package com.project1.admin.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.project1.admin.DAO.LectureRoomDAO;
import com.project1.admin.DAO.StudentDAO;
import com.project1.admin.DTO.LectureRoomDTO;
import com.project1.admin.DTO.StudentDTO;

public class StudentMain {

	private static Scanner scan = null;
	private static StudentDAO dao = new StudentDAO();
	private static StudentDTO dto = new StudentDTO();
	private static ArrayList<StudentDTO> list = null;
	public static void main(String[] args) {
		
	//	LectureRoomDAO dao = new LectureRoomDAO();
		
		init();
		System.out.println("[1. 학생등록] ]");
		System.out.println("[2. 학생 정보 출력]");
		System.out.println("[3. 특정 학생 정보 출력]");
		System.out.println("[4. 특정 학생 정보 삭제]");
		System.out.println("[5. 특정 학생 정보 수정]");
		
		System.out.print("업무선택 : ");
		String n = scan.nextLine();
		if(n.equals("1")){
			System.out.println("[학생 등록]");
			addStudent();
		}else if(n.equals("2")){
			System.out.println("[학생 정보 출력]");
			listStudent();// 다중 레코드를 출력
		}else if(n.equals("3")){
			System.out.println("[특정 학생 정보 출력]");
			searchStudent(); // 단일값 가져오기
		}else if(n.equals("4")){
			System.out.println("[특정 학생 정보 삭제]");
		//	studentChildDelete();
			deleteStudent();	
		}else if(n.equals("5")){
			System.out.println("[특정 학생 정보 수정]");
			updateStudent();
		}
		
	}//main
	
	
	public static void addStudent() {
		

		    System.out.print("[학생 학번 입력해 주세요] : ");
		    int studentNumber = scan.nextInt();
		    scan.skip("\r\n");
		    System.out.print("[학생 이름 입력해 주세요] : ");
		    String studentName = scan.nextLine();
		    System.out.print("[학생 비밀번호 입력해 주세요] : ");
		    int studentPassword = scan.nextInt();
		    scan.skip("\r\n");	  
		    System.out.print("[학생 이메일 입력해 주세요] : ");
		    String studentEmail = scan.nextLine();	  
		    System.out.print("[학생 학과코드 입력해 주세요] : ");
		    int studentClassCode = scan.nextInt();
		    scan.skip("\r\n");	  
		    
		    StudentDTO  dto =	new StudentDTO();
		    StudentDAO  dao =  	new StudentDAO();
 		    
		    	 dto.setStudentNumber(studentNumber);
		    	 dto.setStudentName(studentName);
		    	 dto.setPassword(studentPassword);
		    	 dto.setEmail(studentEmail);
		    	 dto.setClassCode(studentClassCode);
	
		    dao.add(dto);  
		    
	}//add
	
	public static void init(){
		scan = new Scanner(System.in);	
	}//init
	
	private static void listStudent(){
		 list = dao.studentListAll();
		for(StudentDTO  dto : list){		
			System.out.printf("%d,%s, %d, %s,%d \n ",
				dto.getStudentNumber(),
				dto.getStudentName(),
				dto.getPassword(),
				dto.getEmail(),
				dto.getClassCode()
			);
		}//향상된 for문
	}//list
	
	private static void searchStudent(){
		System.out.print("[찾으시는  학생넘버를 입력해주세요] : ");
		StudentDAO dao = new StudentDAO();		
		
		list = dao.studentSearch();
		for(StudentDTO  dto : list){
			System.out.printf("%d,%s, %d, %s,%d \n ",
					dto.getStudentNumber(),
					dto.getStudentName(),
					dto.getPassword(),
					dto.getEmail(),
					dto.getClassCode()
			);	
		}
	}//searchStudent
	private static void deleteStudent(){
		System.out.print("[삭제를 원하시면 학생 코드를 적어 주세요] : " );
			int studentNumber = scan.nextInt();
			scan.nextLine();
			dto.setStudentNumber(studentNumber);
			System.out.println("여기까지는 들어온다");
			dao.studentChildDelete(dto);
			dao.studentDelete(dto);
		
	}//deleteStudent
	private static void updateStudent(){
		System.out.print("[수정하실 학생 이름 입력] : ");
			String studentName = scan.nextLine();
		System.out.print("[수정 될 비밀번호 입력] : ");
			int studentPassword	= scan.nextInt();
			scan.nextLine();
		System.out.print("수정 될 이메일 입력] : ");
			String studentEmail	= scan.nextLine();
		
		dto.setStudentName(studentName);
		dto.setPassword(studentPassword);
		dto.setEmail(studentEmail);
	
		dao.studentUpdate(dto);	
	}//updateStudent

}//class
	
	
	
	

