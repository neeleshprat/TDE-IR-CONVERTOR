package ir.beans.old;

import java.io.Serializable;

import tde.beans.Cell;

public class CellStructured_old extends Cell implements Serializable {

	private static final long serialVersionUID = 1L;

	// private ArrayList<String> columnLabels;
	// private ArrayList<String> rowLabels;
	private String href;

	private Boolean isLabelCell;

	private String dataType;

	public CellStructured_old() {
		// TODO Auto-generated constructor stub
	}

	public CellStructured_old(Cell cell) {
		// TODO Auto-generated constructor stub
	}

	// public ArrayList<String> getColumnLabels() {
	// return columnLabels;
	// }
	//
	// public void setColumnLabels(ArrayList<String> columnLabels) {
	// this.columnLabels = columnLabels;
	// }
	//
	// public ArrayList<String> getRowLabels() {
	// return rowLabels;
	// }
	//
	// public void setRowLabels(ArrayList<String> rowLabels) {
	// this.rowLabels = rowLabels;
	// }

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Boolean getIsLabelCell() {
		return isLabelCell;
	}

	public void setIsLabelCell(Boolean isLabelCell) {
		this.isLabelCell = isLabelCell;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

}