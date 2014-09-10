package tde.beans;

import java.io.Serializable;
import java.util.HashMap;

//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;

public class Data implements Serializable {

	private static final long serialVersionUID = 1L;

	String name;
	HashMap<Integer, Row> rows;
	HashMap<Integer, Column> columns;

	public Data() {

		rows = new HashMap<Integer, Row>();
		columns = new HashMap<Integer, Column>();
	}

	public Data(String inputContentString) {

		this();

//		parse(inputContentString);
	}

	/*
	private void parse(String inputContentString) {

		Document sDocument;
		Elements sTables; // should never be more than one
		Element sTable;
		Elements sRows;
		int rowNumber;

		sDocument = Jsoup.parse(inputContentString);
		sTables = sDocument.select(Table.TAG_TABLE);
		sTable = sTables.first();
		sRows = sTable.select(Table.TAG_TR);

		// go over all rows
		rowNumber = 0;
		for (Element soupRow : sRows) {

			Row row;

			row = new Row(soupRow);

			handleCells(soupRow, row, rowNumber, Table.TAG_TH);
			handleCells(soupRow, row, rowNumber, Table.TAG_TD);

			rows.put(rowNumber, row);

			rowNumber++;
		}
	}

	private void handleCells(Element soupRow, Row row, int rowNumber, String tag) {

		Elements sCells;
		int columnNumber;

		sCells = soupRow.select(tag);

		// go over all cells, which are columns
		columnNumber = 0;
		for (Element sCell : sCells) {

			int colspan;

			colspan = determineColspan(sCell);

			// go really over all cells after resolution of colspan
			for (int i = 0; i < colspan; i++) {

				Cell cell;
				Column column;

				column = retrieveColumn(columnNumber);
				cell = new Cell(sCell.text(), sCell);

				row.getCells().add(cell);
				column.getCells().add(cell);

				columnNumber++;
			}
		}
	}

	private int determineColspan(Element sCell) {

		int result;

		if (sCell.attr("colspan") != null && !"".equals(sCell.attr("colspan"))) {

			result = Integer.parseInt(sCell.attr("colspan"));

		} else {

			result = 1;
		}

		return result;
	}

	private Column retrieveColumn(int columnNumber) {

		Column result;

		// if we are in the first row, we have to create the columns
		if (!columns.containsKey(columnNumber)) {

			result = new Column();
			columns.put(columnNumber, result);

		} else {

			result = columns.get(columnNumber);
		}

		return result;
	}
	*/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<Integer, Row> getRows() {
		return rows;
	}

	public void setRows(HashMap<Integer, Row> rows) {
		this.rows = rows;
	}

	public HashMap<Integer, Column> getColumns() {
		return columns;
	}

	public void setColumns(HashMap<Integer, Column> columns) {
		this.columns = columns;
	}
}
