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
public class DomandaPrenotazione extends ServletBasic {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		// parametri inseriti dall' utente
		String titolo = request.getParameter("titolo");
		String oraInizio = request.getParameter("oraInizio");
		String data = request.getParameter("data");
		String oraFine = request.getParameter("oraFine");
		String descrizione = request.getParameter("descrizione");
		// parametri nascosti
		String aula = request.getParameter("aula");
		String edificio = request.getParameter("edificio");
		Utente utente = (Utente) session.getAttribute("utente");
		String email = utente.getEmail();
		// se l' utente � amministratore...
		// ...se il dipartimento corrisponde al dipartimento dell amministratore, allora
		// la prenotazione viene salvata direttamente nel database
		String dipAmm = dipDAO.doRetrieveByKey(utente.getEmail());
		String aulaDip = dipDAO.doDipartimentoByStruttura(aula, edificio);
		if (((utente.getTipoUtente()) > 1) && (dipAmm.equals(aulaDip))) {

			int result = prenDAO.doSave(titolo, data, Integer.parseInt(oraInizio), Integer.parseInt(oraFine),
					descrizione, email, aula, edificio, 1);
			if (result != 0)
				request.setAttribute("messaggio", "Hai prenotato l'aula");

			else {
				request.setAttribute("messaggio", "Non hai prenotato l'aula");

			}

			RequestDispatcher view = request.getRequestDispatcher("NavAula?aula=" + aula);
			view.forward(request, response);
		} else {

			int result = prenDAO.doSave(titolo, data, Integer.parseInt(oraInizio), Integer.parseInt(oraFine),
					descrizione, email, aula, edificio, 0);
			if (result != 0)
				request.setAttribute("messaggio", "Hai richiesto la prenotazione");

			else {
				request.setAttribute("messaggio", "Richiesta non avvenuta");

			}

			RequestDispatcher view = request.getRequestDispatcher("NavAula?aula=" + aula);
			view.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
