package it.chooseit.bean;

import java.io.Serializable;
import java.sql.Date;


/**
 * Un oggetto StatoTirocinioBean rappresenta lo stato di un tirocinio. Uno stato ha
 * un identificativo per il registro associato a quel tirocinio, rappresentato con
 * la variabile d'istanza registroTirocinio, ha una data, rappresentata con la variabile
 * d'istanza dataStato, ha un tipo, rappresentato con la variabile d'istanza tipo.
 * 
 * @author RocketStudios
 */
public class StatoTirocinioBean implements Serializable{

  private static final long serialVersionUID = 1L;

  public enum StatoTirocinio {INCORSO, ANNULLATO, TERMINATO};

  /**
   * Rappresenta il registro di tirocinio.
   */
  private RegistroTirocinioBean registroTirocinio;

  /**
   * Rappresenta la data in cui &egrave;; stato assegnato lo stato al tirocinio.
   */
  private Date dataStato;

  /**
   * Rappresenta il tipo di stato del tirocinio.
   */
  private StatoTirocinio tipo;

  /**
   * Costruttore di StatoTirocinioBean.
   * 
   * @param registroTirocinio registro di tirocinio.
   * @param dataStato data in cui il tirocinio ha assunto uno stato.
   * @param tipo tipo di stato assegnato al tirocinio.
   */
  public StatoTirocinioBean(RegistroTirocinioBean registroTirocinio, Date dataStato, StatoTirocinio tipo) {
    this.registroTirocinio = registroTirocinio;
    this.dataStato = dataStato;
    this.tipo = tipo; 
  }


  /**
   * Costruttore vuoto di StatoTirocinioBean.
   */
  public StatoTirocinioBean() {}
  /*
    |--------------------------------------------------------------------------
    | Interfaccia pubblica
    |--------------------------------------------------------------------------
   */

  /**
   * Restituisce il registro associato al tirocinio.
   * 
   * @return il registro di tirocinio.
   */
  public RegistroTirocinioBean getRegistroTirocinio() {
    return registroTirocinio;
  }

  /**
   * Setta un nuovo registro di tirocinio.
   * 
   * Pre: registroTirocinio != null.
   * @param registroTirocinio nuovo registro di tirocinio.
   */
  public void setRegistroTirocinio(RegistroTirocinioBean registroTirocinio) {
    this.registroTirocinio = registroTirocinio;
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