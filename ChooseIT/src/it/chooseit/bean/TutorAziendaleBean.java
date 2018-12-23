package it.chooseit.bean;

import java.io.Serializable;
import java.sql.Date;

public class TutorAziendaleBean extends UtenteBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int azienda_id;
	
	public TutorAziendaleBean() {
		
	}
	
	public TutorAziendaleBean(String email, String nome, String cognome, String telefono, String indirizzo, Date data_nascita, String foto_profilo, int azienda_id) {
		super(email, nome, cognome, telefono, indirizzo, data_nascita, foto_profilo);
		this.azienda_id = azienda_id;
	}
	
	
}
