package com.project1.main;

import java.util.Scanner;

import com.project1.DAO.FacultyDAO;
import com.project1.DTO.FacultyDTO;
import com.project1.DTO.FacultyInstructorDTO;
import com.project1.DTO.InstructorDTO;

import java.util.ArrayList;
public class main {
   
   private static Scanner scan;
   
   public static void main(String[] args) {
      
      //COMMIT TEST
      init();
      
      
      System.out.print("번호 입력: ");
      
      String n = scan.nextLine();
      
      if (n.equals("1")) {
    	  instructor_list();

      
      }   
      
      
      
      
   }
  
   
   
      private static void instructor_list() {
         FacultyDAO dao = new FacultyDAO();
         
         System.out.println("【교원 리스트】");
         ArrayList<FacultyInstructorDTO> i_list = dao.instructor_list();
         
         
         for(FacultyInstructorDTO dto : i_list) {
        	 System.out.printf("강사 번호: %s\n",dto.getStaffCode());
        	 System.out.printf("강사 이름: %s\n",dto.getStaffName());
        	 System.out.printf("강사 이메일:%s\n",dto.getEmail());
        	 System.out.printf("----------------\n");
        	 
        	 
        	 
         }//for
         
         for(FacultyInstructorDTO dto : i_list) {

        	 System.out.printf("교수 번호: %s\n",dto.getStaffCode());
         	 System.out.printf("교수 이름: %s\n",dto.getStaffName());
         	 System.out.printf("교수 이메일:%s\n----------------\n",dto.getEmail());
         }//for

         
                    
         
      }//i_list
      

        
      
      
         
      private static void init() {
      
      scan = new Scanner(System.in);
      
   
   
   }

}