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
 * Servlet implementation class ModificaProfiloServlet
 */
@WebServlet("/ConvalidaRichiestaTirocinioServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, maxFileSize = 1024 * 1024 * 1, maxRequestSize = 1024 * 1024 * 1)
public class ConvalidaRichiestaTirocinioServlet extends HttpServlet{

  private static final long serialVersionUID = 1L;

  /**
   * Servlet implementation class ModificaProfiloServlet
   */
  public ConvalidaRichiestaTirocinioServlet() {
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
    RichiestaTirocinioBean richiestaTirocinio = (RichiestaTirocinioBean) request.getSession().getAttribute("richiesta");

    // 1)OTTENGO IL PATH DOVE SALVARE
    String filePath = GestioneModulisticaFacade.uploadRichiestaTirocinio(richiestaTirocinio, getServletContext().getRealPath("//"));

    boolean progettoFormativoOK = false;

    // 2)SALVO NEL PATH OTTENUTO
    if (request.getPart("progettoFormativo") != null && request.getPart("progettoFormativo").getSize() > 0) {
      if (filePath != null && !filePath.equals("")) {
        Part part = request.getPart("progettoFormativo");
        part.write(filePath);
        progettoFormativoOK = true;
        System.out.println("Salvato in " + filePath);
        richiestaTirocinio.setProgettoFormativo(filePath); //lo aggiorna solo se il file &egrave; presente altrimenti resta quello ottenuto con retrievebykey
      } else {
        // &egrave; andata male
        System.out.println("Errore nel salvataggio del progetto formativo");
      }
    }	


    GestionePraticheTirocinioFacade gestore = new GestionePraticheTirocinioFacade();
    boolean convalidaRichiestaOK = gestore.convalidaRichiestaTirocinio(richiestaTirocinio, scelta);
    request.getSession().setAttribute("convalidaRichiestaOK", convalidaRichiestaOK);


    String url = response.encodeRedirectURL("/ListaRichiesteTirocinio.jsp");
    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
    dispatcher.forward(request, response);
  }

}
