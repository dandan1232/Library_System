package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entity.BookType;

public class BookTypeUtil {

	Connection conn = null;
	dao.DBUtil DBUtil = new DBUtil();

	/*
	 * �ó��鼮���ͱ���id��һ�е�����
	 */
	public List<String> getBookTypeId() {
		String sql = "SELECT id FROM book_type";
		conn = DBUtil.getConnection();
		List<String> list = new ArrayList<String>();
		ResultSet res;
		Statement stmt;
		try {
			stmt = conn.createStatement();
			res = stmt.executeQuery(sql);
			while (res.next()) {
				String str = res.getString("id");
				list.add(str);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/*
	 * �ó��鼮���ͱ�name��һ�е�����
	 */
	public List<String> getBookType() {
		String sql = "SELECT * FROM book_type";
		conn = DBUtil.getConnection();
		List<String> list = new ArrayList<String>();
		ResultSet res;
		try {
			Statement stmt = conn.createStatement();
			res = stmt.executeQuery(sql);
			while (res.next()) {
				String str = res.getString(2);
				list.add(str);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/*
	 * ��ѯ����ͼ����Ϣ
	 */
	public List<BookType> selectAllBookType() {
		List<BookType> list = new ArrayList<BookType>();
		String sql = "SELECT * FROM book_type";
		conn = DBUtil.getConnection();
		Statement stmt;
		ResultSet res;
		try {
			stmt = conn.createStatement();
			res = stmt.executeQuery(sql);
			while (res.next()) {
				BookType booktype = new BookType();
				booktype.setId(res.getString(1));
				booktype.setName(res.getString(2));
				list.add(booktype);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
