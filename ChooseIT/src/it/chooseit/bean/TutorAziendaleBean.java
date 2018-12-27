package it.chooseit.bean;

/**
 * Un oggetto TutorAziendaleBean rappresenta un tutor di un'azienda convenzionata presso l'Università degli Studi di Salerno,
 * iscritto alla piattaforma ChooseIT. 
 * Un oggetto TutorAziendaleBean è anche * {@inheritDoc}. 
 * Inoltre, ha un riferimento all'azienda in cui ricopre il ruolo di tutor, rappresentato dalla variabile d'istanza azienda.
 *
 * @author RocketStudios
 */

import java.io.Serializable;
import java.sql.Date;

public class TutorAziendaleBean extends UtenteBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Rappresenta l'identificativo dell'azienda del tutor.
	 */
	private AziendaBean azienda;
	
	/**
	 * Costruttore vuoto di TutorAziendaleBean,
	 */
	public TutorAziendaleBean() { }
	
	/**
	 * Costruttore di TutorAziendaleBean.
	 * 
	 * @param email email del tutor.
	 * @param nome nome del tutor.
	 * @param cognome cognome del tutor.
	 * @param telefono numero di telefono del tutor.
	 * @param indirizzo indirizzo del tutor.
	 * @param dataNascita data di nascita del tutor.
	 * @param fotoProfilo path della foto del profilo del tutor.
	 * @param azienda identificativo dell'azienda del tutor.
	 */
	public TutorAziendaleBean(String email, String nome, String cognome, String telefono, String indirizzo, Date dataNascita, String fotoProfilo, AziendaBean azienda) {
		super(email, nome, cognome, telefono, indirizzo, dataNascita, fotoProfilo);
		this.azienda = azienda;
	}
	
	/**
	 * Restituisce l'azienda per cui lavora TutorAziendaleBean.
	 * 
	 * @return azienda per cui lavora il tutor aziendale.
	 */
	public AziendaBean getAzienda() {
		return azienda;
	}
	
}