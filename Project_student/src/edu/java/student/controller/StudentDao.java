package edu.java.student.controller;

import java.util.List;

import edu.java.student.model.Student;

public interface StudentDao {

		/**
		 * 학생 전체 검색.
		 * DB STUDENTINFO 테이블에 저장된 모든 연락처 정보를 검색.
		 * @return Student 타입을 원소로 갖는 List
		 */
	List<Student> read();
	
	/**
	 * DB STUDENTINFO 테이블에서 primary key로 연락처 정보를 검색.
	 * 
	 * @param sid 검색한 primary key
	 * @return sid가 존재하면 Student 타입 객체 리턴. sid가 없으면 null 리턴
	 */
	Student read(int sid);
	
	/**
	 * 주어진 검색어가 이름 또는 전화번호, 이메일에 포함된 연락처들을
	 * DB STUDENTINFO 테이블에서 검색해서 연락처 리스트를 리턴. 
	 * 검색어는 대/소문자 구별 X
	 * 
	 * @param keyword 검색어
	 * @return 검색 결과 리스트
	 */
	List<Student> read(String keyword);
	
	/**
	 * 연락처 정보를 DB의 STUDENTINFO 테이블에서 insert (등록)
	 * 
	 * @parm list 저장할 이름, 생년월일, 주소, 전화번호, 이메일 정보를 가지고 있는 객체
	 * @return DB테이블에 삽입된 행의 개수. 
	 */
	int create(Student list);
	
	/**
	 * Primary key에 해당하는 연락처 정보를 수정(업데이트)
	 * 
	 * @param list 수정할 연락처의 primary key(sid),
	 * 업데이트 할 이름, 생년월일, 주소, 전화번호, 이메일 정보를 저장한 객체.
	 * @return DB 테이블에서 업데이트 된 행의 개수.
	 */
	int update(Student list);
	
	/**
	 * Primary key(sid)에 해당하는 연락처 정보를 DB 테이블에서 삭제.
	 * 
	 * @param sid 삭제할 연락처의 PK
	 * @return 삭제된 행의 개수.
	 */
	int delete(Integer sid);
}
