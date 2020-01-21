package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.StrutturaDAO;

/**
 * Servlet implementation class CreaEdificio
 */
@WebServlet("/CreaEdificio")
public class CreaEdificio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String aula = request.getParameter("aula");
		String edificio = request.getParameter("edificio");

		String des = request.getParameter("descrizione");

		int result = new StrutturaDAO().doSave(aula, edificio, des);
		request.setAttribute("result", result);

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/CreaAula.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
