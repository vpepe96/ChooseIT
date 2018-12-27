package it.chooseit.bean;

/**
 * Un oggetto RichiestaTirocinioBean rappresenta la richiesta di tirocinio, fatta da uno studente, per iniziare un tirocinio presso un'azienda.
 * Una richiesta di tirocinio ha un identificativo univoco, che viene rappresentato con la variabile d'istanza id, lo studente che 
 * effettua la richiesta di tirocinio, che viene rappresentata con la variabile d'istanza studente, la data di effettuazione della richiesta,
 * che viene rappresentata con la variabile d'istanza dataRichiesta, un collegamento dell'azienda dove lo studente vorrebbe svolgere il tirocinio,
 * che viene rappresentata con la variabile d'istanza azienda, il path del progetto formativo che lo studente compila e carica, 
 * che viene rappresentata con la variabile d'istanza progettoFormativo, e un collegamento al registro di tirocinio, che viene rappresentato con la 
 * variabile d'istanza registroTirocinio.
 *  
 * @author RocketStudios
 */

import java.io.Serializable;
import java.sql.Date;

public class RichiestaTirocinioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Rappresenta l'identificativo della richiesta di tirocinio
	 */
	private int id;
	
	/**
	 * Rappresenta lo studente che effettua la richiesta di tirocinio
	 */
	private StudenteBean studente;
	
	/**
	 * Rappresenta la data di effettuazione della richiesta di tirocinio
	 */
	private Date dataRichiesta;
	
	/**
	 * Rappresenta l'azienda scelta dallo studente
	 */
	private AziendaBean azienda;
	
	/**
	 * Rappresenta il path del progetto formativo compilato per la richiesta di tirocinio
	 */
	private String progettoFormativo;
	
	/**
	 * Rappresenta il registro di tirocinio associato
	 */
	private RegistroTirocinioBean registroTirocinio;
	
	/**
	 * Costruttore di RichiestaTirocinioBean
	 * 
	 * @param id identificativo della richiesta di tirocinio
	 * @param studente studente che effettua la richiesta di tirocinio
	 * @param dataRichiesta data di effettuazione della richiesta
	 * @param azienda azienda selezionata
	 * @param progettoFormativo path del progetto formativo compilato per la richiesta
	 * @param registroTirocinio registro di tirocinio associato
	 */
	public RichiestaTirocinioBean(int id, StudenteBean studente, Date dataRichiesta, AziendaBean azienda, String progettoFormativo, RegistroTirocinioBean registroTirocinio) {
		this.id = id;
		this.studente = studente;
		this.dataRichiesta = dataRichiesta;
		this.azienda = azienda;
		this.progettoFormativo = progettoFormativo;
		this.registroTirocinio = registroTirocinio;
	}

	/*
    |--------------------------------------------------------------------------
    | Interfaccia pubblica
    |--------------------------------------------------------------------------
    */
	
	/**
	 * Restituisce l'identificativo di RichiestaTirocinioBean
	 * 
	 * @return identificativo della richiesta di tirocinio 
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setta un nuovo identificativo per RichiestaTirocinioBean
	 * 
	 * Pre: id != null
	 * @param id nuovo identificativo per le richiesta di tirocinio
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Restituisce lo studente che effettua la richiesta relativa a RichiestaTirocinioBean
	 * 
	 * @return studente che effettua la richiesta di tirocinio
	 */
	public StudenteBean getStudente() {
		return studente;
	}

	/**
	 * Setta un nuovo studente che effettua la richiesta relativa a RichiestaTirocinioBean
	 * 
	 * Pre: studente != null
	 * @param studente nuovo studente che effettua la richiesta di tirocinio
	 */
	public void setStudenteEmail(StudenteBean studente) {
		this.studente = studente;
	}

	/**
	 * Restituisce la data di effettuazione di RichiestaTirocinioBean
	 * 
	 * @return data di effettuazione della richiesta di tirocinio
	 */
	public Date getDataRichiesta() {
		return dataRichiesta;
	}

	/**
	 * Setta una nuova data di effettuazione di RichiestaTirocinioBean
	 *
	 * Pre: dataRichiesta != null
	 * @param dataRichiesta nuova data di effettuazione della richiesta di tirocinio
	 */
	public void setDataRichiesta(Date dataRichiesta) {
		this.dataRichiesta = dataRichiesta;
	}

	/**
	 * Restituisce l'azienda di RichiestaTirocinioBean
	 * 
	 * @return azienda scelta per la richiesta di tirocinio
	 */
	public AziendaBean getAzienda() {
		return azienda;
	}
	
	/**
	 * Setta una nuova azienda di RichiestaTirocinioBean
	 * 
	 * Pre: azienda != null
	 * @param azienda nuova azienda selezionata per la richiesta di tirocinio
	 */
	public void setAzienda(AziendaBean azienda) {
		this.azienda = azienda;
	}

	/**
	 * Restituisce la path del progetto formativo di RichiestaTirocinioBean
	 * 
	 * @return path del progetto formativo della richiesta di tirocinio
	 */
	public String getProgettoFormativo() {
		return progettoFormativo;
	}

	/**
	 * Setta un nuovo path per il progetto formativo di RichiestaTirocinioBean
	 * 
	 * Pre: progettoFormativo != null
	 * @param progettoFormativo nuova path del progetto formativo della richiesta di tirocinio
	 */
	public void setProgettoFormativo(String progettoFormativo) {
		this.progettoFormativo = progettoFormativo;
	}
	
	/**
	 * Restituisce il registro di tirocinio di RichiestaTirocinioBean
	 * 
	 * @return registro di tirocinio associato alla richiesta di tirocinio
	 */
	public RegistroTirocinioBean getRegistroTirocinio() {
		return registroTirocinio;
	}
	
	/**
	 * Setta un nuovo registro di tirocinio di RichiestaTirocinioBean
	 * 
	 * Pre: registroTirocinio != null
	 * @param registroTirocinio nuovo registro di tirocinio associato
	 */
	public void setRegistroTirocinio(RegistroTirocinioBean registroTirocinio) {
		this.registroTirocinio = registroTirocinio;
	}
	
}
