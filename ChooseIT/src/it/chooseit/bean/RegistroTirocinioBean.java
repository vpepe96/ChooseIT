package it.chooseit.bean;

import java.io.Serializable;
import java.sql.Date;

public class RegistroTirocinioBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int identificativo;
	private Date dataInizio;
	private String studenteEmail;
	private String tutorAziendaleEmail;
	private String tutorUniversitarioEmail;
	
	public RegistroTirocinioBean() {
		
	}
	
	public RegistroTirocinioBean(int identificativo, Date dataInizio, String studenteEmail, String tutorAziendaleEmail, String tutorUniversitarioEmail) {
		this.identificativo = identificativo;
		this.dataInizio = dataInizio;
		this.studenteEmail = studenteEmail;
		this.tutorAziendaleEmail = tutorAziendaleEmail;
		this.tutorUniversitarioEmail = tutorUniversitarioEmail;
	}

	public int getIdentificativo() {
		return identificativo;
	}

	public void setIdentificativo(int identificativo) {
		this.identificativo = identificativo;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public String getStudenteEmail() {
		return studenteEmail;
	}

	public void setStudenteEmail(String studenteEmail) {
		this.studenteEmail = studenteEmail;
	}

	public String getTutorAziendaleEmail() {
		return tutorAziendaleEmail;
	}

	public void setTutorAziendaleEmail(String tutorAziendaleEmail) {
		this.tutorAziendaleEmail = tutorAziendaleEmail;
	}

	public String getTutorUniversitarioEmail() {
		return tutorUniversitarioEmail;
	}

	public void setTutorUniversitarioEmail(String tutorUniversitarioEmail) {
		this.tutorUniversitarioEmail = tutorUniversitarioEmail;
	}
	
}