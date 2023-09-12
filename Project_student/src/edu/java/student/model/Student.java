package edu.java.student.model;

import java.io.Serializable;

public class Student implements Serializable {

	public interface Entity {
		String TBL_NAME = "STUDENTINFO"; // 테이블 이름
		String COL_SID = "SID"; // PK
		String COL_NAME = "NAME";	// 이름
		String COL_GENDER = "GENDER"; // 성별
		String COL_BIRTH = "BIRTH";	// 생년월일
		String COL_AGE = "AGE";	// 나이
		String COL_ADDRESS = "ADDRESS"; // 주소
		String COL_PHONE = "PHONE";	// 휴대전화
		String COL_EMAIL = "EMAIL"; // 이메일
	}
	
	private int sid; 
	private String name;
	private String gender;
	private String birth;
	private int age;
	private String address;
	private String phone;
	private String email;
	
	public Student() {}

	public Student(int sid, String name, String gender, String birth, int age, String address, String phone, String email) {
		super();
		this.sid = sid;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
		this.age = age;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getAddress() {
		return address;
	}

	public void setAdress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}



	@Override
	public String toString() {
		return String.format("Student(sid=%d, name=%s, gender=%s, birth=%s, age=%s, address=%s, phone=%s, email=%s",
							sid, name, gender, birth, age, address, phone, email);
	}
	
}
