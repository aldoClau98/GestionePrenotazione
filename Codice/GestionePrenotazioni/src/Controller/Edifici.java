package Controller;

import Model.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Servlet implementation class Edifici
 */
@WebServlet("/Edifici")
public class Edifici extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String edificio = request.getParameter("edificio");

		ArrayList<Model.Aula> listaAule = new StrutturaDAO().doAulabyEdificio(edificio);
		ArrayList<String> listaEdifici = new StrutturaDAO().doRetrieveAllEdifici(); 
		request.setAttribute("listaAule", listaAule);
		request.setAttribute("listaEdifici", listaEdifici);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/Edifici.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
