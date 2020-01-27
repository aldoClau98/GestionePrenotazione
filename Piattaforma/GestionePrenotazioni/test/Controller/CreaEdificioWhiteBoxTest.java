package Controller;

import static org.junit.jupiter.api.Assertions.*;

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

import Model.Struttura;
import Model.StrutturaDAO;

class CreaEdificioWhiteBoxTest extends Mockito{
	
	private static HttpServletRequest request;
	private static HttpServletResponse response;
	private static CreaEdificio servlet = new CreaEdificio();
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
		doReturn(null).when(request).getParameter("aula");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Creazione fallita" , ac.getValue());
	}
	@Test
	void testCaseWhiteBox_002() throws ServletException, IOException {
		doReturn("G1").when(request).getParameter("aula");
		doReturn("E2").when(request).getParameter("edificio");
		doReturn("Nuovo edificio per il dipartimento").when(request).getParameter("descrizione");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		doReturn(new Struttura()).when(struttDAO).doStrutturabyName(any(), any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Creazione fallita, edificio esistente" , ac.getValue());
	}
	@Test
	void testCaseWhiteBox_003() throws ServletException, IOException {
		doReturn("G2").when(request).getParameter("aula");
		doReturn("E2").when(request).getParameter("edificio");
		doReturn("Nuovo edificio per il dipartimento").when(request).getParameter("descrizione");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		doReturn(0).when(struttDAO).doSave(any(), any(), any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Creazione fallita" , ac.getValue());
	}
}
