package Controller;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LoginTest extends Mockito {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private static Login servlet = new Login();

	@BeforeAll
	void inizializza() {
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
	}
	
	@Test
	void test1_2_01() throws ServletException, IOException {
		when(request.getParameter("email")).thenReturn("");
		servlet.doPost(request, response);

	}
	@Test
	void test1_2_02() throws ServletException, IOException {
		when(request.getParameter("email")).thenReturn("vernica.marcantuono@libero.it");
		servlet.doPost(request, response);

	}
	@Test
	void test1_2_03() throws ServletException, IOException {
		when(request.getParameter("email")).thenReturn("vernica.marcantuono@unisa.it");
		when(request.getParameter("password")).thenReturn("");

		servlet.doPost(request, response);

	}
	@Test
	void test1_2_04() throws ServletException, IOException {
		when(request.getParameter("email")).thenReturn("vernica.marcantuono@unisa.it");
		when(request.getParameter("password")).thenReturn("Ute12");

		servlet.doPost(request, response);

	}
	@Test
	void test1_2_05() throws ServletException, IOException {
		when(request.getParameter("email")).thenReturn("vernica.marcantuono@unisa.it");
		when(request.getParameter("password")).thenReturn("12345678");

		servlet.doPost(request, response);

	}
	

}
