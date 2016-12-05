package com.project1.admin.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.project1.admin.DAO.FacultyDAO;
import com.project1.admin.DTO.FacultyDTO;


public class StaffMain {

	private static Scanner scan = null;
	private static FacultyDAO dao = new FacultyDAO();
	private static FacultyDTO dto = new FacultyDTO();
	private static ArrayList<FacultyDTO> list = null;
	public static void main(String[] args) {
		
	//	LectureRoomDAO dao = new LectureRoomDAO();
		
		menu();
		
	}//main
	
	public static void menu(){
		init();
		
		System.out.println("[1. 교원 등록 ]");
		System.out.println("[2. 교원 목록보기]");
		System.out.println("[3. 특정 교원 정보 출력]");
		System.out.println("[4. 특정 교원 정보 수정]");
		System.out.println("[5. 처음 페이지로 이동]");
		System.out.println("[6. 메인 페이지로 이동]");
		System.out.println("[7. 종료]");
		
		System.out.print("업무선택 : ");
		String n = scan.nextLine();
		if(n.equals("1")){
			System.out.println("[교원 등록]");
			addStaff();
			menu();
		}else if(n.equals("2")){
			System.out.println("[교원 정보 출력]");
			listStaff();
			menu();
		}else if(n.equals("3")){
			System.out.println("[특정 교원 정보 출력]");
			listStaff();
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
교원번호(PK)	NUMBER	staffCode(PK)
교원이름	VARCHAR2(15)	staffName
구분코드	CHAR(1)	betweenCode
비밀번호	VARCHAR2(50)	password
이메일	VARCHAR2(50)	email
학과코드(FK)	NUMBER	classCode(FK)

 * 		
 */

		    System.out.print("[교원번호 입력해 주세요] : ");
		    int staffCode = scan.nextInt();
		    scan.skip("\r\n");
		    System.out.print("[교원 이름 입력해 주세요] : ");
		    String staffName = scan.nextLine();
		    System.out.print("[교원 구분 코드 입력해 주세요] : ");
		    String betweenCode = scan.nextLine();
		    System.out.print("[교원 비밀번호 입력해 주세요] : ");
		    String pssword = scan.nextLine();  	  
		    System.out.print("[교원 이메일 입력해 주세요] : ");
		    String email = scan.nextLine();	  
		    System.out.print("[교원 학과코드 입력해 주세요] : ");
		    int classCode = scan.nextInt();
		    scan.skip("\r\n");	  
		    
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
			System.out.printf("【교원코드】%d\t【교원명】%s\t【구분코드】%s\t【비밀번호】%s\t【이메일】%s\t【학과코드】%d\t\n ",
				dto.getStaffCode(),
				dto.getStaffName(),
				dto.getBetweenCode(),
				dto.getPassword(),
				dto.getEmail(),
				dto.getClassCode()
			
			);
		}//향상된 for문
		//System.out.println("구분코드는 1:교수 & 2:강사 입니다.");
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
		System.out.print("[수정할 교원코드 입력] : ");
		int staffCode	= scan.nextInt();
		scan.nextLine();
		System.out.print("[원하시는 이름 입력] : ");
			String staffName = scan.nextLine();
		System.out.print("[원하시는 구분 교드 입력] : ");
			String betweenCode	= scan.nextLine();
		
		System.out.print("[원하시는 비번 입력] : ");
			String password	= scan.nextLine();
		System.out.print("[원하시는 이메일 입력] : ");
			String email	= scan.nextLine();
		
			
		dto.setStaffName(staffName);
		dto.setBetweenCode(betweenCode);
		dto.setPassword(password);
		dto.setEmail(email);
		dto.setStaffCode(staffCode);
			

		dao.facultyUpdate(dto);
	}//updateStudent

}//class
	
	
	
	

