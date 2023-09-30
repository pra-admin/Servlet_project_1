package com.flipkart.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flipkart.model.DIOService;
import com.flipkart.model.DIOServiceImpl;

@WebServlet("/ListAll")
public class ReadRegController extends HttpServlet{
	
	public static final long serialVersionUID = 1L;
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException{
		
		DIOService service = new DIOServiceImpl();
		
		service.connectDB();
		
		ResultSet results = service.listAll();
		
		request.setAttribute("results", results);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/ListAll.jsp");
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException{
		
	}

}
