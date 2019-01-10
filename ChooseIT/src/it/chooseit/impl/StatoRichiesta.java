package it.chooseit.impl;

/**
 * Implementazione di StatoRichiestaDAO che definisce tutti i metodi per gestire i dati relativi agli stati
 * delle richieste di tirocinio.
 *  
 * @author RocketStudios
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import it.chooseit.bean.RichiestaTirocinioBean;
import it.chooseit.bean.StatoRichiestaBean;
import it.chooseit.dao.RichiestaTirocinioDAO;
import it.chooseit.dao.StatoRichiestaDAO;
import it.chooseit.services.ConvertEnum;
import it.chooseit.services.DriverManagerConnectionPool;

public class StatoRichiesta implements StatoRichiestaDAO{

  @Override
  public StatoRichiestaBean retrieveByKey(StatoRichiestaBean key) throws SQLException {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * Restituisce tutti gli stati di tutte le richieste di tirocinio
   * 
   * @param order criterio di ordinamento da adottare per la collezione risultante
   * @return collezione di tutti gli stati di tutte le richieste di tirocinio
   * @throws SQLException
   */
  public Collection<StatoRichiestaBean> retrieveAll(String order) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ConvertEnum convert = new ConvertEnum();

    Collection<StatoRichiestaBean> statiRichieste = new ArrayList<StatoRichiestaBean>();

    String selectSQL = "SELECT * FROM stato_richiesta";

    if(order != null && !order.equals("")) {
      selectSQL += " ORDER BY " + order;
    }

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(selectSQL);

      System.out.println("doRetrieveAll:" + preparedStatement.toString());

      ResultSet rs = preparedStatement.executeQuery();
      RichiestaTirocinio ric = new RichiestaTirocinio();

      while(rs.next()) {
        StatoRichiestaBean bean = new StatoRichiestaBean();

        bean.setDataStato(rs.getDate("data_stato"));
        bean.setTipo(convert.convertStatoRichiesta(rs.getString("tipo")));
        bean.setRichiestaId(ric.retrieveByKey(rs.getInt("richiesta_id")));

        statiRichieste.add(bean);
      }
    } finally {
      try {
        if(preparedStatement != null)
          preparedStatement.close();
      } finally {
        DriverManagerConnectionPool.releaseConnection(connection);
      }
    }

    return statiRichieste;
  }

  /**
   * Consente l'inserimento di uno stato di una richiesta di tirocinio
   * 
   * Pre: statoRichiesta != null
   * @param statoRichiesta stato da inserire
   * @throws SQLException
   */
  public synchronized void insert(StatoRichiestaBean statoRichiesta) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ConvertEnum convert = new ConvertEnum();

    String insertSQL = "INSERT INTO stato_richiesta (data_stato,tipo,richiesta_id) VALUES (?, ?, ?)";

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(insertSQL);

      preparedStatement.setDate(1, statoRichiesta.getDataStato());
      preparedStatement.setString(2, convert.convertStatoRichiestaString(statoRichiesta.getTipo()));
      preparedStatement.setInt(3, statoRichiesta.getRichiestaTirocinio().getId());

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

  /**
   * Consente di aggiornare uno stato di una richiesta di tirocinio
   * 
   * @param statoRichiesta nuovo stato della richiesta di tirocinio 
   * @throws SQLException
   */
  public synchronized void update(StatoRichiestaBean statoRichiesta) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ConvertEnum convert = new ConvertEnum();

    String updateSQL = "UPDATE stato_richiesta SET data_stato=?, tipo=?" + 
        "WHERE richiesta_id = ?";

    try {
      connection = DriverManagerConnectionPool.getConnection();

      preparedStatement = connection.prepareStatement(updateSQL);

      preparedStatement.setDate(1, statoRichiesta.getDataStato());
      preparedStatement.setString(2, convert.convertStatoRichiestaString(statoRichiesta.getTipo()));
      preparedStatement.setInt(3, statoRichiesta.getRichiestaTirocinio().getId());

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

  /**
   * Consente di eliminare uno stato di una richiesta di tirocinio
   * 
   * @param statoRichiesta stato della richiesta di tirocinio da eliminare
   * @return TRUE se l'eliminiazione ha avuto succeso FALSE altrimenti
   * @throws SQLException
   */
  public boolean delete(StatoRichiestaBean statoRichiesta) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    int result = 0;

    String deleteSQL = "DELETE FROM stato_richiesta WHERE richiesta_id= ?";

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(deleteSQL);

      preparedStatement.setInt(1, statoRichiesta.getRichiestaTirocinio().getId());

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

  /**
   * Restituisce lo stato pi&ugrave; aggiornato di una richiesta di tirocinio
   */
  public StatoRichiestaBean getStatoRichiesta(RichiestaTirocinioBean richiestaTirocinio) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ConvertEnum convert = new ConvertEnum();

    StatoRichiestaBean bean = new StatoRichiestaBean(null, null, null);

    String selectSQL = "SELECT * \r\n" + 
        "FROM stato_richiesta \r\n" + 
        "WHERE richiesta_id = ?";

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(selectSQL);

      preparedStatement.setInt(1, richiestaTirocinio.getId());

      System.out.println("doRetrieveByKey:" + preparedStatement.toString());

      ResultSet rs = preparedStatement.executeQuery();

      while(rs.next()) {
        bean.setDataStato(rs.getDate("data_stato"));
        bean.setTipo(convert.convertStatoRichiesta(rs.getString("tipo")));
        bean.setRichiestaId(richiestaTirocinio);
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

  /**
   * Restituisce la lista di tutti gli stati di una richiesta di tirocinio
   */
  public Collection<StatoRichiestaBean> getStatiRichiesta(RichiestaTirocinioBean richiestaTirocinio) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ConvertEnum convert = new ConvertEnum();

    Collection<StatoRichiestaBean> statiRichiesta = new ArrayList<StatoRichiestaBean>();

    String selectSQL = "SELECT * FROM stato_richiesta WHERE richiesta_id = ?";

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(selectSQL);

      preparedStatement.setInt(1, richiestaTirocinio.getId());

      System.out.println("doRetrieveAll:" + preparedStatement.toString());

      ResultSet rs = preparedStatement.executeQuery();

      while(rs.next()) {
        StatoRichiestaBean bean = new StatoRichiestaBean(null, null, null);

        bean.setDataStato(rs.getDate("data_stato"));
        bean.setTipo(convert.convertStatoRichiesta(rs.getString("tipo")));
        bean.setRichiestaId(richiestaTirocinio);

        statiRichiesta.add(bean);
      }
    } finally {
      try {
        if(preparedStatement != null)
          preparedStatement.close();
      } finally {
        DriverManagerConnectionPool.releaseConnection(connection);
      }
    }

    return statiRichiesta;
  }
}
