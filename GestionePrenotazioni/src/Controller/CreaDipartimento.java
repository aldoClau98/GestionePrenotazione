package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreaDipartimento
 */
@WebServlet("/CreaDipartimento")
public class CreaDipartimento extends ServletBasic {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String dip = request.getParameter("dipartimento");

		int result = dipDAO.doSave(dip);
		if (result != 0)
			request.setAttribute("messaggio", "Dipartimento creato");
		else
			request.setAttribute("messaggio", "Dipartimento non creato");

		ArrayList<String> listaDipartimenti = dipDAO.doRetrieveAllDipartimenti();
		ArrayList<Model.Dipartimento> listaAmministratori = dipDAO.doRetrieveAll();
		
		request.setAttribute("listaDipartimenti", listaDipartimenti);
		request.setAttribute("listaAmministratori", listaAmministratori);

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/Dipartimenti.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
