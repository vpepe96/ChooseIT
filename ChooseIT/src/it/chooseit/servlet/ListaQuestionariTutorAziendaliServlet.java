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
import it.chooseit.bean.RegistroTirocinioBean;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("registroId");
		if (id != null) {
			int reg_id = Integer.parseInt(id);
			TutorAziendaleBean tutor = (TutorAziendaleBean) request.getSession().getAttribute("utente");
			RegistroTirocinioBean reg = tutor.getRegistroTirocinio(reg_id);
			request.getSession().setAttribute("registroTirocinio", reg);

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
