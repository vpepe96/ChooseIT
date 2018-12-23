package it.chooseit.bean;

import java.io.Serializable;
import java.sql.Date;

public class StatoTirocinioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public enum StatoRichiesta {NUOVA, INVALIDAZIONE, INCONVALIDA, ACCETTATA, RIFIUTATA};
	public enum StatoTirocinio {INCORSO, ANNULLATO, TERMINATO};
	
	private int registro_id;
	private Date data_stato;
	private StatoTirocinio tipo;
	
	public StatoTirocinioBean(int registro_id, Date data_stato, StatoTirocinio tipo) {
		this.registro_id = registro_id;
		this.data_stato = data_stato;
		this.tipo = tipo; 
	}

	public int getRegistroId() {
		return registro_id;
	}

	public void setRegistroId(int registro_id) {
		this.registro_id = registro_id;
	}

	public Date getDataStato() {
		return data_stato;
	}

	public void setDataStato(Date data_stato) {
		this.data_stato = data_stato;
	}

	public StatoTirocinio getTipo() {
		return tipo;
	}

	public void setTipo(StatoTirocinio tipo) {
		this.tipo = tipo;
	}

	
	
}
