package com.project1.faculty;

import java.util.ArrayList;

import com.project1.DAO.CurriculumDAO;
import com.project1.DAO.DepartmentDAO;
import com.project1.DAO.FacultyDAO;
import com.project1.DTO.CurriculumDTO;
import com.project1.DTO.DepartmentDTO;
import com.project1.DTO.FacultyDTO;
import com.project1.main.Function;
import com.project1.main.main;

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
		System.out.print("검색:");
		String name = scan.nextLine();

		FacultyDAO dao = new FacultyDAO();

		ArrayList<FacultyDTO> list = dao.search(name);

		for (FacultyDTO dto : list) {
			System.out.printf("교원 번호: %s\n", dto.getStaffCode());
			System.out.printf("교원 이름: %s\n", dto.getStaffName());
			System.out.printf("교원 이메일:%s\n", dto.getEmail());
			System.out.printf("----------------\n");

		} // for

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


		} // for

	}// Curriculum_list






	/**
	 * 교원목록
	 */
	private static void faculty_list() {
		FacultyDAO dao = new FacultyDAO();

		System.out.println("【교원 리스트】");
		ArrayList<FacultyDTO> i_list = dao.faculty_list();

		System.out.println("【강사 번호】    【강사 이름】    【강사 이메일】");
		for (FacultyDTO dto : i_list) {
			System.out.printf("%s\t\t %s\t\t %s\t\t\n", dto.getStaffCode(), dto.getStaffName(), dto.getEmail());

		} // for

	}// i_list


	//	/**
	//	 * 교원등록
	//	 */
	//	public static void add() {
	//		String classCode = "";
	//		String staffCode = "";
	//		// 가입한다
	//		// 1.자동증가
	//		// 2.이름
	//		// 3.구분코드
	//		// 4.비밀번호
	//		// 5.이메일
	//		// 6.학과이름 ---> code code 삽입
	//
	//		System.out.print("이름:");
	//		String name = scan.nextLine();
	//
	//		System.out.print("구분번호:");
	//		String between = scan.nextLine();
	//
	//		System.out.print("비밀번호:");
	//		String password = scan.nextLine();
	//
	//		System.out.print("이메일:");
	//		String email = scan.nextLine();
	//
	//		System.out.print("학과명 : ");
	//		String className = scan.nextLine();
	//
	//		DepartmentDAO daoD = new DepartmentDAO();
	//		ArrayList<DepartmentDTO> list = daoD.departmentList();
	//
	//		for (DepartmentDTO dto : list) {
	//			if (className.equals(dto.getClassName())) {
	//				classCode = dto.getClassCode();
	//			}
	//
	//		}
	//
	//		if (classCode != null) {
	//			FacultyDAO dao = new FacultyDAO();
	//			FacultyInstructorDTO dto = new FacultyInstructorDTO();
	//			
	//			dto.setStaffCode(staffCode);
	//			dto.setStaffName(name);
	//			dto.setBetweenCode(between);
	//			dto.setPassword(password);
	//			dto.setEmail(email);
	//			dto.setClasscode(classCode);
	//
	//			dao.add(dto);
	//		}
	//		else{
	//			System.out.println("고장남");
	//			
	//		}
	//
	//	}// add





	/**
	 *메인메뉴
	 */
	public static void menu() {

		boolean flag = true;
		while (flag) {
			System.out.println("<MENU> ");
			System.out.println("1.교원 ");
			System.out.println("2.교육과정 ");
			System.out.println("0.메뉴");

			System.out.println("번호 입력: ");

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
			System.out.println("1.교육과정 리스트");
			System.out.println("2.교육과정 검색");
			System.out.println("3.개인 교육과정");
			System.out.println("0.메뉴");

			System.out.println("번호 입력: ");

			String n = scan.nextLine();

			if (n.equals("1")) {
				Curriculum_list();
			} else if (n.equals("2")) {
				Curriculum_search();
			} else if (n.equals("3")) {
				MyCurriculum();
			}		
			else if (n.equals("0")) {
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
			System.out.println("<MENU> ");
			System.out.println("1.교원 리스트 ");
			System.out.println("2.교원 검색 ");
			System.out.println("0.메뉴");

			System.out.println("번호 입력: ");

			String n = scan.nextLine();

			if (n.equals("1")) {
				faculty_list();

			} else if (n.equals("2")) {
				search();
			} else if (n.equals("0")) {
				// 교원메인메뉴가기
				Faculty.Faculty();
			}

		}

	}// menu






	/**
	 * 교육과정 검색
	 */
	public static void Curriculum_search() {

		boolean flag = true;

		while(flag) {


			System.out.print("검색:");
			String name = scan.nextLine();

			CurriculumDAO dao = new CurriculumDAO();

			ArrayList<CurriculumDTO> list = dao.Curriculum_search();


			for (CurriculumDTO dto : list) {
				if(name.contains(dto.getSubjectName())

						|| name.contains(dto.getStaffName())
						|| name.contains(dto.getClassName())){


					System.out.printf("과목명:%s  학과:%s  담당교수:%s  학년:%s  학점:%s  시수:%s  이메일:%s\n"
							,dto.getSubjectName()
							,dto.getClassName()
							,dto.getStaffName()
							,dto.getSemester()
							,dto.getSubjectScore()
							,dto.getPeriod()
							,dto.getEmail());

					flag = true;
						
					


				} 				

			} // for
			break;
		}//while
		
	}//curriculum_serch



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



		}




	}//for





}//curriculum_serch





