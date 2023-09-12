package edu.java.student.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;

import edu.java.student.model.Student;
import static edu.java.student.model.Student.Entity.*;
import static edu.java.student.ojdbc.OracleConnect.*;
import oracle.jdbc.OracleDriver;

public class StudentDaoImpl implements StudentDao {
	
	// Singleton 
	private static StudentDaoImpl instance = null;
	private StudentDaoImpl() {}
	public static StudentDaoImpl getInstance() {
		if(instance == null) {
			instance = new StudentDaoImpl();
		}
		return instance;
	}
	
	// 오라클 DB접속
	protected Connection getConnection() throws SQLException {
		DriverManager.registerDriver(new OracleDriver());
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		return conn;
	}
	// closeRsrc (conn , stmt)
	protected void closeRsrc(Connection conn, Statement stmt) throws SQLException {
		stmt.close();
		conn.close();
	}
	// closeRsrc (conn, stmt, rs)
	protected void closeRsrc(Connection conn,  Statement stmt, ResultSet rs) throws SQLException {
		rs.close();
		closeRsrc(conn, stmt);
	}
	
	
	// SELECT * FROM STUDENTINFO ORDER BY sid
	private static final String SQL_SELECT_ALL = 
			"SELECT * FROM " + TBL_NAME + " ORDER BY " + COL_SID;
	@Override // 전체 검색
	public List<Student> read() {
		ArrayList<Student> lists = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	try {	
		conn = getConnection();
		stmt = conn.prepareStatement(SQL_SELECT_ALL);
		rs = stmt.executeQuery();
		while(rs.next()) {
			int sid = rs.getInt(COL_SID);
			String name = rs.getString(COL_NAME);
			String gender = rs.getString(COL_GENDER);
			String birth = rs.getString(COL_BIRTH);
			int age = rs.getInt(COL_AGE);
			String address = rs.getString(COL_ADDRESS);
			String phone = rs.getString(COL_PHONE);
			String email = rs.getString(COL_EMAIL);
			
			Student list = new Student(sid, name, gender, birth, age, address, phone, email);
			lists.add(list);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeRsrc(conn, stmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		return lists;
	}
	
	// SELECT * FROM STUDENTINFO WHERE SID = ?
	private static final String SQL_SELECT_BY_ID =
			"SELECT * FROM " + TBL_NAME + " WHERE " + COL_SID + " = ?";
	@Override // sid로 학생 검색
	public Student read(int sid) {
		Student list = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			stmt.setInt(1, sid);
			rs = stmt.executeQuery();
			if(rs.next()) {
				int id = rs.getInt(COL_SID);
				String name = rs.getString(COL_NAME);
				String gender = rs.getString(COL_GENDER);
				String birth = rs.getString(COL_BIRTH);
				int age = rs.getInt(COL_AGE);
				String address = rs.getString(COL_ADDRESS);
				String phone = rs.getString(COL_PHONE);
				String email = rs.getString(COL_EMAIL);
				
				list = new Student(sid, name, gender, birth, age, address, phone, email);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeRsrc(conn, stmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	// SELECT * FROM STUDENTINFO WHERE LOWER(NAME) LIKE LOWER('?') ORDER BY sid;
	private static final String SQL_SELECT_BY_KEYWORD =
			"SELECT * FROM STUDENTINFO " + "WHERE LOWER(NAME) LIKE LOWER(?) " + "ORDER BY SID";
	@Override
	public List<Student> read(String keyword) {
		ArrayList<Student> search = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_BY_KEYWORD);
			String key = "%" + keyword + "%";
			System.out.println("keyword = " + keyword + ", ket = " + key);
			
			stmt.setString(1, key);
			stmt.setString(2, key);
			stmt.setString(3, key);
			
			rs = stmt.executeQuery();
			while(rs.next()){
				int sid = rs.getInt(COL_SID);
				String name = rs.getString(COL_NAME);
				String gender = rs.getString(COL_GENDER);
				String birth = rs.getString(COL_BIRTH);
				int age = rs.getInt(COL_AGE);
				String address = rs.getString(COL_ADDRESS);
				String phone = rs.getString(COL_PHONE);
				String email = rs.getString(COL_EMAIL);
				
				Student list = new Student(sid, name, gender, birth, age, address, phone, email); 
				search.add(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeRsrc(conn, stmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return search;
	}
	
	// INSERT INTO STUDENTINFO (NAME, BIRTH, GENDER, ADDRESS, AGE, PHONE, EMAIL) VALUES (?, ?, ?, ?, ?);
	private static final String SQL_INSERT = "INSERT INTO " +TBL_NAME 
			+ " (" +COL_NAME+ ", " +COL_BIRTH+ ", " +COL_GENDER+ ", "+COL_ADDRESS+ ", " +COL_AGE+ ", " +COL_PHONE+ ", " +COL_EMAIL+ ") VALUES (?, ?, ?, ?, ?, ?, ?)";
	@Override
	public int create(Student list) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, list.getName());
			stmt.setString(2, list.getBirth());
			stmt.setString(3, list.getGender());
			stmt.setString(4, list.getAddress());
			stmt.setInt(5, list.getAge());
			stmt.setString(6, list.getPhone());
			stmt.setString(7, list.getEmail());
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeRsrc(conn, stmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}
	
	// UPDATE STUDENTINFO SET name = ?, birth = ?, gender = ?, address = ?, age = ?, phone = ?, email = ? WHERE sid = ?;
	private static final String SQL_UPDATE = "UPDATE " + TBL_NAME+ " SET " 
			+COL_NAME+" = ?, " +COL_BIRTH+ " = ?, " +COL_GENDER+ " = ?, "+COL_ADDRESS+ " = ?, "
			+COL_AGE+ " = ?, "+ COL_PHONE+ " = ?, " +COL_EMAIL+ " = ? " + "WHERE " +COL_SID + " = ?";

	@Override
	public int update(Student list) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, list.getName());
			stmt.setString(2, list.getBirth());
			stmt.setString(3, list.getGender());
			stmt.setString(4, list.getAddress());
			stmt.setInt(5, list.getAge());
			stmt.setString(6, list.getPhone());
			stmt.setString(7, list.getEmail());
			stmt.setInt(8, list.getSid());
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeRsrc(conn, stmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	
	// DELETE FROM STUDENTINFO WHERE sid = ?
	private static final String SQL_DELETE = "DELETE FROM " +TBL_NAME+ " WHERE " +COL_SID+ " = ?";
	@Override
	public int delete(Integer sid) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, sid)	;
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeRsrc(conn, stmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		return result;
	}

	
	
//	private static final String SQL_number = "INSERT INTO SCORE (score_id, student_id, subject_id, score) VALUES (? ,?, ?, ?)";
//	private static final String SQL_number1 = "INSERT INTO SCORE (score_id, student_id, subject_id, score) VALUES (score_id_seq.nextval, ?, ?, ?)";
	
	//	public void sqlPK (int studentId, int subjectId, int score) {
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		
//		try {
//			conn = getConnection();
//			stmt = conn.prepareStatement(SQL_number);
//			
//			stmt.setInt(1, studentId);
//			stmt.setInt(2, subjectId);
//			stmt.setInt(3, score);
//			
//			stmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (conn != null || stmt != null) {
//					closeRsrc(conn, stmt);
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
		
//	}
	
}
