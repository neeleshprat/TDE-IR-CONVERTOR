package tde.beans;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;

public class Table implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String TAG_TABLE = "table";
	public static final String TAG_TR = "tr";
	public static final String TAG_TH = "th";
	public static final String TAG_TD = "td";
	public static final String ATTRIBUTE_COLSPAN = "colspan";
	public static final String ATTRIBUTE_ROWSPAN = "rowspan";

	private Data data;
	private String name;
	private HashMap<String, Result> results;
	private Result result;
	private OriginalDescription originalDescription;
	private OriginalDescriptionTable originalDescriptionTable;

	public Table() {

		data = new Data();
		results = new HashMap<String, Result>();
		result = new Result();
		originalDescription = new OriginalDescription();
		setOriginalDescriptionTable(new OriginalDescriptionTable());
	}

	private void writeFile(String path, String content) throws IOException {

		FileUtils.writeStringToFile(new File(path), content);
	}

	private String readFile(String path) throws IOException {

		String result = "";

		result = FileUtils.readFileToString(new File(path));

		return result;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public HashMap<Integer, Row> getRows() {
		return data.getRows();
	}

	public void setRows(HashMap<Integer, Row> rows) {
		data.setRows(rows);
	}

	public HashMap<Integer, Column> getColumns() {
		return data.getColumns();
	}

	public void setColumns(HashMap<Integer, Column> columns) {
		data.setColumns(columns);
	}

	public HashMap<String, Result> getResults() {
		return results;
	}

	public void setResults(HashMap<String, Result> results) {
		this.results = results;
	}

	public Result getExpectedResult() {
		return result;
	}

	public void setExpectedResult(Result expectedResult) {
		this.result = expectedResult;
	}

	public OriginalDescription getOriginalDescription() {
		return originalDescription;
	}

	public void setOriginalDescription(OriginalDescription originalDescription) {
		this.originalDescription = originalDescription;
	}

	public String getId() {
		return name;
	}

	public void setId(String tableId) {
		this.name = tableId;
	}

	public OriginalDescriptionTable getOriginalDescriptionTable() {
		return originalDescriptionTable;
	}

	public void setOriginalDescriptionTable(
			OriginalDescriptionTable originalDescriptionTable) {
		this.originalDescriptionTable = originalDescriptionTable;
	}

	/*
	 * 
	 * public Table(String inputContentString, String tableId) {
	 * 
	 * this();
	 * 
	 * this.tableId = tableId;
	 * 
	 * loadData(inputContentString); loadExpectedResult(); }
	 * 
	 * private void loadData(String inputContentString) {
	 * 
	 * data = new Data(inputContentString); }
	 * 
	 * private void loadExpectedResult() {
	 * 
	 * Gson gson; Configuration configuration; String path; String
	 * expectedResultString;
	 * 
	 * expectedResultString = null; path = ""; gson = new Gson(); configuration
	 * = Configuration.getInstance();
	 * 
	 * try {
	 * 
	 * path = configuration.getExpectedResultsPath() +
	 * configuration.getSeparator() + tableId +
	 * configuration.getGlobal().getResultFileExtension();
	 * 
	 * expectedResultString = readFile(path);
	 * 
	 * expectedResult = gson.fromJson(expectedResultString, Result.class);
	 * 
	 * } catch (IOException e) {
	 * 
	 * // This can happen if we do not have an expected result
	 * 
	 * expectedResult = null; } }
	 * 
	 * public void save() {
	 * 
	 * saveExpectedResult(); saveResult(); }
	 * 
	 * private void saveExpectedResult() {
	 * 
	 * if (expectedResult != null) {
	 * 
	 * String expectedResultString; Gson gson; Configuration configuration;
	 * 
	 * gson = new Gson(); configuration = Configuration.getInstance();
	 * expectedResultString = gson.toJson(expectedResult);
	 * 
	 * try { writeFile(configuration.getExpectedResultsPath() +
	 * configuration.getSeparator() + tableId +
	 * configuration.getGlobal().getResultFileExtension(),
	 * expectedResultString);
	 * 
	 * } catch (IOException e) { throw new RuntimeException(e); } } }
	 * 
	 * private void saveResult() {
	 * 
	 * ExportedResult exportedResult; Result result; Gson gson; String
	 * exportedResultString; Configuration configuration;
	 * 
	 * // Change in final version to use best result result = expectedResult;
	 * 
	 * if (result != null) { exportedResult = new ExportedResult(tableId, data,
	 * result, originalDescription); gson = new Gson(); exportedResultString =
	 * gson.toJson(exportedResult); configuration = Configuration.getInstance();
	 * 
	 * try { writeFile( configuration.getResultsPath() +
	 * configuration.getSeparator() + tableId + configuration.getGlobal()
	 * .getResultFileExtension(), exportedResultString);
	 * 
	 * } catch (IOException e) { throw new RuntimeException(e); } } }
	 */
}