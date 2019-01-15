package it.chooseit.impl;

/**
 * 
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import it.chooseit.bean.ReportBean;
import it.chooseit.bean.StatoReportBean;
import it.chooseit.dao.StatoReportDAO;
import it.chooseit.services.ConvertEnum;
import it.chooseit.services.DriverManagerConnectionPool;
import it.chooseit.services.ReportKey;

public class StatoReport implements StatoReportDAO {

  @Override
  public StatoReportBean retrieveByKey(StatoReportBean key) throws SQLException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Collection<StatoReportBean> retrieveAll(String order) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ConvertEnum convert = new ConvertEnum();

    Collection<StatoReportBean> statiReports = new ArrayList<StatoReportBean>();

    String selectSQL = "SELECT * FROM stato_report";

    if(order != null && !order.equals("")) {
      selectSQL += " ORDER BY " + order;
    }

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(selectSQL);

      System.out.println("doRetrieveAll:" + preparedStatement.toString());

      ResultSet rs = preparedStatement.executeQuery();
      RegistroTirocinio reg = new RegistroTirocinio();
      Report rep = new Report();

      while(rs.next()) {
        StatoReportBean bean = new StatoReportBean();

        bean.setDataStato(rs.getDate("data_stato"));
        bean.setTipo(convert.convertStatoReport(rs.getString("tipo")));
        bean.setRegistroTirocinio(reg.retrieveByKey(rs.getInt("report_id_reg")));
        bean.setReport(rep.retrieveByKey(new ReportKey(reg.retrieveByKey(rs.getInt("report_id_reg")), rs.getDate("report_data"))));

        statiReports.add(bean);
      }
    } finally {
      try {
        if(preparedStatement != null)
          preparedStatement.close();
      } finally {
        DriverManagerConnectionPool.releaseConnection(connection);
      }
    }

    return statiReports;
  }

  @Override
  public synchronized void insert(StatoReportBean statoReport) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    String insertSQL = "INSERT INTO stato_report(data_stato,tipo,report_id_reg,report_data) VALUES (?, ?, ?, ?)";

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(insertSQL);

      preparedStatement.setDate(1, statoReport.getDataStato());
      preparedStatement.setString(2, statoReport.getTipo().toString());
      preparedStatement.setInt(3, statoReport.getRegistroTirocinio().getIdentificativo());
      preparedStatement.setDate(4, statoReport.getReport().getDataInserimento());

      System.out.println("doSave: "+ preparedStatement.toString());
      preparedStatement.executeUpdate();

    } finally {
      try {
        if (preparedStatement != null)
          preparedStatement.close();
      } finally {
        DriverManagerConnectionPool.releaseConnection(connection);
      }
    }

  }

  @Override
  public synchronized void update(StatoReportBean statoReport) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    String updateSQL = "UPDATE stato_report SET data_stato = ?, tipo = ?" + 
        "WHERE report_id_reg=? AND report_data=?";

    try {
      connection = DriverManagerConnectionPool.getConnection();

      preparedStatement = connection.prepareStatement(updateSQL);

      preparedStatement.setDate(1, statoReport.getDataStato());
      preparedStatement.setString(2, statoReport.getTipo().toString());
      preparedStatement.setInt(3, statoReport.getRegistroTirocinio().getIdentificativo());
      preparedStatement.setDate(4, statoReport.getReport().getDataInserimento());

      System.out.println("doUpdate: "+ preparedStatement.toString());
      preparedStatement.executeUpdate();

    } finally {
      try {
        if (preparedStatement != null)
          preparedStatement.close();
      } finally {
        DriverManagerConnectionPool.releaseConnection(connection);
      }
    }

  }

  @Override
  public boolean delete(StatoReportBean statoReport) throws SQLException {
	  ConvertEnum convert= new ConvertEnum();
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    int result = 0;

    String deleteSQL = "DELETE FROM stato_report WHERE report_id_reg = ? AND stato_report.tipo = ?";

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(deleteSQL);

      preparedStatement.setInt(1, statoReport.getRegistroTirocinio().getIdentificativo());
      preparedStatement.setString(2, convert.convertStatoReportString(statoReport.getTipo()));

      System.out.println("doDelete: "+ preparedStatement.toString());
      result = preparedStatement.executeUpdate();

    } finally {
      try {
        if (preparedStatement != null)
          preparedStatement.close();
      } finally {
        DriverManagerConnectionPool.releaseConnection(connection);
      }
    }
    return (result != 0);
  }

  @Override
  public StatoReportBean getStatoReport(ReportBean report) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ConvertEnum convert = new ConvertEnum();
    RegistroTirocinio reg = new RegistroTirocinio();
    Report rep = new Report();

    StatoReportBean bean = new StatoReportBean(null, null, null, null);

    String selectSQL = "SELECT * \r\n" + 
        "FROM stato_report \r\n" + 
        "WHERE data_stato = " + 
        "(SELECT MAX(data_stato) FROM stato_report WHERE report_id_reg = ? AND report_data = ?)";

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(selectSQL);

      preparedStatement.setInt(1, report.getRegistroTirocinio().getIdentificativo());
      preparedStatement.setDate(2, report.getDataInserimento());

      System.out.println("doRetrieveByKey:" + preparedStatement.toString());

      ResultSet rs = preparedStatement.executeQuery();

      while(rs.next()) {
        bean.setDataStato(rs.getDate("data_stato"));
        bean.setTipo(convert.convertStatoReport(rs.getString("tipo")));
        bean.setRegistroTirocinio(reg.retrieveByKey(rs.getInt("report_id_reg")));
        bean.setReport(rep.retrieveByKey(new ReportKey(reg.retrieveByKey(rs.getInt("report_id_reg")), rs.getDate("report_data"))));
      }
    } finally {
      try {
        if(preparedStatement != null)
          preparedStatement.close();
      } finally {
        DriverManagerConnectionPool.releaseConnection(connection);
      }
    }
    return bean;
  }

  @Override
  public Collection<StatoReportBean> getStatiReport(ReportBean report) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ConvertEnum convert = new ConvertEnum();

    Collection<StatoReportBean> statiReport = new ArrayList<StatoReportBean>();

    String selectSQL = "select stato_report.data_stato, stato_report.tipo, stato_report.report_id_reg, stato_report.report_data\r\n" + 
    		"from report JOIN stato_report ON report.registro_id = stato_report.report_id_reg \r\n" + 
    		"where report.registro_id = ? and report.data_inserimento = ? and report.data_inserimento = stato_report.report_data\r\n";

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(selectSQL);

      preparedStatement.setInt(1, report.getRegistroTirocinio().getIdentificativo());
      preparedStatement.setDate(2, report.getDataInserimento());

      System.out.println("doRetrieveAll:" + preparedStatement.toString());

      ResultSet rs = preparedStatement.executeQuery();
      RegistroTirocinio reg = new RegistroTirocinio();
      Report rep = new Report();

      while(rs.next()) {
        StatoReportBean bean = new StatoReportBean(null, null, null, null);

        bean.setDataStato(rs.getDate("data_stato"));
        bean.setTipo(convert.convertStatoReport(rs.getString("tipo")));
        bean.setRegistroTirocinio(reg.retrieveByKey(rs.getInt("report_id_reg")));
        bean.setReport(report);

        statiReport.add(bean);
      }
    } finally {
      try {
        if(preparedStatement != null)
          preparedStatement.close();
      } finally {
        DriverManagerConnectionPool.releaseConnection(connection);
      }
    }

    return statiReport;
  }

}
