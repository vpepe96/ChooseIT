package it.chooseit.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

import it.chooseit.bean.StatoTirocinioBean.StatoTirocinio;

/**
 * Un oggetto RegistroTirocinioBean rappresenta il registro di tirocinio relativo ad un tirocinio di uno studente presso 
 * un'azienda.
 * Un registro di tirocinio ha un identificativo univoco, rappresentato con la variabile d'istanza identificativo, una 
 * data d'inizio, rappresentata con la variabile d'istanza dataInizio, uno studente, rappresentato con la variabile d'istanza 
 * studente, un tutor aziendale, rappresentato con la variabile d'istanza tutorAziendale, un tutor universitario, rappresentato
 * con la variabile d'istanza tutorUniversitario, una richiesta di tirocinio, rappresentata con la variabile d'istanza 
 * richiestaTirocinio, una lista di report, rappresentata con la variabile d'istanza reports, una lista di stati, rappresentati
 * con la varibile d'istanza statiTirocinio, un questionario sull'azienda, rappresentato con la variabile d'istanza
 * questionarioAzienda, e un questionario sullo studente, rappresentato con la variabile d'istanza questionarioStudente.
 *  
 * @author RocketStudios
 */
public class RegistroTirocinioBean implements Serializable{

  private static final long serialVersionUID = 1L;

  /**
   * Rappresenta l'identificativo del registro di tirocinio
   */
  private int identificativo;

  /**
   * Rappresenta la data in cui comincia il tirocinio e conseguentemente viene creato il registro di tirocinio
   */
  private Date dataInizio;

  /**
   * Rappresenta lo studente tirocinante che detiene il registro di tirocinio
   */
  private StudenteBean studente;

  /**
   * Rappresenta l'email del tutor aziendale che &egrave; stato assegnato al tirocinio a cui si riferisce il registro di tirocinio
   */
  private TutorAziendaleBean tutorAziendale;

  /**
   * Rappresenta l'email del tutor universitario che &egrave; stato assegnato al tirocinio a cui si riferisce il registro di tirocinio
   */
  private TutorUniversitarioBean tutorUniversitario;

  /**
   * Rappresenta la richiesta di tirocinio che comporta la creazione del registro di tirocinio
   */
  private RichiestaTirocinioBean richiestaTirocinio;

  /**
   * Rappresenta la lista dei report contenuti nel registro
   */
  private ArrayList<ReportBean> reports; 

  /**
   * Rappresenta una lista degli stati che assume un tirocinio
   */
  private ArrayList<StatoTirocinioBean> statiTirocinio;

  /**
   * Rappresenta il questionario sull'azineda riferito al tirocinio
   */
  private QuestionarioAziendaBean questionarioAzienda;

  /**
   * Rappresenta il questionario sullo studente riferito al tirocinio
   */
  private QuestionarioStudenteBean questionarioStudente;

  /**
   * Costruttore di RegistroTirocinioBean
   * 
   * @param studente studente associato
   * @param tutorAziendale tutor aziendale associato al registro di tirocinio
   * @param tutorUniversitario tutor universitario associato al registro di tirocinio
   * @param richiestaTirocinio richiesta di tirocinio associata al registro di tirocinio
   */
  public RegistroTirocinioBean(StudenteBean studente, TutorAziendaleBean tutorAziendale, TutorUniversitarioBean tutorUniversitario, RichiestaTirocinioBean richiestaTirocinio) {
    this.studente = studente;
    this.tutorAziendale = tutorAziendale;
    this.tutorUniversitario = tutorUniversitario;
    this.richiestaTirocinio = richiestaTirocinio;
  }

  /**
   * Costruttore di RegistroTirocinioBean
   * 
   * @param identificativo identificativo del registro di tirocinio
   * @param dataInizio data inizio del tirocinio e di creazione del registro di tirocinio
   * @param studente dello studente tirocinante associato al registro di tirocinio
   * @param tutorAziendale tutor aziendale associato al registro di tirocinio
   * @param tutorUniversitario tutor universitario associato al registro di tirocinio
   * @param richiestaTirocinio richiesta di tirocinio associata al registro di tirocinio
   * @param reports lista dei report contenuti nel registro di tirocinio
   * @param statiTirocinio lista degli stati del tirocinio
   * @param questionarioAzienda questionario sull'azienda del tirocinio
   * @param questionarioStudente questionario sullo studente del tirocinio
   */
  public RegistroTirocinioBean(int identificativo, Date dataInizio, StudenteBean studente, TutorAziendaleBean tutorAziendale, TutorUniversitarioBean tutorUniversitario, RichiestaTirocinioBean richiestaTirocinio, ArrayList<ReportBean> reports, ArrayList<StatoTirocinioBean> statiTirocinio, QuestionarioAziendaBean questionarioAzienda, QuestionarioStudenteBean questionarioStudente) {
    this.identificativo = identificativo;
    this.dataInizio = dataInizio;
    this.studente = studente;
    this.tutorAziendale = tutorAziendale;
    this.tutorUniversitario = tutorUniversitario;
    this.richiestaTirocinio = richiestaTirocinio;
    this.reports = reports;
    this.statiTirocinio = statiTirocinio;
    this.questionarioAzienda = questionarioAzienda;
    this.questionarioStudente = questionarioStudente;
  }


  /**
   * Costruttore vuoto di RegistroTirocinioBean.
   */
  public RegistroTirocinioBean() {}

  /*
    |--------------------------------------------------------------------------
    | Interfaccia pubblica
    |--------------------------------------------------------------------------
   */

  /**
   * Restituisce l'identificativo di registro di tirocinio
   * 
   * @return identificativo di registro di tirocinio
   */
  public int getIdentificativo() {
    return identificativo;
  }

  /**
   * Setta l'identificativo di registro di tirocinio
   * 
   * Pre: identificativo != null
   * @param identificativo nuovo identificativo di registro di tirocinio
   */
  public void setIdentificativo(int identificativo) {
    this.identificativo = identificativo;
  }

  /**
   * Restituisce la data d'inizio del tirocinio e di creazione di registro di tirocinio
   * 
   * @return data d'inizio del tirocinio associato e di creazione di registro di tirocinio
   */
  public Date getDataInizio() {
    return dataInizio;
  }

  /**
   * Setta la data d'inizio del tirocinio e di creazione di registro di tirocinio
   * 
   * Pre: dataInizio != null
   * @param dataInizio nuova data d'inizio del tirocinio e di creazione di registro di tirocinio
   */
  public void setDataInizio(Date dataInizio) {
    this.dataInizio = dataInizio;
  }

  /**
   * Restituisce lo studente che detiene registro di tirocinio
   * 
   * @return studente tirocinante
   */
  public StudenteBean getStudente() {
    return studente;
  }

  /**
   * Setta lo studente che detiene registro di tirocinio
   * 
   * Pre: studente != null
   * @param studente nuovo studente tirocinante
   */
  public void setStudente(StudenteBean studente) {
    this.studente = studente;
  }

  /**
   * Restituisce il tutor aziendale associato al registro di tirocinio
   * 
   * @return tutor aziendale associato
   */
  public TutorAziendaleBean getTutorAziendale() {
    return tutorAziendale;
  }

  /**
   * Setta il tutor aziendale associato al registro di tirocinio
   * 
   * Pre: tutorAziendale != null
   * @param tutorAziendale nuovo tutor aziendale associato
   */
  public void setTutorAziendale(TutorAziendaleBean tutorAziendale) {
    this.tutorAziendale = tutorAziendale;
  }

  /**
   * Restituisce il tutor universitario associato al registro di tirocinio
   * 
   * @return tutor universitario associato
   */
  public TutorUniversitarioBean getTutorUniversitario() {
    return tutorUniversitario;
  }

  /**
   * Setta il tutor universitario associato al registro di tirocinio
   * 
   * Pre: tutorUniversitario != null
   * @param tutorUniversitario nuovo tutor universitario associato
   */
  public void setTutorUniversitario(TutorUniversitarioBean tutorUniversitario) {
    this.tutorUniversitario = tutorUniversitario;
  }

  /**
   * Restituisce la richiesta di tircinio che ha portato alla creazione del registro di tirocinio
   * 
   * @return richiesta di tirocinio associata al registro di tirocinio
   */
  public RichiestaTirocinioBean getRichiestaTirocinio() {
    return richiestaTirocinio;
  }

  /**
   * Setta una nuova richiesta di tirocinio associata al registro di tirocinio
   * 
   * @param richiestaTirocinio nuova richiesta di tirocino
   */
  public void setRichiestaTirocinio(RichiestaTirocinioBean richiestaTirocinio) {
    this.richiestaTirocinio = richiestaTirocinio;
  }

  /**
   * Restituisce la lista dei report del registro di tirocinio
   * 
   * @return lista dei report
   */
  public ArrayList<ReportBean> getReports() {
    return reports;
  }

  /**
   * Setta una nuova lista di report contenuta nel registro di tirocinio
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
   * Aggiunge un report alla lista dei report del registro di tirocinio
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
   * Restituisce la lista degli stati del tirocinio
   * 
   * @return lista degli stati del tirocinio
   */
  public ArrayList<StatoTirocinioBean> getStatiTirocinio() {
    return statiTirocinio;
  }

  /**
   * Setta una nuova lista degli stati del tirocinio
   *
   * @param statiTirocinio nuova lista degli stati del tirocinio
   */
  public void setStatiTirocinio(ArrayList<StatoTirocinioBean> statiTirocinio) {
    this.statiTirocinio = statiTirocinio;
  }

  /**
   * Restituisce lo stato con il tipo specificato
   * 
   * Pre: tipo != null && statiTirocinio[0] <= tipo <= statiTirocinio[N-1]
   * @param tipo tipo di stato del tirocinio
   * @return stato del tirocinio con tipo specificato
   */
  public StatoTirocinioBean getStatoTirocinio(StatoTirocinio tipo) {

    for(StatoTirocinioBean s: statiTirocinio) {
      if(s.getTipo().equals(tipo))
        return s;
    }

    return null;
  }

  /**
   * Aggiunge uno stato alla lista di stati del tirocinio
   * 
   * @param statoTirocinio stato del tirocinio da aggiungere
   */
  public void addStatoTirocinio(StatoTirocinioBean statoTirocinio) {
    statiTirocinio.add(statoTirocinio);
  }

  /**
   * Sostituisce lo stato del tirocinio con data specificata con un nuovo stato 
   * 
   * Pre: data != null && statiTirocinio[0] <= data <= statiTirocinio[N-1] 
   * @param data data di assunzione dello stato del tirocinio
   * @param statoTirocinio nuovo stato del tirocinio
   */
  public void setStatoTirocinio(Date data, StatoTirocinioBean statoTirocinio) {
    int i = 0;

    for(StatoTirocinioBean s: statiTirocinio) {
      if(s.getDataStato().equals(data)) 
        statiTirocinio.set(i, statoTirocinio);
      i++;
    }
  }

  /**
   * Restituisce il questionario sull'azienda del tirocinio
   * 
   * @return questionario sull'azienda
   */
  public QuestionarioAziendaBean getQuestionarioAzienda() {
    return questionarioAzienda;
  }

  /**
   * Setta il questionario sull'azienda del tirocinio
   * 
   * Pre questionarioAzienda != null
   * @param questionarioAzienda nuovo questionario sull'azienda
   */
  public void setQuestionarioAzienda(QuestionarioAziendaBean questionarioAzienda) {
    this.questionarioAzienda = questionarioAzienda;
  }

  /**
   * Restituisce il questionario sullo studente del tirocinio
   * 
   * @return questionario sullo studente
   */
  public QuestionarioStudenteBean getQuestionarioStudente() {
    return questionarioStudente;
  }

  /**
   * Setta il questionario sullo studente del tirocinio
   * 
   * Pre questionarioStudente != null
   * @param questionarioStudente nuovo questionario sullo studente
   */
  public void setQuestionarioStudente(QuestionarioStudenteBean questionarioStudente) {
    this.questionarioStudente = questionarioStudente;
  }

}