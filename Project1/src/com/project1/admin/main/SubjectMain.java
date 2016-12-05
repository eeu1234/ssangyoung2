package com.project1.admin.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.project1.admin.DAO.DepartmentDAO;
import com.project1.admin.DAO.LectureRoomDAO;
import com.project1.admin.DAO.SubjectDAO;
import com.project1.admin.DTO.LectureRoomDTO;
import com.project1.admin.DTO.SubjectDTO;

public class SubjectMain {
	
	private static Scanner scan = null;
	private static SubjectDAO dao = new SubjectDAO();
	private static SubjectDTO dto = new SubjectDTO();
	private static ArrayList<SubjectDTO> list = null;
	private static DepartmentMain departMain = new DepartmentMain();
	public static void main(String[] args) {
		
		menu();
		}//main
		
	
		public static void menu(){
			System.out.println("[1. 교과목 등록]");
			System.out.println("[2. 교과목 전체 출력]");
			System.out.println("[3. 교과목 선택 출력]");
			System.out.println("[4. 교과목 선택 삭제]");
			System.out.println("[5. 교과목 정보 수정]");
				init();
				
				System.out.println();			
				System.out.print("[업무선택 : ]");
				String n = scan.nextLine();
				if(n.equals("1")){
				
					System.out.println("[교과목 등록을 선택 하셨습니다.]");
					addSubject();
					menu();
				}else if(n.equals("2")){
					System.out.println("교과목 전체 출력.]");
					listSubject();
					menu();
				}else if(n.equals("3")){
					System.out.println("[특정 교과목 출력을  선택 하셨습니다.]");
					listSubject();
					searchSubject(); 
					menu();
				}else if(n.equals("4")){
					listSubject();
					System.out.println("[교과목 정보 삭제를  선택 하셨습니다.]");
					deleteSubject();	
					menu();
				}else if(n.equals("5")){
					System.out.println("[교과목 정보 수정을  선택 하셨습니다.]");
					updateSubject();
					menu();
				}
		}
	
	
		
		public static void addSubject() {
			
		
			    System.out.print("[교과목 8자리번호를 입력해 주세요 : ]");
			    int subjectCode = scan.nextInt();
			    scan.nextLine();
			    System.out.print("[교과목 이름 입력해 주세요 : ]");
			    String subjectName = scan.nextLine();
			    System.out.print("[과교과목목 학점을 입력해 주세요 : ]");
			    String subjectScore = scan.nextLine();
			    System.out.print("[과교과목목 시수(교시)을 입력해 주세요 : ]");
			    String period = scan.nextLine();
			    System.out.print("[교과목 계획내용을 입력해 주세요 : ]");
			    String subjectProgram = scan.nextLine();
			    
			    departMain.listDepartment();
			    System.out.print("[교과목 학과코드를 입력해 주세요 : ]");
			    int classCode = scan.nextInt();
			    scan.nextLine();
			   // scan.skip("\r\n");
			    	
			    	SubjectDTO  dto =	new SubjectDTO();
			    	SubjectDAO  dao =  	new SubjectDAO();
	 		    
			    	dto.setSubjectCode(subjectCode);//int
			    	dto.setSubjectName(subjectName);//String
			    	dto.setSubjectScore(subjectScore);//String
			    	dto.setPeriod(period);//String
			    	dto.setSubjectProgram(subjectProgram);//String
			    	dto.setClassCode(classCode);//int
			   
			    	
			    dao.add(dto);
			    
		}//add
		
		public static void init(){
			scan = new Scanner(System.in);
			
		}//init
		
		
		private static void listSubject(){
			 list = dao.subjectListAll();
		
			for(SubjectDTO  dto : list){		
				System.out.printf("%d, %s,%s, %s, %s,%d \n ",
					dto.getSubjectCode(),
					dto.getSubjectName(),
					dto.getSubjectScore(),
					dto.getPeriod(),
					dto.getSubjectProgram(),
					dto.getClassCode()
				);
			}//향상된 for문
		}//list
		
		private static void searchSubject(){
		
			SubjectDAO dao = new SubjectDAO();		
			
			//ArrayList<LectureRoomDTO> 
			list = dao.subjectSearch();
			for(SubjectDTO  dto : list){
			
				System.out.printf("%d,%s,%s,%s,%s,%d \n ",
						dto.getSubjectCode(),
						dto.getSubjectName(),
						dto.getSubjectScore(),
						dto.getPeriod(),
						dto.getSubjectProgram(),
						dto.getClassCode()
				);
			}
		}//searchSubject

		private static void deleteSubject(){
			listSubject();
			System.out.print("[삭제하실 교과목 코드를 적어 주세요 :]" );
				int subjectCode = scan.nextInt();
				scan.nextLine();
				dto.setSubjectCode(subjectCode);
				dao.subjectDelete(dto);
		}//deleteSubject
		
		private static void updateSubject(){
				listSubject();
			    System.out.print("[수정을 원하시는 교과목 코드 입력해 주세요 : ]");
			    int subjectCode = scan.nextInt();
			    
			    System.out.print("[교과목 이름 입력해 주세요 : ]");
			    String subjectName = scan.nextLine();
			    System.out.print("[교과목 학점을 입력해 주세요 : ]");
			    String subjectScore = scan.nextLine();	
			    System.out.print("[교과목 시수(교시)을 입력해 주세요 : ]");
			    String period = scan.nextLine();
			    System.out.print("[교과목 계획내용을 입력해 주세요 : ]");
			    String subjectProgram = scan.nextLine();
			    listSubject();
			    System.out.print("[교과목 학과코드을 입력해 주세요 : ]");
			    int classCode = scan.nextInt();
		
				 	dto.setSubjectCode(subjectCode);//int
			    	dto.setSubjectName(subjectName);//String
			    	dto.setSubjectScore(subjectScore);//String
			    	dto.setPeriod(period);//String
			    	dto.setSubjectProgram(subjectProgram);//String
			    	dto.setClassCode(classCode);//int
			   		 
			 dao.subjectRoomUpdate(dto);
			
		}//updateSubject
		
		
		
	
}//class
