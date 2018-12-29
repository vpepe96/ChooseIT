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
			
			//public RichiestaTirocinioBean(int id, StudenteBean studente, Date dataRichiesta, AziendaBean azienda, String progettoFormativo, RegistroTirocinioBean registroTirocinio, ArrayList<StatoRichiestaBean> statiRichiesta) {
			
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(RichiestaTirocinioBean object) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(RichiestaTirocinioBean object) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean delete(Integer key) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<RichiestaTirocinioBean> getRichiestePerAzienda(AziendaBean azienda) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		ArrayList<RichiestaTirocinioBean> list = new ArrayList<>();

		try {
			connection = DriverManagerConnectionPool.getConnection();

			String sql = "select * from richiesta_tirocinio where ragione_sociale_azienda = ?;";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, azienda.getRagioneSociale());
			
			rs = preparedStatement.executeQuery();
			
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
	
}
