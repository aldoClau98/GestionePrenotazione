package Controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.PrenotazioneDAO;
import Model.Prenotazione;

/**
 * Servlet implementation class NavRichiestePrenotazioni
 */
@WebServlet("/NavRichiestePrenotazioni")
public class NavRichiestePrenotazioni extends ServletBasic {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession sessione = request.getSession();
	//Dalla sessione prendo  il  dipartimento che gestisce l'amminsitratore
	String dip =  (String) sessione.getAttribute("dipartimento");
	System.out.println("NAVRichesteprenotazione dipartimento: "+dip);
	//Dalla sessione prendo la data corrente 
	String data = "2019-06-09";// (String) sessione.getAttribute("CurrentData");
	//Dal database prendo  tutte le prenotazioni  di  quel  dipartimento	
	ArrayList<Prenotazione> listaPrenotazioni = new  PrenotazioneDAO().doRetrieveByDip(dip,data);
		sessione.setAttribute("listaPrenotazioni", listaPrenotazioni);
	RequestDispatcher view  =  request.getRequestDispatcher("WEB-INF/RichiestePrenotazione.jsp");
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
