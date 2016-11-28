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
	private Statement stat;


	public FacultyDAO() { //��� �ҷ�����

		try {

			this.conn = DBUtil.open();
			this.stat = conn.createStatement();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}


	/**
	 * 
	 * @���� �˻�
	 */
	public ArrayList<FacultyInstructorDTO> instructor_search() { //���� ���

		ArrayList<FacultyInstructorDTO> list = new ArrayList<FacultyInstructorDTO>();
		


		try{

			String sql = "SELECT * FROM FACULTY F INNER JOIN INSTRUCTOR I ON F.STAFFCODE = I.STAFFCODE WHERE BETWEENCODE = 1 OR BETWEENCODE =2";

			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {

				FacultyInstructorDTO dto= new FacultyInstructorDTO();
				

				dto.setStaffCode(rs.getString("STAFFCODE"));
				dto.setStaffName(rs.getString("STAFFNAME"));
				dto.setBetweenCode(rs.getString("BETWEENCODE"));

				dto.setEmail(rs.getString("EMAIL"));


				list.add(dto);


			}//while



		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return list;


	}//instructor_list
	
	
	
	
	/**
	 * 
	 * @���� ���
	 */
	public ArrayList<FacultyInstructorDTO> instructor_list() { //���� ���

		ArrayList<FacultyInstructorDTO> list = new ArrayList<FacultyInstructorDTO>();
		


		try{

			String sql = "SELECT * FROM FACULTY F INNER JOIN INSTRUCTOR I ON F.STAFFCODE = I.STAFFCODE WHERE BETWEENCODE = 1 OR BETWEENCODE =2";

			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {

				FacultyInstructorDTO dto= new FacultyInstructorDTO();
				

				dto.setStaffCode(rs.getString("STAFFCODE"));
				dto.setStaffName(rs.getString("STAFFNAME"));
				dto.setBetweenCode(rs.getString("BETWEENCODE"));

				dto.setEmail(rs.getString("EMAIL"));


				list.add(dto);


			}//while



		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return list;


	}//instructor_list
















}//DD