package Controller;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.lang.reflect.Field;

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

class AccettaRichiestaWhiteBoxTest extends Mockito{

	private static HttpServletRequest request;
	private static HttpServletResponse response;
	private static HttpSession session;
	private static AccettaRichiesta servlet = new AccettaRichiesta();
	private static RequestDispatcher requestDispatcher;
	private static ArgumentCaptor<String> ac;
	private static PrenotazioneDAO prenDAO;
	
	@BeforeEach
	public void inizializza() throws NoSuchFieldException, SecurityException, Exception {
		request = spy(HttpServletRequest.class);
		response = spy(HttpServletResponse.class);
		session = spy(HttpSession.class);
		requestDispatcher = spy(RequestDispatcher.class);
		ac = ArgumentCaptor.forClass(String.class);
		prenDAO = spy(PrenotazioneDAO.class);
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
		doReturn(session).when(request).getSession();
		doReturn("14").when(request).getParameter("oraInizio");
		doReturn("16").when(request).getParameter("oraFine");
		doReturn("2020-01-05").when(request).getParameter("data");
		doReturn("F1").when(request).getParameter("aula");
		doReturn("F2").when(request).getParameter("edificio");
		doReturn(0).when(prenDAO).controlloOra(any(), anyInt(), anyInt(), any(), any());
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Prenotazione non accettata" , ac.getValue());
	}
	@Test
	void testCaseWhiteBox_002() throws ServletException, IOException {
		doReturn(session).when(request).getSession();
		doReturn("14").when(request).getParameter("oraInizio");
		doReturn("16").when(request).getParameter("oraFine");
		doReturn("2020-01-05").when(request).getParameter("data");
		doReturn("F1").when(request).getParameter("aula");
		doReturn("F2").when(request).getParameter("edificio");
		doReturn("1").when(request).getParameter("id");
		doReturn(1).when(prenDAO).controlloOra(any(), anyInt(), anyInt(), any(), any());
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(eq("messaggio"), ac.capture());
		assertEquals("Prenotazione accettata" , ac.getValue());
	}

}
