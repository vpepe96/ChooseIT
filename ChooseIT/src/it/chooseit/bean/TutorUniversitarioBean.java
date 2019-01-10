package it.chooseit.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Un oggetto TutorUniveristarioBean rappresenta un tutor universitario dell'Universit&agrave; degli Studi di Salerno
 * iscritto alla piattaforma ChooseIT. 
 * Un oggetto TutorUniversitarioBean &egrave; anche {@inheritDoc}.
 * Inoltre, una lista di tirocini a cui &egrave; stato assegnato, rappresentata dalla varbiale d'istanza registriTirocinio. 
 *
 * @author RocketStudios
 */
public class TutorUniversitarioBean extends UtenteBean implements Serializable{

  private static final long serialVersionUID = 1L;

  /**
   * Rappresenta la lista di tutti i tirocini a cui &egrave; stato assegnato il tutor
   */
  private ArrayList<RegistroTirocinioBean> registriTirocinio;

  /**
   * Costruttore di TutorUniversitarioBean.
   * 
   * @param email email del tutor.
   * @param nome nome del tutor.
   * @param cognome cognome del tutor.
   * @param telefono numero di telefono del tutor.
   * @param indirizzo indirizzo del tutor.
   * @param dataNascita data di nascita del tutor.
   * @param fotoProfilo path della foto del profilo del tutor.
   * @param registriTirocinio lista dei registri di tirocinio assegnati al tutor 
   */
  public TutorUniversitarioBean(String email, String nome, String cognome, String telefono, String indirizzo, Date dataNascita, String fotoProfilo, ArrayList<RegistroTirocinioBean> registriTirocinio) { 
    super(email, nome, cognome, telefono, indirizzo, dataNascita, fotoProfilo);
    this.registriTirocinio = registriTirocinio;
  }


  /**
   * Costruttore vuoto di TutorUniversitarioBean.
   */
  public TutorUniversitarioBean() {}
  /*
    |--------------------------------------------------------------------------
    | Interfaccia pubblica
    |--------------------------------------------------------------------------
   */

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