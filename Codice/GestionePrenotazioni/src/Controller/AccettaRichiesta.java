package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.PrenotazioneDAO;

/**
 * Servlet implementation class AccettaRichiesta
 */
@WebServlet("/AccettaRichiesta")
public class AccettaRichiesta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String ids = request.getParameter("id");
		if (ids != null) {
			System.out.println("Accetta prenotazione,  ID: " + ids);
			int id = Integer.parseInt(ids);
			
			new PrenotazioneDAO().doUpdate(id);
			System.out.println("AccettaRichiesta Modifica:OK");
			RequestDispatcher view =  request.getRequestDispatcher("WEB-INF/RichiestePrenotazione.jsp");
			view.forward(request, response);

		}else {
			
			RequestDispatcher view =  request.getRequestDispatcher("WEB-INF/RichiestePrenotazione.jsp");
			view.forward(request, response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
