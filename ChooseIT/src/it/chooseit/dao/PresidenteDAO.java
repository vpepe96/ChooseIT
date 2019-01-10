package it.chooseit.dao;

import java.sql.SQLException;

import it.chooseit.bean.PresidenteBean;

public interface PresidenteDAO extends GenericDAO<PresidenteBean, String> {

  /**
   * Inserisce un presidente nel database.
   * @param tutor le informazioni del presidente da inserire
   * @param pwd la password del presidente
   * @throws SQLException
   */
  public void insert(PresidenteBean utente, String pwd) throws SQLException;
}
