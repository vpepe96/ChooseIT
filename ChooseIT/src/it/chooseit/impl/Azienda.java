package it.chooseit.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import it.chooseit.bean.AziendaBean;
import it.chooseit.dao.AziendaDAO;
import it.chooseit.services.DriverManagerConnectionPool;

public class Azienda implements AziendaDAO{

	private static final String TABLE_NAME = "azienda";

	public AziendaBean retrieveByKey(String key) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatament = null;

		AziendaBean bean = new AziendaBean(null, null, null, null);

		String selectSQL = "SELECT * FROM " + Azienda.TABLE_NAME + " WHERE ragione_sociale = ?;";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatament = connection.prepareStatement(selectSQL);

			preparedStatament.setString(1, key);

			System.out.println("doRetrieveByKey:" + preparedStatament.toString());

			ResultSet rs = preparedStatament.executeQuery();

			while(rs.next()) { 
				bean.setRagioneSociale(rs.getString("ragione_sociale"));
				bean.setProgettoFormativo(rs.getString("progetto_formativo"));
				bean.setSedeOperativa(rs.getString("sede_operativa"));
				bean.setSedeLegale(rs.getString("sede_legale"));
			}
		} finally {
			try {
				if(preparedStatament != null)
					preparedStatament.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return bean;
	}
	public Collection<AziendaBean> retrieveAll(String order) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatament = null;

		Collection<AziendaBean> offerte = new LinkedList<AziendaBean>();

		String selectSQL = "SELECT * FROM " + Azienda.TABLE_NAME;

		if(order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order +";";
		}else {
			selectSQL += ";";
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatament = connection.prepareStatement(selectSQL);

			System.out.println("doRetrieveAll:" + preparedStatament.toString());

			ResultSet rs = preparedStatament.executeQuery();

			while(rs.next()) {
				AziendaBean bean = new AziendaBean(null, null, null, null);

				bean.setRagioneSociale(rs.getString("ragione_sociale"));
				bean.setProgettoFormativo(rs.getString("progetto_formativo"));
				bean.setSedeOperativa(rs.getString("sede_operativa"));
				bean.setSedeLegale(rs.getString("sede_legale"));

				offerte.add(bean);
			}
		} finally {
			try {
				if(preparedStatament != null)
					preparedStatament.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}

		return offerte;
	}


	public void insert(AziendaBean object) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + Azienda.TABLE_NAME
				+ " (ragione_sociale,progetto_formativo,sede_operativa,sede_legale) VALUES (?, ?, ?, ?);";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);

			preparedStatement.setString(1,object.getRagioneSociale());
			preparedStatement.setString(2, object.getProgettoFormativo());
			preparedStatement.setString(3, object.getSedeOperativa());
			preparedStatement.setString(4, object.getSedeLegale());

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
	public void update(AziendaBean object) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertSQL = "UPDATE " + Azienda.TABLE_NAME
				+ " SET progetto_formativo = ?, sede_operativa=?, sede_legale=?,"
				+ " WHERE ragione_sociale = ?;";

		try {
			connection = DriverManagerConnectionPool.getConnection();

			preparedStatement = connection.prepareStatement(insertSQL);

			preparedStatement.setString(1, object.getRagioneSociale());
			preparedStatement.setString(2, object.getProgettoFormativo());
			preparedStatement.setString(3, object.getSedeOperativa());
			preparedStatement.setString(4, object.getSedeLegale());

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

	public boolean delete(String key) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + Azienda.TABLE_NAME + " WHERE ragione_sociale = ?;";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, key);

			System.out.println("doDelete: "+ preparedStatement.toString());
			result = preparedStatement.executeUpdate();

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
}

