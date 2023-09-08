package com.school.controller;

import java.util.Scanner;

import com.school.dto.Teacher;
import com.school.service.TeacherService;

public class TeacherController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		Teacher teacher = new Teacher();
		System.out.println("Enter the details of teacher ");
		System.out.println("Enter the id of teacher");
		int id= sc.nextInt();
		System.out.println("Enter the name of teacher");
		String name= sc.next();
		System.out.println("Enter the email of teacher ");
		String email =sc.next();
		teacher.setId(id);
		teacher.setEmail(email);
		teacher.setName(name);
		
		TeacherService teacherService = new TeacherService();
		
		Teacher a= teacherService.saveTeacher(teacher);
		if(a!=null) {
			System.out.println(teacher.getId()+ " Enter Succesfully");
		}
	}

}
