package it.chooseit.bean;

import java.io.Serializable;
import java.sql.Date;

public class RegistroTirocinioBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int identificativo;
	private Date data_inizio;
	private String studente_email;
	private String tutor_aziendale_email;
	private String tutor_universitario_email;
	
	public RegistroTirocinioBean() {
		
	}
	
	public RegistroTirocinioBean(int identificativo, Date data_inizio, String studente_email, String tutor_aziendale_email, String tutor_universitario_email) {
		this.identificativo = identificativo;
		this.data_inizio = data_inizio;
		this.studente_email = studente_email;
		this.tutor_aziendale_email = tutor_aziendale_email;
		this.tutor_universitario_email = tutor_universitario_email;
	}

	public int getIdentificativo() {
		return identificativo;
	}

	public void setIdentificativo(int identificativo) {
		this.identificativo = identificativo;
	}

	public Date getDataInizio() {
		return data_inizio;
	}

	public void setDataInizio(Date data_inizio) {
		this.data_inizio = data_inizio;
	}

	public String getStudenteEmail() {
		return studente_email;
	}

	public void setStudenteEmail(String studente_email) {
		this.studente_email = studente_email;
	}

	public String getTutorAziendaleEmail() {
		return tutor_aziendale_email;
	}

	public void setTutorAziendaleEmail(String tutor_aziendale_email) {
		this.tutor_aziendale_email = tutor_aziendale_email;
	}

	public String getTutorUniversitarioEmail() {
		return tutor_universitario_email;
	}

	public void setTutorUniversitarioEmail(String tutor_universitario_email) {
		this.tutor_universitario_email = tutor_universitario_email;
	}
	
}
