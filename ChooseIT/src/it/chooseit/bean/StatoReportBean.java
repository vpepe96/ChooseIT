package it.chooseit.bean;

import java.io.Serializable;
import java.sql.Date;

public class StatoReportBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public enum StatoReport {NUOVO, COMPILATO, VALIDATO, RIFIUTATO};
	
	private Date data_stato;
	private StatoReport tipo;
	private Date report_data;
	private int registro_id;
	
	public StatoReportBean(Date data_stato, StatoReport tipo, Date report_data, int registro_id) {
		this.data_stato = data_stato;
		this.tipo = tipo;
		this.report_data = report_data;
		this.registro_id = registro_id;
	}

	public Date getDataSato() {
		return data_stato;
	}

	public void setDataStato(Date data_stato) {
		this.data_stato = data_stato;
	}

	public StatoReport getTipo() {
		return tipo;
	}

	public void setTipo(StatoReport tipo) {
		this.tipo = tipo;
	}

	public Date getReportData() {
		return report_data;
	}

	public void setReportData(Date report_data) {
		this.report_data = report_data;
	}

	public int getRegistroId() {
		return registro_id;
	}

	public void setRegistroId(int registro_id) {
		this.registro_id = registro_id;
	}
		
}
