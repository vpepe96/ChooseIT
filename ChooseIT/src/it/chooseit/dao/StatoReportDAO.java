package it.chooseit.dao;

import java.sql.SQLException;
import java.util.Collection;

import it.chooseit.bean.ReportBean;
import it.chooseit.bean.StatoReportBean;

public interface StatoReportDAO extends GenericDAO<StatoReportBean, StatoReportBean>{

  /**
   * Restituisce lo stato pi&ugrave; recente di un report
   * 
   * Pre: report != null
   * Post: result -> (s: StatoReportBean | s.idRegistro == report.registroId)	
   * @param report report di cui si desidera lo stato
   * @return stato pi&ugrave; recente del report
   * @throws SQLException
   */
  public StatoReportBean getStatoReport(ReportBean report) throws SQLException;

  /**
   * Restituisce tutti gli stati di un report
   * 
   * Pre: report != null
   * Post: result -> forAll(s: StatoReportBean | s.idRegistro == report.registroId)
   * @param report report di cui si desiderano gli stati
   * @return lista degli stati del report
   * @throws SQLException
   */
  public Collection<StatoReportBean> getStatiReport(ReportBean report) throws SQLException;

}
