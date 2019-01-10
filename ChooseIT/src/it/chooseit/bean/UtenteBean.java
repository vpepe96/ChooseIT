package it.chooseit.bean;

import java.io.Serializable;
import java.sql.Date;

/**
 * Un oggetto UtenteBean rappresenta un utente loggato al sistema ChooseIT.
 * Un utente ha una email, un nome, un cognome, un numero di telefono, un indirizzo,
 * una data di nascita e una foto del profilo. 
 * Ogni campo &egrave; rappresentato con la propria variabile di istanza.
 * 
 * @author RocketStudios
 */
public class UtenteBean implements Serializable{

  private static final long serialVersionUID = 1L;

  /**
   * Rappresenta la email di un utente.
   */
  private String email;
  /**
   * Rappresenta il nome di un utente.
   */
  private String nome;
  /**
   * Rappresenta il cognome di un utente.
   */
  private String cognome;
  /**
   * Rappresenta il numero di telefono di un utente.
   */
  private String telefono;
  /**
   * Rappresenta l'indirizzo di un utente.
   */
  private String indirizzo;
  /**
   * Rappresenta la data di nascita di un utente.
   */
  private Date dataNascita;
  /**
   * Rappresenta il path della foto di profilo di un utente.
   */
  private String fotoProfilo;

  /**
   * Costruttore vuoto di UtenteBean.
   */
  public UtenteBean() { }

  /**
   * Costruttore di UtenteBean.
   * 
   * @param email email dell'utente.
   * @param nome nome dell'utente.
   * @param cognome cognome dell'utente.
   * @param telefono telefono dell'utente.
   * @param indirizzo indirizzo  dell'utente.
   * @param dataNascita data di nascita dell'utente.
   * @param fotoProfilo path della foto del profilo dell'utente.
   */
  public UtenteBean(String email, String nome, String cognome, String telefono, String indirizzo, Date dataNascita, String fotoProfilo) {
    this.email = email;
    this.nome = nome;
    this.cognome = cognome;
    this.telefono = telefono;
    this.indirizzo = indirizzo;
    this.dataNascita = dataNascita;
    this.fotoProfilo = fotoProfilo;
  }

  /*
    |--------------------------------------------------------------------------
    | Interfaccia pubblica
    |--------------------------------------------------------------------------
   */

  /**
   * Restituisce la email dell'utente.
   * 
   * @return email email dell'utente.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Setta una nuova email per utente.
   * 
   * Pre: email != null.
   * @param email nuova email per utente.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Restituisce il nome dell'utente.
   * 
   * @return nome nome dell'utente.
   */
  public String getNome() {
    return nome;
  }

  /**
   * Setta un nuovo nome per l'utente.
   * 
   * Pre: nome != null.
   * @param nome nuovo nome per l'utente.
   */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * Restituisce il cognome dell'utente.
   * 
   * @return cognome cognome dell'utente.
   */
  public String getCognome() {
    return cognome;
  }

  /**
   * Setta un nuovo cognome per l'utente.
   * 
   * Pre: cognome != null.
   * @param cognome nuovo cognome dell'utente.
   */
  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  /**
   * Restituisce il numero di telefono dell'utente.
   * 
   * @return telefono numero di telefono dell'utente.
   */
  public String getTelefono() {
    return telefono;
  }

  /**
   * Setta un nuovo numero di telefono per l'utente.
   * 
   * Pre: telefono != null.
   * @param telefono nuovo numero di telefono dell'utente.
   */
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  /**
   * Restituisce l'indirizzo dell'utente.
   * 
   * @return indirizzo indirizzo dell'utente.
   */
  public String getIndirizzo() {
    return indirizzo;
  }

  /**
   * Setta un nuovo indirizzo per l'utente.
   * 
   * Pre: indirizzo != null.
   * @param indirizzo nuovo indirizzo per l'utente.
   */
  public void setIndirizzo(String indirizzo) {
    this.indirizzo = indirizzo;
  }

  /**
   * Restituisce la data di nascita dell'utente.
   * 
   * @return dataNascita data di nascita dell'utente.
   */
  public Date getDataNascita() {
    return dataNascita;
  }

  /**
   * Setta una nuova data di nascita per l'utente.
   * 
   * Pre: dataNascita != null.
   * @param dataNascita nuova data di nascita per l'utente.
   */
  public void setDataNascita(Date dataNascita) {
    this.dataNascita = dataNascita;
  }

  /**
   * Restituisce il path della foto del profilo dell'utente.
   * 
   * @return fotoProfilo path della foto del profilo.
   */
  public String getFotoProfilo() {
    return fotoProfilo;
  }

  /**
   * Setta un nuovo path per la foto del profilo dell'utente.
   * 
   * Pre: fotoProfilo != null.
   * @param fotoProfilo nuovo path dell foto del profilo.
   */
  public void setFotoProfilo(String fotoProfilo) {
    this.fotoProfilo = fotoProfilo;
  }

}