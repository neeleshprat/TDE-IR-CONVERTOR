package tde.beans;

import java.io.Serializable;
import java.util.ArrayList;

//import org.jsoup.nodes.Element;

public class Row implements TablePart, Serializable {

	private static final long serialVersionUID = 1L;

	private ArrayList<Cell> cells;

//	private transient Element rowHtml;

	public Row() {

		cells = new ArrayList<Cell>();
	}

//	public Row(Element soupRow) {
//
//		cells = new ArrayList<Cell>();
//		this.rowHtml = soupRow;
//	}


	public ArrayList<Cell> getCells() {
		return cells;
	}


	public void setCells(ArrayList<Cell> cells) {
		this.cells = cells;
	}

//	public Element getHtml() {
//		return rowHtml;
//	}

//	public void setHtml(Element rowHtml) {
//		this.rowHtml = rowHtml;
//	}
}