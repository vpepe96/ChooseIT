package it.chooseit.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.dao.RegistroTirocinioDAO;
import it.chooseit.impl.RegistroTirocinio;

/**
 * Servlet implementation class ListaQuestionariTutorAziendaliServlet
 */
@WebServlet("/ListaQuestionariTutorAziendaliServlet")
public class ListaQuestionariTutorAziendaliServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor.
   */
  public ListaQuestionariTutorAziendaliServlet() {
    super();
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   * 
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String id = request.getParameter("registroId");
    if (id != null) {
      int reg_id = Integer.parseInt(id);
      RegistroTirocinioDAO regDao = new RegistroTirocinio();
      RegistroTirocinioBean registroTirocinioBean = null;
      try {
        registroTirocinioBean = regDao.retrieveByKey(reg_id);
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      request.getSession().setAttribute("registroTirocinio", registroTirocinioBean);

      String url = response.encodeURL("/Questionari.jsp");
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);

    } else {
      String url = response.encodeURL("/ListaQuestionariTutorAziendale.jsp");
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);
    }
  }
}
