package com.project1.admin.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 반복 되는 부분을 빼놓고 ip주소에 따라서만 바궈주면 활용도가 높다
 
 
 
 
 **/
public  class DBUtil {
	private static Connection conn = null;
	
	// 커넥션 객체를 만들어서 반환을 해주는 메서드
	public static Connection open(){
		
		//String url = "jdbc:oracle:thin:@localhost:1521:xe";// DB 정보
		String url = "jdbc:oracle:thin:@eeu1234.iptime.org:1521:adam";
		String id = "jinwoo";// 계정 ID
		String pw = "java1234"; //계정 PW 
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");// DB DRIVER ROAD
															//오라클 드라이버 설치  로드
			// 디비에 접속 암묵적인 Connection
			conn =	DriverManager.getConnection(url,id,pw);// 
		} catch (Exception e) {
			System.out.println("DBUtil : " + e.toString());
		}
		return conn;
		
	}//conn
	
	public static void close(){
			
		try {
			if(conn != null && conn.isClosed()){
				conn.close();// 접속을 끊어주세요
			}
		} catch (Exception e) {
			System.out.println("DBUtil : " + e.toString());
		}
		
	}//close
	
	public static Connection open(String server, String id, String pw){
		
		String url = "jdbc:oracle:thin:@" + server +":1521:xe";
		
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 디비에 접속 
			conn =	DriverManager.getConnection(url,id,pw);
			
		} catch (Exception e) {
			System.out.println("DBUtil : " + e.toString());
		}
		return conn;
		
	}//conn
	
	
	
	
	
}
