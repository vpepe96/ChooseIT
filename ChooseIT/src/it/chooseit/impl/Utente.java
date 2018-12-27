package it.chooseit.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import it.chooseit.bean.UtenteBean;
import it.chooseit.dao.UtenteDAO;
import it.chooseit.services.DriverManagerConnectionPool;

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

		/*
		 * //Genera hash della password SecureRandom random = new SecureRandom(); byte[]
		 * salt = new byte[16]; random.nextBytes(salt); KeySpec spec = new
		 * PBEKeySpec(pwd.toCharArray(), salt, 65536, 128); SecretKeyFactory factory =
		 * null; try { factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1"); }
		 * catch (NoSuchAlgorithmException e) { System.out.println("NoSuchAlgorithm"); }
		 * byte[] hash = null;
		 * 
		 * try { hash = factory.generateSecret(spec).getEncoded(); } catch
		 * (InvalidKeySpecException e) { System.out.println("InvalidKeySpec"); }
		 */

		// Cerca nel database la combinazione email-hash
		try {
			connection = DriverManagerConnectionPool.getConnection();

			String sql = "select * from utente where email = ? and pwd = ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, email);
			preparedStatement.setString(2, pwd);

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

	
	public synchronized void insert(UtenteBean utente, String pwd) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManagerConnectionPool.getConnection();

			String sql = "insert into utente (email, nome, cognome, data_nascita, indirizzo, telefono, pwd, foto_profilo) values (?, ?, ?, ?, ? ,?, ?, ?);";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, utente.getEmail());
			preparedStatement.setString(2, utente.getNome());
			preparedStatement.setString(3, utente.getCognome());
			preparedStatement.setDate(4, utente.getDataNascita());
			preparedStatement.setString(5, utente.getIndirizzo());
			preparedStatement.setString(6, utente.getTelefono());
			preparedStatement.setString(7, pwd);
			preparedStatement.setString(8, utente.getFotoProfilo());
			
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
	public synchronized void update(UtenteBean utente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManagerConnectionPool.getConnection();

			String sql = "update utente set nome = ?, cognome = ?, data_nascita = ?, indirizzo = ?, telefono = ?, foto_profilo = ? where email = ?;";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, utente.getNome());
			preparedStatement.setString(2, utente.getCognome());
			preparedStatement.setDate(3, utente.getDataNascita());
			preparedStatement.setString(4, utente.getIndirizzo());
			preparedStatement.setString(5, utente.getTelefono());
			preparedStatement.setString(7, utente.getFotoProfilo());
			preparedStatement.setString(8, utente.getEmail());
			
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
			
			String sql = "delete from utente where email = ?;";

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

	
	public synchronized String checkRuolo(String email) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		try {
			connection = DriverManagerConnectionPool.getConnection();

			// Controlla se l'utente è di tipo 'studente'
			String sql = "select * from studente where email = ?;";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, email);

			rs = preparedStatement.executeQuery();

			if (rs.next()) {
				return "studente";
			}

			// Controlla se l'utente è di tipo 'segreteria'
			sql = "select * from segreteria where email = ?;";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, email);

			rs = preparedStatement.executeQuery();

			if (rs.next()) {
				return "segreteria";
			}

			// Controlla se l'utente è di tipo 'presidente'
			sql = "select * from presidente where email = ?;";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, email);

			rs = preparedStatement.executeQuery();

			if (rs.next()) {
				return "presidente";
			}

			// Controlla se l'utente è di tipo 'tutorUniversitario'
			sql = "select * from tutor_universitario where email = ?;";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, email);

			rs = preparedStatement.executeQuery();

			if (rs.next()) {
				return "tutorUniversitario";
			}

			// Controlla se l'utente è di tipo 'tutorAziendale'
			sql = "select * from tutor_aziendale where email = ?;";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, email);

			rs = preparedStatement.executeQuery();

			if (rs.next()) {
				return "tutorAziendale";
			}

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
	public Collection<UtenteBean> retrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Collection<UtenteBean> list = new ArrayList<>();

		try {
			connection = DriverManagerConnectionPool.getConnection();
			String sql = null;
			if(order == null || order.equals("")) {
				sql = "select * from utente;";
			}else {
				sql = "select * from utente order by "+order+";";
			}

			preparedStatement = connection.prepareStatement(sql);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				UtenteBean bean = new UtenteBean();
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
	public void insert(UtenteBean object) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
