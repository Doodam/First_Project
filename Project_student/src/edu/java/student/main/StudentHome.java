package edu.java.student.main;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.xml.transform.Source;

import edu.java.student.controller.StudentDaoImpl;
import edu.java.student.model.Student;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class StudentHome extends JFrame {
	
	private static final String[] COLUMN = {"번 호", "이 름", "생 년 월 일", "휴 대 전 화"};
	private final StudentDaoImpl dao = StudentDaoImpl.getInstance();
	private List<Student> studentlist;
	private DefaultTableModel model;

	private JFrame frame;
	private JPanel contentPane;
	private JTable table;
	private JTextField Searchtext;
	private JButton InsertBT;
	private JButton UpdateBT;
	private JButton DeleteBT;
	private JLabel LogoLabel;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JLabel LogoLabel_1;

	/**
	 * Launch the application.
	 */
	public static void ShowHome() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentHome frame = new StudentHome();
					frame.setVisible(true);
					frame.getContentPane();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void notifyUpdate() {
		TableModel();
		JOptionPane.showMessageDialog(frame, "수정되었습니다.");
	}
	
	public void notifyCreate() {
		TableModel();
		JOptionPane.showMessageDialog(frame, "저장되었습니다.");
	}
	

	private void loadData() {
		studentlist = dao.read();
		for (Student s : studentlist) {
			Object[] row = { s.getSid(), s.getName(), s.getBirth(), s.getPhone() };
			model.addRow(row);
		}
	}
	
	
	
	private void TableModel() {
		model = new DefaultTableModel(null, COLUMN);
		loadData();
		table.setModel(model);
	}
	
	
	/**
	 * Create the frame.
	 */
	StudentHome() {
		Homeinitial();
		loadData();
	}
	
	
	private void Homeinitial() {
		setTitle("홈 페 이 지");
		Frame frame = new JFrame("홈페이지");
		frame.setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 674);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel LogoLabel = new JLabel("New label");
		ImageIcon img = new ImageIcon("Student img/itwill22.jpg");
		contentPane.setLayout(null);
		LogoLabel_1 = new JLabel(img);
		LogoLabel_1.setBounds(31, 27, 116, 47);
		LogoLabel_1.setFont(new Font("굴림", Font.PLAIN, 12));
		LogoLabel_1.setText("LOGO");
		contentPane.add(LogoLabel_1);
		
		lblNewLabel = new JLabel("검 색");
		lblNewLabel.setBounds(45, 228, 56, 22);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		
		table = new JTable();
//		table.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				int row = table.getSelectedRow();
//				int col = studentlist.get(row).getSid();
//					StudentAllInfo.showStudentAllInfo(frame, col, StudentHome.this);
//
//			}
//		});
		table.setFont(new Font("굴림", Font.PLAIN, 13));
		table.setBounds(27, 239, 623, 248);
		model = new DefaultTableModel(null, COLUMN);
		table.setModel(model);	
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 301, 581, 324);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
//		contentPane.add(table);	
		
		Searchtext = new JTextField();
		Searchtext.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				DefaultTableModel obj = (DefaultTableModel) table.getModel();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(obj);
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(Searchtext.getText()));
			}
		});
		Searchtext.setBounds(127, 222, 374, 38);
		contentPane.add(Searchtext);
		Searchtext.setColumns(10);
		
		DeleteBT = new RoundButton("삭 제");
		DeleteBT.setBackground(new Color(230, 230, 250));
		DeleteBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteStudent();
			}
		});
		DeleteBT.setBounds(513, 220, 96, 38);
		DeleteBT.setFont(new Font("굴림", Font.PLAIN, 17));
		contentPane.add(DeleteBT);
		
		UpdateBT = new RoundButton("수 정");
		UpdateBT.setBackground(new Color(230, 230, 250));
		UpdateBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateStudent();
			}
		});
		UpdateBT.setBounds(380, 81, 109, 47);
		UpdateBT.setFont(new Font("굴림", Font.PLAIN, 17));
		contentPane.add(UpdateBT);
		
		InsertBT = new RoundButton("학생등록");
		InsertBT.setBackground(new Color(230, 230, 250));
		InsertBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentInsert.ShowInsert(frame, StudentHome.this);
			}
		});
		InsertBT.setBounds(501, 81, 109, 47);
		InsertBT.setFont(new Font("굴림", Font.PLAIN, 17));
		contentPane.add(InsertBT);
		
		JButton AllBT = new RoundButton("상세보기");
		AllBT.setBackground(new Color(230, 230, 250));
		AllBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				int col = studentlist.get(row).getSid();
					StudentAllInfo.showStudentAllInfo(frame, col, StudentHome.this);

			}
		});
		AllBT.setFont(new Font("굴림", Font.PLAIN, 17));
		AllBT.setBounds(259, 81, 109, 47);
		contentPane.add(AllBT);
		
		JButton btnNewButton = new RoundButton("로그아웃");
		btnNewButton.setBackground(new Color(255, 228, 225));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(frame, "로그아웃 하시겠습니까?", "로 그 아 웃", JOptionPane.YES_NO_OPTION);
				if(confirm == JOptionPane.YES_OPTION) {
					dispose();
					System.exit(0);
				}
			}
		});
		btnNewButton.setBounds(513, 10, 91, 35);
		contentPane.add(btnNewButton);
	}



	private void UpdateStudent() {
		int row = table.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(frame, "수정할 학생을 선택해주세요", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		int sid = studentlist.get(row).getSid();
		StudentUpdate.showStudentUpdate(frame, sid, StudentHome.this);
		
	}

	private void deleteStudent() {
		int row = table.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(frame, "삭제할 학생을 선택해주세요", "오류", JOptionPane.ERROR_MESSAGE);
			return;
		}
		int confirm = JOptionPane.showConfirmDialog(frame, "정말 삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION);
		if(confirm == JOptionPane.YES_OPTION) {
			int sid = studentlist.get(row).getSid();
			dao.delete(sid);
			model.removeRow(row);
			
			JOptionPane.showMessageDialog(frame, "삭제 완료");
		}
	}

	
}
