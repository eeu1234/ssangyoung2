package com.project1.admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.project1.admin.DTO.LectureRoomDTO;
import com.project1.admin.DTO.SubjectDTO;

public class SubjectDAO {



	//LECTURE_ROOM
	public  void add(SubjectDTO dto){
		Connection conn =DBUtil.open();
	    PreparedStatement pstmt = null;
	    
	      try {    	  
	    	  String sql = "INSERT INTO SUBJECT(SUBJECTCODE,SUBJECTNAME,SUBJECTSCORE,PERIOD,SUBJECTPROGRAM,CLASSCODE)"
	    			  + "VALUES(SUBJECTCODE.NEXTVAL,?,?,?,?,?)";                                                 
	    	  pstmt = conn.prepareStatement(sql);   	 

			    pstmt.setString(1,dto.getSubjectName());
			    pstmt.setString(2, dto.getSubjectScore());  
			    pstmt.setString(3, dto.getPeriod());
			    pstmt.setString(4, dto.getSubjectProgram());  
			    pstmt.setInt(5, dto.getClassCode());  
			    pstmt.executeUpdate();
	    DBUtil.close();
	   
	
	      } catch (Exception e) {
	         System.out.println(e.toString());
	      }
	}//add

/////////////////////////////////////////////////////////////////////////////////	
	public ArrayList<SubjectDTO> subjectListAll(){
	
		ArrayList<SubjectDTO> list = new ArrayList<SubjectDTO>();		
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;	
		ResultSet rs = null;		
		String sql  = "SELECT * FROM SUBJECT ORDER BY  SUBJECTCODE ASC";			
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
				while (rs.next()){
					SubjectDTO dto = new SubjectDTO();			
			     dto.setSubjectCode(rs.getInt("subjectCode"));
			     dto.setSubjectName(rs.getString("subjectName"));
			     dto.setSubjectScore(rs.getString("subjectScore"));
			     dto.setSubjectProgram(rs.getString("subjectProgram"));
			     dto.setClassCode(rs.getInt("classCode"));	     
	             list.add(dto);  
				}
				 DBUtil.close();								
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return list;						
	
	}//subjectListAll
/////////////////////////////////////////////////////////////////////////////////	
	
	public  ArrayList<SubjectDTO> subjectSearch (){
		Scanner scan = new Scanner(System.in);
		ArrayList<SubjectDTO> list = new ArrayList<SubjectDTO>();
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;	
		ResultSet rs = null;		
		SubjectDTO dto = new SubjectDTO();
		System.out.print("[찾고싶은 교과코드를 입력 해주세요] : ");
		int subjectCode = scan.nextInt();
		scan.nextLine();
		String sql  = "SELECT * FROM SUBJECT WHERE SUBJECTCODE =?  ORDER BY SUBJECTCODE ASC";		
		try {		
			pstmt  	=  conn.prepareStatement(sql);	
			pstmt.setInt(1, subjectCode);
			rs		=  pstmt.executeQuery();
			while (rs.next()){
			   dto.setSubjectCode(rs.getInt("subjectCode"));
			   dto.setSubjectName(rs.getString("subjectName"));
			   dto.setSubjectScore(rs.getString("subjectScore"));
			   dto.setPeriod(rs.getString("period"));
			   dto.setSubjectProgram(rs.getString("subjectProgram"));
			   dto.setClassCode(rs.getInt("classCode"));
             list.add(dto);   
			}
			DBUtil.close();			
		} catch (SQLException e) {			
		System.out.println(e.toString());
		}
		return list;
	}//subjectSearch
/////////////////////////////////////////////////////////////////////////////////	
	public  void subjectRoomUpdate(SubjectDTO dto){
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;	
		try {
			String sql  = 
					"UPDATE SUBJECT SET  SUBJECTNAME =?,"
					+ "SUBJECTSCORE =?, PERIOD =?, SUBJECTPROGRAM = ?  WHERE  SUBJECTCODE =?";
			pstmt = conn.prepareStatement(sql);//객체를 생성하고 			
			
			pstmt.setString(1, dto.getSubjectScore());
			pstmt.setString(2,dto.getPeriod());
			pstmt.setString(3,dto.getSubjectProgram());			
			pstmt.setInt(4,dto.getSubjectCode());
			pstmt.executeUpdate();
			
			ResultSet rs  = pstmt.executeQuery();
			if(rs != null){		
				System.out.println("[수정 완료 되었습니다]");
				DBUtil.close();
			}else{
			}	
		} catch (SQLException e) {
			System.out.println("[수정 실패]");
			System.out.println(e.toString());
		}	
	}//subjectRoomUpdate
/////////////////////////////////////////////////////////////////////////////////	

	public void subjectDelete(SubjectDTO dto){
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;	
		try {
			String sql  = "DELETE  FROM SUBJECT WHERE SUBJECTCODE = ?";		
			System.out.println(sql);		
			pstmt  	=  conn.prepareStatement(sql);
			pstmt.setInt(1,  dto.getSubjectCode());
			int val =  pstmt.executeUpdate();	
			if(val != 0 ){
				System.out.println("[삭제가 완료 되었습니다]");		
			}else{
				System.out.println("[삭제가 안되었습니다]");
			}
			DBUtil.close();				
		} catch (SQLException e) {
				System.out.println(e.toString());
		}
	}//subjectDelete	`
/////////////////////////////////////////////////////////////////////////////////	
	

	
	
}//class
