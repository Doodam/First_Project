package edu.java.student.main;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.student.controller.StudentDaoImpl;
import edu.java.student.model.Student;
import edu.java.student.model.Student.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class StudentInsert extends JFrame {
	
	private final StudentDaoImpl dao = StudentDaoImpl.getInstance();
	private Component parent;
	private StudentHome app;
	
	private String gender;
	
	private JPanel contentPane;
	private JTextField Nametext;
	private JTextField Birthtext;
	private JTextField Addresstext;
	private JTextField Phonetext;
	private JTextField Emailtext;
	private JFrame frame;
	private JTextField Agetext;
	private JRadioButton ManRadioButton;
	private JRadioButton WomanButton;
	private ButtonGroup genderGroup = new ButtonGroup();
	private JRadioButton selectedGenderButton;
	
	

	/**
	 * Launch the application.
	 */
	public static void ShowInsert(Component parent, StudentHome app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentInsert frame = new StudentInsert(parent, app);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	

	
	
	public StudentInsert(Component parent, StudentHome app) {
		this.parent = parent;
		this.app = app;
		Studentinital();
	}
	
	
	public void Studentinital() {
		JFrame frame = new JFrame("학생등록");
		frame.setBackground(Color.WHITE);
		setTitle("학 생 등 록");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 420, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("학생 등록");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(152, 10, 137, 57);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		Nametext = new JTextField();
		Nametext.setBackground(UIManager.getColor("Button.disabledShadow"));
		Nametext.setBounds(49, 108, 200, 39);
		contentPane.add(Nametext);
		Nametext.setColumns(10);
		
		JLabel NameLabel = new JLabel("이 름");
		NameLabel.setForeground(Color.GRAY);
		NameLabel.setFont(new Font("굴림", Font.BOLD, 15));
		NameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		NameLabel.setBounds(12, 68, 81, 39);
		contentPane.add(NameLabel);
		
		JLabel BirthLabel = new JLabel("생 년 월 일");
		BirthLabel.setForeground(Color.GRAY);
		BirthLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		BirthLabel.setFont(new Font("굴림", Font.BOLD, 15));
		BirthLabel.setBounds(49, 157, 81, 39);
		contentPane.add(BirthLabel);
		
		JLabel AddressLabel = new JLabel("주 소");
		AddressLabel.setForeground(Color.GRAY);
		AddressLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		AddressLabel.setFont(new Font("굴림", Font.BOLD, 15));
		AddressLabel.setBounds(12, 243, 81, 39);
		contentPane.add(AddressLabel);
		
		JLabel PhoneLabel = new JLabel("휴 대 전 화");
		PhoneLabel.setForeground(Color.GRAY);
		PhoneLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		PhoneLabel.setFont(new Font("굴림", Font.BOLD, 15));
		PhoneLabel.setBounds(52, 332, 81, 39);
		contentPane.add(PhoneLabel);
		
		JLabel EmailLabel = new JLabel("이 메 일");
		EmailLabel.setForeground(Color.GRAY);
		EmailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		EmailLabel.setFont(new Font("굴림", Font.BOLD, 15));
		EmailLabel.setBounds(32, 419, 81, 39);
		contentPane.add(EmailLabel);
		
		Birthtext = new JTextField();
		Birthtext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ageCal();
			}
		});
		Birthtext.setColumns(10);
		Birthtext.setBounds(49, 194, 200, 39);
		contentPane.add(Birthtext);
	
		
		Agetext = new JTextField();
		Agetext.setFont(new Font("굴림", Font.PLAIN, 16));
		Agetext.setForeground(Color.BLACK);
		Agetext.setHorizontalAlignment(SwingConstants.CENTER);
		Agetext.setBounds(271, 194, 81, 39);
		contentPane.add(Agetext);
		Agetext.setColumns(10);
		
		Addresstext = new JTextField();
		Addresstext.setColumns(10);
		Addresstext.setBounds(49, 278, 297, 39);
		contentPane.add(Addresstext);
		
		Phonetext = new JTextField();
		Phonetext.setColumns(10);
		Phonetext.setBounds(49, 370, 297, 39);
		contentPane.add(Phonetext);
		
		Emailtext = new JTextField();
		Emailtext.setColumns(10);
		Emailtext.setBounds(49, 459, 297, 39);
		contentPane.add(Emailtext);
		JButton btnNewButton = new RoundButton("등 록");
		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertTable();
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 15));
		btnNewButton.setBounds(248, 522, 98, 48);
		contentPane.add(btnNewButton);

		ManRadioButton = new JRadioButton("남");
		genderGroup.add(ManRadioButton);
		ManRadioButton.setBounds(271, 112, 37, 23);
		contentPane.add(ManRadioButton);
		WomanButton = new JRadioButton("여");
		genderGroup.add(WomanButton);
		WomanButton.setBounds(322, 112, 37, 23);
		contentPane.add(WomanButton);
		
		JLabel NameLabel_1 = new JLabel("나 이");
		NameLabel_1.setForeground(Color.GRAY);
		NameLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		NameLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
		NameLabel_1.setBounds(229, 157, 81, 39);
		contentPane.add(NameLabel_1);

	}

	
	private void ageCal() {
		String Birtht = Birthtext.getText();
		try { 
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate birth = LocalDate.parse(Birtht, format);
			LocalDate today = LocalDate.now();
			int years = Period.between(birth, today).getYears();
			Agetext.setText(String.valueOf(years));
		
//		String formatbirth = birth.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			String formatbirth = birth.format(format);
			Birthtext.setText(formatbirth);
		} catch (DateTimeParseException e) {
			JOptionPane.showMessageDialog(this, "생년월일은 YYYY-MM-DD 형식으로 입력해주세요.");
		}
	}
	
	
	private void selectedGenderButton(String gender) {
		genderGroup = new ButtonGroup();
		ManRadioButton = new JRadioButton("남");
		WomanButton = new JRadioButton("여");
		genderGroup.add(ManRadioButton);
		genderGroup.add(WomanButton);
		

		if (gender.equals("남")) {
			ManRadioButton.setSelected(true);
		} else if (gender.equals("여")) {
			WomanButton.setSelected(true);
		}
	}

	
	
	

	private void insertTable() {
		
//		if (Birthtext != null) {
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			String dateString = sdf.format(Birthtext);
//		}
		
	
		
		String name = Nametext.getText().trim();
		String birth = Birthtext.getText().trim();
		String gender = "";
		String address = Addresstext.getText().trim();
		int age = Integer.parseInt(Agetext.getText());
		String phone = Phonetext.getText().trim();
		String email  = Emailtext.getText().trim();
		
		
		if(name.length() == 0 || birth.length() == 0 || address.length() == 0 || phone.length() == 0 || email.length() == 0) {
			JOptionPane.showMessageDialog(frame, "정보를 전부 입력해주세요.", "공백 작성", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		
		if(ManRadioButton.isSelected()) {
			gender = "남";
		} else if (WomanButton.isSelected()) {
			gender = "여";
		} 
		
//		if (Birthtext != null) {
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			String dateString = sdf.format(Birthtext);
//		}
		
		
		Student student = new Student(0, name, gender, birth, age, address, phone, email);
		
		int confirm = JOptionPane.showConfirmDialog(StudentInsert.this, "등록하시겠습니까?", "등록", JOptionPane.YES_NO_OPTION);
		if(confirm == JOptionPane.YES_OPTION) {
			dao.create(student);
			app.notifyCreate();
			dispose();
			
		}
		
		
	}
}
