package Controller;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import Controller.Registrazione;

class RegistrationTest extends Mockito {
	private static HttpServletRequest request;
	private static HttpServletResponse response;
	private static Registrazione servlet = new Registrazione();
	private static RequestDispatcher requestDispatcher;
	private static ArgumentCaptor<String> ac;
//	private static UtenteDAO userDAO;
	
//	public static void setFinalStatic(Field field, Object newValue) throws Exception {
//	    field.setAccessible(true);
//	    // remove final modifier from field
////	    Field modifiersField = Field.class.getDeclaredField("modifiers");
////	    modifiersField.setAccessible(true);
////	    modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
//	    field.set(null, newValue);
//	  }
	
	@BeforeEach
	public void inizializza() throws NoSuchFieldException, SecurityException, Exception {
		request = spy(HttpServletRequest.class);
		response = spy(HttpServletResponse.class);
		requestDispatcher = spy(RequestDispatcher.class);
//		userDAO = spy(UtenteDAO.class);
		ac = ArgumentCaptor.forClass(String.class);
//		setFinalStatic(servlet.getClass().getSuperclass().getDeclaredField("userDAO"), userDAO);
	}
	
	@AfterEach
	public void setDown() throws NoSuchFieldException, SecurityException, Exception {
//		setFinalStatic(servlet.getClass().getSuperclass().getDeclaredField("userDAO"), new UtenteDAO());
	}

	@Test
	void testCase_1_1_01() throws ServletException, IOException {
		doReturn(null).when(request).getParameter("nome");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Errore, campo Nome non compilato" , ac.getValue());
	}
	
	@Test
	void testCase_1_1_02() throws ServletException, IOException {
		doReturn("9####").when(request).getParameter("nome");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Errore, campo Nome compilato male" , ac.getValue());
	}
	
	@Test
	void testCase_1_1_03() throws ServletException, IOException {
		doReturn("Mario").when(request).getParameter("nome");
		doReturn(null).when(request).getParameter("cognome");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Errore, campo Cognome non compilato" , ac.getValue());
	}
	
	@Test
	void testCase_1_1_04() throws ServletException, IOException {
		doReturn("Mario").when(request).getParameter("nome");
		doReturn("Rossi1.[]").when(request).getParameter("cognome");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Errore, campo Cognome compilato male" , ac.getValue());
	}
	
	@Test
	void testCase_1_1_05() throws ServletException, IOException {
		doReturn("Mario").when(request).getParameter("nome");
		doReturn("Rossi").when(request).getParameter("cognome");
		doReturn(null).when(request).getParameter("email");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Errore, campo Email non compilato" , ac.getValue());
	}
	
	@Test
	void testCase_1_1_06() throws ServletException, IOException {
		doReturn("Mario").when(request).getParameter("nome");
		doReturn("Rossi").when(request).getParameter("cognome");
		doReturn("___*").when(request).getParameter("email");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Errore, campo Email compilato male" , ac.getValue());
	}
	
	@Test
	void testCase_1_1_07() throws ServletException, IOException {
		doReturn("Mario").when(request).getParameter("nome");
		doReturn("Rossi").when(request).getParameter("cognome");
		doReturn("m.rossi@unisa.it").when(request).getParameter("email");
		doReturn(null).when(request).getParameter("password");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Errore, campo Password non compilato" , ac.getValue());
	}
	
	@Test
	void testCase_1_1_08() throws ServletException, IOException {
		doReturn("Mario").when(request).getParameter("nome");
		doReturn("Rossi").when(request).getParameter("cognome");
		doReturn("m.rossi@unisa.it").when(request).getParameter("email");
		doReturn("n11#").when(request).getParameter("password");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Errore, campo Password compilato male" , ac.getValue());
	}
	
//	@Test
//	void testCase1_09() throws ServletException, IOException {
//		doReturn("Mario").when(request).getParameter("nome");
//		doReturn("Rossi").when(request).getParameter("cognome");
//		doReturn("m.rossi@unisa.it").when(request).getParameter("email");
//		doReturn("Utente13").when(request).getParameter("password");
//		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
//		doReturn(null).when(userDAO).doRetrieveByEmail(any());
//		doReturn(1).when(userDAO).doSave(any(), any(), any(), any(), anyInt());
//		servlet.doPost(request, response);
//		verify(request).setAttribute(any(), ac.capture());
//		assertEquals("Registrazione avvenuta" , ac.getValue());
//	}
	
	@Test
	void testCase_1_1_09() throws ServletException, IOException {
		doReturn("Mario").when(request).getParameter("nome");
		doReturn("Rossi").when(request).getParameter("cognome");
		doReturn("m.rossi@unisa.it").when(request).getParameter("email");
		doReturn("Utente13").when(request).getParameter("password");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Registrazione avvenuta" , ac.getValue());
	}
}

