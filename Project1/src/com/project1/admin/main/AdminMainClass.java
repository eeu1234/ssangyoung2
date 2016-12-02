package com.project1.admin.main;

import java.util.Scanner;

import com.project1.admin.DAO.DBUtil;

import sun.applet.Main;

public class AdminMainClass {
	public static Scanner scan;

	public static void main(String[] args) {
		
		   scan =  new Scanner(System.in);
		      	      
		   System.out.println("Admin.java");
		   System.out.println("[관리자 화면 입니다]");   
		      
		   mainMenu();
		  
		  
	}//main
	
	public static void mainMenu(){
		 System.out.println("[1] 학생      [2] 교원      [3] 수강신청   [4] 교육과정   [5] 기타      [0] 종료");
		   System.out.print("업무선택 : ");
		
		   boolean flag = true;
		   while(flag){   
			   String n =scan.nextLine();
		          if(n.equals("1")){//학생
		        System.out.println("[학생을 선택 하셨습니다.]");
		         StudentMain student = new StudentMain();
		         student.menu();
		         //student.
		         }else if(n.equals("2")){//교원
				System.out.println("[교원을 선택 하셨습니다.]");
			
		         StaffMain    staff = new StaffMain();
		         
		         staff.menu();
		         
		         }else if(n.equals("3")){//수강신청
		        //수강신청
		         System.out.println("[수강 신청 메뉴를  선택 하셨습니다.]");
		         
		         }else if(n.equals("4")){//교육과정
		        //교육과정
		         System.out.println("[교육과정 메뉴를 선택 하셨습니다]");
		 
		         }else if(n.equals("5")){//기타
		        //1.교과목, 2.강의실 , 3.학과 , 4.교시, 5.요일
		        	 System.out.println("[1. 교과목, 2. 강의실 3. 학과 4. 교시 5. 나가기]");
		        	 n = scan.nextLine();
		        	boolean flag1 = true;
		        	 while (flag1){
		        	 if(n.equals("1")){
		        		 System.out.println("[1.교과목]");
		        		 SubjectMain subjectMain = new SubjectMain();
		        		 subjectMain.menu();
		        		 break;
		        	 }else if(n.equals("2")){
		        		 System.out.println("[강의실을 선택 하셨습니다]");
		        			System.out.println("[1]. 강의실");
				        	System.out.println("[2]. 강의실 배정");
			        		 int nn = scan.nextInt();
			        		 		  scan.nextLine();
			        		 
			        		 if(nn == 1){
			        		 
			        		 	LectureRoomMain lectureRoomMain = new LectureRoomMain();
			        		 	lectureRoomMain.menu();
			        		 	break;
			        		 }else if(nn == 2){
			        		
			        		 	LectureRoomAssignMain lectureRoomAssingMain = new LectureRoomAssignMain();
			        		 	lectureRoomAssingMain.menu();
			        		 	break;
			        		 }else{
			        			 System.out.println("[입력하신 값이 아닙니다]");
			        			 break;
			        		 }
		        	 }else if(n.equals("3")){
		        		 System.out.println("[학과를 선택 하셨습니다]");
		        		 DepartmentMain departmentMain = new DepartmentMain();
		        		 departmentMain.menu();
		        		 break;
		        	 }else if(n.equals("4")){
		        		 System.out.println("[교시를 선택 하셨습니다]");
		        		 PeriodMain periodMain = new PeriodMain();
		        		 periodMain.menu();
		        		 break;
		        	 }else{
		        		 System.out.println("[나가기]");
		        		 flag  = false;
	
		        		 
		        		 break;
		        	 }
		        	 }//while

		         }else if(n.equals("0")){//종료
		            System.out.println("[종료 되었습니다]");
		          
		            DBUtil.close();
		            flag = false;
		            return;
		       
		         }else{
		        	 System.out.println("[종료 되었습니다]");
			            DBUtil.close();
			            flag = false;
			            return;
		         }
		   }//while
		   
	}
	
	
	
}