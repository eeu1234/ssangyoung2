package com.project1.admin.DAO;

public class StudentDTO {
/*

STUDENT
studentNumber(PK)	CHAR(10)	�븰踰�(PK)
studentName	VARCHAR2(15)	�븰�깮�씠由�
password	N/A	鍮꾨�踰덊샇sdfsdf
email	N/A	�씠硫붿씪
classCode(FK)	CHAR(6)	�븰怨쇱퐫�뱶(FK)
 	
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
