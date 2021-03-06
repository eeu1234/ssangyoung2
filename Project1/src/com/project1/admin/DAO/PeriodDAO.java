package com.project1.admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.project1.admin.DTO.PeriodDTO;



public class PeriodDAO {
	private static Scanner scan = new Scanner(System.in);
	public  Connection conn = null;

	public PeriodDAO(){
		try {
			this.conn = DBUtil.open();
			System.out.println("커넥션 연결");
		} catch (Exception e) {
			System.out.println(e.toString());
		}		
	}// 생성자

	
	public  void add(PeriodDTO dto){
		Connection conn = DBUtil.open();
	    PreparedStatement pstmt = null;
	      try {    	  
	    	  String sql = String.format("INSERT INTO PERIOD(PERIODCODE,PERIODNUM,CURRICULUMCODE,DAYCODE) "
	    	  		+ "VALUES(PERIODCODE.NEXTVAL,?,?,?)");                                                 
	    	    pstmt = conn.prepareStatement(sql);   	 	 	  
		    	pstmt.setInt(1, dto.getPeriodNum());
			    pstmt.setInt(2,dto.getCurriculumCode());
			    pstmt.setInt(3, dto.getDayCode());  
			    pstmt.executeUpdate();     
	    DBUtil.close();  
	      } catch (Exception e) {
	         System.out.println(e.toString());
	      }
	}//add

// 교시 목록 출력
	public  ArrayList<PeriodDTO> list(){	
		ArrayList<PeriodDTO> list = new ArrayList<PeriodDTO>();

		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;	
		ResultSet rs = null;		
		String sql  = "SELECT * FROM PERIOD ORDER BY  PERIODNUM ASC";			
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
				while (rs.next()){
					PeriodDTO dto = new PeriodDTO();			
			     dto.setPeriodCode(rs.getInt("periodCode"));
			     dto.setPeriodNum(rs.getInt("periodNum"));
	             dto.setCurriculumCode(rs.getInt("curriculumCode"));
	             dto.setDayCode(rs.getInt("dayCode"));                                   
	             list.add(dto);   
				}
				DBUtil.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return list;						
	}//list
//교시 검색 서치
	public  ArrayList<PeriodDTO> searchPeriod(){
		ArrayList<PeriodDTO> list = new ArrayList<PeriodDTO>();
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;	
		ResultSet rs = null;		
		System.out.print("검색 하실 교시코드를 적어 주세요 : " );
		int periodCode = scan.nextInt();
		
		String sql  ="SELECT * FROM PERIOD WHERE PERIODCODE =?  ORDER BY  PERIODNUM ASC";		
		scan.skip("\r\n");
		
		try {
			pstmt  	=  conn.prepareStatement(sql);		
			pstmt.setInt(1, periodCode);	
			rs		=  pstmt.executeQuery();
			
			while (rs.next()){
				PeriodDTO dto = new PeriodDTO();			
				  dto.setPeriodCode(rs.getInt("periodCode"));
				  dto.setPeriodNum(rs.getInt("periodNum"));
		          dto.setCurriculumCode(rs.getInt("curriculumCode"));
		          dto.setDayCode(rs.getInt("dayCode"));                                 
             list.add(dto);   
			}
			DBUtil.close();		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		System.out.println(e.toString());
		}
		return list;
	}//searchPeriod 검색 
	
	public void delPeriod(PeriodDTO dto){
		System.out.println("메롱");
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;	
		try {
			String sql  = "DELETE  FROM PERIOD WHERE PERIODNUM = ?";		
			System.out.println(sql);
			pstmt  	=  conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getPeriodNum());
			int val =  pstmt.executeUpdate();	
			if(val != 0 ){
				System.out.println("삭제가 완료 되었습니다 ");		
			}else{
				System.out.println("삭제가 안되었습니다 ");
			}
	//
			pstmt.close();
			conn.close();				
		} catch (SQLException e) {
		System.out.println(e.toString());
		}
	}//delPeriod
	
	
	public void updatePeriod(PeriodDTO dto){
		System.out.println("DAO 업데이트");
		Connection conn = DBUtil.open();
		PreparedStatement pstmt = null;	
		
		try {
			String sql  = 
					"UPDATE PERIOD SET  PERIODNUM =?, CURRICULUMCODE =?, DAYCODE =? WHERE  PERIODCODE =?";	
			pstmt = conn.prepareStatement(sql); 
	
			pstmt.setInt(1, dto.getPeriodNum());
			pstmt.setInt(2, dto.getCurriculumCode());
			pstmt.setInt(3, dto.getDayCode());
			pstmt.setInt(4, dto.getPeriodCode());
			
			int val   =  pstmt.executeUpdate();
			if(val != 0){
				System.out.println("수정 완료 되었습니다 ");
				pstmt.close();
				conn.close();
			}else{
				System.out.println("수정 안되었습니다 ");
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}	
	}//updatePeriod
	

	
}//class
