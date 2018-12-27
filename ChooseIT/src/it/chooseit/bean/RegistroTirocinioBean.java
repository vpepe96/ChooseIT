package it.chooseit.bean;

/**
 * Un oggetto RegistroTirocinioBean rappresenta il registro di tirocinio relativo ad un tirocinio di uno studente presso un'azienda.
 * Un registro di tirocinio ha un identificativo univoco, che viene rappresentato con la variabile d'istanza identificativo, una data d'inizio,
 * che viene rappresentata con la variabile d'istanza dataInizio, lo studente, che viene rappresentata con la variabile d'istanza 
 * studente, un tutor aziendale, che viene rappresentata con la variabile d'istanza tutorAziendale, e un tutor universitario, che viene 
 * rappresentata con la variabile d'istanza tutorUniversitario.
 *  
 * @author RocketStudios
 */

import java.io.Serializable;
import java.sql.Date;

public class RegistroTirocinioBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Rappresenta l'identificativo del registro di tirocinio
	 */
	private int identificativo;
	
	/**
	 * Rappresenta la data in cui comincia il tirocinio e conseguentemente viene creato il registro di tirocinio
	 */
	private Date dataInizio;
	
	/**
	 * Rappresenta lo studente tirocinante che detiene il registro di tirocinio
	 */
	private StudenteBean studente;
	
	/**
	 * Rappresenta l'email del tutor aziendale che è stato assegnato al tirocinio a cui si riferisce il registro di tirocinio
	 */
	private TutorAziendaleBean tutorAziendale;
	
	/**
	 * Rappresenta l'email del tutor universitario che è stato assegnato al tirocinio a cui si riferisce il registro di tirocinio
	 */
	private TutorUniversitarioBean tutorUniversitario;
	
	/**
	 * Costruttore di RegistroTirocinioBean
	 * 
	 * @param studente studente associato
	 * @param tutorAziendale tutor aziendale associato
	 * @param tutorUniversitario tutor universitario associato
	 */
	public RegistroTirocinioBean(StudenteBean studente, TutorAziendaleBean tutorAziendale, TutorUniversitarioBean tutorUniversitario) {
		this.studente = studente;
		this.tutorAziendale = tutorAziendale;
		this.tutorUniversitario = tutorUniversitario;
	}
	
	/**
	 * Costruttore di RegistroTirocinioBean
	 * 
	 * @param identificativo identificativo del registro di tirocinio
	 * @param dataInizio data inizio del tirocinio e di creazione del registro di tirocinio
	 * @param studente dello studente tirocinante associato
	 * @param tutorAziendale tutor aziendale associato
	 * @param tutorUniversitario tutor universitario associato
	 */
	public RegistroTirocinioBean(int identificativo, Date dataInizio, StudenteBean studente, TutorAziendaleBean tutorAziendale, TutorUniversitarioBean tutorUniversitario) {
		this.identificativo = identificativo;
		this.dataInizio = dataInizio;
		this.studente = studente;
		this.tutorAziendale = tutorAziendale;
		this.tutorUniversitario = tutorUniversitario;
	}

	/*
    |--------------------------------------------------------------------------
    | Interfaccia pubblica
    |--------------------------------------------------------------------------
    */
	
	/**
	 * Restituisce l'identificativo di RegistroTirocinioBean
	 * 
	 * @return identificativo di RegistroTirocinioBean
	 */
	public int getIdentificativo() {
		return identificativo;
	}

	/**
	 * Setta l'identificativo di RegistroTirocinioBean
	 * 
	 * Pre: identificativo != null
	 * @param identificativo nuovo identificativo di RegistroTirocinioBean
	 */
	public void setIdentificativo(int identificativo) {
		this.identificativo = identificativo;
	}

	/**
	 * Restituisce la data d'inizio del tirocinio e di creazione di RegistroTirocinioBean
	 * 
	 * @return data d'inizio del tirocinio associato e di creazione di RegistroTirocinioBean
	 */
	public Date getDataInizio() {
		return dataInizio;
	}

	/**
	 * Setta la data d'inizio del tirocinio e di creazione di RegistroTirocinioBean
	 * 
	 * Pre: dataInizio != null
	 * @param dataInizio nuova data d'inizio del tirocinio e di creazione di RegistroTirocinioBean
	 */
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	/**
	 * Restituisce lo studente che detiene RegistroTirocinioBean
	 * 
	 * @return studente tirocinante
	 */
	public StudenteBean getStudente() {
		return studente;
	}

	/**
	 * Setta lo studente che detiene RegistroTirocinioBean
	 * 
	 * Pre: studente != null
	 * @param studente nuovo studente tirocinante
	 */
	public void setStudente(StudenteBean studente) {
		this.studente = studente;
	}

	/**
	 * Restituisce il tutor aziendale associato al RegistroTirocinioBean
	 * 
	 * @return tutor aziendale associato
	 */
	public TutorAziendaleBean getTutorAziendale() {
		return tutorAziendale;
	}

	/**
	 * Setta il tutor aziendale associato al RegistroTirocinioBean
	 * 
	 * Pre: tutorAziendale != null
	 * @param tutorAziendale nuovo tutor aziendale associato
	 */
	public void setTutorAziendale(TutorAziendaleBean tutorAziendale) {
		this.tutorAziendale = tutorAziendale;
	}

	/**
	 * Restituisce il tutor universitario associato al RegistroTirocinioBean
	 * 
	 * @return tutor universitario associato
	 */
	public TutorUniversitarioBean getTutorUniversitario() {
		return tutorUniversitario;
	}

	/**
	 * Setta il tutor universitario associato al RegistroTirocinioBean
	 * 
	 * Pre: tutorUniversitario != null
	 * @param tutorUniversitario nuovo tutor universitario associato
	 */
	public void setTutorUniversitario(TutorUniversitarioBean tutorUniversitario) {
		this.tutorUniversitario = tutorUniversitario;
	}
	
}