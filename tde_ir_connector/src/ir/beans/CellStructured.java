package ir.beans;

import java.io.Serializable;

import tde.beans.Cell;

public class CellStructured implements Serializable {

	private static final long serialVersionUID = 1L;

	private String content;

	private int rowIndex;

	private int columnIndex;

	private String href;

	private String dataType;

	private Boolean isLabelCell;

	private String source;

	public CellStructured() {
		// TODO Auto-generated constructor stub
	}

	public CellStructured(Cell cell) {
		// TODO Auto-generated constructor stub
	}

	public CellStructured(String content, int rowIndex, int columnIndex,
			String href, String dataType, Boolean isLabelCell, String source) {
		this.content = content;
		this.rowIndex = rowIndex;
		this.columnIndex = columnIndex;
		this.href = href;
		this.dataType = dataType;
		this.isLabelCell = isLabelCell;
		this.source = source;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}

	public int getColumnIndex() {
		return columnIndex;
	}

	public void setColumnIndex(int columnIndex) {
		this.columnIndex = columnIndex;
	}

	public Boolean getIsLabelCell() {
		return isLabelCell;
	}

	public void setIsLabelCell(Boolean isLabelCell) {
		this.isLabelCell = isLabelCell;
	}

	public String getDataTypeCellContent(String content) {
		String dataType = null;

		return dataType;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}