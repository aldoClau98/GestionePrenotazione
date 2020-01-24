package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AssegnaDipartimentoAula")
public class AssegnaDipartimentoAula extends ServletBasic {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String aula = request.getParameter("aula");
		String edificio = request.getParameter("edificio");
		String dip = request.getParameter("dipartimento");

		int result = struttDAO.doUpdateDipartimento(aula, edificio, dip);
		if (result != 0)
			request.setAttribute("messaggio", "Aula assegnata");
		else
			request.setAttribute("messaggio", "Aula non assegnata");
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/Homepage.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
