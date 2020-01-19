package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.StrutturaDAO;

/**
 * Servlet implementation class NavEdifici
 */
@WebServlet("/NavEdifici")
public class NavEdifici extends ServletBasic {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessione =  request.getSession();
		ArrayList<String> listaEdifici = new  StrutturaDAO().doRetrieveAllEdifici();
		sessione.setAttribute("listaEdifici", listaEdifici);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/Edifici.jsp");
		view.forward(request, response);
	
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
