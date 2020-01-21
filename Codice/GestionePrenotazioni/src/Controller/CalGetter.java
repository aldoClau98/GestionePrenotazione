package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import Model.Prenotazione;

/**
 * Author: Andrea Claro
 */
@WebServlet("/CalGetter")
public class CalGetter extends ServletBasic {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String data = request.getParameter("data");
		String aula = request.getParameter("aula");

		if (data != null && aula != null) {
			JSONArray prodJson = new JSONArray();
			ArrayList<Prenotazione> pren = prenDAO.doAulabyDate(data, aula);
			for (Prenotazione p : pren) {
				System.out.println("###");
				if (p.getAulaPrenotata()) {
					prodJson.put(p.getTitolo());
					prodJson.put(p.getOraInizio());
					prodJson.put(p.getOraFine());
					prodJson.put(p.getDescrizione());
				}
			}
			response.setContentType("application/json");
			response.getWriter().append(prodJson.toString());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
