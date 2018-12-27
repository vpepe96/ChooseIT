package it.chooseit.bean;

/**
 * Un oggetto TutorUniveristarioBean rappresenta un tutor universitario dell'Università degli Studi di Salerno
 * iscritto alla piattaforma ChooseIT. 
 * Un oggetto TutorUniversitarioBean è anche {@inheritDoc}.
 *
 * @author RocketStudios
 */

import java.io.Serializable;
import java.sql.Date;

public class TutorUniversitarioBean extends UtenteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Costruttore di TutorUniversitarioBean.
	 * 
	 * @param email email del tutor.
	 * @param nome nome del tutor.
	 * @param cognome cognome del tutor.
	 * @param telefono numero di telefono del tutor.
	 * @param indirizzo indirizzo del tutor.
	 * @param dataNascita data di nascita del tutor.
	 * @param fotoProfilo path della foto del profilo del tutor.
	 */
	public TutorUniversitarioBean(String email, String nome, String cognome, String telefono, String indirizzo, Date dataNascita, String fotoProfilo) { 
		super(email, nome, cognome, telefono, indirizzo, dataNascita, fotoProfilo);
	}
	
}