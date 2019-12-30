package Controller;
import Model.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NavDipartimento
 */
@WebServlet("/NavDipartimento")
public class NavDipartimento extends ServletBasic {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =  request.getSession();
		
		ArrayList<Model.Dipartimento> listaDipartimenti = new DipartimentoDAO().doRetrieveAll();
		session.setAttribute("listaDipartimenti", listaDipartimenti);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/Dipartimenti.jsp");
		view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}