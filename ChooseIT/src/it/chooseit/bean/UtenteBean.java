package it.chooseit.bean;

import java.io.Serializable;
import java.sql.Date;

public class UtenteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String email;
	private String nome;
	private String cognome;
	private String telefono;
	private String indirizzo;
	private Date data_nascita;
	private String foto_profilo;
	
	public UtenteBean() {
		
	}
	
	public UtenteBean(String email, String nome, String cognome, String telefono, String indirizzo, Date data_nascita, String foto_profilo) {
		this.email = email;
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.indirizzo = indirizzo;
		this.data_nascita = data_nascita;
		this.foto_profilo = foto_profilo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Date getDataNascita() {
		return data_nascita;
	}

	public void setDataNascita(Date data_nascita) {
		this.data_nascita = data_nascita;
	}

	public String getFotoProfilo() {
		return foto_profilo;
	}

	public void setFotoProfilo(String foto_profilo) {
		this.foto_profilo = foto_profilo;
	}

	@Override
	public String toString() {
		return "UtenteBean [email=" + email + ", nome=" + nome + ", cognome=" + cognome + ", telefono=" + telefono
				+ ", indirizzo=" + indirizzo + ", data_nascita=" + data_nascita + ", foto_profilo=" + foto_profilo
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UtenteBean other = (UtenteBean) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (data_nascita == null) {
			if (other.data_nascita != null)
				return false;
		} else if (!data_nascita.equals(other.data_nascita))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (foto_profilo == null) {
			if (other.foto_profilo != null)
				return false;
		} else if (!foto_profilo.equals(other.foto_profilo))
			return false;
		if (indirizzo == null) {
			if (other.indirizzo != null)
				return false;
		} else if (!indirizzo.equals(other.indirizzo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}
	
	
	
}
