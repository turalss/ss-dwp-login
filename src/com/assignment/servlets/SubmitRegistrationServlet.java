package com.assignment.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assignment.dao.UserDAO;
import com.assignment.dao.UserDAOImpl;
import com.assignment.models.User;

/**
 * Servlet implementation class SubmitRegistrationServlet
 */
@MultipartConfig // tells the sever that it has complex data and mapped the old fashioned way. look at web.xml
public class SubmitRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDAO userDAO = new UserDAOImpl();
		
		User user =  new User();
		user.setUsername(request.getParameter("username"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		boolean isSuccess = userDAO.createUser(user);
		
		if (isSuccess) { 
			request.getSession().setAttribute("message", "Successfully registered");
			request.getSession().setAttribute("messageClass", "alert-success");
			response.sendRedirect(request.getContextPath() + "/login");
		} else {
			request.getSession().setAttribute("message", "There was a problem with your registration");
			request.getSession().setAttribute("messageClass", "alert-danger");
			response.sendRedirect(request.getContextPath() + "/registration");
		}
		

	}

}
