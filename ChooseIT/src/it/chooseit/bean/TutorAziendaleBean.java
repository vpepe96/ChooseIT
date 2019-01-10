package it.chooseit.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;


/**
 * Un oggetto TutorAziendaleBean rappresenta un tutor di un'azienda convenzionata presso l'Universit&agrave; degli Studi di Salerno,
 * iscritto alla piattaforma ChooseIT. 
 * Un oggetto TutorAziendaleBean &egrave;anche * {@inheritDoc}. 
 * Inoltre, ha un riferimento all'azienda in cui ricopre il ruolo di tutor, rappresentato dalla variabile d'istanza azienda,
 * una lista di report, collegati ad un registro di tirocinio, che deve firmare, rappresentata dalla variabile d'istanza
 * reports, e una lista di tirocini a cui &egrave;stato assegnato, rappresentata dalla varbiale d'istanza registriTirocinio.
 *
 * @author RocketStudios
 */

public class TutorAziendaleBean extends UtenteBean implements Serializable{

  private static final long serialVersionUID = 1L;

  /**
   * Rappresenta l'identificativo dell'azienda del tutor.
   */
  private AziendaBean azienda;

  /**
   * Rappresenta la lista dei report firmati dal tutor 
   */
  private ArrayList<ReportBean> reports;

  /**
   * Rappresenta la lista di tutti i tirocini a cui &egrave;stato assegnato il tutor
   */
  private ArrayList<RegistroTirocinioBean> registriTirocinio;

  /**
   * Costruttore di TutorAziendaleBean.
   * 
   * @param email email del tutor.
   * @param nome nome del tutor.
   * @param cognome cognome del tutor.
   * @param telefono numero di telefono del tutor.
   * @param indirizzo indirizzo del tutor.
   * @param dataNascita data di nascita del tutor.
   * @param fotoProfilo path della foto del profilo del tutor.
   * @param azienda identificativo dell'azienda del tutor.
   * @param reports lista di report firmati dal tutor
   * @param registriTirocinio lista dei registri di tirocinio assegnati al tutor 
   */
  public TutorAziendaleBean(String email, String nome, String cognome, String telefono, String indirizzo, Date dataNascita, String fotoProfilo, AziendaBean azienda, ArrayList<ReportBean> reports, ArrayList<RegistroTirocinioBean> registriTirocinio) {
    super(email, nome, cognome, telefono, indirizzo, dataNascita, fotoProfilo);
    this.azienda = azienda;
    this.reports = reports;
    this.registriTirocinio = registriTirocinio;
  }

  /**
   * Costruttore vuoto di TutorAziendaleBean.
   */
  public TutorAziendaleBean() {}

  /**
   * Restituisce l'azienda per cui lavora TutorAziendaleBean.
   * 
   * @return azienda per cui lavora il tutor aziendale.
   */
  public AziendaBean getAzienda() {
    return azienda;
  }

  /**
   * Setta una nuova azienda per il tutor aziendale.
   * 
   * Pre: azienda != null;
   * @param azienda nuova azienda del tutor aziendale.
   */
  public void setAzienda(AziendaBean azienda) {
    this.azienda = azienda;
  }

  /**
   * Restituisce la lista dei report firmati dal tutor aziendale
   * 
   * @return lista dei report
   */
  public ArrayList<ReportBean> getReports() {
    return reports;
  }

  /**
   * Setta una nuova lista di report firmati dal tutor aziendale
   *
   * @param reports nuova lista dei report
   */
  public void setReports(ArrayList<ReportBean> reports) {
    this.reports = reports;
  }

  /**
   * Restituisce il report con la data d'inserimento specificata
   * 
   * Pre: data != null && reports[0] <= data <= reports[N-1]
   * @param data data d'inserimento del report desiderato
   * @return report con data d'inserimento specificata
   */
  public ReportBean getReport(Date data) {

    for(ReportBean r: reports) {
      if(r.getDataInserimento().equals(data))
        return r;
    }

    return null;
  }

  /**
   * Aggiunge un report alla lista dei report firmati dal tutor aziendale
   * 
   * @param report report da aggiungere
   */
  public void addReport(ReportBean report) {
    reports.add(report);
  }

  /**
   * Sostituisce il report con la data d'inserimento specificata con un nuovo report
   *  
   * Pre: data != null && reports[0] <= data <= reports[N-1] 
   * @param data data d'inserimento del report da sostituire
   * @param report nuovo report 
   */
  public void setReport(Date data, ReportBean report) {
    int i = 0;

    for(ReportBean r: reports) {
      if(r.getDataInserimento().equals(data)) 
        reports.set(i, report);
      i++;
    }
  }

  /**
   * Restituisce la lista dei registri di tirocinio assegnati al tutor
   * 
   * @return lista dei registri di tirocinio
   */
  public ArrayList<RegistroTirocinioBean> getRegistriTirocinio() {
    return registriTirocinio;
  }

  /**
   * Setta una nuova lista di registri di tirocinio assegnati al tutor
   *
   * @param registriTirocinio lista dei registri di tirocinio
   */
  public void setRegistriTirocinio(ArrayList<RegistroTirocinioBean> registriTirocinio) {
    this.registriTirocinio = registriTirocinio;
  }

  /**
   * Restituisce il registro di tirocinio con l'identificativo specificato
   * 
   * Pre: identificativo != null && registriTirocinio[0] <= identificativo <= registriTirocinio[N-1]
   * @param identificativo identificativo del registro di tirocinio
   * @return registro di tirocinio con identificativo specificato
   */
  public RegistroTirocinioBean getRegistroTirocinio(int identificativo) {
    for(RegistroTirocinioBean r: registriTirocinio) {
      if(r.getIdentificativo() == identificativo)
        return r;

    }
    return null;
  }

  /**
   * Aggiunge un registro di tirocinio alla lista dei registri di tirocinio assegnati al tutor
   * 
   * @param registroTirocinio registro di tirocinio da aggiungere
   */
  public void addRegistroTirocinio(RegistroTirocinioBean registroTirocinio) {
    registriTirocinio.add(registroTirocinio);
  }

  /**
   * Sostituisce il registro di tirocinio con l'identificativo specificato con un nuovo registro di tirocinio
   * 
   * Pre: identificativo != null && registriTirocinio[0] <= identificativo <= registriTirocinio[N-1] 
   * @param identificativo identificativo del registro di tirocinio da sostituire
   * @param registroTirocinio nuovo registro di tirocinio
   */
  public void setRegistroTirocinio(int identificativo, RegistroTirocinioBean registroTirocinio) {
    int i = 0;

    for(RegistroTirocinioBean r: registriTirocinio) {
      if(r.getIdentificativo() == identificativo) 
        registriTirocinio.set(i, registroTirocinio);
      i++;
    }
  }


}