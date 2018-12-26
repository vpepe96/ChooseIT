package it.chooseit.bean;

/**
 * Un oggetto StatoTirocinioBean rappresenta lo stato di un tirocinio. Uno stato ha
 * un identificativo per il registro associato a quel tirocinio, che viene rappresentato con
 * la variabile d'istanza registroId, ha una data, che viene rappresentata con la variabile
 * d'istanza dataStato, ha un tipo, che viene rappresentato con la variabile d'istanza tipo.
 * 
 * @author RocketStudios
 */

import java.io.Serializable;
import java.sql.Date;

public class StatoTirocinioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public enum StatoRichiesta {NUOVA, INVALIDAZIONE, INCONVALIDA, ACCETTATA, RIFIUTATA};
	public enum StatoTirocinio {INCORSO, ANNULLATO, TERMINATO};
	
	/**
	 * Rappresenta l'identificativo del registro di tirocinio.
	 */
	private int registroId;
	/**
	 * Rappresenta la data in cui è stato assegnato lo stato al tirocinio.
	 */
	private Date dataStato;
	/**
	 * Rappresenta il tipo di stato del tirocinio.
	 */
	private StatoTirocinio tipo;
	
	/**
	 * Costruttore di StatoTirocinioBean.
	 * 
	 * @param registroId identificativo del registro di tirocinio.
	 * @param dataStato data in cui il tirocinio ha assunto uno stato.
	 * @param tipo tipo di stato assegnato al tirocinio.
	 */
	public StatoTirocinioBean(int registroId, Date dataStato, StatoTirocinio tipo) {
		this.registroId = registroId;
		this.dataStato = dataStato;
		this.tipo = tipo; 
	}

	/*
    |--------------------------------------------------------------------------
    | Interfaccia pubblica
    |--------------------------------------------------------------------------
    */
	
	/**
	 * Restituisce l'identificativo del registro associato al tirocinio.
	 * 
	 * @return registroId identificativo del registro di tirocinio.
	 */
	public int getRegistroId() {
		return registroId;
	}

	/**
	 * Setta un nuovo identificativo per il registro di tirocinio.
	 * 
	 * Pre: registroId != null.
	 * @param registroId nuovo identificativo del registro di tirocinio.
	 */
	public void setRegistroId(int registroId) {
		this.registroId = registroId;
	}

	/**
	 * Restituisce la data in cui il tirocinio ha assunto lo stato.
	 * 
	 * @return dataStato data dell'assegnamento dello stato del tirocinio.
	 */
	public Date getDataStato() {
		return dataStato;
	}

	/**
	 * Setta una nuova data per l'assegnamento di uno stato.
	 * 
	 * Pre: dataStato != null.
	 * @param dataStato nuova data dello stato.
	 */
	public void setDataStato(Date dataStato) {
		this.dataStato = dataStato;
	}

	/**
	 * Restituisce il tipo di stato di StatoTirocinioBean.
	 * 
	 * @return tipo tipo dello stato.
	 */
	public StatoTirocinio getTipo() {
		return tipo;
	}

	/**
	 * Setta un nuovo tipo per StatoTirocinioBean.
	 * 
	 * Pre: tipo != null.
	 * @param tipo nuovo tipo dello stato.
	 */
	public void setTipo(StatoTirocinio tipo) {
		this.tipo = tipo;
	}
	
}