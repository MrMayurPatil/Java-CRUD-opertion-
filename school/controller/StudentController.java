package com.school.controller;

import java.util.Scanner;

import com.school.dto.Student;
import com.school.service.StudentService;

public class StudentController {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Student student = new Student();
		System.out.println("Enter the student details");
		System.out.println("Enter Student ID");
		int id =sc.nextInt();
		System.out.println("Enter name of student");
		String name =sc.next();
		System.out.println("Enter email of student");
		String email =sc.next();
		student.setId(id);
		student.setName(name);
		student.setEmail(email);
		
		StudentService studentService  = new StudentService();
		Student s = studentService.saveStudent(student);
		if(s!=null) {
			System.out.println(s.getId() +" Saved Succestsfully");
		}
		
	
	}
}
