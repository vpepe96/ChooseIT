package it.chooseit.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.StudenteBean;
import it.chooseit.bean.TutorAziendaleBean;
import it.chooseit.bean.TutorUniversitarioBean;
import it.chooseit.dao.RegistroTirocinioDAO;
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

			int identificativo = 0;
			Date dataInizio = null;
			StudenteBean studente = new StudenteBean();
			TutorAziendaleBean tutorAziendale = new TutorAziendaleBean();
			TutorUniversitarioBean tutorUniversitario = new TutorUniversitarioBean(null, null, null, null, null, null,
					null);

			if (rs.next()) {
				identificativo = key.intValue();
				studente.setEmail(rs.getString("studente_email"));
				tutorAziendale.setEmail(rs.getString("tutor_aziendale_email"));
				tutorUniversitario.setEmail(rs.getString("tutor_universitario_email"));
				dataInizio = rs.getDate("data_inizio");
			}

			// Cerca dati studente
			StudenteDAO studenteDao = new Studente();
			studente = studenteDao.retrieveByKey(studente.getEmail());

			// Cerca dati tutor universitario
			TutorUniversitarioDAO tutorUniDao = new TutorUniversitario();
			tutorUniversitario = tutorUniDao.retrieveByKey(tutorUniversitario.getEmail());

			// Carca dati tutor aziendale
			TutorAziendaleDAO tutorAziDao = new TutorAziendale();
			tutorAziendale = tutorAziDao.retrieveByKey(tutorAziendale.getEmail());
			

			RegistroTirocinioBean registro = new RegistroTirocinioBean(identificativo, dataInizio, studente,
					tutorAziendale, tutorUniversitario);
			return registro;
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

			String sql = "insert into registro_tirocinio (identificativo, studente_email, data_inizio, tutor_aziendale_email, tutor_universitario_email) values (?, ?, ?, ?, ?);";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, object.getIdentificativo());
			preparedStatement.setString(2, object.getStudente().getEmail());
			preparedStatement.setDate(3, object.getDataInizio());
			preparedStatement.setString(4, object.getTutorAziendale().getEmail());
			preparedStatement.setString(5, object.getTutorUniversitario().getEmail());

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

			String sql = "update registro_tirocinio set tutor_aziendale_email = ?, tutor_universitario_email = ?  where identificativo = ?;";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, object.getTutorAziendale().getEmail());
			preparedStatement.setString(2, object.getTutorUniversitario().getEmail());
			preparedStatement.setInt(3, object.getIdentificativo());

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
