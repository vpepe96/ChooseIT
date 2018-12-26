package it.chooseit.bean;

/**
 * Un oggetto StudenteBean rappresenta uno studente dell'Università degli Studi di Salerno,
 * iscritto alla piattaforma ChooseIT. Un oggetto StudenteBean è anche un oggetto UtenteBean, infatti
 * {@inheritDoc}. Inoltre, ha una matricola, rappresentata dalla variabile d'istanza matricola, e
 * una descrizione del proprio profilo personale, rappresentata dalla variabile d'istanza descrizione.
 *
 * @author RocketStudios
 */

import java.io.Serializable;
import java.sql.Date;

public class StudenteBean extends UtenteBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * Rappresenta la matricola dello studente.
	 */
	private String matricola;
	/**
	 * Rappresenta la descrizione del profilo personale dello studente.
	 */
	private String descrizione;
	
	/**
	 * Costruttore vuoto di StudenteBean.
	 */
	public StudenteBean() { }
	
	/**
	 * Costruttore di StudenteBean.
	 * 
	 * @param email email dello studente.
	 * @param nome nome dello studente.
	 * @param cognome cognome dello studente.
	 * @param telefono numero di telefono dello studente.
	 * @param indirizzo indirizzo dello studente.
	 * @param dataNascita data di nascita dello studente.
	 * @param fotoProfilo path della foto di profilo dello studente.
	 * @param matricola matricola dello studente.
	 * @param descrizione descrizione del profilo personale dello studente.
	 */
	public StudenteBean(String email, String nome, String cognome, String telefono, String indirizzo, Date dataNascita, String fotoProfilo, String matricola, String descrizione) {
		super(email, nome, cognome, telefono, indirizzo, dataNascita, fotoProfilo);
		this.matricola = matricola;
		this.descrizione = descrizione;
	}

	/*
    |--------------------------------------------------------------------------
    | Interfaccia pubblica
    |--------------------------------------------------------------------------
    */
	
	/**
	 * Restituisce la matricola dello studente.
	 * 
	 * @return matricola matricola dello studente.
	 */
	public String getMatricola() {
		return matricola;
	}

	/**
	 * Setta una nuova matricola per lo studente
	 * 
	 * Pre: matricola != null.
	 * @param matricola nuova matricola per lo studente.
	 */
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	/**
	 * Restituisce la descrizione del profilo personale dello studente.
	 * 
	 * @return descrizione del profilo personale dello studente.
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * Setta una nuova descrizione per il profilo personale dello studente.
	 * 
	 * Pre: descrizione != null.
	 * @param descrizione nuova descrizione del profilo personale dello studente.
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public String toString() {
		return super.toString() + "StudenteBean [matricola=" + matricola + ", descrizione=" + descrizione + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudenteBean other = (StudenteBean) obj;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (matricola == null) {
			if (other.matricola != null)
				return false;
		} else if (!matricola.equals(other.matricola))
			return false;
		return true;
	}

}