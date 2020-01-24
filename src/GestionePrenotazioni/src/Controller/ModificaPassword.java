package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
//		String passw = request.getParameter("password");
		String newPassw = request.getParameter("rpassword");
		HttpSession session = request.getSession();

		utente = (Utente) session.getAttribute("utente");

		if (email == null || newPassw == null || utente == null) {
			request.setAttribute("messaggio", "Modifica non avvenuta");

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/Homepage.jsp");
			requestDispatcher.forward(request, response);
		} else {
			userDAO.doUpdate(email, newPassw);
			request.setAttribute("messaggio", "Modifica avvenuta");

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/Homepage.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
