package Controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import Model.Utente;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends ServletBasic {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessione = request.getSession();
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Utente utente = null;
		
		if (email != null && password != null) {
			utente = userDAO.doRetrieveByKey(email, password);
		}
		if (utente == null) {
			request.setAttribute("messaggio", "Login fallito");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/Homepage.jsp");
			requestDispatcher.forward(request, response);
		} else {
			// salva la data corrente
			LocalDateTime ldt = LocalDateTime.now();
			DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ITALIAN);
			String formatter = formmat1.format(ldt);

			sessione.setAttribute("CurrentData", formatter);
			sessione.setAttribute("utente", utente);

			// se l'utente è amminsitratore di dipartimento
			if ((utente.getTipoUtente()) == 2) {
				String dip = dipDAO.doRetrieveByKey(utente.getEmail());
				sessione.setAttribute("dipartimento", dip);
			}

			request.setAttribute("messaggio", "Login avvenuto");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/Homepage.jsp");
			requestDispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
