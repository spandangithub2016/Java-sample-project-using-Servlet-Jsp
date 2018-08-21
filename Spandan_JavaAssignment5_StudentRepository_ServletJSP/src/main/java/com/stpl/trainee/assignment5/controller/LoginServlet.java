package com.stpl.trainee.assignment5.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stpl.trainee.assignment5.bean.StudentBean;
import com.stpl.trainee.assignment5.service.StudentLogin;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static String jsStart = "<script type=\"text/javascript\">";
	private static String jsEnd = "</script>";

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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

		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		beanObject.setUserName(userName);
		beanObject.setPassword(password);

		try {

			if ("admin".equals(userName) && "admin".equals(password)) {

				print.println(jsStart);
				print.println("alert('Hi Spandan..! Login Successfull');");
				print.println("location='AdminMenu.jsp';");
				print.println(jsEnd);

			} else {

				StudentLogin student = new StudentLogin();
				String sql = "SELECT * FROM STUDENT_REGISTER WHERE USERNAME = ? AND PASWORD = ?";
				
				result = student.login(beanObject, sql);

				if (result != 0) {
					print.println(jsStart);
					print.println("alert('User Login Successfull');");
					print.println("location='UserMenu.jsp';");
					print.println("</script>");
				} else {
					print.println(jsStart);
					print.println("alert('Login Falied, Wrong Credentials, Try Again..!');");
					print.println("location='Login.jsp';");
					print.println(jsEnd);
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
