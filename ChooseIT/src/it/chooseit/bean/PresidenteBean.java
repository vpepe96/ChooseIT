package it.chooseit.bean;

import java.io.Serializable;
import java.sql.Date;

/**
 * Un oggetto PresidenteBean rappresenta il Presidente dell'Universit&agrave; degli Studi di Salerno, iscritto alla piattaforma ChooseIT.
 * Un oggetto PresidenteBean &egrave; anche {@inheritDoc}.
 * 
 * @author RocketStudios
 */
public class PresidenteBean extends UtenteBean implements Serializable{

  private static final long serialVersionUID = 1L;

  /**
   * Costruttore di PresidenteBean
   * 
   * @param email email del presidente
   * @param nome nome del presidente
   * @param cognome cognome del presidente
   * @param telefono numero telefonico del presidente
   * @param indirizzo indirizzo di residenza del presidente
   * @param dataNascita data di nascita del presidente
   * @param fotoProfilo path della foto del profilo personale del presidente
   */
  public PresidenteBean(String email, String nome, String cognome, String telefono, String indirizzo, Date dataNascita, String fotoProfilo) {
    super(email, nome, cognome, telefono, indirizzo, dataNascita, fotoProfilo);
  }

  /**
   * Costruttore vuoto di PresidenteBean.
   */
  public PresidenteBean() {}

}
