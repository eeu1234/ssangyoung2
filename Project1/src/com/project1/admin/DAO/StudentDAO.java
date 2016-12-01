package com.project1.admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.project1.admin.DTO.LectureRoomDTO;
import com.project1.admin.DTO.StudentDTO;

public class StudentDAO {

	public  void add(StudentDTO dto){

		System.out.println("들어온다.");
		Connection conn =DBUtil.open();
	    PreparedStatement pstmt = null;
	    
	      try {    	  
	    	  String sql ="INSERT INTO STUDENT(STUDENTNUMBER,STUDENTNAME,PASSWORD,EMAIL,CLASSCODE)"+ "VALUES(?,?,?,?,?)";                                                 
	    	  pstmt = conn.prepareStatement(sql);   	 
 	  
		    	pstmt.setInt(1, dto.getStudentNumber());
			    pstmt.setString(2, dto.getStudentName());
			    pstmt.setInt(3, dto.getPassword());
			    pstmt.setString(4, dto.getEmail()); 
			    pstmt.setInt(5, dto.getClassCode());
			    
			  pstmt.executeUpdate();
		    	DBUtil.close();
	      } catch (Exception e) {
	         System.out.println(e.toString());
	      }
	}//add

/////////////////////////////////////////////////////////////////////////////////	
	public ArrayList<StudentDTO> studentListAll(){
	
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();		
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;	
		ResultSet rs = null;		
		String sql  = "SELECT * FROM STUDENT ORDER BY  STUDENTNUMBER ASC";			
		System.out.println("studentListAll  3");
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
				while (rs.next()){
					StudentDTO dto = new StudentDTO();
					 dto.setStudentNumber(rs.getInt("studentNumber"));
				     dto.setStudentName(rs.getString("studentName"));
				     dto.setPassword(rs.getInt("password"));
				     dto.setEmail(rs.getString("email"));
				     dto.setClassCode(rs.getInt("classCode"));
				     
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
	
	public  ArrayList<StudentDTO> studentSearch (){
		Scanner scan = new Scanner(System.in);
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;	
		ResultSet rs = null;		
		StudentDTO dto = new StudentDTO();
		int studentNumber = scan.nextInt();
			
		String sql  ="SELECT * FROM STUDENT WHERE STUDENTNUMBER =?  ORDER BY STUDENTNUMBER ASC";		
			//System.out.println(sql);
		
			//scan.skip("\r\n");
		System.out.println("studentSearch  1");
		try {		
			pstmt  	=  conn.prepareStatement(sql);
			pstmt.setInt(1, studentNumber);
			rs		=  pstmt.executeQuery();
				System.out.println("studentSearch  2");
			while (rs.next()){
				System.out.println("studentSearch  3");	    
				 dto.setStudentNumber(rs.getInt("studentNumber"));
			     dto.setStudentName(rs.getString("studentName"));
			     dto.setPassword(rs.getInt("password"));
			     dto.setEmail(rs.getString("email"));
			     dto.setClassCode(rs.getInt("classCode"));
		     	System.out.println("studentSearch  4");                          
             list.add(dto);   
			}
			DBUtil.close();		
			
		} catch (SQLException e) {			
		System.out.println(e.toString());
		}
		return list;
	}//lectureRoomSearch
/////////////////////////////////////////////////////////////////////////////////	
	public  void studentUpdate(StudentDTO dto){
		System.out.println("DAO 업데이트");
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;	
		
		System.out.println("UPDATE 들어온다");	
		try {
			String sql  = 
					"UPDATE STUDENT SET  STUDENTNAME =?,"
					+ " PASSWORD =?, EMAIL =? WHERE  STUDENTNAME =?";
			pstmt = conn.prepareStatement(sql);//객체를 생성하고 
			
		System.out.println(sql);				
			
		    pstmt.setString(1, dto.getStudentName());
		    pstmt.setInt(2, dto.getPassword());
		    pstmt.setString(3, dto.getEmail()); 
		    pstmt.setString(4, dto.getStudentName());
			
		    pstmt.executeUpdate();
			
			System.out.println("완료");
			
			ResultSet rs  = pstmt.executeQuery();
			if(rs != null){		
				System.out.println("[수정이 완료 되었습니다] ");
				DBUtil.close();
			}else{
			}	
		} catch (SQLException e) {
			
			System.out.println("[수정이 되지 않았습니다]");
			System.out.println(e.toString());
		}	
	}//lectureRoomUpdate
/////////////////////////////////////////////////////////////////////////////////
public void studentChildDelete(StudentDTO dto){
		
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;	
		try {
			String sql  = "DELETE  FROM COURSE_APPLICATION WHERE STUDENTNUMBER = ?";		
			System.out.println(sql);		
			pstmt  	=  conn.prepareStatement(sql);
			
			pstmt.setInt(1,dto.getStudentNumber());
			int val =  pstmt.executeUpdate();	
			if(val != 0 ){
				System.out.println("[삭제가 완료 되었습니다] ");
				DBUtil.close();
			}else{
				System.out.println("[삭제가 안되었습니다] ");
			}
			DBUtil.close();				
		} catch (SQLException e) {
			
		System.out.println(e.toString());
		}
	}//lectureRoomDelete		
	
////////////////////////////////////////////////////////////////////////////////
	public void studentDelete(StudentDTO dto){
		
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;	
		try {
			String sql  = "DELETE  FROM STUDENT WHERE STUDENTNUMBER = ?";		
			System.out.println(sql);		
			pstmt  	=  conn.prepareStatement(sql);
		
			pstmt.setInt(1,dto.getStudentNumber());
			int val =  pstmt.executeUpdate();	
			if(val != 0 ){
				System.out.println("[삭제가 완료 되었습니다] ");
				DBUtil.close();
			}else{
				System.out.println("[삭제가 안되었습니다] ");
			}
			DBUtil.close();				
		} catch (SQLException e) {
			
		System.out.println(e.toString());
		}
	}//lectureRoomDelete	
/////////////////////////////////////////////////////////////////////////////////	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
