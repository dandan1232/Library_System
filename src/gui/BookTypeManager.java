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

import entity.BookType;
import Table.BookTypeTable;
import dao.BookTypeUtil;
public class BookTypeManager extends JFrame{

	BookTypeManager() {
		setTitle("类别管理");
		addWindowListener(new WindowAdapter () {
			@Override
			public void windowClosing(WindowEvent e) {
				new ManagerMain().setVisible(true);
			}
		});
		setBounds(500, 200, 500, 400);
		setResizable(false);
		
		Container container = getContentPane();
		container.setLayout(null);
		
		JLabel  jlab = new JLabel("当前位置：类别查询");
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

		/*插入booktype表*/
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 60, 450, 290);
		BookTypeTable model = new BookTypeTable();
		JTable table = new JTable(model);
		List<BookType> list = new BookTypeUtil().selectAllBookType();
		for (int i = 0; i < list.size(); i++) {
			BookType booktype = list.get(i);
			model.addRow(new Object[] { booktype.getId(), booktype.getName() });
		}
		scrollPane.setViewportView(table);
		container.add(scrollPane);
	}
}
