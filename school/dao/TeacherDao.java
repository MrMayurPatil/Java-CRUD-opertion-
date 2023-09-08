package com.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.school.configuration.TeacherHelper;
import com.school.dto.Teacher;

public class TeacherDao {

	TeacherHelper teacherHelper = new TeacherHelper();
	Connection connection= null;
	
	public boolean deleteTeacher(int id) {
		int i=0;
		String delete= "DELETE FROM teacher WHERE id=?";
	connection=	teacherHelper.getConnection();
	
	try {
		PreparedStatement preparedStatement =connection.prepareStatement(delete);
	 	preparedStatement.setInt(1, id);
	 	preparedStatement.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	finally {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	if(i>0) {
		return true;
	}else {
		return false;
	}
	
	}
	public Teacher saveTeacher(Teacher teacher) {
		
		connection = teacherHelper.getConnection();
		String sql = "INSERT INTO teacher VALUES(?,?,?)";
		
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, teacher.getId());
			prepareStatement.setString(2,teacher.getName());
			prepareStatement.setString(3,teacher.getEmail());
			
			prepareStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return teacher;
	}
	
	
	
}
