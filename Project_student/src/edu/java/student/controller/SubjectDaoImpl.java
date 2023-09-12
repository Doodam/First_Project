package edu.java.student.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.java.student.model.Subject;

import static edu.java.student.model.Student.Entity.COL_SID;
import static edu.java.student.model.Student.Entity.TBL_NAME;
import static edu.java.student.model.Subject.Entity2.*;
import static edu.java.student.ojdbc.OracleConnect.*;
import oracle.jdbc.OracleDriver;
import oracle.jdbc.proxy.annotation.Pre;

public class SubjectDaoImpl implements SubjectDao {
	private final StudentDaoImpl dao1 = StudentDaoImpl.getInstance(); 
	
	
	private static SubjectDaoImpl instance2 = null;
	private SubjectDaoImpl() {}
	public static SubjectDaoImpl getInstance() {
		if(instance2 == null) {
			instance2 = new SubjectDaoImpl();
		}
		return instance2;
	}
	
	// SELECT * FROM SUBJECTINFO ORDER BY sid;
	private static final String SQL_SELECT_ALL2 =
			"SELECT * FROM " + TBL_NAME2 + " ORDER BY " + COL_JID;
	@Override // 전체 검색
	public List<Subject> read() {
		ArrayList<Subject> subject = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dao1.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_ALL2);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int jid = rs.getInt(COL_JID);
				String name2 = rs.getString(COL_NAME2);
				String teacher = rs.getString(COL_TEACHER);
				String sub1 = rs.getString(COL_SUB1);
				double score1 = rs.getDouble(COL_SCORE1);
				String sub2 = rs.getString(COL_SUB2);
				double score2 = rs.getDouble(COL_SCORE2);
				String sub3 = rs.getString(COL_SUB3);
				double score3 = rs.getDouble(COL_SCORE3);
				double avg = rs.getDouble(COL_AVG);
				
				Subject list = new Subject(jid, name2, teacher, sub1, score1, sub2, score2, sub3, score3, avg);
				subject.add(list);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dao1.closeRsrc(conn, stmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return subject;
	}

	// INSERT INTO SUBJECTINFO (NAME2, TEACHER, SUB1, SCORE1, 
	// 			SUB2, SCORE2, SUB3, SCORE3, AVG) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);
	private static final String SQL_INSERT = "INSERT INTO " +TBL_NAME2 + 
			" (" +COL_NAME2+ ", " +COL_TEACHER+ ", " +COL_SUB1+ ", " +COL_SCORE1+ ", " + COL_SUB2+ ", " +COL_SCORE2 + ", "
			+ COL_SUB3+ ", " +COL_SCORE3+ ", " +COL_AVG+ ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	@Override // 성적 등록
	public int jcreate(Subject subject) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = dao1.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, subject.getName2());
			stmt.setString(2, subject.getTeacher());
			stmt.setString(3, subject.getSub1());
			stmt.setDouble(4, subject.getScore1());
			stmt.setString(5, subject.getSub2());
			stmt.setDouble(6, subject.getScore2());
			stmt.setString(7, subject.getSub3());
			stmt.setDouble(8, subject.getScore3());
			stmt.setDouble(9, subject.getAvg());
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dao1.closeRsrc(conn, stmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// DELETE FROM SUBJECTINFO WHERE jid = ?
	private static final String SQL_DELETE = "DELETE FROM " +TBL_NAME2+ " WHERE " +COL_JID+ " = ?";
	@Override
	public int jdelect(Integer jid) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = dao1.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, jid);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dao1.closeRsrc(conn, stmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	//UPDATE SUBJECTINFO SET name2 = ?, teacher = ?, sub1 = ?, score1 = ?, sub2 = ?, score2 = ?,
	// 								 sub3 = ?, score3 = ?, avg = ? WHERE jid = ?;
	private static final String SQL_UPDATE2 = "UPDATE " +TBL_NAME2+ " SET " +COL_NAME2+ " = ?, "
			+ COL_TEACHER+" = ?, "+ COL_SUB1+" = ?, "+COL_SCORE1+ " = ?, "
			+COL_SUB2+" = ?, "+COL_SCORE2+" = ?, "+ COL_SUB3+" = ?, "+COL_SCORE3+" = ?, "+COL_AVG
			+"WHERE " +COL_JID + " = ?";
	public int update(Subject subject) {
		int result = 0;
		

		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = dao1.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE2);
			stmt.setString(1, subject.getName2());
			stmt.setString(2, subject.getTeacher());
			stmt.setString(3, subject.getSub1());
			stmt.setDouble(4, subject.getScore1());
			stmt.setString(5, subject.getSub2());
			stmt.setDouble(6, subject.getScore2());
			stmt.setString(7, subject.getSub3());
			stmt.setDouble(8, subject.getScore3());
			stmt.setDouble(9, subject.getAvg());
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dao1.closeRsrc(conn, stmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return  result;
	}
	
	
	
	private static final String SQL_DELETE2 = "DELETE FROM " +TBL_NAME+ " WHERE " +COL_JID+ " = ?";
	@Override
	public int delete2(Integer jid) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = dao1.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, jid)	;
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dao1.closeRsrc(conn, stmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		return result;
	}

	
//	"INSERT INTO " + SCORE_TABLE_NAME + " (score_id, student_id, subject_id, score) VALUES (?, ?, ?, ?)";
//	 student 와 subject 테이블 연결
//	private static final String SQL_number = "INSERT INTO SCORE (SEQ_SCORE.NEXTVAL, score_id, student_id, subject_id, score) VALUES (?, ?, ?)";
//	public void sqlPK (int studentId, int subjectId, int score) {
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		
//		try {
//			conn = dao1.getConnection();
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
//					dao1.closeRsrc(conn, stmt);
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
//	}
	
	

}
