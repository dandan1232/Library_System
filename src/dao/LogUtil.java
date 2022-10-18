package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DBUtil;
import entity.Log;

public class LogUtil extends DBUtil {
	
	/*
	 * 获取log表中的全部数据
	 */
	public List<Log> getAllLog() {
		List<Log> list = new ArrayList<Log>();
		String sql = "SELECT * FROM log";
		Object[] param = null;
		ResultSet res = this.executeQuery(sql, param);
		try {
			while (res.next()) {
				Log log = new Log();
				log.setDate(res.getString(1));
				log.setUserId(res.getString(2));
				log.setUserType(res.getString(3));
				log.setOperate(res.getString(4));
				log.setBookId(res.getString(5));
				log.setBorrowDate(res.getString(6));
				log.setReturnDate(res.getString(7));
				log.setNum(res.getInt(8));
				log.setNote(res.getString(9));
				list.add(log);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
