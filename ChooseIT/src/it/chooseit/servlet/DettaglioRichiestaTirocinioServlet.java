package it.chooseit.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.chooseit.bean.RichiestaTirocinioBean;
import it.chooseit.dao.RichiestaTirocinioDAO;
import it.chooseit.impl.RichiestaTirocinio;

/**
 * Servlet implementation class DettaglioRichiestaTirocinioServlet
 */

@WebServlet("/DettaglioRichiestaTirocinioServlet")
public class DettaglioRichiestaTirocinioServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public DettaglioRichiestaTirocinioServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    RichiestaTirocinioDAO richiestaTirocinioDao = new RichiestaTirocinio();
    RichiestaTirocinioBean richiesta = null;
    int richiestaId = Integer.parseInt((String) request.getParameter("id_richiesta"));

    try {
      richiesta = richiestaTirocinioDao.retrieveByKey(richiestaId);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    request.getSession().setAttribute("richiesta", richiesta);

    String url = response.encodeRedirectURL("DettaglioRichiestaTirocinio.jsp");
    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
    dispatcher.forward(request, response);
  }

}
