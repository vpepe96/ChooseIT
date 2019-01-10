package it.chooseit.dao;


import java.sql.SQLException;
import java.util.Collection;

import it.chooseit.bean.QuestionarioStudenteBean;

import it.chooseit.bean.TutorAziendaleBean;

public interface QuestionarioStudenteDAO extends GenericDAO<QuestionarioStudenteBean,Integer> {

  /**
   * Permette di recuperare un insieme di questionari valutativi sullo studente associati al tutor aziendale.
   * @param tutor il tutor aziendale del quale si vogliono recuperari i questionari
   * @return un insieme di questionari per il tutor aziendale
   * @throws SQLException
   */
  public Collection<QuestionarioStudenteBean> getQuestionarioPerTutorAziendale(TutorAziendaleBean tutor) throws SQLException;

  /**
   * Permette di recuperare un insieme di questionari valutativi sullo studente associati al tutor aziendale con stato Terminato .
   * @param tutor il tutor aziendale del quale si vogliono recuperari i questionari
   * @return un insieme di questionari terminati per il tutor aziendale
   * @throws SQLException
   */


  public Collection<QuestionarioStudenteBean> getQuestionariNonCompilati(TutorAziendaleBean tutor) throws SQLException;

}
