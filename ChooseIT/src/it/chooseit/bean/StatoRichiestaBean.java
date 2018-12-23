package it.chooseit.bean;

import java.io.Serializable;
import java.sql.Date;

public class StatoRichiestaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public enum StatoRichiesta {NUOVA, INVALIDAZIONE, INCONVALIDA, ACCETTATA, RIFIUTATA};
	
	private Date dataStato;
	private StatoRichiesta tipo;
	private int richiestaId;
	
	public StatoRichiestaBean(Date dataStato, StatoRichiesta tipo, int richiestaId) {
		this.dataStato = dataStato;
		this.tipo = tipo;
		this.richiestaId = richiestaId;
	}

	public Date getDataStato() {
		return dataStato;
	}

	public void setDataStato(Date dataStato) {
		this.dataStato = dataStato;
	}

	public StatoRichiesta getTipo() {
		return tipo;
	}

	public void setTipo(StatoRichiesta tipo) {
		this.tipo = tipo;
	}

	public int getRichiestaId() {
		return richiestaId;
	}

	public void setRichiestaId(int richiestaId) {
		this.richiestaId = richiestaId;
	}
		
}
