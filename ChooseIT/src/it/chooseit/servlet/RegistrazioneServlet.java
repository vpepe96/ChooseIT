package it.chooseit.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import it.chooseit.facade.GestioneModulisticaFacade;
import it.chooseit.bean.StudenteBean;
import it.chooseit.facade.GestioneAccountFacade;

/**
 * Servlet implementation class ServletRegistrazione
 */
@WebServlet("/RegistrazioneServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, maxFileSize = 1024 * 1024 * 1, maxRequestSize = 1024 * 1024 * 1)
public class RegistrazioneServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public RegistrazioneServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String nome = request.getParameter("nome");
    String cognome = request.getParameter("cognome");
    String telefono = request.getParameter("telefono");
    String indirizzo = request.getParameter("indirizzo");
    String dataNascita = request.getParameter("dataNascita");
    String matricola = request.getParameter("matricola");
    String descrizione = request.getParameter("descrizione");

    // Parse da String a sql.Date
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    java.sql.Date sqlDate = null;
    try {
      java.util.Date utilDate = format.parse(dataNascita);
      sqlDate = new java.sql.Date(utilDate.getTime());
    } catch (ParseException e) {
      e.printStackTrace();
    }

    // 1) CREA IL BEAN
    StudenteBean bean = new StudenteBean();
    bean.setDataNascita(sqlDate);
    bean.setEmail(email);
    bean.setNome(nome);
    bean.setCognome(cognome);
    bean.setTelefono(telefono);
    bean.setMatricola(matricola);
    bean.setIndirizzo(indirizzo);
    if (descrizione == null) {
      bean.setDescrizione("");
    } else {
      bean.setDescrizione(descrizione);
    }

    // 2)OTTENGO IL PATH DOVE SALVARE
    String filePath = GestioneModulisticaFacade.uploadImmagine(bean, getServletContext().getRealPath("//"));

    boolean fotoOK = false;
    boolean formatoOK = false;
    // 3)SALVO NEL PATH OTTENUTO
    if (request.getPart("fotoProfilo") != null && request.getPart("fotoProfilo").getSize() > 0) {

      if (filePath != null && !filePath.equals("")) {

        Part part = request.getPart("fotoProfilo");
        if(part.getContentType().equals("image/jpeg")) {

          formatoOK = true;
          part.write(filePath);
          fotoOK = true;
          System.out.println("Salvato in " + filePath);
        }else {

          System.out.println("Errore formato");
        }

      } else {

        System.out.println("Errore nel salvataggio foto profilo");
      }

    }else {
      formatoOK = true;
    }

    // 4)AGGIORNO IL BEAN AGGIUNGENDO IL PERCORSO APPENA OTTENUTO (filePath) 
    // (solo se la foto &egrave; stata inserit&agrave;, cio&egrave; se fotoOK == true)
    if (fotoOK) {
      bean.setFotoProfilo(filePath);
    } else {
      bean.setFotoProfilo("");
    }

    if(formatoOK) {
      GestioneAccountFacade gestore = new GestioneAccountFacade();
      boolean registrazioneOK = gestore.registrazione(bean, password);
      request.getSession().setAttribute("registrazioneOK", registrazioneOK);
    }else {

      request.getSession().setAttribute("formatoOK", false);
    }


    String url = response.encodeRedirectURL("/Registrazione.jsp");
    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
    dispatcher.forward(request, response);
  }

}
