package it.chooseit.dao;

import java.sql.SQLException;
import java.util.Collection;

import it.chooseit.bean.AziendaBean;
import it.chooseit.bean.RichiestaTirocinioBean;

public interface RichiestaTirocinioDAO extends GenericDAO<RichiestaTirocinioBean, Integer> {

	/**
	 * Permette di recuperare un insieme di richieste di tirocinio effettuata per l'azienda.
	 * @param azienda l'azienda della quale si vogliono recuperare le richieste
	 * @return un insieme di richieste di tirocinio
	 * @throws SQLException
	 */
	Collection<RichiestaTirocinioBean> getRichiestePer(AziendaBean azienda) throws SQLException;
}
