package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreaEdificio
 */
@WebServlet("/CreaEdificio")
public class CreaEdificio extends ServletBasic {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String aula = request.getParameter("aula");
		if(aula == null)
			request.setAttribute("messaggio", "Creazione fallita");
		else {
			
			
			String edificio = request.getParameter("edificio");
			if(edificio == null)
				request.setAttribute("messaggio", "Errore, campo Nome non compilato");
			else {
				if(!edificio.matches("^\\w{2,16}$"))
					request.setAttribute("messaggio", "Errore, campo Nome non valido");
				else {
					
					
					String des = request.getParameter("descrizione");
					if(des == null)
						request.setAttribute("messaggio", "Errore, campo Descrizione non compilato");
					else {
						
						
						if(struttDAO.doStrutturabyName(aula, edificio) != null)
							request.setAttribute("messaggio", "Creazione fallita, edificio esistente");
						else {
							
							
							if(struttDAO.doSave(aula, edificio, des) == 0)
								request.setAttribute("messaggio", "Creazione fallita");
							else
								request.setAttribute("messaggio", "Edificio creato");
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
