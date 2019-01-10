package it.chooseit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.ReportBean;
import it.chooseit.bean.TutorAziendaleBean;
import it.chooseit.bean.UtenteBean;
import it.chooseit.facade.GestioneReportFacade;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class ServletInserimentoReport
 */

@WebServlet("/InserimentoReportServlet")
public class InserimentoReportServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor. 
   */

  public InserimentoReportServlet() {
    super();
  }


  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    long data = Calendar.getInstance().getTimeInMillis();

    // Parse a sql.Date
    java.sql.Date sqlDate = null;
    sqlDate = new java.sql.Date(data);



    String contenuto=request.getParameter("contenuto");


    UtenteBean utente = (UtenteBean) request.getSession().getAttribute("utente");
    String ruolo = (String) request.getSession().getAttribute("ruolo");

    if(ruolo.equals("tutorAziendale")) {
      TutorAziendaleBean tutor = (TutorAziendaleBean) utente;

      /* Registro preso dalla sessione */

      RegistroTirocinioBean reg =(RegistroTirocinioBean) request.getSession().getAttribute("registroTirocinio");

      /*id del registro*/
      int id = reg.getIdentificativo();



      ReportBean report=new ReportBean();

      if(id != 0) {
        report.setPath(contenuto);
        report.setDataInserimento(sqlDate);
        report.setTutorAziendale(tutor);
      }


      GestioneReportFacade reportN = new GestioneReportFacade();

      reportN.inserimentoReport(report);

      String url=response.encodeURL("/RegistroTirocinio.jsp");
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);
    }else {

      String url=response.encodeURL("/AreaPersonale.jsp");
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);
    }
  }

}

