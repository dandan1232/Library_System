package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import dao.ManagerDao;
import entity.Book;
import entity.Manager;
import entity.Student;
import dao.DBUtil;
import dao.BookTypeUtil;

public class ManagerImplements extends DBUtil implements ManagerDao {
	
	public static DBUtil DBUtil = new DBUtil();
	
	
/*
 * 管理员对学生的“增删改查”的方法
 */
	@Override
	public boolean canRegister(Student student) {
		String sql = "SELECT id FROM student WHERE id = ?";
		Object[] param = { student.getId() };
		ResultSet res = executeQuery(sql, param);
		try {
			if (res.next()) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	@Override
	public boolean insertStudent(Student student) {
		String sql = "INSERT INTO student VALUE(?, ?, ?)";
		Object[] param = { student.getId(), student.getName(), student.getPassword() };
		if (DBUtil.executeUpdate(sql, param) != 0) {
			return true;
		}
		return false;
	}
	@Override
	public boolean updateStudent(Student student) {
		String sql = "UPDATE student SET name = ? WHERE id = ?";
		Object[] param = { student.getName(), student.getId() };
		if (DBUtil.executeUpdate(sql, param) != 0) {
			return true;
		}
		return false;
	}
	@Override
	public boolean deleteStudent(Student student) {
		String sql = "DELETE FROM student WHERE id = ?";
		Object[] param = { student.getId() };
		if (DBUtil.executeUpdate(sql, param) != 0) {
			return true;
		}
		return false;
	}
	@Override
	public List<Student> selectStudent() {
		String sql = "SELECT * FROM student";
		List<Student> list = new ArrayList<Student>();
		Object[] param = null;
		ResultSet res = DBUtil.executeQuery(sql, param);
		try {
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
// -----------------------------------------------------------------------------------------	
	
	
	
	
	
// 管理员自身的一些行为方法	
	@Override
	public boolean canRegister(Manager manager) {
		String sql = "SELECT id FROM manager WHERE id = ?";
		Object[] param = { manager.getId() };
		ResultSet res = executeQuery(sql, param);
		try {
			if (res.next()) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	@Override
	public boolean loginManager(Manager manager) {
		String sql = "SELECT * FROM manager WHERE id = ? AND password = ?";
		Object[] param = { manager.getId(), manager.getPassword() };
		try {
			if (DBUtil.executeQuery(sql, param).next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean insertManager(Manager manager) {
		String sql = "INSERT INTO manager VALUE(?, ?, ?)";
		Object[] param = { manager.getId(), manager.getName(), manager.getPassword() };
		if (DBUtil.executeUpdate(sql, param) != 0) {
			return true;
		}		
		return false;
	}
	/*
	 * 得到管理员名字的方法
	 */
	@Override
	public String getManagerName(Manager manager) {
		String sql = "SELECT name FROM manager WHERE id = ?";
		Object[] param = { manager.getId() };
		ResultSet res = this.executeQuery(sql, param);
		String name = null;
		try {
			if (res.next()){
				name = res.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}
// -----------------------------------------------------------------------------------------	
	
// 管理员对图书的基本操作方法	
	@Override
	public boolean canAddBook(Book book) {
		String sql = "SELECT id FROM book WHERE id = ?";
		Object[] param = { book.getId() };
		ResultSet res = executeQuery(sql, param);
		try {
			if (res.next()) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	@Override
	public int sava(Book book) {
		String sql = "insert into book value(?, ?, ?, 0)";
		Object[] param = {book.getId(), book.getName(), book.getNum()};
		int num = executeUpdate(sql, param);
		if (num !=0) {
			return 1;
		} else {
			return 0;
		}
	}
	/*swing界面修改后同步更新到数据库*/
	@Override
	public int updateBook(Book book) {
		String sql = "update book set name=?,num = ?, times = ? where id = ?";
		  Object[] param = {book.getName(),book.getNum(), book.getTimes(), book.getId() };
		  int num = executeUpdate(sql, param);
		  if (num != 0) {
			  return 1;
		  } else {
			  return 0;
		  }
	}
	@Override
	public int delBook(Book book) {
		String sql = "delete from book  where id = ?";
		  Object[] param = {book.getId()};
		  int num = executeUpdate(sql, param);
		return num;
	}
	
	
	
	
	
	
	
	@Override
	public Map<String, Integer> statistics() {
		Connection conn = new DBUtil().getConnection();
		PreparedStatement pstmt = null;
		ResultSet res = null;
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		String sql = "SELECT DISTINCT BT.name, SUM(B.times) FROM book B, book_type BT WHERE B.id LIKE ? AND BT.id = ?";
		List<String> list = new BookTypeUtil().getBookTypeId();		// 得出图书类型的所有的id代码
		for (int i = 0; i < list.size(); i++) {
			try {
				pstmt = conn.prepareStatement(sql);					// 预执行数据库语句
				pstmt.setString(1, list.get(i) + "%");
				pstmt.setString(2, list.get(i));
				res = pstmt.executeQuery();
				res.next();
				map.put(res.getString(1), res.getInt(2));			// 添加数据到map集合中
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
}
