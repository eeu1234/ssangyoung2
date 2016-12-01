package com.project1.main;

import java.util.Scanner;

public class Function {
	public static Scanner scan;
	
	 
	 
	 
	   public static void init() {
	      
	      scan = new Scanner(System.in);
	      
	   
	   
	   }

	   public static void pause() {
		      System.out.println();
		      System.out.println("계속하시려면 엔터키를 입력하세요.");
		      scan.nextLine();//블럭 걸리게함
		      
		   }
}
