package it.chooseit.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.ReportBean;
import it.chooseit.dao.RegistroTirocinioDAO;
import it.chooseit.dao.ReportDAO;
import it.chooseit.services.DriverManagerConnectionPool;
import it.chooseit.services.ReportKey;

public class Report implements ReportDAO {

  @Override
  public ReportBean retrieveByKey(ReportKey key) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatament = null;

    ReportBean bean = new ReportBean();

    String selectSQL = "SELECT * FROM report WHERE registro_id = ? AND data_inserimento= ?;";

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatament = connection.prepareStatement(selectSQL);


      preparedStatament.setInt(1, key.getRegistro().getIdentificativo());
      preparedStatament.setDate(2, key.getData());

      System.out.println("doRetrieveByKey:" + preparedStatament.toString());

      ResultSet rs = preparedStatament.executeQuery();

      while(rs.next()) {	
        bean.setDataInserimento(key.getData());
        bean.setRegistroTirocinio(key.getRegistro());
        bean.setPath(rs.getString("contenuto"));

        if(rs.getString("tutor_aziendale_email") == null) {
          bean.setTutorAziendale(null);
        }else {
          bean.setTutorAziendale(key.getRegistro().getTutorAziendale());
        }

        // settare con StatoReportDAO.getStatiReport(ReportBean bean)
        bean.setStatiReport(null);
      }
    } finally {
      try {
        if(preparedStatament != null)
          preparedStatament.close();
      } finally {
        DriverManagerConnectionPool.releaseConnection(connection);
      }
    }
    return bean;

  }

  @Override
  public Collection<ReportBean> retrieveAll(String order) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatament = null;

    Collection<ReportBean> reports = new ArrayList<ReportBean>();

    String selectSQL = "SELECT * FROM report";

    if(order != null && !order.equals("")) {
      selectSQL += " ORDER BY " + order+";";
    }else {
      selectSQL += ";";
    }

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatament = connection.prepareStatement(selectSQL);

      System.out.println("doRetrieveAll:" + preparedStatament.toString());

      ResultSet rs = preparedStatament.executeQuery();

      while(rs.next()) {
        ReportBean bean;
        RegistroTirocinioDAO registroDao = new RegistroTirocinio();
        RegistroTirocinioBean registro = registroDao.retrieveByKey(rs.getInt("registro_id"));
        ReportKey key = new ReportKey(registro, rs.getDate("data_inserimento"));

        bean = retrieveByKey(key);
        reports.add(bean);
      }
    } finally {
      try {
        if(preparedStatament != null)
          preparedStatament.close();
      } finally {
        DriverManagerConnectionPool.releaseConnection(connection);
      }
    }

    return reports;
  }

  @Override
  public synchronized void insert(ReportBean object) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    String insertSQL = "INSERT INTO report (registro_id,data_inserimento, contenuto, tutor_aziendale_email) VALUES (?, ?, ?, ?);";

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(insertSQL);

      preparedStatement.setInt(1,object.getRegistroTirocinio().getIdentificativo());
      preparedStatement.setDate(2, object.getDataInserimento());
      preparedStatement.setString(3, object.getPath());
      if(object.getTutorAziendale() == null) {
        preparedStatement.setString(4, null);
      }else {
        preparedStatement.setString(4, object.getTutorAziendale().getEmail());
      }
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
  public synchronized void update(ReportBean object) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    String insertSQL = "UPDATE report SET contenuto=?, tutor_aziendale_email=?"
        + " WHERE registro_id = ? AND data_inserimento= ?;";

    try {
      connection = DriverManagerConnectionPool.getConnection();

      preparedStatement = connection.prepareStatement(insertSQL);

      preparedStatement.setString(1,object.getPath());
      preparedStatement.setString(2, object.getTutorAziendale().getEmail());
      preparedStatement.setInt(3, object.getRegistroTirocinio().getIdentificativo());
      preparedStatement.setDate(4,object.getDataInserimento());

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
  public boolean delete(ReportKey key) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    int result = 0;

    String deleteSQL = "DELETE FROM report WHERE registro_id= ? AND data_inserimento= ?;";

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(deleteSQL);
      preparedStatement.setInt(1, key.getRegistro().getIdentificativo());
      preparedStatement.setDate(2, key.getData());

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
  public Collection<ReportBean> getReportFirmati(RegistroTirocinioBean registro) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatament = null;

    Collection<ReportBean> reports = new ArrayList<ReportBean>();

    String selectSQL = "SELECT * FROM report WHERE registro_id=? AND tutor_aziendale_email is not null;";


    try {
      connection = DriverManagerConnectionPool.getConnection();

      preparedStatament = connection.prepareStatement(selectSQL);


      preparedStatament.setInt(1, registro.getIdentificativo());

      System.out.println("doRetrieveAll:" + preparedStatament.toString());

      ResultSet rs = preparedStatament.executeQuery();
      RegistroTirocinio reg=new RegistroTirocinio();
      TutorAziendale ta=new TutorAziendale();

      while(rs.next()) {
        ReportBean bean = new ReportBean();

        bean.setDataInserimento(rs.getDate("data_inserimento"));
        bean.setRegistroTirocinio(reg.retrieveByKey(rs.getInt("registro_id")));
        bean.setPath(rs.getString("contenuto"));
        bean.setTutorAziendale(ta.retrieveByKey(rs.getString("tutor_aziendale_email")));

        reports.add(bean);
      }
    } finally {
      try {
        if(preparedStatament != null)
          preparedStatament.close();
      } finally {
        DriverManagerConnectionPool.releaseConnection(connection);
      }
    }

    return reports;
  }

  @Override
  public Collection<ReportBean> getReportNonFirmati(RegistroTirocinioBean registro) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatament = null;

    Collection<ReportBean> reports = new ArrayList<ReportBean>();

    String selectSQL = "SELECT * FROM report WHERE registro_id=? AND tutor_aziendale_email is null;";


    try {
      connection = DriverManagerConnectionPool.getConnection();

      preparedStatament = connection.prepareStatement(selectSQL);


      preparedStatament.setInt(1, registro.getIdentificativo());

      System.out.println("doRetrieveAll:" + preparedStatament.toString());

      ResultSet rs = preparedStatament.executeQuery();
      RegistroTirocinio reg=new RegistroTirocinio();

      while(rs.next()) {
        ReportBean bean = new ReportBean();

        bean.setDataInserimento(rs.getDate("data_inserimento"));
        bean.setRegistroTirocinio(reg.retrieveByKey(rs.getInt("registro_id")));
        bean.setPath(rs.getString("contenuto"));
        bean.setTutorAziendale(null);

        reports.add(bean);
      }
    } finally {
      try {
        if(preparedStatament != null)
          preparedStatament.close();
      } finally {
        DriverManagerConnectionPool.releaseConnection(connection);
      }
    }

    return reports;
  }

  @Override
  public Collection<ReportBean> getReportRegistro(RegistroTirocinioBean registro) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatament = null;

    Collection<ReportBean> reports = new ArrayList<ReportBean>();

    String selectSQL = "SELECT * FROM report WHERE registro_id=?;";


    try {
      connection = DriverManagerConnectionPool.getConnection();

      preparedStatament = connection.prepareStatement(selectSQL);


      preparedStatament.setInt(1, registro.getIdentificativo());

      System.out.println("doRetrieveAll:" + preparedStatament.toString());

      ResultSet rs = preparedStatament.executeQuery();
      RegistroTirocinio reg=new RegistroTirocinio();
      TutorAziendale ta=new TutorAziendale();

      while(rs.next()) {
        ReportBean bean = new ReportBean();

        bean.setDataInserimento(rs.getDate("data_inserimento"));
        bean.setRegistroTirocinio(reg.retrieveByKey(rs.getInt("registro_id")));
        bean.setPath(rs.getString("contenuto"));
        if(rs.getString("tutor_aziendale_email") != null) {
          bean.setTutorAziendale(ta.retrieveByKey(rs.getString("tutor_aziendale_email")));
        }else {
          bean.setTutorAziendale(null);
        }
        reports.add(bean);
      }
    } finally {
      try {
        if(preparedStatament != null)
          preparedStatament.close();
      } finally {
        DriverManagerConnectionPool.releaseConnection(connection);
      }
    }

    return reports;
  }

}
