package tde.beans;
import java.io.Serializable;

public class OriginalDescriptionTable implements Serializable {

	private static final long serialVersionUID = 1L;

	private int start;
	private int end;
	private boolean content = false;
	private boolean relevant = false;

	public OriginalDescriptionTable() {
		// nothing
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

	public boolean isContent() {
		return content;
	}

	public void setContent(boolean content) {
		this.content = content;
	}

	public boolean isRelevant() {
		return relevant;
	}

	public void setRelevant(boolean relevant) {
		this.relevant = relevant;
	}
}