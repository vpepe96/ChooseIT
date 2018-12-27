package it.chooseit.facade;

import java.io.File;

import it.chooseit.bean.AziendaBean;
import it.chooseit.bean.ReportBean;
import it.chooseit.bean.RichiestaTirocinioBean;

/**
 * Definisce i metodi per gestire le funzionalità relative all' upload e download della modulistica.
 */
public class GestioneModulisticaFacade {
	
	/**
	 * Permette di caricare sul server un progetto Formativo relativo ad un'azienda in fase di inserimento o modifica dell'azienda.
	 * PRE: file != null AND azienda != null
	 * @param file Progetto Formativo da associare all'azienda 
	 * @param azienda azienda a cui associare il file 
	 */
	public static void uploadProgettoFormativo(File file, AziendaBean azienda) {
		
	}
	
	
	/**
	 * Permette di caricare sul server una richiesta di tirocinio relativa ad uno studente.
	 * PRE: file != null AND richiesta != null
	 * @param file richiesta di tirocinio inviata dallo studente. 
	 * @param richiesta dati relativi alla richiesta. 
	 */
	public static void uploadRichiestaTirocinio(File file, RichiestaTirocinioBean richiesta) {
		
	}
	
	/**
	 * Permette di caricare sul server un Report all'interno di un registro di tirocinio
	 * PRE: file != null AND report != null
	 * @param file Report da caricare all'interno di un registro di tirocinio 
	 * @param report informazioni riguardanti il report da caricare
	 */
	public static void uploadReport(File file, ReportBean report) {
		
	}
	
	
	/**
	 * Permette di scaricare dal server un progetto formativo relativo ad un'azienda.
	 * PRE: azienda != null
	 * @param azienda azienda della quale si desidera scaricare il progetto formativo. 
	 * @return String path dal quale effettuare il download del file.
	 */
	public static String downloadProgettoFormativo(AziendaBean azienda) {
		
		
		return null;
	}
	
	
	/**
	 * Permette di scaricare dal server una richiesta di tirocinio relativa ad uno studente.
	 * PRE: richiesta != null
	 * @param richiesta dati relativi alla richiesta della quale si desidera scaricare la richiesta di tirocinio. 
	 * @return String path dal quale effettuare il download del file.
	 */
	public static String downloadRichiestaTirocinio(RichiestaTirocinioBean richiesta) {
		
		return null;
	}
	
	
	/**
	 * Permette di scaricare dal server un report relativo ad un Registro di tirocinio.
	 * PRE: report != null
	 * @param report dati sul report di cui si desidera scricare il file. 
	 * @return String path dal quale effettuare il download del file.
	 */
	public static String downloadReport(ReportBean report) {
		
		
		return null;	
	}
	
	

}
