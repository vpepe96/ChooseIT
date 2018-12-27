package it.chooseit.bean;

/**
 * Un oggetto ReportBean rappresenta report generico sull'attività lavorativa odierna svolta da un tirocinante presso un'azienda.
 * Un report ha un collegamento al registro di tirocinio, che viene rappresentato con la variabile d'istanza registroTirocinio, una data d'inserimento,
 * che viene rappresentata con la variabile d'istanza dataInserimento, una descrizione, che viene rappresentata con la variabile d'istanza 
 * contenuto, e un tutor aziendale, che viene rappresentata con la variabile d'istanza tutorAziendale.
 *  
 * @author RocketStudios
 */

import java.io.Serializable;
import java.sql.Date;

public class ReportBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * Rappresenta il registro di tirocinio di cui fa parte il report
	 */
	private RegistroTirocinioBean registroTirocinio;
	
	/**
	 * Rappresenta la data d'insetimento del report 
	 */
	private Date dataInserimento;
	
	/**
	 * Rappresenta la descrizione del report
	 */
	private String contenuto;
	
	/**
	 * Rappresenta il tutor aziendale associato al registro di tirocinio che contiene il report
	 */
	private TutorAziendaleBean tutorAziendale;
	
	/**
	 * Costruttore di ReportBean
	 * 
	 * @param registroTirocinio registro di tirocinio che contiene il report
	 * @param dataInserimento data d'inserimento del report
	 * @param contenuto descrizione del report
	 * @param tutorAziendale tutor aziendale associato
	 */
	public ReportBean(RegistroTirocinioBean registroId, Date dataInserimento, String contenuto, TutorAziendaleBean tutorAziendaleEmail) {
		this.registroTirocinio = registroTirocinio;
		this.dataInserimento = dataInserimento;
		this.contenuto = contenuto;
		this.tutorAziendale = tutorAziendale;
	}

	/*
    |--------------------------------------------------------------------------
    | Interfaccia pubblica
    |--------------------------------------------------------------------------
    */
	
	/**
	 * Restituisce il registro di tirocinio che contiene ReportBean
	 * 
	 * @return registro di tirocinio 
	 */
	public RegistroTirocinioBean getRegistroTirocinio() {
		return registroTirocinio;
	}

	/**
	 * Setta un nuovo registro di tirocinio che contiene ReportBean
	 * 
	 * Pre: registroTirocinio != null
	 * @param registroTirocinio nuovo registro di tirocinio
	 */
	public void setRegistroTirocinio(RegistroTirocinioBean registroTirocinio) {
		this.registroTirocinio = registroTirocinio;
	}

	/**
	 * Restituisce la data d'inserimento di ReportBean
	 * 
	 * @return data d'inserimento del report
	 */
	public Date getDataInserimento() {
		return dataInserimento;
	}

	/**
	 * Setta una nuova data d'inserimento d'inserimento di ReportBean
	 * 
	 * Pre: dataInserimento != null
	 * @param dataInserimento nuova data d'inserimento del report
	 */
	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	/**
	 * Restituisce la descrizione di ReportBean
	 * 
	 * @return descrizione del report
	 */
	public String getContenuto() {
		return contenuto;
	}

	/**
	 * Setta una nuova data descrizione di ReportBean
	 * 
	 * Pre: contenuto != null
	 * @param contenuto nuova descrizione del report
	 */
	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
	}

	/**
	 * Restituisce il tutor aziendale assegnato al registro di tirocinio che contiene ReportBean
	 * 
	 * @return tutor aziendale associato
	 */ 
	public TutorAziendaleBean getTutorAziendale() {
		return tutorAziendale;
	}

	/**
	 * Setta un nuovo tutor aziendale assegnato al registro di tirocinio che contiene ReportBean
	 * 
	 * Pre: tutorAziendale != null
	 * @param tutorAziendale nuovo tutor aziendale associato
	 */
	public void setTutorAziendale(TutorAziendaleBean tutorAziendale) {
		this.tutorAziendale = tutorAziendale;
	}
	
}
