package it.chooseit.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.ReportBean;
import it.chooseit.bean.TutorAziendaleBean;
import it.chooseit.facade.GestioneModulisticaFacade;
import it.chooseit.facade.GestioneReportFacade;

/**
 * Servlet implementation class ValutaReport
 */
@WebServlet("/ValutaReportServlet")
public class ValutaReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ValutaReportServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       
		String action = request.getParameter("action");
	
		/* Registro tirocinio preso dalla Session*/
		RegistroTirocinioBean registroTirocinio = (RegistroTirocinioBean) request.getSession()
				.getAttribute("registroTirocinio");
		
		/*parametri che interessano il report*/
		String dataInserimento = request.getParameter("dataInserimento");
		String path = request.getParameter("path");
		TutorAziendaleBean tutorAziendale = (TutorAziendaleBean) request.getSession().getAttribute("tutorAziendale");

		// Parse da String a sql.Date
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date sqlDate = null;
		try {
			java.util.Date utilDate = format.parse(dataInserimento);
			sqlDate = new java.sql.Date(utilDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		/* id del registro */
		int id = registroTirocinio.getIdentificativo();

		/* bean report */

		ReportBean report = new ReportBean();

		if (id != 0) {
			report.setRegistroTirocinio(registroTirocinio);
			report.setPath(path);
			report.setDataInserimento(sqlDate);
			}
       
		/* download  report */
		
		
		if (action.trim().equals("download")) {
		
		// 2) RICHIAMO IL METODO PER OTTENERE IL FILE
		File f = GestioneModulisticaFacade.downloadReport(report, getServletContext().getRealPath("//"));

		// 3) COSE PER IL DOWNLOAD DEL FILE
		response.setContentType("application/pdf");
		response.setContentLength((int) f.length());

		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", f.getName());
		response.setHeader(headerKey, headerValue);

		OutputStream outStream = response.getOutputStream();

		byte[] buffer = new byte[4096];
		int bytesRead = -1;

		FileInputStream inStream = new FileInputStream(f);
		while ((bytesRead = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}

		inStream.close();
		outStream.close();

	}else if (action.trim().equals("upload")) {
		
	   // 2)OTTENGO IL PATH DOVE SALVARE
	   String filePath = GestioneModulisticaFacade.uploadReport(report, getServletContext().getRealPath("\\"));

	// 3)SALVO NEL PATH OTTENUTO
	if(request.getParts()!=null&&request.getParts().size()>0)
	{
		for (Part part : request.getParts()) { // teoricamente nel nostro caso deve essere una sola quindi un solo file
			if (filePath != null && !filePath.equals("")) {
				part.write(filePath);
				System.out.println("Salvato in " + filePath);
			} else {
				// Ë andata male
				System.out.println("non ho salvato una cippa");
			}
		}
	}

	// 4)AGGIORNO IL BEAN AGGIUNGENDO IL PERCORSO APPENA OTTENUTO (filePath) E
	// FACCIO UPDATE NEL DB

	report.setPath(filePath);
	GestioneReportFacade assegnoTutor=new GestioneReportFacade();
	assegnoTutor.inserimentoFirma(report,tutorAziendale);
	}
}
		
	


}
