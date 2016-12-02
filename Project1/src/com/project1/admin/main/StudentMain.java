package com.project1.admin.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.project1.admin.DAO.DBUtil;
import com.project1.admin.DAO.LectureRoomDAO;
import com.project1.admin.DAO.StudentDAO;
import com.project1.admin.DTO.LectureRoomDTO;
import com.project1.admin.DTO.StudentDTO;

public class StudentMain {

	private static Scanner scan = null;
	private static StudentDAO dao = new StudentDAO();
	private static StudentDTO dto = new StudentDTO();
	private static ArrayList<StudentDTO> list = null;
	private static AdminMainClass mainView = new AdminMainClass();
	
	
	
	public static void main(String[] args) {	

		menu();
		
	}
	
	public static void menu(){
		init();
		System.out.println("[1. 학생등록] ]");
		System.out.println("[2. 학생 정보 출력]");
		System.out.println("[3. 특정 학생 정보 출력]");
		System.out.println("[4. 특정 학생 정보 삭제]");
		System.out.println("[5. 특정 학생 정보 수정]");
		System.out.println("[6. 메인 화면 으로 이동]");
		System.out.println("[7. 프로 그램 종료]");
		
		System.out.print("업무선택 : ");
		String n = scan.nextLine();
		if(n.equals("1")){

			System.out.println("[학생 등록]");
			addStudent();
			menu();
		}else if(n.equals("2")){
			System.out.println("[학생 정보 출력]");
			listStudent();
			menu();
		}else if(n.equals("3")){
			System.out.println("[특정 학생 정보 출력]");
			listStudent();
			searchStudent();
			menu();
		}else if(n.equals("4")){
			System.out.println("[특정 학생 정보 삭제]");
			listStudent();
			deleteStudent();
			menu();
		}else if(n.equals("5")){
			listStudent();
			System.out.println("[특정 학생 정보 수정]");
			updateStudent();
			menu();
		}else if(n.equals("6")){
			System.out.println("메인 화면 으로 이동하기");
			mainView.mainMenu();
		}else if(n.equals("7")){
			System.out.println("[종료되었습니다]");
			return;
		}
		
	}//main
	
	
	public static void retureMethod(){
		 
		
	
		  System.out.println("[1.다시 입력을 원하면][2.처음으로 돌아가고 싶으시다면][3. 프로그램 종료]");
		  int choi = scan.nextInt();
		  
		  
		  switch (choi) {
	      case 1    : System.out.println("다시 입력 으로 복귀.");
	      			  addStudent();
	                   break;
	      case 2   : System.out.println("[처음으로 복귀].");
	      		AdminMainClass mainView = new AdminMainClass();
	      		mainView.mainMenu();
	                   break;
	      case 3  : System.out.println("[프로그램 종료].");
	      			   DBUtil.close();
	      			   
	                   break;
	      default    : System.out.println("해당 숫자가 없습니다");
	      
	                   break;
	    }
		
		
		
	}
	
	
	public static void addStudent() {
		
//	boolean flag  = true;
	

		    System.out.print("[학생 학번 입력해 주세요] : ");
		    int studentNumber = scan.nextInt();
		   // scan.skip("\r\n");
		    scan.nextLine();
		    String numberTest = Integer.toString(studentNumber);
		    if(numberTest.length() == 9 && (studentNumber>=111111111 || studentNumber <= 999999999)){
		    	System.out.println("[학번 통과]");
		    }else{
		    	retureMethod();
		    }
		  System.out.print("[학생 이름 입력해 주세요] : ");
		    String studentName = scan.nextLine();
		    
		    	
		    
		    
		
		    	for(int i =0; i<= 10; i++ ){
		    		//(a  >= 65  && a<= 125)
		    	char a= studentName.charAt(i);
		    		if(!(studentName.length() <= 10)){
		    			System.out.println("[이름 재검사]");
		    			retureMethod();
		    		}else{
		    			System.out.println("[이름 통과]");
		    			break;
		    		}
		    	}//for
		    
		    
		  System.out.print("[학생 비밀번호 입력해 주세요] : ");
		    System.out.println("[입력제한수 20이하]");
		    int studentPassword = scan.nextInt();
		    scan.skip("\r\n");	  
		    String passLength = Integer.toString(studentPassword);
		   
		    if(passLength.length() <=20){
		    	System.out.println("[비밀번호 통과]");
		    }else{
		    	retureMethod();
		    } 
		  System.out.print("[학생 이메일 입력해 주세요] : ");
		    String studentEmail = scan.nextLine();	  
		    
		    if(!(studentEmail.length() <=25  && studentName.contains("@"))&& studentName.contains(".")){
		     
		    	retureMethod();
		    }
		    
		    System.out.print("[학생 학과코드 입력해 주세요] : ");
		    int studentClassCode = scan.nextInt();
		    scan.skip("\r\n");	  
		    
			//학번 9자리  숫자만  ] [ 이름  특스문자 제외 ]  [ 비번   숫자 ][이메일 @ . 영어][숫자만]
		    

		    StudentDTO  dto =	new StudentDTO();
		    StudentDAO  dao =  	new StudentDAO();
 		    System.out.println("dto 에 들어간다");
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
			System.out.printf("%9d,%s, %d, %s,%d \n ",
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
		//	dao.studentChildDelete(dto);
			dao.studentDelete(dto);
		
	}//deleteStudent
	private static void updateStudent(){
		System.out.print("[수정하실 학생 이름 입력] : ");
			String studentName = scan.nextLine();
		System.out.print("[수정 될 비밀번호 입력] : ");
			int studentPassword	= scan.nextInt();
			scan.nextLine();
		System.out.print("[수정 될 이메일 입력] : ");
			String studentEmail	= scan.nextLine();
		
		dto.setStudentName(studentName);
		dto.setPassword(studentPassword);
		dto.setEmail(studentEmail);
	
		dao.studentUpdate(dto);	
	}//updateStudent

}//class
	
	
	
	

