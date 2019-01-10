package it.chooseit.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import it.chooseit.bean.RichiestaTirocinioBean;
import it.chooseit.bean.TutorAziendaleBean;
import it.chooseit.bean.TutorUniversitarioBean;
import it.chooseit.dao.TutorAziendaleDAO;
import it.chooseit.dao.TutorUniversitarioDAO;
import it.chooseit.facade.GestioneModulisticaFacade;
import it.chooseit.facade.GestionePraticheTirocinioFacade;
import it.chooseit.impl.TutorAziendale;
import it.chooseit.impl.TutorUniversitario;

/**
 * Servlet implementation class ValutazioneInizialeRichiestaTirocinioServlet
 */
@WebServlet("/ValutazioneInizialeRichiestaTirocinioServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, maxFileSize = 1024 * 1024 * 1, maxRequestSize = 1024 * 1024 * 1)
public class ValutazioneInizialeRichiestaTirocinioServlet extends HttpServlet{

  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public ValutazioneInizialeRichiestaTirocinioServlet() {
    super();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    RichiestaTirocinioBean richiestaBean = (RichiestaTirocinioBean) request.getSession().getAttribute("richiesta");
    String emailTutorUniversitario = (String) request.getParameter("email_tutor_universitario");
    String emailTutorAziendale = (String) request.getParameter("email_tutor_aziendale");
    String scelta = (String) request.getParameter("scelta");

    System.out.println("TUTOR AZIENDALE"+emailTutorAziendale);
    System.out.println("TUTOR UNIVERSITARIO"+emailTutorUniversitario);
    System.out.println("SCELTA"+scelta);

    //1) SETTO IL BEAN PER IL TUTOR AZIENDALE
    TutorAziendaleDAO tutorAziendaleDao = new TutorAziendale();
    TutorAziendaleBean tutorAziendale = null;
    try {
      tutorAziendale = tutorAziendaleDao.retrieveByKey(emailTutorAziendale);
    } catch (SQLException e1) {
      e1.printStackTrace();
    }

    //2) SETTO IL BEAN PER IL TUTOR UNIVERSITARIO
    TutorUniversitarioDAO tutorUniversitarioDao = new TutorUniversitario();
    TutorUniversitarioBean tutorUniversitario = null;
    try {
      tutorUniversitario = tutorUniversitarioDao.retrieveByKey(emailTutorUniversitario);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    // 1)OTTENGO IL PATH DOVE SALVARE
    String filePath = GestioneModulisticaFacade.uploadRichiestaTirocinio(richiestaBean, getServletContext().getRealPath("//"));

    boolean progettoFormativoOK = false;

    // 2)SALVO NEL PATH OTTENUTO
    if (request.getPart("progettoFormativo") != null && request.getPart("progettoFormativo").getSize() > 0) {
      if (filePath != null && !filePath.equals("")) {
        Part part = request.getPart("progettoFormativo");
        part.write(filePath);
        progettoFormativoOK = true;
        System.out.println("Salvato in " + filePath);
        richiestaBean.setProgettoFormativo(filePath); //lo aggiorna solo se il file &egrave; presente altrimenti resta quello ottenuto con retrievebykey
      } else {
        // &egrave; andata male
        System.out.println("Errore nel salvataggio del progetto formativo");
      }
    }	


    GestionePraticheTirocinioFacade gestore = new GestionePraticheTirocinioFacade();
    boolean valutazioneInizialeRichiestaOK = gestore.valutazioneInizialeRichiestaTirocinio(richiestaBean, tutorAziendale, tutorUniversitario, scelta);
    request.getSession().setAttribute("valutazioneInizialeRichiestaOK", valutazioneInizialeRichiestaOK);

    String url = response.encodeRedirectURL("/ListaRichiesteTirocinio.jsp");
    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
    dispatcher.forward(request, response);
  }

}
