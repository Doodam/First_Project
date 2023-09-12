package edu.java.student.model;

import java.io.Serializable;

public class Subject implements Serializable{
	
	public interface Entity2 {
	String TBL_NAME2 = "SUBJECTINFO";
	String COL_JID = "jid";
	String COL_NAME2 = "NAME2";
	String COL_TEACHER = "TEACHER";
	String COL_SUB1 = "SUB1";
	String COL_SCORE1 = "SCORE1";
	String COL_SUB2 = "SUB2";
	String COL_SCORE2 = "SCORE2";
	String COL_SUB3 = "SUB3";
	String COL_SCORE3 = "SCORE3";
	String COL_AVG = "AVG";
	}
	
	private int jid;
	private String name2;
	private String teacher;
	private String sub1;
	private double score1;
	private String sub2;
	private double score2;
	private String sub3;
	private double score3;
	private double avg;
	
	public Subject() {}

	public Subject(int jid, String name2, String teacher, String sub1, double score1, String sub2, double score2,
			String sub3, double score3, double avg) {
		super();
		this.jid = jid;
		this.name2 = name2;
		this.teacher = teacher;
		this.sub1 = sub1;
		this.score1 = score1;
		this.sub2 = sub2;
		this.score2 = score2;
		this.sub3 = sub3;
		this.score3 = score3;
		this.avg = avg;
	}

	public int getJid() {
		return jid;
	}

	public void setJid(int jid) {
		this.jid = jid;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getSub1() {
		return sub1;
	}

	public void setSub1(String sub1) {
		this.sub1 = sub1;
	}

	public double getScore1() {
		return score1;
	}

	public void setScore1(double score1) {
		this.score1 = score1;
	}

	public String getSub2() {
		return sub2;
	}

	public void setSub2(String sub2) {
		this.sub2 = sub2;
	}

	public double getScore2() {
		return score2;
	}

	public void setScore2(double score2) {
		this.score2 = score2;
	}

	public String getSub3() {
		return sub3;
	}

	public void setSub3(String sub3) {
		this.sub3 = sub3;
	}

	public double getScore3() {
		return score3;
	}

	public void setScore3(double score3) {
		this.score3 = score3;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	
	
	
	
	
	
}
