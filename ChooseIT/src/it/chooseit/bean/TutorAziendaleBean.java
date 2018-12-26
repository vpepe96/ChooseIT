package it.chooseit.bean;

/**
 * Un oggetto TutorAziendaleBean rappresenta un tutor di un'azienda convenzionata presso l'Università degli Studi di Salerno,
 * iscritto alla piattaforma ChooseIT. Un oggetto TutorAziendaleBean è anche un oggetto UtenteBean, infatti
 * {@inheritDoc}. Inoltre, ha un identificativo che rappresenta l'azienda in cui ricopre il ruolo di tutor, rappresentato
 * dalla variabile d'istanza aziendaId.
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
	private int aziendaId;
	
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
	 * @param aziendaId identificativo dell'azienda del tutor.
	 */
	public TutorAziendaleBean(String email, String nome, String cognome, String telefono, String indirizzo, Date dataNascita, String fotoProfilo, int aziendaId) {
		super(email, nome, cognome, telefono, indirizzo, dataNascita, fotoProfilo);
		this.aziendaId = aziendaId;
	}
	
	/**
	 * Restituisce l'identificativo dell'azienda del tutor.
	 * 
	 * @return aziendaId identificativo dell'azienda.
	 */
	public int getAziendaId() {
		return aziendaId;
	}
	
}