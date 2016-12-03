package com.project1.admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.project1.admin.DTO.DepartmentDTO;
import com.project1.admin.main.DepartmentMain;

public class DepartmentDAO {

	//LECTURE_ROOM
	public  void add(DepartmentDTO dto){
/* 
학과
학과코드(PK)	NUMBER	classCode(PK)
학과이름	VARCHAR2(30)	className	
 */
		Connection conn =DBUtil.open();
	    PreparedStatement pstmt = null;
	 
	      try {    	  
	    	  String sql ="INSERT INTO DEPARTMENT(CLASSCODE,CLASSNAME) VALUES(?,?)";                                                 
	    	  pstmt = conn.prepareStatement(sql);   	 
 	  
		    	pstmt.setInt(1, dto.getClassCode());
			    pstmt.setString(2, dto.getClassName());
			 
			  pstmt.executeUpdate();
		    	DBUtil.close();
	      } catch (Exception e) {
	         System.out.println(e.toString());
	      }
	}//add

/////////////////////////////////////////////////////////////////////////////////	
	public ArrayList<DepartmentDTO> departmentListAll(){
	
		ArrayList<DepartmentDTO> list = new ArrayList<DepartmentDTO>();		
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;	
		ResultSet rs = null;		
		String sql  = "SELECT CLASSCODE, CLASSNAME FROM DEPARTMENT";			
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
				while (rs.next()){
					DepartmentDTO dto = new DepartmentDTO();
					dto.setClassCode(rs.getInt("classCode"));
					dto.setClassName(rs.getString("className"));	     
	             list.add(dto);  
				}
				 DBUtil.close();								
		} catch (SQLException e) {
		
			System.out.println(e.toString());
		}
		return list;						
	
	}//departmentListAll
/////////////////////////////////////////////////////////////////////////////////	
	
	public  ArrayList<DepartmentDTO> departmentSearch (){
		Scanner scan = new Scanner(System.in);
		ArrayList<DepartmentDTO> list = new ArrayList<DepartmentDTO>();
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;	
		ResultSet rs = null;		
		DepartmentDTO dto = new DepartmentDTO();
		System.out.println("[찾고자 하시는 학과 코드를 입력해주세요] : ");
		int classCode = scan.nextInt();
		scan.nextLine();
		dto.setClassCode(classCode);
			
		String sql  ="SELECT * FROM DEPARTMENT WHERE CLASSCODE =?  ORDER BY CLASSCODE ASC";		
		try {		
			pstmt  	=  conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getClassCode());
			rs		=  pstmt.executeQuery();
			while (rs.next()){
				dto.setClassCode(rs.getInt("classCode"));
				dto.setClassName(rs.getString("className"));	     		 
				list.add(dto); 
				DBUtil.close();		
			}
			DBUtil.close();					
		} catch (SQLException e) {			
		System.out.println(e.toString());
		}
		return list;
	}//departmentSearch
/////////////////////////////////////////////////////////////////////////////////	
	public  void departmentUpdate(DepartmentDTO dto){
		System.out.println("DAO 업데이트");
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;	
		
		try {
			String sql  = 
					"UPDATE DEPARTMENT SET  CLASSNAME =? WHERE  CLASSCODE =?";
			pstmt = conn.prepareStatement(sql);//객체를 생성하고 
			
		System.out.println(sql);				
		  	pstmt.setString(1, dto.getClassName());
		    pstmt.setInt(2, dto.getClassCode());

		    pstmt.executeUpdate();
	
			
			ResultSet rs  = pstmt.executeQuery();
			if(rs != null){		
				System.out.println("[수정 완료 되었습니다] ");
				DBUtil.close();
			}else{
			}	
		} catch (SQLException e) {
			DBUtil.close();
			
			System.out.println("수정이 되지 않았습니다");
			System.out.println(e.toString());
		}	
	}//departmentUpdate
	
}//class
