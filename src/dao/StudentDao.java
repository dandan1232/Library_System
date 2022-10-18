package dao;

import java.util.List;

import entity.Book;
import entity.BookType;
import entity.Record;
import entity.Student;

public interface StudentDao {
	
	/*
	 * 判断学生是否登录成功
	 */
	boolean loginStudent(Student student);

	
	/*
	 * 学生精确查找图书信息的方法
	 */
	List<Book> selectBook(Book book);
	/*
	 * 学生通过书的类型查找对应的图书信息
	 */
	List<Book> selectBookByType(BookType bookType);
	
	
	
	/*
	 * 借阅图书的方法   --->针对于book表
	 */
	boolean borrowBook(Book book, Record record);
	
	/*
	 * 归还图书的方法  --->针对于book表
	 */
	boolean returnBook(Record record);
	
	/*
	 * 学生查看自己借阅记录表的方法
	 */
	List<Record> getRecord(Student student);
	
	/*
	 * 判断此书自己有没有借阅过
	 */
	boolean isBorrowed(Student student, Book book);
	
}
