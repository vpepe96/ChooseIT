package it.chooseit.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import it.chooseit.bean.UtenteBean;

/**
 * Definisce i metodi per gestire i dati relativi agli utenti.
 */
public interface UtenteDAO {
	
	
	/**
	 * Recupera dal database le informazioni relative ad un utente.
	 * PRE: email != null
	 * @param email la chiave usata per ricercare l'utente nel database
	 * @return utente != null se l'utente è nel database, utente == null altrimenti
	 * @throws SQLException
	 */
	public UtenteBean retrieveByKey(String email) throws SQLException;
	
	
	/**
	 * Recupera dal database le informazioni relative a tutti gli utenti del sito.
	 * @return una lista con tutti gli utenti del sito
	 * @throws SQLException
	 */
	public ArrayList<UtenteBean> retrieveAll() throws SQLException;
	
	
	/**
	 * Inserisce un nuovo utente nel database.
	 * PRE: utente != null AND pwd != null
	 * @param utente l'utente da inserire nel database
	 * @param pwd la password dell'utente
	 * @throws SQLException
	 */
	public void insert(UtenteBean utente, String pwd) throws SQLException;
	
	
	/**
	 * Aggiorna le informazioni di un utente.
	 * PRE: email != null AND utente != null
	 * @param email l'email dell'utente di cui si vogliono aggiornare le informazioni
	 * @param utente le nuove informazioni sull'utente da inserire nel database 
	 * @throws SQLException
	 */
	public void update(String email, UtenteBean utente) throws SQLException;
	
	
	/**
	 * Elimina le informazioni relative ad un utente del sito.
	 * PRE: email != null
	 * @param email l'email dell'utente di cui si vogliono cancellare le informazioni
	 * @throws SQLException
	 */
	public void delete(String email) throws SQLException;
	
	
	/**
	 * Controlla il ruolo dell'utente che ha effettuato il login.
	 * PRE: email != null
	 * @param email l'email dell'utente di cui si vuole controllare il ruolo
	 * @return il ruolo dell'utente come String
	 * @throws SQLException
	 */
	public String checkRuolo(String email) throws SQLException;
	
	
	/**
	 * Controlla se le credenziali inserite in fase di login sono giuste.
	 * PRE: email != null AND pwd != null
	 * @param email l'email inserita in fase di login
	 * @param pwd la password inserita in fase di login
	 * @return utente != null se le credenziali immesse in fase di login sono giuste, utente == null se l'email o la password sono errate
	 * @throws SQLException
	 */
	public UtenteBean checkLogin(String email, String pwd) throws SQLException;
}
