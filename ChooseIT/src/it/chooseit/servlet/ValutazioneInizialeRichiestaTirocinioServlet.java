package it.chooseit.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.chooseit.bean.RichiestaTirocinioBean;
import it.chooseit.bean.TutorAziendaleBean;
import it.chooseit.bean.TutorUniversitarioBean;
import it.chooseit.dao.TutorAziendaleDAO;
import it.chooseit.dao.TutorUniversitarioDAO;
import it.chooseit.facade.GestionePraticheTirocinioFacade;
import it.chooseit.impl.TutorAziendale;
import it.chooseit.impl.TutorUniversitario;

@WebServlet("/ServletValutazioneInizialeRichiestaTirocinio")
public class ValutazioneInizialeRichiestaTirocinioServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public ValutazioneInizialeRichiestaTirocinioServlet() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String scelta = request.getParameter("scelta");
		String emailTutorAziendale = request.getParameter("emailTutorAziendale");
		String emailTutorUniversitario = request.getParameter("emailTutorUniversitario");
		RichiestaTirocinioBean richiestaTirocinio = (RichiestaTirocinioBean) request.getSession().getAttribute("richiestaTirocinio");
		
		//1) SETTO IL BEAN PER IL TUTOR AZIENDALE
		TutorAziendaleDAO tutorAziendaleDao = new TutorAziendale();
		TutorAziendaleBean tutorAziendale = null;
		try {
			tutorAziendale = tutorAziendaleDao.retrieveByKey(emailTutorAziendale);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		//2) SETTO IL BEAN PER IL TUTOR UNIVERSITARIO
		TutorUniversitarioDAO tutorUniversitarioDao = new TutorUniversitario();
		TutorUniversitarioBean tutorUniversitario = null;
		try {
			tutorUniversitario = tutorUniversitarioDao.retrieveByKey(emailTutorUniversitario);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		GestionePraticheTirocinioFacade gestore = new GestionePraticheTirocinioFacade();
		boolean valutazioneInizialeRichiestaOK = gestore.valutazioneInizialeRichiestaTirocinio(richiestaTirocinio, tutorAziendale, tutorUniversitario, scelta);
		request.getSession().setAttribute("valutazioneInizialeRichiestaOK", valutazioneInizialeRichiestaOK);
		
		String url = response.encodeRedirectURL("/ListaRichiesteTirocinio.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
