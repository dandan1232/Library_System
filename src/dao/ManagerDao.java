package dao;

import java.util.List;
import java.util.Map;

import entity.Book;
import entity.Manager;
import entity.Student;

public interface ManagerDao {

	
// ����Ա��ѧ���ġ���ɾ�Ĳ顱
	/*
	 * ���ж�ѧ����Ϣ�Ƿ��Ѿ�����
	 */
	boolean canRegister(Student student);
	
	
	/*
	 * �ж�ѧ����Ϣ�Ƿ����ɹ�
	 */
	boolean insertStudent(Student student);
	/*
	 * �ж�ѧ����Ϣ�Ƿ��޸ĳɹ�
	 */
	boolean updateStudent(Student student);
	/*
	 * �ж�ѧ����Ϣ�Ƿ�ɾ���ɹ�
	 */
	boolean deleteStudent(Student student);
	/*
	 * �鿴����ѧ������Ϣ
	 */
	List<Student> selectStudent();
	
	
	
// ����Ա�Լ�����Ϊ������
	/*
	 * �ж�ע��ʱ������id�Ƿ����
	 */
	boolean canRegister(Manager manager);
	
	/*
	 * �жϹ���Ա�Ƿ��¼�ɹ�
	 */
	boolean loginManager(Manager manager);
	
	/*
	 * �жϹ���Ա�Ƿ�ע��ɹ�
	 */
	boolean insertManager(Manager manager);
	
	/*
	 * ��ȡ����Ա����
	 */
	String getManagerName(Manager manager);
	
	
	
	

// ����Ա��ͼ��Ļ�������
	/*
	 * �����жϲ������鼮ʱ��id�Ŀ��÷�
	 */
	boolean canAddBook(Book book);
	
	/*
	 * ����ɾ��ͼ����Ϣ
	 */
	int delBook(Book book);

	/*
	 * �����޸�ͼ����Ϣ
	 */
	int updateBook(Book book);

	/*
	 * �������ͼ��
	 */
	int sava(Book book);
	
	
	/*
	 * ����Աͳ��ͼ����Ĵ����ķ���
	 */
	Map<String, Integer> statistics();		// statistics --> ͳ��
	
}
