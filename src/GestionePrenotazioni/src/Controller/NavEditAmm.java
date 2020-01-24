package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class NavAssegnaAmm
 */
@WebServlet("/NavEditAmm")
public class NavEditAmm extends ServletBasic {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Model.Dipartimento> listaDipartimenti = dipDAO.doRetrieveAllDip();
		String email = request.getParameter("email");

		request.setAttribute("listaDipartimenti", listaDipartimenti);
		request.setAttribute("email", email);

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/EditAmministratore.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
