package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import Model.Utente;

class NavModificaPasswordWhiteBoxTest extends Mockito{

	private static HttpServletRequest request;
	private static HttpServletResponse response;
	private static HttpSession session;
	private static NavModificaPassword servlet = new NavModificaPassword();
	private static RequestDispatcher requestDispatcher;
	
	@BeforeEach
	public void inizializza() throws NoSuchFieldException, SecurityException, Exception {
		request = spy(HttpServletRequest.class);
		response = spy(HttpServletResponse.class);
		session = spy(HttpSession.class);
		requestDispatcher = spy(RequestDispatcher.class);
	}
	
	@Test
	void testCaseWhiteBox_001() throws ServletException, IOException {
		doReturn(session).when(request).getSession();
		doReturn(new Utente()).when(session).getAttribute(eq("utente"));
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
	}

}
