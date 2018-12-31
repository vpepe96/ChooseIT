package it.chooseit.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import it.chooseit.bean.AziendaBean;
import it.chooseit.bean.RichiestaTirocinioBean;
import it.chooseit.bean.StudenteBean;
import it.chooseit.dao.AziendaDAO;
import it.chooseit.facade.GestioneModulisticaFacade;
import it.chooseit.facade.GestionePraticheTirocinioFacade;
import it.chooseit.impl.Azienda;

@WebServlet("/ServletInviaRichiestaTirocinio")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, maxFileSize = 1024 * 1024 * 1, maxRequestSize = 1024 * 1024 * 1)
public class ServletInviaRichiestaTirocinio extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public ServletInviaRichiestaTirocinio() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String email = request.getParameter("email");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String telefono = request.getParameter("telefono");
		String indirizzo = request.getParameter("indirizzo");
		Date dataNascita = convertDate(request.getParameter("dataNascita"));
		String matricola = request.getParameter("matricola");
		String descrizione = request.getParameter("descrizione");
		Date dataRichiesta = new Date(System.currentTimeMillis());
		String ragioneSociale = request.getParameter("ragioneSociale");
		AziendaDAO aziendaDao = new Azienda();
		
		// 1) CREA IL BEAN STUDENTE
		StudenteBean studenteBean = new StudenteBean();
		studenteBean.setDataNascita(dataNascita);
		studenteBean.setEmail(email);
		studenteBean.setNome(nome);
		studenteBean.setCognome(cognome);
		studenteBean.setTelefono(telefono);
		studenteBean.setMatricola(matricola);
		studenteBean.setIndirizzo(indirizzo);
		if (descrizione == null) {
			studenteBean.setDescrizione("");
		} else {
			studenteBean.setDescrizione(descrizione);
		}
		
		// 2) CREA IL BEAN AZIENDA
		AziendaBean aziendaBean = null;
		try {
			aziendaBean = aziendaDao.retrieveByKey(ragioneSociale);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3) CREA IL BEAN RICHIESTA DI TIROCINIO
		RichiestaTirocinioBean richiestaBean = new RichiestaTirocinioBean();
		richiestaBean.setStudenteEmail(studenteBean);
		richiestaBean.setAzienda(aziendaBean);
		richiestaBean.setDataRichiesta(dataRichiesta);
		
		// 4)OTTENGO IL PATH DOVE SALVARE
		String filePath = GestioneModulisticaFacade.uploadRichiestaTirocinio(richiestaBean, getServletContext().getRealPath("//"));

		boolean progettoFormativoOK = false;

		// 5)SALVO NEL PATH OTTENUTO
		if (request.getPart("progettoFormativo") != null && request.getPart("progettoFormativo").getSize() > 0) {
			if (filePath != null && !filePath.equals("")) {
				Part part = request.getPart("progettoFormativo");
				part.write(filePath);
				progettoFormativoOK = true;
				System.out.println("Salvato in " + filePath);
			} else {
				// è andata male
				System.out.println("Errore nel salvataggio della richiesta di tirocinio");
			}
		}	
		
		// 6)AGGIORNO IL BEAN AGGIUNGENDO IL PERCORSO APPENA OTTENUTO (filePath) 
		// (solo se la richiesta di tirocinio è stata inserita, cioè se progettoFormativoOK == true)
		if (progettoFormativoOK) {
			richiestaBean.setProgettoFormativo(filePath);
		} else {
			richiestaBean.setProgettoFormativo("");
		}
		
		GestionePraticheTirocinioFacade gestore = new GestionePraticheTirocinioFacade();
		boolean inviaRichiestaOK = gestore.inviaRichiestaTirocinio(richiestaBean);
		request.getSession().setAttribute("inviaRichiestaOK", inviaRichiestaOK);

		String url = response.encodeRedirectURL("/InviaRichiestaTirocinio.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
	
	private Date convertDate(String data) {
		// Parse da String a sql.Date
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date sqlDate = null;
		try {
			java.util.Date utilDate = format.parse(data);
			sqlDate = new java.sql.Date(utilDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sqlDate;
	}
}
