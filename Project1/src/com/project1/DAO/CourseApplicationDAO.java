package com.project1.DAO;
//인선dd
	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.Statement;
	import java.util.ArrayList;

	import com.project1.DTO.CurriculumDTO;
	import com.project1.DTO.StudentDTO;
	import com.project1.DTO.myCourseApplicationDTO;
	import com.project1.main.DBUtil;
	import com.project1.main.main;
	
	public class CourseApplicationDAO {
	   private Connection conn;
	   private static Statement stat;
	
	public  CourseApplicationDAO() { //디비 불러오기

	      try {

	         this.conn = DBUtil.open();
	         this.stat = conn.createStatement();

	      } catch (Exception e) {
	         System.out.println(e.toString());
	      }
	   }//method

	   
	/**
	 * 
	 * @return 수강신청 리스트 검색
	 */
	public ArrayList<StudentDTO> courseSearch(String searchWord) { //수강리스트 출력

		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();


		try {

			String sql = "SELECT * FROM CURRICULUM C INNER JOIN LECTURE_ROOM_ASSIGN LRA ON C.CURRICULUMCODE = LRA.CURRICULUMCODE INNER JOIN LECTURE_ROOM LR ON LR.LECTUREROOMCODE = LRA.LECTUREROOMCODE INNER JOIN PERIOD P ON C.CURRICULUMCODE = P.CURRICULUMCODE INNER JOIN DAY_OF_THE_WEEK DW ON DW.DAYCODE = P.DAYCODE INNER JOIN SEMESTER_CLASS SC ON SC.SEMESTERCODE = C.SEMESTERCODE INNER JOIN COURSE_APPLICATION CP ON C.CURRICULUMCODE = CP.CURRICULUMCODE INNER JOIN STUDENT S ON S.STUDENTNUMBER = CP.STUDENTNUMBER INNER JOIN DEPARTMENT D ON D.CLASSCODE = S.CLASSCODE INNER JOIN SUBJECT SJ ON SJ.SUBJECTCODE = C.SUBJECTCODE INNER JOIN FACULTY F ON F.STAFFCODE = C.STAFFCODE WHERE D.CLASSNAME  LIKE '%"+ searchWord +"%' OR SJ.SUBJECTNAME  LIKE '%"+ searchWord +"%' OR F.STAFFNAME  LIKE '%"+ searchWord +"%' ";

			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {

				StudentDTO dto = new StudentDTO();

				dto.setSubjectName(rs.getString("SUBJECTNAME"));
				dto.setClassName(rs.getString("CLASSNAME"));
				dto.setSubjectScore(rs.getString("SUBJECTSCORE"));
				dto.setPeriodNum(rs.getString("PERIODNUM"));
				dto.setPeople(rs.getString("PEOPLE"));
				dto.setDay(rs.getString("DAY"));
				dto.setClassCode(rs.getString("CLASSCODE"));
				dto.setStaffName(rs.getString("STAFFNAME"));
				dto.setLectureRoomName(rs.getString("LECTUREROOMNAME"));
				dto.setSubjectCode(rs.getString("SUBJECTCODE"));
				dto.setCurriculumCode(rs.getString("CURRICULUMCODE"));


				list.add(dto);


			}//while

			DBUtil.close();

		} catch (Exception e) {
			System.out.println(e.toString());



		}




		return list;
	}//courseSearch()

	
	
	

	/**
	 * 
	 * @return 내 수강신청 목록 호출
	 */
	
	public ArrayList<myCourseApplicationDTO> myCourse_list(){

		ArrayList<myCourseApplicationDTO> list = new ArrayList<myCourseApplicationDTO>();


			try {
				
				String sql = "SELECT S.SUBJECTNAME AS SUBJECTNAME, F.STAFFNAME AS STAFFNAME, S.SUBJECTSCORE AS SUBJECTSCORE, P.PERIODNUM AS PERIODNUM, DW.DAYCODE AS DAYCODE,LR.LECTUREROOMNAME AS LECTUREROOMNAME  FROM CURRICULUM C INNER JOIN SUBJECT S ON S.SUBJECTCODE = C.SUBJECTCODE INNER JOIN FACULTY F ON C.STAFFCODE  = F.STAFFCODE INNER JOIN LECTURE_ROOM_ASSIGN  LRA ON LRA.CURRICULUMCODE = C. CURRICULUMCODE INNER JOIN LECTURE_ROOM LR  ON LRA.LECTUREROOMCODE = LR.LECTUREROOMCODE INNER JOIN PERIOD P ON C.CURRICULUMCODE = P.CURRICULUMCODE INNER JOIN DAY_OF_THE_WEEK DW ON DW.DAYCODE = P.DAYCODE WHERE C.CURRICULUMCODE IN(SELECT CC.CURRICULUMCODE FROM SUBJECT ZZ	INNER JOIN CURRICULUM XX	ON ZZ.SUBJECTCODE = XX.SUBJECTCODE	INNER JOIN COURSE_APPLICATION CC	ON XX.CURRICULUMCODE = CC.CURRICULUMCODE INNER JOIN STUDENT AA ON CC.STUDENTNUMBER = AA.STUDENTNUMBER  WHERE CC.STUDENTNUMBER = " + main.userCode + ") ORDER BY DAYCODE,PERIODNUM";
				ResultSet rs = stat.executeQuery(sql);
				while (rs.next()) {

					myCourseApplicationDTO dto = new myCourseApplicationDTO();

					dto.setSubjectName(rs.getString("SUBJECTNAME"));//과목명
					dto.setStaffName(rs.getString("STAFFNAME"));//교수명
					dto.setSubjectScore(rs.getString("SUBJECTSCORE"));//과목학점
					dto.setPeriodNum(rs.getString("PERIODNUM"));//차수
					dto.setDayCode(rs.getString("DAYCODE"));//요일코드
					dto.setLectureName(rs.getString("LECTUREROOMNAME"));//요일코드
				


					list.add(dto);


				}//while


				DBUtil.close();

			} catch (Exception e) {
				System.out.println(e.toString());



			}




			return list;
		}//list()

	
	
	}//class

