package it.chooseit.bean;

import java.io.Serializable;
import java.sql.Date;

public class TutorAziendaleBean extends UtenteBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int aziendaId;
	
	public TutorAziendaleBean() {
		
	}
	
	public TutorAziendaleBean(String email, String nome, String cognome, String telefono, String indirizzo, Date dataNascita, String fotoProfilo, int aziendaId) {
		super(email, nome, cognome, telefono, indirizzo, dataNascita, fotoProfilo);
		this.aziendaId = aziendaId;
	}
	
	public int getAziendaId() {
		return aziendaId;
	}
}
