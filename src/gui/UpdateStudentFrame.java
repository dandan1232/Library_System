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
		setTitle("学生信息修改界面（可直接对学生姓名在表格中修改）");
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
		contentPane.setImage(getToolkit().getImage(getClass().getResource("/image/学生信息.jpg")));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		Font font = new Font("微软雅黑", Font.BOLD, 20);
	// 创建学生信息表：	
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
		
		JButton btnDelect = new JButton("删   除");
		btnDelect.setFont(font);
		btnDelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_btnDelete_actionPerformed(e);
			}
		});
		btnDelect.setBounds(10, 300, 200, 50);
		contentPane.add(btnDelect);
	
		JButton btnBack = new JButton("返   回");
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
		String[] options = { "确定", "取消" };
		int flag = JOptionPane.showOptionDialog(null, "确定要删除这个小朋友吗？", "确认关闭", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (flag == 0) {
			int[] selectRows = table.getSelectedRows();
			for (int i = 0; i < selectRows.length; i++) {
				Student student = list.get(selectRows[i]);
				boolean result = new ManagerImplements().deleteStudent(student);
				if (result) {
// 添加管理员删除学生的日志
					Log log = new Log();
					log.setDate(new SimpleDateFormat("yyyy年MM月dd日").format(new Date()));
					log.setUserId(LoginFrame.managerId);
					log.setUserType("管理员");
					new LogSql().deleteStudentLog(log);
					
					JOptionPane.showMessageDialog(null, "“" + student.getName() + "”已被删除");
					this.dispose(); 
					new UpdateStudentFrame().setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "“" + student.getName() + "”删除失败", "警告", JOptionPane.WARNING_MESSAGE);
				}
			}
		} else {
			
		}
		
		
	}

	protected void do_model_tableChanged(TableModelEvent e) {
		int row = e.getFirstRow();						// 获取选中列的第一行的索引
		int column = e.getColumn();						// 获取选中列的列名
		if (row != -1) {
			String id = (String) table.getValueAt(row, 0);
			String name = (String) table.getValueAt(row, 1);
			String password = (String) table.getValueAt(row, 2);
			Student student = new Student();
			student.setId(id);
			student.setName(name);
			student.setPassword(password);
			if (table.getValueAt(row, column).equals("")) {
				JOptionPane.showMessageDialog(null, "此处不能为空哟！\n已恢复原样！\n请重新输入", "警告", JOptionPane.WARNING_MESSAGE);
				this.dispose();
				new UpdateStudentFrame().setVisible(true);
			} else {
				try {
// 添加管理员删除学生的日志
					Log log = new Log();
					log.setDate(new SimpleDateFormat("yyyy年MM月dd日").format(new Date()));
					log.setUserId(LoginFrame.managerId);
					log.setUserType("管理员");
					new LogSql().updateStudentLog(log);
					
					new ManagerImplements().updateStudent(student);
					JOptionPane.showMessageDialog(null, "已成功修改内容：" + (String) table.getValueAt(row, column));
				} catch (Exception exception) {
					System.out.println("管理员管理学生表格处发生错误！");
					JOptionPane.showConfirmDialog(null, "修改失败！", "警告", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
		
	}
}
