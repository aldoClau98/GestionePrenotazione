package Controller;
import Model.*;
import java.io.IOException;

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
		
		//prendo  dalla request i  due parametri
		String aula =  request.getParameter("aula");
		String edificio = request.getParameter("edificio");
		//li passo  al  dao per l'interrogazione al  database
		Model.Struttura  a = new StrutturaDAO().doStrutturabyName(aula, edificio);
		
		HttpSession session =  request.getSession();
		session.setAttribute("struttura", a);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/Aula.jsp");
		view.forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
