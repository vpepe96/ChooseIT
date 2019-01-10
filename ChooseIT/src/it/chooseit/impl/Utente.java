package it.chooseit.impl;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import it.chooseit.bean.UtenteBean;
import it.chooseit.dao.UtenteDAO;
import it.chooseit.services.DriverManagerConnectionPool;
import it.chooseit.services.GestorePassword;

/**
 * Implementazione di UtenteDAO, che definisce i metodi per gestire i dati
 * relativi agli utenti.
 */
public class Utente implements UtenteDAO {

  @Override
  public synchronized UtenteBean retrieveByKey(String email) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;

    try {
      connection = DriverManagerConnectionPool.getConnection();

      String sql = "select * from utente where email = ?;";

      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setString(1, email);

      rs = preparedStatement.executeQuery();

      if (rs.next()) {
        UtenteBean bean = new UtenteBean();
        bean.setEmail(rs.getString("email"));
        bean.setNome(rs.getString("nome"));
        bean.setCognome(rs.getString("cognome"));
        bean.setDataNascita(rs.getDate("data_nascita"));
        bean.setIndirizzo(rs.getString("indirizzo"));
        bean.setTelefono(rs.getString("telefono"));
        bean.setFotoProfilo(rs.getString("foto_profilo"));
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
  public synchronized UtenteBean checkLogin(String email, String pwd) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;

    try {
      connection = DriverManagerConnectionPool.getConnection();

      String sql = "select * from utente where email = ?";

      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setString(1, email);

      rs = preparedStatement.executeQuery();
      String storedPassword = null;
      boolean pwdOK = false;

      // Se l'utente &egrave; iscritto al sito...
      if (rs.next()) {
        storedPassword = rs.getString("pwd");
      } else // ...altrimenti non &egrave; iscritto al sito
        return null;

      // Controllo sulla password inserita...
      try {
        pwdOK = GestorePassword.validatePassword(pwd, storedPassword);
      } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
      } catch (InvalidKeySpecException e) {
        e.printStackTrace();
      }

      if (pwdOK) {
        UtenteBean bean = new UtenteBean();

        bean = retrieveByKey(email);

        return bean;
      } else {
        return null;
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
  public synchronized void insert(UtenteBean utente, String pwd) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DriverManagerConnectionPool.getConnection();

      String pwdSicura = null;
      try {
        pwdSicura = GestorePassword.generateStrongPasswordHash(pwd);
      } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
      } catch (InvalidKeySpecException e) {
        e.printStackTrace();
      }

      String sql = "insert into utente (email, nome, cognome, data_nascita, indirizzo, telefono, pwd, foto_profilo) values (?, ?, ?, ?, ? ,?, ?, ?);";

      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setString(1, utente.getEmail());
      preparedStatement.setString(2, utente.getNome());
      preparedStatement.setString(3, utente.getCognome());
      preparedStatement.setDate(4, utente.getDataNascita());
      preparedStatement.setString(5, utente.getIndirizzo());
      preparedStatement.setString(6, utente.getTelefono());
      preparedStatement.setString(7, pwdSicura);
      preparedStatement.setString(8, utente.getFotoProfilo());

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

  @Override
  public synchronized void update(UtenteBean utente) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DriverManagerConnectionPool.getConnection();

      String sql = "update utente set nome = ?, cognome = ?, data_nascita = ?, indirizzo = ?, telefono = ?, foto_profilo = ? where email = ?;";

      System.out.println(sql);

      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setString(1, utente.getNome());
      preparedStatement.setString(2, utente.getCognome());
      preparedStatement.setDate(3, utente.getDataNascita());
      preparedStatement.setString(4, utente.getIndirizzo());
      preparedStatement.setString(5, utente.getTelefono());
      preparedStatement.setString(6, utente.getFotoProfilo());
      preparedStatement.setString(7, utente.getEmail());

      System.out.println("doUpdate: "+ preparedStatement.toString());

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

  @Override
  public synchronized boolean delete(String email) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DriverManagerConnectionPool.getConnection();

      String sql = "delete from utente where email = ?;";

      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setString(1, email);

      int result = preparedStatement.executeUpdate();

      if (result == 1) {
        return true;
      } else {
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
  public synchronized Collection<UtenteBean> retrieveAll(String order) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    Collection<UtenteBean> list = new ArrayList<>();

    try {
      connection = DriverManagerConnectionPool.getConnection();
      String sql = null;
      if (order == null || order.equals("")) {
        sql = "select * from utente;";
      } else {
        sql = "select * from utente order by " + order + ";";
      }

      preparedStatement = connection.prepareStatement(sql);

      rs = preparedStatement.executeQuery();

      while (rs.next()) {
        UtenteBean bean = new UtenteBean();

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
  public void insert(UtenteBean object) throws SQLException {
  }
}
