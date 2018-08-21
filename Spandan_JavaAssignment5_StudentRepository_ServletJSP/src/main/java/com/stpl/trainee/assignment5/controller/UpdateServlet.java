package com.stpl.trainee.assignment5.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.stpl.trainee.assignment5.bean.StudentBean;
import com.stpl.trainee.assignment5.service.StudentUpdate;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {

	private static final Logger LOGGER = LogManager.getLogger(UpdateServlet.class);

	private static String jsStart = "<script type=\"text/javascript\">";
	private static String jsEnd = "</script>";

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
		super();

	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter print = response.getWriter();
		StudentBean beanObject = new StudentBean();
		int result;

		String fullName = request.getParameter("fullname");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String contact = request.getParameter("phone");
		String email = request.getParameter("email");
		String courseName = request.getParameter("course");
		String courseId = request.getParameter("cid");
		String fees = request.getParameter("fees");
		String duration = request.getParameter("duration");

		beanObject.setFullName(fullName);
		beanObject.setUserName(userName);
		beanObject.setPassword(password);
		beanObject.setAddress(address);
		beanObject.setDob(dob);
		beanObject.setGender(gender);
		beanObject.setContact(contact);
		beanObject.setEmail(email);
		beanObject.setCourseName(courseName);
		beanObject.setCourseId(courseId);
		beanObject.setFees(fees);
		beanObject.setDuration(duration);

		StudentUpdate student = new StudentUpdate();

		try {
			String sql = "UPDATE STUDENT_REGISTER SET FULNAME=?, PASWORD=?, ADDRESS=?, DOB=?, "
	        		+ "GENDER=?, CONTACT=?, EMAIL=?, COURSENAME=?, COURSEID=?, FEES=?, DURATION=? WHERE USERNAME=?";
			
			result = student.update(beanObject, sql);

			if (result != 0) {

				print.println(jsStart);
				print.println("alert('Student Details are updated Successfully..!');");
				print.println("location='AdminMenu.jsp';");
				print.println(jsEnd);
			} else {
				print.println(jsStart);
				print.println("alert('Wrong Username, Please try again..!');");
				print.println("location='ViewAndUpdate.jsp';");
				print.println(jsEnd);
			}
			
		} catch (SQLException e) {
			LOGGER.info("Erro is Update Servlet: " + e);
		}
	}

}
