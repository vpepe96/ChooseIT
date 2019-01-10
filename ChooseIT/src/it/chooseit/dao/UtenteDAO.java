package it.chooseit.dao;

import java.sql.SQLException;

import it.chooseit.bean.UtenteBean;

public interface UtenteDAO extends GenericDAO<UtenteBean, String> {

  /**
   * Controlla che le credenziali inserite durante il login siano corrette e recupera le informazioni dell'utente.
   * @param email l'email inserita durante il login
   * @param pwd la password inserita durante il login
   * @return le informazioni dell'utente se le credenziali sono corrette, null altrimenti
   * @throws SQLException
   */
  public UtenteBean checkLogin(String email, String pwd) throws SQLException;

  /**
   * Inserisce un utente nel database.
   * @param utente le informazioni dell'utente da inserire
   * @param pwd la password dell'utente
   * @throws SQLException
   */
  public void insert(UtenteBean utente, String pwd) throws SQLException;

}
