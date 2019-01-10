package it.chooseit.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import it.chooseit.bean.AziendaBean;
import it.chooseit.bean.RichiestaTirocinioBean;
import it.chooseit.bean.StudenteBean;
import it.chooseit.facade.GestioneModulisticaFacade;
import it.chooseit.facade.GestionePraticheTirocinioFacade;

/**
 * Servlet implementation class InviaRichiestatirocinioServlet
 */

@WebServlet("/InviaRichiestaTirocinioServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, maxFileSize = 1024 * 1024 * 1, maxRequestSize = 1024 * 1024 * 1)
public class InviaRichiestaTirocinioServlet extends HttpServlet{

  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public InviaRichiestaTirocinioServlet() {
    super();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    doPost(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    //1) RECUPERO STUDENTE DALLA SESSIONE
    StudenteBean studenteBean = (StudenteBean) request.getSession().getAttribute("utente");
    AziendaBean aziendaBean = (AziendaBean) request.getSession().getAttribute("azienda");

    Date dataRichiesta = new Date(System.currentTimeMillis());

    // 3) CREA IL BEAN RICHIESTA DI TIROCINIO
    RichiestaTirocinioBean richiestaBean = new RichiestaTirocinioBean();
    richiestaBean.setStudente(studenteBean);
    richiestaBean.setAzienda(aziendaBean);
    richiestaBean.setDataRichiesta(dataRichiesta);

    // 4)OTTENGO IL PATH DOVE SALVARE
    String filePath = GestioneModulisticaFacade.uploadRichiestaTirocinio(richiestaBean, getServletContext().getRealPath("//"));

    boolean progettoFormativoOK = false;

    // 5)SALVO NEL PATH OTTENUTO
    if (request.getPart("progettoFormativo") != null && request.getPart("progettoFormativo").getSize() > 0) {
      if (filePath != null && !filePath.equals("")) {
        Part part = request.getPart("progettoFormativo");
        part.write(filePath);
        progettoFormativoOK = true;
        System.out.println("Salvato in " + filePath);
      } else {
        // &egrave; andata male
        System.out.println("Errore nel salvataggio della richiesta di tirocinio");
      }
    }	

    // 6)AGGIORNO IL BEAN AGGIUNGENDO IL PERCORSO APPENA OTTENUTO (filePath) 
    // (solo se la richiesta di tirocinio &egrave; stata inserita, cio&egrave; se progettoFormativoOK == true)
    if (progettoFormativoOK) {
      richiestaBean.setProgettoFormativo(filePath);
    } else {
      richiestaBean.setProgettoFormativo("");
    }

    GestionePraticheTirocinioFacade gestore = new GestionePraticheTirocinioFacade();
    boolean inviaRichiestaOK = gestore.inviaRichiestaTirocinio(richiestaBean, studenteBean.getEmail());
    request.getSession().setAttribute("inviaRichiestaOK", inviaRichiestaOK);

    String url = response.encodeRedirectURL("/ListaRichiesteTirocinioServlet");
    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
    dispatcher.forward(request, response);

  }

}
