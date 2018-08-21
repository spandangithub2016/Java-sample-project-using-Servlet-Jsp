package com.stpl.trainee.assignment5.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.stpl.trainee.assignment5.bean.StudentBean;
import com.stpl.trainee.assignment5.connection.MyConnect;
import com.stpl.trainee.assignment5.constants.Constants;

public class StudentView {

	private PreparedStatement ps;
	private ResultSet resultSet;
	private StudentBean studentBean = new StudentBean();
	
	public StudentView()
	{
		// To fix sonar issue
	}

	public StudentBean view(StudentBean beanObject, String sql) throws SQLException {

		final Connection conn = MyConnect.connect();

		try {

			ps = conn.prepareStatement(sql);
			ps.setString(Constants.ONE, beanObject.getUserName());

			resultSet = ps.executeQuery();

			if (resultSet.next()) {

				studentBean.setFullName(resultSet.getString("FULNAME"));
				studentBean.setUserName(resultSet.getString("USERNAME"));
				studentBean.setPassword(resultSet.getString("PASWORD"));
				studentBean.setAddress(resultSet.getString("ADDRESS"));
				studentBean.setDob(resultSet.getString("DOB"));
				studentBean.setGender(resultSet.getString("GENDER"));
				studentBean.setContact(resultSet.getString("CONTACT"));
				studentBean.setEmail(resultSet.getString("EMAIL"));
				studentBean.setCourseName(resultSet.getString("COURSENAME"));
				studentBean.setCourseId(resultSet.getString("COURSEID"));
				studentBean.setFees(resultSet.getString("FEES"));
				studentBean.setDuration(resultSet.getString("DURATION"));

			}
		} 
		finally {

			resultSet.close();
			ps.close();
			conn.close();

		}
		return studentBean;
	}
}
