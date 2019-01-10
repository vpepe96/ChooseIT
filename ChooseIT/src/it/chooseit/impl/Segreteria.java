package it.chooseit.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import it.chooseit.bean.SegreteriaBean;
import it.chooseit.bean.UtenteBean;
import it.chooseit.dao.SegreteriaDAO;
import it.chooseit.dao.UtenteDAO;
import it.chooseit.services.DriverManagerConnectionPool;

public class Segreteria implements SegreteriaDAO {

  @Override
  public SegreteriaBean retrieveByKey(String key) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;

    try {
      connection = DriverManagerConnectionPool.getConnection();

      String sql = "select * from segreteria where email = ?;";

      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setString(1, key);

      rs = preparedStatement.executeQuery();

      if (rs.next()) {
        SegreteriaBean bean = new SegreteriaBean();
        bean.setEmail(rs.getString("email"));

        //cerca dati utente
        UtenteDAO utenteDao = new Utente();
        UtenteBean utente = utenteDao.retrieveByKey(key);
        //setta dati utente
        bean.setNome(utente.getNome());
        bean.setCognome(utente.getCognome());
        bean.setDataNascita(utente.getDataNascita());
        bean.setIndirizzo(utente.getIndirizzo());
        bean.setTelefono(utente.getTelefono());
        bean.setFotoProfilo(utente.getFotoProfilo());

        return bean;
      } else 
        return null;
    } finally {
      try {
        if (!connection.isClosed())
          connection.close();
      } finally {
        DriverManagerConnectionPool.releaseConnection(connection);
      }
    }
  }

  @Override
  public Collection<SegreteriaBean> retrieveAll(String order) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    Collection<SegreteriaBean> list = new ArrayList<>();

    try {
      connection = DriverManagerConnectionPool.getConnection();
      String sql = null;
      if(order == null || order.equals("")) {
        sql = "select * from segreteria;";
      }else {
        sql = "select * from utente order by "+order+";";
      }

      preparedStatement = connection.prepareStatement(sql);

      rs = preparedStatement.executeQuery();

      while (rs.next()) {
        SegreteriaBean bean = new SegreteriaBean();

        String email = rs.getString("email");

        bean = retrieveByKey(email);

        list.add(bean);
      }

      return list;
    } finally {
      try {
        if (!connection.isClosed())
          connection.close();
      } finally {
        DriverManagerConnectionPool.releaseConnection(connection);
      }
    }
  }

  @Override
  public void insert(SegreteriaBean object) throws SQLException {}

  @Override
  public void update(SegreteriaBean object) throws SQLException {
    Connection connection = null;

    try {
      connection = DriverManagerConnectionPool.getConnection();

      UtenteDAO utenteDao = new Utente();
      utenteDao.update(object);

    } finally {
      try {
        if (!connection.isClosed())
          connection.close();
      } finally {
        DriverManagerConnectionPool.releaseConnection(connection);
      }
    }
  }

  @Override
  public boolean delete(String key) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DriverManagerConnectionPool.getConnection();

      String sql = "delete from segreteria where email = ?;";

      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setString(1, key);

      int result = preparedStatement.executeUpdate();

      //se il segretario &egrave; stato cancellato...
      if(result == 1) {
        //...cancella l'utente
        UtenteDAO utenteDao = new Utente();
        if(utenteDao.delete(key)) {
          //se l'utente &egrave; stato cancellato return true
          return true;
        }else {
          //altrimenti return false
          return false;
        }
      }else {
        //...altrimenti cancellazione non avvenuta
        return false;
      }

    } finally {
      try {
        if (!connection.isClosed())
          connection.close();
      } finally {
        DriverManagerConnectionPool.releaseConnection(connection);
      }
    }
  }

  @Override
  public void insert(SegreteriaBean utente, String pwd) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DriverManagerConnectionPool.getConnection();

      //inserimento dell'utente
      UtenteDAO utenteDao = new Utente();
      utenteDao.insert(utente, pwd);

      //inserimento segreteria
      String sql = "insert into segreteria (email) values (?);";

      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, utente.getEmail());

      preparedStatement.executeUpdate();

    } finally {
      try {
        if (!connection.isClosed())
          connection.close();
      } finally {
        DriverManagerConnectionPool.releaseConnection(connection);
      }
    }

  }

}
