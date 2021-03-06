package com.project1.admin.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.project1.admin.DAO.SemesterClassDAO;
import com.project1.admin.DTO.SemesterClassDTO;


public class SemesterMain {

	private static Scanner scan = null;
	private static SemesterClassDAO dao = new SemesterClassDAO();
	private static SemesterClassDTO dto = new SemesterClassDTO();
	private static ArrayList<SemesterClassDTO> list = null;
	public static void main(String[] args) {
		

		menu();
		
	}//main
	
	public static void menu(){
		System.out.println("[1.학기 선택]");
		System.out.println("[2.학기 정보 출력]");
		System.out.println("[3.특정 학기 정보 출력]");
		System.out.println("[4.특정 학기 정보 수정]");
		System.out.println("[5. 메인 화면 으로 이동]");
		System.out.println("[6. 프로 그램 종료]");
		System.out.print("업무선택 : ");
		
		init();
		
		System.out.print("업무선택 : ");
		String n = scan.nextLine();
		if(n.equals("1")){
			System.out.println("[학기 등록]");
			addSemester();
			menu();
		}else if(n.equals("2")){
			System.out.println("[학기 정보 출력]");
			listSemester();// 다중 레코드를 출력
			menu();
		}else if(n.equals("3")){
			System.out.println("[특정 학기 정보 출력]");
			listSemester();
			searchSemester(); // 단일값 가져오기
			menu();
		}else if(n.equals("4")){
			System.out.println("[특정 학기 정보 수정]");
			listSemester();
			updateSemester();
			menu();
		}else if(n.equals("5")){
			AdminMainClass  mainView = new AdminMainClass();
			System.out.println("메인 화면 으로 이동하기");
			mainView.mainMenu();
		}else if(n.equals("6")){
			System.out.println("[종료되었습니다]");
			return;
		}
		
		
	}
	
	
	
	public static void addSemester() {
		    System.out.print("[학기 코드 입력해 주세요] : ");
		    	int semesterCode = scan.nextInt();
		    	scan.skip("\r\n");
		    System.out.print("[학기 년도 입력해 주세요] : ");
		    	String year = scan.nextLine(); 
		    System.out.print("[해당 학기를 입력해 주세요] : ");
		    	String semester = scan.nextLine();   
		   
		    SemesterClassDTO  dto =	new SemesterClassDTO();
		    SemesterClassDAO  dao = new SemesterClassDAO();
 		    
		    dto.setSemesterCode(semesterCode);
		    dto.setYear(year);
		    dto.setSemester(semester);
		   
		    dao.semesterAdd(dto);  	    
	}//addDepartment
	
	
	public static void init(){
		scan = new Scanner(System.in);	
	}//init
	
	
	private static void listSemester(){
		 list = dao.semesterListAll();
		for(SemesterClassDTO  dto : list){		
			System.out.printf("%d,%s,%s \n ",
				dto.getSemesterCode(),
				dto.getYear(),
				dto.getSemester()
			);
		}//향상된 for문
	}//listDepartment
	
	private static void searchSemester(){
	
		SemesterClassDAO dao = new SemesterClassDAO();		
		
		
		list = dao.semesterSearch();
		for(SemesterClassDTO  dto : list){
			System.out.printf("%d,%s,%s \n ",
					dto.getSemesterCode(),
					dto.getYear(),
					dto.getSemester()
				);
			}
	}//searchDepartment

	private static void updateSemester(){
		System.out.print("[수정할 학기 년도 입력] : ");
			String year = scan.nextLine();
						 
		System.out.print("[수정하실 학기 입력] : ");
			String semester	= scan.nextLine();
		
		System.out.print("[수정하실 학기 코드 입력] : ");
			int semesterCode	= scan.nextInt();
			scan.skip("\r\n");
			
			
			
		dto.setYear(year);
		dto.setSemester(semester);
		dto.setSemesterCode(semesterCode);
		dao.semesterUpdate(dto);	
	}//updateStudent

}//class
	
	
	
	

