package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;


import entity.Log;
import entity.Manager;
import entity.Student;
import impl.ManagerImplements;
import impl.StudentImplements;
import Table.BackgroundPanel;
import Table.LogSql;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

public class LoginFrame extends JFrame {
	
 	private static final long serialVersionUID = 1L;
	
	private BackgroundPanel contentPane;
	private JTextField textName;
	private JPasswordField textPassword;
	private JRadioButton btnStudent, btnManager;
	private JLabel lblId;
	
	public static String studentId;
	public static String managerId;
	
	
	ManagerImplements managerImpl = new ManagerImplements();
	StudentImplements studentImpl = new StudentImplements();
	
	public LoginFrame() {
		
	// 基本属性的定义：	
		setTitle("登录界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		setBounds(width / 2 - 570 / 2, height / 2 - 400 / 2, 570, 400);
		setResizable(false);
		contentPane = new BackgroundPanel();
		contentPane.setImage(getToolkit().getImage(getClass().getResource("/image/登录背景.jpg")));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		Font font = new Font("微软雅黑", Font.BOLD, 18);
	// 添加一个“图书管理系统”标签组件：
		JLabel lblTitle = new JLabel("图书管理系统");
		lblTitle.setFont(new Font("华文琥珀", Font.BOLD, 50));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 100, 570, 50);
		contentPane.add(lblTitle);
	// 添加单选按钮“学生or管理员”组件：
		btnStudent = new JRadioButton("学生");
		btnStudent.setOpaque(false);
		btnStudent.setSelected(true);
		btnStudent.setFont(font);
		btnStudent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (btnStudent.isSelected()) {
					lblId.setText("学号：");
				} 
			}
		});
		btnStudent.setBounds(160, 160, 100, 20);
		btnManager = new JRadioButton("管理员");
		btnManager.setOpaque(false);
		btnManager.setFont(font);
		btnManager.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (btnManager.isSelected()) {
					lblId.setText("管理员号：");
				}
			}
		});
		btnManager.setBounds(340, 160, 100, 20);
		ButtonGroup group = new ButtonGroup();
		group.add(btnStudent);
		group.add(btnManager);
		contentPane.add(btnStudent);
		contentPane.add(btnManager);
	// 添加“用户名”标签
		lblId = new JLabel("学号：");
		lblId.setFont(font);
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(117, 203, 100, 20);
		contentPane.add(lblId);
	// 添加“用户名文本框”组件
		textName = new JTextField();
		textName.setColumns(10);
		textName.setFont(font);
		textName.setBounds(225, 202, 200, 28);
		contentPane.add(textName);
		
	// 添加“密码”标签
		JLabel lblPassword = new JLabel("密码：");
		lblPassword.setFont(font);
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(117, 253, 100, 20);
		contentPane.add(lblPassword);
	// 添加“密码文本框”组件
		textPassword = new JPasswordField();
		textPassword.setColumns(10);
		textPassword.setFont(font);
		textPassword.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_btnLogin_actionPerformed(e);
			}
		});
		textPassword.setBounds(225, 250, 200, 28);
		contentPane.add(textPassword);
	// 添加“登录”按钮：
		JButton btnLogin = new JButton ("登   录");
		btnLogin.setFont(font);
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_btnLogin_actionPerformed(e);
			}
		});
		btnLogin.setBounds(135, 300, 100, 40);
		contentPane.add(btnLogin);
	// 添加“注册”按钮：
		JButton btnRegist = new JButton ("注   册");
		btnRegist.setFont(font);
		btnRegist.setBounds(370, 300, 100, 40);
		btnRegist.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (btnStudent.isSelected()) {
					JOptionPane.showMessageDialog(null, "学生信息只能由管理员注册！", "警告", JOptionPane.WARNING_MESSAGE);
				} else if (btnManager.isSelected()) {
					//Object obj = JOptionPane.showInputDialog("请输入系统密码：");
					JPasswordField password = new JPasswordField(10);
					JOptionPane optionPane = new JOptionPane("请输入系统密码：", JOptionPane.QUESTION_MESSAGE);
					optionPane.add(password, 1);
					password.setEchoChar('*');
					JDialog localDialog = optionPane.createDialog("身份验证：");
					localDialog.setDefaultCloseOperation(1);
					localDialog.setVisible(true);									// 使创建了对话框显示出来
					String obj = String.valueOf(password.getPassword());
					if (obj.equals("")) {
						JOptionPane.showMessageDialog(null, "系统密码输入为空！您无权注册管理员！", "警告", JOptionPane.WARNING_MESSAGE);
					} else {
						if (obj.equals("root")) {
							new RegisterManagerFrame().setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "系统密码输出错误！您无权注册管理员！", "警告", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
			}
		});
		contentPane.add(btnRegist);
	}
	
	
	/*
	 * “登录”按钮的监听方法：
	 */
	protected void do_btnLogin_actionPerformed(ActionEvent e) {
		String id = textName.getText();
		String password = String.valueOf(textPassword.getPassword());
		if (btnManager.isSelected()) {
			Manager manager = new Manager();
			manager.setId(id);
			manager.setPassword(password); 
			if (managerImpl.loginManager(manager)) {
				managerId = textName.getText();
				this.dispose();
				new ManagerMain().setVisible(true);
				
	// 添加管理员登录日志：
				Log log = new Log();
				log.setDate(new SimpleDateFormat("yyyy年MM月dd日").format(new Date()));
				log.setUserId(managerId);
				log.setUserType("管理员");
				new LogSql().login(log);
			} else {
				JOptionPane.showMessageDialog(null, "登录失败");
				textPassword.setText("");
			}
		} else {
			Student student = new Student();
			student.setId(id);
			student.setPassword(password);
			if (studentImpl.loginStudent(student)) {
				studentId = textName.getText();
				this.dispose();
				new StudentMainFrame().setVisible(true);
// 添加学生登录日志
				Log log = new Log();
				log.setDate(new SimpleDateFormat("yyyy年MM月dd日").format(new Date()));
				log.setUserId(studentId);
				log.setUserType("学生");
				new LogSql().login(log);
			} else {
				JOptionPane.showMessageDialog(null, "用户名或密码错误！", "警告", JOptionPane.WARNING_MESSAGE);
				textPassword.setText("");
			}
		}
	}

	private static void loadSkin()
	{
		InitGlobalFont(new Font("微软雅黑", Font.PLAIN,12));
		try
		{
			BeautyEyeLNFHelper.frameBorderStyle =BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		}
		catch (Exception e)
		{
			System.err.println("set skin fail!");
		}
	}

	private static void InitGlobalFont(Font font)
	{
		FontUIResource fontRes = new FontUIResource(font);
		for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof FontUIResource) {
				UIManager.put(key, fontRes);
			}
		}
	}
	public static void main(String[] args) {
		loadSkin();
		new LoginFrame().setVisible(true);
	}
}
