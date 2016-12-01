package com.project1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import com.project1.DTO.StudentDTO;
import com.project1.main.DBUtil;



public class StudentDAO {

	private static final String String = null;
	private Connection conn;
	private Statement stat;


	public StudentDAO() { //디비 불러오기

		try {

			this.conn = DBUtil.open();
			this.stat = conn.createStatement();



		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}//디비 접속

	/**
	 * 
	 * @return 검색
	 */
	public ArrayList<StudentDTO> studentSearch() {

		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		try {



			String sql = " SELECT * FROM STUDENT";

			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {
				StudentDTO dto = new StudentDTO();
				dto.setStudentNumber(rs.getString("STUDENTNUMBER"));
				dto.setStudentName(rs.getString("STUDENTNAME"));
				dto.setPassword(rs.getString("PASSWORD"));
				dto.setEmail(rs.getString("EMAIL"));
				dto.setClassCode(rs.getString("CLASSCODE"));


				list.add(dto);
			}

			DBUtil.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return list;	


	}//studentSearch()
	
	/**
	 * 
	 * @param dto 수강삭제
	 */
	public static void delete(StudentDTO dto) {
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;

		String deleteSQL = "DELETE  FROM COURSE_APPLICATION WHERE LECTURECODE = ?";

		try {
			pstmt = conn.prepareStatement(deleteSQL);
			pstmt.setString(1,dto.getLectureCode());
			pstmt.executeUpdate();

			System.out.println("삭제완료!~");

			DBUtil.close();


		} catch (Exception e) {
			System.out.println(e.toString());
		}




	}//delete
	
	/**
	 * 
	 * @param Sdto 수강등록
	 */
	public static void add(StudentDTO Sdto) {

		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;

		String insertSQL =  "INSERT INTO COURSE_APPLICATION(LECTURECODE,CURRICULUMCODE,STUDENTNUMBER)"
				+ "VALUES("+ "31" + "|| LECTURECODE.NEXTVAL,?,?)";      

		try {
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1,Sdto.getCurriculumCode());
			pstmt.setString(2,Sdto.getStudentNumber());
			pstmt.executeUpdate();
			System.out.println("수강신청 완료");

			DBUtil.close();


		} catch (Exception e) {
			System.out.println(e.toString());
		}




	}//add






















}//studentDAO

