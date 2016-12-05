package com.project1.admin.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.project1.admin.DAO.DepartmentDAO;
import com.project1.admin.DAO.FacultyDAO;
import com.project1.admin.DTO.FacultyDTO;


public class StaffMain {

	private static Scanner scan = null;
	private static FacultyDAO dao = new FacultyDAO();
	private static FacultyDTO dto = new FacultyDTO();
	private static DepartmentDAO departDao = new DepartmentDAO();
	private static ArrayList<FacultyDTO> list = null;
	public static void main(String[] args) {
		
	//	LectureRoomDAO dao = new LectureRoomDAO();
		
		menu();
		
	}//main
	
	public static void menu(){
		init();
		
		System.out.println("[1. 교원 등록] ]");
		System.out.println("[2. 교원 정보 출력]");
		System.out.println("[3. 특정 교원 정보 출력]");
		System.out.println("[4. 특정 교원 정보 수정]");
		System.out.println("[5. 처음 페이지로 이동]");
		System.out.println("[6. 메인 페이지로 이동]");
		System.out.println("[7. 종료]");
		
		System.out.print("업무선택 : ");
		String n = scan.nextLine();
		if(n.equals("1")){
			System.out.println("[교원 등록]");
			listStaff();
			addStaff();
			menu();
		}else if(n.equals("2")){
			System.out.println("[교원 정보 출력]");
			listStaff();
			menu();
		}else if(n.equals("3")){
			System.out.println("[특정 교원 정보 출력]");
			listStaff();
		
			searchStaff();
			menu();
		}else if(n.equals("4")){
			System.out.println("[특정 교원 정보 수정]");
			listStaff();
			updateStaff();
			menu();
		}else if(n.equals("5")){
			System.out.println("[처음 페이지로 이동]");
			menu();
		}else if(n.equals("6")){
				System.out.println("[메인 페이지로 이동]");
				AdminMainClass adMain = new AdminMainClass();
				adMain.mainMenu();
		}else if(n.equals("7")){
			System.out.println("[종료]");
			return;
		}
	}
	
	
	
	public static void addStaff() {
/*
 * 교원
private int 	staffCode;
	private String	staffName;
	private String	betweenCode;
	private String	password;
	private String	email;
	private int 	classCode;

 * 		
 */
			System.out.print("[교원 학과코드 입력해 주세요] : ");
			int classCode = scan.nextInt();
		    scan.skip("\r\n");
		    System.out.print("[교원 이름 입력해 주세요] : ");
		    String staffName = scan.nextLine();
		    System.out.print("[교원 구분 코드 입력해 주세요] : ");
		    String betweenCode = scan.nextLine();
		    System.out.print("[교원 비밀번호 입력해 주세요] : ");
		    String pssword = scan.nextLine();  	  
		    System.out.print("[교원 이메일 입력해 주세요] : ");
		    String email = scan.nextLine();
		    departDao.departmentListAll();
		    
		    scan.skip("\r\n");
		    System.out.print("[교원번호 5자리를  입력해 주세요] : ");
		    int staffCode = scan.nextInt();
		    
		    FacultyDTO  dto =	new FacultyDTO();
		    FacultyDAO  dao =  	new FacultyDAO();
 		    
		    dto.setStaffCode(staffCode);
			   dto.setStaffName(staffName);
			   dto.setBetweenCode(betweenCode);
			   dto.setPassword(pssword);
			   dto.setEmail(email);
			   dto.setClassCode(classCode);
		  
		    dao.staffAdd(dto);  
		    
	}//add
	
	public static void init(){
		scan = new Scanner(System.in);	
	}//init
	
	private static void listStaff(){
		 list = dao.staffListAll();
		for(FacultyDTO  dto : list){		
			System.out.printf("%d,%s,%s,%s,%s,%d \n ",
				dto.getStaffCode(),
				dto.getStaffName(),
				dto.getBetweenCode(),
				dto.getPassword(),
				dto.getEmail(),
				dto.getClassCode()
			);
		}//향상된 for문
	}//list
	
	private static void searchStaff(){
		
		FacultyDAO dao = new FacultyDAO();	
		list = dao.facultySearch();
		for(FacultyDTO  dto : list){
			System.out.printf("%d,%s,%s,%s,%s,%d \n ",
					dto.getStaffCode(),
					dto.getStaffName(),
					dto.getBetweenCode(),
					dto.getPassword(),
					dto.getEmail(),
					dto.getClassCode()
				);
		}
	}//searchStaff

	private static void updateStaff(){
		System.out.print("[수정하실  교원코드 입력] : ");
		int staffCode	= scan.nextInt();
		scan.nextLine();
		System.out.print("[원하시는 구분 교드 입력] : ");
			String betweenCode	= scan.nextLine();
		
		System.out.print("[원하시는 비번 입력] : ");
			String password	= scan.nextLine();
		System.out.print("[원하시는 이메일 입력] : ");
			String email	= scan.nextLine();
		listStaff();
		
		System.out.print("[수정을 원하시는 이름 입력] : ");
		String staffName = scan.nextLine();	
		dto.setStaffName(staffName);
		dto.setBetweenCode(betweenCode);
		dto.setPassword(password);
		dto.setEmail(email);
		dto.setStaffCode(staffCode);
			

		dao.facultyUpdate(dto);
	}//updateStudent

}//class
	
	
	
	

