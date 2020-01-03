package Controller;
import Model.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Aula
 */
@WebServlet("/Aula")
public class Aula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =  request.getSession();
		RequestDispatcher view;
		//prendo  dalla request i  due parametri
		String data = "2019-07-03";  //request.getParameter("date");
		String aula =  request.getParameter("aula");
		String edificio = request.getParameter("edificio");
		
		if(edificio !=null) {
		//li passo  al  dao per l'interrogazione al  database
		Model.Struttura  a = new StrutturaDAO().doStrutturabyName(aula, edificio);
		
		session.setAttribute("struttura", a);
		 view = request.getRequestDispatcher("WEB-INF/Aula.jsp");
		view.forward(request, response);
		
		} else if(data !=null) {
			ArrayList<Prenotazione> listaPren =  new PrenotazioneDAO().doRetrieveByDate(data, aula);
			
			session.setAttribute("listaPren", listaPren);
		
		 view = request.getRequestDispatcher("WEB-INF/Aula.jsp");
		view.forward(request, response);
		
		}else {
			 view = request.getRequestDispatcher("WEB-INF/Homepage.jsp");
			view.forward(request, response);
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
