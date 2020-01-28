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
		if (aula == null)
			request.setAttribute("messaggio", "Assegnamento fallito");
		else {

			String edificio = request.getParameter("edificio");
			if (edificio == null)
				request.setAttribute("messaggio", "Assegnamento fallito");
			else {

				String dip = request.getParameter("dipartimento");
				if (dip == null)
					request.setAttribute("messaggio", "Errore, campo Dipartimento non compilato");
				else {

					if (struttDAO.doUpdateDipartimento(aula, edificio, dip) == 0)
						request.setAttribute("messaggio", "Aula non assegnata");
					else
						request.setAttribute("messaggio", "Aula assegnata");
				}
			}
		}

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/Homepage.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
