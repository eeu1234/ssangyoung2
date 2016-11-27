package com.project1.DAO;

import java.sql.Connection;
import java.sql.Statement;


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
		 
	
	
	
	public void add() {
		
		
		
		
	}
}
