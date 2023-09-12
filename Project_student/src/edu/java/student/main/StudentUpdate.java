package edu.java.student.main;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.student.controller.StudentDaoImpl;
import edu.java.student.controller.SubjectDaoImpl;
import edu.java.student.model.Student;
import edu.java.student.model.Student.*;
import edu.java.student.model.Subject;
import edu.java.student.main.StudentInsert.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.ButtonGroup;
import java.awt.SystemColor;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class StudentUpdate extends JFrame {
	
	private static final String[] COLUMN2 = {"번호", "이름", "강의교수", "과목1", "점수1", "과목2", "점수2", "과목3", "점수3", "평균"};
	private DefaultTableModel model2;
	private List<Subject> subjectlist;
	private JFrame frame;
	private JPanel contentPane;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton selectedGenderButton;

	private Component parent;
	private int sid;
	private StudentHome app;
	private final StudentDaoImpl dao = StudentDaoImpl.getInstance();
	private final SubjectDaoImpl subDao = SubjectDaoImpl.getInstance();
	private String gender;
	private JTabbedPane tabbedPane;
	private JPanel UpDate;
	private JLabel NameLabel;
	private JTextField Nametext1;
	private JLabel BirthLabel;
	private JTextField Birthtext1;
	private JLabel AddressLabel;
	private JTextField Addresstext1;
	private JLabel PhoneLabel;
	private JTextField Phonetext1;
	private JLabel EmailLabel;
	private JTextField Emailtext1;
	private JButton UpdateBT;
	private JLabel Label;
	private JRadioButton ManRadioButton;
	private JRadioButton WomanButton;
	private JTextField Agetext1;
	private JButton CancelBT;
	private JPanel Score;
	private JTextField Name2text;
	private JComboBox Sub2comboBox;
	private JComboBox Sub3comboBox;
	private JTextField Teachertext;
	private JTextField Sub1text;
	private JTextField Sub2text;
	private JTextField Sub3text;
	private JTextField Avgtext;
	private JButton SaveButton;
	private JTable Subjecttable;
	private JScrollPane SubjectscrollPane;
	private JComboBox Sub1comboBox;
	private JButton ScoreResultBT;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void showStudentUpdate(Component parent, int sid, StudentHome app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentUpdate frame = new StudentUpdate(parent, sid, app);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void notifyCreate2() {
//		TableModel2();
		model2 = new DefaultTableModel(null, COLUMN2);
		loadData2();
		Subjecttable.setModel(model2);
		
		JOptionPane.showMessageDialog(frame, "저장되었습니다.");
		
	}
	
//	private void TableModel2() {
//	
//		model2 = new DefaultTableModel(null, COLUMN2);
//		loadData2();
//		Subjecttable.setModel(model2);
//		
//	}
	
	private void loadData2() {
		subjectlist = subDao.read();
		for (Subject s : subjectlist) {
			Object[] row = { s.getJid(), s.getName2(), s.getTeacher(), s.getSub1(), s.getScore1(),
							 s.getSub2(), s.getScore2(), s.getSub3(), s.getScore3(), s.getAvg()};
			model2.addRow(row);
		}
	
	}
	
	

	/**
	 * Create the frame.
	 */
	public StudentUpdate(Component parent, int sid, StudentHome app) {
		setBackground(new Color(255, 255, 255));
		this.parent = parent;
		this.sid = sid;
		this.app = app;
		Updateinital();
		readStudent();
	}
	
	
	private void readStudent() {
	
		Student student = dao.read(sid);
		
		
	if (student != null) {	
		Integer age = student.getAge();
		Nametext1.setText(student.getName());
		Birthtext1.setText(student.getBirth());
		String gender = student.getGender();
		Addresstext1.setText(student.getAddress());
		Agetext1.setText(Integer.toString(age));
		Phonetext1.setText(student.getPhone());
		Emailtext1.setText(student.getEmail());
		
		if (gender != null) {
			if (gender.equals("남")) {
				ManRadioButton.setSelected(true);
			} else if (gender.equals("여")) {
				WomanButton.setSelected(true);
			}
	}
	
		
		}
	}
	
	
	public void Updateinital() {	
		
		
		setTitle("수 정 하 기");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		setBounds(100, 100, 983, 636);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 969, 599);
		contentPane.add(tabbedPane);
		
		UpDate = new JPanel();
		UpDate.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("학생정보", null, UpDate, null);
		UpDate.setLayout(null);
		
		NameLabel = new JLabel("이 름");
		NameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		NameLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		NameLabel.setBounds(67, 63, 81, 39);
		UpDate.add(NameLabel);
		
		Nametext1 = new JTextField();
		Nametext1.setColumns(10);
		Nametext1.setBounds(107, 100, 201, 39);
		UpDate.add(Nametext1);
		
		BirthLabel = new JLabel("생 년 월 일");
		BirthLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		BirthLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		BirthLabel.setBounds(102, 136, 81, 39);
		UpDate.add(BirthLabel);
		
		Birthtext1 = new JTextField();
		Birthtext1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ageCal2();
			}
		});
		Birthtext1.setColumns(10);
		Birthtext1.setBounds(107, 169, 201, 39);
		UpDate.add(Birthtext1);
		
		AddressLabel = new JLabel("주 소");
		AddressLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		AddressLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		AddressLabel.setBounds(67, 204, 81, 39);
		UpDate.add(AddressLabel);
		
		Addresstext1 = new JTextField();
		Addresstext1.setColumns(10);
		Addresstext1.setBounds(107, 239, 301, 39);
		UpDate.add(Addresstext1);
		
		PhoneLabel = new JLabel("휴 대 전 화");
		PhoneLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		PhoneLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		PhoneLabel.setBounds(102, 280, 81, 39);
		UpDate.add(PhoneLabel);
		
		Phonetext1 = new JTextField();
		Phonetext1.setColumns(10);
		Phonetext1.setBounds(107, 320, 301, 39);
		UpDate.add(Phonetext1);
		
		EmailLabel = new JLabel("이 메 일");
		EmailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		EmailLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		EmailLabel.setBounds(85, 364, 81, 39);
		UpDate.add(EmailLabel);
		
		Emailtext1 = new JTextField();
		Emailtext1.setColumns(10);
		Emailtext1.setBounds(107, 399, 301, 39);
		UpDate.add(Emailtext1);
		
		UpdateBT = new RoundButton("수 정");
		UpdateBT.setBackground(new Color(230, 230, 250));
		UpdateBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateStudent();
			}
		});
		UpdateBT.setFont(new Font("굴림", Font.PLAIN, 15));
		UpdateBT.setBounds(310, 465, 98, 48);
		UpDate.add(UpdateBT);
		
		Label = new JLabel("수 정 하 기");
		Label.setHorizontalAlignment(SwingConstants.CENTER);
		Label.setForeground(Color.BLACK);
		Label.setFont(new Font("굴림", Font.BOLD, 20));
		Label.setBounds(183, 10, 137, 57);
		UpDate.add(Label);
		
		ManRadioButton = new JRadioButton("남");
		buttonGroup.add(ManRadioButton);
		ManRadioButton.setBounds(327, 108, 37, 23);
		UpDate.add(ManRadioButton);
		
		WomanButton = new JRadioButton("여");
		buttonGroup.add(WomanButton);
		WomanButton.setBounds(368, 108, 37, 23);
		UpDate.add(WomanButton);
		
		Agetext1 = new JTextField();
		Agetext1.setHorizontalAlignment(SwingConstants.CENTER);
		Agetext1.setForeground(Color.BLACK);
		Agetext1.setFont(new Font("굴림", Font.PLAIN, 16));
		Agetext1.setColumns(10);
		Agetext1.setBounds(327, 168, 81, 39);
		UpDate.add(Agetext1);
		
		CancelBT = new RoundButton("취 소");
		CancelBT.setBackground(new Color(230, 230, 250));
		CancelBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		CancelBT.setFont(new Font("굴림", Font.PLAIN, 15));
		CancelBT.setBounds(188, 465, 98, 48);
		UpDate.add(CancelBT);
		
		Score = new JPanel();
		Score.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("성적", null, Score, null);
		Score.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("과 목 1");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(46, 200, 65, 35);
		Score.add(lblNewLabel_1_1);
		
		
		Sub1comboBox = new JComboBox();
		Sub1comboBox.setBounds(123, 200, 146, 35);
		Score.add(Sub1comboBox);

		
		JLabel lblNewLabel_1 = new JLabel("이 름");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(47, 81, 65, 35);
		Score.add(lblNewLabel_1);
		
		Name2text = new JTextField();
		Name2text.setColumns(10);
		Name2text.setBounds(125, 81, 234, 35);
		Score.add(Name2text);
		
		Sub2comboBox = new JComboBox();
		Sub2comboBox.setBounds(124, 245, 146, 35);
		Score.add(Sub2comboBox);
		
		JLabel lblNewLabel_1_2 = new JLabel("과 목 2");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(47, 245, 65, 35);
		Score.add(lblNewLabel_1_2);
		
		Sub3comboBox = new JComboBox();
		Sub3comboBox.setBounds(124, 291, 146, 35);
		Score.add(Sub3comboBox);
		
		String[] subjects = {"Java" , "SQL", "HTML", "CSS", "Java Script", "Python"};
		for(String s : subjects) {
			Sub1comboBox.addItem(s);
			Sub2comboBox.addItem(s);
			Sub3comboBox.addItem(s);
		};
		
		JLabel lblNewLabel_1_3 = new JLabel("과 목 3");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setBounds(47, 291, 65, 35);
		Score.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2 = new JLabel("강 의 교 수");
		lblNewLabel_2.setBounds(48, 126, 65, 35);
		Score.add(lblNewLabel_2);
		
		Teachertext = new JTextField();
		Teachertext.setColumns(10);
		Teachertext.setBounds(125, 126, 234, 35);
		Score.add(Teachertext);
		
		Sub1text = new JTextField();
		Sub1text.setBounds(281, 200, 78, 35);
		Score.add(Sub1text);
		Sub1text.setColumns(10);
		
		Sub2text = new JTextField();
		Sub2text.setColumns(10);
		Sub2text.setBounds(281, 245, 78, 35);
		Score.add(Sub2text);
		
		Sub3text = new JTextField();
		Sub3text.setColumns(10);
		Sub3text.setBounds(281, 291, 78, 35);
		Score.add(Sub3text);
		
		JLabel lblNewLabel_3 = new JLabel("평 균");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(48, 377, 65, 35);
		Score.add(lblNewLabel_3);
		
		Avgtext = new JTextField();
		Avgtext.setColumns(10);
		Avgtext.setBounds(123, 377, 146, 35);
		Score.add(Avgtext);
		
		SaveButton = new RoundButton("저 장");
		SaveButton.setBackground(new Color(230, 230, 250));
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveScore();
			}
		});
		SaveButton.setBounds(268, 474, 91, 53);
		Score.add(SaveButton);
		
//		Subjecttable = new JTable();
		DefaultTableModel model2 = new DefaultTableModel(null, COLUMN2);	
		Subjecttable = new JTable(model2);
		JScrollPane SubjectscrollPane = new JScrollPane(Subjecttable);
		SubjectscrollPane.setBounds(412, 96, 518, 346);
		
		Score.add(SubjectscrollPane);
		

		
		

//		SubjectscrollPane.setViewportView(Subjecttable);

//		Score.add(Subjecttable);
		
		JLabel lblNewLabel_4 = new JLabel("성 적 기 록");
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(116, 24, 171, 47);
		Score.add(lblNewLabel_4);
		
		JButton deleteButton2 = new RoundButton("삭 제");
		deleteButton2.setBackground(new Color(230, 230, 250));
		deleteButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteSubject();
				
			}
		});
		deleteButton2.setBounds(817, 33, 91, 53);
		Score.add(deleteButton2);
		
		ScoreResultBT = new RoundButton("결 과");
		ScoreResultBT.setBackground(new Color(255, 222, 173));
		ScoreResultBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				averageCalculator();
			}
		});
		ScoreResultBT.setBounds(281, 377, 78, 35);
		Score.add(ScoreResultBT);
		
		JButton ExitBT = new RoundButton("종 료");
		ExitBT.setBackground(new Color(230, 230, 250));
		ExitBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		ExitBT.setBounds(817, 474, 91, 53);
		Score.add(ExitBT);
		
	
		
	}

	

	

	private void deleteSubject() {
		int row = Subjecttable.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(frame, "삭제할 목록을 선택해주세요", "오류", JOptionPane.ERROR_MESSAGE);
			return;
		}
		int confirm = JOptionPane.showConfirmDialog(frame, "정말 삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION);
		if(confirm == JOptionPane.YES_OPTION) {
			int jid = subjectlist.get(row).getJid();
			subDao.delete2(jid);
			model2.removeRow(row);
			
			JOptionPane.showMessageDialog(frame, "삭제 완료");
		}
	}

	private void saveScore() {
		String name2 = Name2text.getText().trim();
		String Teacher = Teachertext.getText().trim();
		String sub1 = Sub1comboBox.getSelectedItem().toString();
		Double score1 = Double.parseDouble(Sub1text.getText().trim());
		String sub2 = Sub2comboBox.getSelectedItem().toString();
		Double score2 = Double.parseDouble(Sub2text.getText().trim());
		String sub3 = Sub3comboBox.getSelectedItem().toString();
		Double score3 = Double.parseDouble(Sub3text.getText().trim());
		Double average = Double.parseDouble(Avgtext.getText().trim());
		
		Subject subject = new Subject(0, name2, Teacher, sub1, score1, sub2, score2, sub3, score3, average);
		
		subDao.jcreate(subject);
		notifyCreate2();
		
	
	
	}

	private void averageCalculator() {
		double number1 = 0;
		double number2 = 0;
		double number3 = 0;
		
		try {
		number1 = Double.parseDouble(Sub1text.getText());
		number2 = Double.parseDouble(Sub2text.getText());
		number3 = Double.parseDouble(Sub3text.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "숫자만 입력해주세요.");
			return;
		}
		
		double result = (number1+number2+number3) / 3.0;
		result = Math.round(result * 100.0) / 100.0;
		
		Avgtext.setText(Double.toString(result));
	}

	private void ageCal2() {
		String Birtht = Birthtext1.getText();
		try {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate birth = LocalDate.parse(Birtht, format);
			LocalDate today = LocalDate.now();
			int years = Period.between(birth, today).getYears();
			Agetext1.setText(String.valueOf(years));
//			String formatbirth = birth.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			String formatbirth = birth.format(format);
			Birthtext1.setText(formatbirth);
		} catch (DateTimeParseException e) {
			JOptionPane.showMessageDialog(this, "생년월일은 YYYY-MM-DD 형식으로 입력해주세요.");
		}
		
		
	}
	
	private void UpdateStudent() {
		Student student = dao.read(sid);
		

		String name = Nametext1.getText();
		String birth = Birthtext1.getText();
		String gender = "";
		String address = Addresstext1.getText();
		int age = Integer.parseInt(Agetext1.getText());
		String phone = Phonetext1.getText();
		String email  = Emailtext1.getText();
		
		if(ManRadioButton.isSelected()) {
			selectedGenderButton = ManRadioButton;
			gender = "남";
		} else {
			selectedGenderButton = WomanButton;
			gender = "여";
		}
		


		Student list = new Student(sid, name, gender, birth, age, address, phone, email);
		int confirm = JOptionPane.showConfirmDialog(StudentUpdate.this, "수정하시겠습니까?", "수정", JOptionPane.YES_NO_OPTION);
		if(confirm == JOptionPane.YES_OPTION) {
			try {
				dao.update(list);
				app.notifyUpdate();
				dispose();
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(StudentUpdate.this, "수정을 실패했습니다. 다시 시도해주세요.");
			}
		}
		
	}
}

	
