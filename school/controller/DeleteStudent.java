package com.school.controller;

import com.school.service.StudentService;

public class DeleteStudent {

	public static void main(String[] args) {
		
//		Student student = new Student;
		
		StudentService serviceStudent = new StudentService();
		boolean b= serviceStudent.deleteStudent(1);
		System.out.println(b);
		
	}

}
