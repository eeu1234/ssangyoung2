package com.project1.admin.DAO;

public class StudentDTO {
/*

STUDENT
stsdfdfudentNumber(PK)	ddddCHAR(10)	학번(PK)
studentName	VARCHAR2(15)	학생이름
password	N/A	비밀번호
email	N/A	이메일sdfsdfdsfsdfsdfsdf
classCode(FK)	CHAR(6)	학과코드(FsdfsdffK)
 	sdf
**/


String studentNumber;
String studentName;
String password;
String email;
String classCode;
public String getStudentNumber() {
	return studentNumber;
}
public void setStudentNumber(String studentNumber) {
	this.studentNumber = studentNumber;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getClassCode() {
	return classCode;
}
public void setClassCode(String classCode) {
	this.classCode = classCode;
}
	
	
}
