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
 * Servlet implementation class CambiaDipartimento
 */
@WebServlet("/CambiaDipartimento")
public class CambiaDipartimento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String email =  request.getParameter("email");
	String dip = request.getParameter("dip");
	System.out.println("CambiaDiaprtimento: email: "+email+" Dipartimento: "+dip);
	//rimuovo l' amminsitratore dal  vecchio dipartimento
	new DipartimentoDAO().doDeleteAmm(email);
	int result= new DipartimentoDAO().doUpdate(dip, email);
	System.out.println("CambiaDipartimento: "+result);
	request.setAttribute("result", result);
	RequestDispatcher view  =  request.getRequestDispatcher("WEB-INF/Homepage.jsp");
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
