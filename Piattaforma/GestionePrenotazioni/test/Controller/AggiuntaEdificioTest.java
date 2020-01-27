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
class AggiuntaEdificioTest extends Mockito{

	private static HttpServletRequest request;
	private static HttpServletResponse response;
	private static CreaEdificio servlet = new CreaEdificio();
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
	void testCase_4_2_01() throws ServletException, IOException {
		doReturn("start").when(request).getParameter("aula");
		doReturn(null).when(request).getParameter("edificio");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Errore, campo Nome non compilato" , ac.getValue());
	}
	@Test
	void testCase_4_2_02() throws ServletException, IOException {
		doReturn("start").when(request).getParameter("aula");
		doReturn("E@1").when(request).getParameter("edificio");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Errore, campo Nome non valido" , ac.getValue());
	}
	@Test
	void testCase_4_2_03() throws ServletException, IOException {
		doReturn("start").when(request).getParameter("aula");
		doReturn("E1").when(request).getParameter("edificio");
		doReturn(null).when(request).getParameter("descrizione");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Errore, campo Descrizione non compilato" , ac.getValue());
	}
	@Test
	void testCase_4_1_04() throws ServletException, IOException {
		doReturn("start").when(request).getParameter("aula");
		doReturn("E1").when(request).getParameter("edificio");
		doReturn("Nuovo edificio per il dipartimento").when(request).getParameter("descrizione");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Edificio creato" , ac.getValue());
	}
}
