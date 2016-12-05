package com.project1.admin.main;

import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

import com.project1.DAO.CurriculumDAO;
import com.project1.admin.DAO.PeriodDAO;
import com.project1.admin.DTO.PeriodDTO;

public class PeriodMain {

	private static Scanner scan = null;
	private static PeriodDAO periodDao = new PeriodDAO();
	private static CurriculumDAO curriculumDAO = new CurriculumDAO();
	
	
	public static void main(String[] args) {
		
		PeriodDAO dao = new PeriodDAO();
		
		menu();
		
		
		
	}//main
	public static void menu(){
		PeriodDAO dao = new PeriodDAO();
		
		System.out.println("[1.교시 선택]");
		System.out.println("[2.교시 정보 출력]");
		System.out.println("[3.특정 교시 정보 출력]");
		System.out.println("[4.특정 교시 정보 삭제]");
		System.out.println("[5.특정 교시 정보 수정]");
		System.out.println("[6. 메인 화면 으로 이동]");
		System.out.println("[7. 프로 그램 종료]");
		System.out.print("업무선택 : ");
		
		init();
		
		System.out.print("업무선택 : ");
		String n = scan.nextLine();
		if(n.equals("1")){
			add();
			menu();
		}else if(n.equals("2")){
			list();
			menu();
		}else if(n.equals("3")){
			searchPeriod();
		}else if(n.equals("4")){
			list();
			deletePeriod();
			menu();
			
		}else if(n.equals("5")){
			list();
			updatePeriod();
			menu();
		}else if(n.equals("6")){
			AdminMainClass  mainView = new AdminMainClass();
			System.out.println("메인 화면 으로 이동하기");
			mainView.mainMenu();
		}else if(n.equals("7")){
			System.out.println("[종료되었습니다]");
			return;
		}
	}
	
	
	
	public static void add() {
		
	System.out.println("[교시 등록]");
			periodDao.list();
		    System.out.print("[교시를 입력해 주세요] : ");
		    int periodNum = scan.nextInt();
		    scan.skip("\r\n");
		    // 교육과정 테이블 생성
		    curriculumDAO.list();
		    System.out.print("[교육과정 코드 입력해 주세요] : ");
		    int curriculumCode = scan.nextInt();
		    //요일 테이블
		    System.out.print("[요일 코드 입력해 주세요] : ");
		    periodDao.list();
		    int dayCode = scan.nextInt();	  
		    
		    	PeriodDTO  dto =	new PeriodDTO();
		    	PeriodDAO  dao =  	new PeriodDAO();
 		    
		    dto.setPeriodNum(periodNum);
		    dto.setCurriculumCode(curriculumCode);
		    dto.setDayCode(dayCode);
	
		    dao.add(dto);  
		    
	}//add
	
	public static void init(){
		scan = new Scanner(System.in);
		
	}//init
	
	
	private static void list(){
		
		PeriodDAO dao = new PeriodDAO();
		
		//레코드 1줄이 문자열
		//레코드 집합(테이블)  ->  DTO 집합 (ArrayList)
		// list 가 곧  Address 테이블 자체이다.	
		ArrayList<PeriodDTO> list = dao.list();
		for(PeriodDTO  dto : list){	
			System.out.printf("%d,%d,%d,%d \n ",
				dto.getPeriodCode(),
				dto.getPeriodNum(),
				dto.getCurriculumCode(),
				dto.getDayCode()	
		);
		}
	}//list
	
	private static void searchPeriod(){
		PeriodDAO dao = new PeriodDAO();
		//PeriodDTO  dto1 = new PeriodDTO();
		ArrayList<PeriodDTO> list = dao.searchPeriod();;
	
		for(PeriodDTO  dto : list){
			
			System.out.printf("%s,%s, %s, %s\n ",
					dto.getPeriodCode(),
					dto.getPeriodNum(),
					dto.getCurriculumCode(),
					dto.getDayCode()	
			);
			
		}
	}//search

	private static void deletePeriod(){
		
		PeriodDAO dao = new PeriodDAO();
		PeriodDTO  dto = new PeriodDTO();
		list();
		System.out.print("[삭제 하실 교시를 적어 주세요] : " );
		int periodNum = scan.nextInt();
		scan.nextLine();
		dto.setPeriodNum(periodNum);
		
		dao.delPeriod(dto);
		
	}//deletePeriod
			
	
	private static void updatePeriod(){
/*
,dto.getPeriodCode()
,dto.getPeriodNum()
,dto.getStartTime()
,dto.getEndTime()
*/
		PeriodDAO  dao = new PeriodDAO();
		PeriodDTO  dto = new PeriodDTO();	
		list();
		System.out.print("수정할 하실 행의 교시 코드 입력 : ");
		int periodCode	= scan.nextInt();
		scan.nextLine();
		System.out.print("수정하실 교시 입력 : ");
		int periodNum	= scan.nextInt();
		scan.nextLine();
		curriculumDAO.list();
		System.out.print("수정하실 교육과정  입력 : ");
		int curriculumCode= scan.nextInt();
		System.out.println("[1.월요일][2. 화요일][3. 수요일][4. 목요일][5. 금요일]");
		System.out.print("수정하실  요일코드 입력 : ");
		int dayCode	= scan.nextInt();
 
		dto.setPeriodCode(periodCode);
		dto.setPeriodNum(periodNum);
		dto.setCurriculumCode(curriculumCode);
		dto.setDayCode(dayCode);
		
		dao.updatePeriod(dto);
		
	}
		
	
	
	
	
	
	
	
	
}//class
	
	
	
	

