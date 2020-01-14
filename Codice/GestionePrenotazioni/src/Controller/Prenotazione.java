package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.PrenotazioneDAO;
import Model.Utente;

/**
 * Servlet implementation class Prenotazione
 */
@WebServlet("/Prenotazione")
public class Prenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =  request.getSession();
		//parametri  inseriti  dall' utente
		String titolo = request.getParameter("titolo");
		String oraInizio =  request.getParameter("oraInizio");
		String oraFine =  request.getParameter("oraFine");
		String descrizione =  request.getParameter("descrizione");
		//parametri  nascosti
		String aula =  request.getParameter("aula");
		String edificio =  request.getParameter("edificio");
		String  data =  request.getParameter("date2");
		Utente utente =  (Utente) session.getAttribute("utente");
		String email =  utente.getEmail();
		System.out.println("Servlet prenotazione: "+"titolo: "+titolo+"oraInizio: "+oraInizio+"orafine: "+oraFine+"descrizione: "+descrizione+"aula: "+aula+"edificio: "+edificio+"data: "+data+"email: "+email);
		int result = new PrenotazioneDAO().doSave(titolo, data, Integer.parseInt(oraInizio), Integer.parseInt(oraFine), descrizione, email, aula, edificio);
		
		
	
			request.setAttribute("resultPren", result);
			RequestDispatcher view  =  request.getRequestDispatcher("WEB-INF/aula.jsp");
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
