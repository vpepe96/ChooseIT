package it.chooseit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import it.chooseit.bean.AziendaBean;
import it.chooseit.facade.GestioneModulisticaFacade;
import it.chooseit.facade.GestionePraticheTirocinioFacade;

@WebServlet("/ServletInserisciAzienda")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, maxFileSize = 1024 * 1024 * 1, maxRequestSize = 1024 * 1024 * 1)
public class ServletInserisciAzienda extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ServletInserisciAzienda() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String ragioneSociale = request.getParameter("ragioneSociale");
		String sedeOperativa = request.getParameter("sedeOperativa");
		String sedeLegale = request.getParameter("sedeLegale");
		
		// 1)CREA IL BEAN AZIENDA
		AziendaBean aziendaBean = new AziendaBean();
		aziendaBean.setRagioneSociale(ragioneSociale);
		aziendaBean.setSedeOperativa(sedeOperativa);
		aziendaBean.setSedeLegale(sedeLegale);
		
		// 1)OTTENGO IL PATH DOVE SALVARE
		String filePath = GestioneModulisticaFacade.uploadProgettoFormativo(aziendaBean, getServletContext().getRealPath("//"));

		boolean progettoFormativoOK = false;

		// 2)SALVO NEL PATH OTTENUTO
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
			aziendaBean.setProgettoFormativo(filePath);
		} else {
			aziendaBean.setProgettoFormativo("");
		}

		GestionePraticheTirocinioFacade gestore = new GestionePraticheTirocinioFacade();
		boolean iserisciAziendaOK = gestore.inserisciAzienda(aziendaBean);
		request.getSession().setAttribute("iserisciAziendaOK", iserisciAziendaOK);

		String url = response.encodeRedirectURL("/InserisciAzienda.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
}
