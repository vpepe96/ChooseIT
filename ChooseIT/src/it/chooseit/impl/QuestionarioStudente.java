package it.chooseit.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import it.chooseit.bean.QuestionarioStudenteBean;
import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.TutorAziendaleBean;
import it.chooseit.dao.QuestionarioStudenteDAO;
import it.chooseit.dao.RegistroTirocinioDAO;
import it.chooseit.services.DriverManagerConnectionPool;

public class QuestionarioStudente implements QuestionarioStudenteDAO{

	@Override
	public QuestionarioStudenteBean retrieveByKey(Integer id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		try {
			connection = DriverManagerConnectionPool.getConnection();

			String sql = "select * from questionario_studente where registro_id = ?;";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, id.intValue());

			rs = preparedStatement.executeQuery();

			// Cerca dati registro tirocinio
			RegistroTirocinioDAO regDao = new RegistroTirocinio();
			RegistroTirocinioBean registroBean = regDao.retrieveByKey(id);

			QuestionarioStudenteBean bean = new QuestionarioStudenteBean(null);

			if (rs.next()) {
				bean.setRegistroTirocinio(registroBean);
				bean.setPdt1(rs.getInt("pdt_1"));
				bean.setPdt2(rs.getInt("pdt_2"));
				bean.setPdt3(rs.getInt("pdt_3"));
				bean.setPdt4(rs.getInt("pdt_4"));
				
				bean.setT1(rs.getInt("t_1"));
				bean.setT2(rs.getInt("t_2"));
				bean.setT3(rs.getInt("t_3"));
				bean.setT4(rs.getInt("t_4"));
				
				bean.setSu1(rs.getInt("su_1"));
				bean.setSu2(rs.getInt("su_2"));
				bean.setSu3(rs.getInt("su_3"));

				return bean;

			} else {
				return null;
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
	public Collection<QuestionarioStudenteBean> retrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Collection<QuestionarioStudenteBean> list = new ArrayList<>();

		try {
			connection = DriverManagerConnectionPool.getConnection();
			String sql = null;
			if (order == null || order.equals("")) {
				sql = "select * from questionario_studente;";
			} else {
				sql = " select * from questionario_studente order by " + order + ";";
			}

			preparedStatement = connection.prepareStatement(sql);

			rs = preparedStatement.executeQuery();

			RegistroTirocinioDAO regDao = new RegistroTirocinio();

			while (rs.next()) {

				QuestionarioStudenteBean bean = new QuestionarioStudenteBean(null);

				// Cerca dati registro tirocinio
				RegistroTirocinioBean registro = regDao.retrieveByKey(rs.getInt("registro_id"));

				bean.setRegistroTirocinio(registro);
				bean.setPdt1(rs.getInt("pdt_1"));
				bean.setPdt2(rs.getInt("pdt_2"));
				bean.setPdt3(rs.getInt("pdt_3"));
				bean.setPdt4(rs.getInt("pdt_4"));
				
				bean.setT1(rs.getInt("t_1"));
				bean.setT2(rs.getInt("t_2"));
				bean.setT3(rs.getInt("t_3"));
				bean.setT4(rs.getInt("t_4"));
			
				bean.setSu1(rs.getInt("su_1"));
				bean.setSu2(rs.getInt("su_2"));
				bean.setSu3(rs.getInt("su_3"));
				list.add(bean);
			}
		} finally {
			try {
				if (!connection.isClosed())
					connection.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return list;

	}

	

	@Override
	public void insert(QuestionarioStudenteBean questionario) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManagerConnectionPool.getConnection();

			String sql = "insert into questionario_studente (registro_id,pdt_1,pdt_2,pdt_3,pdt_4,t_1,t_2,t_3,t_4,su_1,su_2,su_3) values (?,?,?,?,?,?,?,?,?,?,?,?);";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, questionario.getRegistroTirocinio().getIdentificativo());
			preparedStatement.setInt(2, questionario.getPdt1());
			preparedStatement.setInt(3, questionario.getPdt2());
			preparedStatement.setInt(4, questionario.getPdt3());
			preparedStatement.setInt(5, questionario.getPdt4());
			
			preparedStatement.setInt(7, questionario.getT1());
			preparedStatement.setInt(8, questionario.getT2());
			preparedStatement.setInt(9, questionario.getT3());
			preparedStatement.setInt(10, questionario.getT4());
			
			preparedStatement.setInt(12, questionario.getSu1());
			preparedStatement.setInt(13, questionario.getSu2());
			preparedStatement.setInt(14, questionario.getSu3());

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
	public void update(QuestionarioStudenteBean questionario) throws SQLException {
		if (delete(questionario.getRegistroTirocinio().getIdentificativo())) {
			insert(questionario);
		}
	}

	@Override
	public boolean delete(Integer id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManagerConnectionPool.getConnection();

			String sql = "delete from questionario_studente where registro__id = ?;";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, id.intValue());

			int result = preparedStatement.executeUpdate();
			if (result == 1) {
				return true;
			} else {
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
	public Collection<QuestionarioStudenteBean> getQuestionarioPer(TutorAziendaleBean tutor) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Collection<QuestionarioStudenteBean> list = new ArrayList<>();

		try {
			connection = DriverManagerConnectionPool.getConnection();

			String sql = "select * from tutor_aziendale, registro_tirocinio, questionario_studente where "
					+ "studente.email = ? and " + "registro_tirocinio.studente_email = studente.email and"
					+ "questionario_studente.registro_id = registro_tirocinio.identificativo;";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, tutor.getEmail());

			rs = preparedStatement.executeQuery();

			RegistroTirocinioDAO regDao = new RegistroTirocinio();

			while (rs.next()) {
				QuestionarioStudenteBean bean = new QuestionarioStudenteBean(null);

				// Cerca dati registro tirocinio
				RegistroTirocinioBean registro = regDao.retrieveByKey(rs.getInt("identificativo"));

				bean.setRegistroTirocinio(registro);
				bean.setPdt1(rs.getInt("pdt_1"));
				bean.setPdt2(rs.getInt("pdt_2"));
				bean.setPdt3(rs.getInt("pdt_3"));
				bean.setPdt4(rs.getInt("pdt_4"));
				
				bean.setT1(rs.getInt("t_1"));
				bean.setT2(rs.getInt("t_2"));
				bean.setT3(rs.getInt("t_3"));
				bean.setT4(rs.getInt("t_4"));
				
				bean.setSu1(rs.getInt("su_1"));
				bean.setSu2(rs.getInt("su_2"));
				bean.setSu3(rs.getInt("su_3"));

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
