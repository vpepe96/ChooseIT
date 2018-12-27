package it.chooseit.facade;

import java.sql.SQLException;

import it.chooseit.bean.StudenteBean;
import it.chooseit.bean.UtenteBean;
import it.chooseit.dao.StudenteDAO;
import it.chooseit.dao.UtenteDAO;
import it.chooseit.impl.Studente;
import it.chooseit.impl.Utente;

/**
 * Definisce i metodi per gestire le funzionalità relative all’account.
 */
public class GestioneAccountFacade {
	
	/**
	 * Permette di prelevare informazioni relative ad un utente in fase di login.
	 * PRE: email != null AND pwd != null
	 * @param email l'email immessa dall'utente in fase di login 
	 * @param pwd la password immessa dall'utente in fase di login
	 * @return utente != null se le credenziali immesse in fase di login sono giuste, utente == null se l'email o la password sono errate
	 */
	public UtenteBean login(String email, String pwd) {
		UtenteBean utente = null;
		UtenteDAO utenteDao = new Utente();
		
		//Cerca l'utente nel database...
		try {
			//Se le credenziali sono giuste restituisci utenteBean
			utente = utenteDao.checkLogin(email, pwd);
			return utente;
			
		} catch (SQLException e) {
			//...altrimenti l'utente non è stato trovato oppure la pwd è errata
			return null;
		}
	}
	
	
	/**
	 * Permette di registrare un nuovo studente al sito.
	 * @param studente lo studente da registrare
	 * @param pwd la password dello studente da registrare
	 * @return true se la registrazione è andata a buon fine, false altrimenti
	 */
	public boolean registrazione(StudenteBean studente, String pwd) {
		UtenteDAO utenteDao = new Utente();
		try {
			utenteDao.insert(studente, pwd);
		} catch (SQLException e) {
			return false;
		}
		System.out.println("utente inserito");
		StudenteDAO studenteDao = new Studente();
		try {
			studenteDao.insert(studente);
		} catch (SQLException e) {
			return false;
		}
		System.out.println("studente inserito");
		return true;
	}
	
	
	/**
	 * Permette di controllare il tipo di utente che ha effettuato il login.
	 * PRE: utente != null
	 * @param utente l'utente che ha effettuato il login
	 * @return il ruolo dell'utente come String
	 */
	public String checkRuolo(UtenteBean utente) {
		String ruolo = null;
		UtenteDAO utenteDao = new Utente();
		/*
		//Controlla il ruolo dell'utente
		try {
			//Il ruolo dell'utente è stato trovato
			//ruolo = utenteDao.checkRuolo(utente.getEmail());
		} catch (SQLException e) {
			//Il ruolo dell'utente non è stato trovato
		}
		*/
		return ruolo;
	}
	
}
