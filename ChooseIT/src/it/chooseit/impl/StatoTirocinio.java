package it.chooseit.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.StatoTirocinioBean;
import it.chooseit.dao.StatoTirocinioDAO;
import it.chooseit.services.ConvertEnum;
import it.chooseit.services.DriverManagerConnectionPool;

public class StatoTirocinio implements StatoTirocinioDAO{

  @Override
  public StatoTirocinioBean retrieveByKey(StatoTirocinioBean key) throws SQLException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Collection<StatoTirocinioBean> retrieveAll(String order) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ConvertEnum convert = new ConvertEnum();

    Collection<StatoTirocinioBean> statiTirocini = new ArrayList<StatoTirocinioBean>();

    String selectSQL = "SELECT * FROM stato_tirocinio";

    if(order != null && !order.equals("")) {
      selectSQL += " ORDER BY " + order;
    }

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(selectSQL);

      System.out.println("doRetrieveAll:" + preparedStatement.toString());

      ResultSet rs = preparedStatement.executeQuery();
      RegistroTirocinio reg = new RegistroTirocinio();

      while(rs.next()) {
        StatoTirocinioBean bean = new StatoTirocinioBean();

        bean.setDataStato(rs.getDate("data_stato"));
        bean.setTipo(convert.convertStatoTirocinio(rs.getString("tipo")));
        bean.setRegistroTirocinio(reg.retrieveByKey(rs.getInt("registro_id")));

        statiTirocini.add(bean);
      }
    } finally {
      try {
        if(preparedStatement != null)
          preparedStatement.close();
      } finally {
        DriverManagerConnectionPool.releaseConnection(connection);
      }
    }

    return statiTirocini;
  }

  @Override
  public synchronized void insert(StatoTirocinioBean statoTirocinio) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    String insertSQL = "INSERT INTO stato_tirocinio(data_stato,tipo,registro_id) VALUES (?, ?, ?)";

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(insertSQL);

      preparedStatement.setDate(1, statoTirocinio.getDataStato());
      preparedStatement.setString(2, statoTirocinio.getTipo().toString());
      preparedStatement.setInt(3, statoTirocinio.getRegistroTirocinio().getIdentificativo());

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
  public synchronized void update(StatoTirocinioBean statoTirocinio) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    String updateSQL = "UPDATE stato_tirocinio SET data_stato=?, tipo=?" + 
        "WHERE registro_id = ?";

    try {
      connection = DriverManagerConnectionPool.getConnection();

      preparedStatement = connection.prepareStatement(updateSQL);

      preparedStatement.setDate(1, statoTirocinio.getDataStato());
      preparedStatement.setString(2, statoTirocinio.getTipo().toString());
      preparedStatement.setInt(3, statoTirocinio.getRegistroTirocinio().getIdentificativo());

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
  public boolean delete(StatoTirocinioBean statoTirocinio) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ConvertEnum convert = new ConvertEnum();
    
    int result = 0;

    String deleteSQL = "DELETE FROM stato_tirocinio WHERE registro_id= ? AND stato_tirocinio.tipo = ?";

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(deleteSQL);

      preparedStatement.setInt(1, statoTirocinio.getRegistroTirocinio().getIdentificativo());
      preparedStatement.setString(2, convert.convertStatoTirocinioString(statoTirocinio.getTipo()));
      
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
  public StatoTirocinioBean getStatoTirocinio(RegistroTirocinioBean registroTirocinio) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ConvertEnum convert = new ConvertEnum();

    StatoTirocinioBean bean = new StatoTirocinioBean(null, null, null);

    String selectSQL = "SELECT * FROM stato_tirocinio WHERE registro_id = ?;";

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(selectSQL);

      preparedStatement.setInt(1, registroTirocinio.getIdentificativo());

      System.out.println("doRetrieveByKey:" + preparedStatement.toString());

      ResultSet rs = preparedStatement.executeQuery();

      while(rs.next()) {
        bean.setDataStato(rs.getDate("data_stato"));
        bean.setTipo(convert.convertStatoTirocinio(rs.getString("tipo")));
        bean.setRegistroTirocinio(registroTirocinio);
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
  public Collection<StatoTirocinioBean> getStatiTirocinio(RegistroTirocinioBean registroTirocinio) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ConvertEnum convert = new ConvertEnum();

    Collection<StatoTirocinioBean> statiTirocinio = new ArrayList<StatoTirocinioBean>();

    String selectSQL = "SELECT * FROM stato_tirocinio WHERE registro_id = ?";

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(selectSQL);

      preparedStatement.setInt(1, registroTirocinio.getIdentificativo());

      System.out.println("doRetrieveAll:" + preparedStatement.toString());

      ResultSet rs = preparedStatement.executeQuery();
      RegistroTirocinio reg = new RegistroTirocinio();

      while(rs.next()) {
        StatoTirocinioBean bean = new StatoTirocinioBean(null, null, null);

        bean.setDataStato(rs.getDate("data_stato"));
        bean.setTipo(convert.convertStatoTirocinio(rs.getString("tipo")));
        bean.setRegistroTirocinio(reg.retrieveByKey(rs.getInt("registro_id")));

        statiTirocinio.add(bean);
      }
    } finally {
      try {
        if(preparedStatement != null)
          preparedStatement.close();
      } finally {
        DriverManagerConnectionPool.releaseConnection(connection);
      }
    }

    return statiTirocinio;
  }

}
