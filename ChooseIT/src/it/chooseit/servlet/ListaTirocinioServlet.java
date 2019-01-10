package it.chooseit.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.facade.GestioneReportFacade;

/**
 * Servlet implementation class ListaTirocinioServlet
 */
@WebServlet("/ListaTirocinioServlet")
public class ListaTirocinioServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public ListaTirocinioServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String id = request.getParameter("registroId");
    if (id != null) {
      int reg_id = Integer.parseInt(id);
      GestioneReportFacade g = new GestioneReportFacade();
      ArrayList<RegistroTirocinioBean> registri = (ArrayList<RegistroTirocinioBean>) g.listaRegistroTirocinio();
      RegistroTirocinioBean reg = null;
      for (RegistroTirocinioBean registroTirocinioBean : registri) {
        if(registroTirocinioBean.getIdentificativo() == reg_id) {
          reg = registroTirocinioBean;
          break;
        }	
      }
      if(reg != null) {
        request.getSession().setAttribute("registroTirocinio", reg);

        String url = response.encodeURL("/RegistroTirocinio.jsp");
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
      } else {
        String url = response.encodeURL("/ListaTirocini.jsp");
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
      }
    }
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
