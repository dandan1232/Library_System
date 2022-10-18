package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import Table.BackgroundPanel;

public class ManagerStudentFrame extends JFrame {

	BackgroundPanel contentPane;
	
	public ManagerStudentFrame() {
		setTitle("管理学生界面");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				new ManagerMain().setVisible(true);
			}	
		});
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		setBounds(width / 2 - 585 / 2, height / 2 - 438 / 2, 585, 438);
		setResizable(false);
		contentPane = new BackgroundPanel();
		contentPane.setImage(getToolkit().getImage(getClass().getResource("/image/学生管理系统图.jpg")));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		Font font = new Font("微软雅黑", Font.BOLD, 16);
		
		JButton btnRegisterStu = new JButton("注册学生信息");
		btnRegisterStu.setFont(font);
		btnRegisterStu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RegisterStudentFrame().setVisible(true);
			}
		});
		btnRegisterStu.setBounds(308, 10, 200, 50);
		contentPane.add(btnRegisterStu);
		contentPane.setBackground(Color.cyan);
		setContentPane(contentPane);
		
		JButton btnUpdateStu = new JButton("学生信息管理");
		btnUpdateStu.setFont(font);
		btnUpdateStu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new UpdateStudentFrame().setVisible(true);
			}
		});
		btnUpdateStu.setBounds(308, 70, 200, 50);
		contentPane.add(btnUpdateStu);
						
		JButton btnLogOut = new JButton("返   回");
		btnLogOut.setFont(font);
		btnLogOut.setBounds(308, 130, 200, 50);
		btnLogOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ManagerMain().setVisible(true);
			}
		});
		contentPane.add(btnLogOut);		
	}	
}
