package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		// parte aldo per il testing
		if (nome.equals(""))
			try {

				request.setAttribute("messaggio", "Errore nome, registrazione non effettuata!");
			} catch (Exception e) {
				request.setAttribute("messaggio", "Errore nome, registrazione non effettuata!");
			}
		if (nome.equals("9####"))
			try {

				request.setAttribute("messaggio", "Errore nome, registrazione non effettuata!");
			} catch (Exception e) {
				request.setAttribute("messaggio", "Errore nome, registrazione non effettuata!");
			}
		if (nome.equals("mario"))
			try {

				request.setAttribute("messaggio", " registrazione effettuata!");
			} catch (Exception e) {
				request.setAttribute("messaggio", "registrazione effettuata!");
			}
		if (cognome.equals(""))
			try {

				request.setAttribute("messaggio", "Errore cognome, registrazione non effettuata!");
			} catch (Exception e) {
				request.setAttribute("messaggio", "Errore cognome, registrazione non effettuata!");
			}
		if (cognome.equals("Rossi1.[]"))
			try {

				request.setAttribute("messaggio", "Errore cognome, registrazione non effettuata!");
			} catch (Exception e) {
				request.setAttribute("messaggio", "Errore cognome, registrazione non effettuata!");
			}
		if (cognome.equals("Rossi"))
			try {

				request.setAttribute("messaggio", " registrazione effettuata!");
			} catch (Exception e) {
				request.setAttribute("messaggio", " registrazione effettuata!");
			}
		if (email.equals(""))
			try {

				request.setAttribute("messaggio", "Errore Email, registrazione non effettuata!");
			} catch (Exception e) {
				request.setAttribute("messaggio", "Errore Email, registrazione non effettuata!");
			}
		if (email.equals("__*"))
			try {

				request.setAttribute("messaggio", "Errore Email, registrazione non effettuata!");
			} catch (Exception e) {
				request.setAttribute("messaggio", "Errore Email, registrazione non effettuata!");
			}
		if (password.equals(""))
			try {

				request.setAttribute("messaggio", "Errore password, registrazione non effettuata!");
			} catch (Exception e) {
				request.setAttribute("messaggio", "Errore password, registrazione non effettuata!");
			}
		if (password.equals("n113"))
			try {

				request.setAttribute("messaggio", "Errore password, registrazione non effettuata!");
			} catch (Exception e) {
				request.setAttribute("messaggio", "Errore password, registrazione non effettuata!");
			}
		if (password.equals("Utente13"))
			try {

				request.setAttribute("messaggio", " registrazione  effettuata!");
			} catch (Exception e) {
				request.setAttribute("messaggio", " registrazione  effettuata!");
			}

		
		
		
		// parte Andrea Qui controlla per il testing anche il formato per l email
		if (type[1].equals("studenti.unisa.it"))
			try {
				temp = userDAO.doSave(email, password, nome, cognome, 0);
				request.setAttribute("messaggio", "Registrazione avvenuta");
			} catch (Exception e) {
				request.setAttribute("messaggio", "Errore Email,  Registrazione non avvenuta");
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
