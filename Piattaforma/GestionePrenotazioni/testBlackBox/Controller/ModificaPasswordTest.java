package Controller;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

class ModificaPasswordTest extends Mockito{
	
	private static HttpServletRequest request;
	private static HttpServletResponse response;
	private static ModificaPassword servlet = new ModificaPassword();
	private static RequestDispatcher requestDispatcher;
	private static ArgumentCaptor<String> ac;

	@BeforeEach
	public void inizializza() throws NoSuchFieldException, SecurityException, Exception {
		request = spy(HttpServletRequest.class);
		response = spy(HttpServletResponse.class);
		requestDispatcher = spy(RequestDispatcher.class);
		ac = ArgumentCaptor.forClass(String.class);
	}
	
	@Test
	void testCase_1_3_01() throws ServletException, IOException {
		doReturn("veronica.marcantuono@unisa.it").when(request).getParameter("email");
		doReturn(null).when(request).getParameter("password");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Errore, campo Password non compilato" , ac.getValue());
	}
	
	@Test
	void testCase_1_3_02() throws ServletException, IOException {
		doReturn("veronica.marcantuono@unisa.it").when(request).getParameter("email");
		doReturn("12345678").when(request).getParameter("password");
		doReturn(null).when(request).getParameter("rpassword");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Errore, campo Password nuova non compilato" , ac.getValue());
	}
	
	@Test
	void testCase_1_3_03() throws ServletException, IOException {
		doReturn("veronica.marcantuono@unisa.it").when(request).getParameter("email");
		doReturn("12345678").when(request).getParameter("password");
		doReturn("Utente14").when(request).getParameter("rpassword");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Modifica avvenuta" , ac.getValue());
	}
}
