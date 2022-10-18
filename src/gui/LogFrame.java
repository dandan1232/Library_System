package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entity.Log;
import Table.LogTable;
import dao.LogUtil;

public class LogFrame extends JFrame {
	
	JPanel contentPane;
	
	public LogFrame() {
		setTitle("日志");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //定义工具包
		Toolkit kit = Toolkit.getDefaultToolkit();  //获取屏幕尺寸
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		setBounds(width / 2 - 1000 / 2, height / 2 - 400 / 2, 1000, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(Color.ORANGE);
		setContentPane(contentPane);
		Font font = new Font("微软雅黑", Font.BOLD, 16);
		
		LogTable model = new LogTable();
		JTable table = new JTable(model);
		List<Log> list = new LogUtil().getAllLog();
		for (int i = 0; i < list.size(); i++) {
			Log log = list.get(i);
			Object[] obj = { log.getDate(), log.getUserId(), log.getUserType(), 
					log.getOperate(), log.getBookId(), log.getBorrowDate(), 
					log.getReturnDate(), log.getNum(), log.getNote() };
			model.addRow(obj);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		scrollPane.setFont(font);
		scrollPane.setBounds(10, 10, 965, 340);
		contentPane.add(scrollPane);
	}
}
