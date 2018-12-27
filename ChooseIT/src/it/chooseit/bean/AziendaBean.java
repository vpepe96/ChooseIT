package it.chooseit.bean;

/**
 * Un oggetto AziendaBean rappresenta un'azienda convenzionata con l'Università degli Studi di Salerno ed iscritta al sistema ChooseIT.
 * Un'azienda ha un nome, che viene rappresentato con la variabile d'istanza ragioneSociale, un progetto formativo, che viene rappresentato 
 * con la variabile d'istanza progettoFormativo, una sede operativa, che viene rappresentata con la variabile d'istanza sedeOperativa, 
 * e una sede legale, che viene rappresentata con la variabile d'istanza sedeLegale.
 * 
 * @author RocketStudios
 */

import java.io.Serializable;

public class AziendaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Rappresenta la ragione sociale dell'azienda
	 */
	private String ragioneSociale;
	
	/**
	 * Rappresenta il path del progetto formativo dell'azienda
	 */
	private String progettoFormativo;
	
	/**
	 * Rappresenta l'indirizzo della sede operativa dell'azienda
	 */
	private String sedeOperativa;
	
	/**
	 * Rappresenta l'indirizzo della sede legale dell'azienda
	 */
	private String sedeLegale;
	
	/**
	 * Costruttore di AziendaBean
	 * 
	 * @param ragioneSociale ragione sociale dell'azienda
	 * @param progettoFormativo path del progetto formativo dell'azienda
	 * @param sedeOperativa indirizzo della sede operativa dell'azienda
	 * @param sedeLegale indirizzo della sede legale dell'azienda
	 */
	public AziendaBean(String ragioneSociale, String progettoFormativo, String sedeOperativa, String sedeLegale) {
		this.ragioneSociale = ragioneSociale;
		this.progettoFormativo = progettoFormativo;
		this.sedeOperativa = sedeOperativa;
		this.sedeLegale = sedeLegale;
	}
	
	/*
    |--------------------------------------------------------------------------
    | Interfaccia pubblica
    |--------------------------------------------------------------------------
    */
	
	/**
	 * Restituisce la ragione sociale di AziendaBean
	 * 
	 * @return ragioneSociale ragione sociale 
	 */
	public String getRagioneSociale() {
		return ragioneSociale;
	}

	/**
	 * Setta una nuova ragione sociale per AziendaBean
	 * 
	 * Pre: ragioneSociale != null
	 * @param ragioneSociale nuova ragione sociale
	 */
	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	/**
	 * Restituisce il path del progetto formativo di AziendaBean
	 * 
	 * @return progettoFormativo path del progetto formativo 
	 */
	public String getProgettoFormativo() {
		return progettoFormativo;
	}

	/**
	 * Setta un nuovo path per il progetto formativo di AziendaBean
	 * 
	 * Pre: progettoFormativo != null
	 * @param progettoFormativo nuovo path del progetto formativo 
	 */
	public void setProgettoFormativo(String progettoFormativo) {
		this.progettoFormativo = progettoFormativo;
	}
	
	/**
	 * Restituisce l'indirizzo della sede operativa di AziendaBean
	 * 
	 * @return sedeOperativa indirizzo della sede operativa
	 */
	public String getSedeOperativa() {
		return sedeOperativa;
	}

	/**
	 * Setta un nuovo indirizzo per la sede operativa di AziendaBean
	 * 
	 * Pre: sedeOperativa != null
	 * @param sedeOperativa nuovo indirizzo della sede operativa
	 */
	public void setSedeOperativa(String sedeOperativa) {
		this.sedeOperativa = sedeOperativa;
	}

	/**
	 * Restituisce l'indirizzo della sede legale di AziendaBean
	 * 
	 * @return sedeLegale indirizzo della sede legale
	 */
	public String getSedeLegale() {
		return sedeLegale;
	}

	/**
	 * Setta un nuovo indirizzo per la sede legale di AziendaBean
	 * 
	 * Pre: sedeLegale != null
	 * @param sedeLegale nuovo indirizzo della sede legale
	 */
	public void setSedeLegale(String sedeLegale) {
		this.sedeLegale = sedeLegale;
	}

}