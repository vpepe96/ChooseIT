package it.chooseit.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import it.chooseit.bean.QuestionarioStudenteBean;
import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.TutorAziendaleBean;
import it.chooseit.dao.QuestionarioStudenteDAO;
import it.chooseit.dao.RegistroTirocinioDAO;
import it.chooseit.services.DriverManagerConnectionPool;

public class QuestionarioStudente implements QuestionarioStudenteDAO{

  @Override
  public QuestionarioStudenteBean retrieveByKey(Integer id) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;

    try {
      connection = DriverManagerConnectionPool.getConnection();

      String sql = "select * from questionario_valutativo_studente where registro_id = ?;";

      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setInt(1, id.intValue());

      rs = preparedStatement.executeQuery();

      // Cerca dati registro tirocinio
      RegistroTirocinioDAO regDao = new RegistroTirocinio();
      RegistroTirocinioBean registroBean = regDao.retrieveByKey(id);


      QuestionarioStudenteBean bean = new QuestionarioStudenteBean();

      if (rs.next()) {
        bean.setRegistroTirocinio(registroBean);
        bean.setPdt1(rs.getInt("pdt_1"));
        bean.setPdt2(rs.getInt("pdt_2"));
        bean.setPdt3(rs.getInt("pdt_3"));
        bean.setPdt4(rs.getInt("pdt_4"));

        bean.setT1(rs.getInt("t_1"));
        bean.setT2(rs.getInt("t_2"));
        bean.setT3(rs.getInt("t_3"));
        bean.setT4(rs.getInt("t_4"));

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
  public Collection<QuestionarioStudenteBean> retrieveAll(String order) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    Collection<QuestionarioStudenteBean> list = new ArrayList<>();

    try {
      connection = DriverManagerConnectionPool.getConnection();
      String sql = null;
      if (order == null || order.equals("")) {
        sql = "select * from questionario_valutativo_studente;";
      } else {
        sql = " select * from questionario_valutativo_studente order by " + order + ";";
      }

      preparedStatement = connection.prepareStatement(sql);

      rs = preparedStatement.executeQuery();

      while (rs.next()) {

        QuestionarioStudenteBean bean;

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



  @Override
  public void insert(QuestionarioStudenteBean questionario) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DriverManagerConnectionPool.getConnection();

      String sql = "insert into questionario_valutativo_studente (registro_id,pdt_1,pdt_2,pdt_3,pdt_4,t_1,t_2,t_3,t_4,su_1,su_2,su_3) values (?,?,?,?,?,?,?,?,?,?,?,?);";

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
      }else {
        preparedStatement.setInt(2, questionario.getPdt1());
        preparedStatement.setInt(3, questionario.getPdt2());
        preparedStatement.setInt(4, questionario.getPdt3());
        preparedStatement.setInt(5, questionario.getPdt4());

        preparedStatement.setInt(6, questionario.getT1());
        preparedStatement.setInt(7, questionario.getT2());
        preparedStatement.setInt(8, questionario.getT3());
        preparedStatement.setInt(9, questionario.getT4());

        preparedStatement.setInt(10, questionario.getSu1());
        preparedStatement.setInt(11, questionario.getSu2());
        preparedStatement.setInt(12, questionario.getSu3());
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
  public void update(QuestionarioStudenteBean questionario) throws SQLException {
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

      String sql = "delete from questionario_valutativo_studente where registro_id = ?;";

      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setInt(1, id.intValue());

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
  public Collection<QuestionarioStudenteBean> getQuestionarioPerTutorAziendale(TutorAziendaleBean tutor) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    Collection<QuestionarioStudenteBean> list = new ArrayList<>();

    try {
      connection = DriverManagerConnectionPool.getConnection();

      String sql = "select * from tutor_aziendale, registro_tirocinio, questionario_valutativo_studente where "
          + "tutor_aziendale.email = ? and registro_tirocinio.tutor_aziendale_email = tutor_aziendale.email and "
          + "questionario_valutativo_studente.registro_id = registro_tirocinio.identificativo;";

      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setString(1, tutor.getEmail());

      rs = preparedStatement.executeQuery();

      while (rs.next()) {
        QuestionarioStudenteBean bean;

        bean = retrieveByKey(rs.getInt("identificativo"));

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
  public Collection<QuestionarioStudenteBean> getQuestionariNonCompilati(TutorAziendaleBean tutor) throws SQLException{
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    Collection<QuestionarioStudenteBean> list = new ArrayList<>();
    try {
      connection = DriverManagerConnectionPool.getConnection();

      String sql = "select * from tutor_aziendale, registro_tirocinio, questionario_valutativo_studente,stato_tirocinio where " + 
          "					 tutor_aziendale.email = ? and registro_tirocinio.tutor_aziendale_email = tutor_aziendale.email " + 
          "					 and questionario_valutativo_studente.registro_id = registro_tirocinio.identificativo and " + 
          "					 stato_tirocinio.registro_id=registro_tirocinio.identificativo and stato_tirocinio.tipo = 'terminato' " + 
          "					 and questionario_valutativo_studente.pdt_1 is null;";

      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setString(1, tutor.getEmail());

      rs = preparedStatement.executeQuery();
      while (rs.next()) {
        QuestionarioStudenteBean bean;

        bean = retrieveByKey(rs.getInt("identificativo"));

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



}
