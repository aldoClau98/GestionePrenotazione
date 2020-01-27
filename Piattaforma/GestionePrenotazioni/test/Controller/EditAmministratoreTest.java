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

class EditAmministratoreTest extends Mockito{

	private static HttpServletRequest request;
	private static HttpServletResponse response;
	private static EditAmministratore servlet = new EditAmministratore();
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
	void testCase_4_6_01() throws ServletException, IOException {
		doReturn(null).when(request).getParameter("email");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Riassegnamento fallito" , ac.getValue());
	}
	
	@Test
	void testCase_4_6_02() throws ServletException, IOException {
		doReturn("veronica.marcantuono@unisa.it").when(request).getParameter("email");
		doReturn(null).when(request).getParameter("dip");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Errore, campo Dipartimento non compilato" , ac.getValue());
	}
	
	@Test
	void testCase_4_6_03() throws ServletException, IOException {
		doReturn("veronica.marcantuono@unisa.it").when(request).getParameter("email");
		doReturn("informatica").when(request).getParameter("dip");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Riassegnamento avvenuto" , ac.getValue());
	}
}
