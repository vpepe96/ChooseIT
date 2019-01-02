package it.chooseit.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.chooseit.bean.QuestionarioStudenteBean;
import it.chooseit.bean.TutorAziendaleBean;
import it.chooseit.bean.UtenteBean;
import it.chooseit.facade.GestioneReportFacade;

/**
 * Servlet implementation class ListaQuestionariTutorAziendali
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* dalla sessione ricaviamo il tutor aziendale */
		UtenteBean utente = (UtenteBean) request.getSession().getAttribute("utente");
		String ruolo = (String) request.getSession().getAttribute("ruolo");
		
		if(ruolo.equals("tutorAziendale")) {
			
			TutorAziendaleBean tutor = (TutorAziendaleBean) utente;
			
			/* uso della GestioneReportFacade */
			GestioneReportFacade report = new GestioneReportFacade();
			/* utilizzo del metodo RecuperaQuestionariPer */
			ArrayList<QuestionarioStudenteBean> questionari = (ArrayList<QuestionarioStudenteBean>) report.recuperaQuestionarioStudente(tutor);
			
			request.getSession().setAttribute("questionari", questionari);
			
			String url=response.encodeURL("/ListaQuestionari.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}else {
			String url=response.encodeURL("/AreaPersonale.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
		
		
	}
}
