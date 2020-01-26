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
		
		String email = request.getParameter("email");
		if (email == null)
			request.setAttribute("messaggio", "Errore, campo Email non compilato");
		else {
			if (email.length() < 1  ||  email.length() > 254  ||  !(email.matches("^(\\w+([\\.-])?\\w+)+@?(studenti\\.unisa\\.it)$")  ||  email.matches("^(\\w+([\\.-])?\\w+)+@?(unisa\\.it)$")))
				request.setAttribute("messaggio", "Errore, campo Email non valido");
			else {
				
				
				String password = request.getParameter("password");
				if (password == null)
					request.setAttribute("messaggio", "Errore, campo Password non compilato");
				else {
					if (!password.matches("^\\w+([\\.-])?\\w+$"))
						request.setAttribute("messaggio", "Errore, campo Password non valido");
					else {
						
						
						Utente utente = userDAO.doRetrieveByKey(email, password);
						if(utente == null)
							request.setAttribute("messaggio", "Login fallito");
						else {
							HttpSession sessione = request.getSession();
							
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
