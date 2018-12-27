package it.chooseit.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import it.chooseit.bean.StudenteBean;
import it.chooseit.bean.TutorAziendaleBean;
import it.chooseit.bean.TutorUniversitarioBean;
import it.chooseit.dao.StudenteDAO;
import it.chooseit.services.DriverManagerConnectionPool;

/**
 * Implementazione di StudenteDAO, che definisce i metodi per gestire i dati
 * relativi agli studenti.
 */
public class Studente implements StudenteDAO {

	
	@Override
	public synchronized StudenteBean retrieveByKey(String email) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		try {
			connection = DriverManagerConnectionPool.getConnection();

			String sql = "select * from utente,studente where utente.email = ? and studente.email = ?;";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, email);
			preparedStatement.setString(2, email);

			rs = preparedStatement.executeQuery();

			StudenteBean bean = new StudenteBean();
			if (rs.next()) {
				bean.setEmail(rs.getString("email"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setDataNascita(rs.getDate("data_nascita"));
				bean.setIndirizzo(rs.getString("indirizzo"));
				bean.setTelefono(rs.getString("telefono"));
				bean.setFotoProfilo(rs.getString("foto_profilo"));
				bean.setMatricola(rs.getString("matricola"));
				bean.setDescrizione(rs.getString("descrizione"));
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
	public synchronized Collection<StudenteBean> retrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Collection<StudenteBean> list = new ArrayList<>();

		try {
			connection = DriverManagerConnectionPool.getConnection();
			String sql = null;
			if(order == null || order.equals("")) {
				sql = "select * from utente,studente where utente.email = studente.email;";
			}else {
				sql = "select * from utente,studente where utente.email = studente.email order by "+order+";";
			}

			preparedStatement = connection.prepareStatement(sql);

			rs = preparedStatement.executeQuery();
			
			
			while (rs.next()) {
				StudenteBean bean = new StudenteBean();
				bean.setEmail(rs.getString("email"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setDataNascita(rs.getDate("data_nascita"));
				bean.setIndirizzo(rs.getString("indirizzo"));
				bean.setTelefono(rs.getString("telefono"));
				bean.setFotoProfilo(rs.getString("foto_profilo"));
				bean.setMatricola(rs.getString("matricola"));
				bean.setDescrizione(rs.getString("descrizione"));
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
	public void insert(StudenteBean studente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManagerConnectionPool.getConnection();

			String sql = "insert into studente (email, matricola, descrizione) values (?,?,?);";

			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, studente.getEmail());
			preparedStatement.setString(2, studente.getMatricola());
			preparedStatement.setString(3, studente.getDescrizione());
			
			preparedStatement.executeUpdate();
			
			connection.commit();
			
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
	public void update(StudenteBean utente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManagerConnectionPool.getConnection();

			String sql = "update studente set descrizione = ? where email = ?;";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, utente.getDescrizione());
			preparedStatement.setString(2, utente.getEmail());
			
			preparedStatement.executeUpdate();

			connection.commit();
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
	public boolean delete(String email) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManagerConnectionPool.getConnection();
			
			String sql = "delete from studente where email = ?;";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, email);

			connection.commit();
			
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
	public Collection<StudenteBean> getStudentiAssociati(TutorAziendaleBean tutor) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Collection<StudenteBean> list = new ArrayList<>();

		try {
			connection = DriverManagerConnectionPool.getConnection();

			String sql = "select * from utente,studente,registro_tirocinio where "
					+ "registro_tirocinio.tutor_aziendale_email = ? and "
					+ "registro_tirocinio.studente_email = studente.email and "
					+ "studente.email = utente.email;";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, tutor.getEmail());
			
			rs = preparedStatement.executeQuery();
			
			
			while (rs.next()) {
				StudenteBean bean = new StudenteBean();
				bean.setEmail(rs.getString("email"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setDataNascita(rs.getDate("data_nascita"));
				bean.setIndirizzo(rs.getString("indirizzo"));
				bean.setTelefono(rs.getString("telefono"));
				bean.setFotoProfilo(rs.getString("foto_profilo"));
				bean.setMatricola(rs.getString("matricola"));
				bean.setDescrizione(rs.getString("descrizione"));
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
	public Collection<StudenteBean> getStudentiAssociati(TutorUniversitarioBean tutor) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		ArrayList<StudenteBean> list = new ArrayList<>();

		try {
			connection = DriverManagerConnectionPool.getConnection();

			String sql = "select * from utente,studente,registro_tirocinio where "
					+ "registro_tirocinio.tutor_universitario_email = ? and "
					+ "registro_tirocinio.studente_email = studente.email and "
					+ "studente.email = utente.email;";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, tutor.getEmail());
			
			rs = preparedStatement.executeQuery();
			
			
			while (rs.next()) {
				StudenteBean bean = new StudenteBean();
				bean.setEmail(rs.getString("email"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setDataNascita(rs.getDate("data_nascita"));
				bean.setIndirizzo(rs.getString("indirizzo"));
				bean.setTelefono(rs.getString("telefono"));
				bean.setFotoProfilo(rs.getString("foto_profilo"));
				bean.setMatricola(rs.getString("matricola"));
				bean.setDescrizione(rs.getString("descrizione"));
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
