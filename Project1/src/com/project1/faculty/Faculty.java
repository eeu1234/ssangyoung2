package com.project1.faculty;

import java.util.ArrayList;
import java.util.Scanner;

import com.project1.DAO.FacultyDAO;
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
	 * �����˻�
	 */
	private static void instructor_search() {
		FacultyDAO dao = new FacultyDAO();

		System.out.println("������ ����Ʈ��");
		ArrayList<FacultyInstructorDTO> i_list = dao.instructor_list();

		for (FacultyInstructorDTO dto : i_list) {
			System.out.printf("���� ��ȣ: %s\n", dto.getStaffCode());
			System.out.printf("���� �̸�: %s\n", dto.getStaffName());
			System.out.printf("���� �̸���:%s\n", dto.getEmail());
			System.out.printf("----------------\n");

		} // for

		for (FacultyInstructorDTO dto : i_list) {

			System.out.printf("���� ��ȣ: %s\n", dto.getStaffCode());
			System.out.printf("���� �̸�: %s\n", dto.getStaffName());
			System.out.printf("���� �̸���:%s\n----------------\n", dto.getEmail());
		} // for

	}// i_list

	
	
	
	
	
	
	
	
	
	
	/**
	 * �������
	 */
	private static void instructor_list() {
		FacultyDAO dao = new FacultyDAO();

		System.out.println("������ ����Ʈ��");
		ArrayList<FacultyInstructorDTO> i_list = dao.instructor_list();

		for (FacultyInstructorDTO dto : i_list) {
			System.out.printf("���� ��ȣ: %s\n", dto.getStaffCode());
			System.out.printf("���� �̸�: %s\n", dto.getStaffName());
			System.out.printf("���� �̸���:%s\n", dto.getEmail());
			System.out.printf("----------------\n");

		} // for

		for (FacultyInstructorDTO dto : i_list) {

			System.out.printf("���� ��ȣ: %s\n", dto.getStaffCode());
			System.out.printf("���� �̸�: %s\n", dto.getStaffName());
			System.out.printf("���� �̸���:%s\n----------------\n", dto.getEmail());
		} // for

	}// i_list

	
	/**
	 * ���� ���θ޴�
	 */
	public static void Facultymenu() {

		boolean flag = true;
		while (flag) {
			System.out.println("<MENU> ");
			System.out.println("1.���� ����Ʈ ");
			System.out.println("2.���� �˻� ");
			System.out.println("0.���� �޴���");

			System.out.println("��ȣ �Է�: ");

			String n = scan.nextLine();

			if (n.equals("1")) {
				instructor_list();
			} else if (n.equals("2")) {

			} else if (n.equals("0")) {
				//�������θ޴�����
					main.faculty();
			}

		}

	}// menu

}// class
