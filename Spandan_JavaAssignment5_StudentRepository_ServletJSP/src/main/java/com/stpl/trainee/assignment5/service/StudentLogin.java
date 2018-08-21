package com.stpl.trainee.assignment5.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.stpl.trainee.assignment5.bean.StudentBean;
import com.stpl.trainee.assignment5.connection.MyConnect;
import com.stpl.trainee.assignment5.constants.Constants;

public class StudentLogin {

	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public StudentLogin()
	{
		// To fix sonar issue
	}

	public int login(StudentBean beanObject, String sql) throws SQLException {

		int result = Constants.ZERO;
		final Connection con = MyConnect.connect();

		try {

			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(Constants.ONE, beanObject.getUserName());
			preparedStatement.setString(Constants.TWO, beanObject.getPassword());

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				result = Constants.ONE;
			}
		} 
		finally {

			resultSet.close();
			preparedStatement.close();
			con.close();

		}
		return result;
	}
}
