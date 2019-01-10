package it.chooseit.dao;

/**
 * 
 */

import java.sql.SQLException;
import java.util.Collection;

import it.chooseit.bean.AziendaBean;
import it.chooseit.bean.RichiestaTirocinioBean;
import it.chooseit.bean.StudenteBean;

public interface RichiestaTirocinioDAO extends GenericDAO<RichiestaTirocinioBean, Integer> {

  /**
   * Permette di recuperare un insieme di richieste di tirocinio effettuata per l'azienda.
   * 
   * Pre: azienda != null
   * Post: result -> forAll(r: RichiestaTirocinioBean | r.ragioneSocialeAzienda == azienda.ragioneSociale)
   * @param azienda l'azienda della quale si vogliono recuperare le richieste
   * @return un insieme di richieste di tirocinio fatte presso la stessa azienda
   * @throws SQLException
   */
  Collection<RichiestaTirocinioBean> getRichiestePerAzienda(AziendaBean azienda) throws SQLException;

  /**
   * Permette di recuperare un insieme di richieste di tirocinio effettuate per stato
   * 
   * Pre: stato != null
   * Post: result -> forAll(r: RichiestaTirocinioBean | r.statoRichiestaBean.equals(stato))
   * @param stato lo stato delle richieste che si desidera recuperare
   * @return un insieme di richieste di tirocinio con lo stesso stato
   * @throws SQLException
   */
  Collection<RichiestaTirocinioBean> getRichiestePerStato(String stato) throws SQLException;

  /**
   * Permette di recuperare un insieme di richieste di tirocinio effettuate per studente
   * 
   * Pre: studente != null
   * Post: result -> forAll(r: RichiestaTirocinioBean | r.studenteEmail == studente.email)
   * @param studente lo studente di cui si desidera recuperare le richieste
   * @return un insieme di richieste di tirocinio effettuate da un singolo studente
   * @throws SQLException
   */
  Collection<RichiestaTirocinioBean> getRichiestePerStudente(StudenteBean studente) throws SQLException;
}
