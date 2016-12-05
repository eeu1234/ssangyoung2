package com.project1.admin.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.project1.admin.DAO.LectureRoomDAO;
import com.project1.admin.DTO.LectureRoomDTO;

public class LectureRoomMain {

	private static Scanner scan = null;
	private static LectureRoomDAO dao = new LectureRoomDAO();
	private static LectureRoomDTO dto = new LectureRoomDTO();
	private static ArrayList<LectureRoomDTO> list = null;
	public static void main(String[] args) {
		
	//	LectureRoomDAO dao = new LectureRoomDAO();
		
		menu();
		
	}//main
	
	public static void menu(){
		init();
		
		System.out.println("[1. 강의실 등록] ]");
		System.out.println("[2. 강의실 정보 출력]");
		System.out.println("[3. 특정 강의실 정보 출력]");
		System.out.println("[4. 특정 강의실 정보 삭제]");
		System.out.println("[5. 처음 강의실 수정]");
		System.out.println("[6. 메인 페이지로 이동]");
		System.out.println("[7. 종료]");
		
		
	
		
		
		System.out.print("업무선택 : ");
		String n = scan.nextLine();
		if(n.equals("1")){
			System.out.println("강의실등록");
			add();
			menu();
		}else if(n.equals("2")){
			list();
			menu();
		}else if(n.equals("3")){	
			list();
			searchLectureRoom();
			menu();
		}else if(n.equals("4")){
			list();
			deleteLectureRoom();	
			menu();
		}else if(n.equals("5")){
			list();
			updateLectureRoom();
			menu();
		}else if(n.equals("6")){
			
			AdminMainClass adMain = new AdminMainClass();
			adMain.mainMenu();
		}else if(n.equals("7")){
			System.out.println("[종료]");
			return;
		}
	}
	
	
	
	
	public static void add() {
		
	//System.out.println("강의실 등록");
		    System.out.print("강의실 번호 입력해 주세요 : ");
		    int lectureRoomNum = scan.nextInt();
		    scan.skip("\r\n");
		    System.out.print("강의실 이름 입력해 주세요 : ");
		    String lectureRoomName = scan.nextLine();
		    System.out.print("강의실 층수 입력해 주세요 : ");
		    String lectureRoomPlace = scan.nextLine();	  
		    
		    	LectureRoomDTO  dto =	new LectureRoomDTO();
		    	LectureRoomDAO  dao =  	new LectureRoomDAO();
 		    
		    	
		    dto.setLectureRoomNum(lectureRoomNum);
		    dto.setLectureRoomName(lectureRoomName);
		    dto.setLectureRoomPlace(lectureRoomPlace);
	
		    dao.add(dto);  
		    
	}//add
	
	public static void init(){
		scan = new Scanner(System.in);
		
	}//init
	
	
	private static void list(){
		 list = dao.lectureRoomListAll();
	
		for(LectureRoomDTO  dto : list){		
			System.out.printf("%s,%s, %s, %s\n ",
				dto.getLectureRoomCode(),
				dto.getLectureRoomNum(),
				dto.getLectureRoomName(),
				dto.getLectureRoomPlace()	
			);
		}//향상된 for문
	}//list
	
	private static void searchLectureRoom(){
		list();
		System.out.print("원하시는 강의실 넘버를 입력해주세요 : ");
		LectureRoomDAO dao = new LectureRoomDAO();		

		list = dao.lectureRoomSearch();
		for(LectureRoomDTO  dto : list){
		
			System.out.printf("%d,%d, %s,%s \n ",
				dto.getLectureRoomCode(),
				dto.getLectureRoomNum(),
				dto.getLectureRoomName(),
				dto.getLectureRoomPlace()	
			);
			
		}
	}//search

	private static void deleteLectureRoom(){
		list();
		System.out.print("삭제 하실 강의실 번호를 적어 주세요 : " );
			int lectureRoomNum = scan.nextInt();
			scan.nextLine();
			dto.setLectureRoomNum(lectureRoomNum);
			//System.out.println("여기까지는 들어온다");
			dao.lectureRoomDelete(dto);
		
	}//deletePeriod
	private static void updateLectureRoom(){
		list();
			System.out.print("수정할 하실 행의 강의실 코드 입력 : ");
		int lectureRoomCode	= scan.nextInt();
		scan.nextLine();
			System.out.print("수정값 강의실 번호 입력 : ");
		int lectureRoomNum	= scan.nextInt();
		scan.nextLine();
			System.out.print("수정값 강의실 이름 입력 : ");
		String lectureRoomName = scan.nextLine();
			System.out.print("수정값 강의실 층수 입력 : ");
		String lectureRoomPlace	= scan.nextLine();
 
		 dto.setLectureRoomCode(lectureRoomCode);
		 dto.setLectureRoomNum(lectureRoomNum);
		 dto.setLectureRoomName(lectureRoomName);
		 dto.setLectureRoomPlace(lectureRoomPlace);
	
		 dao.lectureRoomUpdate(dto);
		
	}

}//class
	
	
	
	

