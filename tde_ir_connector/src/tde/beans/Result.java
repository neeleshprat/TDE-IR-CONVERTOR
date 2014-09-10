package tde.beans;
import java.io.Serializable;
import java.util.HashMap;

public class Result implements Serializable {

	private static final long serialVersionUID = 1L;

	private HashMap<Integer, Boolean> columns;
	private HashMap<Integer, Boolean> rows;

	public Result() {

		columns = new HashMap<Integer, Boolean>();
		rows = new HashMap<Integer, Boolean>();
	}

	public Result(HashMap<Integer, Boolean> rowsResult,
			HashMap<Integer, Boolean> columnsResult) {

		this.rows = rowsResult;
		this.columns = columnsResult;

	}

	public HashMap<Integer, Boolean> getColumns() {
		return columns;
	}

	public void setColumns(HashMap<Integer, Boolean> columns) {
		this.columns = columns;
	}

	public HashMap<Integer, Boolean> getRows() {
		return rows;
	}

	public void setRows(HashMap<Integer, Boolean> rows) {
		this.rows = rows;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((columns == null) ? 0 : columns.hashCode());
		result = prime * result + ((rows == null) ? 0 : rows.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		// Identical object reference
		if (this == obj) {
			return true;
		}
		// Object is null
		if (obj == null) {
			return false;
		}
		// Class is not same
		if (getClass() != obj.getClass()) {
			return false;
		}
		// If class is the same, we may cast
		Result other = (Result) obj;

		// If columns are null, for the other columns must be null also
		if (columns == null) {
			if (other.columns != null) {
				return false;
			}
		} else {
			// For each column, if one says true the other must say true also
			for (int i : columns.keySet()) {
				if (columns.get(i) == true) {
					if (!other.getColumns().containsKey(i)
							|| other.getColumns().get(i) == false) {
						return false;
					}
				} else {
					if (other.getColumns().containsKey(i)
							&& other.getColumns().get(i) == true) {
						return false;
					}
				}
			}
			for (int i : other.getColumns().keySet()) {
				if (other.getColumns().get(i) == true) {
					if (!columns.containsKey(i) || columns.get(i) == false) {
						return false;
					}
				} else {
					if (columns.containsKey(i) && columns.get(i) == true) {
						return false;
					}
				}
			}
		}

		// If rows are null, for the other rows must be null also
		if (rows == null) {
			if (other.rows != null)
				return false;
		} else {
			// For each row, if one says true the other must say true also
			for (int i : rows.keySet()) {
				if (rows.get(i) == true) {
					if (!other.getRows().containsKey(i)
							|| other.getRows().get(i) != true) {
						return false;
					}
				} else {
					if (other.getRows().containsKey(i)
							&& other.getRows().get(i) == true) {
						return false;
					}
				}
			}
			for (int i : other.getRows().keySet()) {
				if (other.getRows().get(i) == true) {
					if (!rows.containsKey(i) || rows.get(i) != true) {
						return false;
					}
				} else {
					if (rows.containsKey(i) && rows.get(i) == true) {
						return false;
					}
				}
			}
		}
		return true;
	}

}
