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
class AggiuntaDipartimentoTest extends Mockito{

	private static HttpServletRequest request;
	private static HttpServletResponse response;
	private static CreaDipartimento servlet = new CreaDipartimento();
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
	void testCase_4_1_01() throws ServletException, IOException {
		doReturn(null).when(request).getParameter("dipartimento");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(eq("messaggio"), ac.capture());
		assertEquals("Errore, campo Nome non compilato" , ac.getValue());
	}
	
	@Test
	void testCase_4_1_02() throws ServletException, IOException {
		doReturn("Informat@ca").when(request).getParameter("dipartimento");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(eq("messaggio"), ac.capture());
		assertEquals("Errore, campo Nome non valido" , ac.getValue());
	}
	
	@Test
	void testCase_4_1_03() throws ServletException, IOException {
		doReturn("Religione").when(request).getParameter("dipartimento");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(eq("messaggio"), ac.capture());
		assertEquals("Dipartimento creato" , ac.getValue());
	}
}
