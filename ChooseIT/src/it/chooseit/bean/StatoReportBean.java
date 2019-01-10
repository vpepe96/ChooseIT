package it.chooseit.bean;

import java.io.Serializable;
import java.sql.Date;


/**
 * Un oggetto StatoReportBean rappresenta lo stato di un report caricato in un registro di tirocinio.
 * Uno stato ha una data, rappresentata con la variabile d'istanza dataStato, ha un tipo, rappresentato
 * con la variabile d'istanza tipo, una data per il report,rappresentata con la variabile d'istanza reportData, 
 * e l'identificativo del registro di tirocinio di cui fa parte il report, con la variabile d'istanza registroTirocinio.
 * 
 * @author RocketStudios
 */
public class StatoReportBean implements Serializable {

  private static final long serialVersionUID = 1L;

  public enum StatoReport {NUOVO, COMPILATO, VALIDATO, RIFIUTATO};

  /**
   * Rappresenta la data in cui il report ha assunto quello stato.
   */
  private Date dataStato;

  /**
   * Rappresenta il tipo di stato che ha un report.
   */
  private StatoReport tipo;

  /**
   * Rappresenta il report a cui &egrave;; associato lo stato.
   */
  private ReportBean report;

  /**
   * Rappresenta l'identificativo del registro di tirocinio che contiene il report.
   */
  private RegistroTirocinioBean registroTirocinio;

  /**
   * Costruttore di StatoReportBean
   * 
   * @param dataStato data in cui il report ha assunto lo stato specificato.
   * @param tipo tipo di stato assegnato ad un report.
   * @param reportData data di inserimento del report.
   * @param registroTirocinio iregistro di tirocinio che contiene il report.
   */
  public StatoReportBean(Date dataStato, StatoReport tipo, ReportBean report, RegistroTirocinioBean registroTirocinio) {
    this.dataStato = dataStato;
    this.tipo = tipo;
    this.report = report;
    this.registroTirocinio = registroTirocinio;
  }


  /**
   * Costruttore vuoto di StatoReportBean.
   */
  public StatoReportBean() {}
  /*
    |--------------------------------------------------------------------------
    | Interfaccia pubblica
    |--------------------------------------------------------------------------
   */

  /**
   * Restituisce la data dell'assegnamento dello stato ad un report di StatoReportBean.
   * 
   * @return dataStato data dell'assegnamento dello stato.
   */
  public Date getDataStato() {
    return dataStato;
  }

  /**
   * Setta una nuova data per StatoReportBean.
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
  public StatoReport getTipo() {
    return tipo;
  }

  /**
   * Setta un nuovo tipo per StatoReportBean.
   * 
   * Pre: tipo != null.
   * @param tipo nuovo tipo dello stato.
   */
  public void setTipo(StatoReport tipo) {
    this.tipo = tipo;
  }

  /**
   * Restituisce la data d'inserimento del report dei StatoReportBean.
   * 
   * @return report associato allo stato.
   */
  public ReportBean getReport() {
    return report;
  }

  /**
   * Setta un nuovo registro associato allo stato.
   * 
   * Pre: report != null.
   * @param report nuovo report.
   */
  public void setReport(ReportBean report) {
    this.report = report;
  }

  /**
   * Resituisce il registro di tirocinio che contiene il report di StatoReportBean.
   * 
   * @return registro di tirocinio.
   */
  public RegistroTirocinioBean getRegistroTirocinio() {
    return registroTirocinio;
  }

  /**
   * Setta un nuovo registro di tirocinio di StatoReportBean.
   * 
   * Pre: registroTirocinio != null.
   * @param registroTirocinio nuovo registro di tirocinio.
   */
  public void setRegistroTirocinio(RegistroTirocinioBean registroTirocinio) {
    this.registroTirocinio = registroTirocinio;
  }

}