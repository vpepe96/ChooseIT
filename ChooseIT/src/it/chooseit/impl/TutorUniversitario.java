package it.chooseit.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import it.chooseit.bean.TutorUniversitarioBean;
import it.chooseit.bean.UtenteBean;
import it.chooseit.dao.TutorUniversitarioDAO;
import it.chooseit.dao.UtenteDAO;
import it.chooseit.services.DriverManagerConnectionPool;

/**
 * Implementazione di TutorUniversitatioDAO, che definisce i metodi per gestire i dati
 * relativi ai tutor universitari iscritti alla piattaforma.
 * 
 * @author RocketStudios
 */
public class TutorUniversitario implements TutorUniversitarioDAO {

  @Override
  public synchronized TutorUniversitarioBean retrieveByKey(String email) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;

    try {
      connection = DriverManagerConnectionPool.getConnection();

      String sql = "select * from tutor_universitario where email = ?;";

      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setString(1, email);

      rs = preparedStatement.executeQuery();

      if (rs.next()) {
        TutorUniversitarioBean bean = new TutorUniversitarioBean();
        bean.setEmail(rs.getString("email"));

        //cerca dati utente
        UtenteDAO utenteDao = new Utente();
        UtenteBean utente = utenteDao.retrieveByKey(email);
        //setta dati utente
        bean.setNome(utente.getNome());
        bean.setCognome(utente.getCognome());
        bean.setDataNascita(utente.getDataNascita());
        bean.setIndirizzo(utente.getIndirizzo());
        bean.setTelefono(utente.getTelefono());
        bean.setFotoProfilo(utente.getFotoProfilo());

        //cerca dati registri tirocini - si dovrebbero settare con le istruzioni seguenti
        //RegistroTirocinioDAO registroDao = new RegistroTirocinio();
        //ArrayList<RegistroTirocinioBean> registri = (ArrayList<RegistroTirocinioBean>) registroDao.getRegistriDiTutorUniversitario(bean);
        bean.setRegistriTirocinio(null);

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
  public synchronized Collection<TutorUniversitarioBean> retrieveAll(String order) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    Collection<TutorUniversitarioBean> list = new ArrayList<>();

    try {
      connection = DriverManagerConnectionPool.getConnection();
      String sql = null;
      if(order == null || order.equals("")) {
        sql = "select * from tutor_universitario;";
      } else {
        sql = "select * from tutor_universitario order by "+order+";";
      }

      preparedStatement = connection.prepareStatement(sql);

      rs = preparedStatement.executeQuery();

      while (rs.next()) {
        TutorUniversitarioBean bean;

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
  public synchronized void insert(TutorUniversitarioBean tutor) throws SQLException {}

  public synchronized void insert(TutorUniversitarioBean tutor, String pwd) throws SQLException {	
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DriverManagerConnectionPool.getConnection();

      //inserimento dell'utente
      UtenteDAO utenteDao = new Utente();
      utenteDao.insert(tutor, pwd);

      //inserimento tutor universitario
      String sql = "insert into tutor_universitario (email) values (?);";

      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, tutor.getEmail());

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
  public synchronized void update(TutorUniversitarioBean tutor) throws SQLException {
    Connection connection = null;

    try {
      connection = DriverManagerConnectionPool.getConnection();

      UtenteDAO utenteDao = new Utente();
      utenteDao.update(tutor);

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

      String sql = "delete from tutor_universitario where email = ?;";

      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setString(1, email);

      int result = preparedStatement.executeUpdate();

      //se il tutor universitario &egrave; stato cancellato...
      if(result == 1) {
        //...cancella l'utente
        UtenteDAO utenteDao = new Utente();
        if(utenteDao.delete(email)) {
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

}
