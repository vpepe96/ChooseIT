package it.chooseit.bean;

import java.io.Serializable;
import java.sql.Date;

/**
 * Un oggetto StatoRichiestaBean rappresenta lo stato di una richiesta di tirocinio.
 * Uno stato ha una data, rappresentata con la variabile d'istanza dataStato, ha un tipo, rappresentato
 * con la variabile d'istanza tipo e l'identificativo della richiesta di tirocinio, rappresentato con la 
 * variabile d'istanza richiestaTirocinio.
 * 
 * @author RocketStudios
 */

public class StatoRichiestaBean implements Serializable{

  private static final long serialVersionUID = 1L;

  public enum StatoRichiesta {NUOVA, INVALIDAZIONE, INCONVALIDA, ACCETTATA, RIFIUTATA};

  /**
   * Rappresenta la data in cui la richiesta ha assunto quello stato.
   */
  private Date dataStato;

  /**
   * Rappresenta il tipo della richiesta di tirocinio.
   */
  private StatoRichiesta tipo;

  /**
   * Rappresenta la richiesta di tirocinio.
   */
  private RichiestaTirocinioBean richiestaTirocinio;

  /**
   * Costruttore di StatoRichiestaBean.
   * 
   * @param dataStato data in cui la richiesta ha assunto lo stato specificato.
   * @param tipo tipo assegnato ad una richiesta di tirocinio.
   * @param richiestaTirocinio richiesta di tirocinio.
   */
  public StatoRichiestaBean(Date dataStato, StatoRichiesta tipo, RichiestaTirocinioBean richiestaTirocinio) {
    this.dataStato = dataStato;
    this.tipo = tipo;
    this.richiestaTirocinio = richiestaTirocinio;
  }

  /**
   * Costruttore vuoto di StatoRichiestaBean.
   */
  public StatoRichiestaBean() {}

  /*
    |--------------------------------------------------------------------------
    | Interfaccia pubblica
    |--------------------------------------------------------------------------
   */

  /**
   * Restituisce la data dell'assegnamento dello stato ad una richiesta di tirocinio.
   * 
   * @return dataStato data dell'assegnamento dello stato.
   */
  public Date getDataStato() {
    return dataStato;
  }

  /**
   * Setta una nuova data per StatoRichiestaBean.
   * 
   * Pre: dataStato != null.
   * @param dataStato nuova data dello stato.
   */
  public void setDataStato(Date dataStato) {
    this.dataStato = dataStato;
  }

  /**
   * Restituisce il tipo di stato dello StatoReportBean.
   * 
   * @return tipo tipo di stato.
   */
  public StatoRichiesta getTipo() {
    return tipo;
  }

  /**
   * Setta un nuovo tipo per StatoRichiestaBean.
   * 
   * Pre: tipo != null.
   * @param tipo nuovo tipo dello stato.
   */
  public void setTipo(StatoRichiesta tipo) {
    this.tipo = tipo;
  }

  /**
   * Restituisce la richiesta di tirocinio.
   * 
   * @return richiesta di tirocinio.
   */
  public RichiestaTirocinioBean getRichiestaTirocinio() {
    return richiestaTirocinio;
  }

  /**
   * Setta una nuova richiesta di tirocinio.
   * 
   * Pre: richiestaId != null.
   * @param richiestaTirocinio nuova richiesta di tirocinio.
   */
  public void setRichiestaId(RichiestaTirocinioBean richiestaTirocinio) {
    this.richiestaTirocinio = richiestaTirocinio;
  }

}