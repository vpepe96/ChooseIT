package it.chooseit.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

import it.chooseit.bean.StatoReportBean.StatoReport;


/**
 * Un oggetto ReportBean rappresenta report generico sull'attivit&agrave; lavorativa odierna svolta da un tirocinante presso un'azienda.
 * Un report ha un collegamento al registro di tirocinio, rappresentato con la variabile d'istanza registroTirocinio, una data 
 * d'inserimento, rappresentata con la variabile d'istanza dataInserimento, un file, rappresentato con la variabile d'istanza 
 * path, un tutor aziendale, rappresentato con la variabile d'istanza tutorAziendale, e una lista di stati, rappresentata con
 * la variabile d'istanza statiReport.
 *  
 * @author RocketStudios
 */

public class ReportBean implements Serializable{

  private static final long serialVersionUID = 1L;

  /**
   * Rappresenta il registro di tirocinio di cui fa parte il report
   */
  private RegistroTirocinioBean registroTirocinio;

  /**
   * Rappresenta la data d'insetimento del report 
   */
  private Date dataInserimento;

  /**
   * Rappresenta il path del file del report
   */
  private String path;

  /**
   * Rappresenta il tutor aziendale associato al registro di tirocinio che contiene il report
   */
  private TutorAziendaleBean tutorAziendale;

  /**
   * Rappresenta la lista degli stati del report
   */
  private ArrayList<StatoReportBean> statiReport;

  /**
   * Costruttore di ReportBean
   * 
   * @param registroTirocinio registro di tirocinio che contiene il report
   * @param dataInserimento data d'inserimento del report
   * @param path path per il file del report
   * @param tutorAziendale tutor aziendale associato al report
   * @param statiReport lista degli stati del report
   */
  public ReportBean(RegistroTirocinioBean registroTirocinio, Date dataInserimento, String path, TutorAziendaleBean tutorAziendale, ArrayList<StatoReportBean> statiReport) {
    this.registroTirocinio = registroTirocinio;
    this.dataInserimento = dataInserimento;
    this.path = path;
    this.tutorAziendale = tutorAziendale;
    this.statiReport = statiReport;
  }


  /**
   * Costruttore vuoto di ReportBean.
   */
  public ReportBean() {}
  /*
    |--------------------------------------------------------------------------
    | Interfaccia pubblica
    |--------------------------------------------------------------------------
   */

  /**
   * Restituisce il registro di tirocinio che contiene ReportBean
   * 
   * @return registro di tirocinio 
   */
  public RegistroTirocinioBean getRegistroTirocinio() {
    return registroTirocinio;
  }

  /**
   * Setta un nuovo registro di tirocinio che contiene ReportBean
   * 
   * Pre: registroTirocinio != null
   * @param registroTirocinio nuovo registro di tirocinio
   */
  public void setRegistroTirocinio(RegistroTirocinioBean registroTirocinio) {
    this.registroTirocinio = registroTirocinio;
  }

  /**
   * Restituisce la data d'inserimento di ReportBean
   * 
   * @return data d'inserimento del report
   */
  public Date getDataInserimento() {
    return dataInserimento;
  }

  /**
   * Setta una nuova data d'inserimento d'inserimento di ReportBean
   * 
   * Pre: dataInserimento != null
   * @param dataInserimento nuova data d'inserimento del report
   */
  public void setDataInserimento(Date dataInserimento) {
    this.dataInserimento = dataInserimento;
  }

  /**
   * Restituisce il path per il file di ReportBean
   * 
   * @return descrizione del report
   */
  public String getPath() {
    return path;
  }

  /**
   * Setta un nuovo path per il file di ReportBean
   * 
   * Pre: path != null
   * @param path nuovo path del file del report
   */
  public void setPath(String path) {
    this.path = path;
  }

  /**
   * Restituisce il tutor aziendale assegnato al registro di tirocinio che contiene ReportBean
   * 
   * @return tutor aziendale associato
   */ 
  public TutorAziendaleBean getTutorAziendale() {
    return tutorAziendale;
  }

  /**
   * Setta un nuovo tutor aziendale assegnato al registro di tirocinio che contiene ReportBean
   * 
   * Pre: tutorAziendale != null
   * @param tutorAziendale nuovo tutor aziendale associato
   */
  public void setTutorAziendale(TutorAziendaleBean tutorAziendale) {
    this.tutorAziendale = tutorAziendale;
  }

  /**
   * Restituisce la lista degli stati del report
   * 
   * @return lista degli stati del report
   */
  public ArrayList<StatoReportBean> getStatiReport() {
    return statiReport;
  }

  /**
   * Setta una nuova lista degli stati del report
   *
   * @param statiReport nuova lista degli stati del report
   */
  public void setStatiReport(ArrayList<StatoReportBean> statiReport) {
    this.statiReport = statiReport;
  }

  /**
   * Restituisce lo stato con il tipo specificato
   * 
   * Pre: tipo != null && statiReport[0] <= tipo <= statiReport[N-1]
   * @param tipo tipo di stato del report
   * @return stato del report con tipo specificato
   */
  public StatoReportBean getStatoReport(StatoReport tipo) {

    for(StatoReportBean s: statiReport) {
      if(s.getTipo().equals(tipo))
        return s;
    }

    return null;
  }

  /**
   * Aggiunge uno stato alla lista di stati del report
   * 
   * @param statoReport stato del report da aggiungere
   */
  public void addStatoReport(StatoReportBean statoReport) {
    statiReport.add(statoReport);
  }

  /**
   * Sostituisce lo stato del report con data specificata con un nuovo stato 
   * 
   * Pre: data != null && statiReport[0] <= data <= statiReport[N-1] 
   * @param data data di assunzione dello stato del report
   * @param statoReport nuovo stato del report
   */
  public void setStatoReport(Date data, StatoReportBean statoReport) {
    int i = 0;

    for(StatoReportBean s: statiReport) {
      if(s.getDataStato().equals(data)) 
        statiReport.set(i, statoReport);
      i++;
    }
  }

}