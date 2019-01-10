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

import it.chooseit.bean.RichiestaTirocinioBean;
import it.chooseit.bean.UtenteBean;
import it.chooseit.dao.RichiestaTirocinioDAO;
import it.chooseit.facade.GestionePraticheTirocinioFacade;
import it.chooseit.impl.RichiestaTirocinio;

/**
 * Servlet implementation class ListaRichiesteTirocinioServlet
 */
@WebServlet("/ListaRichiesteTirocinioServlet")
public class ListaRichiesteTirocinioServlet extends HttpServlet{

  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public ListaRichiesteTirocinioServlet() {
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
    String ruolo = (String) request.getSession().getAttribute("ruolo");
    UtenteBean utente = (UtenteBean) request.getSession().getAttribute("utente");
    RichiestaTirocinioDAO richiestaTirocinioDao = new RichiestaTirocinio();
    Collection<RichiestaTirocinioBean> listaRichiesteTirocinio = null;


    try {
      listaRichiesteTirocinio = richiestaTirocinioDao.retrieveAll("id");
    } catch (SQLException e) {
      e.printStackTrace();
    }

    GestionePraticheTirocinioFacade gestore = new GestionePraticheTirocinioFacade();
    listaRichiesteTirocinio = gestore.listaRichiesteTirocinio(ruolo, utente.getEmail());
    request.getSession().setAttribute("listaRichiesteTirocinio", listaRichiesteTirocinio);

    String url = response.encodeRedirectURL("/ListaRichiesteTirocinio.jsp");
    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
    dispatcher.forward(request, response);
  }

}
