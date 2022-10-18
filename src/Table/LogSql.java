package Table;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DBUtil;
import entity.Log;

public class LogSql extends DBUtil {
    // id --> ָ������id
    private String sql = "INSERT INTO log (date, user_id, user_type, operate, book_id, borrow_date, return_date, num, note) VALUE(?, ?, ?, ?, ?, ?, ?, ?, ?)";


    /*
     * ��¼��־
     */
    public void login(Log log) {
        Object[] param = {log.getDate(), log.getUserId(), log.getUserType(), "��¼��־", "��", "��", "��", 0, "������¼"};
        executeUpdate(sql, param);
    }

    /*
     * ѧ����ע����־
     */
    public void registerOfstudentLog(Log log) {
        Object[] param = {log.getDate(), log.getUserId(), log.getUserType(), "ע����־", "��", "��", "��", 0, "����Ա" + log.getUserId() + "ע����һ����ͬѧ"};
        executeUpdate(sql, param);
    }

    /*
     * ����Ա��ע����־
     */
    public void registerOfManagerLog(Log log) {
        Object[] param = {log.getDate(), "��", "��������Ա", "ע����־", "��", "��", "��", 0, "����Ա" + log.getUserId() + "��ע��"};
        executeUpdate(sql, param);
    }

    /*
     * ������־
     */
    public void borrowLog(Log log) {
        Object[] param = {log.getDate(), log.getUserId(), log.getUserType(), "����ͼ��", log.getBookId(), log.getBorrowDate(), "��", 1, "�ɹ�����"};
        executeUpdate(sql, param);
    }

    /*
     * ������־
     */
    public void returnBookLog(Log log) {
        String getBookBorrowDate = "SELECT borrow_date FROM record WHERE student_id = ? AND book_id = ?";
        Object[] p = {log.getUserId(), log.getBookId()};
        ResultSet res = executeQuery(getBookBorrowDate, p);
        String borrowDate = null;
        try {
            res.next();
            borrowDate = res.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Object[] param = {log.getDate(), log.getUserId(), log.getUserType(), "�黹ͼ��", log.getBookId(), borrowDate, log.getReturnDate(), 1, "�ɹ��黹"};
        executeUpdate(sql, param);
    }

    /*
     * ����鼮��־
     */
    public void addBookLog(Log log) {
        Object[] param = {log.getDate(), log.getUserId(), log.getUserType(), "���ͼ��", log.getBookId(), "��", "��", log.getNum(), "�ɹ����" + log.getBookId() + "�����ͼ��" + log.getNum() + "��"};
        executeUpdate(sql, param);
    }

    /*
     * ɾ���鼮��־
     */
    public void deleteBookLog(Log log) {
        Object[] param = {log.getDate(), log.getUserId(), log.getUserType(), "ɾ��ͼ��", log.getBookId(), "��", "��", log.getNum(), "�ɹ�ɾ��" + log.getBookId() + "�����ͼ��"};
        executeUpdate(sql, param);
    }

    /*
     * �޸��鼮��־
     */
    public void updateBookLog(Log log) {
        Object[] param = {log.getDate(), log.getUserId(), log.getUserType(), "�޸�ͼ��", log.getBookId(), "��", "��", log.getNum(), log.getBookId() + "�����ͼ���޸ĺ������Ϊ" + log.getNum() + "��"};
        executeUpdate(sql, param);
    }

    /*
     * �޸��鼮������־
     */
    public void updateBookNameLog(Log log1) {
        Object[] param = {log1.getDate(), log1.getUserId(), log1.getUserType(), "�޸�ͼ��", log1.getBookId(), "��", "��", 0, log1.getBookId() + "�����ͼ���޸�������"};
        executeUpdate(sql, param);
    }

    /*
     * �޸Ľ����ܴ�����־
     */
    public void updateBookTimeLog(Log log2) {
        Object[] param = {log2.getDate(), log2.getUserId(), log2.getUserType(), "�޸�ͼ��", log2.getBookId(), "��", "��", 0, log2.getBookId() + "�����ͼ�鱻�޸Ľ����ܴ���"};
        executeUpdate(sql, param);
    }

    /*
     * ����Ա�޸�ѧ����Ϣ������־
     */
    public void updateStudentLog(Log log) {
        Object[] param = {log.getDate(), log.getUserId(), log.getUserType(), "����Ա�޸�ѧ������", "��", "��", "��", 0, "��"};
        executeUpdate(sql, param);
    }

    /*
     * ����Աɾ��ѧ����Ϣ��־
     */
    public void deleteStudentLog(Log log) {
        Object[] param = {log.getDate(), log.getUserId(), log.getUserType(), "����Աɾ��ѧ����Ϣ", "��", "��", "��", 0, "��"};
        executeUpdate(sql, param);
    }


}
