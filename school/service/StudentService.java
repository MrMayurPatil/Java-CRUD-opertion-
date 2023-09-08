package com.school.service;

import com.school.dao.StudentDao;
import com.school.dto.Student;

public class StudentService {

	StudentDao studentDao = new StudentDao();
	
	public Student saveStudent (Student student){
		return studentDao.saveStudent(student);
	}
	public Student getStudent(Student student) {
		return studentDao.getStudent(student);
	}
	
	public boolean deleteStudent(int id) {
		return studentDao.deleteStudent(id);
	}
	
	public boolean updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}
}

