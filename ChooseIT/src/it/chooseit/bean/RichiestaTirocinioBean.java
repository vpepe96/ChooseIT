package it.chooseit.bean;

import java.io.Serializable;
import java.sql.Date;

public class RichiestaTirocinioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String studenteEmail;
	private Date dataRichiesta;
	private String ragioneSocialeAzienda;
	private String progettoFormativo;
	private int registroId;
	
	public RichiestaTirocinioBean(int id, String studenteEmail, Date dataRichiesta, String ragioneSocialeAzienda, String progettoFormativo, int registroId) {
		this.id = id;
		this.studenteEmail = studenteEmail;
		this.dataRichiesta = dataRichiesta;
		this.ragioneSocialeAzienda = ragioneSocialeAzienda;
		this.progettoFormativo = progettoFormativo;
		this.registroId = registroId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudenteEmail() {
		return studenteEmail;
	}

	public void setStudenteEmail(String studenteEmail) {
		this.studenteEmail = studenteEmail;
	}

	public Date getDataRichiesta() {
		return dataRichiesta;
	}

	public void setDataRichiesta(Date dataRichiesta) {
		this.dataRichiesta = dataRichiesta;
	}

	public String getRagioneSocialeAzienda() {
		return ragioneSocialeAzienda;
	}

	public void setRagioneSocialeAzienda(String ragioneSocialeAzienda) {
		this.ragioneSocialeAzienda = ragioneSocialeAzienda;
	}

	public String getProgettoFormativo() {
		return progettoFormativo;
	}

	public void setProgettoFormativo(String progettoFormativo) {
		this.progettoFormativo = progettoFormativo;
	}

	public int getRegistroId() {
		return registroId;
	}

	public void setRegistroId(int registroId) {
		this.registroId = registroId;
	}
	
}
