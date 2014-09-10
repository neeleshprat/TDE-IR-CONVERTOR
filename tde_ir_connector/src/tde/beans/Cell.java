package tde.beans;

import java.io.Serializable;
import java.util.ArrayList;

//import org.jsoup.nodes.Element;

public class Cell implements Serializable {

	private static final long serialVersionUID = 1L;

	private String content;
	private ArrayList<String> columnLabels;
	private ArrayList<String> rowLabels;

	private transient Boolean chenIsLabelCell;
//	private transient Element cellHtml;

	public Cell() {
		// nothing
	}

	public Cell(String content) {
		this.content = content;
	}

//	public Cell(String content, Element soupCell) {
//		this.content = content;
//		this.cellHtml = soupCell;
//	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ArrayList<String> getColumnLabels() {
		return columnLabels;
	}

	public void setColumnLabels(ArrayList<String> columnLabels) {
		this.columnLabels = columnLabels;
	}

	public ArrayList<String> getRowLabels() {
		return rowLabels;
	}

	public void setRowLabels(ArrayList<String> rowLabels) {
		this.rowLabels = rowLabels;
	}

//	public Element getCellHtml() {
//		return cellHtml;
//	}
//
//	public void setCellHtml(Element cellHtml) {
//		this.cellHtml = cellHtml;
//	}

	public Boolean chenGetIsLabelCell() {
		return chenIsLabelCell;
	}

	public void chenSetIsLabelCell(Boolean isLabelCell) {
		this.chenIsLabelCell = isLabelCell;
	}

}