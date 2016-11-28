package com.project1.main;

import java.util.Scanner;

import com.project1.DAO.FacultyDAO;
import com.project1.DTO.FacultyDTO;
import com.project1.DTO.FacultyInstructorDTO;
import com.project1.DTO.InstructorDTO;
import com.project1.faculty.Faculty;

import java.util.ArrayList;
public class main extends Function {



   public static void main(String[] args) {
	   
	  Function.init();
      
	  // //
	  
	  faculty();
      
      
      
      
   }//main
  
   
   public static void faculty(){
	   System.out.println("<교원 메인메뉴> ");
	   System.out.println("----------------");
	   System.out.println("1.교원 ");
	   System.out.println("2.교육 과정 ");
	  
	   System.out.println("번호 입력: ");
	   
	   String n = scan.nextLine();
	   
	   if (n.equals("1")) {
	 	  Faculty.Faculty();

	   }
	   
	   
   }//faculty

}//class