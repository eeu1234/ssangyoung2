package com.project1.faculty;

import java.util.ArrayList;

import com.project1.DAO.CurriculumDAO;
import com.project1.DAO.DepartmentDAO;
import com.project1.DAO.FacultyDAO;
import com.project1.DTO.CurriculumDTO;
import com.project1.DTO.DepartmentDTO;
import com.project1.DTO.FacultyDTO;
import com.project1.DTO.StudentDTO;
import com.project1.main.Function;
import com.project1.main.main;
import com.project1.student.Student;


public class Faculty extends Function {

	public static void Faculty() {
		//main.userCode;  //==> 자신의 교원 코드 들어있음  >> 이걸로 내 강좌 이런거 쿼리해오면됌
		Function.init();

		menu();

	}

	/**
	 * 교원검색
	 */
	private static void search() {
		boolean flag = true;
		while(flag) {
		System.out.print("【이름 검색】:");
		String name = scan.nextLine();

		FacultyDAO dao = new FacultyDAO();

		ArrayList<FacultyDTO> list = dao.search(name);

		for (FacultyDTO dto : list) {
			System.out.println("===================================");
			System.out.printf("『교원 번호』: %s\n", dto.getStaffCode());
			System.out.printf("『교원 이름』: %s\n", dto.getStaffName());
			System.out.printf("『교원 이메일』:%s\n", dto.getEmail());
			System.out.printf("===================================\n");
			
			flag = true;

		} // for
		break;
		}
	}


	/**
	 * 교육과정 리스트
	 */
	private static void Curriculum_list() {
		CurriculumDAO dao = new CurriculumDAO();

		System.out.println("【교육 과정】");
		ArrayList<CurriculumDTO> list = dao.list();


		for (CurriculumDTO dto : list) {
			
			System.out.printf("과목명:%s  학과:%s  담당교수:%s  학년:%s  학점:%s  시수:%s  이메일:%s, 강의실:%s\n"
					,dto.getSubjectName()
					,dto.getClassName()
					,dto.getStaffName()
					,dto.getSemester()
					,dto.getSubjectScore()
					,dto.getPeriod()
					,dto.getEmail()
					,dto.getLectureRoomName());
			System.out.println("============================================================================================================================");

		} // for

	}// Curriculum_list






	/**
	 * 교원목록
	 */
	private static void faculty_list() {
		FacultyDAO dao = new FacultyDAO();

		System.out.println("【교원 리스트】");
		ArrayList<FacultyDTO> i_list = dao.faculty_list();
		System.out.println("=================================================================================");
		System.out.println("【강사 번호】    【강사 이름】    【강사 이메일】");
		for (FacultyDTO dto : i_list) {
			System.out.printf("%s\t\t %s\t\t %s\t\t\n"
					, dto.getStaffCode()
					, dto.getStaffName()
					, dto.getEmail());
		System.out.println("=================================================================================");

		} // for

	}// i_list


	/**
	 *메인메뉴
	 */
	public static void menu() {

		boolean flag = true;
		while (flag) {
			System.out.println("<MENU> ");
			System.out.println("【1.교원】 ");
			System.out.println("【2.교육과정】 ");
			System.out.println("【0.메뉴】");

			System.out.println("【번호 입력】: ");

			String n = scan.nextLine();

			if (n.equals("1")) {
				Facultymenu();

			} else if (n.equals("2")) {
				Curriculum_menu();
			} else if (n.equals("0")) {
				// 교원메인메뉴가기
				Faculty.Faculty();
			}

		}

	}// menu





	/**
	 * 교육과정 메뉴
	 */
	public static void Curriculum_menu() {

		boolean flag = true;
		while (flag) {
			System.out.println("<MENU> ");
			System.out.println("【1.교육과정 리스트】");
			System.out.println("【2.교육과정 검색】");
			System.out.println("【3.개인 교육과정】");
			System.out.println("【0.메뉴】");

			System.out.println("【번호 입력】: ");

			String n = scan.nextLine();

			if (n.equals("1")) {
				Curriculum_list();
			} else if (n.equals("2")) {
				Curriculum_search();
			} else if (n.equals("3")) {
				MyCurriculum();
			} else if (n.equals("0")) {
				// 교원메인메뉴가기
				Faculty.Faculty();

			}

		}

	}// menu



	/**
	 * 교원 메인메뉴
	 */
	public static void Facultymenu() {

		boolean flag = true;
		while (flag) {
			System.out.println("<메인 관리항목 선택> ");
			System.out.println("【1.교원 리스트】 ");
			System.out.println("【2.교원 검색】 ");
			System.out.println("【0.로그아웃】");

			System.out.println("【번호 입력】: ");

			String n = scan.nextLine();

			if (n.equals("1")) {
				faculty_list();

			} else if (n.equals("2")) {
				search();
			} else if (n.equals("0")) {
				// 교원메인메뉴가기
				main.login();
			}

		}

	}// menu






	/**
	 * 교육과정 검색
	 */
	public static void Curriculum_search() {

		boolean flag = true;

		while(flag) {


			System.out.print("【과목명】 or 【학과 입력】:");
			String word = scan.nextLine();

			CurriculumDAO dao = new CurriculumDAO();

			ArrayList<CurriculumDTO> list = dao.Curriculum_search(word);


		for (CurriculumDTO dto : list) {

					
					System.out.printf("과목명:%s  학과:%s  담당교수:%s  학년:%s  학점:%s  시수:%s  이메일:%s\n"
							,dto.getSubjectName()
							,dto.getClassName()
							,dto.getStaffName()
							,dto.getSemester()
							,dto.getSubjectScore()
							,dto.getPeriod()
							,dto.getEmail());
					System.out.println("================================================================================================================================");
					flag = true;
						
					


				}//for 				
			break;
			} //while
			
		}//Curriculum_search
		
	


	/**
	 * 자신의 교육과정
	 */
	public static void  MyCurriculum() {

		CurriculumDAO dao = new CurriculumDAO();

		ArrayList<CurriculumDTO> list = dao.MyCurriculum();


		for (CurriculumDTO dto : list) {
			
			System.out.printf("과목명:%s  학과:%s  담당교수:%s  학년:%s  학점:%s  시수:%s  이메일:%s\n"
					,dto.getSubjectName()
					,dto.getClassName()
					,dto.getStaffName()
					,dto.getSemester()
					,dto.getSubjectScore()
					,dto.getPeriod()
					,dto.getEmail());
			System.out.println("====================================================================================================");


		}




	}//for





}//curriculum_serch





