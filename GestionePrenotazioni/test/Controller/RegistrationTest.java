package Controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mockito;

class RegistrationTest extends Mockito {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private static Registrazione servlet = new Registrazione();

	@BeforeAll
	void inizializza() {
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
	}

	@Test
	void testCase1_1() throws ServletException, IOException {
		when(request.getParameter("nome")).thenReturn("");
		servlet.doPost(request, response);
		

	}
	@Test
	void testCase1_2() throws ServletException, IOException {
		when(request.getParameter("nome")).thenReturn("9####");
	
		servlet.doPost(request, response);

	}
	@Test
	void testCase1_3() throws ServletException, IOException {
		when(request.getParameter("nome")).thenReturn("Mario");
		when(request.getParameter("Cognome")).thenReturn("");
		servlet.doPost(request, response);

	}
	@Test
	void testCase1_4() throws ServletException, IOException {
		when(request.getParameter("nome")).thenReturn("Mario");
		when(request.getParameter("Cognome")).thenReturn("Rossi.[]");
		servlet.doPost(request, response);

	}
	@Test
	void testCase1_5() throws ServletException, IOException {
		when(request.getParameter("nome")).thenReturn("Mario");
		when(request.getParameter("Cognome")).thenReturn("Rossi");
		when(request.getParameter("email")).thenReturn("");

		servlet.doPost(request, response);

	}
	@Test
	void testCase1_6() throws ServletException, IOException {
		when(request.getParameter("nome")).thenReturn("Mario");
		when(request.getParameter("Cognome")).thenReturn("Rossi");
		when(request.getParameter("email")).thenReturn("___*");
		servlet.doPost(request, response);

	}
	@Test
	void testCase1_7() throws ServletException, IOException {
		when(request.getParameter("nome")).thenReturn("Mario");
		when(request.getParameter("Cognome")).thenReturn("Rossi");
		when(request.getParameter("email")).thenReturn("m.rossi@unisa.it");
		when(request.getParameter("password")).thenReturn("");

		servlet.doPost(request, response);

	}
	@Test
	void testCase1_8() throws ServletException, IOException {
		when(request.getParameter("nome")).thenReturn("Mario");
		when(request.getParameter("Cognome")).thenReturn("Rossi");
		when(request.getParameter("email")).thenReturn("m.rossi@unisa.it");
		when(request.getParameter("password")).thenReturn("Utente13");

		servlet.doPost(request, response);

	}
	@Test
	void testCase1_9() throws ServletException, IOException {
		when(request.getParameter("nome")).thenReturn("Mario");
		when(request.getParameter("Cognome")).thenReturn("Rossi");
		when(request.getParameter("email")).thenReturn("m.rossi@unisa.it");
		when(request.getParameter("password")).thenReturn("Utente13");

		servlet.doPost(request, response);

	}
	
	

}
