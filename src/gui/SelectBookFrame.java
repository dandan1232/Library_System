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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.StudentDao;
import entity.Book;
import entity.BookType;
import entity.Log;
import entity.Record;
import entity.Student;
import impl.StudentImplements;
import Table.BookTable;
import dao.BookTypeUtil;
import dao.BookUtil;
import Table.LogSql;

public class SelectBookFrame extends JFrame {

	JPanel contentPane;
	private JLabel lblDate;
	private JTextField textName;
	StudentDao studentDao = new StudentImplements();
	BookTypeUtil bookTypeUtil = new BookTypeUtil();
	private BookTable model;
	private JTable table;
	private List<Book> list;
	private JComboBox<Object> textType;
	static String bookTypeId;

	public SelectBookFrame() {
		setTitle("精确查找界面");
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
		setBounds(width / 2 - 800 / 2, height / 2 - 600 / 2, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(Color.ORANGE);
		setContentPane(contentPane);
		Font font = new Font("微软雅黑", Font.BOLD, 16);
// 两个子面板————————————————————————————————————————————————————————————————————————————————————	
		JPanel panelSelect = new JPanel();
		panelSelect.setLayout(null);
		panelSelect.setBounds(10, 10, 768, 140);
		panelSelect.setBorder(BorderFactory.createTitledBorder("精确查询条件处"));
		contentPane.add(panelSelect);

		JPanel panelResult = new JPanel();
		panelResult.setLayout(new BorderLayout());
		panelResult.setBounds(10, 160, 768, 345);
		panelResult.setBorder(BorderFactory.createTitledBorder("结果框"));
		contentPane.add(panelResult);


		lblDate = new JLabel();
		String text = new SimpleDateFormat("yyyy年MM月dd日").format(new Date());
		lblDate.setText(text);
		lblDate.setFont(new Font("隶书", Font.ITALIC, 18));
		lblDate.setBounds(10, 510, 200, 50);
		contentPane.add(lblDate);

		JLabel lblType = new JLabel("请选择图书类别：");
		lblType.setFont(font);
		lblType.setBounds(110, 20, 160, 23);
		panelSelect.add(lblType);

		List<String> bookTypeList = bookTypeUtil .getBookType();
		bookTypeList.add("");
		Object[] str = bookTypeList.toArray();
		textType = new JComboBox<Object>(str);
		textType.setFont(font);
		textType.setEditable(false);
		textType.setSelectedIndex(str.length - 1);
		bookTypeId = null;
		textType.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BookType bookType = new BookType();
				if (textType.getSelectedItem().equals("")) {
					return;
				} else {
					bookType.setName(textType.getSelectedItem().toString());
					BookUtil bookUtil = new BookUtil();
					bookTypeId = bookUtil.getIdByBookName(bookType);
				}
			}
		});
		textType.setBounds(310, 20, 160, 23);
		panelSelect.add(textType);

		JLabel lbl = new JLabel("您也可以选择");
		lbl.setFont(font);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setBounds(255, 60, 100, 23);
		panelSelect.add(lbl);

		JLabel lblName = new JLabel("   输入书的名字：");
		lblName.setFont(font);
		lblName.setBounds(110, 100, 160, 23);
		panelSelect.add(lblName);

		textName = new JTextField(10);
		textName.setFont(new Font("微软雅黑", Font.BOLD, 13));
		textName.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_btnSearch_actionPerformed(e);
			}
		});
		textName.setBounds(310, 100, 160, 23);
		panelSelect.add(textName);

		JButton btnSearch = new JButton("查找");
		btnSearch.setFont(font);
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_btnSearch_actionPerformed(e);
			}
		});
		btnSearch.setBounds(600, 15, 100, 50);
		panelSelect.add(btnSearch);

		JButton btnCancle = new JButton("返回");
		btnCancle.setFont(font);
		btnCancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new StudentMainFrame().setVisible(true);
			}
		});
		btnCancle.setBounds(675, 510, 100, 40);
		contentPane.add(btnCancle);

		/*插入book表*/
		JScrollPane scrollPane = new JScrollPane();
		model = new BookTable() {

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
			}
		};
		table = new JTable(model);
		scrollPane.setViewportView(table);
		panelResult.add(scrollPane);

		JButton btnBorrow = new JButton("借阅");
		btnBorrow.setFont(font);
		btnBorrow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_btnBorrow_actionPerformed(e);
			}
		});
		btnBorrow.setBounds(600, 80, 100, 50);
		panelSelect.add(btnBorrow);

	}

	protected void do_btnBorrow_actionPerformed(ActionEvent e) {
		int[] selectRows = table.getSelectedRows();// 获取选择列的索引
		if (selectRows.length>5) {
			JOptionPane.showMessageDialog(null, "您选择的书超过5本了啦！", "警告", JOptionPane.WARNING_MESSAGE);
		}else {
			for (int i = 0; i < selectRows.length; i++) {
				Student student = new Student();
				student.setId(LoginFrame.studentId);
				Book book = list.get(selectRows[i]);
				Record record = new Record();
				record.setStudentId(LoginFrame.studentId);
				record.setBookId(book.getId());
				record.setBorrowDate(lblDate.getText());
				if (studentDao.isBorrowed(student, book)) {
					JOptionPane.showMessageDialog(null, book.getName() + "书，您已经借阅过一本了，不能重复借阅哦！", "警告", JOptionPane.WARNING_MESSAGE);
				} else {
					// 添加学生借阅图书的日志信息
					Log log = new Log();
					log.setDate(new SimpleDateFormat("yyyy年MM月dd日").format(new Date()));
					log.setUserId(LoginFrame.studentId);
					log.setUserType("学生");
					log.setBookId(record.getBookId());
					log.setBorrowDate(record.getBorrowDate());
					new LogSql().borrowLog(log);
					studentDao.borrowBook(book, record);
					JOptionPane.showMessageDialog(null, book.getName() + "借阅成功！");
				}
			}
		}

		if (selectRows.length == 0) {
			JOptionPane.showMessageDialog(null, "您还没有选择要借阅的图书哟！", "警告", JOptionPane.WARNING_MESSAGE);
		}else{
			dispose();
			new SelectBookFrame().setVisible(true);
		}
	}

	protected void do_btnSearch_actionPerformed(ActionEvent e) {
		model.setRowCount(0);
		String name = textName.getText();
		Book book = new Book();
		book.setId(bookTypeId);
		book.setName(name);
		if (textName.getText().equals("")) {
			list = studentDao.selectBook(book);
		} else {
			list = studentDao.selectBook(book);
		}
		for (int i = 0; i < list.size(); i++) {
			Book b = list.get(i);
			model.addRow(new Object[] { b.getId(), b.getName(), b.getNum(), b.getTimes() });
		}
		if (model.getRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "未查找到信息！请重新出入");
			textType.setSelectedIndex(textType.getItemCount() - 1);
			bookTypeId = null;
			textName.setText("");
		}
	}


}
