package it.chooseit.bean;

/**
 * Un oggetto SegreteriaBean rappresenta un segretario/a dell'Università degli Studi di Salerno, iscritto alla piattaforma ChooseIT.
 * Un oggetto SegreteriaBean è anche {@inheritDoc}.
 * 
 * @author RocketStudios
 */

import java.io.Serializable;
import java.sql.Date;

public class SegreteriaBean extends UtenteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Costruttore di SegreteriaBean
	 * 
	 * @param email email del segretario/a
	 * @param nome nome del segretario/a
	 * @param cognome cognome del segretario/a
	 * @param telefono numero telefonico del segretario/a
	 * @param indirizzo indirizzo di residenza del segretario/a
	 * @param dataNascita data di nascita del segretario/a
	 * @param fotoProfilo path della foto del profilo personale del segretario/a
	 */
	public SegreteriaBean(String email, String nome, String cognome, String telefono, String indirizzo, Date dataNascita, String fotoProfilo) {
		super(email, nome, cognome, telefono, indirizzo, dataNascita, fotoProfilo);
	}
	
}
