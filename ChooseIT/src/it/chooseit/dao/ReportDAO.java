package it.chooseit.dao;

import java.sql.SQLException;
import java.util.Collection;

import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.ReportBean;
import it.chooseit.services.ReportKey;

public interface ReportDAO extends GenericDAO<ReportBean, ReportKey> {

  public Collection<ReportBean> getReportFirmati(RegistroTirocinioBean registro) throws SQLException;

  public Collection<ReportBean> getReportNonFirmati(RegistroTirocinioBean registro) throws SQLException;

  public Collection<ReportBean> getReportRegistro(RegistroTirocinioBean registro) throws SQLException;

}


