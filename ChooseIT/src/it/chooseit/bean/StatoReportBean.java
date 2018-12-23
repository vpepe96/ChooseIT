package it.chooseit.bean;

import java.io.Serializable;
import java.sql.Date;

public class StatoReportBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public enum StatoReport {NUOVO, COMPILATO, VALIDATO, RIFIUTATO};
	
	private Date dataStato;
	private StatoReport tipo;
	private Date reportData;
	private int registroId;
	
	public StatoReportBean(Date dataStato, StatoReport tipo, Date reportData, int registroId) {
		this.dataStato = dataStato;
		this.tipo = tipo;
		this.reportData = reportData;
		this.registroId = registroId;
	}

	public Date getDataSato() {
		return dataStato;
	}

	public void setDataStato(Date dataStato) {
		this.dataStato = dataStato;
	}

	public StatoReport getTipo() {
		return tipo;
	}

	public void setTipo(StatoReport tipo) {
		this.tipo = tipo;
	}

	public Date getReportData() {
		return reportData;
	}

	public void setReportData(Date reportData) {
		this.reportData = reportData;
	}

	public int getRegistroId() {
		return registroId;
	}

	public void setRegistroId(int registroId) {
		this.registroId = registroId;
	}
		
}
