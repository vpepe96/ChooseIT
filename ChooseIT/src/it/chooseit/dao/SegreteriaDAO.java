package it.chooseit.dao;

import java.sql.SQLException;

import it.chooseit.bean.SegreteriaBean;

public interface SegreteriaDAO extends GenericDAO<SegreteriaBean, String> {

  /**
   * Inserisce un segretario nel database.
   * @param tutor le informazioni del segretario da inserire
   * @param pwd la password del segretario
   * @throws SQLException
   */
  public void insert(SegreteriaBean utente, String pwd) throws SQLException;
}
