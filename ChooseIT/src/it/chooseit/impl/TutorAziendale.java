package it.chooseit.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import it.chooseit.bean.AziendaBean;
import it.chooseit.bean.TutorAziendaleBean;
import it.chooseit.bean.UtenteBean;
import it.chooseit.dao.AziendaDAO;
import it.chooseit.dao.TutorAziendaleDAO;
import it.chooseit.dao.UtenteDAO;
import it.chooseit.services.DriverManagerConnectionPool;

public class TutorAziendale implements TutorAziendaleDAO {
	
	@Override
	public TutorAziendaleBean retrieveByKey(String email) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			connection = DriverManagerConnectionPool.getConnection();

			String sql = "select * from tutor_aziendale where email = ?;";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, email);

			rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				TutorAziendaleBean bean = new TutorAziendaleBean(null, null, null, null, null, null, null, null);
				bean.setEmail(rs.getString("email"));
				
				UtenteDAO utenteDao = new Utente();
				UtenteBean utente = utenteDao.retrieveByKey(email);

				bean.setNome(utente.getNome());
				bean.setCognome(utente.getCognome());
				bean.setDataNascita(utente.getDataNascita());
				bean.setIndirizzo(utente.getIndirizzo());
				bean.setTelefono(utente.getTelefono());
				bean.setFotoProfilo(utente.getFotoProfilo());
				
				AziendaDAO aziendaDao = new Azienda();
				AziendaBean azienda = aziendaDao.retrieveByKey(rs.getString("ragione_sociale"));
				
				bean.setAzienda(azienda);
				
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
	public Collection<TutorAziendaleBean> retrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Collection<TutorAziendaleBean> list = new ArrayList<>();

		try {
			connection = DriverManagerConnectionPool.getConnection();
			String sql = null;
			if(order == null || order.equals("")) {
				sql = "select * from tutor_aziendale;";
			} else {
				sql = "select * from tutor_aziendale order by "+order+";";
			}

			preparedStatement = connection.prepareStatement(sql);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				TutorAziendaleBean bean;
				
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
	public synchronized void insert(TutorAziendaleBean tutor) throws SQLException {}

	public synchronized void insert(TutorAziendaleBean tutor, String pwd) throws SQLException {	
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManagerConnectionPool.getConnection();

			//inserimento dell'utente
			UtenteDAO utenteDao = new Utente();
			utenteDao.insert(tutor, pwd);
			
			//inserimento tutor aziendale
			String sql = "insert into tutor_aziendale (email) values (?);";
			
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
	public void update(TutorAziendaleBean tutor) throws SQLException {
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
	public boolean delete(String email) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManagerConnectionPool.getConnection();
			
			String sql = "delete from tutor_aziendale where email = ?;";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, email);
			
			int result = preparedStatement.executeUpdate();
			
			//se il tutor aziendale è stato cancellato...
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
	public Collection<TutorAziendaleBean> getTutorDiAzienda(AziendaBean azienda) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Collection<TutorAziendaleBean> tutor = new LinkedList<TutorAziendaleBean>();
		
		try {
			connection = DriverManagerConnectionPool.getConnection();

			String sql = "select * from utente, tutor_aziendale, azienda where ragione_sociale = " + azienda.getRagioneSociale() + "" +
							"and ragione_sociale = azienda_id" +
							"and utente.email = tutor_aziendale.email;";

			preparedStatement = connection.prepareStatement(sql);

			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				TutorAziendaleBean bean = new TutorAziendaleBean(null, null, null, null, null, null, null, null);
				bean.setEmail(rs.getString("email"));
				
				UtenteDAO utenteDao = new Utente();
				UtenteBean utente = utenteDao.retrieveByKey(rs.getString("email"));

				bean.setNome(utente.getNome());
				bean.setCognome(utente.getCognome());
				bean.setDataNascita(utente.getDataNascita());
				bean.setIndirizzo(utente.getIndirizzo());
				bean.setTelefono(utente.getTelefono());
				bean.setFotoProfilo(utente.getFotoProfilo());
				
				AziendaDAO aziendaDao = new Azienda();
				AziendaBean azienda_tutor = aziendaDao.retrieveByKey(rs.getString("ragione_sociale"));
				
				bean.setAzienda(azienda_tutor);

				tutor.add(bean);
			}
		} finally {
			try {
				if (!connection.isClosed())
					connection.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
		return tutor;
	}

}
