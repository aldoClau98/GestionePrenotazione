package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NavScegliDipartimento
 */
@WebServlet("/NavScegliDipartimento")
public class NavScegliDipartimento extends ServletBasic {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String dip = (String) request.getParameter("dipartimento");	
		String aula = (String) request.getParameter("aula");
		String edificio = (String) request.getParameter("edificio");

		ArrayList<String> listaDip = dipDAO.doRetrieveAllDipartimenti();
		listaDip.remove(dip);

		request.setAttribute("listaDip", listaDip);
		request.setAttribute("aula", aula);
		request.setAttribute("edificio", edificio);

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/ScegliDipartimento.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
