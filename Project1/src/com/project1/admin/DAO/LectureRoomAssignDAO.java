package com.project1.admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.project1.admin.DTO.LectureRoomAssignDTO;
import com.project1.admin.DTO.LectureRoomDTO;
import com.project1.admin.DTO.PeriodDTO;


public class LectureRoomAssignDAO {
	public ArrayList<LectureRoomAssignDTO> list = new ArrayList<LectureRoomAssignDTO>();
	public Scanner scan = new Scanner(System.in);
	//LECTURE_ROOM_ASSIGN
	public  void add(LectureRoomAssignDTO dto){
		System.out.println("들어온다.");
		Connection conn = DBUtil.open();
	    PreparedStatement pstmt = null;
	      try {    	  
	    	  String sql = "INSERT INTO LECTURE_ROOM_ASSIGN(LECTUREASSIGNROOMCODE,CURRICULUMCODE,LECTUREROOMCODE)"
	    	  				+ "VALUES(LECTUREASSIGNROOMCODE.NEXTVAL,?,?)";                                                 
	    	  					
	    	pstmt = conn.prepareStatement(sql);
	    	
		    pstmt.setInt(1,dto.getCurriculumCode());
		    pstmt.setInt(2, dto.getLectureRoomCode());
		
		 int aa =  pstmt.executeUpdate();
		 if(aa !=0){
				System.out.println("강의실 배정 테이블 inseet 완성");
			    DBUtil.close();  
		 }else{
			 System.out.println("실패");
		 }
		 DBUtil.close();  
	      } catch (Exception e) {
	    	 System.out.println("dao add 메서드 catch");
	         System.out.println(e.toString());
	      }
	}//add

	public  ArrayList<LectureRoomAssignDTO> lectureAssignRoomListAll(){

	//	ArrayList<LectureRoomDTO> list = new ArrayList<LectureRoomDTO>();
		
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;	
		ResultSet rs = null;		
		String sql  = "SELECT * FROM LECTURE_ROOM_ASSIGN ORDER BY  LECTUREASSIGNROOMCODE ASC";			
		System.out.println("lectureAssignRoomListAll 여기까지는 들어온다0");

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
				while (rs.next()){
					System.out.println("lectureAssignRoomListAll 여기까지는 들어온다1");
					LectureRoomAssignDTO dto = new LectureRoomAssignDTO();			
			     dto.setLectureAssignRoomCode(rs.getInt("lectureAssignRoomCode"));
			     dto.setCurriculumCode(rs.getInt("curriculumCode"));
			     dto.setLectureRoomCode(rs.getInt("lectureRoomCode"));  
					System.out.println("lectureAssignRoomListAll 여기까지는 들어온다2");

	             list.add(dto);   
				}
				DBUtil.close();								
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		return list;						
	
	}//lectureAssignRoomListAll
	
	public  ArrayList<LectureRoomAssignDTO> lectureAssignRoomSearch (){
	//	ArrayList<LectureRoomDTO> list = new ArrayList<LectureRoomDTO>();
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;	
		ResultSet rs = null;		
		LectureRoomAssignDTO dto = new LectureRoomAssignDTO();
		
		
		int lectureAssignRoomCode = scan.nextInt();
		
		String sql  ="SELECT * FROM LECTURE_ROOM_ASSIGN WHERE LECTUREASSIGNROOMCODE =?  ORDER BY  LECTUREASSIGNROOMCODE ASC";	
		//scan.skip("\r\n");
		System.out.println("lectureAssignRoomSearch 들어온다1");
		try {
			pstmt  	=  conn.prepareStatement(sql);
			pstmt.setInt(1, lectureAssignRoomCode);
			rs		=  pstmt.executeQuery();
			System.out.println(sql);
			System.out.println("lectureAssignRoomSearch 들어온다2");
			while (rs.next()){
//				LectureRoomDTO dto = new LectureRoomDTO();			
				System.out.println("lectureAssignRoomSearch 들어온다3");
				 dto.setLectureAssignRoomCode(rs.getInt("lectureAssignRoomCode"));
			     dto.setCurriculumCode(rs.getInt("curriculumCode"));
			     dto.setLectureRoomCode(rs.getInt("lectureRoomCode"));  
			     System.out.println("lectureAssignRoomSearch 들어온다4");
             list.add(dto);   
			}
			DBUtil.close();		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		System.out.println(e.toString());
		}
		return list;
	}//lectureAssignRoomSearch
		
	public  void lectureAssignRoomUpdate(LectureRoomAssignDTO dto){
		System.out.println("DAO 업데이트");
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;	
		
		System.out.println("UPDATE 들어온다");
	
		try {
			String sql  = 
					"UPDATE LECTURE_ROOM_ASSIGN SET CURRICULUMCODE = ?, LECTUREROOMCODE= ? WHERE  LECTUREASSIGNROOMCODE =?"		;
			
			pstmt = conn.prepareStatement(sql);//객체를 생성하고 
			System.out.println(sql);		
			
			pstmt.setInt(1, dto.getCurriculumCode());
			pstmt.setInt(2, dto.getLectureRoomCode());
			pstmt.setInt(3, dto.getLectureAssignRoomCode());
					
			int  rs  = pstmt.executeUpdate();
			if(rs != 0){
			
				System.out.println("수정 완료 되었습니다 ");
				DBUtil.close();
			}else{
				System.out.println("수정 안되었습니다 ");
			}	
		} catch (SQLException e) {
			System.out.println("메롱");
			System.out.println(e.toString());
		}	
	}//lectureAssignRoomUpdate
	
		public  void lectureAssignRoomDelete(LectureRoomAssignDTO dto){
			System.out.println("메롱");
			Connection conn = DBUtil.open();
			PreparedStatement pstmt = null;	
			try {
				System.out.println("delete 들어온다");
				String sql  ="DELETE  FROM LECTURE_ROOM_ASSIGN WHERE LECTUREASSIGNROOMCODE = ?";		
				System.out.println(sql);
				
				pstmt  	=  conn.prepareStatement(sql);
				pstmt.setInt(1, dto.getLectureAssignRoomCode());
				int val =  pstmt.executeUpdate();	
				if(val != 0 ){
					System.out.println("삭제가 완료 되었습니다 ");		
				}else{
					System.out.println("삭제가 안되었습니다 ");
				}	
					pstmt.close();
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			System.out.println(e.toString());
			}				
		}//lectureAssignRoomDelete	
}//class