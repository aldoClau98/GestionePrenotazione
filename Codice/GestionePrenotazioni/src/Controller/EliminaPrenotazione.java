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
public class EliminaPrenotazione extends ServletBasic {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ids = request.getParameter("id");
		if (ids != null) {
			int id = Integer.parseInt(ids);

			HttpSession sessione = request.getSession();
			Utente c = (Utente) sessione.getAttribute("utente");

			// prende la data corrente
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDate localDate = LocalDate.now();
			System.out.println(dtf.format(localDate));

			prenDAO.doDelete(id);

			ArrayList<Model.Prenotazione> listaPrenotazioni = prenDAO.doRetrieveByDate(c.getEmail(),
					dtf.format(localDate));

			request.removeAttribute("listaPrenotazioni");
			request.setAttribute("listaPrenotazioni", listaPrenotazioni);
			request.setAttribute("messaggio", "Eliminazione effettuata");

			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/StoricoPrenotazioni.jsp");
			view.forward(request, response);
		} else {
			request.setAttribute("messaggio", "Eliminazione non effettuata");

			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/StoricoPrenotazioni.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
