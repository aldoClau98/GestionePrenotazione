package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.*;

/**
 * Servlet implementation class NavEliminaDipartimento
 */
@WebServlet("/NavEliminaDipartimento")
public class NavEliminaDipartimento extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session =  request.getSession();
		
		ArrayList<Model.Dipartimento> listaDip =  new DipartimentoDAO().doRetrieveAll();
		session.setAttribute("listaDip", listaDip);
		
		RequestDispatcher view  =  request.getRequestDispatcher("WEB-INF/RimuoviDipartimento.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}