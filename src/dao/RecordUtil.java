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
	 * ��record�������һ����Ϣ�ķ���
	 */
	public int addRecord(Record record) {
		String sql = "INSERT INTO  record VALUE(?, ?, ?, ?, 'δ��')";
		Object[] param = { record.getStudentId(), record.getBookId(), record.getBorrowDate(), record.getReturnDate() };
		int num = DBUtil.executeUpdate(sql, param);
		return num;
	}
	
	/*
	 * ��record���в���黹���ڵķ���
	 */
	public int addReturnDate(Record record) {
		String sql = "UPDATE record SET return_date = ? WHERE student_id = ? AND book_id = ?";
		Object[] param = { record.getReturnDate(), record.getStudentId(), record.getBookId() };
		int num = DBUtil.executeUpdate(sql, param);
		return num;
	}

	/*
	 * ��record���в���״̬��Ϣ
	 */
	public int addStatus(Record record) {
		String sql = "UPDATE record SET status = '�ѻ�' WHERE student_id = ? AND book_id = ?";
		Object[] param = { record.getStudentId(), record.getBookId() };
		int num = DBUtil.executeUpdate(sql, param);
		return num;
	}
	
	/*
	 * ������record���е�ȫ����Ϣ
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
	 * ѧ����
	 * �жϴ�ͼ���Լ��Ƿ�Ӧ�ù黹
	 * ֱ�Ӳ�ѯrecord����ĳ�����statusֵ
	 */
	public boolean getStatus(Record record) {
		String sql = "SELECT status FROM record WHERE student_id = ? AND book_id = ?";
		Object[] param = { record.getStudentId(), record.getBookId() };
		ResultSet res = DBUtil.executeQuery(sql, param);
		int i = 0;
		try {
			while (res.next()) {
				if (res.getString(1).equals("δ��")) {
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
	 * ����Ա��
	 * ɾ���鼮��Ӧ�����жϸ��鼮�Ƿ���δ������
	 * �鿴record����ĳָ���鼮�Ƿ���δ������
	 */
	public boolean isDeleteBook(Book book) {
		String sql = "SELECT status FROM record WHERE book_id = ?";
		Object[] param = { book.getId() };
		ResultSet res = DBUtil.executeQuery(sql, param);
		try {
			while (res.next()) {
				if (res.getString(1).equals("δ��")) {
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
}
