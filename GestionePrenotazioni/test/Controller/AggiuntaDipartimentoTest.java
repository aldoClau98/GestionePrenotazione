package Controller;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
class AggiuntaDipartimentoTest extends Mockito{

	private HttpServletRequest request;
	private HttpServletResponse response;
	private static  CreaDipartimento servlet = new CreaDipartimento();

	@BeforeAll
	void inizializza() {
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
	}
	
	@Test
	void test_4_1_01() throws ServletException, IOException {
		when(request.getParameter("nome")).thenReturn("");
		servlet.doPost(request, response);

	}
	@Test
	void test_4_1_02() throws ServletException, IOException {
		when(request.getParameter("nome")).thenReturn("Informat@ca");
		servlet.doPost(request, response);

	}
	@Test
	void test_4_1_03() throws ServletException, IOException {
		when(request.getParameter("nome")).thenReturn("informatica");
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
