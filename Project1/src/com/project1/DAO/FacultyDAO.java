package com.project1.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.project1.DTO.FacultyDTO;
import com.project1.DTO.InstructorDTO;


public class FacultyDAO {
   
   private Connection conn;
   private Statement stat;
   
   
   public FacultyDAO() { //디비 불러오기
      
   try {
         
         this.conn = DBUtil.open();
         this.stat = conn.createStatement();
         
      } catch (Exception e) {
         System.out.println(e.toString());
      }
   }
       
   
   
   
//   public void add(FacultyDTO dto) {
//      
//         String.sql = String.format("INSERT INTO CURRICULUM(CURRICULUM,PEOPLE,STAFFCODE, VALUES(CURRICULUM.NEXTVAL,PEOPLE,STAFFCODE,SUBJECTCODE,SEMESTERCODE)")
//      
//      
//   }
   
   
   
   
   
   
   
   public ArrayList<InstructorDTO> list() { //강사 출력

      ArrayList<InstructorDTO> list = new ArrayList<InstructorDTO>();
      
      
      
   try{
      
      String sql = "SELECT * FROM FACULTY F INNER JOIN INSTRUCTOR I ON F.STAFFCODE = I.STAFFCODE WHERE BETWEENCODE = 2";
      
      ResultSet rs = stat.executeQuery(sql);
      
      while (rs.next()) {
         
         InstructorDTO dto= new InstructorDTO();
         
         dto.setPassword(rs.getString("PASSWORD"));
         dto.setEmail(rs.getString("EMAIL"));
         dto.setStaffCode(rs.getString("STAFFCODE"));
         
         list.add(dto);
         
         
      }//while
      
      
      
   } catch (Exception e) {
      System.out.println(e.toString());
   }
   
   return list;
   

}
   
   
//   public ArrayList<InstructorDTO> Flist() { //교수출력
//
//      ArrayList<InstructorDTO> list = new ArrayList<InstructorDTO>();
//      
//      
//      
//   try{
//      
//      String sql = "SELECT * FROM FACULTY F INNER JOIN INSTRUCTOR ON F.STAFFCODE = I.STAFFCODE WHERE BETWEENCODE = 1";
//      
//      ResultSet rs = stat.executeQuery(sql);
//      
//      
//      
//   } catch (Exception e) {
//      System.out.println(e.toString());
//   }
//   
//   return list;
//   
//
//}
//   
   
   
}//DD