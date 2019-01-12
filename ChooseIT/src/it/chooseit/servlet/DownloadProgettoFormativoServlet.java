package it.chooseit.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadProgettoFormativoServlet
 */
@WebServlet("/DownloadProgettoFormativoServlet")
public class DownloadProgettoFormativoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public DownloadProgettoFormativoServlet() {
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
    String percorso = request.getParameter("progetto_formativo");
    System.out.println(percorso);
    File f=new File(percorso);

    if(f.exists()) {
      response.setContentType("application/pdf");
      response.setContentLength((int) f.length());

      String headerKey = "Content-Disposition";
      String headerValue = String.format("attachment; filename=\"%s\"", f.getName());
      response.setHeader(headerKey, headerValue);


      OutputStream outStream = response.getOutputStream();

      byte[] buffer = new byte[4096];
      int bytesRead = -1;

      FileInputStream inStream= new FileInputStream(f);
      while ((bytesRead = inStream.read(buffer)) != -1) {
        outStream.write(buffer, 0, bytesRead);
      }

      inStream.close();
      outStream.close();   
      request.getSession().setAttribute("progettoFormativoBoolean", true);
    }else{
      request.getSession().setAttribute("progettoFormativoBoolean", false);
      String url=response.encodeURL("/DettaglioAzienda.jsp");
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);
    }

  }

}
