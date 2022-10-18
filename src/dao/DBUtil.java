package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {

	public static void main(String[] args) {
		DBUtil dbUtil = new DBUtil();
		dbUtil.getConnection();
	}
	
	private String dirver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/library_system?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
	private String user = "root";
	private String password = "ldd123789dd";

	
	/*
	 * �������ݿ�
	 */
	public Connection getConnection() {
		Connection conn = null;
		if (conn == null) {
			try {
				Class.forName(dirver);
				conn = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				System.err.println(e);
				System.out.println("���ݿ���������ʧ�ܣ�");
			} catch (SQLException e) {
				System.out.println("���ݿ�����ʧ�ܣ�");
			}
		}
		return conn;
	}
	
	/*
	 * �ر����ݿ�����
	 */
	public void closeAll(Connection conn, Statement stmt, ResultSet res) {
		if (res != null) {
			try {
				res.close();
			} catch (SQLException e) {
				System.out.println("ResultSet����رճ���");
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Statement����رճ���");
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Connection����رճ���");
			}
		}
	}
	
	/*
	 * ����ɾ���ĵĲ���
	 */
	public int executeUpdate(String preparedSql, Object[] param) {
		int num = 0;
		PreparedStatement pstmt = null;
		Connection conn = getConnection();
		try {
			pstmt = conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]);
				}
			}
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return num;
	}
	
	/*
	 * ��Ĳ���
	 */
	public ResultSet executeQuery(String sql, Object[] param) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet res = null;
		try {
			pstmt = conn.prepareStatement(sql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]);
				}
			}
			res = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return res;
	}
	
	/*
	 * ��ȡbook���е�����
	 */
	public List<String> getBookColumns() {
		List<String> list = new ArrayList<String>();
		String sql = "SELECT * FROM book";
		Object[] param = null;
		ResultSet res = executeQuery(sql, param);
		ResultSetMetaData rsmd = null;
		int columnCount = 0;
		try {
			rsmd = res.getMetaData();						// ��ȡres�е���
			columnCount = rsmd.getColumnCount();			// ��ȡ�е�����
			for (int i = 1; i <= columnCount; i++) {
				list.add(rsmd.getColumnLabel(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/*
	 * ��ȡrecord���е�����
	 */
	public List<String> getRecordColumns() {
		List<String> list = new ArrayList<String>();
		String sql = "SELECT * FROM record";
		Object[] param = null;
		ResultSet res = executeQuery(sql, param);
		ResultSetMetaData rsmd = null;
		int columnCount = 0;
		try {
			rsmd = res.getMetaData();						// ��ȡres�е���
			columnCount = rsmd.getColumnCount();			// ��ȡ�е�����
			for (int i = 1; i <= columnCount; i++) {
				list.add(rsmd.getColumnLabel(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/*
	 * ��ȡstudent���е�����
	 */
	public List<String> getStudentColumns() {
		List<String> list = new ArrayList<String>();
		String sql = "SELECT * FROM student";
		Object[] param = null;
		ResultSet res = executeQuery(sql, param);
		ResultSetMetaData rsmd = null;
		int columnCount = 0;
		try {
			rsmd = res.getMetaData();							// ��ȡres�е���
			columnCount = rsmd.getColumnCount();				// ��ȡ�е�����
			for (int i = 1; i <= columnCount; i++) {
				list.add(rsmd.getColumnLabel(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/*
	 * ��ȡbookType���е�����
	 */
	public List<String> getBookTypeColumns() {
		List<String> list = new ArrayList<String>();
		String sql = "SELECT * FROM book_type";
		Object[] param = null;
		ResultSet res = executeQuery(sql, param);
		ResultSetMetaData rsmd = null;
		int columnCount = 0;
		try {
			rsmd = res.getMetaData();						// ��ȡres�е���
			columnCount = rsmd.getColumnCount();			// ��ȡ�е�����
			for (int i = 1; i <= columnCount; i++) {
				list.add(rsmd.getColumnLabel(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/*
	 * ��ȡlog�������
	 */
	public List<String> getLogColumns() {
		List<String> list = new ArrayList<String>();
		String sql = "SELECT * FROM log";
		Object[] param = null;
		ResultSet res = executeQuery(sql, param);
		ResultSetMetaData rsmd = null;
		int columnCount = 0;
		try {
			rsmd = res.getMetaData();						// ��ȡres�е���
			columnCount = rsmd.getColumnCount();			// ��ȡ�е�����
			for (int i = 1; i <= columnCount; i++) {
				list.add(rsmd.getColumnLabel(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
