package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.StudentDao;
import entity.Book;
import entity.BookType;
import entity.Record;
import entity.Student;
import dao.DBUtil;
import dao.BookUtil;
import dao.RecordUtil;

public class StudentImplements extends DBUtil implements StudentDao {

    public static RecordUtil recordUtil = new RecordUtil();
    public static BookUtil bookUtil = new BookUtil();

    // 学生自己的基本操作方法
    @Override
    public boolean loginStudent(Student student) {
        String sql = "SELECT * FROM student WHERE id = ? AND password = ?";
        Object[] param = {student.getId(), student.getPassword()};
        ResultSet res = this.executeQuery(sql, param);
        try {
            if (res.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 学生对图书的基本操作的方法
    @Override
    public List<Book> selectBook(Book book) {
        List<Book> list = new ArrayList<Book>();
        String sql = "SELECT * FROM book WHERE id LIKE ? AND name LIKE ? ";
        Connection conn = this.getConnection();
        PreparedStatement pstmt = null;
        ResultSet res = null;
        try {
            pstmt = conn.prepareStatement(sql);
            if (book.getId() == null) {
                pstmt.setString(1, "%");
            } else {
                pstmt.setString(1, book.getId() + "%");
            }
            pstmt.setString(2, "%" + book.getName() + "%");
            res = pstmt.executeQuery();
            while (res.next()) {
                Book b = new Book();
                b.setId(res.getString(1));
                b.setName(res.getString(2));
                b.setNum(res.getInt(3));
                list.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Book> selectBookByType(BookType bookType) {
        List<Book> list = new ArrayList<Book>();
        String sql = "SELECT * FROM book WHERE id = ?";
        Connection conn = this.getConnection();
        PreparedStatement pstmt = null;
        ResultSet res = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1, bookType.getId() + "%");
            res = pstmt.executeQuery();
            while (res.next()) {
                Book b = new Book();
                b.setId(res.getString(1));
                b.setName(res.getString(2));
                b.setNum(res.getInt(3));
                list.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean borrowBook(Book book, Record record) {
        // 先判断此书的数量是否为零
        int num = new BookUtil().getBookNum(book);
        if (num == 0) {
            return false;
        }
        // 从book表中减去一本书
        String sql = "UPDATE book SET num = num - 1, times = times + 1 WHERE id = ?";
        Object[] param = {record.getBookId()};
        int result1 = this.executeUpdate(sql, param);
        // 在record中添加还书日期
        int result2 = recordUtil.addRecord(record);
        if (result1 != 0 && result2 != 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean returnBook(Record record) {
        // 从book表中添加一本书
        String sql = "UPDATE book SET num = ? WHERE id = ?";
        Book book = new Book();
        book.setId(record.getBookId());
        int num = bookUtil.getBookNum(book);
        Object[] param = {num + 1, record.getBookId()};
        int result1 = this.executeUpdate(sql, param);
        // 在record中添加一条信息（归还日期）
        int result2 = recordUtil.addReturnDate(record);
        // 在record中添加一条信息（状态）
        int result3 = recordUtil.addStatus(record);
        if (result1 != 0 && result2 != 0 && result3 != 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isBorrowed(Student student, Book book) {
        String sql = "SELECT status FROM record WHERE student_id = ? AND book_id = ?";
        Object[] param = {student.getId(), book.getId()};
        ResultSet res = this.executeQuery(sql, param);
        try {
            while (res.next()) {
                String status = res.getString(1);
                if (status.equals("未还")) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

// ------------------------------------------------------------------------------------------------------------------

// 学生对借阅记录表的基本操作的方法

    @Override
    public List<Record> getRecord(Student student) {
        String sql = "SELECT * FROM record WHERE student_id = ? and status = '未还'";
        Object[] param = {student.getId()};
        ResultSet res = this.executeQuery(sql, param);
        List<Record> list = new ArrayList<Record>();
        try {
            while (res.next()) {
                Record record = new Record();
                record.setStudentId(res.getString(1));
                record.setBookId(res.getString(2));
                record.setBorrowDate(res.getString(3));
                record.setReturnDate(res.getString(4));
                record.setStatus(res.getString(5));
                list.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
