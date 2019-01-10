package it.chooseit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import it.chooseit.bean.RichiestaTirocinioBean;
import it.chooseit.facade.GestioneModulisticaFacade;
import it.chooseit.facade.GestionePraticheTirocinioFacade;

/**
 * Servlet implementation class ValutazioneFinaleRichiestaTirocinioServlet
 */
@WebServlet("/ValutazioneFinaleRichiestaTirocinioServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, maxFileSize = 1024 * 1024 * 1, maxRequestSize = 1024 * 1024 * 1)
public class ValutazioneFinaleRichiestaTirocinioServlet extends HttpServlet{

  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public ValutazioneFinaleRichiestaTirocinioServlet() {
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
    String scelta = (String) request.getParameter("scelta");
    RichiestaTirocinioBean richiestaBean = (RichiestaTirocinioBean) request.getSession().getAttribute("richiesta");

    System.out.println("Studente:"+richiestaBean.getStudente().getEmail());

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
    boolean valutazioneFinaleRichiestaOK = gestore.valutazioneFinaleRichiestaTirocinio(richiestaBean, scelta);
    request.getSession().setAttribute("valutazioneFinaleRichiestaOK", valutazioneFinaleRichiestaOK);

    String url = response.encodeRedirectURL("/ListaRichiesteTirocinio.jsp");
    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
    dispatcher.forward(request, response);
  }

}
