package Controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mockito;

class ModificaPasswordTest extends Mockito{
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private static ModificaPassword servlet = new ModificaPassword();

	@BeforeAll
	void inizializza() {
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
	}
	
	@Test
	void test1_3_01() throws ServletException, IOException {
		when(request.getParameter("password")).thenReturn("");
		servlet.doPost(request, response);

	}
	@Test
	void test1_3_02() throws ServletException, IOException {
		when(request.getParameter("password")).thenReturn("Utente13");
		when(request.getParameter("nuovaPassword")).thenReturn("");

		servlet.doPost(request, response);

	}
	@Test
	void test1_3_03() throws ServletException, IOException {
		when(request.getParameter("password")).thenReturn("Utente13");
		when(request.getParameter("nuovaPassword")).thenReturn("Utente14");
		when(request.getParameter("confermaPassword")).thenReturn("");

		servlet.doPost(request, response);

	}
	@Test
	void test1_3_04() throws ServletException, IOException {
		when(request.getParameter("password")).thenReturn("Utente13");
		when(request.getParameter("nuovaPassword")).thenReturn("Utente14");
	

		servlet.doPost(request, response);

	}
	@Test
	void test1_3_05() throws ServletException, IOException {
		when(request.getParameter("password")).thenReturn("Utente13");
		when(request.getParameter("nuovaPassword")).thenReturn("Utente14");
		when(request.getParameter("confermaPassword")).thenReturn("Utente14");

		servlet.doPost(request, response);

	}


}
