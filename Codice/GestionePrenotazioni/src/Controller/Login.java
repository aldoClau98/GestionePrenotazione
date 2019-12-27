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
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessione = request.getSession();
		String email =  request.getParameter("email");
		String password =  request.getParameter("password");
	//controllo
		System.out.println("email: "+email);
		
			
			Utente utente = new UtenteDAO().doRetrieveByKey(email);
	
				if (utente == null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/ErrorLogin.jsp");
			requestDispatcher.forward(request, response);
					}
					else 
					{

			sessione.setAttribute("utente", utente);

			ArrayList<Prenotazione> storicoPrenotazioni = new PrenotazioneDAO().doRetrieveByUtente(email);
			request.setAttribute("storicoPrenotazioni", storicoPrenotazioni);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/AreaPersonale.jsp");
			requestDispatcher.forward(request, response);
	}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
