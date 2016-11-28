package com.project1.faculty;

import java.util.ArrayList;
import java.util.Scanner;

import com.project1.DAO.FacultyDAO;
import com.project1.DTO.DepartmentDTO;
import com.project1.DTO.FacultyInstructorDTO;
import com.project1.main.Function;
import com.project1.main.main;

public class Faculty extends Function {

	public static void Faculty() {
		// COMMIT TEST
		Function.init();

		Facultymenu();

	}

	/**
	 * 교원검색
	 */
	private static void search() {
		System.out.print("검색:");
		String name = scan.nextLine();
		
		FacultyDAO dao = new FacultyDAO();
		
		ArrayList<FacultyInstructorDTO> list = dao.search(name);
		
		
		
		for (FacultyInstructorDTO dto : list) {
			System.out.printf("강사 번호: %s\n", dto.getStaffCode());
			System.out.printf("강사 이름: %s\n", dto.getStaffName());
			System.out.printf("강사 이메일:%s\n", dto.getEmail());
			System.out.printf("----------------\n");

		} // for
		
		
	
	}
		
		

	
	/**
	 * 교원목록
	 */
	private static void instructor_list() {
		FacultyDAO dao = new FacultyDAO();

		System.out.println("【교원 리스트】");
		ArrayList<FacultyInstructorDTO> i_list = dao.instructor_list();

		for (FacultyInstructorDTO dto : i_list) {
			System.out.printf("강사 번호: %s\n", dto.getStaffCode());
			System.out.printf("강사 이름: %s\n", dto.getStaffName());
			System.out.printf("강사 이메일:%s\n", dto.getEmail());
			System.out.printf("----------------\n");

		} // for

		for (FacultyInstructorDTO dto : i_list) {

			System.out.printf("교수 번호: %s\n", dto.getStaffCode());
			System.out.printf("교수 이름: %s\n", dto.getStaffName());
			System.out.printf("교수 이메일:%s\n----------------\n", dto.getEmail());
		} // for

	}// i_list

	
	/**
	 * 교원 메인메뉴
	 */
	public static void Facultymenu() {

		boolean flag = true;
		while (flag) {
			System.out.println("<MENU> ");
			System.out.println("1.교원 리스트 ");
			System.out.println("2.교원 검색 ");
			System.out.println("0.메인 메뉴로");

			System.out.println("번호 입력: ");

			String n = scan.nextLine();

			if (n.equals("1")) {
				instructor_list();
			} else if (n.equals("2")) {
				search();
			} else if (n.equals("0")) {
				//교원메인메뉴가기
					main.faculty();
			}

		}

	}// menu

}// class
