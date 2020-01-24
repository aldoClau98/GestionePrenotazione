package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Dipartimento;
import Model.Utente;
import Model.UtenteDAO;

@WebServlet("/ScegliAmministratore")
public class ScegliAmministratore extends ServletBasic {
	private static final long serialVersionUID = 1L;

	/*
	 * LEGGIMI questa servlet serve sia per rimuovere la nomina di amministratore
	 * (EditAmmnistratore secondo form) che per promuovere un docente ad
	 * amminsitratore di dipartimento (primo form di EditAmministratore
	 **/
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String flag = request.getParameter("flag");

		int result = userDAO.doUpdate(email, Integer.parseInt(flag));

		if (flag.equals("1")) {
			ArrayList<Dipartimento> listaDipartimenti = dipDAO.doRetrieveAllDip();

			if (result != 0) {
				for (int k = 0; k < listaDipartimenti.size(); k++) {
					result = dipDAO.doUpdate(listaDipartimenti.get(k).getDip(), null);
				}
				if (result != 0)
					request.setAttribute("messaggio", "Modifica avvenuta");
				else
					request.setAttribute("messaggio", "Modifica non avvenuta");
			} else
				request.setAttribute("messaggio", "Modifica non avvenuta");
		}
		if (flag.equals("2")) {
			if (result != 0)
				request.setAttribute("messaggio", "Modifica avvenuta");
			else
				request.setAttribute("messaggio", "Modifica non avvenuta");
		}
		
		ArrayList<Utente> listaUtente = new UtenteDAO().doRetrieveAll();
		request.setAttribute("listaUtente", listaUtente);

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/ElencoUtenti.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
