package it.chooseit.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
				bean.setDataNascita(rs.getDate("dataNascita"));
				bean.setIndirizzo(rs.getString("indirizzo"));
				bean.setTelefono(rs.getString("telefono"));
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
	public synchronized ArrayList<UtenteBean> retrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		ArrayList<UtenteBean> list = new ArrayList<>();

		try {
			connection = DriverManagerConnectionPool.getConnection();

			String sql = "select * from utente;";

			preparedStatement = connection.prepareStatement(sql);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				UtenteBean bean = new UtenteBean();
				bean.setEmail(rs.getString("email"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setDataNascita(rs.getDate("dataNascita"));
				bean.setIndirizzo(rs.getString("indirizzo"));
				bean.setTelefono(rs.getString("telefono"));
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
	public synchronized void insert(UtenteBean utente, String pwd) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public synchronized void update(String email, UtenteBean utente) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public synchronized void delete(String email) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
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

}
