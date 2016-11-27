package com.project1.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

//반복되는 JDBC 구문 처리
public class DBUtil {

	
	private static Connection conn = null;
	
	public static Connection open() {
		
		String url = "jdbc:oracle:thin:@eeu1234.iptime.org:1521:adam";
		String id = "total";
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
	

	
	public static Connection open(String server, String id, String pw) {
		
		String url = "jdbc:oracle:thin:@" + server + ":1521:adam";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url, id, pw);
			
		} catch (Exception e) {
			System.out.println("DBUtil : " + e.toString());
		}
		 
		return conn;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

