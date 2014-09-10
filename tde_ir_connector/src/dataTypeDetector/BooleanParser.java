package dataTypeDetector;

public class BooleanParser {

	public static final String booleanRegex = "(yes|true|no|false)";

	public static boolean parseBoolean(String text) {

		if (text.toLowerCase().matches(booleanRegex)) {
			return true;
		}
		return false;
	}

}
