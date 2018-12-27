package it.chooseit.dao;

import java.sql.SQLException;
import java.util.Collection;

import it.chooseit.bean.StudenteBean;
import it.chooseit.bean.TutorAziendaleBean;
import it.chooseit.bean.TutorUniversitarioBean;

public interface StudenteDAO extends GenericDAO<StudenteBean, String> {
	/**
	 * Recupera la lista degli studenti iscritti al sito associati al tutor aziendale.
	 * @param tutor il tutor aziendale del quale si vogliono recuperare gli studenti associati
	 * @return una lista di studenti associati al tutor aziendale
	 * @throws SQLException
	 */
	public Collection<StudenteBean> getStudentiAssociati(TutorAziendaleBean tutor) throws SQLException;
	
	
	/**
	 * Recupera la lista degli studenti iscritti al sito associati al tutor universitario.
	 * @param tutor il tutor universitario del quale si vogliono recuperare gli studenti associati 
	 * @return una lista di studenti associati al tutor universitario
	 * @throws SQLException
	 */
	public Collection<StudenteBean> getStudentiAssociati(TutorUniversitarioBean tutor) throws SQLException;
}
