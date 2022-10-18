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
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import entity.Log;
import entity.Student;
import impl.ManagerImplements;
import Table.BackgroundPanel;
import Table.LogSql;
import Table.StudentTable;
import dao.StudentUtil;

public class UpdateStudentFrame extends JFrame {
	
	BackgroundPanel contentPane;
	private List<Student> list = null;
	private JTable table;
	
	public UpdateStudentFrame() {
		setTitle("ѧ����Ϣ�޸Ľ��棨��ֱ�Ӷ�ѧ�������ڱ�����޸ģ�");
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
		setBounds(width / 2 - 585 / 2, height / 2 - 438 / 2, 575, 438);
		setResizable(false);
		contentPane = new BackgroundPanel();
		contentPane.setImage(getToolkit().getImage(getClass().getResource("/image/ѧ����Ϣ.jpg")));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		Font font = new Font("΢���ź�", Font.BOLD, 20);
	// ����ѧ����Ϣ��	
		StudentTable model = new StudentTable();
		table = new JTable(model);
		list = new StudentUtil().selectStudent();
		for (int i = 0; i < list.size(); i++) {
			Student student = list.get(i);
			model.addRow(new Object[] { student.getId(), student.getName(), "*********" });
		}
		model.addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				do_model_tableChanged(e);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		scrollPane.setBounds(5, 5, 550, 280);
		contentPane.add(scrollPane);
		
		JButton btnDelect = new JButton("ɾ   ��");
		btnDelect.setFont(font);
		btnDelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_btnDelete_actionPerformed(e);
			}
		});
		btnDelect.setBounds(10, 300, 200, 50);
		contentPane.add(btnDelect);
	
		JButton btnBack = new JButton("��   ��");
		btnBack.setFont(font);
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ManagerStudentFrame().setVisible(true);
			}
		});
		btnBack.setBounds(350, 300, 200, 50);
		contentPane.add(btnBack);
	}
	
	protected void do_btnDelete_actionPerformed(ActionEvent e) {
		String[] options = { "ȷ��", "ȡ��" };
		int flag = JOptionPane.showOptionDialog(null, "ȷ��Ҫɾ�����С������", "ȷ�Ϲر�", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (flag == 0) {
			int[] selectRows = table.getSelectedRows();
			for (int i = 0; i < selectRows.length; i++) {
				Student student = list.get(selectRows[i]);
				boolean result = new ManagerImplements().deleteStudent(student);
				if (result) {
// ��ӹ���Աɾ��ѧ������־
					Log log = new Log();
					log.setDate(new SimpleDateFormat("yyyy��MM��dd��").format(new Date()));
					log.setUserId(LoginFrame.managerId);
					log.setUserType("����Ա");
					new LogSql().deleteStudentLog(log);
					
					JOptionPane.showMessageDialog(null, "��" + student.getName() + "���ѱ�ɾ��");
					this.dispose(); 
					new UpdateStudentFrame().setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "��" + student.getName() + "��ɾ��ʧ��", "����", JOptionPane.WARNING_MESSAGE);
				}
			}
		} else {
			
		}
		
		
	}

	protected void do_model_tableChanged(TableModelEvent e) {
		int row = e.getFirstRow();						// ��ȡѡ���еĵ�һ�е�����
		int column = e.getColumn();						// ��ȡѡ���е�����
		if (row != -1) {
			String id = (String) table.getValueAt(row, 0);
			String name = (String) table.getValueAt(row, 1);
			String password = (String) table.getValueAt(row, 2);
			Student student = new Student();
			student.setId(id);
			student.setName(name);
			student.setPassword(password);
			if (table.getValueAt(row, column).equals("")) {
				JOptionPane.showMessageDialog(null, "�˴�����Ϊ��Ӵ��\n�ѻָ�ԭ����\n����������", "����", JOptionPane.WARNING_MESSAGE);
				this.dispose();
				new UpdateStudentFrame().setVisible(true);
			} else {
				try {
// ��ӹ���Աɾ��ѧ������־
					Log log = new Log();
					log.setDate(new SimpleDateFormat("yyyy��MM��dd��").format(new Date()));
					log.setUserId(LoginFrame.managerId);
					log.setUserType("����Ա");
					new LogSql().updateStudentLog(log);
					
					new ManagerImplements().updateStudent(student);
					JOptionPane.showMessageDialog(null, "�ѳɹ��޸����ݣ�" + (String) table.getValueAt(row, column));
				} catch (Exception exception) {
					System.out.println("����Ա����ѧ����񴦷�������");
					JOptionPane.showConfirmDialog(null, "�޸�ʧ�ܣ�", "����", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
		
	}
}
