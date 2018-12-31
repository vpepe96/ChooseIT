package it.chooseit.impl;

/**
 * 
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import it.chooseit.bean.AziendaBean;
import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.RichiestaTirocinioBean;
import it.chooseit.bean.StudenteBean;
import it.chooseit.dao.AziendaDAO;
import it.chooseit.dao.RegistroTirocinioDAO;
import it.chooseit.dao.RichiestaTirocinioDAO;
import it.chooseit.dao.StudenteDAO;
import it.chooseit.services.DriverManagerConnectionPool;

public class RichiestaTirocinio implements RichiestaTirocinioDAO{

	public RichiestaTirocinioBean retrieveByKey(Integer key) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatament = null;

		String selectSQL = "SELECT * FROM richiesta_tirocinio WHERE id = ?;";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatament = connection.prepareStatement(selectSQL);

			preparedStatament.setInt(1, key.intValue());

			System.out.println("doRetrieveByKey:" + preparedStatament.toString());

			ResultSet rs = preparedStatament.executeQuery();

			StudenteBean studente = new StudenteBean();
			AziendaBean azienda = new AziendaBean();
			RegistroTirocinioBean registroTirocinio = new RegistroTirocinioBean();
			
			RichiestaTirocinioBean richiesta = new RichiestaTirocinioBean();
			
			if (rs.next()) {
				richiesta.setId(key.intValue());
				
				// Cerca dati studente
				StudenteDAO studenteDao = new Studente();
				studente = studenteDao.retrieveByKey(studente.getEmail());			
				richiesta.setStudenteEmail(studente);
				
				//Cerca dati registro di tirocnio
				RegistroTirocinioDAO registroTirocinioDao = new RegistroTirocinio();
				registroTirocinio = registroTirocinioDao.retrieveByKey(registroTirocinio.getIdentificativo());
				richiesta.setRegistroTirocinio(registroTirocinio);
				
				//Cerca dati azienda
				AziendaDAO aziendaDao = new Azienda();
				azienda = aziendaDao.retrieveByKey(azienda.getRagioneSociale());
				richiesta.setAzienda(azienda);
				
				richiesta.setProgettoFormativo(rs.getString("progetto_formativo"));
				
				richiesta.setDataRichiesta(rs.getDate("data_richiesta"));
				
				// settare con StatoRichiestaDAO.getStatiRichiesta(RichiestaTirocinioBean bean)
				richiesta.setStatiRichiesta(null);
			}
			
			return richiesta;
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
	public Collection<RichiestaTirocinioBean> retrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Collection<RichiestaTirocinioBean> list = new ArrayList<>();

		try {
			connection = DriverManagerConnectionPool.getConnection();
			String sql = null;
			if (order == null || order.equals("")) {
				sql = "select * from richiesta_tirocinio;";
			} else {
				sql = "select * from richiesta_tirocinio order by " + order + ";";
			}

			preparedStatement = connection.prepareStatement(sql);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				RichiestaTirocinioBean bean;

				int id = rs.getInt("id");

				bean = retrieveByKey(id);

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
	public synchronized void insert(RichiestaTirocinioBean richiestaTirocinio) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO richiesta_tirocinio(studente_email,registro_id,ragione_sociale_azienda,progetto_formativo,data_richiesta) VALUES (?, ?, ?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setString(1, richiestaTirocinio.getStudente().getEmail());
			preparedStatement.setInt(2, richiestaTirocinio.getRegistroTirocinio().getIdentificativo());
			preparedStatement.setString(3, richiestaTirocinio.getAzienda().getRagioneSociale());
			preparedStatement.setString(4, richiestaTirocinio.getProgettoFormativo());
			preparedStatement.setDate(5, richiestaTirocinio.getDataRichiesta());
			
			System.out.println("doSave: "+ preparedStatement.toString());
			preparedStatement.executeUpdate();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
	}

	@Override
	public synchronized void update(RichiestaTirocinioBean richiestaTirocinio) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String updateSQL = "UPDATE richiesta_tirocinio SET studente_email = ?, registro_id = ?, ragione_sociale_azienda = ?, progetto_formativo = ?, data_richiesta = ?" + 
						   "WHERE id = ?;";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			
			preparedStatement = connection.prepareStatement(updateSQL);
			
			preparedStatement.setString(1, richiestaTirocinio.getStudente().getEmail());
			preparedStatement.setInt(2, richiestaTirocinio.getRegistroTirocinio().getIdentificativo());
			preparedStatement.setString(3, richiestaTirocinio.getAzienda().getRagioneSociale());
			preparedStatement.setString(4, richiestaTirocinio.getProgettoFormativo());
			preparedStatement.setDate(5, richiestaTirocinio.getDataRichiesta());
			preparedStatement.setInt(6, richiestaTirocinio.getId());
			
			System.out.println("doUpdate: "+ preparedStatement.toString());
			preparedStatement.executeUpdate();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
	}

	@Override
	public boolean delete(Integer key) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM richiesta_tirocinio WHERE id = ?;";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			
			preparedStatement.setInt(1, key.intValue());

			System.out.println("doDelete: "+ preparedStatement.toString());
			result = preparedStatement.executeUpdate();

			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return (result != 0);
	}

	@Override
	public Collection<RichiestaTirocinioBean> getRichiestePerAzienda(AziendaBean azienda) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ArrayList<RichiestaTirocinioBean> list = new ArrayList<>();

		try {
			connection = DriverManagerConnectionPool.getConnection();

			String sql = "SELECT * FROM richiesta_tirocinio WHERE ragione_sociale_azienda = ?;";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, azienda.getRagioneSociale());
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				RichiestaTirocinioBean bean;
				
				bean = retrieveByKey(rs.getInt("id"));
				
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
	public Collection<RichiestaTirocinioBean> getRichiestePerStato(String stato) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Collection<RichiestaTirocinioBean> richiesteTirocinio = new ArrayList<RichiestaTirocinioBean>();

		try {
			connection = DriverManagerConnectionPool.getConnection();

			String selectSQL = "SELECT data_richiesta, id, progetto_formativo, ragione_sociale_azienda, registro_id, studente_email " + 
							   "FROM richiesta_tirocinio JOIN stato_richiesta ON richiesta_tirocinio.id = stato_richiesta.richiesta_id " + 
						       "WHERE stato_richiesta.tipo = ?";

			preparedStatement = connection.prepareStatement(selectSQL);

			preparedStatement.setString(1, stato);
			
			ResultSet rs = preparedStatement.executeQuery();
			Azienda az = new Azienda();
			RegistroTirocinio reg = new RegistroTirocinio();
			Studente st = new Studente();
			
			while (rs.next()) {
				RichiestaTirocinioBean bean = new RichiestaTirocinioBean();
				
				bean.setAzienda(az.retrieveByKey(rs.getString("ragione_sociale_azienda")));
				bean.setDataRichiesta(rs.getDate("data_richiesta"));
				bean.setId(rs.getInt("id"));
				bean.setProgettoFormativo(rs.getString("progetto_formativo"));
				bean.setRegistroTirocinio(reg.retrieveByKey(rs.getInt("registro_id")));
				bean.setStatiRichiesta(null);
				bean.setStudenteEmail(st.retrieveByKey(rs.getString("studente_email")));
				
				richiesteTirocinio.add(bean);
			}

			return richiesteTirocinio;
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
	public Collection<RichiestaTirocinioBean> getRichiestePerStudente(StudenteBean studente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Collection<RichiestaTirocinioBean> richiesteTirocinio = new ArrayList<RichiestaTirocinioBean>();

		try {
			connection = DriverManagerConnectionPool.getConnection();

			String selectSQL = "SELECT * " + 
							   "FROM richiesta_tirocinio " + 
							   "WHERE richiesta_tirocinio.studente_email = ?";

			preparedStatement = connection.prepareStatement(selectSQL);

			preparedStatement.setString(1, studente.getEmail());
			
			ResultSet rs = preparedStatement.executeQuery();
			Azienda az = new Azienda();
			RegistroTirocinio reg = new RegistroTirocinio();
			Studente st = new Studente();
			
			while (rs.next()) {
				RichiestaTirocinioBean bean = new RichiestaTirocinioBean();
				
				bean.setAzienda(az.retrieveByKey(rs.getString("ragione_sociale_azienda")));
				bean.setDataRichiesta(rs.getDate("data_richiesta"));
				bean.setId(rs.getInt("id"));
				bean.setProgettoFormativo(rs.getString("progetto_formativo"));
				bean.setRegistroTirocinio(reg.retrieveByKey(rs.getInt("registro_id")));
				bean.setStatiRichiesta(null);
				bean.setStudenteEmail(st.retrieveByKey(rs.getString("studente_email")));
				
				richiesteTirocinio.add(bean);
			}

			return richiesteTirocinio;
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
