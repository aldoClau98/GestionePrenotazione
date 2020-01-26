package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RimuoviAula
 */
@WebServlet("/RimuoviAula")
public class RimuoviAula extends ServletBasic {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String edificio = request.getParameter("edificio");
		String aula = request.getParameter("aula");

		int result = struttDAO.doDelete(aula, edificio);
		request.setAttribute("result", result);

		if (result != 0)
			request.setAttribute("messaggio", "Aula eliminata");
		else
			request.setAttribute("messaggio", "Aula non eliminata");

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/Edifici.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
