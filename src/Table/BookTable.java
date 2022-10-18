package Table;

import dao.DBUtil;

import javax.swing.table.DefaultTableModel;

public class BookTable extends DefaultTableModel {

    Class<?>[] type = new Class<?>[]{String.class, String.class, Integer.class, Integer.class};

    boolean[] canEdit = new boolean[]{false, true, true, true}; //true设置为可以在表中更改

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
