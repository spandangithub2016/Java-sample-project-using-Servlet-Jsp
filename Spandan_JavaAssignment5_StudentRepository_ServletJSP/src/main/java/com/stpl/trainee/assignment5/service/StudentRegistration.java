package com.stpl.trainee.assignment5.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.stpl.trainee.assignment5.bean.StudentBean;
import com.stpl.trainee.assignment5.connection.MyConnect;
import com.stpl.trainee.assignment5.constants.Constants;

public class StudentRegistration {
	
	private PreparedStatement prepStatement;
	
	public StudentRegistration()
	{
		// To fix sonar issue
	}
    
	public int register(StudentBean beanObject, String sql) throws SQLException {
	    
		int result = Constants.ZERO;
		final Connection con = MyConnect.connect(); 

		try { 
			
			prepStatement = con.prepareStatement(sql);
			
			prepStatement.setString(Constants.ONE, beanObject.getFullName());
			prepStatement.setString(Constants.TWO, beanObject.getUserName());
			prepStatement.setString(Constants.THREE, beanObject.getPassword());
			prepStatement.setString(Constants.FOUR, beanObject.getAddress());
			prepStatement.setString(Constants.FIVE, beanObject.getDob());
			prepStatement.setString(Constants.SIX, beanObject.getGender());
			prepStatement.setString(Constants.SEVEN, beanObject.getContact());
			prepStatement.setString(Constants.EIGHT, beanObject.getEmail());
			prepStatement.setString(Constants.NINE, beanObject.getCourseName());
			prepStatement.setString(Constants.TEN, beanObject.getCourseId());
			prepStatement.setString(Constants.ELEVEN, beanObject.getFees());
			prepStatement.setString(Constants.TWELVE, beanObject.getDuration());

			result = prepStatement.executeUpdate();
		} 
		finally {
			prepStatement.close();
			con.close();
		}
		return result;
	}
}
