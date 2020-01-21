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

import Model.Prenotazione;
import Model.PrenotazioneDAO;
import Model.Utente;

@WebServlet("/EliminaRichiesta")
public class EliminaRichiesta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessione = request.getSession();

		String ids = request.getParameter("id");
		if (ids != null) {
			int id = Integer.parseInt(ids);

			Utente c = (Utente) sessione.getAttribute("utente");
			// prende la data corrente
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDate localDate = LocalDate.now();

			// rimozione della prenotazione
			new PrenotazioneDAO().doDelete(id);

			String dip = (String) sessione.getAttribute("dipartimento");
			// Dalla sessione prendo la data corrente
			String data = "2019-06-09";// (String) sessione.getAttribute("CurrentData");
			// Dal database prendo tutte le prenotazioni di quel dipartimento
			ArrayList<Prenotazione> listaPrenotazioni = new PrenotazioneDAO().doRetrieveByDip(dip, data);
			sessione.removeAttribute("listaPrenotazioni");
			sessione.setAttribute("listaPrenotazioni", listaPrenotazioni);

			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/RichiestePrenotazione.jsp");
			view.forward(request, response);
		} else {

			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/RichiestePrenotazione.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
