package it.chooseit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.chooseit.bean.UtenteBean;
import it.chooseit.facade.GestioneAccountFacade;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		GestioneAccountFacade gestore = new GestioneAccountFacade();
		UtenteBean utente = null;
		
		// Controllo se le credenziali inserite sono != null
		if(email != null && password != null) {
			//Recupero delle informazioni sull'utente dal database
			utente = gestore.login(email, password);
		}
		//Se utente == null allora le credenziali inserite sono errate
		if(utente == null) {
			request.getSession().setAttribute("loginOK", false);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}else {
			//...altrimenti le credenziali sono giuste
			
			// Controllo del ruolo
			String ruolo = gestore.checkRuolo(utente);
			request.getSession().setAttribute("ruolo", ruolo);
			/*
			// Se l'utente è di tipo 'studente'
			if(ruolo.equals("studente")){
			
			}
			
			// Se l'utente è di tipo 'segreteria'
			if(ruolo.equals("segreteria")){
			
			}
			
			// Se l'utente è di tipo 'presidente'
			if(ruolo.equals("presidente")){
			
			}
			
			// Se l'utente è di tipo 'tutorUniversitario'
			if(ruolo.equals("tutorUniversitario")){
			
			}
			
			// Se l'utente è di tipo 'tutorAziendale'
			if(ruolo.equals("tutorAziendale")){
			
			}
			*/
			RequestDispatcher dispatcher = request.getRequestDispatcher("AreaPersonale.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
