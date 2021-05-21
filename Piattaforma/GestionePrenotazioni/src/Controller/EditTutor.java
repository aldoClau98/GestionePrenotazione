package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditTutor
 */
@WebServlet("/EditTutor")
public class EditTutor extends ServletBasic {
	private static final long serialVersionUID = 1L;
	
	
	// Assegna o rimuove il grado di Tuto di dipartimento ad uno studente
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			String email = request.getParameter("email");
			if (email == null)
				request.setAttribute("messaggio", "Riassegnamento fallito");
			else {

				String corso = request.getParameter("corso");
				if (corso == null)
					request.setAttribute("messaggio", "Errore, campo corso non compilato");
				else {
					System.out.println("Controller: EditTutor"+email);
						//cambia il tutor del corso 
					if (userDAO.doChangeCorso(email, corso) == 0) {
						request.setAttribute("messaggio", "Riassegnamento fallito corso");
					}
						else if(userDAO.doChangeTypeUser(email, 4) == 0) {
						request.setAttribute("messaggio", "Riassegnamento fallito email");
					}else
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
