package com.project1.admin.DTO;

public class SemesterClassDTO {
/*
* 학기구분
학기코드(PK)	NUMBER	semesterCode(PK)
년도	VARCHAR2(10)	year
학기	VARCHAR2(10)	semester
*/
	private int semesterCode;
	private String year;
	private String semester;

	
	public int getSemesterCode() {
		return semesterCode;
	}
	public void setSemesterCode(int semesterCode) {
		this.semesterCode = semesterCode;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}

	
	
	
	
	
}
