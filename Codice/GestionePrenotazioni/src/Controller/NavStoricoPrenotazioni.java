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
 * Servlet implementation class NavStoricoPrenotazioni
 */
@WebServlet("/NavStoricoPrenotazioni")
public class NavStoricoPrenotazioni extends ServletBasic {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessione = request.getSession();

		Utente c = (Utente) sessione.getAttribute("utente");
		// prende la data corrente
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
//		System.out.println(dtf.format(localDate)); // 2016/11/16

		ArrayList<Model.Prenotazione> listaPrenotazioni = prenDAO.doRetrieveByDate(c.getEmail(),
				dtf.format(localDate));
		
		request.setAttribute("listaPrenotazioni", listaPrenotazioni);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/StoricoPrenotazioni.jsp");
		view.forward(request, response);
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
