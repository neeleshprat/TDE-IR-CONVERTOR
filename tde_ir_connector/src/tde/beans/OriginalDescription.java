package tde.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class OriginalDescription implements Serializable {

	private static final long serialVersionUID = 1L;

	private String filename;
	private boolean hasContentTables;
	private boolean hasRelevantTables;
	private ArrayList<OriginalDescriptionTable> contentTables;

	public OriginalDescription() {
		// nothing
	}

	public boolean isHasContentTables() {
		return hasContentTables;
	}

	public void setHasContentTables(boolean hasContentTables) {
		this.hasContentTables = hasContentTables;
	}

	public boolean isHasRelevantTables() {
		return hasRelevantTables;
	}

	public void setHasRelevantTables(boolean hasRelevantTables) {
		this.hasRelevantTables = hasRelevantTables;
	}

	public ArrayList<OriginalDescriptionTable> getContentTables() {
		return contentTables;
	}

	public void setContentTables(
			ArrayList<OriginalDescriptionTable> contentTables) {
		this.contentTables = contentTables;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
}