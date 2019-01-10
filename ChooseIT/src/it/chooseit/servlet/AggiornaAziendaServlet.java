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

import it.chooseit.bean.AziendaBean;
import it.chooseit.dao.AziendaDAO;
import it.chooseit.facade.GestioneModulisticaFacade;
import it.chooseit.facade.GestionePraticheTirocinioFacade;
import it.chooseit.impl.Azienda;

/**
 * Servlet implementation class AggiornaAziendaServlet
 */

@WebServlet("/AggiornaAziendaServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, maxFileSize = 1024 * 1024 * 1, maxRequestSize = 1024 * 1024 * 1)
public class AggiornaAziendaServlet extends HttpServlet{

  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public AggiornaAziendaServlet() {
    super();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    doPost(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    String ragioneSociale = request.getParameter("ragioneSociale");
    AziendaDAO aziendaDao = new Azienda();
    String sedeOperativa = request.getParameter("sedeOperativa");
    String sedeLegale = request.getParameter("sedeLegale");

    // 1)CREA IL BEAN AZIENDA
    AziendaBean aziendaBean = null;
    try {
      aziendaBean = aziendaDao.retrieveByKey(ragioneSociale);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    aziendaBean.setSedeOperativa(sedeOperativa);
    aziendaBean.setSedeLegale(sedeLegale);

    // 1)OTTENGO IL PATH DOVE SALVARE
    String filePath = GestioneModulisticaFacade.uploadProgettoFormativo(aziendaBean, getServletContext().getRealPath("//"));

    boolean progettoFormativoOK = false;

    // 2)SALVO NEL PATH OTTENUTO
    if (request.getPart("progettoFormativo") != null && request.getPart("progettoFormativo").getSize() > 0) {
      if (filePath != null && !filePath.equals("")) {
        Part part = request.getPart("progettoFormativo");
        part.write(filePath);
        progettoFormativoOK = true;
        System.out.println("Salvato in " + filePath);
        aziendaBean.setProgettoFormativo(filePath); //lo aggiorna solo se il file &egrave; presente altrimenti resta quello ottenuto con retrievebykey
      } else {
        // &egrave; andata male
        System.out.println("Errore nel salvataggio del progetto formativo");
      }
    }	


    GestionePraticheTirocinioFacade gestore = new GestionePraticheTirocinioFacade();
    boolean aggiornaAziendaOK = gestore.aggiornaAzienda(aziendaBean);
    request.getSession().setAttribute("aggiornaAziendaOK", aggiornaAziendaOK);
    request.getSession().setAttribute("azienda", aziendaBean);

    String url = response.encodeRedirectURL("/DettaglioAzienda.jsp");
    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
    dispatcher.forward(request, response);
  }

}
