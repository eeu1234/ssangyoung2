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
      
	  
	  
	  faculty();
      
      
      
      
   }//main
  
   
   public static void faculty(){
	   System.out.println("<���� ���θ޴�> ");
	   System.out.println("----------------");
	   System.out.println("1.���� ");
	   System.out.println("2.���� ���� ");
	  
	   System.out.println("��ȣ �Է�: ");
	   
	   String n = scan.nextLine();
	   
	   if (n.equals("1")) {
	 	  Faculty.Faculty();

	   
	   }    
   }
 
   
   

      
      
  

}//class