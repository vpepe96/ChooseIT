package it.chooseit.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.chooseit.bean.AziendaBean;
import it.chooseit.dao.AziendaDAO;
import it.chooseit.facade.GestionePraticheTirocinioFacade;
import it.chooseit.impl.Azienda;

/**
 * Servlet implementation class ListaAziendeServlet
 */
@WebServlet("/ListaAziendeServlet")
public class ListaAziendeServlet extends HttpServlet{

  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public ListaAziendeServlet() {
    super();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    AziendaDAO aziendaDao = new Azienda();
    Collection<AziendaBean> listaAziende = null;

    try {
      listaAziende = aziendaDao.retrieveAll("ragione_sociale");
    } catch (SQLException e) {
      e.printStackTrace();
    }

    GestionePraticheTirocinioFacade gestore = new GestionePraticheTirocinioFacade();
    listaAziende = gestore.listaAziende();
    request.getSession().setAttribute("listaAziende", listaAziende);

    String url = response.encodeRedirectURL("ListaAziende.jsp");
    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
    dispatcher.forward(request, response);
  }

}
