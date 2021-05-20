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
import Model.Utente;

/**
 *   Reindirizza alla jsp   Gestiscitutor dove c'è un elenco di tutti gli studenti tutor 
 */
@WebServlet("/NavGestisciTutor")
public class NavGestisciTutor extends ServletBasic {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		ArrayList<Utente> listaUtenti = userDAO.doRetrieveAll();//prendo tutti gli utenti
		
		//controllo degli utenti se sono studenti o qualche altro tipo di ruolo
		for(int  i = 0; i< listaUtenti.size();i++) {
			
			Utente u =  listaUtenti.get(i);
			
			if(u.getTipoUtente() != 0) {
				listaUtenti.remove(i);
			}
			
			
		}
		for (Utente utente : listaUtenti) {
			System.out.println(utente.getEmail());
		}
		System.out.println();
		//dopo lo passo alla JSP
		request.setAttribute("listaUtente", listaUtenti);

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/GestisciTutor.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
