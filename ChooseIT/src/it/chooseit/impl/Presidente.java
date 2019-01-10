package it.chooseit.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import it.chooseit.bean.PresidenteBean;
import it.chooseit.bean.UtenteBean;
import it.chooseit.dao.PresidenteDAO;
import it.chooseit.dao.UtenteDAO;
import it.chooseit.services.DriverManagerConnectionPool;

public class Presidente implements PresidenteDAO {

  @Override
  public PresidenteBean retrieveByKey(String key) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;

    try {
      connection = DriverManagerConnectionPool.getConnection();

      String sql = "select * from presidente where email = ?;";

      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setString(1, key);

      rs = preparedStatement.executeQuery();

      if (rs.next()) {
        PresidenteBean bean = new PresidenteBean();
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
  public Collection<PresidenteBean> retrieveAll(String order) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    Collection<PresidenteBean> list = new ArrayList<>();

    try {
      connection = DriverManagerConnectionPool.getConnection();
      String sql = null;
      if(order == null || order.equals("")) {
        sql = "select * from presidente;";
      }else {
        sql = "select * from presidente order by "+order+";";
      }

      preparedStatement = connection.prepareStatement(sql);

      rs = preparedStatement.executeQuery();

      while (rs.next()) {
        PresidenteBean bean = new PresidenteBean();

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
  public void insert(PresidenteBean object) throws SQLException {}

  @Override
  public void update(PresidenteBean object) throws SQLException {
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

      String sql = "delete from presidente where email = ?;";

      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setString(1, key);

      int result = preparedStatement.executeUpdate();

      //se il presidente &egrave; stato cancellato...
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
  public void insert(PresidenteBean utente, String pwd) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DriverManagerConnectionPool.getConnection();

      //inserimento dell'utente
      UtenteDAO utenteDao = new Utente();
      utenteDao.insert(utente, pwd);

      //inserimento presidente
      String sql = "insert into presidente (email) values (?);";

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
