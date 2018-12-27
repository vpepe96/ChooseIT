package it.chooseit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.chooseit.bean.StudenteBean;
import it.chooseit.dao.StudenteDAO;
import it.chooseit.facade.GestioneAccountFacade;
import it.chooseit.impl.Studente;

/**
 * Servlet implementation class ServletRegistrazione
 */
@WebServlet("/ServletRegistrazione")
public class ServletRegistrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistrazione() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String telefono = request.getParameter("telefono");
		String indirizzo = request.getParameter("indirizzo");
		String dataNascita = request.getParameter("dataNascita");
		String matricola = request.getParameter("matricola");
		String descrizione = request.getParameter("descrizione");
		//String fotoProfilo = request.getParameter("fotoProfilo");
		
		//Parse da String a sql.Date
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date sqlDate = null;
	    try {
	        java.util.Date utilDate = format.parse(dataNascita);
	        sqlDate = new java.sql.Date(utilDate.getTime());
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
		
		StudenteBean bean = new StudenteBean();
		bean.setDataNascita(sqlDate);
		bean.setEmail(email);
		bean.setNome(nome);
		bean.setCognome(cognome);
		bean.setTelefono(telefono);
		bean.setMatricola(matricola);
		bean.setIndirizzo(indirizzo);
		if(descrizione == null) {
			bean.setDescrizione("");
		}else {
			bean.setDescrizione(descrizione);
		}
		/*if(fotoProfilo == null) {
			bean.setFotoProfilo("");
		}else {
			bean.setFotoProfilo(fotoProfilo);
		}*/
		bean.setFotoProfilo("");
		
		
		GestioneAccountFacade gestore = new GestioneAccountFacade();
		boolean registrazioneOK = gestore.registrazione(bean, password);
		request.getSession().setAttribute("registrazioneOK", registrazioneOK);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Registrazione.jsp");
		dispatcher.forward(request, response);
	}

}
