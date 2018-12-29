package it.chooseit.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import it.chooseit.bean.AziendaBean;
import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.RichiestaTirocinioBean;
import it.chooseit.bean.StatoReportBean;
import it.chooseit.bean.StudenteBean;
import it.chooseit.dao.AziendaDAO;
import it.chooseit.dao.RegistroTirocinioDAO;
import it.chooseit.dao.RichiestaTirocinioDAO;
import it.chooseit.dao.StudenteDAO;
import it.chooseit.services.ConvertEnum;
import it.chooseit.services.DriverManagerConnectionPool;
import it.chooseit.services.ReportKey;

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

			int identificativo = 0;
			StudenteBean studente = new StudenteBean();
			Date dataRichiesta = null;
			AziendaBean azienda = new AziendaBean();
			String progettoFormativo = null;
			RegistroTirocinioBean registroTirocinio = new RegistroTirocinioBean();
			
			if (rs.next()) {
				identificativo = key.intValue();
				studente.setEmail(rs.getString("studente_email"));
				dataRichiesta = rs.getDate("data_richiesta");
				azienda.setRagioneSociale(rs.getString("ragione_sociale_azienda"));
				progettoFormativo = rs.getString("progetto_formativo");
				registroTirocinio.setIdentificativo(rs.getInt("registro_id"));
			}

			// Cerca dati studente
			StudenteDAO studenteDao = new Studente();
			studente = studenteDao.retrieveByKey(studente.getEmail());			

			//Cerca dati registro di tirocnio
			RegistroTirocinioDAO registroTirocinioDao = new RegistroTirocinio();
			registroTirocinio = registroTirocinioDao.retrieveByKey(registroTirocinio.getIdentificativo());
			
			//Cerca dati azienda
			AziendaDAO aziendaDao = new Azienda();
			azienda = aziendaDao.retrieveByKey(azienda.getRagioneSociale());
			
			RichiestaTirocinioBean registro = new RichiestaTirocinioBean(identificativo, studente, dataRichiesta, azienda, progettoFormativo, registroTirocinio, null);
			
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
	public Collection<RichiestaTirocinioBean> retrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ConvertEnum convert = new ConvertEnum();
		
		Collection<RichiestaTirocinioBean> richiesteTirocinio = new ArrayList<RichiestaTirocinioBean>();
		
		String selectSQL = "SELECT * FROM richiesta_tirocinio";
		
		if(order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			
			System.out.println("doRetrieveAll:" + preparedStatement.toString());
			
			ResultSet rs = preparedStatement.executeQuery();
			Azienda az = new Azienda();
			RegistroTirocinio reg = new RegistroTirocinio();
			StatoRichiesta stric = new StatoRichiesta();
			Studente st = new Studente();
			
			while(rs.next()) {
				RichiestaTirocinioBean bean = new RichiestaTirocinioBean();
				
				bean.setAzienda(az.retrieveByKey(rs.getString("ragione_sociale_azienda")));
				bean.setDataRichiesta(rs.getDate("data_richiesta"));
				bean.setId(rs.getInt("id"));
				bean.setProgettoFormativo(rs.getString("progetto_formativo"));
				bean.setRegistroTirocinio(reg.retrieveByKey(rs.getInt("registro_id")));
				bean.setStatiRichiesta((ArrayList) stric.getStatiRichiesta(retrieveByKey(rs.getInt("id"))));
				bean.setStudenteEmail(st.retrieveByKey(rs.getString("studente_email")));
				
				richiesteTirocinio.add(bean);
			}
		} finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
		return richiesteTirocinio;
	}

	@Override
	public synchronized void insert(RichiestaTirocinioBean richiestaTirocinio) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO richiesta_tirocinio(id,studente_email,registro_id,ragione_sociale_azienda,progetto_formativo,data_richiesta) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setInt(1, richiestaTirocinio.getId());
			preparedStatement.setString(2, richiestaTirocinio.getStudente().getEmail());
			preparedStatement.setInt(3, richiestaTirocinio.getRegistroTirocinio().getIdentificativo());
			preparedStatement.setString(4, richiestaTirocinio.getAzienda().getRagioneSociale());
			preparedStatement.setString(5, richiestaTirocinio.getProgettoFormativo());
			preparedStatement.setDate(6, richiestaTirocinio.getDataRichiesta());
			
			System.out.println("doSave: "+ preparedStatement.toString());
			preparedStatement.executeUpdate();

			connection.commit();
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
						   "WHERE id = ?";

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

			connection.commit();
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

		String deleteSQL = "DELETE FROM richiesta_tirocinio WHERE id = ?";

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
	public Collection<RichiestaTirocinioBean> getRichiestaPerStato(String stato) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Collection<RichiestaTirocinioBean> richiesteTirocinio = new ArrayList<RichiestaTirocinioBean>();

		try {
			connection = DriverManagerConnectionPool.getConnection();

			String selectSQL = "SELECT data_richiesta, id, progetto_formativo, ragione_sociale_azienda, registro_id, studente_email\r\n" + 
							   "FROM richiesta_tirocinio JOIN stato_richiesta ON richiesta_tirocinio.id = stato_richiesta.richiesta_id\r\n" + 
						       "WHERE stato_richiesta.tipo = ?";

			preparedStatement = connection.prepareStatement(selectSQL);

			preparedStatement.setString(1, stato);
			
			ResultSet rs = preparedStatement.executeQuery();
			Azienda az = new Azienda();
			RegistroTirocinio reg = new RegistroTirocinio();
			StatoRichiesta stric = new StatoRichiesta();
			Studente st = new Studente();
			
			while (rs.next()) {
				RichiestaTirocinioBean bean = new RichiestaTirocinioBean();
				
				bean.setAzienda(az.retrieveByKey(rs.getString("ragione_sociale_azienda")));
				bean.setDataRichiesta(rs.getDate("data_richiesta"));
				bean.setId(rs.getInt("id"));
				bean.setProgettoFormativo(rs.getString("progetto_formativo"));
				bean.setRegistroTirocinio(reg.retrieveByKey(rs.getInt("registro_id")));
				bean.setStatiRichiesta((ArrayList) stric.getStatiRichiesta(retrieveByKey(rs.getInt("id"))));
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
	public Collection<RichiestaTirocinioBean> getRichiestaPerStudente(StudenteBean studente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Collection<RichiestaTirocinioBean> richiesteTirocinio = new ArrayList<RichiestaTirocinioBean>();

		try {
			connection = DriverManagerConnectionPool.getConnection();

			String selectSQL = "SELECT *\r\n" + 
							   "FROM richiesta_tirocinio \r\n" + 
							   "WHERE richiesta_tirocinio.studente_email = ?";

			preparedStatement = connection.prepareStatement(selectSQL);

			preparedStatement.setString(1, studente.getEmail());
			
			ResultSet rs = preparedStatement.executeQuery();
			Azienda az = new Azienda();
			RegistroTirocinio reg = new RegistroTirocinio();
			StatoRichiesta stric = new StatoRichiesta();
			Studente st = new Studente();
			
			while (rs.next()) {
				RichiestaTirocinioBean bean = new RichiestaTirocinioBean();
				
				bean.setAzienda(az.retrieveByKey(rs.getString("ragione_sociale_azienda")));
				bean.setDataRichiesta(rs.getDate("data_richiesta"));
				bean.setId(rs.getInt("id"));
				bean.setProgettoFormativo(rs.getString("progetto_formativo"));
				bean.setRegistroTirocinio(reg.retrieveByKey(rs.getInt("registro_id")));
				bean.setStatiRichiesta((ArrayList) stric.getStatiRichiesta(retrieveByKey(rs.getInt("id"))));
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
