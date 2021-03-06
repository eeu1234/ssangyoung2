package com.project1.DAO;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.project1.DTO.CurriculumDTO;
import com.project1.main.DBUtil;
import com.project1.main.main;

public class CurriculumDAO {

	private Connection conn;
	private static Statement stat;


	public CurriculumDAO() { //디비 불러오기

		try {

			this.conn = DBUtil.open();
			this.stat = conn.createStatement();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}


	/**
	 * 
	 * @return 교육과정 출력
	 */
	public ArrayList<CurriculumDTO> list() { //교육과정 출력

		ArrayList<CurriculumDTO> list = new ArrayList<CurriculumDTO>();


		try {

			String sql = "SELECT * FROM CURRICULUM C INNER JOIN SUBJECT S ON C.SUBJECTCODE = S.SUBJECTCODE INNER JOIN DEPARTMENT D ON S.CLASSCODE = D.CLASSCODE INNER JOIN FACULTY F ON F.CLASSCODE = D.CLASSCODE INNER JOIN SEMESTER_CLASS SC ON SC.SEMESTERCODE = C.SEMESTERCODE INNER JOIN LECTURE_ROOM_ASSIGN LRA ON LRA.CURRICULUMCODE = C.CURRICULUMCODE INNER JOIN LECTURE_ROOM LR ON LR.LECTUREROOMCODE = LRA.LECTUREROOMCODE";

			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {

				CurriculumDTO dto = new CurriculumDTO();

				dto.setSubjectName(rs.getString("SUBJECTNAME"));
				dto.setClassName(rs.getString("CLASSNAME"));
				dto.setSubjectScore(rs.getString("SUBJECTSCORE"));
				dto.setPeriod(rs.getString("PERIOD"));
				dto.setSemester(rs.getString("SEMESTER"));
				dto.setEmail(rs.getString("EMAIL"));
				dto.setStaffName(rs.getString("STAFFNAME"));
				dto.setLectureRoomName(rs.getString("LECTUREROOMNAME"));


				list.add(dto);


			}//while


			DBUtil.close();

		} catch (Exception e) {
			System.out.println(e.toString());



		}




		return list;
	}//list()


	/**
	 * 
	 * @param name 교육과정 검색
	 * @return
	 */
	public ArrayList<CurriculumDTO > Curriculum_search(String word) {

		ArrayList<CurriculumDTO > list = new ArrayList<CurriculumDTO >();
		try {

		
			String sql = "SELECT * FROM CURRICULUM C INNER JOIN SUBJECT S ON C.SUBJECTCODE = S.SUBJECTCODE INNER JOIN DEPARTMENT D ON S.CLASSCODE = D.CLASSCODE INNER JOIN FACULTY F ON F.CLASSCODE = D.CLASSCODE INNER JOIN SEMESTER_CLASS SC ON SC.SEMESTERCODE = C.SEMESTERCODE WHERE D.CLASSNAME LIKE '%"+ word +"%' OR F.STAFFNAME LIKE '%"+ word +"%' OR S.SUBJECTNAME LIKE '%"+ word +"%'";
			ResultSet rs = stat.executeQuery(sql);


			while (rs.next()) {

				CurriculumDTO dto = new CurriculumDTO();

				dto.setSubjectName(rs.getString("SUBJECTNAME"));
				dto.setClassName(rs.getString("CLASSNAME"));
				dto.setSubjectScore(rs.getString("SUBJECTSCORE"));
				dto.setPeriod(rs.getString("PERIOD"));
				dto.setSemester(rs.getString("SEMESTER"));
				dto.setEmail(rs.getString("EMAIL"));
				dto.setStaffName(rs.getString("STAFFNAME"));


				list.add(dto);


			}//while


			DBUtil.close();

		} catch (Exception e) {
			System.out.println(e.toString());



		}




		return list;



	}//Curriculum_search

	/**
	 * 
	 * @return 로그인 ID 교원 교육과정 출력
	 */
	public ArrayList<CurriculumDTO > MyCurriculum() {

		ArrayList<CurriculumDTO > list = new ArrayList<CurriculumDTO >();
		try {

			

			
			String sql = "SELECT * FROM CURRICULUM C INNER JOIN SUBJECT S ON C.SUBJECTCODE = S.SUBJECTCODE INNER JOIN DEPARTMENT D ON S.CLASSCODE = D.CLASSCODE INNER JOIN FACULTY F ON F.CLASSCODE = D.CLASSCODE INNER JOIN SEMESTER_CLASS SC ON SC.SEMESTERCODE = C.SEMESTERCODE WHERE F.STAFFCODE = ' "+ main.userCode + "' ";
			ResultSet rs = stat.executeQuery(sql);


			while (rs.next()) {

				CurriculumDTO dto = new CurriculumDTO();

				dto.setSubjectName(rs.getString("SUBJECTNAME"));
				dto.setClassName(rs.getString("CLASSNAME"));
				dto.setSubjectScore(rs.getString("SUBJECTSCORE"));
				dto.setPeriod(rs.getString("PERIOD"));
				dto.setSemester(rs.getString("SEMESTER"));
				dto.setEmail(rs.getString("EMAIL"));
				dto.setStaffName(rs.getString("STAFFNAME"));
				
				


				list.add(dto);


			}//while


			DBUtil.close();

		} catch (Exception e) {
			System.out.println(e.toString());



		}




		return list;



	}//mycurriculum
	


}//curriculumDAO

