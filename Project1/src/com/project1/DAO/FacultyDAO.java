package com.project1.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.project1.DTO.FacultyDTO;
import com.project1.DTO.FacultyInstructorDTO;
import com.project1.DTO.InstructorDTO;


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
	 * @강사 목록
	 */
	public ArrayList<FacultyInstructorDTO> instructor_list() { //강사 출력

		ArrayList<FacultyInstructorDTO> list = new ArrayList<FacultyInstructorDTO>();



		try{

			String sql = "SELECT * FROM FACULTY WHERE BETWEENCODE = 2";

			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {

				FacultyInstructorDTO dto= new FacultyInstructorDTO();


				dto.setStaffCode(rs.getString("STAFFCODE"));
				dto.setStaffName(rs.getString("STAFFNAME"));
				dto.setBetweenCode(rs.getString("BETWEENCODE"));

				dto.setEmail(rs.getString("EMAIL"));


				list.add(dto);


			}//while


			DBUtil.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}




		return list;


	}//instructor_list




	/**
	 * 
	 * @return 교수 출력
	 */
	public ArrayList<FacultyInstructorDTO> professor_list() { //교수 출력

		ArrayList<FacultyInstructorDTO> list = new ArrayList<FacultyInstructorDTO>();



		try{

			String sql = "SELECT * FROM FACULTY";

			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {

				FacultyInstructorDTO dto= new FacultyInstructorDTO();


				dto.setStaffCode(rs.getString("STAFFCODE"));
				dto.setStaffName(rs.getString("STAFFNAME"));
				dto.setBetweenCode(rs.getString("BETWEENCODE"));

				dto.setEmail(rs.getString("EMAIL"));


				list.add(dto);


			}//while


			DBUtil.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}




		return list;


	}//instructor_list


	/**
	 * 
	 * @교원 검색
	 */
	public ArrayList<FacultyInstructorDTO> search(String name) {

		ArrayList<FacultyInstructorDTO> list = new ArrayList<FacultyInstructorDTO>();
		try {

			FacultyInstructorDTO dto = new FacultyInstructorDTO();

			String sql = " SELECT * FROM FACULTY WHERE STAFFNAME= '"+ name + "'";

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

	


	public static void add(FacultyInstructorDTO dto) {
		
		
		System.out.println(dto.getStaffCode());
		
		String sql = String.format("INSERT INTO FACULTY (STAFFCODE, STAFFNAME, BETWEENCODE, PASSWORD, EMAIL,CLASSCODE) VALUES('%s','%s','%s','%s','%s','%s')"
					,String.valueOf(Integer.parseInt(dto.getStaffCode())+1)
					,dto.getStaffName()
					,dto.getBetweenCode()
					,dto.getPassword()
					,dto.getEmail()
					,dto.getClasscode());
			
		
		try {
			
			stat.executeQuery(sql);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
				
					
		
	}










}//DD