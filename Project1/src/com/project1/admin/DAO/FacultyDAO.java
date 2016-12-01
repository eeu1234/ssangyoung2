package com.project1.admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import com.project1.admin.DTO.FacultyDTO;

public class FacultyDAO {

	//LECTURE_ROOM
	public  void staffAdd(FacultyDTO dto){
/* 
교원
교원번호(PK)	NUMBER	staffCode(PK)
교원이름	VARCHAR2(15)	staffName
구분코드	CHAR(1)	betweenCode
비밀번호	VARCHAR2(50)	password
이메일	VARCHAR2(50)	email
학과코드(FK)	NUMBER	classCode(FK)
		
 */
		System.out.println("들어온다.");
		Connection conn =DBUtil.open();
	    PreparedStatement pstmt = null;
	  
	      try {    	  
	    	  String sql ="INSERT INTO FACULITY(STAFFCODE,STAFFNAME,BETWEENCODE,EMAIL,CLASSCODE)"+ "VALUES(?,?,?,?,?)";                                                 
	    	  pstmt = conn.prepareStatement(sql);   	  	  
		    	pstmt.setInt(1, dto.getStaffCode());
			    pstmt.setString(2, dto.getStaffName());
			    pstmt.setString(3, dto.getBetweenCode());
			    pstmt.setString(4, dto.getPassword());
			    pstmt.setString(5, dto.getEmail()); 
			    pstmt.setInt(6,dto.getClassCode());
			 
			  pstmt.executeUpdate();
		    System.out.println("교원 테이블 insert 완성");
		    	DBUtil.close();
	      } catch (Exception e) {
	    	 System.out.println("dao add 메서드 catch");
	         System.out.println(e.toString());
	      }
	}//staffAdd

/////////////////////////////////////////////////////////////////////////////////	
	public ArrayList<FacultyDTO> staffListAll(){
	
		ArrayList<FacultyDTO> list = new ArrayList<FacultyDTO>();		
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;	
		ResultSet rs = null;		
		String sql  = "SELECT * FROM FACULTY ORDER BY  BETWEENCODE ASC";			
	
		try {
			System.out.println("studentListAll  4");
			pstmt = conn.prepareStatement(sql);
			System.out.println("studentListAll  5");
			rs = pstmt.executeQuery();
			System.out.println("studentListAll  6");
				while (rs.next()){
					FacultyDTO dto = new FacultyDTO();
			  
					   dto.setStaffCode(rs.getInt("staffCode"));
					   dto.setStaffName(rs.getString("staffName"));
					   dto.setBetweenCode(rs.getString("betweenCode"));
					   dto.setPassword(rs.getString("password"));
					   dto.setEmail(rs.getString("email"));
					   dto.setClassCode(rs.getInt("classCode"));
				     
	             list.add(dto);  
				}
				 DBUtil.close();	
				 pstmt.close();
		} catch (SQLException e) {
			
			System.out.println(e.toString());
		}
		return list;						
	
	}//staffListAll

	
	public  ArrayList<FacultyDTO> facultySearch (){
		Scanner scan = new Scanner(System.in);
		ArrayList<FacultyDTO> list = new ArrayList<FacultyDTO>();
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;	
		ResultSet rs = null;		
		FacultyDTO dto = new FacultyDTO();
		System.out.print("[원하시는 교원코드를 입력해주세요] : ");
		int staffCode = scan.nextInt();
			
		String sql  ="SELECT * FROM FACULTY WHERE STAFFCODE =?  ORDER BY BETWEENCODE ASC";		
		
		try {		
			pstmt  	=  conn.prepareStatement(sql);
			pstmt.setInt(1, staffCode);
			rs		=  pstmt.executeQuery();
			while (rs.next()){
					   
				   dto.setStaffCode(rs.getInt("staffCode"));
				   dto.setStaffName(rs.getString("staffName"));
				   dto.setBetweenCode(rs.getString("betweenCode"));
				   dto.setPassword(rs.getString("password"));
				   dto.setEmail(rs.getString("email"));
				   dto.setClassCode(rs.getInt("classCode"));
				     
	                         
             list.add(dto); 
             DBUtil.close();		
			}
			DBUtil.close();		
			
		} catch (SQLException e) {			
		System.out.println(e.toString());
		}
		return list;
	}//facultySearch
/////////////////////////////////////////////////////////////////////////////////	
	public  void facultyUpdate(FacultyDTO dto){
		System.out.println("DAO 업데이트");
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;	
		
		try {
			String sql  = 
					"UPDATE FACULTY SET  STAFFNAME =?, BETWEENCODE=?, PASSWORD =?, EMAIL = ?"
					+ " WHERE  STAFFCODE =?";
			pstmt = conn.prepareStatement(sql);//객체를 생성하고 
			
		System.out.println(sql);				

		    pstmt.setString(1, dto.getStaffName());
		    pstmt.setString(2, dto.getBetweenCode());
		    pstmt.setString(3, dto.getPassword()); 
		    pstmt.setString(4, dto.getEmail());
			pstmt.setInt   (5, dto.getStaffCode());
		    pstmt.executeUpdate();
		
			int rs  = pstmt.executeUpdate();
			if(rs != 0){		
				System.out.println("[수정 완료 되었습니다] ");
				DBUtil.close();
				pstmt.close();
			}else{
			}
		} catch (SQLException e) {
			
			System.out.println("[수정이 되지 않았습니다]");
			System.out.println(e.toString());
		}	
	}//facultyUpdate
/////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
