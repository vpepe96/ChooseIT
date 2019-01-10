package it.chooseit.dao;

import java.sql.SQLException;
import java.util.Collection;

import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.StudenteBean;
import it.chooseit.bean.TutorAziendaleBean;
import it.chooseit.bean.TutorUniversitarioBean;


public interface RegistroTirocinioDAO extends GenericDAO<RegistroTirocinioBean, Integer> {

  /**
   * Recupera tutti i registri di tirocinio associati allo studente.
   * @param studente lo studente di cui si vogliono recuperare i registri associati
   * @return un insieme di registri di tirocinio
   * @throws SQLException
   */
  public Collection<RegistroTirocinioBean> getRegistriDiStudente(StudenteBean studente) throws SQLException;


  /**
   * Recupera tutti i registri di tirocinio associati al tutor aziendale.
   * @param t il tutor aziendale del quale si vogliono recuperare i registri di tirocinio
   * @return un insieme di registri di tirocinio
   * @throws SQLException
   */
  public Collection<RegistroTirocinioBean> getRegistriDiTutorAziendale(TutorAziendaleBean t) throws SQLException;


  /**
   * Recupera tutti i registri di tirocinio in corso.
   * @return un insieme di registri di tirocinio
   * @throws SQLException
   */
  public Collection<RegistroTirocinioBean> getRegistriDiTirociniInCorso() throws SQLException;


  /**
   * Recupera tutti i registri di tirocinio terminati.
   * @return un insieme di registri di tirocinio
   * @throws SQLException
   */
  public Collection<RegistroTirocinioBean> getRegistriDiTirociniTerminati() throws SQLException;


  /**
   * Recupera tutti i registri di tirocinio associati al tutor universitario.
   * @param t il tutor universitario del quale si vogliono recuperare i registri di tirocinio
   * @return un insieme di registri di tirocinio
   * @throws SQLException
   */
  public Collection<RegistroTirocinioBean> getRegistriDiTutorUniversitario(TutorUniversitarioBean t) throws SQLException;

}
