package ir.beans;

import java.io.Serializable;
import java.util.ArrayList;

import tde.beans.Cell;
import tde.beans.Row;

public class RowStructured implements Serializable {

	private static final long serialVersionUID = 1L;

	private final ArrayList<CellStructured> cellsStructured;

	public RowStructured() {
		cellsStructured = new ArrayList<CellStructured>();
	}

	public RowStructured(Row row) {

		cellsStructured = new ArrayList<CellStructured>();
		for (Cell cell : row.getCells()) {
			CellStructured cellStructured = new CellStructured(cell);
			cellsStructured.add(cellStructured);
		}

	}

	public ArrayList<CellStructured> getCellsStructured() {
		return cellsStructured;
	}

	public void addCellsStructured(CellStructured cellStructured) {
		this.cellsStructured.add(cellStructured);
	}

}