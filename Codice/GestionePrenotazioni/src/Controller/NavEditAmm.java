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

import Model.DipartimentoDAO;
import Model.Utente;
import Model.UtenteDAO;

/**
 * Servlet implementation class NavAssegnaAmm
 */
@WebServlet("/NavEditAmm")
public class NavEditAmm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	HttpSession session = request.getSession();
	
	ArrayList<Model.Dipartimento> listaDipartimenti = new  DipartimentoDAO().doRetrieveAll();
		
		String email =  request.getParameter("email");
		session.setAttribute("listaDipartimenti", listaDipartimenti);
		request.setAttribute("docente", email);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/EditAmministratore.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
