package it.chooseit.bean;

import java.io.Serializable;
import java.sql.Date;

public class StatoTirocinioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public enum StatoRichiesta {NUOVA, INVALIDAZIONE, INCONVALIDA, ACCETTATA, RIFIUTATA};
	public enum StatoTirocinio {INCORSO, ANNULLATO, TERMINATO};
	
	private int registroId;
	private Date dataStato;
	private StatoTirocinio tipo;
	
	public StatoTirocinioBean(int registroId, Date dataStato, StatoTirocinio tipo) {
		this.registroId = registroId;
		this.dataStato = dataStato;
		this.tipo = tipo; 
	}

	public int getRegistroId() {
		return registroId;
	}

	public void setRegistroId(int registroId) {
		this.registroId = registroId;
	}

	public Date getDataStato() {
		return dataStato;
	}

	public void setDataStato(Date dataStato) {
		this.dataStato = dataStato;
	}

	public StatoTirocinio getTipo() {
		return tipo;
	}

	public void setTipo(StatoTirocinio tipo) {
		this.tipo = tipo;
	}

	
	
}
