package ir.beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import main.java.Configuration;
import tde.beans.Cell;
import tde.beans.Row;
import tde.beans.Table;

import com.google.gson.Gson;

import dataTypeDetector.BooleanParser;
import dataTypeDetector.DateTimeParser;
import dataTypeDetector.NumericParser;
import de.mannheim.uni.types.ColumnTypeGuesser;

public class TableStructured implements Serializable {

	private static final long serialVersionUID = 1L;

	private String tableId;

	private String fileName;

	private int start;
	private int end;

	private ArrayList<PrimaryAttribute> primaryAttributesList = new ArrayList<PrimaryAttribute>();

	private transient boolean toBeSaved = false;

	public TableStructured() {
		// do nothing
	}

	public void transform(Table table) {
		try {

			this.tableId = table.getId();

			this.fileName = table.getOriginalDescription().getFilename();

			this.start = table.getOriginalDescriptionTable().getStart();
			this.end = table.getOriginalDescriptionTable().getEnd();

			// only tables for which both the row and column labels exist (or
			// have been identified)
			// are considered
			if (checkIfHasLabels(table.getExpectedResult().getRows())
					&& checkIfHasLabels(table.getExpectedResult().getColumns())) {

				this.toBeSaved = true;

				ArrayList<Integer> labelRows = new ArrayList<Integer>();

				int indexLabelColumn = 0;
				int indexLabelRow = 0;

				// get the index and number of rows that are label
				for (Entry<Integer, Boolean> entry : table.getExpectedResult()
						.getRows().entrySet()) {
					labelRows.add(entry.getKey());
					indexLabelRow = entry.getKey();

				}

				// get the index of the column that is label
				for (Entry<Integer, Boolean> e : table.getExpectedResult()
						.getColumns().entrySet()) {
					if (e.getValue()) {
						indexLabelColumn = e.getKey();
						break;
					}

				}

				// create as many objects as the number of the label columns
				for (int i = 0; i < table.getData().getRows()
						.get(indexLabelRow).getCells().size(); i++) {

					PrimaryAttribute primaryAttrbute = new PrimaryAttribute();

					primaryAttributesList.add(primaryAttrbute);

				}

				for (Map.Entry<Integer, Row> entry : table.getData().getRows()
						.entrySet()) {

					ColumnTypeGuesser g = new ColumnTypeGuesser();

					Row row = entry.getValue();
					int rowIndex = entry.getKey();

					int cellIndex = 0;
					boolean isRowLabel = false;

					if (labelRows.contains(rowIndex))
						isRowLabel = true;

					if (isRowLabel == true) {
						for (Cell cell : row.getCells()) {

							String href = getHrefFromCellContent(cell);
							String dataType = g.guessTypeForValue(
									cell.getContent(), null, false, null)
									.toString();
							CellStructured cellStructuredPA = new CellStructured(
									cell.getContent(), rowIndex, cellIndex,
									href, dataType, true, tableId);
							primaryAttributesList.get(cellIndex)
									.addCellStructured(cellStructuredPA);

							cellIndex++;
						}

					} else {

						for (Cell cell : row.getCells()) {

							if (indexLabelColumn != cellIndex) {

								Cell cellLabel = row.getCells().get(
										indexLabelColumn);
								String href = getHrefFromCellContent(cellLabel);
								String dataType = g.guessTypeForValue(
										cellLabel.getContent(), null, false,
										null).toString();
								CellStructured cellStructuredSA = new CellStructured(
										cellLabel.getContent(), rowIndex,
										cellIndex, href, dataType, true,
										tableId);

								String hrefValue = getHrefFromCellContent(cell);
								String dataTypeValue = g.guessTypeForValue(
										cell.getContent(), null, false, null)
										.toString();
								CellStructured cellStructuredValue = new CellStructured(
										cell.getContent(), rowIndex, cellIndex,
										hrefValue, dataTypeValue, true, tableId);

								AttributeValue attrValue = new AttributeValue(
										cellStructuredSA, cellStructuredValue);

								int len = primaryAttributesList.get(cellIndex)
										.getAttrValues().size();
								primaryAttributesList.get(cellIndex)
										.getAttrValues().add(len, attrValue);
							}

							cellIndex++;
						}

					}

				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private boolean checkIfHasLabels(HashMap<Integer, Boolean> entity) {
		// Check the Row and column labels
		for (Map.Entry<Integer, Boolean> entry : entity.entrySet()) {
			if (entry.getValue() == true) {
				return true;
			}
		}

		return false;

	}

	private HashMap<Integer, ArrayList<String>> createRowHeaderLabels(
			Table table) {

		HashMap<Integer, ArrayList<String>> rowLabelsHashMap = new HashMap<Integer, ArrayList<String>>();

		for (int i = 0; i < table.getData().getColumns().get(0).getCells()
				.size(); i++) {

			rowLabelsHashMap.put(i, new ArrayList<String>());
			for (Map.Entry<Integer, Boolean> entry : table.getExpectedResult()
					.getColumns().entrySet()) {

				if (entry.getValue() == true) {

					if (i < table.getData().getColumns().get(entry.getKey())
							.getCells().size()) {
						String cellContent = table.getData().getColumns()
								.get(entry.getKey()).getCells().get(i)
								.getContent();
						rowLabelsHashMap.get(i).add(cellContent);
					}

				}
			}

		}

		return rowLabelsHashMap;

	}

	private HashMap<Integer, ArrayList<String>> createColumnHeaderLabels(
			Table table) {

		HashMap<Integer, ArrayList<String>> columnLabelsHashMap = new HashMap<Integer, ArrayList<String>>();

		for (int i = 0; i < table.getData().getRows().get(0).getCells().size(); i++) {

			columnLabelsHashMap.put(i, new ArrayList<String>());
			for (Map.Entry<Integer, Boolean> entry : table.getExpectedResult()
					.getRows().entrySet()) {

				if (entry.getValue() == true) {

					if (i < table.getData().getRows().get(entry.getKey())
							.getCells().size()) {
						String cellContent = table.getData().getRows()
								.get(entry.getKey()).getCells().get(i)
								.getContent();
						columnLabelsHashMap.get(i).add(cellContent);
					}

				}
			}

		}

		return columnLabelsHashMap;

	}

	private String determineDataType(String content) {

		if (BooleanParser.parseBoolean(content))
			return "boolean";
		if (DateTimeParser.parseDate(content))
			return "datetime";
		if (NumericParser.parseNumeric(content))
			return "numeric";

		return "string";
	}

	public String getHrefFromCellContent(Cell cell) {

		String href = null;

		// org.jsoup.nodes.Element attr =
		// cell.getCellHtml().select("a").first(); //
		// // set the href link if available
		// if (attr != null)
		// if (attr.hasAttr(Configuration.ATTR_HREF))
		// href = attr.attr(Configuration.ATTR_HREF);

		return href;
	}

	public void save() {

		// only save if the table has row and column labels
		if (this.toBeSaved == true) {
			Gson gson;
			String exportedResultString;
			Configuration configuration;

			gson = new Gson();
			exportedResultString = gson.toJson(this);
			configuration = Configuration.getInstance();

			try {
				writeFile(configuration.getTableStructuredNewFolderPath()
						+ tableId + Configuration.RESULT_FILE_EXTENSION,
						exportedResultString);

			} catch (IOException e) {
				// This should not happen, as we already test for null values
				e.printStackTrace();
			}
		}

	}

	private void writeFile(String path, String content) throws IOException {

		// FileUtils.writeStringToFile(new File(path), content);
		// FileUtils.writeStringToFile(new File(path), content,
		// StandardCharsets.UTF_8);

		File file = new File(path);
		FileOutputStream fop = new FileOutputStream(file);

		// if file doesn't exist, then create it
		if (!file.exists()) {
			file.createNewFile();
		}

		// get the content in bytes
		byte[] contentInBytes = content.getBytes();

		fop.write(contentInBytes);
		fop.flush();
		fop.close();
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	/*
	 * public ArrayList<RowStructured> getRowsStructured() { return
	 * rowsStructured; }
	 * 
	 * public void setRowsStructured(ArrayList<RowStructured> sRows) {
	 * this.rowsStructured = sRows; }
	 */

}