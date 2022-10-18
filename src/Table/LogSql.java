package Table;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DBUtil;
import entity.Log;

public class LogSql extends DBUtil {
    // id --> 指操作者id
    private String sql = "INSERT INTO log (date, user_id, user_type, operate, book_id, borrow_date, return_date, num, note) VALUE(?, ?, ?, ?, ?, ?, ?, ?, ?)";


    /*
     * 登录日志
     */
    public void login(Log log) {
        Object[] param = {log.getDate(), log.getUserId(), log.getUserType(), "登录日志", "无", "无", "无", 0, "正常登录"};
        executeUpdate(sql, param);
    }

    /*
     * 学生的注册日志
     */
    public void registerOfstudentLog(Log log) {
        Object[] param = {log.getDate(), log.getUserId(), log.getUserType(), "注册日志", "无", "无", "无", 0, "管理员" + log.getUserId() + "注册了一名新同学"};
        executeUpdate(sql, param);
    }

    /*
     * 管理员的注册日志
     */
    public void registerOfManagerLog(Log log) {
        Object[] param = {log.getDate(), "无", "超级管理员", "注册日志", "无", "无", "无", 0, "管理员" + log.getUserId() + "被注册"};
        executeUpdate(sql, param);
    }

    /*
     * 借书日志
     */
    public void borrowLog(Log log) {
        Object[] param = {log.getDate(), log.getUserId(), log.getUserType(), "借阅图书", log.getBookId(), log.getBorrowDate(), "无", 1, "成功借阅"};
        executeUpdate(sql, param);
    }

    /*
     * 还书日志
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
        Object[] param = {log.getDate(), log.getUserId(), log.getUserType(), "归还图书", log.getBookId(), borrowDate, log.getReturnDate(), 1, "成功归还"};
        executeUpdate(sql, param);
    }

    /*
     * 添加书籍日志
     */
    public void addBookLog(Log log) {
        Object[] param = {log.getDate(), log.getUserId(), log.getUserType(), "添加图书", log.getBookId(), "无", "无", log.getNum(), "成功添加" + log.getBookId() + "编码的图书" + log.getNum() + "本"};
        executeUpdate(sql, param);
    }

    /*
     * 删除书籍日志
     */
    public void deleteBookLog(Log log) {
        Object[] param = {log.getDate(), log.getUserId(), log.getUserType(), "删除图书", log.getBookId(), "无", "无", log.getNum(), "成功删除" + log.getBookId() + "编码的图书"};
        executeUpdate(sql, param);
    }

    /*
     * 修改书籍日志
     */
    public void updateBookLog(Log log) {
        Object[] param = {log.getDate(), log.getUserId(), log.getUserType(), "修改图书", log.getBookId(), "无", "无", log.getNum(), log.getBookId() + "编码的图书修改后的数量为" + log.getNum() + "本"};
        executeUpdate(sql, param);
    }

    /*
     * 修改书籍名称日志
     */
    public void updateBookNameLog(Log log1) {
        Object[] param = {log1.getDate(), log1.getUserId(), log1.getUserType(), "修改图书", log1.getBookId(), "无", "无", 0, log1.getBookId() + "编码的图书修改了名字"};
        executeUpdate(sql, param);
    }

    /*
     * 修改借书总次数日志
     */
    public void updateBookTimeLog(Log log2) {
        Object[] param = {log2.getDate(), log2.getUserId(), log2.getUserType(), "修改图书", log2.getBookId(), "无", "无", 0, log2.getBookId() + "编码的图书被修改借书总次数"};
        executeUpdate(sql, param);
    }

    /*
     * 管理员修改学生信息姓名日志
     */
    public void updateStudentLog(Log log) {
        Object[] param = {log.getDate(), log.getUserId(), log.getUserType(), "管理员修改学生姓名", "无", "无", "无", 0, "无"};
        executeUpdate(sql, param);
    }

    /*
     * 管理员删除学生信息日志
     */
    public void deleteStudentLog(Log log) {
        Object[] param = {log.getDate(), log.getUserId(), log.getUserType(), "管理员删除学生信息", "无", "无", "无", 0, "无"};
        executeUpdate(sql, param);
    }


}
