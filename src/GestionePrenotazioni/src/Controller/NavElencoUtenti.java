package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Utente;

/**
 * Servlet implementation class NavElencoUtenti
 */
@WebServlet("/NavElencoUtenti")
public class NavElencoUtenti extends ServletBasic {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Utente> listaUtente = userDAO.doRetrieveAll();
		request.setAttribute("listaUtente", listaUtente);

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/ElencoUtenti.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
