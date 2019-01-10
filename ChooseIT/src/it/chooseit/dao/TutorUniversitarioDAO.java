package it.chooseit.dao;

import java.sql.SQLException;

import it.chooseit.bean.TutorUniversitarioBean;

/**
 * Interfaccia che estende GenericDAO e definisce ulteriori operazioni individuali del Tutor Universitario.
 *  
 * @author RocketStudios
 */
public interface TutorUniversitarioDAO extends GenericDAO<TutorUniversitarioBean, String>{

  /**
   * Inserisce un tutor universitario nel database.
   * @param tutor le informazioni del tutor da inserire
   * @param pwd la password del tutor
   * @throws SQLException
   */
  public void insert(TutorUniversitarioBean tutor, String pwd) throws SQLException;
}
