package dao;

import java.util.List;

import entity.Book;
import entity.BookType;
import entity.Record;
import entity.Student;

public interface StudentDao {
	
	/*
	 * �ж�ѧ���Ƿ��¼�ɹ�
	 */
	boolean loginStudent(Student student);

	
	/*
	 * ѧ����ȷ����ͼ����Ϣ�ķ���
	 */
	List<Book> selectBook(Book book);
	/*
	 * ѧ��ͨ��������Ͳ��Ҷ�Ӧ��ͼ����Ϣ
	 */
	List<Book> selectBookByType(BookType bookType);
	
	
	
	/*
	 * ����ͼ��ķ���   --->�����book��
	 */
	boolean borrowBook(Book book, Record record);
	
	/*
	 * �黹ͼ��ķ���  --->�����book��
	 */
	boolean returnBook(Record record);
	
	/*
	 * ѧ���鿴�Լ����ļ�¼��ķ���
	 */
	List<Record> getRecord(Student student);
	
	/*
	 * �жϴ����Լ���û�н��Ĺ�
	 */
	boolean isBorrowed(Student student, Book book);
	
}
