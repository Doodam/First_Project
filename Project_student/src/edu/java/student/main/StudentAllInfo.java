package edu.java.student.main;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import edu.java.student.controller.StudentDaoImpl;
import edu.java.student.model.Student;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentAllInfo extends JFrame  {
	
	private Component parent;
	private int sid;
	private StudentHome app;
	private final StudentDaoImpl dao = StudentDaoImpl.getInstance();
	
	private JPanel contentPane;
	private JTextField Nametext2;
	private JTextField Birthtext2;
	private JTextField Addresstext2;
	private JTextField Phonetext2;
	private JTextField Emailtext2;
	private JRadioButton ManRadioButton;
	private JRadioButton WomanButton;
	private JTextField Agetext2;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void showStudentAllInfo(Component parent, int sid, StudentHome app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentAllInfo frame = new StudentAllInfo(parent, sid, app);
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
	
	public StudentAllInfo(Component parent, int sid, StudentHome app) {
		this.parent = parent;
		this.sid = sid;
		this.app = app;
		AllInfoinital();
		readStudent();
	}

	private void readStudent() {
		Student student = dao.read(sid);
		int age = student.getAge();
		
		Nametext2.setText(student.getName());
		Birthtext2.setText(student.getBirth());
		String gender = student.getGender();
		Addresstext2.setText(student.getAddress());
		Agetext2.setText(Integer.toString(age));
		Phonetext2.setText(student.getPhone());
		Emailtext2.setText(student.getEmail());
		
		
		if (gender.equals("남")) {
			ManRadioButton.setSelected(true);
		} else if (gender.equals("여")) {
			WomanButton.setSelected(true);
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	public void AllInfoinital() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 878, 678);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGkr = new JLabel("학 생 정 보");
		lblGkr.setHorizontalAlignment(SwingConstants.CENTER);
		lblGkr.setForeground(Color.BLACK);
		lblGkr.setFont(new Font("굴림", Font.BOLD, 20));
		lblGkr.setBounds(172, 20, 137, 57);
		contentPane.add(lblGkr);
		
		JLabel NameLabel = new JLabel("이 름");
		NameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		NameLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		NameLabel.setBounds(46, 72, 81, 39);
		contentPane.add(NameLabel);
		
		Nametext2 = new JTextField();
		Nametext2.setText((String) null);
		Nametext2.setColumns(10);
		Nametext2.setBounds(83, 108, 201, 39);
		contentPane.add(Nametext2);
		
		ManRadioButton = new JRadioButton("남");
		buttonGroup.add(ManRadioButton);
		ManRadioButton.setBounds(292, 113, 37, 23);
		contentPane.add(ManRadioButton);
		
		WomanButton = new JRadioButton("여");
		buttonGroup.add(WomanButton);
		WomanButton.setBounds(343, 113, 37, 23);
		contentPane.add(WomanButton);
		
		JLabel BirthLabel = new JLabel("생 년 월 일");
		BirthLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		BirthLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		BirthLabel.setBounds(83, 154, 81, 39);
		contentPane.add(BirthLabel);
		
		Birthtext2 = new JTextField();
		Birthtext2.setText((String) null);
		Birthtext2.setColumns(10);
		Birthtext2.setBounds(83, 203, 201, 39);
		contentPane.add(Birthtext2);
		
		JLabel AddressLabel = new JLabel("주 소");
		AddressLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		AddressLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		AddressLabel.setBounds(46, 252, 81, 39);
		contentPane.add(AddressLabel);
		
		Addresstext2 = new JTextField();
		Addresstext2.setText((String) null);
		Addresstext2.setColumns(10);
		Addresstext2.setBounds(83, 287, 297, 39);
		contentPane.add(Addresstext2);
		
		JLabel PhoneLabel = new JLabel("휴 대 전 화");
		PhoneLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		PhoneLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		PhoneLabel.setBounds(83, 336, 81, 39);
		contentPane.add(PhoneLabel);
		
		Phonetext2 = new JTextField();
		Phonetext2.setText((String) null);
		Phonetext2.setColumns(10);
		Phonetext2.setBounds(83, 385, 297, 39);
		contentPane.add(Phonetext2);
		
		JLabel EmailLabel = new JLabel("이 메 일");
		EmailLabel.setBackground(new Color(255, 255, 255));
		EmailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		EmailLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		EmailLabel.setBounds(66, 434, 81, 39);
		contentPane.add(EmailLabel);
		
		Emailtext2 = new JTextField();
		Emailtext2.setText((String) null);
		Emailtext2.setColumns(10);
		Emailtext2.setBounds(83, 483, 297, 39);
		contentPane.add(Emailtext2);
		
		Agetext2 = new JTextField();
		Agetext2.setHorizontalAlignment(SwingConstants.CENTER);
		Agetext2.setForeground(Color.BLACK);
		Agetext2.setFont(new Font("굴림", Font.PLAIN, 16));
		Agetext2.setColumns(10);
		Agetext2.setBounds(299, 203, 81, 39);
		contentPane.add(Agetext2);
		
		JButton InfoBT = new RoundButton("종 료");
		InfoBT.setBackground(new Color(230, 230, 250));
		InfoBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		InfoBT.setFont(new Font("굴림", Font.PLAIN, 15));
		InfoBT.setBounds(282, 546, 98, 48);
		contentPane.add(InfoBT);
	}
}
