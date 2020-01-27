package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreaAula
 */
@WebServlet("/CreaAula")
public class CreaAula extends ServletBasic {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String aula = request.getParameter("nome");
		if(aula == null)
			request.setAttribute("messaggio", "Errore, campo Nome non compilato");
		else {
			if(!aula.matches("^\\w{2,16}$"))
				request.setAttribute("messaggio", "Errore, campo Nome non valido");
			else {
				
				
				String des = request.getParameter("descrizione");
				if(des == null)
					request.setAttribute("messaggio", "Errore, campo Descrizione non compilato");
				else {
					
					
					String edificio = request.getParameter("edificio");
					if(edificio == null)
						request.setAttribute("messaggio", "Errore, campo Edificio non compilato");
					else {
						if(!edificio.matches("^\\w{2,16}$"))
							request.setAttribute("messaggio", "Errore, campo Edificio non valido");
						else {
							
							
							if(struttDAO.doSave(aula, edificio, des) == 0)
								request.setAttribute("messaggio", "Creazione fallita");
							else
								request.setAttribute("messaggio", "Creazione avvenuta");
						}
					}
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
