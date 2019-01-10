package it.chooseit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.chooseit.bean.PresidenteBean;
import it.chooseit.bean.SegreteriaBean;
import it.chooseit.bean.StudenteBean;
import it.chooseit.bean.TutorAziendaleBean;
import it.chooseit.bean.TutorUniversitarioBean;
import it.chooseit.bean.UtenteBean;
import it.chooseit.facade.GestioneAccountFacade;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public LoginServlet() {
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
      String url=response.encodeRedirectURL("/index.jsp");
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);

    }else {
      //...altrimenti le credenziali sono giuste

      // Controllo del ruolo
      String ruolo = gestore.checkRuolo(utente);

      // Se ruolo != null allora prendo le info sull'utente in base al ruolo...
      if(ruolo != null) {
        request.getSession().setAttribute("ruolo", ruolo);

        // Se l'utente &egrave; di tipo 'studente'
        if(ruolo.equals("studente")){
          StudenteBean studente = (StudenteBean) utente;
          request.getSession().setAttribute("utente", studente);
        }

        // Se l'utente &egrave; di tipo 'segreteria'
        if(ruolo.equals("segreteria")){
          SegreteriaBean segreteria = (SegreteriaBean) utente;
          request.getSession().setAttribute("utente", segreteria);
        }

        // Se l'utente &egrave; di tipo 'presidente'
        if(ruolo.equals("presidente")){
          PresidenteBean presidente = (PresidenteBean) utente;
          request.getSession().setAttribute("utente", presidente);
        }

        // Se l'utente &egrave; di tipo 'tutorUniversitario'
        if(ruolo.equals("tutorUniversitario")){
          TutorUniversitarioBean tutorUniversitario = (TutorUniversitarioBean) utente;
          request.getSession().setAttribute("utente", tutorUniversitario);
        }

        // Se l'utente &egrave; di tipo 'tutorAziendale'
        if(ruolo.equals("tutorAziendale")){
          TutorAziendaleBean tutorAziendale = (TutorAziendaleBean) utente;
          request.getSession().setAttribute("utente", tutorAziendale);
        }

        request.getSession().setAttribute("ruolo", ruolo);
        String url=response.encodeRedirectURL("/AreaPersonale.jsp");
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);

      }else {
        // ...altrimenti c'&egrave; un errore nel recupero del ruolo
        request.getSession().setAttribute("loginOK", false);
        String url=response.encodeRedirectURL("/index.jsp");
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
      }

    }

  }

}
