package it.chooseit.bean;

import java.io.Serializable;
import java.sql.Date;

public class ReportBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int registroId;
	private Date dataInserimento;
	private String contenuto;
	private String tutorAziendaleEmail;
	
	public ReportBean(int registroId, Date dataInserimento, String contenuto, String tutorAziendaleEmail) {
		this.registroId = registroId;
		this.dataInserimento = dataInserimento;
		this.contenuto = contenuto;
		this.tutorAziendaleEmail = tutorAziendaleEmail;
	}

	public int getRegistroId() {
		return registroId;
	}

	public void setRegistroId(int registroId) {
		this.registroId = registroId;
	}

	public Date getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public String getContenuto() {
		return contenuto;
	}

	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
	}

	public String getTutorAziendaleEmail() {
		return tutorAziendaleEmail;
	}

	public void setTutorAziendaleEmail(String tutorAziendaleEmail) {
		this.tutorAziendaleEmail = tutorAziendaleEmail;
	}
	
	
	
}
