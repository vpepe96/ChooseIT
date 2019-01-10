package it.chooseit.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

import it.chooseit.bean.StatoRichiestaBean.StatoRichiesta;

/**
 * Un oggetto RichiestaTirocinioBean rappresenta la richiesta di tirocinio, fatta da uno studente, per iniziare un tirocinio 
 * presso un'azienda.
 * Una richiesta di tirocinio ha un identificativo univoco, rappresentato con la variabile d'istanza id, uno studente che
 * effettua la richiesta di tirocinio, rappresentato con la variabile d'istanza studente, la data di effettuazione della
 * richiesta, rappresentata con la variabile d'istanza dataRichiesta, un collegamento all'azienda dove lo studente vorrebbe 
 * svolgere il tirocinio, rappresentato con la variabile d'istanza azienda, il path del progetto formativo che lo studente 
 * compila e carica, rappresentato con la variabile d'istanza progettoFormativo, un collegamento al registro di tirocinio, 
 * che viene rappresentato con la variabile d'istanza registroTirocinio, e una lista di stati, rappresentata con la variabile
 * d'istanza statiRichiesta.
 *  
 * @author RocketStudios
 */
public class RichiestaTirocinioBean implements Serializable{

  private static final long serialVersionUID = 1L;

  /**
   * Rappresenta l'identificativo della richiesta di tirocinio
   */
  private int id;

  /**
   * Rappresenta lo studente che effettua la richiesta di tirocinio
   */
  private StudenteBean studente;

  /**
   * Rappresenta la data di effettuazione della richiesta di tirocinio
   */
  private Date dataRichiesta;

  /**
   * Rappresenta l'azienda scelta dallo studente
   */
  private AziendaBean azienda;

  /**
   * Rappresenta il path del progetto formativo compilato per la richiesta di tirocinio
   */
  private String progettoFormativo;

  /**
   * Rappresenta il registro di tirocinio associato
   */
  private RegistroTirocinioBean registroTirocinio;

  /**
   * Rappresenta il tutor aziendale associato alla richiesta di tirocinio
   */
  private TutorAziendaleBean tutorAziendale;

  /**
   * Rappresenta il tutor universitario associato alla richiesta di tirocinio
   */
  private TutorUniversitarioBean tutorUniversitario;

  /**
   * Rappresenta la lista di stati che assume la richiesta di tirocinio
   */
  private ArrayList<StatoRichiestaBean> statiRichiesta;

  /**
   * Costruttore di RichiestaTirocinioBean
   * 
   * @param id identificativo della richiesta di tirocinio
   * @param studente studente che effettua la richiesta di tirocinio
   * @param dataRichiesta data di effettuazione della richiesta
   * @param azienda azienda selezionata
   * @param progettoFormativo path del progetto formativo compilato per la richiesta
   * @param registroTirocinio registro di tirocinio associato
   * @param statiRichiesta lista dei stati della richiesta di tirocinio 
   */
  public RichiestaTirocinioBean(int id, StudenteBean studente, Date dataRichiesta, AziendaBean azienda, String progettoFormativo, RegistroTirocinioBean registroTirocinio, TutorAziendaleBean tutorAziendale, TutorUniversitarioBean tutorUniversitario, ArrayList<StatoRichiestaBean> statiRichiesta) {
    this.id = id;
    this.studente = studente;
    this.dataRichiesta = dataRichiesta;
    this.azienda = azienda;
    this.progettoFormativo = progettoFormativo;
    this.registroTirocinio = registroTirocinio;
    this.tutorAziendale = tutorAziendale;
    this.tutorUniversitario = tutorUniversitario;
    this.statiRichiesta = statiRichiesta;
  }


  /**
   * Costruttore vuoto di RichiestaTirocinioBean.
   */
  public RichiestaTirocinioBean() {}

  /*
    |--------------------------------------------------------------------------
    | Interfaccia pubblica
    |--------------------------------------------------------------------------
   */

  /**
   * Restituisce l'identificativo di RichiestaTirocinioBean
   * 
   * @return identificativo della richiesta di tirocinio 
   */
  public int getId() {
    return id;
  }

  /**
   * Setta un nuovo identificativo per RichiestaTirocinioBean
   * 
   * Pre: id != null
   * @param id nuovo identificativo per le richiesta di tirocinio
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Restituisce lo studente che effettua la richiesta relativa a RichiestaTirocinioBean
   * 
   * @return studente che effettua la richiesta di tirocinio
   */
  public StudenteBean getStudente() {
    return studente;
  }

  /**
   * Setta un nuovo studente che effettua la richiesta relativa a RichiestaTirocinioBean
   * 
   * Pre: studente != null
   * @param studente nuovo studente che effettua la richiesta di tirocinio
   */
  public void setStudente(StudenteBean studente) {
    this.studente = studente;
  }

  /**
   * Restituisce la data di effettuazione di RichiestaTirocinioBean
   * 
   * @return data di effettuazione della richiesta di tirocinio
   */
  public Date getDataRichiesta() {
    return dataRichiesta;
  }

  /**
   * Setta una nuova data di effettuazione di RichiestaTirocinioBean
   *
   * Pre: dataRichiesta != null
   * @param dataRichiesta nuova data di effettuazione della richiesta di tirocinio
   */
  public void setDataRichiesta(Date dataRichiesta) {
    this.dataRichiesta = dataRichiesta;
  }

  /**
   * Restituisce l'azienda di RichiestaTirocinioBean
   * 
   * @return azienda scelta per la richiesta di tirocinio
   */
  public AziendaBean getAzienda() {
    return azienda;
  }

  /**
   * Setta una nuova azienda di RichiestaTirocinioBean
   * 
   * Pre: azienda != null
   * @param azienda nuova azienda selezionata per la richiesta di tirocinio
   */
  public void setAzienda(AziendaBean azienda) {
    this.azienda = azienda;
  }

  /**
   * Restituisce la path del progetto formativo di RichiestaTirocinioBean
   * 
   * @return path del progetto formativo della richiesta di tirocinio
   */
  public String getProgettoFormativo() {
    return progettoFormativo;
  }

  /**
   * Setta un nuovo path per il progetto formativo di RichiestaTirocinioBean
   * 
   * Pre: progettoFormativo != null
   * @param progettoFormativo nuova path del progetto formativo della richiesta di tirocinio
   */
  public void setProgettoFormativo(String progettoFormativo) {
    this.progettoFormativo = progettoFormativo;
  }

  /**
   * Restituisce il registro di tirocinio di RichiestaTirocinioBean
   * 
   * @return registro di tirocinio associato alla richiesta di tirocinio
   */
  public RegistroTirocinioBean getRegistroTirocinio() {
    return registroTirocinio;
  }

  /**
   * Setta un nuovo registro di tirocinio di RichiestaTirocinioBean
   * 
   * Pre: registroTirocinio != null
   * @param registroTirocinio nuovo registro di tirocinio associato
   */
  public void setRegistroTirocinio(RegistroTirocinioBean registroTirocinio) {
    this.registroTirocinio = registroTirocinio;
  }

  /**
   * Restituisce il tutor aziendale associato alla richiesta di tirocinio
   * 
   * @return tutor aziendale associato
   */
  public TutorAziendaleBean getTutorAziendale() {
    return tutorAziendale;
  }

  /**
   * Setta un nuovo tutor aziendale associato per la richiesta di tirocinio
   * 
   * @param tutorAziendale nuovo tutor aziendale
   */
  public void setTutorAziendale(TutorAziendaleBean tutorAziendale) {
    this.tutorAziendale = tutorAziendale;
  }

  /**
   * Restituisce il tutor universitario associato alla richiesta di tirocinio
   * 
   * @return tutor universitario associato
   */
  public TutorUniversitarioBean getTutorUniversitario() {
    return tutorUniversitario;
  }

  /**
   * Setta un nuovo tutor universitario associato per la richiesta di tirocinio
   * 
   * @param tutorUniversitario nuovo tutor universitario
   */
  public void setTutorUniversitario(TutorUniversitarioBean tutorUniversitario) {
    this.tutorUniversitario = tutorUniversitario;
  }

  /**
   * Restituisce la lista degli stati della richiesta di tirocinio
   * 
   * @return lista degli stati della richiesta
   */
  public ArrayList<StatoRichiestaBean> getStatiRichiesta() {
    return statiRichiesta;
  }

  /**
   * Setta una nuova lista degli stati della richiesta di tirocinio
   *
   * @param statiRichiesta nuova lista degli stati della richiesta di tirocinio
   */
  public void setStatiRichiesta(ArrayList<StatoRichiestaBean> statiRichiesta) {
    this.statiRichiesta = statiRichiesta;
  }

  /**
   * Restituisce lo stato con il tipo specificato
   * 
   * Pre: tipo != null && statiRichiesta[0] <= tipo <= statiRichiesta[N-1]
   * @param tipo tipo di stato della richiesta di tirocinio
   * @return stato della richiesta di tirocinio con tipo specificato
   */
  public StatoRichiestaBean getStatoRichiesta(StatoRichiesta tipo) {

    for(StatoRichiestaBean s: statiRichiesta) {
      if(s.getTipo().equals(tipo))
        return s;
    }

    return null;
  }

  /**
   * Aggiunge uno stato alla lista di stati della richiesta di tirocinio
   * 
   * @param statoRichiesta stato della richiesta di tirocinio da aggiungere
   */
  public void addStatoRichiesta(StatoRichiestaBean statoRichiesta) {
    statiRichiesta.add(statoRichiesta);
  }

  /**
   * Sostituisce lo stato della richiesta di tirocinio con data specificata con un nuovo stato 
   * 
   * Pre: data != null && statiRichiesta[0] <= data <= statiRichiesta[N-1] 
   * @param data data di assunzione dello stato della richiesta di tirocinio
   * @param statoRichiesta nuovo stato della richiesta di tirocinio
   */
  public void setStatoRichiesta(Date data, StatoRichiestaBean statoRichiesta) {
    int i = 0;

    for(StatoRichiestaBean s: statiRichiesta) {
      if(s.getDataStato().equals(data)) 
        statiRichiesta.set(i, statoRichiesta);
      i++;
    }
  }

}
