package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreaEdificio
 */
@WebServlet("/CreaEdificio")
public class CreaEdificio extends ServletBasic {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String aula = request.getParameter("aula");
		String edificio = request.getParameter("edificio");

		String des = request.getParameter("descrizione");

		int result = struttDAO.doSave(aula, edificio, des);
		if (result != 0)
			request.setAttribute("messaggio", "Edificio creato");
		else
			request.setAttribute("messaggio", "Edificio non creato");

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/Edifici.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
