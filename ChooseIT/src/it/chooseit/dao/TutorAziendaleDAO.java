package it.chooseit.dao;

import java.sql.SQLException;
import java.util.Collection;

import it.chooseit.bean.AziendaBean;
import it.chooseit.bean.TutorAziendaleBean;

/**
 * Interfaccia che estende GenericDAO e definisce ulteriori operazioni individuali del Tutor Aziendale.
 * 
 * @author RocketStudios
 */
public interface TutorAziendaleDAO extends GenericDAO<TutorAziendaleBean, String> {

  /**
   * Recupera la lista dei tutor aziendale associati ad un'azienda convenzionata
   * @param azienda azienda della quale si vogliono recuperare tutti i tutor aziendali associati.
   * @return una lista di tutor aziendali associati all'azienda.
   * @throws SQLException
   */
  public Collection<TutorAziendaleBean> getTutorDiAzienda(AziendaBean azienda) throws SQLException;
}
