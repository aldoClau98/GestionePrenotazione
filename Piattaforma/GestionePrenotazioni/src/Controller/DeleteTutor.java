package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Dipartimento;
import Model.Utente;
import Model.UtenteDAO;

/**
 * Servlet implementation class DeleteTutor
 */
@WebServlet("/DeleteTutor")
public class DeleteTutor extends ServletBasic {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		if(email == null)
			request.setAttribute("messaggio", "Errore, campo Utente non compilato");
		else {
							userDAO.doChangeTypeUser(email,0);
				int result = courseDAO.doUpdateTutor(email);
				if(result == 0) {
					request.setAttribute("messaggio", "Modifica fallita");
				}else 
					request.setAttribute("messaggio", "Modifica avvenuta con successo");
				
		}
				
				//prendo tutti gli utenti
				ArrayList<Utente> listaUtenti = userDAO.doRetrieveAll();
				
				//controllo degli utenti se sono studenti o qualche altro tipo di ruolo
				for(int  i = 0; i< listaUtenti.size();i++) {
					
					Utente u =  listaUtenti.get(i);
					
					if((u.getTipoUtente() == 1) || (u.getTipoUtente() == 2) || (u.getTipoUtente() == 3)){
						listaUtenti.remove(i);
					}					
				}
				//log
				for (Utente utente : listaUtenti) {
					System.out.println(utente.getEmail()+" "+ utente.getTipoUtente());
				}
		
				//dopo lo passo alla JSP
				request.setAttribute("listaUtente", listaUtenti);

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/GestisciTutor.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
