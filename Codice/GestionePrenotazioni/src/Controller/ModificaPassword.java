package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.UtenteDAO;
import Model.Utente;

/**
 * Servlet implementation class ModificaPassword
 */
@WebServlet("/ModificaPassword")
public class ModificaPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String email =  request.getParameter("email");
	String password = request.getParameter("password");
	
	
	int result = new UtenteDAO().doUpdate(email,password);
	request.setAttribute("ResultPassword", result);
	
			
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/AreaPersonale.jsp");
				requestDispatcher.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
