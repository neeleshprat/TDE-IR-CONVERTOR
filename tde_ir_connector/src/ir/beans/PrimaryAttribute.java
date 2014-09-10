package ir.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class PrimaryAttribute implements Serializable {

	private static final long serialVersionUID = 1L;

	private ArrayList<CellStructured> primaryAttrCell;

	private ArrayList<AttributeValue> attrValues;

	// private ArrayList<CellStructured> secondaryAttrCell;
	//
	// private ArrayList<CellStructured> valueCell;

	public PrimaryAttribute() {
		//
		this.primaryAttrCell = new ArrayList<CellStructured>();
		this.attrValues = new ArrayList<AttributeValue>();
		// this.secondaryAttrCell = new ArrayList<CellStructured>();
		// this.valueCell = new ArrayList<CellStructured>();
	}

	public ArrayList<CellStructured> getCellStructured() {
		return primaryAttrCell;
	}

	public void addCellStructured(CellStructured cellStructured) {
		this.primaryAttrCell.add(cellStructured);
	}

	// public ArrayList<CellStructured> getSecondaryAttrCell() {
	// return secondaryAttrCell;
	// }
	//
	// public void setSecondaryAttrCell(ArrayList<CellStructured>
	// secondaryAttrCell) {
	// this.secondaryAttrCell = secondaryAttrCell;
	// }
	//
	// public ArrayList<CellStructured> getValueCell() {
	// return valueCell;
	// }
	//
	// public void setValueCell(ArrayList<CellStructured> valueCell) {
	// this.valueCell = valueCell;
	// }

	public ArrayList<AttributeValue> getAttrValues() {
		return attrValues;
	}

	public void setAttrValues(ArrayList<AttributeValue> attrValues) {
		this.attrValues = attrValues;
	}

}