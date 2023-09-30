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

@WebServlet("/SaveReg")
public class SaveRegistration extends HttpServlet{
	public static final long serialVersionUID = 1L;
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException{
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/NewReg.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException{
		
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		DIOService service = new DIOServiceImpl();
		
		service.connectDB();
		
		service.saveRegistration(name, city, email, mobile);
		
		request.setAttribute("msg", "Your record is saved successfully!");
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/NewReg.jsp");
		rd.forward(request, response);
		
		
	}
}
