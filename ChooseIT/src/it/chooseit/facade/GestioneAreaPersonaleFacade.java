package it.chooseit.facade;

import java.sql.SQLException;

import it.chooseit.bean.StudenteBean;
import it.chooseit.bean.UtenteBean;
import it.chooseit.impl.Studente;
import it.chooseit.impl.Utente;

/**
 * Definisce i metodi per gestire le funzionalit&agrave; relative all&rsquo;area personale.
 */
public class GestioneAreaPersonaleFacade {

  /**
   * Permette ad un utente generico di modificare il proprio profilo.
   * @param utente utente da modificare
   * @return boolean true se la modifica &egrave; avvenuta, false altrimenti 
   * */
  public static boolean modificaProfilo(UtenteBean utente) {
    Utente ut=new Utente();
    try {
      ut.update(utente);
      return true;
    } catch (SQLException e) {
      return false;
    }	
  }

  /**
   * Permette ad uno studente di modificare il proprio profilo.
   * @param studente studente da modificare
   * @return boolean true se la modifica &egrave; avvenuta, false altrimenti 
   * */
  public static boolean modificaProfilo(StudenteBean studente) {
    Studente stud=new Studente();
    Utente ut=new Utente();
    try {
      stud.update(studente);
      ut.update(studente);
      return true;
    } catch (SQLException e) {
      return false;
    }	
  }

}
