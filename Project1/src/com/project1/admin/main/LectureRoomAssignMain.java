package com.project1.admin.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.project1.admin.DAO.LectureRoomAssignDAO;
import com.project1.admin.DAO.LectureRoomDAO;
import com.project1.admin.DTO.LectureRoomAssignDTO;
import com.project1.admin.DTO.LectureRoomDTO;

public class LectureRoomAssignMain {

	private static Scanner scan = null;
	private static LectureRoomAssignDAO dao = new LectureRoomAssignDAO();
	private static LectureRoomAssignDTO dto = new LectureRoomAssignDTO();
	private static ArrayList<LectureRoomAssignDTO> list = null;
	public static void main(String[] args) {
		
		menu();
	
		
	}//main
	
	public static void menu(){
	
		init();
		
		System.out.println("[1. 강의실 배정 등록] ]");
		System.out.println("[2. 강의실 배정 정보 출력]");
		System.out.println("[3. 특정 강의실 배정 정보 출력]");
		System.out.println("[4. 특정 강의실 배정 정보 삭제]");
		System.out.println("[5. 처음 강의실 배정 수정]");
		System.out.println("[6. 메인 페이지로 이동]");
		System.out.println("[7. 종료]");
		
		
		System.out.print("업무선택 : ");
		String n = scan.nextLine();
		if(n.equals("1")){	
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
		   // System.out.print("강의실 배정 번호 입력해 주세요 : ");
		   // int lectureAssignRoomCode = scan.nextInt();
		   // scan.skip("\r\n");
		    System.out.print("교육 과정  이름 입력해 주세요 : ");
		    int curriculumCode = scan.nextInt();
		    scan.nextLine();
		    System.out.print(" 강의실 코드 입력해 주세요 : ");
		    int lectureRoomCode = scan.nextInt();
		    scan.nextLine();
		    
		    LectureRoomAssignDTO  dto =	new LectureRoomAssignDTO();
		    LectureRoomAssignDAO  dao = new LectureRoomAssignDAO();
 		    
		  //  dto.setLectureAssignRoomCode(lectureAssignRoomCode);
		    dto.setCurriculumCode(curriculumCode);
		    dto.setLectureRoomCode(lectureRoomCode);
	
		    dao.add(dto);  
		    
	}//add
	
	public static void init(){
		scan = new Scanner(System.in);
		
	}//init
	
	
	private static void list(){
		 list = dao.lectureAssignRoomListAll();
	
		for(LectureRoomAssignDTO  dto : list){		
			System.out.printf("%d,%d,%d\n ",
				dto.getLectureAssignRoomCode(),
				dto.getCurriculumCode(),
				dto.getLectureRoomCode()
			);
		}//향상된 for문
	}//list
	
	private static void searchLectureRoom(){
		System.out.print("찾으시는 강의배정 넘버를 입력해주세요 : ");
		//LectureRoomAssignDAO dao = new LectureRoomAssignDAO();		
		//int lecttureAssignRoomCode = scan.nextInt();
		//	scan.nextLine();
		//	dto.setLectureAssignRoomCode(lecttureAssignRoomCode);
		//ArrayList<LectureRoomDTO> 
		list = dao.lectureAssignRoomSearch();
		for(LectureRoomAssignDTO  dto : list){
			System.out.printf("%d,%d,%d \n",
					dto.getLectureAssignRoomCode(),
					dto.getCurriculumCode(),
					dto.getLectureRoomCode()
			);	
		}
	}//search

	private static void deleteLectureRoom(){
		System.out.print("삭제 하실 강의실 번호를 적어 주세요 : " );
	
		
			int lectureAssignRoomCode = scan.nextInt();
			scan.nextLine();
			dto.setLectureAssignRoomCode(lectureAssignRoomCode);
			
			dao.lectureAssignRoomDelete(dto);
		
	}//deletePeriod
			
	
	private static void updateLectureRoom(){

		//LectureRoomDAO dao = new LectureRoomDAO();
		//LectureRoomDTO  dto = new LectureRoomDTO();
		
		System.out.print("수정하실 강의실의 배정코드를 입력 : ");
			int lectureAssignRoomNum	= scan.nextInt();
			scan.nextLine();
		System.out.print("수정값 교육과정 코드 입력 : ");
			int curriculumCode	= scan.nextInt();
			scan.nextLine();
		System.out.print("수정값 강의실 코드 입력 : ");
			int lectureRoomCode	= scan.nextInt();
			scan.nextLine();
 
		    dto.setLectureAssignRoomCode(lectureAssignRoomNum);
		    dto.setCurriculumCode(curriculumCode);
		    dto.setLectureRoomCode(lectureRoomCode);
	
		    dao.lectureAssignRoomUpdate(dto);
		
	}
		
	
	
	
	
	
	
	
	
	
	
	
}
