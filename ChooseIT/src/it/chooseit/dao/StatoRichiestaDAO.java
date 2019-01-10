package it.chooseit.dao;

import java.sql.SQLException;
import java.util.Collection;

import it.chooseit.bean.RichiestaTirocinioBean;
import it.chooseit.bean.StatoRichiestaBean;

public interface StatoRichiestaDAO extends GenericDAO<StatoRichiestaBean, StatoRichiestaBean>{

  /**
   * Restituisce lo stato pi&ugrave; recente di una richiesta di tirocinio
   * 
   * Pre: richiestaTirocinio != null
   * Post: result -> (s: StatoRichiestaBean | s.richiestaId == richiestaTirocinio.indentificativo)	
   * @param richiestaTirocinio richiesta di tirocinio di cui si desidera lo stato
   * @return stato pi&ugrave; recente della richiesta di tirocinio
   * @throws SQLException
   */
  public StatoRichiestaBean getStatoRichiesta(RichiestaTirocinioBean richiestaTirocinio) throws SQLException;

  /**
   * Restituisce tutti gli stati di una richiesta di tirocinio
   * 
   * Pre: richiestaTirocinio != null
   * Post: result -> forAll(s: StatoRichiestaBean | s.richiestaId == richiestaTirocinio.indentificativo)	
   * @param richiestaTirocinio richiesta di tirocinio di cui si desiderano gli stati
   * @return lista degli stati della richiesta di tirocinio
   * @throws SQLException
   */
  public Collection<StatoRichiestaBean> getStatiRichiesta(RichiestaTirocinioBean richiestaTirocinio) throws SQLException;

}
