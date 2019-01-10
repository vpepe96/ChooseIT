package it.chooseit.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.ReportBean;
import it.chooseit.bean.TutorAziendaleBean;
import it.chooseit.facade.GestioneModulisticaFacade;
import it.chooseit.facade.GestioneReportFacade;

/**
 * Servlet implementation class ValutaReport
 */
@WebServlet("/ValutaReportServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, maxFileSize = 1024 * 1024 * 1, maxRequestSize = 1024 * 1024 * 1)
public class ValutaReportServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor.
   */
  public ValutaReportServlet() {
    // TODO Auto-generated constructor stub
  }

  /**
   * @return
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String ruolo = (String) request.getSession().getAttribute("ruolo");
    String action = request.getParameter("action");

    /* Registro tirocinio preso dalla Session */
    RegistroTirocinioBean registroTirocinio = (RegistroTirocinioBean) request.getSession()
        .getAttribute("registroTirocinio");

    /* parametri che interessano il report */
    String dataInserimento = request.getParameter("dataInserimento");
    String path = request.getParameter("path");


    /* id del registro */
    int id = registroTirocinio.getIdentificativo();

    /* bean report */

    ReportBean report = new ReportBean();

    if (id != 0) {
      report.setRegistroTirocinio(registroTirocinio);
      report.setPath(path);
    }

    /* download report */

    if (action.trim().equals("download")) {

      // Parse da String a sql.Date
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
      java.sql.Date sqlDate = null;
      try {
        java.util.Date utilDate = format.parse(dataInserimento);
        sqlDate = new java.sql.Date(utilDate.getTime());
      } catch (ParseException e) {
        e.printStackTrace();
      }
      report.setDataInserimento(sqlDate);

      // 2) RICHIAMO IL METODO PER OTTENERE IL FILE
      File f = GestioneModulisticaFacade.downloadReport(report, getServletContext().getRealPath("//"));

      // 3) COSE PER IL DOWNLOAD DEL FILE
      response.setContentType("application/pdf");
      response.setContentLength((int) f.length());

      String headerKey = "Content-Disposition";
      String headerValue = String.format("attachment; filename=\"%s\"", f.getName());
      response.setHeader(headerKey, headerValue);

      OutputStream outStream = response.getOutputStream();

      byte[] buffer = new byte[4096];
      int bytesRead = -1;

      FileInputStream inStream = new FileInputStream(f);
      while ((bytesRead = inStream.read(buffer)) != -1) {
        outStream.write(buffer, 0, bytesRead);
      }

      inStream.close();
      outStream.close();

    } else if (ruolo.equals("tutorAziendale")) {
      TutorAziendaleBean tutorAziendale = (TutorAziendaleBean) request.getSession().getAttribute("utente");

      if (action.trim().equals("valuta")) {

        // Parse da String a sql.Date
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sqlDate = null;
        try {
          java.util.Date utilDate = format.parse(dataInserimento);
          sqlDate = new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
          e.printStackTrace();
        }
        report.setDataInserimento(sqlDate);

        // 2)OTTENGO IL PATH DOVE SALVARE
        String filePath = GestioneModulisticaFacade.uploadReport(report, getServletContext().getRealPath("\\"));

        // 3)SALVO NEL PATH OTTENUTO
        if (request.getPart("fileReport") != null && request.getPart("fileReport").getSize() > 0) {

          if (filePath != null && !filePath.equals("")) {
            Part part = request.getPart("fileReport");
            part.write(filePath);
            System.out.println("Salvato in " + filePath);

            // 4)AGGIORNO IL BEAN AGGIUNGENDO IL PERCORSO APPENA OTTENUTO (filePath) E
            // FACCIO UPDATE NEL DB

            report.setPath(filePath);
            GestioneReportFacade assegnoTutor = new GestioneReportFacade();
            assegnoTutor.inserimentoFirma(report, tutorAziendale);

          } else {
            // Ë andata male
            System.out.println("Errore nel salvataggio del file");
          }

        }else {
          System.out.println("File non trovato.");
        }

      }
    }else if(ruolo.equals("studente")) {
      if(action.equals("upload")) {

        report.setDataInserimento(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
        // 2)OTTENGO IL PATH DOVE SALVARE
        String filePath = GestioneModulisticaFacade.uploadReport(report, getServletContext().getRealPath("\\"));

        // 3)SALVO NEL PATH OTTENUTO
        if (request.getPart("fileReport") != null && request.getPart("fileReport").getSize() > 0) {

          if (filePath != null && !filePath.equals("")) {
            Part part = request.getPart("fileReport");
            part.write(filePath);
            System.out.println("Salvato in " + filePath);

            // 4)AGGIORNO IL BEAN AGGIUNGENDO IL PERCORSO APPENA OTTENUTO (filePath) E
            // FACCIO UPDATE NEL DB

            report.setPath(filePath);
            GestioneReportFacade gestore = new GestioneReportFacade();
            gestore.inserimentoReport(report);

          } else {
            // Ë andata male
            System.out.println("Errore nel salvataggio del file");
          }

        }else {
          System.out.println("File non trovato.");
        }


      }
    }
    String url = response.encodeRedirectURL("/AreaPersonale.jsp");
    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
    dispatcher.forward(request, response);
  }
}
