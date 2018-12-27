package it.chooseit.dao;

import java.sql.SQLException;

import it.chooseit.bean.UtenteBean;

public interface UtenteDAO extends GenericDAO<UtenteBean, String> {

	UtenteBean checkLogin(String email, String pwd) throws SQLException;

	public void insert(UtenteBean utente, String pwd) throws SQLException;

}
