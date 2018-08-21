package com.stpl.trainee.assignment5.juint;

import static org.junit.Assert.assertEquals;
import java.sql.SQLException;
import java.util.Random;

import org.junit.Test;
import com.stpl.trainee.assignment5.bean.StudentBean;
import com.stpl.trainee.assignment5.service.StudentRegistration;
import com.stpl.trainee.assignment5.service.StudentUpdate;
import com.stpl.trainee.assignment5.service.StudentView;
import com.stpl.trainee.assignment5.service.StudentDelete;
import com.stpl.trainee.assignment5.service.StudentLogin;

public class Student_Repository_ServletJSP_TestCase {

	@Test
	public void StudentLoginTestCase() {

		StudentLogin studentlogin = new StudentLogin();
		StudentBean studentBean = new StudentBean();

		try {

			studentlogin.login(studentBean, "SELECT * FROM STUDENT_REGISTER WHERE USERNAME = ? AND PASWORD = ?");

			studentBean.setUserName("SP@123");
			studentBean.setPassword("SP@123");

			int expected = studentlogin.login(studentBean,
					"SELECT * FROM STUDENT_REGISTER WHERE USERNAME = ? AND PASWORD = ?");
			if (expected != 0) {
				assertEquals(expected, 1);
			} else {
				assertEquals(expected, 0);
			}

			studentlogin.login(studentBean, "Wrong Sql String");

		} catch (SQLException e) {
		}
	}

	@Test
	public void StudentRegistrationTestCase() {

		StudentRegistration studentRegistration = new StudentRegistration();
		StudentBean studentBean = new StudentBean();

		try {

			Random random = new Random();
			int x = random.nextInt(100);

			studentBean.setUserName("RO@" + x);
			studentBean.setPassword("RO@" + x);
			studentBean.setFullName("RONY ROY");
			studentBean.setAddress("KOLKATA, WEST BENGAL");
			studentBean.setDob("1996-01-14");
			studentBean.setGender("MALE");
			studentBean.setContact("44454545");
			studentBean.setEmail("abc@bc.com");
			studentBean.setCourseName("MCA");
			studentBean.setCourseId("M101");
			studentBean.setFees("48,000");
			studentBean.setDuration("3 YEAR");

			int expected = studentRegistration.register(studentBean,
					"INSERT INTO STUDENT_REGISTER VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
			if (expected != 0) {
				assertEquals(expected, 1);
			} else {
				assertEquals(expected, 0);
			}

			studentRegistration.register(studentBean, "Wrong Sql string");

		} catch (SQLException e) {
		}
	}

	@Test
	public void StudentUpdateTestCase() {

		StudentUpdate studentUpdate = new StudentUpdate();
		StudentBean studentBean = new StudentBean();

		try {

			Random random = new Random();
			int x = random.nextInt(100);

			studentBean.setUserName("RO@" + x);
			studentBean.setPassword("RO@" + x);

			studentBean.setFullName("RONY ROY");
			studentBean.setAddress("KOLKATA, WEST BENGAL");
			studentBean.setDob("1996-01-14");
			studentBean.setGender("MALE");
			studentBean.setContact("44454545");
			studentBean.setEmail("abc@bc.com");
			studentBean.setCourseName("MCA");
			studentBean.setCourseId("M101");
			studentBean.setFees("48,000");
			studentBean.setDuration("3 YEAR");

			int expected = studentUpdate.update(studentBean,
					"UPDATE STUDENT_REGISTER SET FULNAME=?, PASWORD=?, ADDRESS=?, DOB=?, "
							+ "GENDER=?, CONTACT=?, EMAIL=?, COURSENAME=?, COURSEID=?, FEES=?, DURATION=? WHERE USERNAME=?");
			if (expected != 0) {
				assertEquals(expected, 1);
			} else {
				assertEquals(expected, 0);
			}

			studentUpdate.update(studentBean, "Wrong Sql String");

		} catch (SQLException e) {
		}
	}

	@Test
	public void StudentViewTestCase() {

		StudentView studentView = new StudentView();
		StudentBean studentBean = new StudentBean();

		try {
			int expected = 0;

			studentView.view(studentBean, "SELECT * FROM STUDENT_REGISTER WHERE USERNAME = ?");

			studentBean.setUserName("SP@123");
			studentBean.setPassword("SP@123");
			studentBean = studentView.view(studentBean, "SELECT * FROM STUDENT_REGISTER WHERE USERNAME = ?");

			if (studentBean != null) {
				expected = 1;
				assertEquals(expected, 1);
			} else {
				assertEquals(expected, 0);
			}
			studentView.view(studentBean, "Wrong Sql String");

		} catch (SQLException e) {
		}
	}

	@Test
	public void StudentDeleteTestCase() {

		StudentRegistration studentRegistration = new StudentRegistration();
		StudentDelete studentDelete = new StudentDelete();
		StudentBean studentBean = new StudentBean();

		try {
			
			Random random = new Random();
			int x = random.nextInt(100);

			studentBean.setUserName("RO@" + x);
			studentBean.setPassword("RO@" + x);
			studentBean.setFullName("RONY ROY");
			studentBean.setAddress("KOLKATA, WEST BENGAL");
			studentBean.setDob("1996-01-14");
			studentBean.setGender("MALE");
			studentBean.setContact("44454545");
			studentBean.setEmail("abc@bc.com");
			studentBean.setCourseName("MCA");
			studentBean.setCourseId("M101");
			studentBean.setFees("48,000");
			studentBean.setDuration("3 YEAR");
			
			StudentBean studentBean2 = new StudentBean();
			String uname = studentBean.getUserName();
			studentBean2.setUserName(uname);
			
			int result = studentRegistration.register(studentBean,
					"INSERT INTO STUDENT_REGISTER VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
			if(result != 0)
			{
				int expected = studentDelete.delete(studentBean,
						"DELETE FROM STUDENT_REGISTER WHERE USERNAME = ?");
				
				if (expected != 0) {
					assertEquals(expected, 1);
				} else {
					assertEquals(expected, 0);
				}
			}

			studentBean.setUserName("RO@84");
			studentBean.setPassword("RO@84");
			studentDelete.delete(studentBean, "DELETE FROM STUDENT_REGISTER WHERE USERNAME =?");
			
			//studentDelete.delete(studentBean, "Wrong Sql String");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
