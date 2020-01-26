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
		if(dip == null)
			request.setAttribute("messaggio", "Errore, campo Nome non compilato");
		else {
			if(!dip.matches("^\\w{4,16}$"))
				request.setAttribute("messaggio", "Errore, campo Nome non valido");
			else {
				
				
				if(dipDAO.doRetrieveByName(dip) != 0)
					request.setAttribute("messaggio", "Dipartimento già esistente");
				else {
					
					
					if(dipDAO.doSave(dip) == 0)
						request.setAttribute("messaggio", "Dipartimento non creato");
					else
						request.setAttribute("messaggio", "Dipartimento creato");
				}
			}
		}

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
