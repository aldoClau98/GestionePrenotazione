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

class ScegliAmministratoreTest extends Mockito{

	private static HttpServletRequest request;
	private static HttpServletResponse response;
	private static ScegliAmministratore servlet = new ScegliAmministratore();
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
	void testCase_4_5_01() throws ServletException, IOException {
		doReturn(null).when(request).getParameter("email");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(eq("messaggio"), ac.capture());
		assertEquals("Errore, campo Utente non compilato", ac.getValue());
	}

	@Test
	void testCase_4_5_02() throws ServletException, IOException {
		doReturn("andrea.claro@unisa.it").when(request).getParameter("email");
		doReturn("2").when(request).getParameter("flag");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(eq("messaggio"), ac.capture());
		assertEquals("Modifica avvenuta", ac.getValue());
	}

}
