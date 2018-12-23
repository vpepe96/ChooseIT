package it.chooseit.bean;

import java.io.Serializable;
import java.sql.Date;

public class RichiestaTirocinioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String studente_email;
	private Date data_richiesta;
	private String ragione_sociale_azienda;
	private String progetto_formativo;
	private int registro_id;
	
	public RichiestaTirocinioBean(int id, String studente_email, Date data_richiesta, String ragione_sociale_azienda, String progetto_formativo, int registro_id) {
		this.id = id;
		this.studente_email = studente_email;
		this.data_richiesta = data_richiesta;
		this.ragione_sociale_azienda = ragione_sociale_azienda;
		this.progetto_formativo = progetto_formativo;
		this.registro_id = registro_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudenteEmail() {
		return studente_email;
	}

	public void setStudenteEmail(String studente_email) {
		this.studente_email = studente_email;
	}

	public Date getDataRichiesta() {
		return data_richiesta;
	}

	public void setDataRichiesta(Date data_richiesta) {
		this.data_richiesta = data_richiesta;
	}

	public String getRagioneSocialeAzienda() {
		return ragione_sociale_azienda;
	}

	public void setRagioneSocialeAzienda(String ragione_sociale_azienda) {
		this.ragione_sociale_azienda = ragione_sociale_azienda;
	}

	public String getProgettoFormativo() {
		return progetto_formativo;
	}

	public void setProgettoFormativo(String progetto_formativo) {
		this.progetto_formativo = progetto_formativo;
	}

	public int getRegistroId() {
		return registro_id;
	}

	public void setRegistroId(int registro_id) {
		this.registro_id = registro_id;
	}
	
}
