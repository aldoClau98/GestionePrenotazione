package Controller;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import Model.PrenotazioneDAO;
import Model.Utente;

class EliminaRichiestaWhiteBoxTest extends Mockito{

	private static HttpServletRequest request;
	private static HttpServletResponse response;
	private static HttpSession session;
	private static EliminaRichiesta servlet = new EliminaRichiesta();
	private static RequestDispatcher requestDispatcher;
	private static ArgumentCaptor<String> ac;
	private static PrenotazioneDAO prenDAO;
	
	@BeforeEach
	public void inizializza() throws NoSuchFieldException, SecurityException, Exception {
		request = spy(HttpServletRequest.class);
		response = spy(HttpServletResponse.class);
		session = spy(HttpSession.class);
		requestDispatcher = spy(RequestDispatcher.class);
		prenDAO = spy(PrenotazioneDAO.class);		
		ac = ArgumentCaptor.forClass(String.class);
		setFinalStatic(servlet.getClass().getSuperclass().getDeclaredField("prenDAO"), prenDAO);
	}
	
	public static void setFinalStatic(Field field, Object newValue) throws Exception {
	    field.setAccessible(true);
	    field.set(null, newValue);
	  }
	
	@AfterEach
	public void setDown() throws NoSuchFieldException, SecurityException, Exception {
		setFinalStatic(servlet.getClass().getSuperclass().getDeclaredField("prenDAO"), new PrenotazioneDAO());
	}
	
	@Test
	void testCaseWhiteBox_001() throws ServletException, IOException {
		doReturn("100").when(request).getParameter("id");
		doReturn(session).when(request).getSession();
		doReturn(new Utente("Mario", "Rossi", "m.rossi@unisa.it", "Utente13", 1)).when(session).getAttribute("utente");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		doReturn(new ArrayList<Model.Prenotazione>()).when(prenDAO).doRetrieveByDate("m.rossi@unisa.it", "2020/01/01");
		servlet.doPost(request, response);
		verify(request).setAttribute(eq("messaggio"), ac.capture());
		assertEquals("Eliminazione effettuata" , ac.getValue());
	}

	@Test
	void testCaseWhiteBox_002() throws ServletException, IOException {
		doReturn(null).when(request).getParameter("id");
		doReturn(session).when(request).getSession();
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(eq("messaggio"), ac.capture());
		assertEquals("Eliminazione non effettuata" , ac.getValue());
	}
}
