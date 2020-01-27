package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Prenotazione;

/**
 * Servlet implementation class AccettaRichiesta
 */
@WebServlet("/AccettaRichiesta")
public class AccettaRichiesta extends ServletBasic {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessione = request.getSession();
		String ids = request.getParameter("id");
		String oraInizio = request.getParameter("oraInizio");
		String oraFine = request.getParameter("oraFine");
		String dataPren = request.getParameter("data");
		String aula = request.getParameter("aula");
		String edificio = request.getParameter("edificio");

		if (prenDAO.controlloOra(dataPren, Integer.parseInt(oraInizio), Integer.parseInt(oraFine), aula,
				edificio) == 1) {
			prenDAO.doUpdate(Integer.parseInt(ids));

			String dip = (String) sessione.getAttribute("dipartimento");
			// Dalla sessione prendo la data corrente
			String data = (String) sessione.getAttribute("CurrentData");
			// Dal database prendo tutte le prenotazioni di quel dipartimento
			ArrayList<Prenotazione> listaPrenotazioni = prenDAO.doRetrieveByDip(dip, data);

			request.setAttribute("listaPrenotazioni", listaPrenotazioni);
			request.setAttribute("messaggio", "Prenotazione accettata");

			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/RichiestePrenotazione.jsp");
			view.forward(request, response);

		} else {
			request.setAttribute("messaggio", "Prenotazione non accettata");

			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/RichiestePrenotazione.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
