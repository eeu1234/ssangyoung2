package com.project1.admin.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.project1.admin.DAO.PeriodDAO;
import com.project1.admin.DTO.PeriodDTO;

public class PeriodMain {

	private static Scanner scan = null;
	
	
	public static void main(String[] args) {
		
		PeriodDAO dao = new PeriodDAO();
		
		init();
		
		System.out.print("업무선택 : ");
		String n = scan.nextLine();
		if(n.equals("1")){
			add();
		}else if(n.equals("2")){
			list();// 다중 레코드를 출력
		}else if(n.equals("3")){
			System.out.println("[단일값 가져오기]");
			searchPeriod(); // 단일값 가져오기
		}else if(n.equals("4")){
		
			deletePeriod();
			//de	
		}else if(n.equals("5")){
			updatePeriod();
		//	names(); // 
		}
		
	}//main
	
	
	public static void add() {
		
	System.out.println("교시 등록");
		    System.out.print("교시를 입력해 주세요 : ");
		    int periodNum = scan.nextInt();
		    scan.skip("\r\n");
		    System.out.print("시작시간을 입력해 주세요 : ");
		    int curriculumCode = scan.nextInt();
		    System.out.print("끝나는 시간을 입력해 주세요 : ");
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
		PeriodDTO  dto1 = new PeriodDTO();
		ArrayList<PeriodDTO> list = dao.searchPeriod();;
		//System.out.print("원하시는 교시를 입력해주세요 : ");
		//int periodNum = scan.nextInt();
		//scan.nextLine();
		//dto1.setPeriodNum(periodNum);
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
		System.out.print("삭제 하실 교시를 적어 주세요 : " );
		int periodNum = scan.nextInt();
		scan.nextLine();
		dto.setPeriodNum(periodNum);
		System.out.println("여기까지는 들어온다");
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
		
		System.out.print("수정할 하실 행의 교시 코드 입력 : ");
		int periodCode	= scan.nextInt();
		scan.nextLine();
		System.out.print("수정하실 교시 입력 : ");
		int periodNum	= scan.nextInt();
		scan.nextLine();
		System.out.print("수정하실 교육과정  입력 : ");
		int curriculumCode= scan.nextInt();
		System.out.print("수정하실  요일코드 입력 : ");
		int dayCode	= scan.nextInt();
 
		dto.setPeriodCode(periodCode);
		dto.setPeriodNum(periodNum);
		dto.setCurriculumCode(curriculumCode);
		dto.setDayCode(dayCode);
		
		dao.updatePeriod(dto);
		
	}
		
	
	
	
	
	
	
	
	
}//class
	
	
	
	

