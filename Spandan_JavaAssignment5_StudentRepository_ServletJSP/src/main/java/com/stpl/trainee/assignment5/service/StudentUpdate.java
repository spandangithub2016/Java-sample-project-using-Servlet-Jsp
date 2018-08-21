package com.stpl.trainee.assignment5.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.stpl.trainee.assignment5.bean.StudentBean;
import com.stpl.trainee.assignment5.connection.MyConnect;
import com.stpl.trainee.assignment5.constants.Constants;

public class StudentUpdate {
    
	private PreparedStatement ps;
	
	public StudentUpdate()
	{
		// To fix sonar issue
	}
    
    public int update(StudentBean beanObject, String sql) throws SQLException {

        int result = Constants.ZERO;
        final Connection connection = MyConnect.connect(); 

        try {
        	
        	ps = connection.prepareStatement(sql);
        	
        	ps.setString(Constants.ONE, beanObject.getFullName());
			ps.setString(Constants.TWO, beanObject.getPassword());
			ps.setString(Constants.THREE, beanObject.getAddress());
			ps.setString(Constants.FOUR, beanObject.getDob());
			ps.setString(Constants.FIVE, beanObject.getGender());
			ps.setString(Constants.SIX, beanObject.getContact());
			ps.setString(Constants.SEVEN, beanObject.getEmail());
			ps.setString(Constants.EIGHT, beanObject.getCourseName());
			ps.setString(Constants.NINE, beanObject.getCourseId());
			ps.setString(Constants.TEN, beanObject.getFees());
			ps.setString(Constants.ELEVEN, beanObject.getDuration());
			
            ps.setString(Constants.TWELVE, beanObject.getUserName());
            result = ps.executeUpdate();

        } 
        finally {
        	ps.close();
			connection.close();
		}
        return result;
    }
}
