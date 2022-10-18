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
		
	// �������ԵĶ��壺	
		setTitle("��¼����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		setBounds(width / 2 - 570 / 2, height / 2 - 400 / 2, 570, 400);
		setResizable(false);
		contentPane = new BackgroundPanel();
		contentPane.setImage(getToolkit().getImage(getClass().getResource("/image/��¼����.jpg")));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		Font font = new Font("΢���ź�", Font.BOLD, 18);
	// ���һ����ͼ�����ϵͳ����ǩ�����
		JLabel lblTitle = new JLabel("ͼ�����ϵͳ");
		lblTitle.setFont(new Font("��������", Font.BOLD, 50));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 100, 570, 50);
		contentPane.add(lblTitle);
	// ��ӵ�ѡ��ť��ѧ��or����Ա�������
		btnStudent = new JRadioButton("ѧ��");
		btnStudent.setOpaque(false);
		btnStudent.setSelected(true);
		btnStudent.setFont(font);
		btnStudent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (btnStudent.isSelected()) {
					lblId.setText("ѧ�ţ�");
				} 
			}
		});
		btnStudent.setBounds(160, 160, 100, 20);
		btnManager = new JRadioButton("����Ա");
		btnManager.setOpaque(false);
		btnManager.setFont(font);
		btnManager.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (btnManager.isSelected()) {
					lblId.setText("����Ա�ţ�");
				}
			}
		});
		btnManager.setBounds(340, 160, 100, 20);
		ButtonGroup group = new ButtonGroup();
		group.add(btnStudent);
		group.add(btnManager);
		contentPane.add(btnStudent);
		contentPane.add(btnManager);
	// ��ӡ��û�������ǩ
		lblId = new JLabel("ѧ�ţ�");
		lblId.setFont(font);
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(117, 203, 100, 20);
		contentPane.add(lblId);
	// ��ӡ��û����ı������
		textName = new JTextField();
		textName.setColumns(10);
		textName.setFont(font);
		textName.setBounds(225, 202, 200, 28);
		contentPane.add(textName);
		
	// ��ӡ����롱��ǩ
		JLabel lblPassword = new JLabel("���룺");
		lblPassword.setFont(font);
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(117, 253, 100, 20);
		contentPane.add(lblPassword);
	// ��ӡ������ı������
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
	// ��ӡ���¼����ť��
		JButton btnLogin = new JButton ("��   ¼");
		btnLogin.setFont(font);
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_btnLogin_actionPerformed(e);
			}
		});
		btnLogin.setBounds(135, 300, 100, 40);
		contentPane.add(btnLogin);
	// ��ӡ�ע�ᡱ��ť��
		JButton btnRegist = new JButton ("ע   ��");
		btnRegist.setFont(font);
		btnRegist.setBounds(370, 300, 100, 40);
		btnRegist.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (btnStudent.isSelected()) {
					JOptionPane.showMessageDialog(null, "ѧ����Ϣֻ���ɹ���Աע�ᣡ", "����", JOptionPane.WARNING_MESSAGE);
				} else if (btnManager.isSelected()) {
					//Object obj = JOptionPane.showInputDialog("������ϵͳ���룺");
					JPasswordField password = new JPasswordField(10);
					JOptionPane optionPane = new JOptionPane("������ϵͳ���룺", JOptionPane.QUESTION_MESSAGE);
					optionPane.add(password, 1);
					password.setEchoChar('*');
					JDialog localDialog = optionPane.createDialog("�����֤��");
					localDialog.setDefaultCloseOperation(1);
					localDialog.setVisible(true);									// ʹ�����˶Ի�����ʾ����
					String obj = String.valueOf(password.getPassword());
					if (obj.equals("")) {
						JOptionPane.showMessageDialog(null, "ϵͳ��������Ϊ�գ�����Ȩע�����Ա��", "����", JOptionPane.WARNING_MESSAGE);
					} else {
						if (obj.equals("root")) {
							new RegisterManagerFrame().setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "ϵͳ���������������Ȩע�����Ա��", "����", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
			}
		});
		contentPane.add(btnRegist);
	}
	
	
	/*
	 * ����¼����ť�ļ���������
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
				
	// ��ӹ���Ա��¼��־��
				Log log = new Log();
				log.setDate(new SimpleDateFormat("yyyy��MM��dd��").format(new Date()));
				log.setUserId(managerId);
				log.setUserType("����Ա");
				new LogSql().login(log);
			} else {
				JOptionPane.showMessageDialog(null, "��¼ʧ��");
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
// ���ѧ����¼��־
				Log log = new Log();
				log.setDate(new SimpleDateFormat("yyyy��MM��dd��").format(new Date()));
				log.setUserId(studentId);
				log.setUserType("ѧ��");
				new LogSql().login(log);
			} else {
				JOptionPane.showMessageDialog(null, "�û������������", "����", JOptionPane.WARNING_MESSAGE);
				textPassword.setText("");
			}
		}
	}

	private static void loadSkin()
	{
		InitGlobalFont(new Font("΢���ź�", Font.PLAIN,12));
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
