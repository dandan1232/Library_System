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
import entity.Manager;
import impl.ManagerImplements;
import Table.BackgroundPanel;
import Table.LogSql;

public class RegisterManagerFrame extends JFrame {

	private static final long serialVersionUID = 1l;
	
	BackgroundPanel contentPane;
	private JLabel lblId;
	private JTextField textId, textName;
	private JPasswordField textPassword, textRePassword;
	
	public RegisterManagerFrame() {
		setTitle("����Աע�����");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter () {
			@Override
			public void windowClosing(WindowEvent e) {
				new LoginFrame().setVisible(true);
			}
		});
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		setBounds(width / 2 - 575 / 2, height / 2 - 438 / 2, 575, 438);
		setResizable(false);
		contentPane = new BackgroundPanel();
		contentPane.setImage(getToolkit().getImage(getClass().getResource("/image/����Աע�ᱳ��.jpg")));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.CYAN);
		setContentPane(contentPane);
		Font font = new Font("΢���ź�", Font.BOLD, 20);
			
		lblId = new JLabel("����Ա�ţ�");
		lblId.setFont(font);
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(95, 50, 100, 23);
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("������");
		lblName.setFont(font);
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(125, 110, 70, 23);
		contentPane.add(lblName);
		
		JLabel lblPassword = new JLabel("���룺");
		lblPassword.setFont(font);
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(125, 170, 70, 23);
		contentPane.add(lblPassword);
		
		JLabel lblRelPassword = new JLabel("���ٴ��������룺");
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
		
		JButton btnSure = new JButton("ȷ   ��");
		btnSure.setFont(font);
		btnSure.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_btnSure_actionPerformed(e);
			}
		});
		btnSure.setBounds(100, 300, 100, 40);
		contentPane.add(btnSure);
		
		JButton btnCancle = new JButton("ȡ   ��");
		btnCancle.setFont(font);
		btnCancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginFrame().setVisible(true);
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
				Manager manager = new Manager();
				manager.setId(id);
				manager.setName(name);
				manager.setPassword(password1);
				if (managerDao.canRegister(manager)) {
					if (managerDao.insertManager(manager)) {
// ��������Աע�����Ա��־
						Log log1 = new Log();
						log1.setDate(new SimpleDateFormat("yyyy��MM��dd��").format(new Date()));
						log1.setUserId(manager.getId());
						new LogSql().registerOfManagerLog(log1);
						JOptionPane.showMessageDialog(null, "���û�ע��ɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
						this.dispose();
						new LoginFrame().setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "�û�ע��ʧ�ܣ�", "����", JOptionPane.ERROR_MESSAGE);
						textName.setText("");
						textPassword.setText("");
						textRePassword.setText("");
					}
				} else {
					JOptionPane.showMessageDialog(null, "��id�ѱ�ע�ᣡ���¼��", "����", JOptionPane.WARNING_MESSAGE);
					textId.setText("");
					textName.setText("");
					textPassword.setText("");
					textRePassword.setText("");
				}
		} else {
			JOptionPane.showMessageDialog(null, "�û�ע��ʧ�ܣ�����ȷ��д��Ϣ��", "����", JOptionPane.ERROR_MESSAGE);
			textName.setText("");
			textPassword.setText("");
			textRePassword.setText("");
		}
	}
}
