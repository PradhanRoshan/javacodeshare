package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.User;
import com.service.UserService;
 
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session; 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page"); //null
		session = request.getSession();
		if(page == null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else {
			doPost(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page"); // home / login / sign-up 
		// contact / loginForm / logout /signUpForm
		session = request.getSession();
		if(page.equalsIgnoreCase("home")) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else
		if(page.equalsIgnoreCase("login")) {
			request.setAttribute("error_msg", "");
			request.setAttribute("username", "");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else
		if(page.equalsIgnoreCase("sign-up")) {
			request.getRequestDispatcher("sign-up.jsp").forward(request, response);
		}
		else
		if(page.equalsIgnoreCase("contact")) {
			request.getRequestDispatcher("contact.jsp").forward(request, response);
		}
		else  
		if(page.equalsIgnoreCase("loginForm")) {
			String username = request.getParameter("username"); 
			String password = request.getParameter("password");
			UserService userService = new UserService();
			boolean isPresent = userService.validateCredentials(username,password);
			if(isPresent) {
				session.setAttribute("username", username); //<key:username, value:harry>
				request.getRequestDispatcher("productHome.jsp").forward(request, response);
			}
			else {
				request.setAttribute("error_msg", "Invalid Credentials");
				request.setAttribute("username", username);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		else
		if(page.equalsIgnoreCase("logout")) {
			session.invalidate();
			request.setAttribute("error_msg", "logout Success!!!");
			request.setAttribute("username", "");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		if(page.equalsIgnoreCase("signUpForm")) {
			UserService userService = new UserService();
			String name = request.getParameter("name"); 
			String username = request.getParameter("username"); 
			String password = request.getParameter("password");
			User user =new User();
			user.setName(name);
			user.setUsername(username);
			user.setPassword(password);
			userService.insertUser(user);
			request.setAttribute("error_msg", "SignUp Success!!!");
			request.setAttribute("username", "");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
