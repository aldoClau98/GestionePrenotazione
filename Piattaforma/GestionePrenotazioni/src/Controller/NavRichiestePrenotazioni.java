package Controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Utente;
import Model.Prenotazione;

/**
 * Servlet implementation class NavRichiestePrenotazioni
 */
@WebServlet("/NavRichiestePrenotazioni")
public class NavRichiestePrenotazioni extends ServletBasic {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessione = request.getSession();
		// Dalla sessione prendo il dipartimento che gestisce l'amminsitratore
		Utente user = (Utente) sessione.getAttribute("utente");
		// Dalla sessione prendo la data corrente
		String data = (String) sessione.getAttribute("CurrentData");
		
		String dip = dipDAO.doRetrieveByKey(user.getEmail());
				
		// Dal database prendo tutte le prenotazioni di quel dipartimento
		ArrayList<Prenotazione> listaPrenotazioni = prenDAO.doRetrieveByDip(dip, data);
		
		request.setAttribute("listaPrenotazioni", listaPrenotazioni);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/RichiestePrenotazione.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
