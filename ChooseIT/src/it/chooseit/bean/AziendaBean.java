package it.chooseit.bean;

import java.io.Serializable;

public class AziendaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String ragioneSociale;
	private String progettoFormativo;
	private String sedeOperativa;
	private String sedeLegale;
	
	public AziendaBean(String ragioneSociale, String progettoFormativo, String sedeOperativa, String sedeLegale) {
		this.ragioneSociale = ragioneSociale;
		this.progettoFormativo = progettoFormativo;
		this.sedeOperativa = sedeOperativa;
		this.sedeLegale = sedeLegale;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getProgettoFormativo() {
		return progettoFormativo;
	}

	public void setProgettoFormativo(String progettoFormativo) {
		this.progettoFormativo = progettoFormativo;
	}

	public String getSedeOperativa() {
		return sedeOperativa;
	}

	public void setSedeOperativa(String sedeOperativa) {
		this.sedeOperativa = sedeOperativa;
	}

	public String getSedeLegale() {
		return sedeLegale;
	}

	public void setSedeLegale(String sedeLegale) {
		this.sedeLegale = sedeLegale;
	}
	
	

}