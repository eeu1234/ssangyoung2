package com.project1.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.project1.DTO.StudentDTO;
import com.project1.main.DBUtil;

public class StudentDAO {

	private Connection conn;
	private Statement stat;


	public StudentDAO() { //디비 불러오기

		try {

			this.conn = DBUtil.open();
			this.stat = conn.createStatement();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public static void studentAdd (){
		
	};
	
	public static void studentListAll(){
		
	};
	
public ArrayList<StudentDTO> studentSearch() {
			
			ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
			try {
				
				StudentDTO dto = new StudentDTO();

				String sql = " SELECT * FROM STUDENT";
				
				ResultSet rs = stat.executeQuery(sql);
				
				if (rs.next()) {
					
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
		
		
	};
	
	public static void studentUpdate(){
		
	};
	
	public static void studentDelete(){
		
	};
	
	
	
	
}
