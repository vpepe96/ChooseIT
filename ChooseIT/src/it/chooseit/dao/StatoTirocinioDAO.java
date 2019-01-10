package it.chooseit.dao;

import java.sql.SQLException;
import java.util.Collection;

import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.StatoTirocinioBean;

public interface StatoTirocinioDAO extends GenericDAO<StatoTirocinioBean, StatoTirocinioBean> {

  /**
   * Restituisce lo stato pi&ugrave; recente di un tirocinio
   * 
   * Pre: registroTirocinio != null
   * Post: result -> (s: StatoTirocinioBean | s.registroId == richiestaTirocinio.indentificativo)	
   * @param registroTirocinio registro di tirocinio di cui si desidera lo stato
   * @return stato pi&ugrave; recente del tirocinio
   * @throws SQLException
   */
  public StatoTirocinioBean getStatoTirocinio(RegistroTirocinioBean registroTirocinio) throws SQLException;

  /**
   * Restituisce tutti gli stati di un tirocinio
   * 
   * Pre: registroTirocinio != null
   * Post: result -> forAll(s: StatoTirocinioBean | s.registroId == richiestaTirocinio.indentificativo)
   * @param registroTirocinio registro di tirocinio di cui si desiderano gli stati
   * @return lista degli stati del tirocinio
   * @throws SQLException
   */
  public Collection<StatoTirocinioBean> getStatiTirocinio(RegistroTirocinioBean registroTirocinio) throws SQLException;


}
