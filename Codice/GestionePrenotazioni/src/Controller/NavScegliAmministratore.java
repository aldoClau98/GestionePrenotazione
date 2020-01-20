package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Utente;
import Model.UtenteDAO;

/**
 * Servlet implementation class NavScegliAmministratore
 */
@WebServlet("/NavScegliAmministratore")
public class NavScegliAmministratore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =  request.getSession();
		ArrayList<String> listaUtenti =  new ArrayList<String>();
		ArrayList<Utente> listaAllUtenti =  new UtenteDAO().doRetrieveAll();
		
		for(int i = 0;  i< listaAllUtenti.size();i++) {
			if((listaAllUtenti.get(i).getTipoUtente()) == 1) {
				listaUtenti.add(listaAllUtenti.get(i).getEmail());
				System.out.println("NavScegliAmm: "+listaAllUtenti.get(i).getEmail());
			}
		}
		session.setAttribute("listaUtente", listaUtenti);
		RequestDispatcher view  =  request.getRequestDispatcher("WEB-INF/ScegliAmministratore.jsp");
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
