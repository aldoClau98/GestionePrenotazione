package Controller;
import Model.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RimuoviAula
 */
@WebServlet("/RimuoviAula")
public class RimuoviAula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String edificio =  request.getParameter("edificio");
	String aula = request.getParameter("aula");
	
	
	int result =  new StrutturaDAO().doDelete(aula, edificio);
	System.out.println("RimuoviAula: "+result);
	request.setAttribute("result", result);
	
	if(result>0) {
		new PrenotazioneDAO().doDeleteByStruttura(edificio,aula);
	}
	RequestDispatcher view  =  request.getRequestDispatcher("WEB-INF/RimuoviAula.jsp");
	view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

}
