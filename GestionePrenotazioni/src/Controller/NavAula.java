package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Struttura;

/**
 * Servlet implementation class NavAula
 */
@WebServlet("/NavAula")
public class NavAula extends ServletBasic {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String aula = request.getParameter("aula");
		String edificio = request.getParameter("edificio");

		Struttura strutt = struttDAO.doStrutturabyAula(aula);
		Model.Dipartimento dip = dipDAO.doDipartimentoByStruttura(aula, edificio);
		
		request.setAttribute("strutt", strutt);
		request.setAttribute("dip", dip);

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/CalendarioAula.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
