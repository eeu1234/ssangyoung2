package com.project1.faculty;

import java.util.ArrayList;
import java.util.Scanner;

import com.project1.DAO.DepartmentDAO;
import com.project1.DAO.FacultyDAO;
import com.project1.DTO.DepartmentDTO;
import com.project1.DTO.FacultyDTO;
import com.project1.main.Function;
import com.project1.main.main;

public class Faculty extends Function {

	public static void Faculty() {

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

		ArrayList<FacultyDTO> list = dao.search(name);

		for (FacultyDTO dto : list) {
			System.out.printf("강사 번호: %s\n", dto.getStaffCode());
			System.out.printf("강사 이름: %s\n", dto.getStaffName());
			System.out.printf("강사 이메일:%s\n", dto.getEmail());
			System.out.printf("----------------\n");

		} // for

	}

	/**
	 * 강사목록
	 */
	private static void instructor_list() {
		FacultyDAO dao = new FacultyDAO();

		System.out.println("【교원 리스트】");
		ArrayList<FacultyDTO> i_list = dao.instructor_list();

		System.out.println("【강사 번호】    【강사 이름】    【강사 이메일】");
		for (FacultyDTO dto : i_list) {
			System.out.printf("%s\t\t %s\t\t %s\t\t\n", dto.getStaffCode(), dto.getStaffName(), dto.getEmail());

		} // for

	}// i_list

	/**
	 * 교수목록
	 */
	private static void professor_list() {

		FacultyDAO dao = new FacultyDAO();

		System.out.println("\n【교수 리스트】");
		ArrayList<FacultyDTO> list = dao.professor_list();

		System.out.println("【교수 번호】    【교수 이름】    【교수 이메일】");
		for (FacultyDTO dto : list) {
			System.out.printf("%s\t\t %s\t\t %s\t\t\n", dto.getStaffCode(), dto.getStaffName(), dto.getEmail());

		}

	}// professor_list

	/**
	 * 교원등록
	 */
	public static void add() {
		String classCode = "";
		String staffCode = "";
		// 가입한다
		// 1.자동증가
		// 2.이름
		// 3.구분코드
		// 4.비밀번호
		// 5.이메일
		// 6.학과이름 ---> code code 삽입

		System.out.print("이름:");
		String name = scan.nextLine();

		System.out.print("구분번호:");
		String between = scan.nextLine();

		System.out.print("비밀번호:");
		String password = scan.nextLine();

		System.out.print("이메일:");
		String email = scan.nextLine();

		System.out.print("학과명 : ");
		String className = scan.nextLine();

		DepartmentDAO daoD = new DepartmentDAO();
		ArrayList<DepartmentDTO> list = daoD.departmentList();

		for (DepartmentDTO dto : list) {
			if (className.equals(dto.getClassName())) {
				classCode = dto.getClassCode();
			}

		}

		if (classCode != null) {
			FacultyDAO dao = new FacultyDAO();
			FacultyDTO dto = new FacultyDTO();

			dto.setStaffCode(staffCode);
			dto.setStaffName(name);
			dto.setBetweenCode(between);
			dto.setPassWord(password);
			dto.setEmail(email);
			dto.setClassCode(classCode);

			dao.add(dto);
		} else {
			System.out.println("고장남");

		}

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
			System.out.println("3.교원 등록");
			System.out.println("0.메뉴");

			System.out.println("번호 입력: ");

			String n = scan.nextLine();

			if (n.equals("1")) {
				instructor_list();
				professor_list();
			} else if (n.equals("2")) {
				search();
			} else if (n.equals("3")) {
				add();
			} else if (n.equals("0")) {
				// 교원메인메뉴가기
				Faculty.Faculty();
			}

		}

	}// menu

}// class
