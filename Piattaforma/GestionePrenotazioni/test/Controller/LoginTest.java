package Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

class LoginTest extends Mockito {
	
	private static HttpServletRequest request;
	private static HttpServletResponse response;
	private static HttpSession session;
	private static Login servlet = new Login();
	private static RequestDispatcher requestDispatcher;
	private static ArgumentCaptor<String> ac;

	@BeforeEach
	public void inizializza() throws NoSuchFieldException, SecurityException, Exception {
		request = spy(HttpServletRequest.class);
		response = spy(HttpServletResponse.class);
		session = spy(HttpSession.class);
		requestDispatcher = spy(RequestDispatcher.class);
		ac = ArgumentCaptor.forClass(String.class);
	}
	
	@Test
	void testCase_1_2_01() throws ServletException, IOException {
		doReturn(null).when(request).getParameter("email");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Errore, campo Email non compilato" , ac.getValue());
	}
	
	@Test
	void testCase_1_2_02() throws ServletException, IOException {
		doReturn("veronica.marcantuono@libero.it").when(request).getParameter("email");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Errore, campo Email non valido" , ac.getValue());
	}
	
	@Test
	void testCase_1_2_03() throws ServletException, IOException {
		doReturn("veronica.marcantuono@unisa.it").when(request).getParameter("email");
		doReturn(null).when(request).getParameter("password");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Errore, campo Password non compilato" , ac.getValue());
	}
	
	@Test
	void testCase_1_2_04() throws ServletException, IOException {
		doReturn("veronica.marcantuono@unisa.it").when(request).getParameter("email");
		doReturn("Ute@@").when(request).getParameter("password");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Errore, campo Password non valido" , ac.getValue());
	}
	
	@Test
	void testCase_1_2_05() throws ServletException, IOException {
		doReturn("veronica.marcantuono@unisa.it").when(request).getParameter("email");
		doReturn("12345678").when(request).getParameter("password");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		doReturn(session).when(request).getSession();
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Login avvenuto" , ac.getValue());
	}
}
