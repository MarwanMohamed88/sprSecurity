package com.sprSecurity.spring.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sprSecurity.spring.data.service.TempTableService;
import com.sprSecurity.spring.dto.TempTableDTO;
import com.sprSecurity.spring.enums.Status;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private TempTableService  service;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service (HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException {
		PrintWriter out = response.getWriter();
		try {
			TempTableDTO dto = new TempTableDTO();
			dto.setStatus(Status.ACTIVE);
			dto.setId("Adam");
			dto.setTempEmail("adam@gmail.com");
			service.createEntity(dto);
			out.println("");
		} finally {
			out.close();
		}
	}
	
}
