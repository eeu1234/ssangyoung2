package com.project1.admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.project1.admin.DTO.LectureRoomDTO;



public class LectureRoomDAO {

	//LECTURE_ROOM
	public  void add(LectureRoomDTO dto){
		System.out.println("들어온다.");
		Connection conn =DBUtil.open();
	    PreparedStatement pstmt = null;
	    
	      try {    	  
	    	  String sql = String.format("INSERT INTO LECTURE_ROOM(LECTUREROOMCODE,LECTUREROOMNUM,LECTUREROOMNAME,LECTUREROOMPLACE)"+ "VALUES(LECTUREROOMCODE.NEXTVAL,?,?,?)");                                                 
	    	  pstmt = conn.prepareStatement(sql);   	 
//교시 등록값 	  
		  //  pstmt.setInt(1, dto.getLectureRoomCode());
		    pstmt.setInt(1,dto.getLectureRoomNum());
		    pstmt.setString(2, dto.getLectureRoomName());  
		    pstmt.setString(3, dto.getLectureRoomPlace());  
		    pstmt.executeUpdate();
		    System.out.println("강의실 테이블 insert 완성");
	    DBUtil.close();
	   
	    //DBUtil.close();  
	      } catch (Exception e) {
	    	 System.out.println("dao add 메서드 catch");
	         System.out.println(e.toString());
	      }
	}//add

/////////////////////////////////////////////////////////////////////////////////	
	public ArrayList<LectureRoomDTO> lectureRoomListAll(){
	
		ArrayList<LectureRoomDTO> list = new ArrayList<LectureRoomDTO>();		
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;	
		ResultSet rs = null;		
		String sql  = "SELECT * FROM LECTURE_ROOM ORDER BY  LECTUREROOMCODE ASC";			
		System.out.println("lectureRoomListAll  3");
		try {
			System.out.println("lectureRoomListAll  4");
			pstmt = conn.prepareStatement(sql);
			System.out.println("lectureRoomListAll  5");
			rs = pstmt.executeQuery();
			System.out.println("lectureRoomListAll  6");
				while (rs.next()){
					LectureRoomDTO dto = new LectureRoomDTO();			
			     dto.setLectureRoomCode(rs.getInt("lectureRoomCode"));
			     dto.setLectureRoomNum(rs.getInt("lectureRoomNum"));
			     dto.setLectureRoomName(rs.getString("lectureRoomName"));
			     dto.setLectureRoomPlace(rs.getString("lectureRoomPlace"));
			     
	             list.add(dto);  
				}
				 DBUtil.close();								
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		return list;						
	
	};
/////////////////////////////////////////////////////////////////////////////////	
	
	public  ArrayList<LectureRoomDTO> lectureRoomSearch (){
		Scanner scan = new Scanner(System.in);
		ArrayList<LectureRoomDTO> list = new ArrayList<LectureRoomDTO>();
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;	
		ResultSet rs = null;		
		LectureRoomDTO dto = new LectureRoomDTO();
		int lectureRoomNum = scan.nextInt();
			//System.out.println("lectureRoomSearch  0");
			//System.out.println(lectureRoomNum);
		String sql  = String.format("SELECT * FROM LECTURE_ROOM WHERE LECTUREROOMNUM =?  ORDER BY LECTUREROOMNUM ASC",lectureRoomNum);		
			//System.out.println(sql);
		
			//scan.skip("\r\n");
		System.out.println("lectureRoomSearch  1");
		try {		
			pstmt  	=  conn.prepareStatement(sql);
			pstmt.setInt(1, lectureRoomNum);
			rs		=  pstmt.executeQuery();
				System.out.println("lectureRoomSearch  2");
			while (rs.next()){
				System.out.println("lectureRoomSearch  3");	    
		     dto.setLectureRoomCode(rs.getInt("lectureRoomCode"));
		     dto.setLectureRoomNum(rs.getInt("lectureRoomNum"));
		     dto.setLectureRoomName(rs.getString("lectureRoomName"));
		     dto.setLectureRoomPlace(rs.getString("lectureRoomPlace"));
		     	System.out.println("lectureRoomSearch  4");                          
             list.add(dto);   
			}
			DBUtil.close();		
			
		} catch (SQLException e) {			
		System.out.println(e.toString());
		}
		return list;
	}//lectureRoomSearch
/////////////////////////////////////////////////////////////////////////////////	
	public  void lectureRoomUpdate(LectureRoomDTO dto){
		System.out.println("DAO 업데이트");
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;	
		
		System.out.println("UPDATE 들어온다");	
		try {
			String sql  = 
					
					"UPDATE LECTURE_ROOM SET  LECTUREROOMNUM =?,"
					+ " LECTUREROOMNAME =?, LECTUREROOMPLACE =? WHERE  LECTUREROOMCODE =?";
			pstmt = conn.prepareStatement(sql);//객체를 생성하고 
			System.out.println(sql);		
			
			
			pstmt.setInt(1, dto.getLectureRoomNum());
			pstmt.setString(2,dto.getLectureRoomName());
			pstmt.setString(3,dto.getLectureRoomPlace());			
			pstmt.setInt(4,dto.getLectureRoomCode());
			pstmt.executeUpdate();
			System.out.println("완료");
			
			ResultSet rs  = pstmt.executeQuery();
			if(rs != null){		
				System.out.println("수정 완료 되었습니다 ");
				DBUtil.close();
			}else{
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("메롱");
			System.out.println(e.toString());
		}	
	}//lectureRoomUpdate
/////////////////////////////////////////////////////////////////////////////////	

	public void lectureRoomDelete(LectureRoomDTO dto){
		System.out.println("메롱");
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;	
		try {
			String sql  = "DELETE  FROM LECTURE_ROOM WHERE LECTUREROOMNUM = ?";		
			System.out.println(sql);		
			pstmt  	=  conn.prepareStatement(sql);
			pstmt.setInt(1,  dto.getLectureRoomNum());
			int val =  pstmt.executeUpdate();	
			if(val != 0 ){
				System.out.println("삭제가 완료 되었습니다 ");		
			}else{
				System.out.println("삭제가 안되었습니다 ");
			}
			DBUtil.close();				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		System.out.println(e.toString());
		}
	}//lectureRoomDelete	
/////////////////////////////////////////////////////////////////////////////////	
	
}//class
