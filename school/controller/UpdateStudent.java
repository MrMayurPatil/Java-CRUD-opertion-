package com.school.controller;

import com.school.dto.Student;
import com.school.service.StudentService;

public class UpdateStudent {

	public static void main(String[] args) {
		
		Student student =new Student();
		StudentService studentService = new StudentService();
		student.setId(2);
		student.setName("ja");
		student.setEmail("ja@mail.com");
		
	boolean b=	studentService.updateStudent(student);
		System.out.println(b);
		
	}

}
