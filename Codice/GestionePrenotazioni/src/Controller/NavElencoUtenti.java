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

import Model.Utente;
import Model.UtenteDAO;

/**
 * Servlet implementation class NavElencoUtenti
 */
@WebServlet("/NavElencoUtenti")
public class NavElencoUtenti extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =  request.getSession();
	
		ArrayList<Utente> listaUtente =  new UtenteDAO().doRetrieveAll();
			
			session.setAttribute("listaUtente", listaUtente);
		RequestDispatcher view =  request.getRequestDispatcher("WEB-INF/ElencoUtenti.jsp");
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
