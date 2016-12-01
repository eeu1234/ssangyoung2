package com.project1.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.project1.DTO.FacultyDTO;
import com.project1.main.DBUtil;



public class FacultyDAO {

	private Connection conn;
	private static Statement stat;


	public FacultyDAO() { //디비 불러오기

		try {

			this.conn = DBUtil.open();
			this.stat = conn.createStatement();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	


	
	
	/**
	 * 
	 * @교원목록
	 */ 
	public ArrayList<FacultyDTO> faculty_list() { //교원 출력

		ArrayList<FacultyDTO> list = new ArrayList<FacultyDTO>();



		try{

			String sql = "SELECT * FROM FACULTY";

			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {

				FacultyDTO dto= new FacultyDTO();


				dto.setStaffCode(rs.getString("STAFFCODE"));
				dto.setStaffName(rs.getString("STAFFNAME"));
				dto.setBetweenCode(rs.getString("BETWEENCODE"));
				dto.setEmail(rs.getString("EMAIL"));
				dto.setPassWord(rs.getString("passWord"));
				dto.setClassCode(rs.getString("classCode"));

				list.add(dto);


			}//while


			DBUtil.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return list;


	}//faculty_list()


	/**
	 * 
	 * @교원 이름 검색
	 */
	public ArrayList<FacultyDTO> search(String name) {
		
		ArrayList<FacultyDTO> list = new ArrayList<FacultyDTO>();
		try {
			
			FacultyDTO dto = new FacultyDTO();

			String sql = " SELECT * FROM FACULTY F WHERE F.STAFFNAME LIKE '%"+ name + "%'";
			
			ResultSet rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				
				dto.setStaffCode(rs.getString("STAFFCODE"));
				dto.setStaffName(rs.getString("STAFFNAME"));
				dto.setBetweenCode(rs.getString("BETWEENCODE"));
				dto.setEmail(rs.getString("EMAIL"));
			
				
				list.add(dto);
			}
			
		DBUtil.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
		
		
		
		
		
		return list;	
	}
	



public static void add(FacultyDTO dto) {
		
		
		System.out.println(dto.getStaffCode());
		
		String sql = String.format("INSERT INTO FACULTY (STAFFCODE, STAFFNAME, BETWEENCODE, PASSWORD, EMAIL,CLASSCODE) VALUES('%s','%s','%s','%s','%s','%s')"
					,String.valueOf(Integer.parseInt(dto.getStaffCode())+1)
					,dto.getStaffName()
					,dto.getBetweenCode()
					,dto.getPassWord()
					,dto.getEmail()
					,dto.getClassCode());
			
		
		try {
			
			stat.executeQuery(sql);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
				
					
		
	}










}//DD