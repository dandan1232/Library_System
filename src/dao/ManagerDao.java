package dao;

import java.util.List;
import java.util.Map;

import entity.Book;
import entity.Manager;
import entity.Student;

public interface ManagerDao {

	
// 管理员对学生的“增删改查”
	/*
	 * 先判断学生信息是否已经存在
	 */
	boolean canRegister(Student student);
	
	
	/*
	 * 判断学生信息是否插入成功
	 */
	boolean insertStudent(Student student);
	/*
	 * 判断学生信息是否修改成功
	 */
	boolean updateStudent(Student student);
	/*
	 * 判断学生信息是否删除成功
	 */
	boolean deleteStudent(Student student);
	/*
	 * 查看所有学生的信息
	 */
	List<Student> selectStudent();
	
	
	
// 管理员自己的行为方法：
	/*
	 * 判断注册时给定的id是否可用
	 */
	boolean canRegister(Manager manager);
	
	/*
	 * 判断管理员是否登录成功
	 */
	boolean loginManager(Manager manager);
	
	/*
	 * 判断管理员是否注册成功
	 */
	boolean insertManager(Manager manager);
	
	/*
	 * 获取管理员姓名
	 */
	String getManagerName(Manager manager);
	
	
	
	

// 管理员对图书的基本操作
	/*
	 * 管理判断插入新书籍时，id的可用否？
	 */
	boolean canAddBook(Book book);
	
	/*
	 * 用于删除图书信息
	 */
	int delBook(Book book);

	/*
	 * 用于修改图书信息
	 */
	int updateBook(Book book);

	/*
	 * 用于添加图书
	 */
	int sava(Book book);
	
	
	/*
	 * 管理员统计图书借阅次数的方法
	 */
	Map<String, Integer> statistics();		// statistics --> 统计
	
}
