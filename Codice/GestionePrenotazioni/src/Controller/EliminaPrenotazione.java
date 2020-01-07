package Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.*;
/**
 * Servlet implementation class EliminaPrenotazione
 */
@WebServlet("/EliminaPrenotazione")
public class EliminaPrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String ids =  request.getParameter("id");
		if(ids!=null) {
		System.out.println("Elimina prenotazione,  ID: "+ids);
		int id =  Integer.parseInt(ids);
		HttpSession sessione = request.getSession();

		Utente c = (Utente) sessione.getAttribute("utente");
		// prende la data corrente
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		System.out.println(dtf.format(localDate)); 
		
		//rimozione della prenotazione
		new  PrenotazioneDAO().doDelete(id);
		
		ArrayList<Prenotazione> listaPrenotazioni = new PrenotazioneDAO().doRetrieveByDate(c.getEmail(),
				dtf.format(localDate));
		//rimuovo la vecchia lista
		sessione.removeAttribute("listaPrenotazioni");
		//aggiorno la lista 
		sessione.setAttribute("listaPrenotazioni", listaPrenotazioni);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/StoricoPrenotazioni.jsp");
		view.forward(request, response);
		}else {
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/StoricoPrenotazioni.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
