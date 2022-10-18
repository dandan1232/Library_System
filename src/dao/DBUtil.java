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
	 * 连接数据库
	 */
	public Connection getConnection() {
		Connection conn = null;
		if (conn == null) {
			try {
				Class.forName(dirver);
				conn = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				System.err.println(e);
				System.out.println("数据库驱动加载失败！");
			} catch (SQLException e) {
				System.out.println("数据库连接失败！");
			}
		}
		return conn;
	}
	
	/*
	 * 关闭数据库连接
	 */
	public void closeAll(Connection conn, Statement stmt, ResultSet res) {
		if (res != null) {
			try {
				res.close();
			} catch (SQLException e) {
				System.out.println("ResultSet对象关闭出错！");
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Statement对象关闭出错！");
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Connection对象关闭出错！");
			}
		}
	}
	
	/*
	 * 增、删、改的操作
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
	 * 查的操作
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
	 * 获取book表中的列名
	 */
	public List<String> getBookColumns() {
		List<String> list = new ArrayList<String>();
		String sql = "SELECT * FROM book";
		Object[] param = null;
		ResultSet res = executeQuery(sql, param);
		ResultSetMetaData rsmd = null;
		int columnCount = 0;
		try {
			rsmd = res.getMetaData();						// 获取res中的列
			columnCount = rsmd.getColumnCount();			// 获取列的数量
			for (int i = 1; i <= columnCount; i++) {
				list.add(rsmd.getColumnLabel(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/*
	 * 获取record表中的列名
	 */
	public List<String> getRecordColumns() {
		List<String> list = new ArrayList<String>();
		String sql = "SELECT * FROM record";
		Object[] param = null;
		ResultSet res = executeQuery(sql, param);
		ResultSetMetaData rsmd = null;
		int columnCount = 0;
		try {
			rsmd = res.getMetaData();						// 获取res中的列
			columnCount = rsmd.getColumnCount();			// 获取列的数量
			for (int i = 1; i <= columnCount; i++) {
				list.add(rsmd.getColumnLabel(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/*
	 * 获取student表中的列名
	 */
	public List<String> getStudentColumns() {
		List<String> list = new ArrayList<String>();
		String sql = "SELECT * FROM student";
		Object[] param = null;
		ResultSet res = executeQuery(sql, param);
		ResultSetMetaData rsmd = null;
		int columnCount = 0;
		try {
			rsmd = res.getMetaData();							// 获取res中的列
			columnCount = rsmd.getColumnCount();				// 获取列的数量
			for (int i = 1; i <= columnCount; i++) {
				list.add(rsmd.getColumnLabel(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/*
	 * 获取bookType表中的列名
	 */
	public List<String> getBookTypeColumns() {
		List<String> list = new ArrayList<String>();
		String sql = "SELECT * FROM book_type";
		Object[] param = null;
		ResultSet res = executeQuery(sql, param);
		ResultSetMetaData rsmd = null;
		int columnCount = 0;
		try {
			rsmd = res.getMetaData();						// 获取res中的列
			columnCount = rsmd.getColumnCount();			// 获取列的数量
			for (int i = 1; i <= columnCount; i++) {
				list.add(rsmd.getColumnLabel(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/*
	 * 获取log表的列名
	 */
	public List<String> getLogColumns() {
		List<String> list = new ArrayList<String>();
		String sql = "SELECT * FROM log";
		Object[] param = null;
		ResultSet res = executeQuery(sql, param);
		ResultSetMetaData rsmd = null;
		int columnCount = 0;
		try {
			rsmd = res.getMetaData();						// 获取res中的列
			columnCount = rsmd.getColumnCount();			// 获取列的数量
			for (int i = 1; i <= columnCount; i++) {
				list.add(rsmd.getColumnLabel(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
