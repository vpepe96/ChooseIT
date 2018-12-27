package it.chooseit.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import it.chooseit.bean.TutorUniversitarioBean;
import it.chooseit.dao.TutorUniversitarioDAO;
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
				TutorUniversitarioBean bean = new TutorUniversitarioBean(null, null, null, null, null, null, null);
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
				TutorUniversitarioBean bean = new TutorUniversitarioBean(null, null, null, null, null, null, null);
				bean.setEmail(rs.getString("email"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setDataNascita(rs.getDate("data_nascita"));
				bean.setIndirizzo(rs.getString("indirizzo"));
				bean.setTelefono(rs.getString("telefono"));
				bean.setFotoProfilo(rs.getString("foto_profilo"));
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
	public void insert(TutorUniversitarioBean tutor) throws SQLException { }

	public synchronized void insert(TutorUniversitarioBean tutor, String pwd) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManagerConnectionPool.getConnection();

			String sql = "insert into tutor_universitario (email, nome, cognome, data_nascita, indirizzo, telefono, pwd, foto_profilo) values (?, ?, ?, ?, ? ,?, ?, ?);";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, tutor.getEmail());
			preparedStatement.setString(2, tutor.getNome());
			preparedStatement.setString(3, tutor.getCognome());
			preparedStatement.setDate(4, tutor.getDataNascita());
			preparedStatement.setString(5, tutor.getIndirizzo());
			preparedStatement.setString(6, tutor.getTelefono());
			preparedStatement.setString(7, pwd);
			preparedStatement.setString(8, tutor.getFotoProfilo());
			
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
	public synchronized void update(TutorUniversitarioBean tutor) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManagerConnectionPool.getConnection();

			String sql = "update tutor_universitario set nome = ?, cognome = ?, data_nascita = ?, indirizzo = ?, telefono = ?, foto_profilo = ? where email = ?;";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, tutor.getNome());
			preparedStatement.setString(2, tutor.getCognome());
			preparedStatement.setDate(3, tutor.getDataNascita());
			preparedStatement.setString(4, tutor.getIndirizzo());
			preparedStatement.setString(5, tutor.getTelefono());
			preparedStatement.setString(7, tutor.getFotoProfilo());
			preparedStatement.setString(8, tutor.getEmail());
			
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
	public synchronized boolean delete(String email) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManagerConnectionPool.getConnection();
			
			String sql = "delete from tutor_universitario where email = ?;";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, email);

			int result = preparedStatement.executeUpdate();
			
			connection.commit();
			
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

}
