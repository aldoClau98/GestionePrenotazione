package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.UtenteDAO;

/**
 * Servlet implementation class Registrazione
 */
@WebServlet("/Registrazione")
public class Registrazione extends ServletBasic {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int temp = 1;
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String cognome = request.getParameter("cognome");
		String[] type = email.split("@");

		if (type[1].equals("studenti.unisa.it"))
			try {
				temp = userDAO.doSave(email, password, nome, cognome, 0);
				request.setAttribute("messaggio", "Registrazione avvenuta");
			} catch (Exception e) {
				request.setAttribute("messaggio", "Registrazione non avvenuta");
			}
		else if (type[1].equals("unisa.it"))
			try {
				temp = userDAO.doSave(email, password, nome, cognome, 1);
				request.setAttribute("messaggio", "Registrazione avvenuta");
			} catch (Exception e) {
				request.setAttribute("messaggio", "Registrazione non avvenuta");
			}

		/*
		 * risultato dell operazione registrazione 1 se � avvenuta con successo 0 se
		 * l'operazione � fallita
		 */

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/Login.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
