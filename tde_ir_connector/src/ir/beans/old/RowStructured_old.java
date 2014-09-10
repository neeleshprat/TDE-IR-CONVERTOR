package ir.beans.old;

import java.io.Serializable;
import java.util.ArrayList;

import tde.beans.Cell;
import tde.beans.Row;

public class RowStructured_old implements Serializable {

	private static final long serialVersionUID = 1L;

	private final ArrayList<CellStructured_old> cellsStructured;

	public RowStructured_old() {
		cellsStructured = new ArrayList<CellStructured_old>();
	}

	public RowStructured_old(Row row) {

		cellsStructured = new ArrayList<CellStructured_old>();
		for (Cell cell : row.getCells()) {
			CellStructured_old cellStructured = new CellStructured_old(cell);
			cellsStructured.add(cellStructured);
		}

	}

	public ArrayList<CellStructured_old> getCellsStructured() {
		return cellsStructured;
	}

	public void addCellsStructured(CellStructured_old cellStructured) {
		this.cellsStructured.add(cellStructured);
	}

}