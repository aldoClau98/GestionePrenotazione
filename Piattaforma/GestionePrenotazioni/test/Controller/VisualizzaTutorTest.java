package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class VisualizzaTutorTest 
extends Mockito{

	private static HttpServletRequest request;
	private static HttpServletResponse response;
	private static NavGestisciTutor servlet = new NavGestisciTutor();
	private static RequestDispatcher requestDispatcher;
	
	@BeforeEach
	public void inizializza() throws NoSuchFieldException, SecurityException, Exception {
		request = spy(HttpServletRequest.class);
		response = spy(HttpServletResponse.class);
		requestDispatcher = spy(RequestDispatcher.class);
	}
	
	@Test
	void testCasa_FN_3_01() throws ServletException, IOException {
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
	}

}
