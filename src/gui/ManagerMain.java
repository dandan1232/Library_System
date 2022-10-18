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
			setTitle("管理员界面");
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					String[] options = { "确定", "取消" };
					// 显示操作对话框
					int flag = JOptionPane.showOptionDialog(null, "确定要关闭此程序吗？", "确认关闭", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
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
			panelBook.setBorder(BorderFactory.createTitledBorder("图书管理："));
			panelBook.setBounds(170, 75, 1000, 560);
			panelBook.setLayout(null);
			con.add(panelBook);
	/*
	 * 两个分面板：
	 */
			JPanel panelBook1 = new JPanel();
			panelBook1.setBorder(BorderFactory.createTitledBorder("添加新图书："));
			panelBook1.setBounds(30, 40, 940, 150);
			panelBook1.setLayout(new FlowLayout(5, 5, 23));
			panelBook.add(panelBook1);

			JPanel panelBook2 = new JPanel();
			panelBook2.setBorder(BorderFactory.createTitledBorder("修改/删除图书信息(可直接进行修改)"));
			panelBook2.setBounds(30, 210, 940, 350);
			panelBook2.setLayout(new BorderLayout(0, 0));
			panelBook.add(panelBook2);
		//---------------------------------------------------------------------------------------------
			JLabel lblType = new JLabel("类别：");
			lblType.setFont(new Font("宋体", Font.BOLD, 16));
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

			JLabel jl7 = new JLabel("图书id：");
			jl7.setFont(new Font("宋体", Font.BOLD, 16));
			panelBook1.add(jl7);

			jt1 = new JTextField(15);
			panelBook1.add(jt1);

			JLabel jl8 = new JLabel("图书名称：");
			jl8.setFont(new Font("宋体", Font.BOLD, 16));
			panelBook1.add(jl8);

			jt2 = new JTextField(15);
			panelBook1.add(jt2);

			JLabel jl9 = new JLabel("图书数量：");
			jl9.setFont(new Font("宋体", Font.BOLD, 16));
			panelBook1.add(jl9);

			jt3 = new JTextField(15);
			panelBook1.add(jt3);

			JButton jb8 = new JButton("添   加");
			jb8.setFont(new Font("宋体", Font.PLAIN, 16));
			jb8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_jb8_actionPerformed(e);
				}
			});
			panelBook1.add(jb8);

			JButton jb10 = new JButton("删   除");
			jb10.setFont(new Font("微软雅黑", Font.PLAIN, 25));
			jb10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_jb10_actionLister(e);
				}
			});
			panelBook2.add(jb10,BorderLayout.SOUTH);


			/*插入book表*/
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

			JLabel jl1 = new JLabel("图书管理系统");
			jl1.setFont(new Font("微软雅黑", Font.BOLD, 50));
			jl1.setHorizontalAlignment(SwingConstants.LEFT);
			jl1.setBounds(0, 0, 320, 60);
			con.add(jl1);

			Manager manager = new Manager();
			manager.setId(LoginFrame.managerId);
			JLabel jl2 = new JLabel("欢迎您：      " + new ManagerImplements().getManagerName(manager));
			jl2.setFont(new Font("宋体", Font.PLAIN, 20));
			jl2.setHorizontalAlignment(SwingConstants.RIGHT);
			jl2.setBounds(600, 0, 400, 60);
			con.add(jl2);

			JLabel jl3 = new JLabel("图书");
			jl3.setFont(new Font("宋体", Font.BOLD, 30));
			jl3.setHorizontalAlignment(SwingConstants.RIGHT);
			jl3.setBounds(0, 60, 80, 40);
			con.add(jl3);

			JButton jb1 = new JButton("图书管理");
			jb1.setFont(new Font("宋体", Font.PLAIN, 20));
			jb1.setEnabled(false);
			jb1.setBounds(15, 100, 120, 40);
			con.add(jb1);

			JButton jb2 = new JButton("类别查询");
			jb2.setFont(new Font("宋体", Font.PLAIN, 20));
			jb2.setBounds(15, 150, 120, 40);
			jb2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					new BookTypeManager().setVisible(true);
				}
			});
			con.add(jb2);

			JLabel jl4 = new JLabel("读者");
			jl4.setFont(new Font("宋体", Font.BOLD, 30));
			jl4.setHorizontalAlignment(SwingConstants.RIGHT);
			jl4.setBounds(0, 200, 80, 40);
			con.add(jl4);

			JButton jb3 = new JButton("学生管理");
			jb3.setFont(new Font("宋体", Font.PLAIN, 20));
			jb3.setBounds(15, 250, 120, 40);
			jb3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new ManagerStudentFrame().setVisible(true);
				}
			});
		    con.add(jb3);

			JLabel jl5 = new JLabel("借还书");
			jl5.setFont(new Font("宋体", Font.BOLD, 30));
			jl5.setHorizontalAlignment(SwingConstants.RIGHT);
			jl5.setBounds(0, 300, 110, 40);
			con.add(jl5);

			JButton jb4 = new JButton("借阅记录");
			jb4.setFont(new Font("宋体", Font.PLAIN, 20));
			jb4.setBounds(15, 350, 120, 40);
			jb4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new RecordFrame().setVisible(true);
				}
			});
			con.add(jb4);

			JButton jb5 = new JButton("切换账号");
			jb5.setFont(new Font("宋体", Font.PLAIN, 16));
			jb5.setBounds(1070, 5, 100, 30);
			jb5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new LoginFrame().setVisible(true);
				}
			});
			con.add(jb5);

			JButton btnLog = new JButton("日志");
			btnLog.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new LogFrame().setVisible(true);
				}
			});
			btnLog.setFont(new Font("楷书", Font.PLAIN, 16));
			btnLog.setBounds(1070, 45, 100, 30);
			con.add(btnLog);

		}

	protected void do_jb8_actionPerformed(ActionEvent e) {
		if (bookTypeId == null || textType.getSelectedItem().equals("") || jt1.getText().equals("") || jt2.getText().equals("") || jt3.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "请先将想要添加的书的基本信息填写完整！", "警告", JOptionPane.WARNING_MESSAGE);
		} else if(jt3.getText().equals("-1")){
			JOptionPane.showMessageDialog(null, "谁家书导入是负数啊喂！！用点心！", "警告", JOptionPane.WARNING_MESSAGE);
		}else {
			Book book = new Book();
			book.setId(bookTypeId + jt1.getText());
			book.setName("《" + jt2.getText() + "》");
			if (new ManagerImplements().canAddBook(book)) {
				try {
					book.setNum(Integer.parseInt(jt3.getText()));
					if (Integer.parseInt(jt3.getText()) <= 0) {
						JOptionPane.showMessageDialog(null, "请正确输入数量", "警告", JOptionPane.WARNING_MESSAGE);
					}
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "请正确输入数量！", "警告", JOptionPane.WARNING_MESSAGE);
					jt3.setText("");
					return;
				}
				int num = new ManagerImplements().sava(book);
				if (num != 0) {
	// 添加管理员添加图书日志
					Log log = new Log();
					log.setDate(new SimpleDateFormat("yyyy年MM月dd日").format(new Date()));
					log.setUserId(LoginFrame.managerId);
					log.setUserType("管理员");
					log.setBookId(book.getId());
					log.setNum(book.getNum());
					new LogSql().addBookLog(log);

					JOptionPane.showMessageDialog(null, "添加成功", "提示", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					new ManagerMain().setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "添加失败", "警告", JOptionPane.WARNING_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "检测到此id已存在，无法继续使用！", "警告", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	/*
	 * 表格模型的动作监听方法：
	 */
		protected void do_model_tableChanged(TableModelEvent e) {
			int row = e.getFirstRow();								// 获取选中列的第一行的索引
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
// 添加管理员修改图书的日志信息
					Log log = new Log();
					log.setDate(new SimpleDateFormat("yyyy年MM月dd日").format(new Date()));
					log.setUserId(LoginFrame.managerId);
					log.setUserType("管理员");
					log.setBookId(book.getId());
					log.setNum(book.getNum());
					new LogSql().updateBookLog(log);
					new LogSql().updateBookNameLog(log);
					new LogSql().updateBookTimeLog(log);

					JOptionPane.showMessageDialog(null, book.getName() + "修改成功");
				} else {
					JOptionPane.showMessageDialog(null, book.getName() + "修改失败");
				}
			}
		}

		protected void do_jb10_actionLister(ActionEvent e) {
	// 规定每次删除图书时只能一行一行删除！
			int[] selectColumns = table.getSelectedRows();				// 获取选中行的索引
			Book book = list.get(selectColumns[0]);
			if (selectColumns.length != 1) {
				JOptionPane.showMessageDialog(null, "抱歉！每次只能选中一行删除书籍！", "警告", JOptionPane.WARNING_MESSAGE);
			} else {
	// 删除图书时先判断该图书有没有被人借走（若被人借走，则暂时不能删除书籍；反之）
				if (new RecordUtil().isDeleteBook(book)) {
					String[] options = { "确定", "取消" };
					int flag = JOptionPane.showOptionDialog(null, "确定要删除此书籍吗？", "确认关闭", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					if (flag == 0) {
						if (managerDao.delBook(book) == 1) {
							// 添加管理员删除图书的日志
							Log log = new Log();
							log.setDate(new SimpleDateFormat("yyyy年MM月dd日").format(new Date()));
							log.setUserId(LoginFrame.managerId);
							log.setUserType("管理员");
							log.setBookId(book.getId());
							log.setNum(book.getNum());
							new LogSql().deleteBookLog(log);
							JOptionPane.showMessageDialog(null, book.getName() + "删除成功！");
							this.dispose();
							new ManagerMain().setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "删除失败！");
						}
					} else {

					}
				} else {
					JOptionPane.showMessageDialog(null, "抱歉！此图书还存在未还现象！\n您暂时还不能删除该图书！", "警告", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
}
