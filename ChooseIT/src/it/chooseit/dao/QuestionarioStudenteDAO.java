package it.chooseit.dao;


import java.sql.SQLException;
import java.util.Collection;

import it.chooseit.bean.QuestionarioStudenteBean;

import it.chooseit.bean.TutorAziendaleBean;

public interface QuestionarioStudenteDAO extends GenericDAO<QuestionarioStudenteBean,Integer> {

	
	public Collection<QuestionarioStudenteBean> getQuestionarioPer(TutorAziendaleBean tutor)throws SQLException;

}
