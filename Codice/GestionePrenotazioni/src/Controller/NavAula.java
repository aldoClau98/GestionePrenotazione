package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.StrutturaDAO;

/**
 * Servlet implementation class NavAula
 */
@WebServlet("/NavAula")
public class NavAula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =  request.getSession();
		RequestDispatcher view;
		
		String aula =  request.getParameter("aula");
		String edificio = request.getParameter("edificio");
		System.out.println("NavAula:  aula: "+aula+" edificio: "+edificio);
		Model.Struttura  a = new StrutturaDAO().doStrutturabyName(aula, edificio);
		
		session.setAttribute("struttura", a);
		
		 view = request.getRequestDispatcher("WEB-INF/CalendarioAula.jsp");
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
