package Controller;

import java.io.IOException;

import Model.Prenotazione;
import Model.PrenotazioneDAO;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class CercaPrenotazioni
 */
@WebServlet("/CercaPrenotazioni")
public class CercaPrenotazioni extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String aula = request.getParameter("aula");
		HttpSession  session = request.getSession();
		String data = "2019-07-03";  //request.getParameter("date");
		
		
	
		

	
		ArrayList<Prenotazione> listaPren =  new PrenotazioneDAO().doRetrieveByDate(data, aula);
	
		session.setAttribute("listaPren", listaPren);
	
	RequestDispatcher view = request.getRequestDispatcher("WEB-INF/Aula.jsp");
	view.forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
