package it.chooseit.facade;

import java.sql.SQLException;

import it.chooseit.bean.PresidenteBean;
import it.chooseit.bean.SegreteriaBean;
import it.chooseit.bean.StudenteBean;
import it.chooseit.bean.TutorAziendaleBean;
import it.chooseit.bean.TutorUniversitarioBean;
import it.chooseit.bean.UtenteBean;
import it.chooseit.dao.PresidenteDAO;
import it.chooseit.dao.SegreteriaDAO;
import it.chooseit.dao.StudenteDAO;
import it.chooseit.dao.TutorAziendaleDAO;
import it.chooseit.dao.TutorUniversitarioDAO;
import it.chooseit.dao.UtenteDAO;
import it.chooseit.impl.Presidente;
import it.chooseit.impl.Segreteria;
import it.chooseit.impl.Studente;
import it.chooseit.impl.TutorAziendale;
import it.chooseit.impl.TutorUniversitario;
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
			
			String ruolo = checkRuolo(utente);
			
			if(ruolo.equals("studente")) {
				//recupera le informazioni di studente dal db...
				StudenteDAO studenteDao = new Studente();
				StudenteBean studente = studenteDao.retrieveByKey(email);
				return studente;
			}
			
			if(ruolo.equals("segreteria")) {
				//recupera le informazioni di segreteria dal db...
				SegreteriaDAO segreteriaDao = new Segreteria();
				SegreteriaBean segreteria = segreteriaDao.retrieveByKey(email);
				return segreteria;
			}
			
			if(ruolo.equals("presidente")) {
				//recupera le informazioni di presidente dal db...
				PresidenteDAO presidenteDao = new Presidente();
				PresidenteBean presidente = presidenteDao.retrieveByKey(email);
				return presidente;
			}
			
			if(ruolo.equals("tutorAziendale")) {
				//recupera le informazioni di tutor aziendale dal db...
				TutorAziendaleDAO tutorAziDao = new TutorAziendale();
				TutorAziendaleBean tutorAziendale = tutorAziDao.retrieveByKey(email);
				return tutorAziendale;
			}
			
			if(ruolo.equals("tutorUniversitario")) {
				//recupera le informazioni di tutor universitario dal db...
				TutorUniversitarioDAO tutorUniDao = new TutorUniversitario();
				TutorUniversitarioBean tutorUniversitario = tutorUniDao.retrieveByKey(email);
				return tutorUniversitario;
			}
			
			// Se arrivo qui allora il ruolo non è stato trovato
			return null;
			
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
			// Aggiunta utente nel database ...
			utenteDao.insert(studente, pwd);
		} catch (SQLException e) {
			// ... errore nella registrazione
			return false;
		}

		StudenteDAO studenteDao = new Studente();
		try {
			// Aggiunta studente nel database ...
			studenteDao.insert(studente);
		} catch (SQLException e) {
			// ... errore nella registrazione
			return false;
		}
	
		return true;
	}
	
	
	/**
	 * Permette di controllare il ruolo di un utente.
	 * PRE: utente != null
	 * @param utente l'utente di cui si vuole controllare il ruolo
	 * @return il ruolo dell'utente come String
	 */
	public String checkRuolo(UtenteBean utente) {
		String email = utente.getEmail();
		UtenteDAO utenteDao = new Utente();
		
		//Controlla il ruolo dell'utente
		try {
			//Se l'utente esiste...
			if(utenteDao.retrieveByKey(email) != null) {
				
				// Controllo se l'utente è studente
				StudenteDAO studenteDao = new Studente();
				if(studenteDao.retrieveByKey(email) != null) {
					return "studente";
				}
				
				// Controllo se l'utente è segreteria
				SegreteriaDAO segreteriaDao = new Segreteria();
				if(segreteriaDao.retrieveByKey(email) != null) {
					return "segreteria";
				}
				
				// Controllo se l'utente è presidente
				PresidenteDAO presidenteDao = new Presidente();
				if(presidenteDao.retrieveByKey(email) != null) {
					return "presidente";
				}
				
				// Controllo se l'utente è tutor aziendale
				TutorAziendaleDAO tutorAziDao = new TutorAziendale();
				if(tutorAziDao.retrieveByKey(email) != null) {
					return "tutorAziendale";
				}
				
				// Controllo se l'utente è tutor universitario
				TutorUniversitarioDAO tutorUniDao = new TutorUniversitario();
				if(tutorUniDao.retrieveByKey(email) != null) {
					return "tutorUniversitario";
				}
				
			}else {
				//...altrimenti l'utente non esiste (return null)
			}
		} catch (SQLException e) {
			//Il ruolo dell'utente non è stato trovato (return null)
		}
		
		// Se arrivo qui il ruolo non è stato trovato, oppure l'utente non esiste
		return null;
	}
	
}
