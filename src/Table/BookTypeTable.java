package Table;

import dao.DBUtil;

import javax.swing.table.DefaultTableModel;

public class BookTypeTable extends DefaultTableModel {
	
	Class<?>[] type = new Class<?>[] { String.class, String.class};
	
	boolean[] canEdit = new boolean[] { false, false };
	
	public BookTypeTable() {
		super(new Object[][] {}, new DBUtil().getBookTypeColumns().toArray());
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex){
		return type[columnIndex];
	}
	
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return canEdit[columnIndex];
	}
}
