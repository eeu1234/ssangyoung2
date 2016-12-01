package com.project1.admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.project1.admin.DTO.SemesterClassDTO;

public class SemesterClassDAO {

	//SEMESTERCLASS
	/*
학기구분
학기코드(PK)	NUMBER	semesterCode(PK)
년도	VARCHAR2(10)	year
학기	VARCHAR2(10)	semester
	 */
	public  void semesterAdd(SemesterClassDTO dto){

		Connection conn =DBUtil.open();
	    PreparedStatement pstmt = null;
	 
	      try {    	  
	    	  String sql ="INSERT INTO SEMESTER_CLASS(SEMESTERCODE,YEAR,SEMESTER) VALUES(?,?,?)";                                                 
	    	  pstmt = conn.prepareStatement(sql);   	 
 	  
		    	pstmt.setInt(1, dto.getSemesterCode());
			    pstmt.setString(2, dto.getYear());
			    pstmt.setString(3, dto.getSemester());
			 
			  pstmt.executeUpdate();
		    System.out.println("학기 테이블 insert 완성");
		    	DBUtil.close();
	      } catch (Exception e) {
	         System.out.println(e.toString());
	      }
	}//add

/////////////////////////////////////////////////////////////////////////////////	
	public ArrayList<SemesterClassDTO> semesterListAll(){
	
		ArrayList<SemesterClassDTO> list = new ArrayList<SemesterClassDTO>();		
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;	
		ResultSet rs = null;		
		String sql  = "SELECT * FROM SEMESTER_CLASS";			
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
				while (rs.next()){
					SemesterClassDTO dto = new SemesterClassDTO();
						dto.setSemesterCode(rs.getInt("semesterCode"));
						dto.setYear(rs.getString("year"));
						dto.setSemester(rs.getString("semester"));
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
	
	public  ArrayList<SemesterClassDTO> semesterSearch (){
		Scanner scan = new Scanner(System.in);
		ArrayList<SemesterClassDTO> list = new ArrayList<SemesterClassDTO>();
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;	
		ResultSet rs = null;		
		SemesterClassDTO dto = new SemesterClassDTO();

		int semesterCode = scan.nextInt();
		scan.nextLine();
		dto.setSemesterCode(semesterCode);
		
		String sql  ="SELECT * FROM SEMESTER_CLASS WHERE SEMESTERCODE =?";		
		try {		
			pstmt  	=  conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getSemesterCode());
			rs		=  pstmt.executeQuery();
			while (rs.next()){
				dto.setSemesterCode(rs.getInt("semesterCode"));
				dto.setYear(rs.getString("year"));
				dto.setSemester(rs.getString("semester"));
				
				list.add(dto); 
				DBUtil.close();		
			}
			DBUtil.close();					
		} catch (SQLException e) {			
		System.out.println(e.toString());
		}
		return list;
	}//lectureRoomSearch
/////////////////////////////////////////////////////////////////////////////////	
	public  void semesterUpdate(SemesterClassDTO dto){
		System.out.println("DAO 업데이트");
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;	
		
		System.out.println("UPDATE 들어온다");	
		try {
			String sql  = 
					"UPDATE SEMESTER_CLASS SET YEAR =?, SEMESTER = ? WHERE  SEMESTERCODE =?";
			pstmt = conn.prepareStatement(sql);//객체를 생성하고 
			
		System.out.println(sql);				
		  	pstmt.setString(1, dto.getYear());
		    pstmt.setString(2, dto.getSemester());
		    pstmt.setInt(3, dto.getSemesterCode());
		    
		    pstmt.executeUpdate();
			
			System.out.println("완료");
		int val =	pstmt.executeUpdate();
		
			if(val != 0){		
				System.out.println("수정 완료 되었습니다 ");
				DBUtil.close();
				
				pstmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			DBUtil.close();
			
			System.out.println("수정이 되지 않았습니다");
			System.out.println(e.toString());
		}	
	}//lectureRoomUpdate
	
}//class
