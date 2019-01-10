package it.chooseit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import it.chooseit.bean.StudenteBean;
import it.chooseit.bean.UtenteBean;
import it.chooseit.facade.GestioneAreaPersonaleFacade;
import it.chooseit.facade.GestioneModulisticaFacade;

/**
 * Servlet implementation class ModificaProfiloServlet
 */
@WebServlet("/ModificaProfiloServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, maxFileSize = 1024 * 1024 * 1, maxRequestSize = 1024 * 1024 * 1)
public class ModificaProfiloServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public ModificaProfiloServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doPost(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session=request.getSession(false);
    String telefono = request.getParameter("telefono");
    String indirizzo = request.getParameter("indirizzo");
    String descrizione= request.getParameter("descrizione");
    String ruolo= (String) session.getAttribute("ruolo");





    if(ruolo.equals("studente")) {
      StudenteBean stud = (StudenteBean) session.getAttribute("utente");
      stud.setTelefono(telefono);
      stud.setIndirizzo(indirizzo);
      if(descrizione!=null && descrizione!="") {
        stud.setDescrizione(descrizione);
      }


      String filePath = GestioneModulisticaFacade.uploadImmagine(stud, getServletContext().getRealPath("//"));

      if (request.getPart("fotoProfilo") != null && request.getPart("fotoProfilo").getSize() > 0) { //viene fatto solo se &egrave; presente il file
        if (filePath != null && !filePath.equals("")) {
          Part part = request.getPart("fotoProfilo");
          part.write(filePath);
          System.out.println("Salvato in " + filePath);
          stud.setFotoProfilo(filePath);
        } else {
          System.out.println("Errore nel salvataggio foto profilo");
        }


      }
      GestioneAreaPersonaleFacade.modificaProfilo(stud);
      request.getSession().setAttribute("utente", stud);



    }else {
      UtenteBean utente =(UtenteBean) session.getAttribute("utente");
      utente.setTelefono(telefono);
      utente.setIndirizzo(indirizzo);

      String filePath = GestioneModulisticaFacade.uploadImmagine(utente, getServletContext().getRealPath("//"));

      if (request.getPart("fotoProfilo") != null && request.getPart("fotoProfilo").getSize() > 0) { //viene fatto solo se &egrave; presente il file
        if (filePath != null && !filePath.equals("")) {
          Part part = request.getPart("fotoProfilo");
          part.write(filePath);
          System.out.println("Salvato in " + filePath);
          utente.setFotoProfilo(filePath);
        } else {

          System.out.println("Errore nel salvataggio foto profilo");
        }


      }
      GestioneAreaPersonaleFacade.modificaProfilo(utente);
      request.getSession().setAttribute("utente", utente);

    }


    String url = response.encodeURL("/Profilo.jsp");
    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
    dispatcher.forward(request, response);
  }

}

