package Controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
class PrenotazioneAulaTest extends Mockito {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private static DomandaPrenotazione servlet = new DomandaPrenotazione();

	@BeforeAll
	void inizializza() {
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
	}
	
	@Test
	void test_2_1_01() throws ServletException, IOException {
		when(request.getParameter("edificio")).thenReturn("");
		servlet.doPost(request, response);

	}
	@Test
	void test_2_1_02() throws ServletException, IOException {
		when(request.getParameter("edificio")).thenReturn("F1");
		when(request.getParameter("aula")).thenReturn("");
		
		servlet.doPost(request, response);

	}
	@Test
	void test_2_1_03() throws ServletException, IOException {
		when(request.getParameter("edificio")).thenReturn("F2");
		when(request.getParameter("aula")).thenReturn("F8");
		when(request.getParameter("titolo")).thenReturn("");

		servlet.doPost(request, response);

	}
	@Test
	void test_2_1_04() throws ServletException, IOException {
		when(request.getParameter("edificio")).thenReturn("F2");
		when(request.getParameter("aula")).thenReturn("F8");
		when(request.getParameter("titolo")).thenReturn("Tutorato@");

		
		servlet.doPost(request, response);

	}
	@Test
	void test_2_1_05() throws ServletException, IOException {
		when(request.getParameter("edificio")).thenReturn("F2");
		when(request.getParameter("aula")).thenReturn("F8");
		when(request.getParameter("titolo")).thenReturn("Tutorato");
		when(request.getParameter("descrizione")).thenReturn("descrizione motivo tutor@to");

		
		servlet.doPost(request, response);

	}
	@Test
	void test_2_1_06() throws ServletException, IOException {
		when(request.getParameter("edificio")).thenReturn("F2");
		when(request.getParameter("aula")).thenReturn("F8");
		when(request.getParameter("titolo")).thenReturn("Tutorato");
		when(request.getParameter("descrizione")).thenReturn("descrizione tutorato");

		
		servlet.doPost(request, response);

	}
	@Test
	void test_2_1_07() throws ServletException, IOException {
		when(request.getParameter("edificio")).thenReturn("F2");
		when(request.getParameter("aula")).thenReturn("F8");
		when(request.getParameter("titolo")).thenReturn("Tutorato");
		when(request.getParameter("descrizione")).thenReturn("descrizione tutorato");
		when(request.getParameter("data")).thenReturn("");

		
		servlet.doPost(request, response);

	}
	@Test
	void test_2_1_08() throws ServletException, IOException {
		when(request.getParameter("edificio")).thenReturn("F2");
		when(request.getParameter("aula")).thenReturn("F8");
		when(request.getParameter("titolo")).thenReturn("Tutorato");
		when(request.getParameter("descrizione")).thenReturn("descrizione tutorato");
		when(request.getParameter("data")).thenReturn("12/");

		
		servlet.doPost(request, response);

	}
	@Test
	void test_2_1_09() throws ServletException, IOException {
		when(request.getParameter("edificio")).thenReturn("F2");
		when(request.getParameter("aula")).thenReturn("F8");
		when(request.getParameter("titolo")).thenReturn("Tutorato");
		when(request.getParameter("descrizione")).thenReturn("descrizione tutorato");
		when(request.getParameter("data")).thenReturn("12/12");

		
		servlet.doPost(request, response);

	}
	@Test
	void test_2_1_10() throws ServletException, IOException {
		when(request.getParameter("edificio")).thenReturn("F2");
		when(request.getParameter("aula")).thenReturn("F8");
		when(request.getParameter("titolo")).thenReturn("Tutorato");
		when(request.getParameter("descrizione")).thenReturn("descrizione tutorato");
		when(request.getParameter("data")).thenReturn("12/12/2018");

		
		servlet.doPost(request, response);

	}
	@Test
	void test_2_1_11() throws ServletException, IOException {
		when(request.getParameter("edificio")).thenReturn("F2");
		when(request.getParameter("aula")).thenReturn("F8");
		when(request.getParameter("titolo")).thenReturn("Tutorato");
		when(request.getParameter("descrizione")).thenReturn("descrizione tutorato");
		when(request.getParameter("data")).thenReturn("12/12/2020");
		when(request.getParameter("oraInizio")).thenReturn("");

		
		servlet.doPost(request, response);

	}
	@Test
	void test_2_1_12() throws ServletException, IOException {
		when(request.getParameter("edificio")).thenReturn("F2");
		when(request.getParameter("aula")).thenReturn("F8");
		when(request.getParameter("titolo")).thenReturn("Tutorato");
		when(request.getParameter("descrizione")).thenReturn("descrizione tutorato");
		when(request.getParameter("data")).thenReturn("12/12/2020");
		when(request.getParameter("oraInizio")).thenReturn("14");
		when(request.getParameter("oraInizio")).thenReturn("");

		
		servlet.doPost(request, response);

	}
	@Test
	void test_2_1_13() throws ServletException, IOException {
		when(request.getParameter("edificio")).thenReturn("F2");
		when(request.getParameter("aula")).thenReturn("F8");
		when(request.getParameter("titolo")).thenReturn("Tutorato");
		when(request.getParameter("descrizione")).thenReturn("descrizione tutorato");
		when(request.getParameter("data")).thenReturn("12/12/2020");
		when(request.getParameter("oraInizio")).thenReturn("14");
		when(request.getParameter("oraInizio")).thenReturn("12");

		
		servlet.doPost(request, response);

	}
	@Test
	void test_2_1_14() throws ServletException, IOException {
		when(request.getParameter("edificio")).thenReturn("F2");
		when(request.getParameter("aula")).thenReturn("F8");
		when(request.getParameter("titolo")).thenReturn("Tutorato");
		when(request.getParameter("descrizione")).thenReturn("descrizione tutorato");
		when(request.getParameter("data")).thenReturn("12/12/2020");
		when(request.getParameter("oraInizio")).thenReturn("14");
		when(request.getParameter("oraInizio")).thenReturn("16");

		
		servlet.doPost(request, response);

	}
}
