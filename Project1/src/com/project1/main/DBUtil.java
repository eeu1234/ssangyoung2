package com.project1.main;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

   
   private static Connection conn = null;
   
   public static Connection open() {
      
      String url = "jdbc:oracle:thin:@eeu1234.iptime.org:1521:adam";
      String id = "jinwoo";
      String pw = "java1234";
      
      try {
         
         Class.forName("oracle.jdbc.driver.OracleDriver");
         
         conn = DriverManager.getConnection(url, id, pw);
         
      } catch (Exception e) {
         System.out.println("DBUtil : " + e.toString());
      }
      
      return conn;
      
   }
   
   public static void close() {
      
      try {
         
         if (conn != null && !conn.isClosed()) {
            conn.close();
         }
         
      } catch (Exception e) {
         System.out.println("DBUtil : " + e.toString());
      }
      
   }
}
   
