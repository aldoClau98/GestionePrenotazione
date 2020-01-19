package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DipartimentoDAO;
import Model.PrenotazioneDAO;
import Model.Utente;

/**
 * Servlet implementation class RichiestaPrenotazione
 */
@WebServlet("/DomandaPrenotazione")
public class DomandaPrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		// parametri inseriti dall' utente
		String titolo = request.getParameter("titolo");
		String oraInizio = request.getParameter("oraInizio");
		String oraFine = request.getParameter("oraFine");
		String descrizione = request.getParameter("descrizione");
		// parametri nascosti
		String aula = request.getParameter("aula");
		String edificio = request.getParameter("edificio");
		String data = request.getParameter("data");
		Utente utente = (Utente) session.getAttribute("utente");
		String email = utente.getEmail();
		// se l' utente è amministratore...
		// ...se il dipartimento corrisponde al dipartimento dell amministratore, allora
		// la prenotazione viene salvata direttamente nel database
		String dipAmm = new DipartimentoDAO().doRetrieveByKey(utente.getEmail());
		String aulaDip = new DipartimentoDAO().doDipartimentoByStruttura(aula, edificio);
		if (((utente.getTipoUtente()) > 1) && (dipAmm.equals(aulaDip))) {

			int result = new PrenotazioneDAO().doSave(titolo, data, Integer.parseInt(oraInizio),
					Integer.parseInt(oraFine), descrizione, email, aula, edificio, 1);

			request.setAttribute("resultPren", result);
			System.out.println("DomandaPrenotazione: " + result);
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/Homepage.jsp");
			view.forward(request, response);
		} else {
			
			int result = new PrenotazioneDAO().doSave(titolo, data, Integer.parseInt(oraInizio),
					Integer.parseInt(oraFine), descrizione, email, aula, edificio, 0);

			request.setAttribute("resultPren", result);
			System.out.println("DomandaPrenotazione: " + result);
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/Homepage.jsp");
			view.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
