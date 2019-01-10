package it.chooseit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.StatoTirocinioBean;
import it.chooseit.facade.GestionePraticheTirocinioFacade;

/**
 * Servlet implementation class ValutaTirocinioServlet
 */
@WebServlet("/ValutaTirocinioServlet")
public class ValutaTirocinioServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public ValutaTirocinioServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    RegistroTirocinioBean reg = (RegistroTirocinioBean) request.getSession().getAttribute("registroTirocinio");
    StatoTirocinioBean stato = (StatoTirocinioBean) request.getSession().getAttribute("stato");

    GestionePraticheTirocinioFacade gestore = new GestionePraticheTirocinioFacade();

    gestore.terminaTirocinio(reg);

    String url = response.encodeRedirectURL("/ListaTirocini.jsp");
    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
    dispatcher.forward(request, response);
  }

}
