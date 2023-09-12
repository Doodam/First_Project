package edu.java.student.controller;

import java.util.List;

import edu.java.student.model.Student;
import edu.java.student.model.Subject;

public interface SubjectDao {

	/**
	 * 성적 전체 조회
	 * DB SUBJECTINFO 테이블에 저장된 성적 검색
	 * @return Subject 타입을 원소로 갖는 List
	 */
	List<Subject> read();
	
	
	/**
	 * 작성한 성적을 DB 테이블에 insert
	 * @param subject 저장할 이름. 기수, 이름, 강사, 과목1, 점수1, 과목2, 점수2, 과목3, 점수3, 평균 정보
	 * @return DB테이블에 삽입된 행의 개수.
	 */
	int jcreate(Subject subject);
	
	
	/**
	 * Primary key에 해당하는 정보를 DB 테이블에서 삭제.
	 * @param jid 삭제할 PK
	 * @return 삭제된 행의 개수.
	 */
	int jdelect(Integer jid);
	
	
	int update(Subject subject);
	
	int delete2(Integer jid);
		
}
