package it.chooseit.dao;

import java.sql.SQLException;
import java.util.Collection;

import it.chooseit.bean.QuestionarioAziendaBean;
import it.chooseit.bean.StudenteBean;

public interface QuestionarioAziendaDAO extends GenericDAO<QuestionarioAziendaBean,Integer> {

  /**
   * Permette di recuperare un insieme di questionari valutativi sull'azienda associati allo studente.
   * @param studente lo studente del quale si vogliono recuperari i questionari
   * @return un insieme di questionari per lo studente
   * @throws SQLException
   */
  public Collection<QuestionarioAziendaBean> getQuestionarioPerStudente(StudenteBean studente) throws SQLException;

}
