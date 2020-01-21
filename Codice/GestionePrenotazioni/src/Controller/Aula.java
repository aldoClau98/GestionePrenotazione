package Controller;

import Model.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Aula
 */
@WebServlet("/Aula")
public class Aula extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// prendo dalla request i due parametri
		String data = "2019-07-03"; // request.getParameter("date");
		String aula = request.getParameter("aula");
		String edificio = request.getParameter("edificio");

		// interrogo il database
		Model.Struttura a = new StrutturaDAO().doStrutturabyName(aula, edificio);
		ArrayList<Model.Prenotazione> listaPren = new PrenotazioneDAO().doRetrieveByCalendario(aula, edificio, data);
		// salvo
		session.setAttribute("struttura", a);
		session.setAttribute("listaPren", listaPren);

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/CalendarioAula.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
