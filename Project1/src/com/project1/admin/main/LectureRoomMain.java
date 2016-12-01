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
		
		init();
		
		System.out.print("업무선택 : ");
		String n = scan.nextLine();
		if(n.equals("1")){
			System.out.println("강의실등록");
			add();
		}else if(n.equals("2")){
			list();// 다중 레코드를 출력
		}else if(n.equals("3")){
			System.out.println("[단일값 가져오기]");
			searchLectureRoom(); // 단일값 가져오기
		}else if(n.equals("4")){
			deleteLectureRoom();	
		}else if(n.equals("5")){
			updateLectureRoom();
		}
		
	}//main
	
	
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
		System.out.print("원하시는 강의실 넘버를 입력해주세요 : ");
		LectureRoomDAO dao = new LectureRoomDAO();		
		
		//ArrayList<LectureRoomDTO> 
		list = dao.lectureRoomSearch();
		for(LectureRoomDTO  dto : list){
		
			System.out.printf("%d,%d, %s, %s\n ",
				dto.getLectureRoomCode(),
				dto.getLectureRoomNum(),
				dto.getLectureRoomName(),
				dto.getLectureRoomPlace()	
			);
			
		}
	}//search

	private static void deleteLectureRoom(){
		System.out.print("삭제 하실 강의실 번호를 적어 주세요 : " );
			int lectureRoomNum = scan.nextInt();
			scan.nextLine();
			dto.setLectureRoomNum(lectureRoomNum);
			//System.out.println("여기까지는 들어온다");
			dao.lectureRoomDelete(dto);
		
	}//deletePeriod
	private static void updateLectureRoom(){

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
	
	
	
	

