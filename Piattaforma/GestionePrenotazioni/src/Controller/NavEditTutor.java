package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Corso;
import Model.CorsoDAO;

/**
 * Servlet implementation class NavEditTutor
 */
@WebServlet("/NavEditTutor")
public class NavEditTutor extends ServletBasic implements Servlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//ritorna la lista di tutti i corsi di ateneo
		ArrayList<Corso> listaCorsi =  courseDAO.doRetrieveAll(); 
		String email = request.getParameter("email");
		System.out.println("Controller: navEditTutor  "+email);
		request.setAttribute("listaCorsi", listaCorsi);
		request.setAttribute("email", email);

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/EditTutor.jsp");
		view.forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
