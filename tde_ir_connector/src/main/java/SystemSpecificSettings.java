package main.java;

public class SystemSpecificSettings {

	/*
	 * This class contains system-specific settings that need to be adapted to
	 * the system the software is running on. This file is excluded from syncing
	 * and will only sync once, so your changes won't be reflected on the GIT
	 * repository.
	 */

	/*
	 * Path to the folder that contains the input data for our algorithm. You
	 * can set this to the "data/input" folder inside your GIT repository.
	 */

	public static final String INPUT_BASE_PATH = "C:/Users/npra/workspace_tde/tde_ir_connector/resources/input/";

	/*
	 * Path to the folder where the results should be saved. You can set this to
	 * the "data/output" folder inside your GIT repository.
	 */

	public static final String OUTPUT_BASE_PATH = "C:/Users/npra/workspace_tde/tde_ir_connector/resources/output/";

	/*
	 * Path-separator for your current system.
	 */
	public static final String SEPARATOR = "/";
}
