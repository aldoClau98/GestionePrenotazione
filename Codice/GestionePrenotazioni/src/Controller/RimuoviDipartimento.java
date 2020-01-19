package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DipartimentoDAO;
import Model.PrenotazioneDAO;
import Model.StrutturaDAO;

/**
 * Servlet implementation class RimuoviDipartimento
 */
@WebServlet("/RimuoviDipartimento")
public class RimuoviDipartimento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String dip = request.getParameter("dipartimento");
		
		
		int result =  new DipartimentoDAO().doDelete(dip);
		System.out.println("RimuoviDipartimento: "+result);
		request.setAttribute("result", result);
		
		
		RequestDispatcher view  =  request.getRequestDispatcher("WEB-INF/ServletHome.jsp");
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
