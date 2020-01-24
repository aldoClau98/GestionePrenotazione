package Controller;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
class AggiuntaEdificioTest extends Mockito{

	private HttpServletRequest request;
	private HttpServletResponse response;
	private static  CreaEdificio servlet = new CreaEdificio();

	@BeforeAll
	void inizializza() {
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
	}
	
	@Test
	void test_4_2_01() throws ServletException, IOException {
		when(request.getParameter("nome")).thenReturn("");
		servlet.doPost(request, response);

	}
	@Test
	void test_4_2_02() throws ServletException, IOException {
		when(request.getParameter("nome")).thenReturn("E@1");
		servlet.doPost(request, response);

	}
	@Test
	void test_4_2_03() throws ServletException, IOException {
		when(request.getParameter("nome")).thenReturn("E1");
		when(request.getParameter("descrizione")).thenReturn("");

		
		servlet.doPost(request, response);

	}
	@Test
	void test_4_1_04() throws ServletException, IOException {
		when(request.getParameter("nome")).thenReturn("informatica");
		when(request.getParameter("descrizione")).thenReturn("Nuovo diparitmento di inf@ò!tica");

		
		servlet.doPost(request, response);

	}
	@Test
	void test_4_1_05() throws ServletException, IOException {
		when(request.getParameter("nome")).thenReturn("informatica");
		when(request.getParameter("descrizione")).thenReturn("Nuovo diparitmento di informatica");

		
		servlet.doPost(request, response);

	}
}
