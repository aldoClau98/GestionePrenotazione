package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreaAula
 */
@WebServlet("/CreaAula")
public class CreaAula extends ServletBasic {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String aula = request.getParameter("nome");
		String edificio = request.getParameter("edificio");

		String des = request.getParameter("descrizione");
		int result = struttDAO.doSave(aula, edificio, des);
		if (result != 0)
			request.setAttribute("messaggio", "Aula creata");
		else
			request.setAttribute("messaggio", "Aula non creata");

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/Edifici.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
