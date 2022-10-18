package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.DBUtil;
import entity.Student;

public class StudentUtil {

	Connection conn = null;
	dao.DBUtil DBUtil = new DBUtil();
	
	/*
	 * 获取学生表的所有信息除去密码列的值
	 */
	public List<Student> selectStudent() {
		String sql = "SELECT * FROM student";
		conn = DBUtil.getConnection();
		List<Student> list = new ArrayList<Student>();
		ResultSet res;
		try {
			Statement stmt = conn.createStatement();
			res = stmt.executeQuery(sql);
			while (res.next()) {
				Student student = new Student();
				student.setId(res.getString(1));
				student.setName(res.getString(2));
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
