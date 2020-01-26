package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

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

		String email = request.getParameter("email");
		if(email == null)
			request.setAttribute("messaggio", "Modifica fallita");
		else {


			String passw = request.getParameter("password");
			if(passw == null)
				request.setAttribute("messaggio", "Errore, campo Password non compilato");
			else {
				
				
				Utente utente = userDAO.doRetrieveByKey(email, passw);
				if(utente == null)
					request.setAttribute("messaggio", "Errore, campo Password corrente non valido");
				else {
					
					
					String newPassw = request.getParameter("rpassword");
					if(newPassw == null)
						request.setAttribute("messaggio", "Errore, campo Password nuova non compilato");
					else {
						if(!newPassw.matches("^\\w+([\\.-])?\\w+$"))
							request.setAttribute("messaggio", "Errore, campo Password nuova non valido");
						else {
							
							
							if(userDAO.doUpdate(email, newPassw) == 0)
								request.setAttribute("messaggio", "Modifica non avvenuta");
							else
								request.setAttribute("messaggio", "Modifica avvenuta");
						}
					}
				}
			}
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/Homepage.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
