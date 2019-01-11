package it.chooseit.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import it.chooseit.bean.QuestionarioAziendaBean;
import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.StudenteBean;
import it.chooseit.dao.QuestionarioAziendaDAO;
import it.chooseit.dao.RegistroTirocinioDAO;
import it.chooseit.services.DriverManagerConnectionPool;

public class QuestionarioAzienda implements QuestionarioAziendaDAO {
  @Override
  public QuestionarioAziendaBean retrieveByKey(Integer id) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;

    try {
      connection = DriverManagerConnectionPool.getConnection();

      String sql = "select * from questionario_valutativo_ente_ospitante where registro_id = ?;";

      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setInt(1, id.intValue());

      rs = preparedStatement.executeQuery();

      // Cerca dati registro tirocinio
      RegistroTirocinioDAO regDao = new RegistroTirocinio();
      RegistroTirocinioBean registroBean = regDao.retrieveByKey(id);

      QuestionarioAziendaBean bean = new QuestionarioAziendaBean();

      if (rs.next()) {
        bean.setRegistroTirocinio(registroBean);
        bean.setPdt1(rs.getInt("pdt_1"));
        bean.setPdt2(rs.getInt("pdt_2"));
        bean.setPdt3(rs.getInt("pdt_3"));
        bean.setPdt4(rs.getInt("pdt_4"));
        bean.setPdt5(rs.getInt("pdt_5"));
        bean.setEo1(rs.getInt("eo_1"));
        bean.setEo2(rs.getInt("eo_2"));
        bean.setEo3(rs.getInt("eo_3"));
        bean.setEo4(rs.getInt("eo_4"));
        bean.setEo5(rs.getInt("eo_5"));
        bean.setSu1(rs.getInt("su_1"));
        bean.setSu2(rs.getInt("su_2"));
        bean.setSu3(rs.getInt("su_3"));

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
  public void insert(QuestionarioAziendaBean questionario) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DriverManagerConnectionPool.getConnection();

      String sql = "insert into questionario_valutativo_ente_ospitante (registro_id,pdt_1,pdt_2,pdt_3,pdt_4,pdt_5,eo_1,eo_2,eo_3,eo_4,eo_5,su_1,su_2,su_3) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setInt(1, questionario.getRegistroTirocinio().getIdentificativo());
      if(questionario.getPdt1() == 0) {
        preparedStatement.setNull(2, java.sql.Types.NULL);
        preparedStatement.setNull(3, java.sql.Types.NULL);
        preparedStatement.setNull(4, java.sql.Types.NULL);
        preparedStatement.setNull(5, java.sql.Types.NULL);
        preparedStatement.setNull(6, java.sql.Types.NULL);
        preparedStatement.setNull(7, java.sql.Types.NULL);
        preparedStatement.setNull(8, java.sql.Types.NULL);
        preparedStatement.setNull(9, java.sql.Types.NULL);
        preparedStatement.setNull(10, java.sql.Types.NULL);
        preparedStatement.setNull(11, java.sql.Types.NULL);
        preparedStatement.setNull(12, java.sql.Types.NULL);
        preparedStatement.setNull(13, java.sql.Types.NULL);
        preparedStatement.setNull(14, java.sql.Types.NULL);
      }else {
        preparedStatement.setInt(2, questionario.getPdt1());
        preparedStatement.setInt(3, questionario.getPdt2());
        preparedStatement.setInt(4, questionario.getPdt3());
        preparedStatement.setInt(5, questionario.getPdt4());
        preparedStatement.setInt(6, questionario.getPdt5());
        preparedStatement.setInt(7, questionario.getEo1());
        preparedStatement.setInt(8, questionario.getEo2());
        preparedStatement.setInt(9, questionario.getEo3());
        preparedStatement.setInt(10, questionario.getEo4());
        preparedStatement.setInt(11, questionario.getEo5());
        preparedStatement.setInt(12, questionario.getSu1());
        preparedStatement.setInt(13, questionario.getSu2());
        preparedStatement.setInt(14, questionario.getSu3());
      }


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
  public void update(QuestionarioAziendaBean questionario) throws SQLException {
    if (delete(questionario.getRegistroTirocinio().getIdentificativo())) {
      insert(questionario);
    }

  }

  @Override
  public boolean delete(Integer id) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DriverManagerConnectionPool.getConnection();

      String sql = "delete from questionario_valutativo_ente_ospitante where registro_id = ?;";

      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setInt(1, id.intValue());

      int result = preparedStatement.executeUpdate();
      if (result == 1) {
        System.out.println("Cancellato");
        return true;
      } else {
        System.out.println("non cancellato");
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
  public Collection<QuestionarioAziendaBean> getQuestionarioPerStudente(StudenteBean studente) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    Collection<QuestionarioAziendaBean> list = new ArrayList<>();

    try {
      connection = DriverManagerConnectionPool.getConnection();

      String sql = "select * from studente, registro_tirocinio, questionario_valutativo_ente_ospitante where "
          + "studente.email = ? and registro_tirocinio.studente_email = studente.email and "
          + "questionario_valutativo_ente_ospitante.registro_id = registro_tirocinio.identificativo and questionario_valutativo_ente_ospitante.pdt_1 is null;";

      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setString(1, studente.getEmail());

      rs = preparedStatement.executeQuery();

      while (rs.next()) {
        QuestionarioAziendaBean bean;

        bean = retrieveByKey(rs.getInt("registro_id"));

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
  public Collection<QuestionarioAziendaBean> retrieveAll(String order) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    Collection<QuestionarioAziendaBean> list = new ArrayList<>();

    try {
      connection = DriverManagerConnectionPool.getConnection();
      String sql = null;
      if (order == null || order.equals("")) {
        sql = "select * from questionario_valutativo_ente_ospitante;";
      } else {
        sql = " select * from questionario_valutativo_ente_ospitante order by " + order + ";";
      }

      preparedStatement = connection.prepareStatement(sql);

      rs = preparedStatement.executeQuery();

      while (rs.next()) {

        QuestionarioAziendaBean bean;

        bean = retrieveByKey(rs.getInt("registro_id"));

        list.add(bean);
      }
    } finally {
      try {
        if (!connection.isClosed())
          connection.close();
      } finally {
        DriverManagerConnectionPool.releaseConnection(connection);
      }
    }
    return list;

  }
}