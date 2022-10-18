package Table;

import dao.DBUtil;

import javax.swing.table.DefaultTableModel;

public class BookTable extends DefaultTableModel {

    Class<?>[] type = new Class<?>[]{String.class, String.class, Integer.class, Integer.class};

    boolean[] canEdit = new boolean[]{false, true, true, true}; //true����Ϊ�����ڱ��и���

    public BookTable() {
        super(new Object[][]{}, new DBUtil().getBookColumns().toArray());
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
