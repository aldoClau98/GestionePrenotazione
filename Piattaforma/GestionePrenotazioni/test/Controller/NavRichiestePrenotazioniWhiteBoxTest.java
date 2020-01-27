package Controller;

import java.io.IOException;
import java.lang.reflect.Field;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import Model.DipartimentoDAO;
import Model.Utente;

class NavRichiestePrenotazioniWhiteBoxTest extends Mockito{

	private static HttpServletRequest request;
	private static HttpServletResponse response;
	private static HttpSession session;
	private static NavRichiestePrenotazioni servlet = new NavRichiestePrenotazioni();
	private static RequestDispatcher requestDispatcher;
	private static DipartimentoDAO dipDAO;

	@BeforeEach
	public void inizializza() throws NoSuchFieldException, SecurityException, Exception {
		request = spy(HttpServletRequest.class);
		response = spy(HttpServletResponse.class);
		session = spy(HttpSession.class);
		requestDispatcher = spy(RequestDispatcher.class);
		dipDAO = spy(DipartimentoDAO.class);
		setFinalStatic(servlet.getClass().getSuperclass().getDeclaredField("dipDAO"), dipDAO);
	}
	
	public static void setFinalStatic(Field field, Object newValue) throws Exception {
	    field.setAccessible(true);
	    field.set(null, newValue);
	  }
	
	@AfterEach
	public void setDown() throws NoSuchFieldException, SecurityException, Exception {
		setFinalStatic(servlet.getClass().getSuperclass().getDeclaredField("dipDAO"), new DipartimentoDAO());
	}
	
	@Test
	void testCaseWhiteBox_001() throws ServletException, IOException {
		doReturn(session).when(request).getSession();
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		doReturn(new Utente("veronica", "marcantuono", "veronica.marcantuono@unisa.it", "12345678", 2)).when(session).getAttribute(eq("utente"));
		doReturn("informatica").when(dipDAO).doRetrieveByKey(any());
		servlet.doPost(request, response);
	}

}
