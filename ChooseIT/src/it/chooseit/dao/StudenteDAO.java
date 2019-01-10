package it.chooseit.dao;

import java.sql.SQLException;
import java.util.Collection;

import it.chooseit.bean.StudenteBean;
import it.chooseit.bean.TutorAziendaleBean;
import it.chooseit.bean.TutorUniversitarioBean;

public interface StudenteDAO extends GenericDAO<StudenteBean, String> {

  /**
   * Recupera la lista degli studenti iscritti al sito associati al tutor aziendale.
   * @param tutor il tutor aziendale del quale si vogliono recuperare gli studenti associati
   * @return una lista di studenti associati al tutor aziendale
   * @throws SQLException
   */
  public Collection<StudenteBean> getStudentiAssociati(TutorAziendaleBean tutor) throws SQLException;


  /**
   * Recupera la lista degli studenti iscritti al sito associati al tutor universitario.
   * @param tutor il tutor universitario del quale si vogliono recuperare gli studenti associati 
   * @return una lista di studenti associati al tutor universitario
   * @throws SQLException
   */
  public Collection<StudenteBean> getStudentiAssociati(TutorUniversitarioBean tutor) throws SQLException;

  /**
   * Inserisce uno studente nel database.
   * @param studente le informazioni dello studente da inserire
   * @param pwd la password dello studente
   * @throws SQLException
   */
  public void insert(StudenteBean studente, String pwd) throws SQLException;

  /**
   * Recupera una lista di studenti con richiesta di tirocinio in uno stato specificato 
   * @param statoRichiesta stato della richiesta di tirocinio degli studenti
   * @return una lista di studenti con una richiesta di tirocinio in uno stato specificato
   * @throws SQLException
   */
  public Collection<StudenteBean> getStudentiPerStatoRichiesta(String statoRichiesta) throws SQLException;

  /**
   * Recupera una lista di studenti con tirocinio in uno stato specificato
   * @param statoTirocinio stato del tirocinio degli studenti
   * @return una lista di studenti con tirocinio in uno stato specificato
   * @throws SQLException
   */
  public Collection<StudenteBean> getStudentiPerStatoTirocinio(String statoTirocinio) throws SQLException;
}
