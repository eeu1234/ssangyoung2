package com.project1.student;

import java.util.ArrayList;
import java.util.Scanner;

import com.project1.DAO.CourseApplicationDAO;
import com.project1.DAO.StudentDAO;
import com.project1.DTO.StudentDTO;
import com.project1.faculty.Faculty;
import com.project1.main.Function;

public class Student {
//	main.userCode  ==> 자신의 학번  들어있음  >> 이걸로 내 강좌 이런거 쿼리해오면됌
	
	public static Scanner scan = new Scanner(System.in);
	public static void Student() {
		//main.userCode;  //==> 자신의 교원 코드 들어있음  >> 이걸로 내 강좌 이런거 쿼리해오면됌
		Function.init();

		menu();

	}
	
	
	
	/**
	 * 학생 메인메뉴
	 */
	public static void menu() {

		boolean flag = true;
		while (flag) {
			System.out.println(" ");
			System.out.println("<MENU> ");
			System.out.println("1.수강과목 리스트 ");
			
			System.out.println("2.수강신청 하기 ");
			System.out.println("3.수강신청 정정");

			System.out.println("번호 입력: ");

			String n = Function.scan.nextLine();
			
			if (n.equals("1")) {
				lecture_list();			
			} else if (n.equals("2")) {
				
				add();
			} else if (n.equals("3")) {
				delete();
			}
			else if (n.equals("0")) {
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

			System.out.print("학과명or과목명or과목코드:");
			String serachWord= scan.nextLine();

			CourseApplicationDAO dao = new CourseApplicationDAO();

			ArrayList<StudentDTO> list = dao.courseSearch(serachWord);


			for (StudentDTO dto : list) {
	

					System.out.printf("교육과정코드:%s 과목코드:%s  학과:%s  학점:%s  강좌명:%s  허용인원:%s  교수:%s  강의실:%s 요일:%s 차수:%s\n"
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


			} // for
			break;
		}//while
		
	}//curriculum_serch
	
	
	
	/**
	 * 수강신청 등록
	 */
	public static void add() {

		boolean flag = true;

		while(flag) {


			
			System.out.print("교육과정코드:");
			String ccode = scan.nextLine();
			
			System.out.print("학번:");
			String studentNumber  = scan.nextLine();
			
			StudentDAO dao = new StudentDAO();
			
			StudentDTO dto = new StudentDTO();
			dto.setCurriculumCode(ccode);
			dto.setStudentNumber(studentNumber);
			
			StudentDAO.add(dto);

			
		}//while
		
	}//add()
	
	
	/**
	 * 수강삭제
	 */
	public static void delete() {
		
		boolean flag = true;

		while(flag) {


			
			System.out.print("삭제할 수강신청코드 입력:");
			String del = scan.nextLine();
			
			StudentDTO dto = new StudentDTO();
			dto.setLectureCode(del);
			
			StudentDAO dao = new StudentDAO();
			
			
			
			
			StudentDAO.delete(dto);
		
		
		}
		
	}//delete()
	



	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}//class
