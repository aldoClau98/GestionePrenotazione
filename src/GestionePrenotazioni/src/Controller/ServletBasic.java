package Controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import Model.DipartimentoDAO;
import Model.MyCalendar;
import Model.PrenotazioneDAO;
import Model.StrutturaDAO;
import Model.UtenteDAO;

@WebServlet("/ServletBasic")
public class ServletBasic extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected static MyCalendar dateToday = new MyCalendar();
	protected static String dataCorrente = dateToday.getToday();
	protected static DipartimentoDAO dipDAO = new DipartimentoDAO();
	protected static StrutturaDAO struttDAO = new StrutturaDAO();
	protected static PrenotazioneDAO prenDAO = new PrenotazioneDAO();
	protected static UtenteDAO userDAO = new UtenteDAO();

}
