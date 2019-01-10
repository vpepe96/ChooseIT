package it.chooseit.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Un oggetto StudenteBean rappresenta uno studente dell'Universit&agrave;; degli Studi di Salerno,
 * iscritto alla piattaforma ChooseIT. 
 * Un oggetto StudenteBean &egrave; anche {@inheritDoc}. 
 * Inoltre, ha una matricola, rappresentata dalla variabile d'istanza matricola, una descrizione del 
 * proprio profilo personale, rappresentata dalla variabile d'istanza descrizione,una lista di registri 
 * di tirocinio, rappresentata dalla variabile d'isanza registriTirocinio, e una lista di richieste di 
 * tirocinio, rappresentata dalla variabile d'istanza richiesteTirocinio.
 *
 * @author RocketStudios
 */
public class StudenteBean extends UtenteBean implements Serializable{

  private static final long serialVersionUID = 1L;

  /**
   * Rappresenta la matricola dello studente.
   */
  private String matricola;
  /**
   * Rappresenta la descrizione del profilo personale dello studente.
   */
  private String descrizione;

  /**
   * Rappresenta la lista di tutti i registri di tirocinio dello studente.
   */
  private ArrayList <RegistroTirocinioBean> registriTirocinio;

  /**
   * Rappresenta la lista di tutte le richieste di tirocinio dello studente
   */
  private ArrayList <RichiestaTirocinioBean> richiesteTirocinio;

  /**
   * Costruttore vuoto di StudenteBean.
   */
  public StudenteBean() { }

  /**
   * Costruttore di StudenteBean.
   * 
   * @param email email dello studente.
   * @param nome nome dello studente.
   * @param cognome cognome dello studente.
   * @param telefono numero di telefono dello studente.
   * @param indirizzo indirizzo dello studente.
   * @param dataNascita data di nascita dello studente.
   * @param fotoProfilo path della foto di profilo dello studente.
   * @param matricola matricola dello studente.
   * @param descrizione descrizione del profilo personale dello studente.
   * @param registriTirocinio lista dei registri di tirocinio dello studente
   * @param richiesteTirocinio lista delle richieste di tirocinio dello studente
   */
  public StudenteBean(String email, String nome, String cognome, String telefono, String indirizzo, Date dataNascita, String fotoProfilo, String matricola, String descrizione, ArrayList <RegistroTirocinioBean> registriTirocinio, ArrayList <RichiestaTirocinioBean> richiesteTirocinio) {
    super(email, nome, cognome, telefono, indirizzo, dataNascita, fotoProfilo);
    this.matricola = matricola;
    this.descrizione = descrizione;
    this.registriTirocinio = registriTirocinio;
    this.richiesteTirocinio = richiesteTirocinio;
  }

  /*
    |--------------------------------------------------------------------------
    | Interfaccia pubblica
    |--------------------------------------------------------------------------
   */

  /**
   * Restituisce la matricola dello studente.
   * 
   * @return matricola matricola dello studente.
   */
  public String getMatricola() {
    return matricola;
  }

  /**
   * Setta una nuova matricola per lo studente
   * 
   * Pre: matricola != null.
   * @param matricola nuova matricola per lo studente.
   */
  public void setMatricola(String matricola) {
    this.matricola = matricola;
  }

  /**
   * Restituisce la descrizione del profilo personale dello studente.
   * 
   * @return descrizione del profilo personale dello studente.
   */
  public String getDescrizione() {
    return descrizione;
  }

  /**
   * Setta una nuova descrizione per il profilo personale dello studente.
   * 
   * Pre: descrizione != null.
   * @param descrizione nuova descrizione del profilo personale dello studente.
   */
  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  /**
   * Restituisce la lista dei registri di tirocinio dello studente
   * 
   * @return lista dei registri di tirocinio
   */
  public ArrayList<RegistroTirocinioBean> getRegistriTirocinio() {
    return registriTirocinio;
  }

  /**
   * Setta una nuova lista di registri di tirocinio dello studente
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
   * Aggiunge un registro di tirocinio alla lista dei registri di tirocinio dello studente
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

  /**
   * Restituisce la lista delle richieste di tirocinio dello studente
   * 
   * @return lista delle richieste di tirocinio
   */
  public ArrayList<RichiestaTirocinioBean> getRichiesteTirocinio() {
    return richiesteTirocinio;
  }

  /**
   * Setta una nuova lista di richieste di tirocinio dello studente
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
   * Aggiunge una richiesta di tirocinio alla lista delle richieste di tirocinio dello studente
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