package com.project1.main;

import java.util.Scanner;

import com.project1.DAO.FacultyDAO;
import com.project1.DTO.InstructorDTO;

import java.util.ArrayList;
public class main {
   
   private static Scanner scan;
   
   public static void main(String[] args) {
      
      
      init();
      
      System.out.print("��ȣ �Է�: ");
      
      String n = scan.nextLine();
      
      if (n.equals("1")) {
         list();
      
      }   
      
      
      
      
   }
  
   
   
      private static void list() {
         FacultyDAO dao = new FacultyDAO();
         
         System.out.println("�̸���\t\t\t��й�ȣ\t\t������ȣ");
         ArrayList<InstructorDTO> list = dao.list();
         
         for(InstructorDTO dto : list) {
            System.out.printf("%s, %s, %s\n"
            								,dto.getEmail()
            								,dto.getPassword()
            								,dto.getStaffCode());
            
         }
      
   }






      private static void init() {
      
      scan = new Scanner(System.in);
      
   
   
   }

}