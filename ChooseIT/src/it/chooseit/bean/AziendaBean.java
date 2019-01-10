package it.chooseit.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Un oggetto AziendaBean rappresenta un'azienda convenzionata con l'Universit&agrave; degli Studi di Salerno ed iscritta al sistema ChooseIT.
 * Un'azienda ha un nome, rappresentato con la variabile d'istanza ragioneSociale, un progetto formativo, rappresentato con la 
 * variabile d'istanza progettoFormativo, una sede operativa, rappresentata con la variabile d'istanza sedeOperativa, una sede 
 * legale, rappresentata con la variabile d'istanza sedeLegale, una lista di tutor, rappresentata con la variabile d'istanza
 * tutorAziendali, e una lista di richieste di tirocinio, rappresentata con la variabile d'istanza richiesteTirocinio.
 * 
 * @author RocketStudios
 */
public class AziendaBean implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * Rappresenta la ragione sociale dell'azienda
   */
  private String ragioneSociale;

  /**
   * Rappresenta il path del progetto formativo dell'azienda
   */
  private String progettoFormativo;

  /**
   * Rappresenta l'indirizzo della sede operativa dell'azienda
   */
  private String sedeOperativa;

  /**
   * Rappresenta l'indirizzo della sede legale dell'azienda
   */
  private String sedeLegale;

  /**
   * Rappresenta la lista dei tutor che lavorano per l'azienda
   */
  private ArrayList<TutorAziendaleBean> tutorAziendali;

  /**
   * Rappresenta la lista delle richieste di tirocinio in cui viene selezionata l'azienda
   */
  private ArrayList<RichiestaTirocinioBean> richiesteTirocinio;

  /**
   * Costruttore di AziendaBean
   * 
   * @param ragioneSociale ragione sociale dell'azienda
   * @param progettoFormativo path del progetto formativo dell'azienda
   * @param sedeOperativa indirizzo della sede operativa dell'azienda
   * @param sedeLegale indirizzo della sede legale dell'azienda
   * @param tutorAziendali lista dei tutor dell'azienda
   */
  public AziendaBean(String ragioneSociale, String progettoFormativo, String sedeOperativa, String sedeLegale, ArrayList<TutorAziendaleBean> tutorAziendali, ArrayList<RichiestaTirocinioBean> richiesteTirocinio) {
    this.ragioneSociale = ragioneSociale;
    this.progettoFormativo = progettoFormativo;
    this.sedeOperativa = sedeOperativa;
    this.sedeLegale = sedeLegale;
    this.tutorAziendali = tutorAziendali;
    this.richiesteTirocinio = richiesteTirocinio;
  }

  /**
   * Costruttore vuoto di AziendaBean.
   */
  public AziendaBean() {}
  /*
    |--------------------------------------------------------------------------
    | Interfaccia pubblica
    |--------------------------------------------------------------------------
   */

  /**
   * Restituisce la ragione sociale di AziendaBean
   * 
   * @return ragioneSociale ragione sociale 
   */
  public String getRagioneSociale() {
    return ragioneSociale;
  }

  /**
   * Setta una nuova ragione sociale per AziendaBean
   * 
   * Pre: ragioneSociale != null
   * @param ragioneSociale nuova ragione sociale
   */
  public void setRagioneSociale(String ragioneSociale) {
    this.ragioneSociale = ragioneSociale;
  }

  /**
   * Restituisce il path del progetto formativo di AziendaBean
   * 
   * @return progettoFormativo path del progetto formativo 
   */
  public String getProgettoFormativo() {
    return progettoFormativo;
  }

  /**
   * Setta un nuovo path per il progetto formativo di AziendaBean
   * 
   * Pre: progettoFormativo != null
   * @param progettoFormativo nuovo path del progetto formativo 
   */
  public void setProgettoFormativo(String progettoFormativo) {
    this.progettoFormativo = progettoFormativo;
  }

  /**
   * Restituisce l'indirizzo della sede operativa di AziendaBean
   * 
   * @return sedeOperativa indirizzo della sede operativa
   */
  public String getSedeOperativa() {
    return sedeOperativa;
  }

  /**
   * Setta un nuovo indirizzo per la sede operativa di AziendaBean
   * 
   * Pre: sedeOperativa != null
   * @param sedeOperativa nuovo indirizzo della sede operativa
   */
  public void setSedeOperativa(String sedeOperativa) {
    this.sedeOperativa = sedeOperativa;
  }

  /**
   * Restituisce l'indirizzo della sede legale di AziendaBean
   * 
   * @return sedeLegale indirizzo della sede legale
   */
  public String getSedeLegale() {
    return sedeLegale;
  }

  /**
   * Setta un nuovo indirizzo per la sede legale di AziendaBean
   * 
   * Pre: sedeLegale != null
   * @param sedeLegale nuovo indirizzo della sede legale
   */
  public void setSedeLegale(String sedeLegale) {
    this.sedeLegale = sedeLegale;
  }

  /**
   * Restituisce la lista dei tutor dell'azienda
   * 
   * @return lista dei tutor dell'azienda
   */
  public ArrayList<TutorAziendaleBean> getTutorAziendali() {
    return tutorAziendali;
  }

  /**
   * Setta una nuova lista di tutor dell'azienda
   *
   * @param tutorAziendali lista dei tutor aziendali
   */
  public void setTutorAziendali(ArrayList<TutorAziendaleBean> tutorAziendali) {
    this.tutorAziendali = tutorAziendali;
  }

  /**
   * Restituisce il tutor aziendale con l'email specificata
   * 
   * Pre: email != null && tutorAiendali[0] <= email <= tutorAziendali[N-1]
   * @param email email del tutor aziendale
   * @return tutor aziendale con l'email specificata
   */
  public TutorAziendaleBean getTutorAziendale(String email) {

    for(TutorAziendaleBean t: tutorAziendali) {
      if(t.getEmail().equals(email))
        return t;
    }

    return null;
  }

  /**
   * Aggiunge un tutor alla lista dei tutor dell'azienda
   * 
   * @param tutorAziendale tutor aziendale da aggiungere
   */
  public void addTutorAziendale(TutorAziendaleBean tutorAziendale) {
    tutorAziendali.add(tutorAziendale);
  }

  /**
   * Sostituisce il tutor aziendale con l'email specificata con un nuovo tutor aziendale
   * 
   * Pre: email != null && tutorAiendali[0] <= email <= tutorAziendali[N-1] 
   * @param email email del tutor aziendale da sostituire
   * @param tutorAziendale nuovo tutor da aggiungere
   */
  public void setTutorAziendale(String email, TutorAziendaleBean tutorAziendale) {
    int i = 0;

    for(TutorAziendaleBean t: tutorAziendali) {
      if(t.getEmail().equals(email)) 
        tutorAziendali.set(i, tutorAziendale);
      i++;
    }
  }

  /**
   * Restituisce la lista delle richieste di tirocinio in cui &egrave; stata selezionata l'azienda
   * 
   * @return lista delle richieste di tirocinio
   */
  public ArrayList<RichiestaTirocinioBean> getRichiesteTirocinio() {
    return richiesteTirocinio;
  }

  /**
   * Setta una nuova lista di richieste di tirocinio n cui &egrave; stata selezionata l'azienda
   *
   * @param richiesteTirocinio lista di richieste di tirocinio
   */
  public void setRichiesteTirocinio(ArrayList<RichiestaTirocinioBean> richiesteTirocinio) {
    this.richiesteTirocinio = richiesteTirocinio;
  }

  /**
   * Restituisce la richiesta di tirocinio con l'identificativo specificato
   * 
   * Pre: identificativo != null && richiesteTirocinio[0] <= identificativo <= richiesteTirocinio[N-1]
   * @param identificativo identificativo del registro di tirocinio
   * @return richiesta di tirocinio con l'identificativo specificato
   */
  public RichiestaTirocinioBean getRichiestaTirocinio(int identificativo) {
    for(RichiestaTirocinioBean r: richiesteTirocinio) {
      if(r.getId() == identificativo)
        return r;

    }
    return null;
  }

  /**
   * Aggiunge una richiesta di tirocinio alla lista delle richieste di tirocinio n cui &egrave; stata selezionata l'azienda
   * 
   * @param richiestaTirocinio richiesta di tirocinio da aggiungere
   */
  public void addRichiestaTirocinio(RichiestaTirocinioBean richiestaTirocinio) {
    richiesteTirocinio.add(richiestaTirocinio);
  }

  /**
   * Sostituisce la richiesta di tirocinio con l'identificativo specificato con una nuova richiesta di tirocinio
   * 
   * Pre: identificativo != null && richiesteTirocinio[0] <= identificativo <= richiesteTirocinio[N-1] 
   * @param identificativo identificativo della richiesta di tirocinio da sostituire
   * @param richiestaTirocinio nuova richiesta di tirocinio
   */
  public void setRichiestaTirocinio(int identificativo, RichiestaTirocinioBean richiestaTirocinio) {
    int i = 0;

    for(RichiestaTirocinioBean r: richiesteTirocinio) {
      if(r.getId() == identificativo) 
        richiesteTirocinio.set(i, richiestaTirocinio);
      i++;
    }
  }

}