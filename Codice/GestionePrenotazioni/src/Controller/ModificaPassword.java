package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.*;

/**
 * Servlet implementation class ModificaPassword
 */
@WebServlet("/ModificaPassword")
public class ModificaPassword extends ServletBasic {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Utente utente = null;
		String email = request.getParameter("email");
		String newPassw = request.getParameter("newPassw");
		System.out.println("email: "+email+"password: "+newPassw);
		// trova l'utente nel database
		utente = new UtenteDAO().doRetrieveByKey(email, newPassw);

		if ( (email != null && newPassw != null) || utente == null) {
				System.out.println("if di errore");
			request.setAttribute("resultPassword", "0");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/Homepage.jsp");
			requestDispatcher.forward(request, response);
		} else {
			System.out.println("if di buono ");
			request.setAttribute("resultPassword", (UtenteDAO.doUpdate(email, newPassw)));
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/Homepage.jsp");
			requestDispatcher.forward(request, response);
	}
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
