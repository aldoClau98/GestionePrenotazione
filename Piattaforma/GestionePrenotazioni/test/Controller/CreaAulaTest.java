package Controller;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

class CreaAulaTest extends Mockito{

	private static HttpServletRequest request;
	private static HttpServletResponse response;
	private static CreaAula servlet = new CreaAula();
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
	void testCase_4_3_01() throws ServletException, IOException {
		doReturn(null).when(request).getParameter("nome");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Errore, campo Nome non compilato" , ac.getValue());
	}
	
	@Test
	void testCase_4_3_02() throws ServletException, IOException {
		doReturn("e@1").when(request).getParameter("nome");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Errore, campo Nome non valido" , ac.getValue());
	}
	
	@Test
	void testCase_4_3_03() throws ServletException, IOException {
		doReturn("e1").when(request).getParameter("nome");
		doReturn(null).when(request).getParameter("descrizione");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Errore, campo Descrizione non compilato" , ac.getValue());
	}
	
	@Test
	void testCase_4_3_04() throws ServletException, IOException {
		doReturn("e1").when(request).getParameter("nome");
		doReturn("Nuova aula per l’edificio").when(request).getParameter("descrizione");
		doReturn(null).when(request).getParameter("edificio");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Errore, campo Edificio non compilato" , ac.getValue());
	}

	@Test
	void testCase_4_3_05() throws ServletException, IOException {
		doReturn("e1").when(request).getParameter("nome");
		doReturn("Nuova aula per l’edificio").when(request).getParameter("descrizione");
		doReturn("E2").when(request).getParameter("edificio");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Creazione avvenuta" , ac.getValue());
	}
}
