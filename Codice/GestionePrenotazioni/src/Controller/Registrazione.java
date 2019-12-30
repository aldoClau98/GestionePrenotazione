package Controller;

import java.io.IOException;

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
public class Registrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int temp;
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String password = request.getParameter("Password");
		String cognome = request.getParameter("cognome");
		String tipoutente = request.getParameter("tipoutente");
		
		//funzione di registrazione dell'utente
		 temp =   new UtenteDAO().doSave( email, password,  nome,  cognome, Integer.parseInt(tipoutente) );
		  System.out.println(temp);
		  /*
			 * risultato  dell operazione registrazione 
			 * 1 se �  avvenuta con  successo 
			 * 0  se l'operazione �  fallita
			 */
		
			request.setAttribute("risult", temp);//reindirizzamento alla pagina di login
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/Login.jsp");
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
