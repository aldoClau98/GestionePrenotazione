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

class AssegnaDipartimentoAulaTest extends Mockito{

	private static HttpServletRequest request;
	private static HttpServletResponse response;
	private static AssegnaDipartimentoAula servlet = new AssegnaDipartimentoAula();
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
	void testCase_4_4_01() throws ServletException, IOException {
		doReturn("P1").when(request).getParameter("aula");
		doReturn("P3").when(request).getParameter("edificio");
		doReturn(null).when(request).getParameter("dipartimento");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Errore, campo Dipartimento non compilato", ac.getValue());
	}

	@Test
	void testCase_4_4_02() throws ServletException, IOException {
		doReturn("P1").when(request).getParameter("aula");
		doReturn("F3").when(request).getParameter("edificio");
		doReturn("informatica").when(request).getParameter("dipartimento");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Aula assegnata", ac.getValue());
	}
}
