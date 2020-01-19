package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.PrenotazioneDAO;
import Model.StrutturaDAO;

/**
 * Servlet implementation class RimuoviEdificio
 */
@WebServlet("/RimuoviEdificio")
public class RimuoviEdificio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String edificio = request.getParameter("edificio");
		
		
		int result =  new StrutturaDAO().doDeleteEdificio(edificio);
		System.out.println("RimuoviEdificio: "+result);
		request.setAttribute("result", result);
		
		if(result>0) {
			new PrenotazioneDAO().doDeleteByEdificio(edificio);
		}
		RequestDispatcher view  =  request.getRequestDispatcher("WEB-INF/RimuoviEdificio.jsp");
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
