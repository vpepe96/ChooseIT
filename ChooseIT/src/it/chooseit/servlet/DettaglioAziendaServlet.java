package it.chooseit.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.chooseit.bean.AziendaBean;
import it.chooseit.dao.AziendaDAO;
import it.chooseit.impl.Azienda;

/**
 * Servlet implementation class DettaglioAziendaServlet
 */
@WebServlet("/DettaglioAziendaServlet")
public class DettaglioAziendaServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public DettaglioAziendaServlet() {
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
    AziendaDAO aziendaDao = new Azienda();
    AziendaBean azienda = null;
    String aziendaID = (String) request.getParameter("id_azienda");

    try {
      azienda = aziendaDao.retrieveByKey(aziendaID);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    request.getSession().setAttribute("azienda", azienda);

    String url = response.encodeRedirectURL("DettaglioAzienda.jsp");
    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
    dispatcher.forward(request, response);
  }

}
