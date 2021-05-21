package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AulaStudenti
 */
@WebServlet("/AulaStudenti")
public class AulaStudenti extends ServletBasic {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String aula = request.getParameter("aula");
	String edificio =  request.getParameter("edificio");
	String flag = request.getParameter("flag");

		int  result= struttDAO.doUpdate(aula, edificio,flag);

		if(result!=0)
	request.setAttribute("messaggio", "Prenotabilita' aula cambiata");
		else 
			request.setAttribute("messaggio", "Prenotabilita' aula non riuscita");
		
	RequestDispatcher view  =  request.getRequestDispatcher("WEB-INF/Homepage.jsp");
	view.forward(request, response);
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
