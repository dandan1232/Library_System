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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dao.StudentDao;
import entity.Log;
import entity.Record;
import entity.Student;
import impl.StudentImplements;
import dao.BookUtil;
import Table.LogSql;
import Table.RecordTable;
import dao.RecordUtil;

public class ReturnBookFrame extends JFrame {

	private JPanel contentPane;
	StudentDao studentDao = new StudentImplements();
	private RecordTable model;
	private JTable table;
	private List<Record> list;
	public JLabel lblDate;

	public ReturnBookFrame() {
		setTitle("�黹ͼ�����");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter () {
			@Override
			public void windowClosing(WindowEvent e) {
				new StudentMainFrame().setVisible(true);
			}
		});
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		setBounds(width / 2 - 570 / 2, height / 2 - 400 / 2, 570, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(Color.ORANGE);
		setContentPane(contentPane);
		Font font = new Font("΢���ź�", Font.BOLD, 20);

		/*����record��*/
		JScrollPane scrollPane = new JScrollPane();
		model = new RecordTable();
		table = new JTable(model);
		Student student = new Student();
		student.setId(LoginFrame.studentId);
		list = studentDao.getRecord(student);
		for (int i = 0; i < list.size(); i++) {
			Record record = list.get(i);
			model.addRow(new Object[] { record.getStudentId(), record.getBookId(), record.getBorrowDate(), record.getReturnDate(), record.getStatus() });
		}
		scrollPane.setViewportView(table);
		scrollPane.setBounds(0, 0, 550, 250);
		contentPane.add(scrollPane);

		JButton btnReturn = new JButton("�黹ͼ��");
		btnReturn.setFont(font);
		btnReturn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_btnReturn_actionPerformed(e);
			}
		});
		btnReturn.setBounds(10, 300, 200, 50);
		contentPane.add(btnReturn);

		lblDate = new JLabel();
		lblDate.setFont(new Font("����", Font.ITALIC, 18));
		String text = new SimpleDateFormat("yyyy��MM��dd��").format(new Date());
		lblDate.setText(text);
		lblDate.setBounds(350, 250, 200, 50);
		contentPane.add(lblDate);

		JButton btnBack = new JButton("����");
		btnBack.setFont(font);
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new StudentMainFrame().setVisible(true);
			}
		});
		btnBack.setBounds(300, 300, 200, 50);
		contentPane.add(btnBack);

	}

	protected void do_btnReturn_actionPerformed(ActionEvent e) {
		int[] selectRows = table.getSelectedRows();
		if (selectRows.length == 0) {
			JOptionPane.showMessageDialog(null, "����ûѡ��Ҫ�黹��ͼ��Ӵ��", "����", JOptionPane.WARNING_MESSAGE);
		} else {
			for (int i =0; i < selectRows.length; i++) {
				Record record = list.get(selectRows[i]);
				record.setReturnDate(lblDate.getText());
				if (new RecordUtil().getStatus(record)) {
					// ���ѧ���黹ͼ����־
					Log log = new Log();
					log.setDate(new SimpleDateFormat("yyyy��MM��dd��").format(new Date()));
					log.setUserId(LoginFrame.studentId);
					log.setUserType("ѧ��");
					log.setBookId(record.getBookId());
					log.setReturnDate(record.getReturnDate());
					new LogSql().returnBookLog(log);
					studentDao.returnBook(record);

					JOptionPane.showMessageDialog(null, new BookUtil().getBookNameByRecord(record) + "��黹�ɹ���");
				} else {
					JOptionPane.showMessageDialog(null, new BookUtil().getBookNameByRecord(record) + "���Ѿ��黹�ɹ��ˣ������ظ��˲�����", "����", JOptionPane.WARNING_MESSAGE);
				}
			}
			dispose();
			new ReturnBookFrame().setVisible(true);
		}
	}
}
