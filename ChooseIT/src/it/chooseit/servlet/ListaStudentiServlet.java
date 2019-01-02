package it.chooseit.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.chooseit.bean.StudenteBean;
import it.chooseit.dao.StudenteDAO;
import it.chooseit.facade.GestionePraticheTirocinioFacade;
import it.chooseit.impl.Studente;

@WebServlet("/ServletListaStudenti")
public class ListaStudentiServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public ListaStudentiServlet() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ruolo = (String) request.getSession().getAttribute("ruolo");
		String email = (String) request.getSession().getAttribute("email");
		StudenteDAO studenteDao = new Studente();
		Collection<StudenteBean> listaStudenti = null;
		
		
		try {
			listaStudenti = studenteDao.retrieveAll("matricola");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		GestionePraticheTirocinioFacade gestore = new GestionePraticheTirocinioFacade();
		listaStudenti = gestore.listaStudenti(ruolo, email);
		request.getSession().setAttribute("listaStudenti", listaStudenti);
		
		String url = response.encodeRedirectURL("/ListaStudenti.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
}
