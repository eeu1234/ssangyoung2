package com.project1.DAO;

	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.Statement;
	import java.util.ArrayList;

	import com.project1.DTO.CurriculumDTO;
import com.project1.DTO.StudentDTO;
import com.project1.main.DBUtil;

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


				list.add(dto);


			}//while

			DBUtil.close();

		} catch (Exception e) {
			System.out.println(e.toString());



		}




		return list;
	}//courseSearch()

	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	   
	
	}//class

