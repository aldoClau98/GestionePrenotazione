package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Registrazione")
public class Registrazione extends ServletBasic {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		if (nome == null)
			request.setAttribute("messaggio", "Errore, campo Nome non compilato");
		else {
			if (nome.length() < 2  ||  nome.length() > 25  ||  !nome.matches("^[a-zA-Z]+$"))
				request.setAttribute("messaggio", "Errore, campo Nome compilato male");
			else {
				
				
				String cognome = request.getParameter("cognome");
				if (cognome == null)
					request.setAttribute("messaggio", "Errore, campo Cognome non compilato");
				else {
					if (cognome.length() < 2  ||  cognome.length() > 25  ||  !cognome.matches("^[a-zA-Z]+$"))
						request.setAttribute("messaggio", "Errore, campo Cognome compilato male");
					else {
						
						
						
						String email = request.getParameter("email");
						if (email == null)
							request.setAttribute("messaggio", "Errore, campo Email non compilato");
						else {
							if (email.length() < 1  ||  email.length() > 254  ||  !(email.matches("^(\\w+([\\.-])?\\w+)+@?(studenti\\.unisa\\.it)$")  ||  email.matches("^(\\w+([\\.-])?\\w+)+@?(unisa\\.it)$")))
								request.setAttribute("messaggio", "Errore, campo Email compilato male");
							else {
								
								
								
								String password = request.getParameter("password");
								if (password == null)
									request.setAttribute("messaggio", "Errore, campo Password non compilato");
								else {
									if (!password.matches("^\\w+([\\.-])?\\w+$"))
										request.setAttribute("messaggio", "Errore, campo Password compilato male");
									else {
										
										
										
										String[] type = email.split("@");
										if(type != null) {
											
											
											if (userDAO.doRetrieveByEmail(email) == null) {
												
												
												if (type[1].equals("studenti.unisa.it")) {
													try {
														if (userDAO.doSave(email, password, nome, cognome, 0) != 0)
															request.setAttribute("messaggio", "Registrazione avvenuta");
														else 
															request.setAttribute("messaggio", "Registrazione fallita");
													} catch (Exception e) {
														request.setAttribute("messaggio", "Registrazione fallita");
													}
												}
												
												
												
												else if (type[1].equals("unisa.it")) {
													try {
														if (userDAO.doSave(email, password, nome, cognome, 1) != 0)
															request.setAttribute("messaggio", "Registrazione avvenuta");
														else 
															request.setAttribute("messaggio", "Registrazione fallita");
													} catch (Exception e) {
														request.setAttribute("messaggio", "Registrazione fallita");
													}	
												}
											}
											else
												request.setAttribute("messaggio", "Utente già esistente");
										}
										else
											request.setAttribute("messaggio", "Registrazione fallita");
									}
								}
							}
						}	
					}
				}
			}
		}

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/Login.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
