package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import Model.Struttura;

/**
 * Author: Andrea Claro
 */
@WebServlet("/RimAulaGetter")
public class RimAulaGetter extends ServletBasic {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String str = request.getParameter("str");
		if (str != null) {
			JSONArray prodJson = new JSONArray();
			ArrayList<Struttura> aule = struttDAO.doAulabyEdificio(str);
			for (Struttura aula : aule) {
				prodJson.put(aula.getAula());
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
