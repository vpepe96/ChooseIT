package it.chooseit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.chooseit.bean.QuestionarioAziendaBean;
import it.chooseit.bean.QuestionarioStudenteBean;
import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.StatoTirocinioBean;
import it.chooseit.bean.StatoTirocinioBean.StatoTirocinio;
import it.chooseit.facade.GestioneReportFacade;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class QuestionariServlet
 */

@WebServlet("/QuestionariServlet")
public class QuestionariServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet
   */
  public QuestionariServlet() {
    super();
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String ruolo = (String) request.getSession().getAttribute("ruolo");


    GestioneReportFacade gestore = new GestioneReportFacade();

    if(ruolo.equals("tutorAziendale")) {
      RegistroTirocinioBean reg = (RegistroTirocinioBean) request.getSession().getAttribute("registroTirocinio");


      String pdt_1 = (String) request.getParameter("pdt1");
      int pdt1 = Integer.parseInt(pdt_1);
      String pdt_2 = (String) request.getParameter("pdt2");
      int pdt2 = Integer.parseInt(pdt_2);
      String pdt_3 = (String) request.getParameter("pdt3");
      int pdt3 = Integer.parseInt(pdt_3);
      String pdt_4 = (String) request.getParameter("pdt4");
      int pdt4 = Integer.parseInt(pdt_4);

      String t_1 = (String) request.getParameter("t1");
      int t1 = Integer.parseInt(t_1);
      String t_2 = (String) request.getParameter("t2");
      int t2 = Integer.parseInt(t_2);
      String t_3 = (String) request.getParameter("t3");
      int t3 = Integer.parseInt(t_3);
      String t_4 = (String) request.getParameter("t4");
      int t4 = Integer.parseInt(t_4);

      String su_1 = (String) request.getParameter("su1");
      int su1 = Integer.parseInt(su_1);
      String su_2 = (String) request.getParameter("su2");
      int su2 = Integer.parseInt(su_2);
      String su_3 = (String) request.getParameter("su3");
      int su3 = Integer.parseInt(su_3);


      QuestionarioStudenteBean questionarioente = new QuestionarioStudenteBean(reg);
      questionarioente.setPdt1(pdt1);
      questionarioente.setPdt2(pdt2);
      questionarioente.setPdt3(pdt3);
      questionarioente.setPdt4(pdt4);

      questionarioente.setT1(t1);
      questionarioente.setT2(t2);
      questionarioente.setT3(t3);
      questionarioente.setT4(t4);

      questionarioente.setSu1(su1);
      questionarioente.setSu2(su2);
      questionarioente.setSu3(su3);

      gestore.inserisciQuestionarioStudente(questionarioente);

      request.getSession().setAttribute("questionarioOK", true);
      String url=response.encodeURL("/AreaPersonale.jsp");
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);


    }else if(ruolo.equals("studente")){
      RegistroTirocinioBean reg = (RegistroTirocinioBean) request.getSession().getAttribute("registroTirocinio");

      String pdt_1 = (String) request.getParameter("pdt1");
      int pdt1 = Integer.parseInt(pdt_1);
      String pdt_2 = (String) request.getParameter("pdt2");
      int pdt2 = Integer.parseInt(pdt_2);
      String pdt_3 = (String) request.getParameter("pdt3");
      int pdt3 = Integer.parseInt(pdt_3);
      String pdt_4 = (String) request.getParameter("pdt4");
      int pdt4 = Integer.parseInt(pdt_4);
      String pdt_5 = (String) request.getParameter("pdt5");
      int pdt5 = Integer.parseInt(pdt_5);

      String eo_1 = (String) request.getParameter("eo1");
      int eo1 = Integer.parseInt(eo_1);
      String eo_2 = (String) request.getParameter("eo2");
      int eo2 = Integer.parseInt(eo_2);
      String eo_3 = (String) request.getParameter("eo3");
      int eo3 = Integer.parseInt(eo_3);
      String eo_4 = (String) request.getParameter("eo4");
      int eo4 = Integer.parseInt(eo_4);
      String eo_5 = (String) request.getParameter("eo5");
      int eo5 = Integer.parseInt(eo_5);

      String su_1 = (String) request.getParameter("su1");
      int su1 = Integer.parseInt(su_1);
      String su_2 = (String) request.getParameter("su2");
      int su2 = Integer.parseInt(su_2);
      String su_3 = (String) request.getParameter("su3");
      int su3 = Integer.parseInt(su_3);


      QuestionarioAziendaBean questionarioStu = new QuestionarioAziendaBean(reg);
      questionarioStu.setPdt1(pdt1);
      questionarioStu.setPdt2(pdt2);
      questionarioStu.setPdt3(pdt3);
      questionarioStu.setPdt4(pdt4);
      questionarioStu.setPdt5(pdt5);

      questionarioStu.setEo1(eo1);
      questionarioStu.setEo2(eo2);
      questionarioStu.setEo3(eo3);
      questionarioStu.setEo4(eo4);
      questionarioStu.setEo5(eo5);

      questionarioStu.setSu1(su1);
      questionarioStu.setSu2(su2);
      questionarioStu.setSu3(su3);

      System.out.println("Compila");
      gestore.inserisciQuestionarioAzienda(questionarioStu);

      request.getSession().setAttribute("questionarioOK", true);
      String url=response.encodeURL("/AreaPersonale.jsp");
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);


    }

  }

}