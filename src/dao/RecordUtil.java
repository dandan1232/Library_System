package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DBUtil;
import entity.Book;
import entity.Record;

public class RecordUtil {
	
	dao.DBUtil DBUtil = new DBUtil();
	
	
	/*
	 * 在record表中添加一条信息的方法
	 */
	public int addRecord(Record record) {
		String sql = "INSERT INTO  record VALUE(?, ?, ?, ?, '未还')";
		Object[] param = { record.getStudentId(), record.getBookId(), record.getBorrowDate(), record.getReturnDate() };
		int num = DBUtil.executeUpdate(sql, param);
		return num;
	}
	
	/*
	 * 在record表中插入归还日期的方法
	 */
	public int addReturnDate(Record record) {
		String sql = "UPDATE record SET return_date = ? WHERE student_id = ? AND book_id = ?";
		Object[] param = { record.getReturnDate(), record.getStudentId(), record.getBookId() };
		int num = DBUtil.executeUpdate(sql, param);
		return num;
	}

	/*
	 * 在record表中插入状态信息
	 */
	public int addStatus(Record record) {
		String sql = "UPDATE record SET status = '已还' WHERE student_id = ? AND book_id = ?";
		Object[] param = { record.getStudentId(), record.getBookId() };
		int num = DBUtil.executeUpdate(sql, param);
		return num;
	}
	
	/*
	 * 搜索出record表中的全部信息
	 */
	public List<Record> selectAllRecord() {
		List<Record> list = new ArrayList<Record>();
		String sql = "SELECT * FROM record";
		Object[] param = null;
		ResultSet res = DBUtil.executeQuery(sql, param);
		try {
			while (res.next()) {
				Record record = new Record();
				record.setStudentId(res.getString(1));
				record.setBookId(res.getString(2));
				record.setBorrowDate(res.getString(3));
				record.setReturnDate(res.getString(4));
				record.setStatus(res.getString(5));
				list.add(record);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/*
	 * 学生：
	 * 判断此图书自己是否应该归还
	 * 直接查询record表中某本书的status值
	 */
	public boolean getStatus(Record record) {
		String sql = "SELECT status FROM record WHERE student_id = ? AND book_id = ?";
		Object[] param = { record.getStudentId(), record.getBookId() };
		ResultSet res = DBUtil.executeQuery(sql, param);
		int i = 0;
		try {
			while (res.next()) {
				if (res.getString(1).equals("未还")) {
					i++;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i != 0) {
			return true;
		}
		return false;
	}
	
	/*
	 * 管理员：
	 * 删除书籍是应该先判断该书籍是否还有未还现象
	 * 查看record表中某指定书籍是否还有未还现象
	 */
	public boolean isDeleteBook(Book book) {
		String sql = "SELECT status FROM record WHERE book_id = ?";
		Object[] param = { book.getId() };
		ResultSet res = DBUtil.executeQuery(sql, param);
		try {
			while (res.next()) {
				if (res.getString(1).equals("未还")) {
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
}
