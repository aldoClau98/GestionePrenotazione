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

public class AssegnaAulaTutorTest extends Mockito{
	
	private static HttpServletRequest request;
	private static HttpServletResponse response;
	private static AulaStudenti servlet = new AulaStudenti();
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
		doReturn("P1").when(request).getParameter("aula");
		doReturn("F3").when(request).getParameter("edificio");
		doReturn("3").when(request).getParameter("tipoaula");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		doReturn(1).when(struttDAO).doUpdate(any(), any(), any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Prenotabilita' aula cambiata" , ac.getValue());
	}
	@Test
	void testCaseWhiteBox_002() throws ServletException, IOException {
		doReturn("P1").when(request).getParameter("aula");
		doReturn("F3").when(request).getParameter("edificio");
		doReturn("2").when(request).getParameter("tipoaula");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		doReturn(1).when(struttDAO).doUpdate(any(), any(), any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Prenotabilita' aula cambiata" , ac.getValue());
	}

}
