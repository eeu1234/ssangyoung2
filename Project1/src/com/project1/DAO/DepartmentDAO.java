package com.project1.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.project1.DTO.DepartmentDTO;
import com.project1.DTO.FacultyInstructorDTO;

public class DepartmentDAO {

	private Connection conn;
	private Statement stat;

	
	public DepartmentDAO() { //�뵒鍮� 遺덈윭�삤湲�

		try {

			this.conn = DBUtil.open();
			this.stat = conn.createStatement();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	
	
	/**
	 * 
	 * @媛뺤궗 紐⑸줉
	 */
	public ArrayList<DepartmentDTO> departmentList() { //�븰怨� 紐⑸줉

		ArrayList<DepartmentDTO> list = new ArrayList<DepartmentDTO>();



		try{

			String sql = "SELECT * FROM DEPARTMENT";

			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {

				DepartmentDTO dto= new DepartmentDTO();


				dto.setClassCode((rs.getString("CLASSCODE")));
				dto.setClassName((rs.getString("CLASSNAME")));



				list.add(dto);


			}//while


			DBUtil.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}




		return list;


	}//instructor_list
	
	
}
