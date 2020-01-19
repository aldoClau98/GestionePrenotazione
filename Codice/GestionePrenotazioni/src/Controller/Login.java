package Controller;
import Model.DipartimentoDAO;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Prenotazione;
import Model.PrenotazioneDAO;
import Model.Utente;
import Model.UtenteDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessione = request.getSession();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		// controllo

		Utente utente = null;

		if (email != null && password != null) {
			utente = new UtenteDAO().doRetrieveByKey(email, password);
		}
		if (utente == null) {
			
			request.setAttribute("resultlogin", "0");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/Homepage.jsp");
			requestDispatcher.forward(request, response);
		} else {
			//salva la data corrente 
			LocalDateTime ldt = LocalDateTime.now().plusDays(1);
			DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ITALIAN);
			String formatter = formmat1.format(ldt);
			
			
			
			
			System.out.println("Login  utente: "+utente.getTipoUtente());
			
			sessione.setAttribute("CurrentData",formatter);
			System.out.println(formatter);
				//salva l'utente nella sessione
			sessione.setAttribute("utente", utente);
			
					//se l'utente è  amminsitratore di  dipartimento
						if((utente.getTipoUtente())==2) {
							
							String dip= new DipartimentoDAO().doRetrieveByKey(utente.getEmail());
							
							System.out.println("Login dipartimento: "+dip);
							sessione.setAttribute("dipartimento", dip);
						}

			ArrayList<Prenotazione> storicoPrenotazioni = new PrenotazioneDAO().doRetrieveByUtente(email);
			sessione.setAttribute("storicoPrenotazioni", storicoPrenotazioni);
			request.setAttribute("resultlogin", "1");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/Homepage.jsp");
			requestDispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
