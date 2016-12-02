package com.project1.student;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.project1.DAO.CourseApplicationDAO;
import com.project1.DAO.StudentDAO;
import com.project1.DTO.CourseApplicationDTO;
import com.project1.DTO.StudentDTO;
import com.project1.DTO.myCourseApplicationDTO;
import com.project1.faculty.Faculty;
import com.project1.main.Function;
import com.project1.main.main;

public class Student {
	// main.userCode ==> 자신의 학번 들어있음 >> 이걸로 내 강좌 이런거 쿼리해오면됌

	public static Scanner scan = new Scanner(System.in);

	public static void Student() {
		// main.userCode; //==> 자신의 교원 코드 들어있음 >> 이걸로 내 강좌 이런거 쿼리해오면됌
		Function.init();

		menu();

	}

	/**
	 * 다음 수업 찾기
	 */
	private static void nextMyClass() {

		int period = 0;
		int startHour = 0;
		int startMin = 0;
		int count = 0;
		Calendar today = Calendar.getInstance();
		CourseApplicationDAO dao = new CourseApplicationDAO();
		ArrayList<myCourseApplicationDTO> list = dao.myCourse_list();

		/*
		 * 1 9:00 9:50 2 9:50 10:40 3 10:45 11:40 4 11:45 12:35 5 12:40 13:30 6
		 * 13:35 14:30 7 14:35 15:30 8 15:35 16:30 9 16:35 17:25
		 * 
		 * 
		 * 
		 */

		for (myCourseApplicationDTO dto : list) {
			if (today.get(Calendar.DAY_OF_WEEK) == Integer.parseInt(dto.getDayCode())) {
				period = Integer.parseInt(dto.getPeriodNum());
				// 교시
				switch (period) {
				case 1:
					startHour = 9;
					startMin = 00;
					break;
				case 2:
					startHour = 9;
					startMin = 50;
					break;
				case 3:
					startHour = 10;
					startMin = 45;
					break;
				case 4:
					startHour = 11;
					startMin = 45;
					break;
				case 5:
					startHour = 12;
					startMin = 40;
					break;
				case 6:
					startHour = 13;
					startMin = 35;
					break;
				case 7:
					startHour = 14;
					startMin = 35;
					break;
				case 8:
					startHour = 15;
					startMin = 35;
					break;
				case 9:
					startHour = 16;
					startMin = 35;
					break;
				default:
					startHour = 0;
					startMin = 00;
					break;
				}

			}
			;

			// 시간(0~23)으로 다음 수업 찾기
			if (today.get(Calendar.HOUR_OF_DAY) < startHour && today.get(Calendar.MINUTE) < startMin) {
				int remainTime = 0;
				int remainMin = 0;
				remainTime = startHour - today.get(Calendar.HOUR_OF_DAY);
				remainMin = startMin - today.get(Calendar.MINUTE);
				System.out.println("=====================================================");
				System.out.println("|    다음 시간 과목은 '" + dto.getSubjectName() + "' 입니다.");
				System.out.println("|    강의실 : " + dto.getLectureName());
				System.out.println("|    교시 : " + period);
				System.out.println("=====================================================");
				System.out.println("남은 시간 : " + startHour + ":" + remainMin + "입니다.");
				count++;
				break;

			}

		} // for
		if (count == 0) {
			System.out.println("=====================================================");
			System.out.println("다음 수업이 없습니다.");
			System.out.println("전체 시간표를 보시려면 Enter를 치세요.");
			System.out.println("=====================================================");
		}
	}// nextMyClass()

	/**
	 * 수강신청과정 리스트
	 */
	private static void myCourse_list() {
		nextMyClass();
		Function.pause();

		CourseApplicationDAO dao = new CourseApplicationDAO();

		System.out.println("【내 수강신청】");
		ArrayList<myCourseApplicationDTO> list = dao.myCourse_list();

		System.out.print(" \t 월\t\t\t화\t\t\t수\t\t\t목\t\t\t금\n");
		System.out.print("");

		System.out.print(
				"------------------------------------------------------------------------------------------------------------\n");
		// 1 - 8교시
		for (int i = 1; i < 9; i++) {
			// 월 - 금
			System.out.print(i + "교시" + "|");

			// 과목명출력
			for (int j = 1; j < 6; j++) {

				for (myCourseApplicationDTO dto : list) {
					if (i == Integer.parseInt(dto.getPeriodNum()) && j == Integer.parseInt(dto.getDayCode

					())) {
						System.out.print(dto.getSubjectName());
					} else {
					}
				} // for

				System.out.print("\t\t");
			}
			System.out.println("");

			// 교수명
			System.out.print("　　　　　");
			for (int j = 1; j < 6; j++) {

				for (myCourseApplicationDTO dto : list) {
					if (i == Integer.parseInt(dto.getPeriodNum()) && j == Integer.parseInt(dto.getDayCode

					())) {
						System.out.print("▒▒" + dto.getStaffName() + "  ");
					} else {
						System.out.print("▒▒▒▒▒");
					}
				} // for
				System.out.print("\t\t");
			}
			System.out.println("");

			// 학점
			System.out.print("　　　　　");
			for (int j = 1; j < 6; j++) {

				for (myCourseApplicationDTO dto : list) {
					if (i == Integer.parseInt(dto.getPeriodNum()) && j == Integer.parseInt(dto.getDayCode

					())) {
						System.out.print("▒▒▒▒▒" + dto.getSubjectScore() + "  ");
					} else {
						System.out.print("▒▒▒▒▒");
					}
					;
				} // for
				System.out.print("\t\t");
			}
			System.out.println("");

			System.out.print("");

			System.out.print(
					"------------------------------------------------------------------------------------------------------------\n");
		}

	}// myCourse_list

	/**
	 * 학생 메인메뉴
	 */
	public static void menu() {

		boolean flag = true;
		while (flag) {
			System.out.println(" ");
			System.out.println("<MENU> ");
			System.out.println("【1.수강과목 시간표】 ");

			System.out.println("【2.수강신청 등록】 ");
			System.out.println("【3.수강신청 정정】");

			System.out.println("【번호 입력】: ");

			String n = Function.scan.nextLine();

			if (n.equals("1")) {
				myCourse_list();

			} else if (n.equals("2")) {
				lecture_list();
				add();
				one();
			} else if (n.equals("3")) {
				delete();
				one();
			} else if (n.equals("0")) {
				// 교원메인메뉴가기
				Faculty.Faculty();
			}
		}
	}// menu

	/**
	 * 수강신청 검색 리스트
	 */
	public static void lecture_list() {

		boolean flag = true;

		while(flag) {

			System.out.print("【학과명】or【교원명】or【과목이름】:");

			String serachWord= scan.nextLine();

			CourseApplicationDAO dao = new CourseApplicationDAO();

			ArrayList<StudentDTO> list = dao.courseSearch(serachWord);

			if(list.size() != 0){

				for (StudentDTO dto : list) {
					if(flag) {
					
					System.out.printf("\n교육과정코드:%s 과목코드:%s  학과:%s  학점:%s  강좌명:%s  허용인원:%s  교수:%s  강의실:%s 요일:%s 차수:%s\n"
						
							,dto.getCurriculumCode()
							,dto.getSubjectCode()
							,dto.getClassName()
							,dto.getSubjectScore()
							,dto.getSubjectName()
							,dto.getPeople()
							,dto.getStaffName()
							,dto.getLectureRoomName()
							,dto.getDay()
							,dto.getPeriodNum());
					System.out.println("========================================================================================================================================================");
				
					}
					
			}
			}
			flag=false;
		
		}//while

	}// curriculum_serch

	/**
	 * 수강신청 등록
	 */
	public static void add() {

		boolean flag = true;

		while (flag) {

			System.out.println("\n");
			
			
			System.out.print("【교육과정코드】:");
			int ccode = scan.nextInt();
			scan.skip("\r\n");
			System.out.print("【학번】:");
			String studentNumber = scan.nextLine();

			StudentDAO dao = new StudentDAO();

			StudentDTO dto = new StudentDTO();
			dto.setCurriculumCode(ccode);
			dto.setStudentNumber(studentNumber);

			StudentDAO.add(dto);
			flag = false;

		} // while

	}// add()

	/**
	 * 수강삭제
	 */
	public static void delete() {

		boolean flag = true;

		while (flag) {

			System.out.print("【삭제할 수강신청코드 입력】:");
			int del = scan.nextInt();
			scan.skip("\r\n");
			StudentDTO dto = new StudentDTO();
			dto.setLectureCode(del);

			StudentDAO dao = new StudentDAO();

			StudentDAO.delete(dto);
			flag = false;
		}

	}// delete()

	/**
	 * 수강후 레코드 출력
	 */
	public static void one() {
		boolean flag = true;

		while (flag) {
			System.out.println("【수강코드】or【교원명】or【학생이름】:");
			String num = scan.nextLine();

			StudentDAO dao = new StudentDAO();

			ArrayList<StudentDTO> one = dao.one(num);

			for (StudentDTO dto : one) {
				System.out.println(
						"========================================================================================================================================================");
				System.out.printf("\n교육과정코드:%s 과목코드:%s  학과:%s  학점:%s  강좌명:%s  허용인원:%s  교수:%s  강의실:%s 요일:%s 차수:%s\n",
						dto.getCurriculumCode(), dto.getSubjectCode(), dto.getClassName(), dto.getSubjectScore(),
						dto.getSubjectName(), dto.getPeople(), dto.getStaffName(), dto.getLectureRoomName(),
						dto.getDay(), dto.getPeriodNum());
				System.out.println(
						"========================================================================================================================================================");
				
			}
			flag =false;
		}
	}
}// one

// class
