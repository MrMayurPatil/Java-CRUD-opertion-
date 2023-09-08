package com.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.school.configuration.HelperClass;
import com.school.dto.Student;

public class StudentDao {

	HelperClass helperclass = new HelperClass();
	
	Connection connection =null;

	public boolean updateStudent(Student student) {
		connection =helperclass.getConnection();

		String update ="UPDATE student SET name=?, email=? WHERE id=?";
		int i=0;
		
		try {
			PreparedStatement preparedStatement =connection.prepareStatement(update);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getEmail());
			preparedStatement.setInt(3, student.getId());
			 i= preparedStatement.executeUpdate();
			
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
		if(i>0){
			return true;
		}else {
			return false;
		}
	}
	
	public Student getStudent(Student student) {
		connection= helperclass.getConnection();
		String get ="SELECT * FROM student ";
		
		try {
			
			PreparedStatement preparedStatement =connection.prepareStatement(get);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return student;
		
	}
	
	public boolean deleteStudent(int id) {
		connection=helperclass.getConnection();
		String delete ="DELETE  FROM student WHERE id=?";
		int i=0;
		try {
			PreparedStatement preparedStatement =connection.prepareStatement(delete);
			 preparedStatement.setInt(1, id);
			
//			execute
		 i= preparedStatement.executeUpdate();
		 
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
	
	public Student saveStudent(Student student) {
		
		connection =helperclass.getConnection();
		String sql ="INSERT INTO student values (?,?,?)";
		
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getEmail());
			
//			execute
			preparedStatement.execute();
				
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
		return student;
		
		
		}
	
}
