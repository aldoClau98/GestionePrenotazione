package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RimuoviEdificio
 */
@WebServlet("/RimuoviEdificio")
public class RimuoviEdificio extends ServletBasic {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String edificio = request.getParameter("edificio");

		int result = struttDAO.doDeleteEdificio(edificio);
		if (result != 0)
			request.setAttribute("messaggio", "Edificio eliminato");
		else
			request.setAttribute("messaggio", "Edificio non eliminato");

		ArrayList<String> listaEdifici = struttDAO.doRetrieveAllEdifici();
		request.setAttribute("listaEdifici", listaEdifici);

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/Edifici.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
