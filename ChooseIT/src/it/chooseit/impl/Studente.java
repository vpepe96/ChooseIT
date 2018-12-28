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
import it.chooseit.bean.UtenteBean;
import it.chooseit.dao.StudenteDAO;
import it.chooseit.dao.UtenteDAO;
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

			String sql = "select * from studente where studente.email = ?;";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, email);

			rs = preparedStatement.executeQuery();

			StudenteBean bean = new StudenteBean();
			if (rs.next()) {
				bean.setEmail(rs.getString("email"));
				bean.setMatricola(rs.getString("matricola"));
				bean.setDescrizione(rs.getString("descrizione"));
				
				UtenteDAO utenteDao = new Utente();
				UtenteBean utente = utenteDao.retrieveByKey(email);

				bean.setNome(utente.getNome());
				bean.setCognome(utente.getCognome());
				bean.setDataNascita(utente.getDataNascita());
				bean.setIndirizzo(utente.getIndirizzo());
				bean.setTelefono(utente.getTelefono());
				bean.setFotoProfilo(utente.getFotoProfilo());
				
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
				sql = "select * from studente;";
			}else {
				sql = "select * from studente order by "+order+";";
			}

			preparedStatement = connection.prepareStatement(sql);

			rs = preparedStatement.executeQuery();
			
			
			while (rs.next()) {
				StudenteBean bean = new StudenteBean();
				
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
	public synchronized void insert(StudenteBean studente) throws SQLException {}

	@Override
	public synchronized void update(StudenteBean utente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManagerConnectionPool.getConnection();

			String sql = "update studente set descrizione = ? where email = ?;";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, utente.getDescrizione());
			preparedStatement.setString(2, utente.getEmail());
			
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
			
			String sql = "delete from studente where email = ?;";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, email);
			
			int result = preparedStatement.executeUpdate();
			
			//se lo studente è stato cancellato...
			if(result == 1) {
				//...cancella l'utente
				UtenteDAO utenteDao = new Utente();
				if(utenteDao.delete(email)) {
					//se l'utente è stato cancellato return true
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


	@Override
	public synchronized Collection<StudenteBean> getStudentiAssociati(TutorAziendaleBean tutor) throws SQLException {
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
	public synchronized Collection<StudenteBean> getStudentiAssociati(TutorUniversitarioBean tutor) throws SQLException {
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

	@Override
	public void insert(StudenteBean studente, String pwd) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManagerConnectionPool.getConnection();

			//inserimento dell'utente
			UtenteDAO utenteDao = new Utente();
			utenteDao.insert(studente, pwd);
			
			//inserimento studente
			String sql = "insert into studente (email, matricola, descrizione) values (?,?,?);";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, studente.getEmail());
			preparedStatement.setString(2, studente.getMatricola());
			preparedStatement.setString(3, studente.getDescrizione());
			
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

}
