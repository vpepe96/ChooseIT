package it.chooseit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.chooseit.bean.RichiestaTirocinioBean;
import it.chooseit.facade.GestionePraticheTirocinioFacade;

@WebServlet("/ServletValutazioneFinaleRichiestaTirocinio")
public class ServletValutazioneFinaleRichiestaTirocinio extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	public ServletValutazioneFinaleRichiestaTirocinio() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String scelta = request.getParameter("scelta");
		RichiestaTirocinioBean richiestaTirocinio = (RichiestaTirocinioBean) request.getSession().getAttribute("richiestaTirocinio");
		
		GestionePraticheTirocinioFacade gestore = new GestionePraticheTirocinioFacade();
		boolean valutazioneFinaleRichiestaOK = gestore.valutazioneFinaleRichiestaTirocinio(richiestaTirocinio, scelta);
		request.getSession().setAttribute("valutazioneFinaleRichiestaOK", valutazioneFinaleRichiestaOK);
		
		String url = response.encodeRedirectURL("/ListaRichiesteTirocinio.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
}
