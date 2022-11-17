package gui;

import java.awt.BorderLayout;
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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dao.StudentDao;
import entity.Book;
import entity.Log;
import entity.Record;
import entity.Student;
import impl.StudentImplements;
import Table.BackgroundPanel;
import Table.BookTable;
import dao.BookUtil;
import Table.LogSql;

public class StudentMainFrame extends JFrame {

	private JPanel contentPane;
	private StudentDao studentDao = new StudentImplements();
	private JLabel lblDate;
	private BookTable model;
	private JTable table;
	private List<Book> list;


	public StudentMainFrame() {
		setTitle("学生界面");
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
		setBounds(width / 2 - 1000 / 2, height / 2 - 600 / 2, 1000, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(Color.PINK);
		setContentPane(contentPane);
		Font font = new Font("微软雅黑", Font.BOLD, 16);

		// 存放表格的面板
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("全部图书（可直接借阅）"));
		panel.setLayout(new BorderLayout(10, 10));
		panel.setBounds(220, 10, 750, 540);
		contentPane.add(panel);
		// 存放功能按钮的面板
		JPanel panelFunction = new JPanel();
		panelFunction.setLayout(null);
		panelFunction.setBorder(BorderFactory.createTitledBorder("功能面板"));
		panelFunction.setBounds(10, 10, 200, 260);
		contentPane.add(panelFunction);
		// 存放图片的面板
		BackgroundPanel backgroundPanel = new BackgroundPanel();
//		backgroundPanel.setImage(getToolkit().getImage(getClass().getResource("http://pic-ldd-test.oss-cn-hangzhou.aliyuncs.com/a.jpg")));
		backgroundPanel.setImage(getToolkit().getImage(getClass().getResource("/image/励志图.jpg")));
		backgroundPanel.setBounds(10, 230, 200, 320);
		backgroundPanel.setBackground(Color.cyan);
		contentPane.add(backgroundPanel);


		JButton btnSearch = new JButton("精确查找书籍");
		btnSearch.setFont(font);
		btnSearch.setBounds(10, 15, 180, 50);
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectBookFrame().setVisible(true);
				dispose();
			}
		});
		panelFunction.add(btnSearch);

		JButton btnReturn = new JButton("查看并归还图书");
		btnReturn.setFont(font);
		btnReturn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ReturnBookFrame().setVisible(true);
				dispose();
			}
		});
		btnReturn.setBounds(10, 75, 180, 50);
		panelFunction.add(btnReturn);

		JButton btnLogOut = new JButton("切换账号");
		btnLogOut.setFont(font);
		btnLogOut.setBounds(10, 200, 180, 50);
		btnLogOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginFrame().setVisible(true);
			}
		});
		panelFunction.add(btnLogOut);

		model = new BookTable() {

			private static final long serialVersionUID = 1L;

			@Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
			}
		};
		table = new JTable(model);
		list = new BookUtil().selectAllBook();
		for (int i = 0; i < list.size(); i++) {
			Book book = list.get(i);
			model.addRow(new Object[] { book.getId(), book.getName(), book.getNum(), book.getTimes() });
		}


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		panel.add(scrollPane);

		JButton btnBorrow = new JButton("借阅");
		btnBorrow.setFont(font);
		btnBorrow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_btnBorrow_actionPerformed(e);
			}
		});
		btnBorrow.setBounds(10, 135, 180, 50);
		panelFunction.add(btnBorrow);

		lblDate = new JLabel();
		String text = new SimpleDateFormat("yyyy年MM月dd日").format(new Date());
		lblDate.setText(text);
		lblDate.setFont(new Font("隶书", Font.ITALIC, 18));
		lblDate.setBounds(340, 250, 200, 50);
		contentPane.add(lblDate);
	}

	protected void do_btnBorrow_actionPerformed(ActionEvent e) {
		int[] selectRows = table.getSelectedRows();				// 获取选择列的索引
		Student student = new Student();
		student.setId(LoginFrame.studentId);
		if (selectRows.length>5) {
			JOptionPane.showMessageDialog(null, "您选择的书超过5本了啦！", "警告", JOptionPane.WARNING_MESSAGE);
			dispose();
			new StudentMainFrame().setVisible(true);
		}else{
			for (int i = 0; i < selectRows.length; i++) {
				Book book = list.get(selectRows[i]);
				Record record = new Record();
				record.setStudentId(LoginFrame.studentId);
				record.setBookId(book.getId());
				record.setBorrowDate(lblDate.getText());
				if (studentDao.isBorrowed(student, book)) {
					JOptionPane.showMessageDialog(null, book.getName() + "书，您已经借阅过一本了，不能重复借阅哦！", "警告", JOptionPane.WARNING_MESSAGE);
				} else {
					if (studentDao.borrowBook(book, record)) {
						// 添加学生借阅图书的日志信息
						Log log = new Log();
						log.setDate(new SimpleDateFormat("yyyy年MM月dd日").format(new Date()));
						log.setUserId(LoginFrame.studentId);
						log.setUserType("学生");
						log.setBookId(record.getBookId());
						log.setBorrowDate(record.getBorrowDate());
						new LogSql().borrowLog(log);
						JOptionPane.showMessageDialog(null, book.getName() + "借阅成功！");

					} else {
						JOptionPane.showMessageDialog(null, book.getName() + "库存不足,可联系蛋蛋管理员进行添加哦！");
					}
				}
			}
		}

		if (selectRows.length == 0) {
			JOptionPane.showMessageDialog(null, "您还没有选择要借阅的图书哟！", "警告", JOptionPane.WARNING_MESSAGE);
		}else{
			dispose();
			new StudentMainFrame().setVisible(true);
			repaint();
		}
	}
}
