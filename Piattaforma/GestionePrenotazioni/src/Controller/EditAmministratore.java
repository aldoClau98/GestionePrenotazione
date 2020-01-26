package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DiventaAmministratore
 */
@WebServlet("/EditAmministratore")
public class EditAmministratore extends ServletBasic {
	private static final long serialVersionUID = 1L;

	// Assegna o rimuove il grado di Amministratore di dipartimento ad un docente
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		if (email == null)
			request.setAttribute("messaggio", "Riassegnamento fallito");
		else {

			String dip = request.getParameter("dip");
			if (dip == null)
				request.setAttribute("messaggio", "Errore, campo Dipartimento non compilato");
			else {

				if (userDAO.doChangeDip(email, dip) == 0)
					request.setAttribute("messaggio", "Riassegnamento fallito");
				else
					request.setAttribute("messaggio", "Riassegnamento avvenuto");
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
