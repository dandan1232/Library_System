package gui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entity.Record;
import Table.RecordTable;
import dao.RecordUtil;

public class RecordFrame extends JFrame {
	
private static final long serialVersionUID = 1L;
	
	public RecordFrame() {
		setTitle("类别管理");
		addWindowListener(new WindowAdapter () {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				new ManagerMain().setVisible(true);
			}
		});
		setBounds(500, 200, 500, 400);
		setResizable(false);
		
		Container container = getContentPane();
		container.setLayout(null);
		
		JLabel  jlab = new JLabel("当前位置：借阅记录");
		jlab.setFont(new Font("宋体", Font.BOLD, 20));
		jlab.setBounds(20, 20, 200, 30);
		container.add(jlab);
		
		JButton btnBack = new JButton("返   回");
		btnBack.setFont(new Font("宋体", Font.BOLD, 16));
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ManagerMain().setVisible(true);
			}
		});
		btnBack.setBounds(360, 20, 100, 30);
		container.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 60, 450, 290);
		RecordTable model = new RecordTable();
		JTable table = new JTable(model);
		List<Record> list = new RecordUtil().selectAllRecord(); 
		for (int i = 0; i < list.size(); i++) {
			Record record = list.get(i);
			model.addRow(new Object[] { record.getStudentId(), record.getBookId(), record.getBorrowDate(), record.getReturnDate(), record.getStatus() });
		}
		scrollPane.setViewportView(table);
		container.add(scrollPane);
	}
}
