package it.chooseit.servlet;

/**
 * 
 */
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
import it.chooseit.dao.RichiestaTirocinioDAO;
import it.chooseit.facade.GestionePraticheTirocinioFacade;
import it.chooseit.impl.RichiestaTirocinio;

@WebServlet("/ServletListaRichiesteTirocinio")
public class ListaRichiesteTirocinioServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public ListaRichiesteTirocinioServlet() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ruolo = (String) request.getSession().getAttribute("ruolo");
		String email = (String) request.getSession().getAttribute("email");
		RichiestaTirocinioDAO richiestaTirocinioDao = new RichiestaTirocinio();
		Collection<RichiestaTirocinioBean> listaRichiesteTirocinio = null;
		
		
		try {
			listaRichiesteTirocinio = richiestaTirocinioDao.retrieveAll("id");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		GestionePraticheTirocinioFacade gestore = new GestionePraticheTirocinioFacade();
		listaRichiesteTirocinio = gestore.listaRichiesteTirocinio(ruolo, email);
		
		request.getSession().setAttribute("listaRichiesteTirocinio", listaRichiesteTirocinio);
		
		String url = response.encodeRedirectURL("/ListaRichiesteTirocinio.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
