package Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.lang.reflect.Field;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import Model.StrutturaDAO;

class CreaAulaWhiteBoxTest extends Mockito{

	private static HttpServletRequest request;
	private static HttpServletResponse response;
	private static CreaAula servlet = new CreaAula();
	private static RequestDispatcher requestDispatcher;
	private static ArgumentCaptor<String> ac;
	private static StrutturaDAO struttDAO;
	
	@BeforeEach
	public void inizializza() throws NoSuchFieldException, SecurityException, Exception {
		request = spy(HttpServletRequest.class);
		response = spy(HttpServletResponse.class);
		requestDispatcher = spy(RequestDispatcher.class);
		struttDAO = spy(StrutturaDAO.class);		
		ac = ArgumentCaptor.forClass(String.class);
		setFinalStatic(servlet.getClass().getSuperclass().getDeclaredField("struttDAO"), struttDAO);
	}
	
	public static void setFinalStatic(Field field, Object newValue) throws Exception {
	    field.setAccessible(true);
	    field.set(null, newValue);
	  }
	
	@AfterEach
	public void setDown() throws NoSuchFieldException, SecurityException, Exception {
		setFinalStatic(servlet.getClass().getSuperclass().getDeclaredField("struttDAO"), new StrutturaDAO());
	}
	
	@Test
	void testCaseWhiteBox_001() throws ServletException, IOException {
		doReturn("e2").when(request).getParameter("nome");
		doReturn("Nuova aula per l’edificio").when(request).getParameter("descrizione");
		doReturn("G2#").when(request).getParameter("edificio");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Errore, campo Edificio non valido" , ac.getValue());
	}
	
	@Test
	void testCaseWhiteBox_002() throws ServletException, IOException {
		doReturn("e2").when(request).getParameter("nome");
		doReturn("Nuova aula per l’edificio").when(request).getParameter("descrizione");
		doReturn("G2").when(request).getParameter("edificio");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		doReturn(0).when(struttDAO).doSave(any(), any(), any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Creazione fallita" , ac.getValue());
	}
}
