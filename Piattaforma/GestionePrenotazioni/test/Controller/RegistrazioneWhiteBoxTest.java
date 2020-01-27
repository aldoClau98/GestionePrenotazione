package Controller;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import Model.Utente;
import Model.UtenteDAO;

class RegistrazioneWhiteBoxTest extends Mockito{

	private static HttpServletRequest request;
	private static HttpServletResponse response;
	private static Registrazione servlet = new Registrazione();
	private static RequestDispatcher requestDispatcher;
	private static ArgumentCaptor<String> ac;
	private static UtenteDAO userDAO;
	
	public static void setFinalStatic(Field field, Object newValue) throws Exception {
	    field.setAccessible(true);
	    // remove final modifier from field
//	    Field modifiersField = Field.class.getDeclaredField("modifiers");
//	    modifiersField.setAccessible(true);
//	    modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
	    field.set(null, newValue);
	  }
	
	@BeforeEach
	public void inizializza() throws NoSuchFieldException, SecurityException, Exception {
		request = spy(HttpServletRequest.class);
		response = spy(HttpServletResponse.class);
		requestDispatcher = spy(RequestDispatcher.class);
		userDAO = spy(UtenteDAO.class);
		ac = ArgumentCaptor.forClass(String.class);
		setFinalStatic(servlet.getClass().getSuperclass().getDeclaredField("userDAO"), userDAO);
	}
	
	@AfterEach
	public void setDown() throws NoSuchFieldException, SecurityException, Exception {
		setFinalStatic(servlet.getClass().getSuperclass().getDeclaredField("userDAO"), new UtenteDAO());
	}

	@Test
	void testCaseWhiteBox_001() throws ServletException, IOException {
		doReturn("test").when(request).getParameter("nome");
		doReturn("WhiteB").when(request).getParameter("cognome");
		doReturn("t1.white@unisa.it").when(request).getParameter("email");
		doReturn("12345").when(request).getParameter("password");
		doReturn(0).when(userDAO).doSave(any(), any(), any(), any(), anyInt());
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Registrazione fallita" , ac.getValue());
	}
	
	@Test
	void testCaseWhiteBox_002() throws ServletException, IOException {
		doReturn("test").when(request).getParameter("nome");
		doReturn("WhiteB").when(request).getParameter("cognome");
		doReturn("t2.white@unisa.it").when(request).getParameter("email");
		doReturn("12345").when(request).getParameter("password");
		doThrow(SQLException.class).when(userDAO).doSave(any(), any(), any(), any(), anyInt());
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Registrazione fallita" , ac.getValue());
	}
	
	@Test
	void testCaseWhiteBox_003() throws ServletException, IOException {
		doReturn("test").when(request).getParameter("nome");
		doReturn("WhiteB").when(request).getParameter("cognome");
		doReturn("t3.white@studenti.unisa.it").when(request).getParameter("email");
		doReturn("12345").when(request).getParameter("password");
		doReturn(0).when(userDAO).doSave(any(), any(), any(), any(), anyInt());
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Registrazione fallita" , ac.getValue());
	}
	
	@Test
	void testCaseWhiteBox_004() throws ServletException, IOException {
		doReturn("test").when(request).getParameter("nome");
		doReturn("WhiteB").when(request).getParameter("cognome");
		doReturn("t4.white@studenti.unisa.it").when(request).getParameter("email");
		doReturn("12345").when(request).getParameter("password");
		doThrow(SQLException.class).when(userDAO).doSave(any(), any(), any(), any(), anyInt());
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Registrazione fallita" , ac.getValue());
	}
	
	@Test
	void testCaseWhiteBox_005() throws ServletException, IOException {
		doReturn("test").when(request).getParameter("nome");
		doReturn("WhiteB").when(request).getParameter("cognome");
		doReturn("t5.white@studenti.unisa.it").when(request).getParameter("email");
		doReturn("12345").when(request).getParameter("password");
		doReturn(new Utente()).when(userDAO).doRetrieveByEmail(any());
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Utente già esistente" , ac.getValue());
	}
	
	@Test
	void testCaseWhiteBox_006() throws ServletException, IOException {
		doReturn("test").when(request).getParameter("nome");
		doReturn("WhiteB").when(request).getParameter("cognome");
		doReturn("t6.white@studenti.unisa.it").when(request).getParameter("email");
		doReturn("12345").when(request).getParameter("password");
		doReturn(1).when(userDAO).doSave(any(), any(), any(), any(), anyInt());
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Registrazione avvenuta" , ac.getValue());
	}
//	
//	@Test
//	void testCaseWhiteBox_002() throws ServletException, IOException {
//		doReturn("Mario").when(request).getParameter("nome");
//		doReturn("Rossi").when(request).getParameter("cognome");
//		doReturn("m.rossi@unisa.it").when(request).getParameter("email");
//		doReturn("Utente13").when(request).getParameter("password");
//		doReturn(null).when("email").split(any());
//		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
//		servlet.doPost(request, response);
//		verify(request).setAttribute(any(), ac.capture());
//		assertEquals("Registrazione avvenuta" , ac.getValue());
//	}
}
