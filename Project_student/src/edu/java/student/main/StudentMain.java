package edu.java.student.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

import edu.java.student.main.StudentHome.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class StudentMain  {

	private JFrame frame;
	private JLabel itwillIMG;
	private JLabel lblID;
	private JLabel lblPW;
	private JButton btnLogin;
	private JTextField textPW;
	private JTextField textID;


	/**
	 * Launch the application.                                                                                                                                
	 */
	public static void main(String[] args) {
	
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentMain window = new StudentMain();                                                                                                                                                           
					window.frame.setVisible(true);
//					Photo fullPanel = new Photo(
//							new ImageIcon("C:\\workspaces\\lab-java\\Project_Student\\Student img\\흰색배경.jpg")
//							.getImage());
//					fullPanel.setBounds(0,0, 539, 504);
					window.frame.getContentPane();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentMain() {
		initialize();
	}
                                                                                                                                                                                                                                                                  
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 553, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                                                                                                                                                                   
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setTitle("ITwill 학생 관리 프로그램");
		frame.getContentPane().setLayout(null);
			
		itwillIMG = new JLabel("로고");
		ImageIcon open = new ImageIcon("Student img/itwill.jpg");
		itwillIMG = new JLabel(open);
		itwillIMG.setBounds(60, 77, 407,146);
		frame.getContentPane().add(itwillIMG);
			
		lblID = new JLabel("아 이 디");
		lblID.setFont(new Font("굴림", Font.BOLD, 14));
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setBounds(71, 319, 63, 21);
		frame.getContentPane().add(lblID);
		
		textID = new JTextField();
		textID.setBounds(159, 312, 221, 31);
		frame.getContentPane().add(textID);
		textID.setColumns(10);
		
		lblPW = new JLabel("비 밀 번 호");
		lblPW.setHorizontalAlignment(SwingConstants.CENTER);
		lblPW.setFont(new Font("굴림", Font.BOLD, 14));
		lblPW.setBounds(60, 357, 74, 21);
		frame.getContentPane().add(lblPW);
		
		textPW = new JTextField();
		textPW.setColumns(10);
		textPW.setBounds(159, 350, 221, 31);
		frame.getContentPane().add(textPW);
		
		btnLogin = new RoundButton("로 그 인");
		btnLogin.setBackground(UIManager.getColor("textHighlight"));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logintest();
				
			}
		});
		btnLogin.setFont(new Font("굴림", Font.PLAIN, 15));
		btnLogin.setBounds(391, 312, 91, 66);
		
		frame.getContentPane().add(btnLogin);
		
	}

	private void logintest() {
		String id = textID.getText().trim();
		String pw = textPW.getText().trim();
		
		if(id.length() == 0 || pw.length() == 0) {
			JOptionPane.showMessageDialog(
					frame, 
					"아이디 또는 비밀번호를 입력하세요.", 
					"로그인 오류", 
					JOptionPane.WARNING_MESSAGE);
			return;
		} 
		if(id.equals("Ohteacher") && pw.equals("Oh1234")){
			
			JOptionPane.showMessageDialog(frame,"환영합니다.");
						frame.dispose();
						studenthome();
						
						
		} else {
			JOptionPane.showConfirmDialog(
					frame,
					"아이디 또는 비밀번호가 틀렸습니다.",
					"로그인 실패",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		
	
		
		
	}

	private void studenthome() {
		StudentHome.ShowHome();
		StudentHome sth = new StudentHome();
//		sth.setVisible(true);
		
	}

	
}
