package Table;

import dao.DBUtil;

import javax.swing.table.DefaultTableModel;

public class StudentTable extends DefaultTableModel {

	
	Class<?>[] type = new Class<?>[] { String.class, String.class, String.class };

	boolean[] canEdit = new boolean[] { false, true, false };
	
	public StudentTable() {
		super(new Object[][] {}, new DBUtil().getStudentColumns().toArray());
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
