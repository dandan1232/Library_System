package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import dao.ManagerDao;
import entity.Book;
import entity.BookType;
import entity.Log;
import entity.Manager;
import impl.ManagerImplements;
import Table.BookTable;
import dao.BookTypeUtil;
import dao.BookUtil;
import Table.LogSql;
import dao.RecordUtil;

public class ManagerMain extends JFrame{


	boolean b1 = false;
	boolean b2 = false;
	private JTable table;
	private BookTable model;
	private JTextField jt1, jt2, jt3;
	private List<Book> list = null;
	private ManagerDao managerDao = new ManagerImplements();

	private Container con;
	private JScrollPane jsl;
	private JPanel panelBook;
	private JComboBox<Object> textType;
	private String bookTypeId = null;

		ManagerMain() {
			setTitle("����Ա����");
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					String[] options = { "ȷ��", "ȡ��" };
					// ��ʾ�����Ի���
					int flag = JOptionPane.showOptionDialog(null, "ȷ��Ҫ�رմ˳�����", "ȷ�Ϲر�", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					if (flag == 0) {
						setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					} else {
						setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					}
				}
			});
			Toolkit kit = Toolkit.getDefaultToolkit();
			Dimension screenSize = kit.getScreenSize();
			int width = screenSize.width;
			int height = screenSize.height;
			setBounds(width / 2 - 1200 / 2, height / 2 - 700 / 2, 1200, 700);
			setResizable(false);
			setLayout(null);
			con = getContentPane();

			panelBook = new JPanel();
			panelBook.setBorder(BorderFactory.createTitledBorder("ͼ�����"));
			panelBook.setBounds(170, 75, 1000, 560);
			panelBook.setLayout(null);
			con.add(panelBook);
	/*
	 * ��������壺
	 */
			JPanel panelBook1 = new JPanel();
			panelBook1.setBorder(BorderFactory.createTitledBorder("�����ͼ�飺"));
			panelBook1.setBounds(30, 40, 940, 150);
			panelBook1.setLayout(new FlowLayout(5, 5, 23));
			panelBook.add(panelBook1);

			JPanel panelBook2 = new JPanel();
			panelBook2.setBorder(BorderFactory.createTitledBorder("�޸�/ɾ��ͼ����Ϣ(��ֱ�ӽ����޸�)"));
			panelBook2.setBounds(30, 210, 940, 350);
			panelBook2.setLayout(new BorderLayout(0, 0));
			panelBook.add(panelBook2);
		//---------------------------------------------------------------------------------------------
			JLabel lblType = new JLabel("���");
			lblType.setFont(new Font("����", Font.BOLD, 16));
			lblType.setBounds(120, 10, 140, 23);
			panelBook1.add(lblType);

			List<String> bookTypeList = new BookTypeUtil().getBookType();
			bookTypeList.add("");
			Object[] str = bookTypeList.toArray();
			textType = new JComboBox<Object>(str);
			textType.setEditable(false);
			textType.setSelectedIndex(str.length - 1);
			bookTypeId = null;
			textType.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (textType.getSelectedIndex() == str.length - 1) {
						return;
					} else {
						BookType bookType = new BookType();
						bookType.setName(textType.getSelectedItem().toString());
						BookUtil bookUtil = new BookUtil();
						bookTypeId = bookUtil.getIdByBookName(bookType);
					}
				}
			});
			panelBook1.add(textType);

			JLabel jl7 = new JLabel("ͼ��id��");
			jl7.setFont(new Font("����", Font.BOLD, 16));
			panelBook1.add(jl7);

			jt1 = new JTextField(15);
			panelBook1.add(jt1);

			JLabel jl8 = new JLabel("ͼ�����ƣ�");
			jl8.setFont(new Font("����", Font.BOLD, 16));
			panelBook1.add(jl8);

			jt2 = new JTextField(15);
			panelBook1.add(jt2);

			JLabel jl9 = new JLabel("ͼ��������");
			jl9.setFont(new Font("����", Font.BOLD, 16));
			panelBook1.add(jl9);

			jt3 = new JTextField(15);
			panelBook1.add(jt3);

			JButton jb8 = new JButton("��   ��");
			jb8.setFont(new Font("����", Font.PLAIN, 16));
			jb8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_jb8_actionPerformed(e);
				}
			});
			panelBook1.add(jb8);

			JButton jb10 = new JButton("ɾ   ��");
			jb10.setFont(new Font("΢���ź�", Font.PLAIN, 25));
			jb10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_jb10_actionLister(e);
				}
			});
			panelBook2.add(jb10,BorderLayout.SOUTH);


			/*����book��*/
			jsl = new JScrollPane();
			model = new BookTable();
			list = new BookUtil().selectAllBook();
			table = new JTable(model);
			for(int i = 0; i < list.size(); i++) {
				Book book = list.get(i);
				Object[] a = { book.getId(), book.getName(), book.getNum(), book.getTimes()};
				model.addRow(a);
			}
			model.addTableModelListener(new TableModelListener() {
				@Override
				public void tableChanged(TableModelEvent e){
					do_model_tableChanged(e);
				}
			});
			jsl.setViewportView(table);
			panelBook2.add(jsl);

			JLabel jl1 = new JLabel("ͼ�����ϵͳ");
			jl1.setFont(new Font("΢���ź�", Font.BOLD, 50));
			jl1.setHorizontalAlignment(SwingConstants.LEFT);
			jl1.setBounds(0, 0, 320, 60);
			con.add(jl1);

			Manager manager = new Manager();
			manager.setId(LoginFrame.managerId);
			JLabel jl2 = new JLabel("��ӭ����      " + new ManagerImplements().getManagerName(manager));
			jl2.setFont(new Font("����", Font.PLAIN, 20));
			jl2.setHorizontalAlignment(SwingConstants.RIGHT);
			jl2.setBounds(600, 0, 400, 60);
			con.add(jl2);

			JLabel jl3 = new JLabel("ͼ��");
			jl3.setFont(new Font("����", Font.BOLD, 30));
			jl3.setHorizontalAlignment(SwingConstants.RIGHT);
			jl3.setBounds(0, 60, 80, 40);
			con.add(jl3);

			JButton jb1 = new JButton("ͼ�����");
			jb1.setFont(new Font("����", Font.PLAIN, 20));
			jb1.setEnabled(false);
			jb1.setBounds(15, 100, 120, 40);
			con.add(jb1);

			JButton jb2 = new JButton("����ѯ");
			jb2.setFont(new Font("����", Font.PLAIN, 20));
			jb2.setBounds(15, 150, 120, 40);
			jb2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					new BookTypeManager().setVisible(true);
				}
			});
			con.add(jb2);

			JLabel jl4 = new JLabel("����");
			jl4.setFont(new Font("����", Font.BOLD, 30));
			jl4.setHorizontalAlignment(SwingConstants.RIGHT);
			jl4.setBounds(0, 200, 80, 40);
			con.add(jl4);

			JButton jb3 = new JButton("ѧ������");
			jb3.setFont(new Font("����", Font.PLAIN, 20));
			jb3.setBounds(15, 250, 120, 40);
			jb3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new ManagerStudentFrame().setVisible(true);
				}
			});
		    con.add(jb3);

			JLabel jl5 = new JLabel("�軹��");
			jl5.setFont(new Font("����", Font.BOLD, 30));
			jl5.setHorizontalAlignment(SwingConstants.RIGHT);
			jl5.setBounds(0, 300, 110, 40);
			con.add(jl5);

			JButton jb4 = new JButton("���ļ�¼");
			jb4.setFont(new Font("����", Font.PLAIN, 20));
			jb4.setBounds(15, 350, 120, 40);
			jb4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new RecordFrame().setVisible(true);
				}
			});
			con.add(jb4);

			JButton jb5 = new JButton("�л��˺�");
			jb5.setFont(new Font("����", Font.PLAIN, 16));
			jb5.setBounds(1070, 5, 100, 30);
			jb5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new LoginFrame().setVisible(true);
				}
			});
			con.add(jb5);

			JButton btnLog = new JButton("��־");
			btnLog.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new LogFrame().setVisible(true);
				}
			});
			btnLog.setFont(new Font("����", Font.PLAIN, 16));
			btnLog.setBounds(1070, 45, 100, 30);
			con.add(btnLog);

		}

	protected void do_jb8_actionPerformed(ActionEvent e) {
		if (bookTypeId == null || textType.getSelectedItem().equals("") || jt1.getText().equals("") || jt2.getText().equals("") || jt3.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "���Ƚ���Ҫ��ӵ���Ļ�����Ϣ��д������", "����", JOptionPane.WARNING_MESSAGE);
		} else if(jt3.getText().equals("-1")){
			JOptionPane.showMessageDialog(null, "˭���鵼���Ǹ�����ι�����õ��ģ�", "����", JOptionPane.WARNING_MESSAGE);
		}else {
			Book book = new Book();
			book.setId(bookTypeId + jt1.getText());
			book.setName("��" + jt2.getText() + "��");
			if (new ManagerImplements().canAddBook(book)) {
				try {
					book.setNum(Integer.parseInt(jt3.getText()));
					if (Integer.parseInt(jt3.getText()) <= 0) {
						JOptionPane.showMessageDialog(null, "����ȷ��������", "����", JOptionPane.WARNING_MESSAGE);
					}
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "����ȷ����������", "����", JOptionPane.WARNING_MESSAGE);
					jt3.setText("");
					return;
				}
				int num = new ManagerImplements().sava(book);
				if (num != 0) {
	// ��ӹ���Ա���ͼ����־
					Log log = new Log();
					log.setDate(new SimpleDateFormat("yyyy��MM��dd��").format(new Date()));
					log.setUserId(LoginFrame.managerId);
					log.setUserType("����Ա");
					log.setBookId(book.getId());
					log.setNum(book.getNum());
					new LogSql().addBookLog(log);

					JOptionPane.showMessageDialog(null, "��ӳɹ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					new ManagerMain().setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "���ʧ��", "����", JOptionPane.WARNING_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "��⵽��id�Ѵ��ڣ��޷�����ʹ�ã�", "����", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	/*
	 * ���ģ�͵Ķ�������������
	 */
		protected void do_model_tableChanged(TableModelEvent e) {
			int row = e.getFirstRow();								// ��ȡѡ���еĵ�һ�е�����
			if (row != -1) {
				String id = (String) table.getValueAt(row, 0);
				String name = (String) table.getValueAt(row, 1);
				Integer num = (Integer) table.getValueAt(row, 2);
				int times = (Integer) table.getValueAt(row, 3);
				Book book = new Book();
				book.setId(id);
				book.setName(name);
				book.setNum(num);
				book.setTimes(times);
				if (new ManagerImplements().updateBook(book) == 1) {
// ��ӹ���Ա�޸�ͼ�����־��Ϣ
					Log log = new Log();
					log.setDate(new SimpleDateFormat("yyyy��MM��dd��").format(new Date()));
					log.setUserId(LoginFrame.managerId);
					log.setUserType("����Ա");
					log.setBookId(book.getId());
					log.setNum(book.getNum());
					new LogSql().updateBookLog(log);
					new LogSql().updateBookNameLog(log);
					new LogSql().updateBookTimeLog(log);

					JOptionPane.showMessageDialog(null, book.getName() + "�޸ĳɹ�");
				} else {
					JOptionPane.showMessageDialog(null, book.getName() + "�޸�ʧ��");
				}
			}
		}

		protected void do_jb10_actionLister(ActionEvent e) {
	// �涨ÿ��ɾ��ͼ��ʱֻ��һ��һ��ɾ����
			int[] selectColumns = table.getSelectedRows();				// ��ȡѡ���е�����
			Book book = list.get(selectColumns[0]);
			if (selectColumns.length != 1) {
				JOptionPane.showMessageDialog(null, "��Ǹ��ÿ��ֻ��ѡ��һ��ɾ���鼮��", "����", JOptionPane.WARNING_MESSAGE);
			} else {
	// ɾ��ͼ��ʱ���жϸ�ͼ����û�б��˽��ߣ������˽��ߣ�����ʱ����ɾ���鼮����֮��
				if (new RecordUtil().isDeleteBook(book)) {
					String[] options = { "ȷ��", "ȡ��" };
					int flag = JOptionPane.showOptionDialog(null, "ȷ��Ҫɾ�����鼮��", "ȷ�Ϲر�", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					if (flag == 0) {
						if (managerDao.delBook(book) == 1) {
							// ��ӹ���Աɾ��ͼ�����־
							Log log = new Log();
							log.setDate(new SimpleDateFormat("yyyy��MM��dd��").format(new Date()));
							log.setUserId(LoginFrame.managerId);
							log.setUserType("����Ա");
							log.setBookId(book.getId());
							log.setNum(book.getNum());
							new LogSql().deleteBookLog(log);
							JOptionPane.showMessageDialog(null, book.getName() + "ɾ���ɹ���");
							this.dispose();
							new ManagerMain().setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
						}
					} else {

					}
				} else {
					JOptionPane.showMessageDialog(null, "��Ǹ����ͼ�黹����δ������\n����ʱ������ɾ����ͼ�飡", "����", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
}
