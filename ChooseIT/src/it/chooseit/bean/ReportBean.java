package it.chooseit.bean;

import java.io.Serializable;
import java.sql.Date;

public class ReportBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int registro_id;
	private Date data_inserimento;
	private String contenuto;
	private String tutor_aziendale_email;
	
	public ReportBean(int registro_id, Date data_inserimento, String contenuto, String tutor_aziendale_email) {
		this.registro_id = registro_id;
		this.data_inserimento = data_inserimento;
		this.contenuto = contenuto;
		this.tutor_aziendale_email = tutor_aziendale_email;
	}

	public int getRegistroId() {
		return registro_id;
	}

	public void setRegistroId(int registro_id) {
		this.registro_id = registro_id;
	}

	public Date getDataInserimento() {
		return data_inserimento;
	}

	public void setDataInserimento(Date data_inserimento) {
		this.data_inserimento = data_inserimento;
	}

	public String getContenuto() {
		return contenuto;
	}

	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
	}

	public String getTutorAziendaleEmail() {
		return tutor_aziendale_email;
	}

	public void setTutorAziendaleEmail(String tutor_aziendale_email) {
		this.tutor_aziendale_email = tutor_aziendale_email;
	}
	
	
	
}
