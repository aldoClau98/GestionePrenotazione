package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Utente;

/**
 * Servlet implementation class RichiestaPrenotazione
 */
@WebServlet("/DomandaPrenotazione")
public class DomandaPrenotazione extends ServletBasic {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String edificio = request.getParameter("edificio");
		if(edificio == null)
			request.setAttribute("messaggio", "Prenotazione fallita");
		else {
			
			
			String aula = request.getParameter("aula");
			if(aula == null)
				request.setAttribute("messaggio", "Prenotazione fallita");
			else {
				
				
				if(struttDAO.doStrutturabyName(aula, edificio) == null)
					request.setAttribute("messaggio", "Prenotazione fallita");
				else {
					
					
					HttpSession session = request.getSession();
					Utente utente = (Utente) session.getAttribute("utente");
					if(utente == null)
						request.setAttribute("messaggio", "Prenotazione fallita");
					else {
						
						
						String titolo = request.getParameter("titolo");
						if(titolo == null)
							request.setAttribute("messaggio", "Errore, campo Titolo non compilato");
						else {
							if(!titolo.matches("^[\\w\\W\\s]{5,32}$"))
								request.setAttribute("messaggio", "Errore, campo Titolo non valido");
							else {
								
								
								String descrizione = request.getParameter("descrizione");
								if(descrizione == null)
									request.setAttribute("messaggio", "Errore, campo Descrizione non compilato");
								else {
									if(!descrizione.matches("^[\\w\\W\\s]{8,250}$"))
										request.setAttribute("messaggio", "Errore, campo Descrizione non valido");
									else {
										
										
										String data = request.getParameter("data");
										if(data == null)
											request.setAttribute("messaggio", "Errore, campo Data non compilato");
										else {
											if(!data.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}$"))
												request.setAttribute("messaggio", "Errore, campo Data non valido");
											else {
												
												
												String oraInizio = request.getParameter("oraInizio");
												if(oraInizio == null)
													request.setAttribute("messaggio", "Errore, campo Ora inizio non compilato");
												else {
													
													
													String oraFine = request.getParameter("oraFine");
													if(oraFine == null)
														request.setAttribute("messaggio", "Errore, campo Ora fine non compilato");
													else {
														
														
														if(Integer.parseInt(oraFine) < Integer.parseInt(oraInizio))
															request.setAttribute("messaggio", "Prenotazione fallita");
														else {
															
															
															// se l' utente � amministratore...
															// ...se il dipartimento corrisponde al dipartimento dell amministratore, allora
															// la prenotazione viene salvata direttamente nel database
															String dipAmm = dipDAO.doRetrieveByKey(utente.getEmail());
															Model.Dipartimento aulaDip = dipDAO.doDipartimentoByStruttura(aula, edificio);
															
															if(prenDAO.controlloOra(data, Integer.parseInt(oraInizio), Integer.parseInt(oraFine), aula, edificio) == 1) {
																
																if (((utente.getTipoUtente()) == 2) && (dipAmm.equals(aulaDip.getDip()))) {
																	if (prenDAO.doSave(titolo, data, Integer.parseInt(oraInizio), Integer.parseInt(oraFine),
																			descrizione, utente.getEmail(), aula, edificio, 1) != 0)
																		request.setAttribute("messaggio", "Prenotazione effettuata");
																	else 
																		request.setAttribute("messaggio", "Prenotazione fallita");
																} 
																
																
																else {

																	if (prenDAO.doSave(titolo, data, Integer.parseInt(oraInizio), Integer.parseInt(oraFine),
																			descrizione, utente.getEmail(), aula, edificio, 0) != 0)
																		request.setAttribute("messaggio", "Richiesta effettuata");
																	else 
																		request.setAttribute("messaggio", "Richiesta fallita");
																}
															}
															else 
																request.setAttribute("messaggio", "Orario già prenotato");
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			RequestDispatcher view = request.getRequestDispatcher("NavAula?aula=" + aula);
			view.forward(request, response);
		}
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/Homepage.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
