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

@WebServlet("/login")
public class LoginController extends HttpServlet {
	public static final long serialVersionUID = 1L;


protected void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException{
	
	}


protected void doPost(HttpServletRequest request, HttpServletResponse response)
					 throws ServletException, IOException{
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			
			DIOService service = new DIOServiceImpl();
			
			service.connectDB();
			
			boolean status = service.verifyLogin(name, password);
			
			if(status==true) {
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/NewReg.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("error", "Invalid username/password");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
	}
}



