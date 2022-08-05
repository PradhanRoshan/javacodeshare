package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.DB;
import com.model.Vendor;
 
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, res);
	}
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page"); //null  products
		if(page == null) {
			request.setAttribute("username", "harry");
			
			//request.getRequestDispatcher("index.jsp").forward(request, response);
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		else
		if(page.equalsIgnoreCase("products")) {
			//go to DB and fetch all vendors and give me List<Vendor> 
			DB db = new DB();
			List<Vendor> list = db.fetchVendors();
			request.setAttribute("list", list);
			System.out.println(list);
			request.getRequestDispatcher("product.jsp").forward(request, response);
		}
		 
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page"); //login 
		
		if(page.equalsIgnoreCase("login")) {
			String username = request.getParameter("username");
			//set the session 
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
		}
		doGet(request, response);
	}

}
/*
 doGet : doGet gets called 
 doPost : coming thru a form, method=post 
*/