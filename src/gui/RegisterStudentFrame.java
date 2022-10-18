package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.ManagerDao;
import entity.Log;
import entity.Student;
import impl.ManagerImplements;
import Table.BackgroundPanel;
import Table.LogSql;

public class RegisterStudentFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	BackgroundPanel contentPane;
	private JLabel lblId;
	private JTextField textId, textName;
	private JPasswordField textPassword, textRePassword;
	
	public RegisterStudentFrame() {

		setTitle("学生注册界面");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter () {
			@Override
			public void windowClosing(WindowEvent e) {
				new ManagerStudentFrame().setVisible(true);
			}
		});
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		setBounds(width / 2 - 585 / 2, height / 2 - 438 / 2, 575, 437);
		setResizable(false);
		contentPane = new BackgroundPanel();
		contentPane.setImage(getToolkit().getImage(getClass().getResource("/image/学生注册背景.jpg")));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.CYAN);
		setContentPane(contentPane);
		Font font = new Font("微软雅黑", Font.BOLD, 20);
			
		lblId = new JLabel("学号：");
		lblId.setFont(font);
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(95, 50, 100, 23);
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("姓名：");
		lblName.setFont(font);
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(125, 110, 70, 23);
		contentPane.add(lblName);
		
		JLabel lblPassword = new JLabel("密码：");
		lblPassword.setFont(font);
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(125, 170, 70, 23);
		contentPane.add(lblPassword);
		
		JLabel lblRelPassword = new JLabel("请再次输入密码：");
		lblRelPassword.setFont(font);
		lblRelPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRelPassword.setBounds(35, 230, 160, 23);
		contentPane.add(lblRelPassword);
		
		textId = new JTextField(10);
		textId.setFont(font);
		textId.setBounds(220, 50, 200, 25);
		contentPane.add(textId);
		
		textName = new JTextField(10);
		textName.setFont(font);
		textName.setBounds(220, 110, 200, 25);
		contentPane.add(textName);
		
		textPassword = new JPasswordField(10);
		textPassword.setFont(font);
		textPassword.setBounds(220, 170, 200, 25);
		contentPane.add(textPassword);
		
		textRePassword = new JPasswordField(10);
		textRePassword.setFont(font);
		textRePassword.setBounds(220, 230, 200, 25);
		textRePassword.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_btnSure_actionPerformed(e);
			}
		});
		contentPane.add(textRePassword);
		
		JButton btnSure = new JButton("确   定");
		btnSure.setFont(font);
		btnSure.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_btnSure_actionPerformed(e);
			}
		});
		btnSure.setBounds(100, 300, 100, 40);
		contentPane.add(btnSure);
		
		JButton btnCancle = new JButton("取   消");
		btnCancle.setFont(font);
		btnCancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ManagerStudentFrame().setVisible(true);
			}
		});
		btnCancle.setBounds(370, 300, 100, 40);
		contentPane.add(btnCancle);
	
	}
	
	protected void do_btnSure_actionPerformed(ActionEvent e) {
		ManagerDao managerDao = new ManagerImplements();
		String id = textId.getText();
		String name = textName.getText();
		char[] ch1 = textPassword.getPassword();
		char[] ch2 = textRePassword.getPassword();
		String password1 = String.valueOf(ch1);
		String password2 = String.valueOf(ch2);
			
		boolean log = !id.equals("");
		boolean psw1 = !password1.equals("");
		boolean psw2 = !password2.equals("");			
		boolean psw = password1.equals(password2);
		
		if (log && psw1 && psw2 && psw) {
				Student student = new Student();
				student.setId(id);
				student.setName(name);
				student.setPassword(password1);
				if (managerDao.canRegister(student)) {
	// 添加管理员注册学生的日志信息
					Log log1 = new Log();
					log1.setDate(new SimpleDateFormat("yyyy年MM月dd日").format(new Date()));
					log1.setUserId(LoginFrame.managerId);
					log1.setUserType("管理员");
					new LogSql().registerOfstudentLog(log1);
					managerDao.insertStudent(student);
					JOptionPane.showMessageDialog(null, "新用户注册成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
					this.dispose();
					new ManagerStudentFrame().setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "该id已经被注册请登录！", "错误", JOptionPane.ERROR_MESSAGE);
					textName.setText("");
					textPassword.setText("");
					textRePassword.setText("");
				}
		} else {
			JOptionPane.showMessageDialog(null, "用户注册失败，请正确填写信息！", "错误", JOptionPane.ERROR_MESSAGE);
			textName.setText("");
			textPassword.setText("");
			textRePassword.setText("");
		}
	}

}
