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

import Model.Prenotazione;
import Model.PrenotazioneDAO;

/**
 * Servlet implementation class AccettaRichiesta
 */
@WebServlet("/AccettaRichiesta")
public class AccettaRichiesta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessione = request.getSession();
		
		
		String ids = request.getParameter("id");
		if (ids != null) {
			System.out.println("Accetta prenotazione,  ID: " + ids);
			int id = Integer.parseInt(ids);
			
			new PrenotazioneDAO().doUpdate(id);
			System.out.println("AccettaRichiesta Modifica:OK");
			
			
			
			String dip =  (String) sessione.getAttribute("dipartimento");
			System.out.println("NAVRichesteprenotazione dipartimento: "+dip);
			//Dalla sessione prendo la data corrente 
			String data =(String) sessione.getAttribute("CurrentData");
			//Dal database prendo  tutte le prenotazioni  di  quel  dipartimento	
			ArrayList<Prenotazione> listaPrenotazioni = new  PrenotazioneDAO().doRetrieveByDip(dip,data);
			sessione.removeAttribute("listaPrenotazioni");
				sessione.setAttribute("listaPrenotazioni", listaPrenotazioni);
			
			
			
			RequestDispatcher view =  request.getRequestDispatcher("WEB-INF/RichiestePrenotazione.jsp");
			view.forward(request, response);
		}else {
			
			RequestDispatcher view =  request.getRequestDispatcher("WEB-INF/RichiestePrenotazione.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
