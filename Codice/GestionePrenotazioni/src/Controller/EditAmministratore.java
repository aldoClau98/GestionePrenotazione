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
 * Servlet implementation class DiventaAmministratore
 */
@WebServlet("/DiventaAmministratore")
public class EditAmministratore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   //Assegna o rimuove il  grado  di  Amministratore di dipartimento  ad un  docente
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String email =  request.getParameter("email");
	String flag = request.getParameter("flag");
					
			int result = new UtenteDAO().doUpdate(email, Integer.parseInt(flag));
			
			
			
			
			request.setAttribute("result", result);	
			RequestDispatcher view =  request.getRequestDispatcher("WEB-INF/Homepage.jsp");
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
