package main.java;

import java.io.File;
import java.io.Serializable;

public enum Configuration implements Serializable {

	// Singleton

	INSTANCE;

	public static Configuration getInstance() {
		return INSTANCE;
	}

	// Class variables

	private static final String DESCRIPTION_FOLDER_NAME = "descriptions";
	private static final String EXPECTED_RESULT_FOLDER_NAME = "expectedResults";
	private static final String HTML_FILES_FOLDER_NAME = "files";
	private static final String RESULTS_FOLDER_NAME = "results";
	private static final String TABLE_STRUCTURED_OLD_FOLDER_NAME = "tableStructured_old";
	private static final String TABLE_STRUCTURED_NEW_FOLDER_NAME = "tableStructured_new";

	public static final String RESULT_FILE_EXTENSION = ".json";

	public final static String TAG_TABLE_DATA_CELL = "td";
	public final static String TAG_TABLE_HEADER = "th";
	public final static String TAG_TABLE_COLSPAN = "colspan";
	public final static String TAG_TABLE_ROWSPAN = "rowspan";
	public final static String TAG_TABLE_ROW = "tr";
	public final static String ATTR_HREF = "href";

	// Methods

	public File getInputFolder() {
		return new File(SystemSpecificSettings.INPUT_BASE_PATH);
	}

	public File getDescriptionFolder() {
		return new File(SystemSpecificSettings.INPUT_BASE_PATH
				+ DESCRIPTION_FOLDER_NAME);
	}

	public File getExpectedResultFolder() {
		return new File(SystemSpecificSettings.INPUT_BASE_PATH
				+ EXPECTED_RESULT_FOLDER_NAME);
	}

	public File getHtmlFilesFolder() {
		return new File(SystemSpecificSettings.INPUT_BASE_PATH
				+ HTML_FILES_FOLDER_NAME);
	}

	public File getOutputFolder() {
		return new File(SystemSpecificSettings.OUTPUT_BASE_PATH);
	}

	public File getResultsFolder() {
		return new File(SystemSpecificSettings.INPUT_BASE_PATH
				+ RESULTS_FOLDER_NAME);
	}

	public String getInputPath() {
		return SystemSpecificSettings.INPUT_BASE_PATH;
	}

	public String getDescriptionPatj() {
		return SystemSpecificSettings.INPUT_BASE_PATH + DESCRIPTION_FOLDER_NAME
				+ SystemSpecificSettings.SEPARATOR;
	}

	public String getExpectedResultsPath() {
		return SystemSpecificSettings.INPUT_BASE_PATH
				+ EXPECTED_RESULT_FOLDER_NAME
				+ SystemSpecificSettings.SEPARATOR;
	}

	public String getHtmlFilesPath() {
		return SystemSpecificSettings.INPUT_BASE_PATH + HTML_FILES_FOLDER_NAME
				+ SystemSpecificSettings.SEPARATOR;
	}

	public String getOutputPath() {
		return SystemSpecificSettings.OUTPUT_BASE_PATH;
	}

	public String getResultsPath() {
		return SystemSpecificSettings.OUTPUT_BASE_PATH + RESULTS_FOLDER_NAME
				+ SystemSpecificSettings.SEPARATOR;
	}

	public static String getTableStructuredOldFolderPath() {
		return SystemSpecificSettings.OUTPUT_BASE_PATH
				+ TABLE_STRUCTURED_OLD_FOLDER_NAME
				+ SystemSpecificSettings.SEPARATOR;
	}

	public static String getTableStructuredNewFolderPath() {
		return SystemSpecificSettings.OUTPUT_BASE_PATH
				+ TABLE_STRUCTURED_NEW_FOLDER_NAME
				+ SystemSpecificSettings.SEPARATOR;
	}

}