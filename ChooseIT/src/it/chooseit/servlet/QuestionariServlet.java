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
			
			
			int pdt1 = Integer.parseInt(request.getParameter("pdt1"));
			int pdt2 = Integer.parseInt(request.getParameter("pdt2"));
			int pdt3 = Integer.parseInt(request.getParameter("pdt3"));
			int pdt4 = Integer.parseInt(request.getParameter("pdt4"));

			int t1 = Integer.parseInt(request.getParameter("t1"));
			int t2 = Integer.parseInt(request.getParameter("t2"));
			int t3 = Integer.parseInt(request.getParameter("t3"));
			int t4 = Integer.parseInt(request.getParameter("t4"));

			int su1 = Integer.parseInt(request.getParameter("su1"));
			int su2 = Integer.parseInt(request.getParameter("su2"));
			int su3 = Integer.parseInt(request.getParameter("su3"));

			
				
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
			StatoTirocinioBean stato = (StatoTirocinioBean) request.getSession().getAttribute("stato");
			RegistroTirocinioBean reg = (RegistroTirocinioBean) request.getSession().getAttribute("registroTirocinio");
			
			int id = reg.getIdentificativo();
			int pdt1 = Integer.getInteger(request.getParameter("pdt1"));
			int pdt2 = Integer.getInteger(request.getParameter("pdt2"));
			int pdt3 = Integer.getInteger(request.getParameter("pdt3"));
			int pdt4 = Integer.getInteger(request.getParameter("pdt4"));
			int pdt5 = Integer.getInteger(request.getParameter("pdt5"));
			
			int eo1 = Integer.getInteger(request.getParameter("eo1"));
			int eo2 = Integer.getInteger(request.getParameter("eo2"));
			int eo3 = Integer.getInteger(request.getParameter("eo3"));
			int eo4 = Integer.getInteger(request.getParameter("eo4"));
			int eo5 = Integer.getInteger(request.getParameter("eo5"));

			int su1 = Integer.getInteger(request.getParameter("su1"));
			int su2 = Integer.getInteger(request.getParameter("su2"));
			int su3 = Integer.getInteger(request.getParameter("su3"));

			
			if (stato.getTipo() == StatoTirocinio.TERMINATO && stato.getRegistroTirocinio().getIdentificativo() == id) {
				
				QuestionarioAziendaBean questionarioStu = new QuestionarioAziendaBean();
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

				gestore.inserisciQuestionarioAzienda(questionarioStu);
				
				request.getSession().setAttribute("questionarioOK", true);
				String url=response.encodeURL("/AreaPersonale.jsp");
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
			}			

		}
		
		request.getSession().setAttribute("questionarioOK", false);
		String url=response.encodeURL("/AreaPersonale.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}