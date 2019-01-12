package it.chooseit.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

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
 * Servlet implementation class InserisciAziendaServlet
 */
@WebServlet("/InserisciAziendaServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, maxFileSize = 1024 * 1024 * 1, maxRequestSize = 1024 * 1024 * 1)
public class InserisciAziendaServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public InserisciAziendaServlet() {
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
    String sedeOperativa = request.getParameter("sedeOperativa");
    String sedeLegale = request.getParameter("sedeLegale");

    // 1)CREA IL BEAN AZIENDA
    AziendaBean aziendaBean = new AziendaBean();
    aziendaBean.setRagioneSociale(ragioneSociale);
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
      } else {
        // &egrave; andata male
        System.out.println("Errore nel salvataggio del progetto formativo");
      }
    }	

    // 6)AGGIORNO IL BEAN AGGIUNGENDO IL PERCORSO APPENA OTTENUTO (filePath) 
    // (solo se la richiesta di tirocinio &egrave; stata inserita, cio&egrave; se progettoFormativoOK == true)
    if (progettoFormativoOK) {
      aziendaBean.setProgettoFormativo(filePath);
    } else {
      aziendaBean.setProgettoFormativo("");
    }

    GestionePraticheTirocinioFacade gestore = new GestionePraticheTirocinioFacade();
    boolean iserisciAziendaOK = gestore.inserisciAzienda(aziendaBean);
    request.getSession().setAttribute("iserisciAziendaOK", iserisciAziendaOK);
    
    AziendaDAO aziendaDao = new Azienda();
    Collection<AziendaBean> aziende = null;
	try {
		aziende = aziendaDao.retrieveAll(null);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    request.getSession().setAttribute("listaAziende", aziende);

    String url = response.encodeRedirectURL("ListaAziende.jsp");
    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
    dispatcher.forward(request, response);
  }

}
