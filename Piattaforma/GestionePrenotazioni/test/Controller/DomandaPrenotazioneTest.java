package Controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import Model.Utente;
class DomandaPrenotazioneTest extends Mockito {

	private static HttpServletRequest request;
	private static HttpServletResponse response;
	private static HttpSession session;
	private static DomandaPrenotazione servlet = new DomandaPrenotazione();
	private static RequestDispatcher requestDispatcher;
	private static ArgumentCaptor<String> ac;

	@BeforeEach
	public void inizializza() throws NoSuchFieldException, SecurityException, Exception {
		request = spy(HttpServletRequest.class);
		response = spy(HttpServletResponse.class);
		session = spy(HttpSession.class);
		requestDispatcher = spy(RequestDispatcher.class);
		ac = ArgumentCaptor.forClass(String.class);
	}
	
	@Test
	void testCase_2_1_01() throws ServletException, IOException {
		doReturn(null).when(request).getParameter("edificio");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Prenotazione fallita" , ac.getValue());

	}
	
	@Test
	void testCase_2_1_02() throws ServletException, IOException {
		doReturn("F1").when(request).getParameter("edificio");
		doReturn(null).when(request).getParameter("aula");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Prenotazione fallita" , ac.getValue());
	}
	
	@Test
	void testCase_2_1_03() throws ServletException, IOException {
		doReturn("F2").when(request).getParameter("edificio");
		doReturn("fff8").when(request).getParameter("aula");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Prenotazione fallita" , ac.getValue());
	}
	
	@Test
	void testCase_2_1_04() throws ServletException, IOException {
		doReturn("F2").when(request).getParameter("edificio");
		doReturn("F1").when(request).getParameter("aula");
		doReturn(null).when(request).getParameter("titolo");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		doReturn(session).when(request).getSession();
		doReturn(new Utente("veronica", "marcantuono", "veronica.marcantuono@unisa.it", "12345678", 2)).when(session).getAttribute("utente");
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Errore, campo Titolo non compilato" , ac.getValue());
	}
	
	@Test
	void testCase_2_1_05() throws ServletException, IOException {
		doReturn("F2").when(request).getParameter("edificio");
		doReturn("F1").when(request).getParameter("aula");
		doReturn("Tutorato1234").when(request).getParameter("titolo");
		doReturn(null).when(request).getParameter("descrizione");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		doReturn(session).when(request).getSession();
		doReturn(new Utente("veronica", "marcantuono", "veronica.marcantuono@unisa.it", "12345678", 2)).when(session).getAttribute("utente");
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Errore, campo Descrizione non compilato" , ac.getValue());
	}
	
	@Test
	void testCase_2_1_06() throws ServletException, IOException {
		doReturn("F2").when(request).getParameter("edificio");
		doReturn("F1").when(request).getParameter("aula");
		doReturn("Tutorato").when(request).getParameter("titolo");
		doReturn("descrizione motivo turor@to").when(request).getParameter("descrizione");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		doReturn(session).when(request).getSession();
		doReturn(new Utente("veronica", "marcantuono", "veronica.marcantuono@unisa.it", "12345678", 2)).when(session).getAttribute("utente");
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Errore, campo Data non compilato" , ac.getValue());
	}
	
	@Test
	void testCase_2_1_07() throws ServletException, IOException {
		doReturn("F2").when(request).getParameter("edificio");
		doReturn("F1").when(request).getParameter("aula");
		doReturn("Tutorato").when(request).getParameter("titolo");
		doReturn("descrizione tutorato").when(request).getParameter("descrizione");
		doReturn(null).when(request).getParameter("data");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		doReturn(session).when(request).getSession();
		doReturn(new Utente("veronica", "marcantuono", "veronica.marcantuono@unisa.it", "12345678", 2)).when(session).getAttribute("utente");
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Errore, campo Data non compilato" , ac.getValue());
	}
	
	@Test
	void testCase_2_1_08() throws ServletException, IOException {
		doReturn("F2").when(request).getParameter("edificio");
		doReturn("F1").when(request).getParameter("aula");
		doReturn("Tutorato").when(request).getParameter("titolo");
		doReturn("descrizione tutorato").when(request).getParameter("descrizione");
		doReturn("12/").when(request).getParameter("data");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		doReturn(session).when(request).getSession();
		doReturn(new Utente("veronica", "marcantuono", "veronica.marcantuono@unisa.it", "12345678", 2)).when(session).getAttribute("utente");
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Errore, campo Data non valido" , ac.getValue());
	}
	
	@Test
	void testCase_2_1_09() throws ServletException, IOException {
		doReturn("F2").when(request).getParameter("edificio");
		doReturn("F1").when(request).getParameter("aula");
		doReturn("Tutorato").when(request).getParameter("titolo");
		doReturn("descrizione tutorato").when(request).getParameter("descrizione");
		doReturn("12/12").when(request).getParameter("data");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		doReturn(session).when(request).getSession();
		doReturn(new Utente("veronica", "marcantuono", "veronica.marcantuono@unisa.it", "12345678", 2)).when(session).getAttribute("utente");
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Errore, campo Data non valido" , ac.getValue());
	}
	
	@Test
	void testCase_2_1_10() throws ServletException, IOException {
		doReturn("F2").when(request).getParameter("edificio");
		doReturn("F1").when(request).getParameter("aula");
		doReturn("Tutorato").when(request).getParameter("titolo");
		doReturn("descrizione tutorato").when(request).getParameter("descrizione");
		doReturn("2018-12-12").when(request).getParameter("data");
		doReturn(null).when(request).getParameter("oraInizio");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		doReturn(session).when(request).getSession();
		doReturn(new Utente("veronica", "marcantuono", "veronica.marcantuono@unisa.it", "12345678", 2)).when(session).getAttribute("utente");
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Errore, campo Ora inizio non compilato" , ac.getValue());
	}
	
	@Test
	void testCase_2_1_11() throws ServletException, IOException {
		doReturn("F2").when(request).getParameter("edificio");
		doReturn("F1").when(request).getParameter("aula");
		doReturn("Tutorato").when(request).getParameter("titolo");
		doReturn("descrizione tutorato").when(request).getParameter("descrizione");
		doReturn("2018-12-12").when(request).getParameter("data");
		doReturn("14.00").when(request).getParameter("oraInizio");
		doReturn(null).when(request).getParameter("oraFine");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		doReturn(session).when(request).getSession();
		doReturn(new Utente("veronica", "marcantuono", "veronica.marcantuono@unisa.it", "12345678", 2)).when(session).getAttribute("utente");
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Errore, campo Ora fine non compilato" , ac.getValue());
	}
	@Test
	void testCase_2_1_12() throws ServletException, IOException {
		doReturn("F2").when(request).getParameter("edificio");
		doReturn("F1").when(request).getParameter("aula");
		doReturn("Tutorato").when(request).getParameter("titolo");
		doReturn("descrizione tutorato").when(request).getParameter("descrizione");
		doReturn("2018-12-12").when(request).getParameter("data");
		doReturn("14").when(request).getParameter("oraInizio");
		doReturn("12").when(request).getParameter("oraFine");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		doReturn(session).when(request).getSession();
		doReturn(new Utente("veronica", "marcantuono", "veronica.marcantuono@unisa.it", "12345678", 2)).when(session).getAttribute("utente");
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Prenotazione fallita" , ac.getValue());
	}
	@Test
	void testCase_2_1_13() throws ServletException, IOException {
		doReturn("F2").when(request).getParameter("edificio");
		doReturn("F1").when(request).getParameter("aula");
		doReturn("Tutorato").when(request).getParameter("titolo");
		doReturn("descrizione tutorato").when(request).getParameter("descrizione");
		doReturn("2018-12-12").when(request).getParameter("data");
		doReturn("14").when(request).getParameter("oraInizio");
		doReturn("16").when(request).getParameter("oraFine");
		doReturn(requestDispatcher).when(request).getRequestDispatcher(any());
		doReturn(session).when(request).getSession();
		doReturn(new Utente("veronica", "marcantuono", "veronica.marcantuono@unisa.it", "12345678", 2)).when(session).getAttribute("utente");
		servlet.doPost(request, response);
		verify(request).setAttribute(any(), ac.capture());
		assertEquals("Prenotazione effettuata" , ac.getValue());
	}
}
