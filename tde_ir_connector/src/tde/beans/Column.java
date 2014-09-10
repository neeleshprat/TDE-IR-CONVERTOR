package tde.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class Column implements TablePart, Serializable {

	private static final long serialVersionUID = 1L;

	private ArrayList<Cell> cells;

	public Column() {

		cells = new ArrayList<Cell>();
	}


	public ArrayList<Cell> getCells() {
		return cells;
	}


	public void setCells(ArrayList<Cell> cells) {
		this.cells = cells;
	}
}