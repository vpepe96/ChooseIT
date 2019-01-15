package it.chooseit.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.RichiestaTirocinioBean;
import it.chooseit.bean.StudenteBean;
import it.chooseit.bean.TutorAziendaleBean;
import it.chooseit.bean.TutorUniversitarioBean;
import it.chooseit.dao.RegistroTirocinioDAO;
import it.chooseit.dao.RichiestaTirocinioDAO;
import it.chooseit.dao.StudenteDAO;
import it.chooseit.dao.TutorAziendaleDAO;
import it.chooseit.dao.TutorUniversitarioDAO;
import it.chooseit.services.DriverManagerConnectionPool;

public class RegistroTirocinio implements RegistroTirocinioDAO {

  @Override
  public RegistroTirocinioBean retrieveByKey(Integer key) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatament = null;

    String selectSQL = "SELECT * FROM registro_tirocinio WHERE identificativo = ?;";

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatament = connection.prepareStatement(selectSQL);

      preparedStatament.setInt(1, key.intValue());

      System.out.println("doRetrieveByKey:" + preparedStatament.toString());

      ResultSet rs = preparedStatament.executeQuery();

      if (rs.next()) {

        RegistroTirocinioBean registro = new RegistroTirocinioBean();

        int identificativo = key.intValue();
        registro.setIdentificativo(identificativo);

        Date dataInizio = rs.getDate("data_inizio");
        registro.setDataInizio(dataInizio);

        // Cerca dati studente
        StudenteDAO studenteDao = new Studente();
        StudenteBean studente = studenteDao.retrieveByKey(rs.getString("studente_email"));
        registro.setStudente(studente);

        // Cerca dati tutor universitario
        TutorUniversitarioDAO tutorUniDao = new TutorUniversitario();
        TutorUniversitarioBean tutorUniversitario = tutorUniDao.retrieveByKey(rs.getString("tutor_universitario_email"));
        registro.setTutorUniversitario(tutorUniversitario);

        // Cerca dati tutor aziendale
        TutorAziendaleDAO tutorAziDao = new TutorAziendale();
        TutorAziendaleBean tutorAziendale = tutorAziDao.retrieveByKey(rs.getString("tutor_aziendale_email"));
        registro.setTutorAziendale(tutorAziendale);

        // Cerca i dati della richiesta di tirocinio
        RichiestaTirocinioDAO ricTiDao = new RichiestaTirocinio();
        RichiestaTirocinioBean richiestaTirocinio = ricTiDao.retrieveByKey(rs.getInt("richiesta_id"));
        registro.setRichiestaTirocinio(richiestaTirocinio);

        // settare con ReportDAO.getReportRegistro(RegistroTirocinioBean bean) 
        registro.setReports(null);

        // settare con StatoTirocinioDAO.getStatiTirocinio(RegistroTirocinioBean bean)
        registro.setStatiTirocinio(null);

        // settare con QuestionarioAziendaDAO.retrieveByKey(registro.getIdentificativo())
        registro.setQuestionarioAzienda(null);

        // settare con QuestionarioStudenteDAO.retrieveByKey(registro.getIdentificativo())
        registro.setQuestionarioStudente(null);

        return registro;
      }else {
        return null;
      }

    } finally {
      try {
        if (preparedStatament != null)
          preparedStatament.close();
      } finally {
        DriverManagerConnectionPool.releaseConnection(connection);
      }
    }
  }

  @Override
  public Collection<RegistroTirocinioBean> retrieveAll(String order) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    Collection<RegistroTirocinioBean> list = new ArrayList<>();

    try {
      connection = DriverManagerConnectionPool.getConnection();
      String sql = null;
      if (order == null || order.equals("")) {
        sql = "select * from registro_tirocinio;";
      } else {
        sql = "select * from registro_tirocinio order by " + order + ";";
      }

      preparedStatement = connection.prepareStatement(sql);

      rs = preparedStatement.executeQuery();

      while (rs.next()) {
        RegistroTirocinioBean bean;

        int identificativo = rs.getInt("identificativo");

        bean = retrieveByKey(identificativo);

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
  public void insert(RegistroTirocinioBean object) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DriverManagerConnectionPool.getConnection();

      String sql = "insert into registro_tirocinio (studente_email, data_inizio, tutor_aziendale_email, tutor_universitario_email, richiesta_id) values (?, ?, ?, ?, ?);";

      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setString(1, object.getStudente().getEmail());
      preparedStatement.setDate(2, object.getDataInizio());
      preparedStatement.setString(3, object.getTutorAziendale().getEmail());
      preparedStatement.setString(4, object.getTutorUniversitario().getEmail());
      preparedStatement.setInt(5, object.getRichiestaTirocinio().getId());

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
  public void update(RegistroTirocinioBean object) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DriverManagerConnectionPool.getConnection();

      String sql = "update registro_tirocinio set tutor_aziendale_email = ?, tutor_universitario_email = ?, richiesta_id = ?  where identificativo = ?;";

      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setString(1, object.getTutorAziendale().getEmail());
      preparedStatement.setString(2, object.getTutorUniversitario().getEmail());
      preparedStatement.setInt(3, object.getRichiestaTirocinio().getId());
      preparedStatement.setInt(4, object.getIdentificativo());

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
  public boolean delete(Integer key) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DriverManagerConnectionPool.getConnection();

      String sql = "delete from registro_tirocinio where identificativo = ?;";

      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setInt(1, key.intValue());

      int result = preparedStatement.executeUpdate();

      if(result == 1) {
        ArrayList<RegistroTirocinioBean> list = (ArrayList<RegistroTirocinioBean>) retrieveAll("identificativo");
        int id = 0;
        for (RegistroTirocinioBean registroTirocinioBean : list) {
          id = registroTirocinioBean.getIdentificativo();
        }
        id++;
        sql = "alter table registro_tirocinio auto_increment = "+id+";";
        return true;
      }else {
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
  public Collection<RegistroTirocinioBean> getRegistriDiStudente(StudenteBean studente) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    ArrayList<RegistroTirocinioBean> list = new ArrayList<>();

    try {
      connection = DriverManagerConnectionPool.getConnection();

      String sql = "select * from registro_tirocinio where studente_email = ?;";

      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setString(1, studente.getEmail());

      rs = preparedStatement.executeQuery();

      while (rs.next()) {
        RegistroTirocinioBean bean;

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
  public Collection<RegistroTirocinioBean> getRegistriDiTutorAziendale(TutorAziendaleBean t) throws SQLException{
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    ArrayList<RegistroTirocinioBean> list = new ArrayList<>();

    try {
      connection = DriverManagerConnectionPool.getConnection();

      String sql = "select * from registro_tirocinio where tutor_aziendale_email = ?;";

      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setString(1, t.getEmail());

      rs = preparedStatement.executeQuery();

      while (rs.next()) {
        RegistroTirocinioBean bean;

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
  public Collection<RegistroTirocinioBean> getRegistriDiTutorUniversitario(TutorUniversitarioBean t) throws SQLException{
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    ArrayList<RegistroTirocinioBean> list = new ArrayList<>();

    try {
      connection = DriverManagerConnectionPool.getConnection();

      String sql = "select * from registro_tirocinio where tutor_universitario_email = ?;";

      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setString(1, t.getEmail());

      rs = preparedStatement.executeQuery();

      while (rs.next()) {
        RegistroTirocinioBean bean;

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
  public Collection<RegistroTirocinioBean> getRegistriDiTirociniInCorso() throws SQLException{
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    ArrayList<RegistroTirocinioBean> list = new ArrayList<>();

    try {
      connection = DriverManagerConnectionPool.getConnection();

      String sql = "select * from stato_tirocinio where stato_tirocinio.registro_id not in "
          + "(select registro_id from stato_tirocinio where "
          + "stato_tirocinio.tipo = 'annullato' OR stato_tirocinio.tipo = 'terminato');";

      preparedStatement = connection.prepareStatement(sql);

      rs = preparedStatement.executeQuery();

      while (rs.next()) {
        RegistroTirocinioBean bean;

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
  public Collection<RegistroTirocinioBean> getRegistriDiTirociniTerminati() throws SQLException{
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    ArrayList<RegistroTirocinioBean> list = new ArrayList<>();

    try {
      connection = DriverManagerConnectionPool.getConnection();

      String sql = "select * from stato_tirocinio where stato_tirocinio.tipo = 'terminato';";

      preparedStatement = connection.prepareStatement(sql);

      rs = preparedStatement.executeQuery();

      //Per ogni stato trovare il registro associato...
      while (rs.next()) {
        RegistroTirocinioBean bean;

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

}
