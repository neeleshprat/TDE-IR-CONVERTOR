package ir.beans;

import java.io.Serializable;

public class AttributeValue implements Serializable {

	private CellStructured cellAttribute;

	private CellStructured cellValue;

	AttributeValue() {

		cellAttribute = new CellStructured();
		cellValue = new CellStructured();
	}

	AttributeValue(CellStructured cellAttribute, CellStructured cellValue) {

		this.cellAttribute = cellAttribute;
		this.cellValue = cellValue;
	}

	public CellStructured getCellAttribute() {
		return cellAttribute;
	}

	public void setCellAttribute(CellStructured cellAttribute) {
		this.cellAttribute = cellAttribute;
	}

	public CellStructured getCellValue() {
		return cellValue;
	}

	public void setCellValue(CellStructured cellValue) {
		this.cellValue = cellValue;
	}

}