package com.project1.main;

import java.util.Scanner;

import com.project1.DAO.FacultyDAO;
import com.project1.DTO.InstructorDTO;

import java.util.ArrayList;
public class main {
   
   private static Scanner scan;
   
   public static void main(String[] args) {
      
      
      init();
      
      System.out.print("번호 입력: ");
      
      String n = scan.nextLine();
      
      if (n.equals("1")) {
         list();
      
      }   
      
      
      
      
   }
  
   
   
      private static void list() {
         FacultyDAO dao = new FacultyDAO();
         
         System.out.println("이메일\t\t\t비밀번호\t\t교원번호");
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