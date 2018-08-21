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
import com.stpl.trainee.assignment5.service.StudentView;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewServlet() {
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
		StudentView student = new StudentView();

		String userName = request.getParameter("username");
		beanObject.setUserName(userName);

		try {
			String sql = "SELECT * FROM STUDENT_REGISTER WHERE USERNAME = ?";
			beanObject = student.view(beanObject, sql);

			if (beanObject.getUserName() != null) {

				request.setAttribute("fullname", beanObject.getFullName());
				request.setAttribute("username", beanObject.getUserName());
				request.setAttribute("password", beanObject.getPassword());
				request.setAttribute("address", beanObject.getAddress());
				request.setAttribute("dob", beanObject.getDob());
				request.setAttribute("gender", beanObject.getGender());
				request.setAttribute("contact", beanObject.getContact());
				request.setAttribute("email", beanObject.getEmail());
				request.setAttribute("coursename", beanObject.getCourseName());
				request.setAttribute("courseid", beanObject.getCourseId());
				request.setAttribute("fees", beanObject.getFees());
				request.setAttribute("duration", beanObject.getDuration());
				request.getRequestDispatcher("ViewAndUpdate.jsp").forward(request, response);

			} else {
				print.println("<script type=\"text/javascript\">");
				print.println("alert('Sorry, Username not exists, Try Again..!');");
				print.println("location='ViewInput.jsp';");
				print.println("</script>");

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
