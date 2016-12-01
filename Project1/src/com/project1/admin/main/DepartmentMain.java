package com.project1.admin.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.project1.admin.DAO.DepartmentDAO;
import com.project1.admin.DTO.DepartmentDTO;

public class DepartmentMain {

	private static Scanner scan = null;
	private static DepartmentDAO dao = new DepartmentDAO();
	private static DepartmentDTO dto = new DepartmentDTO();
	private static ArrayList<DepartmentDTO> list = null;
	public static void main(String[] args) {
		

		init();
		System.out.println("[1. 학과선택][2.학과 정보 출력][3.특정 학과 정보 출력][4.특정 학과 정보 수정]");
		System.out.print("업무선택 : ");
		String n = scan.nextLine();
		if(n.equals("1")){
			System.out.println("[학과 등록]");
			addDepartment();
		}else if(n.equals("2")){
			System.out.println("[학과 정보 출력]");
			listDepartment();// 다중 레코드를 출력
		}else if(n.equals("3")){
			System.out.println("[특정 학과 정보 출력]");
			searchDepartment(); // 단일값 가져오기
		}else if(n.equals("4")){
			System.out.println("[특정 학과 정보 수정]");
			updateDepartment();
		}
		
	}//main
	
	
	public static void addDepartment() {
		    System.out.print("학과 코드 입력해 주세요 : ");
		    int classCode = scan.nextInt();
		    scan.skip("\r\n");
		    System.out.print("학과 이름 입력해 주세요 : ");
		    String className = scan.nextLine();    
		   
		    DepartmentDTO  dto =	new DepartmentDTO();
		    DepartmentDAO  dao =  	new DepartmentDAO();
 		    
		    dto.setClassCode(classCode);
		    dto.setClassName(className);
	
		    dao.add(dto);  	    
	}//addDepartment
	
	
	public static void init(){
		scan = new Scanner(System.in);	
	}//init
	
	
	private static void listDepartment(){
		 list = dao.departmentListAll();
		for(DepartmentDTO  dto : list){		
			System.out.printf("%d,%s \n ",
				dto.getClassCode(),
				dto.getClassName()
			);
		}//향상된 for문
	}//listDepartment
	
	private static void searchDepartment(){
	
		DepartmentDAO dao = new DepartmentDAO();		
		
		
		list = dao.departmentSearch();
		for(DepartmentDTO  dto : list){
				System.out.printf("%d,%s \n ",
					dto.getClassCode(),
					dto.getClassName()
				);
			}
	}//searchDepartment

	private static void updateDepartment(){
		System.out.print("[수정할 학과 코드 입력] : ");
			int classCode = scan.nextInt();
			scan.nextLine();
	
		System.out.print("[수정될 학과 이름 입력] : ");
			String className	= scan.nextLine();
		
		dto.setClassCode(classCode);
		dto.setClassName(className);
	
		dao.departmentUpdate(dto);	
	}//updateDepartment

}//class
	
	
	
	
