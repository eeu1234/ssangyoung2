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
      
      
      System.out.print("��ȣ �Է�: ");
      
      String n = scan.nextLine();
      
      if (n.equals("1")) {
    	  instructor_list();

      
      }   
      
      
      
      
   }
  
   
   
      private static void instructor_list() {
         FacultyDAO dao = new FacultyDAO();
         
         System.out.println("������ ����Ʈ��");
         ArrayList<FacultyInstructorDTO> i_list = dao.instructor_list();
         
         
         for(FacultyInstructorDTO dto : i_list) {
        	 System.out.printf("���� ��ȣ: %s\n",dto.getStaffCode());
        	 System.out.printf("���� �̸�: %s\n",dto.getStaffName());
        	 System.out.printf("���� �̸���:%s\n",dto.getEmail());
        	 System.out.printf("----------------\n");
        	 
        	 
        	 
         }//for
         
         for(FacultyInstructorDTO dto : i_list) {

        	 System.out.printf("���� ��ȣ: %s\n",dto.getStaffCode());
         	 System.out.printf("���� �̸�: %s\n",dto.getStaffName());
         	 System.out.printf("���� �̸���:%s\n----------------\n",dto.getEmail());
         }//for

         
                    
         
      }//i_list
      

        
      
      
         
      private static void init() {
      
      scan = new Scanner(System.in);
      
   
   
   }

}