package it.chooseit.bean;

import java.io.Serializable;

public class AziendaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String ragione_sociale;
	private String progetto_formativo;
	private String sede_operativa;
	private String sede_legale;
	
	public AziendaBean(String ragione_sociale, String progetto_formativo, String sede_operativa, String sede_legale) {
		this.ragione_sociale = ragione_sociale;
		this.progetto_formativo = progetto_formativo;
		this.sede_operativa = sede_operativa;
		this.sede_legale = sede_legale;
	}

	public String getRagioneSociale() {
		return ragione_sociale;
	}

	public void setRagioneSociale(String ragione_sociale) {
		this.ragione_sociale = ragione_sociale;
	}

	public String getProgettoFormativo() {
		return progetto_formativo;
	}

	public void setProgettoFormativo(String progetto_formativo) {
		this.progetto_formativo = progetto_formativo;
	}

	public String getSedeOperativa() {
		return sede_operativa;
	}

	public void setSedeOperativa(String sede_operativa) {
		this.sede_operativa = sede_operativa;
	}

	public String getSedeLegale() {
		return sede_legale;
	}

	public void setSedeLegale(String sede_legale) {
		this.sede_legale = sede_legale;
	}
	
	

}
