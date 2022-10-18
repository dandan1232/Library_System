package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entity.Book;
import entity.BookType;
import entity.Record;

public class BookUtil {

	Connection conn = null;
	dao.DBUtil DBUtil = new DBUtil();
	
	/*
	 * �ó�book����ĳ����������ķ���
	 */
	public int getBookNum(Book book) {
		String sql = "SELECT num FROM book WHERE id = ?";
		Object[] param = { book.getId() };
		ResultSet res = DBUtil.executeQuery(sql, param);
		int num = 0;
		try {
			res.next();
			num = res.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	/*
	 * ͨ��������Ͳ�ѯ��Ӧ ����� �Ĵ���
	 */
	public String getIdByBookName(BookType bookType) {
		String sql = "SELECT id FROM book_type WHERE name = ?";
		Object[] param = { bookType.getName() };
		ResultSet res = DBUtil.executeQuery(sql, param);
		String str = null;
		try {
			res.next();
			str = res.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	/*
	 * ��������ͼ����Ϣ
	 */
	public List<Book> selectAllBook() {	
		List<Book> list = new ArrayList<Book>();
		String sql = "SELECT * FROM book";
		conn = DBUtil.getConnection();
		Statement stmt;
		ResultSet res;
		try {
			stmt = conn.createStatement();
			res = stmt.executeQuery(sql);
			while (res.next()) {
				Book book = new Book();
				book.setId(res.getString(1));
				book.setName(res.getString(2));
				book.setNum(res.getInt(3));
				book.setTimes(res.getInt(4));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/*
	 * ͨ��Record������Ҷ�Ӧ������
	 */
	public String getBookNameByRecord(Record record) {
		String sql = "SELECT name FROM book WHERE id =  ?";
		Object[] param = { record.getBookId() };
		ResultSet res = DBUtil.executeQuery(sql, param);
		String bookName = null;
		try {
			res.next();
			bookName = res.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookName;
	}
}
