package it.chooseit.dao;

import java.sql.SQLException;
import java.util.Collection;

import it.chooseit.bean.QuestionarioAziendaBean;
import it.chooseit.bean.StudenteBean;

public interface QuestionarioAziendaDAO extends GenericDAO<QuestionarioAziendaBean,Integer> {

	/**
	 * Recupera una lista di questionari riferiti all'Ente Ospitante.
	 * @param studente 
	 * @return una lista di questionari 
	 * @throws SQLException
	 */
	public Collection<QuestionarioAziendaBean> getQuestionarioPer(StudenteBean studente)throws SQLException;
	
}
