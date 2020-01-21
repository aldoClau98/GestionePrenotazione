package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.StrutturaDAO;
import Model.Struttura;

/**
 * Servlet implementation class Dipartimento
 */
@WebServlet("/Dipartimento")
public class Dipartimento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String dip = request.getParameter("dip");
		// prendo edifici ed aule associate
		ArrayList<Struttura> listaStr = new StrutturaDAO().doStrutturabyDip(dip);

		session.setAttribute("listaStr", listaStr);
		// le mando alla JSP
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/Dipartimenti.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
