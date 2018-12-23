package it.chooseit.bean;

import java.io.Serializable;
import java.sql.Date;

public class StudenteBean extends UtenteBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String matricola;
	private String descrizione;
	
	public StudenteBean() {
		
	}
	
	public StudenteBean(String email, String nome, String cognome, String telefono, String indirizzo, Date dataNascita, String fotoProfilo, String matricola, String descrizione) {
		super(email, nome, cognome, telefono, indirizzo, dataNascita, fotoProfilo);
		this.matricola = matricola;
		this.descrizione = descrizione;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getDescrizione() {
		return descrizione;
	}

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
