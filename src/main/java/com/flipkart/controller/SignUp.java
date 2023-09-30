package com.flipkart.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flipkart.model.DIOService;
import com.flipkart.model.DIOServiceImpl;

@WebServlet("/signup")
public class SignUp extends HttpServlet{
	
	public static final long serialVersionUID = 1L;
	
	
protected void doGet(HttpServletRequest request, HttpServletResponse response)
					 throws ServletException, IOException{
	
	RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/SignUp.jsp");
	rd.forward(request, response);
	
}

protected void doPost(HttpServletRequest request, HttpServletResponse response)
					 throws ServletException, IOException{
	
	String email = request.getParameter("email");
	
	String password = request.getParameter("password");
	
	DIOService service = new DIOServiceImpl();
	
	service.connectDB();
	
	service.saveDetails(email, password);
	
	RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
	
	rd.forward(request, response);
		
}

}
