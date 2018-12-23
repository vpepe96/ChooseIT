package it.chooseit.bean;

import java.io.Serializable;
import java.sql.Date;

public class StatoRichiestaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public enum StatoRichiesta {NUOVA, INVALIDAZIONE, INCONVALIDA, ACCETTATA, RIFIUTATA};
	
	private Date data_stato;
	private StatoRichiesta tipo;
	private int richiesta_id;
	
	public StatoRichiestaBean(Date data_stato, StatoRichiesta tipo, int richiesta_id) {
		this.data_stato = data_stato;
		this.tipo = tipo;
		this.richiesta_id = richiesta_id;
	}

	public Date getDataStato() {
		return data_stato;
	}

	public void setDataStato(Date data_stato) {
		this.data_stato = data_stato;
	}

	public StatoRichiesta getTipo() {
		return tipo;
	}

	public void setTipo(StatoRichiesta tipo) {
		this.tipo = tipo;
	}

	public int getRichiestaId() {
		return richiesta_id;
	}

	public void setRichiestaId(int richiesta_id) {
		this.richiesta_id = richiesta_id;
	}
		
}
