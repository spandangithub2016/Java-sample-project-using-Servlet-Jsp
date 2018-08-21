package com.stpl.trainee.assignment5.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.stpl.trainee.assignment5.bean.StudentBean;
import com.stpl.trainee.assignment5.connection.MyConnect;
import com.stpl.trainee.assignment5.constants.Constants;

public class StudentDelete {
	
	private PreparedStatement ps;
	
	public StudentDelete()
	{
		// To fix sonar issue
	}
    
    public int delete(StudentBean beanObject, String sql) throws SQLException{

        int result = Constants.ZERO;
        final Connection con = MyConnect.connect();
        
        try{
        	
        	ps = con.prepareStatement(sql);
            ps.setString(Constants.ONE, beanObject.getUserName());
            result = ps.executeUpdate();
        } 
        finally {
        	ps.close();
			con.close();
		}
        return result;
    }
}
