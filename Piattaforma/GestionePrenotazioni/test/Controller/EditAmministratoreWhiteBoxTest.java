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

import Model.UtenteDAO;

class EditAmministratoreWhiteBoxTest extends Mockito{

	private static HttpServletRequest request;
	private static HttpServletResponse response;
	private static EditAmministratore servlet = new EditAmministratore();
	private static RequestDispatcher requestDispatcher;
	private static ArgumentCaptor<String> ac;
	private static UtenteDAO userDAO;

	@BeforeEach
	public void inizializza() throws NoSuchFieldException, SecurityException, Exception {
		request = spy(HttpServletRequest.class);
		response = spy(HttpServletResponse.class);
		requestDispatcher = spy(RequestDispatcher.class);
		userDAO = spy(UtenteDAO.class);		
		ac = ArgumentCaptor.forClass(String.class);
		setFinalStatic(servlet.getClass().getSuperclass().getDeclaredField("userDAO"), userDAO);
	}
	
	public static void setFinalStatic(Field field, Object newValue) throws Exception {
	    field.setAccessible(true);
	    field.set(null, newValue);
	  }
	
	@AfterEach
	public void setDown() throws NoSuchFieldException, SecurityException, Exception {
		setFinalStatic(servlet.getClass().getSuperclass().getDeclaredField("userDAO"), new UtenteDAO());
	}
	
	@Test
	void testCaseWhiteBox_001() throws ServletException, IOException {
		doReturn("veronica.marcantuono@unisa.it").when(request).getParameter("email");
		doReturn("informatica").when(request).getParameter("dip");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		doReturn(0).when(userDAO).doChangeDip(any(), any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Riassegnamento fallito" , ac.getValue());
	}
}
