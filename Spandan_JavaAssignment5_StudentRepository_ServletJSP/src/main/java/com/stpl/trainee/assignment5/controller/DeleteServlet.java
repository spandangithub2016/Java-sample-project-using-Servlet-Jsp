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
import com.stpl.trainee.assignment5.service.StudentDelete;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

	private static String jsStart = "<script type=\"text/javascript\">";
	private static String jsEnd = "</script>";

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteServlet() {
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
		int result = 0;

		String userName = request.getParameter("username");
		beanObject.setUserName(userName);

		StudentDelete student = new StudentDelete();
		String sql = "DELETE FROM STUDENT_REGISTER WHERE USERNAME = ?";

		try {
			result = student.delete(beanObject, sql);

			if (result != 0) {

				print.println(jsStart);
				print.println("alert('Student deleted successfully');");
				print.println("location='AdminMenu.jsp';");
				print.println(jsEnd);
			} else {
				print.println(jsStart);
				print.println("alert('Wrong Username, please try again..!');");
				print.println("location='Delete.jsp';");
				print.println(jsEnd);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
