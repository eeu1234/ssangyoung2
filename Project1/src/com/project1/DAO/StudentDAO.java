package com.project1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import com.project1.DTO.StudentDTO;
import com.project1.main.DBUtil;
import com.project1.main.main;


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
	 * @param dto 수강신청
	 */
	public  void add(StudentDTO dto){

		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;
		try {         
			String sql = "INSERT INTO COURSE_APPLICATION(LECTURECODE,CURRICULUMCODE,STUDENTNUMBER)"
					+ "VALUES("+ "31" + "|| LECTURECODE.NEXTVAL,?,?)";                                                 

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1,dto.getCurriculumCode());
			pstmt.setString(2,dto.getStudentNumber());

			int aa =  pstmt.executeUpdate();
			if(aa !=0){
				System.out.println("수강 신청 완료");
				DBUtil.close();  
			}else{
				System.out.println("실패");
			}
			DBUtil.close();  
		} catch (Exception e) {
			//System.out.println("dao add 메서드 catch");
			System.out.println(e.toString());
		}
	}//add



	public void Delete(StudentDTO dto){
		System.out.println("메롱");
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;   
		
		try {
			String sql  = "DELETE  FROM COURSE_APPLICATION WHERE LECTURECODE = ?";      
			System.out.println(sql);      
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dto.getLectureCode());
			
			int val =  pstmt.executeUpdate();   
			if(val != 0 ){
				System.out.println("삭제가 완료 되었습니다 ");      
			}else{
				System.out.println("삭제가 안되었습니다 ");
			}
			DBUtil.close();            
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
	}//lectureRoomDelete   

























}//studentDAO

