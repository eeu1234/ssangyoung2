package com.project1.main;



import com.project1.DAO.FacultyDAO;
import com.project1.DAO.StudentDAO;
import com.project1.DTO.FacultyDTO;
import com.project1.DTO.StudentDTO;
import com.project1.admin.Admin;
import com.project1.faculty.Faculty;
import com.project1.student.Student;

import java.util.ArrayList;
public class main extends Function {

	public static String userCode ="";

	public static void main(String[] args) {
		System.out.println("	      ~@@@@@@-!@@@@@@@@@@@@@@@                                                                      	");
		System.out.println("	    #@@@@@@* @@@@@@@@@@@@@@@@@                                                                      	");
		System.out.println("	   @@@@@@@@ @@@@@@@@@@@@@@@@@@                                                                      	");
		System.out.println("	   @@@@@@@*.@@@@@@@@@@$@@@@@@@                                                                      	");
		System.out.println("	   @@@@@@@@ @@@@@@@@~      =@@                                                                      	");
		System.out.println("	   $@@@@@@@= @@@@@@@@@:                                                                             	");
		System.out.println("	    $@@@@@@@@ $@@@@@@@@@@         @@ @@        @@                          @@                       	");
		System.out.println("	      @@@@@@@@@:.$@@@@@@@@@.      @@ @@        @@                          @@   @@                  	");
		System.out.println("	       .@@@@@@@@@@ *@@@@@@@@$     @@ @@  @@@@  @@ @@.  @@  @@-  @@ @  #@@  @@ ,@@@@ @@ @@           	");
		System.out.println("	          :@@@@@@@@= @@@@@@@@*    @@ @@  @@@@@ @@  @@ @@  @@@@@ @@@@ @@@@@ @@ ,@@@@ @@ @@           	");
		System.out.println("	   @#.      $@@@@@@@$ @@@@@@@@    @@ @@  @@ @@ @@  @@ @@ ,@@@@@ @@@  @@;   @@   @@  ;@.@            	");
		System.out.println("	   @@@@@@$##@@@@@@@@@ @@@@@@@@    @@ @@  @@ @@ @@   @@@  :@@@@@ @@    *@@@ @@   @@   @@@            	");
		System.out.println("	   @@@@@@@@@@@@@@@@@@ @@@@@@@@    @@ @@  @@ @@ @@   @@@   @@ @@ @@   @@.@@ @@   @@.  @@             	");
		System.out.println("	   @@@@@@@@@@@@@@@@@ @@@@@@@@      @@@   @@ @@ @@    @,    @@@  @@    @@@; @@   @@@ @@@             	");
		System.out.println("	   @@@@@@@@@@@@@@$ $@@@@@#*                                                         @*           	");
		System.out.println("-----------------------------------------------------------------------------------------------------------");   
		System.out.println("-----------------------------------------------------------------------------------------------------------");   


		Function.init();
		login();






	}//main






	/**
	 * 로그인
	 */
	public static  void login(){

		String id="";
		String pass="";
		userCode = "";
		boolean flag = true;//오류시 루프를 위한 flag

		while(flag){
			boolean flag2 = true;
			while(flag2){

				System.out.print("\t\t\t\t\t【아이디】  : ");
				id = scan.nextLine();
				if(id.length() <= 9  || id.length() >= 4){
					flag2 = false;
					break;
				}
				System.out.println("\t\t\t\t\t"+"※다시 입력해주세요.※ ");
				System.out.println("\t\t\t\t\t"+"-------------------");
			}//flag2


			System.out.print("\t\t\t\t\t【비밀번호】 : ");
			pass = scan.nextLine();





			//학생 ,교원 , 관리자 구분
			String level =  id.substring(0,1);




			//교원
			if(level.contains("1")){
				

				FacultyDAO daoF = new FacultyDAO();
				ArrayList<FacultyDTO> list = daoF.faculty_list();


				//교원 메뉴 호출 
				for (FacultyDTO dtoF : list) {
					//교원 테이블에서 ID와 비밀번호 있는지 여부 확인
					if(dtoF.getStaffCode().equals(id) && dtoF.getPassWord().equals(pass)){
						userCode = dtoF.getStaffCode();
						//교원메뉴 출력	
						Faculty.Faculty();

						flag= false;
						break;
					}

				} // for


				//학생  
			}else if(level.equals("2")){


				StudentDAO daoS = new StudentDAO();
				ArrayList<StudentDTO> list = daoS.studentSearch();

				//학생 메뉴 호출

				for (StudentDTO dtoS : list) {
					//학생 테이블에서 ID와 비밀번호 있는지 여부 확인
					if(dtoS.getStudentNumber().equals(id) && dtoS.getPassword().equals(pass)){
						//  userCode=dto.getStudentNumber();
						userCode = dtoS.getStudentNumber();


						//menu();
						Student.Student();
						flag= false;

						break;
					}

				} // for




			}else if(level.equals("a")){
				Admin.Admin();
				flag= false;
			}


			else{

			}










		}//while
	}

}//class