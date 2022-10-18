package Table;

import dao.DBUtil;

import javax.swing.table.DefaultTableModel;

public class RecordTable extends DefaultTableModel {
	
	Class<?>[] type = new Class<?>[] { String.class, String.class, String.class, String.class, String.class };
	
	boolean[] canEdit = new boolean[] { false, false, false, false, false };
	
	public RecordTable() {
		super(new Object[][] {}, new DBUtil().getRecordColumns().toArray());
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return type[columnIndex];
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return canEdit[columnIndex];
	}
}
