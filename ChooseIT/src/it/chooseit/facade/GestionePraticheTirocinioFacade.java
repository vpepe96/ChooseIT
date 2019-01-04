package it.chooseit.facade;

/**
 * 
 */
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import it.chooseit.bean.AziendaBean;
import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.StudenteBean;
import it.chooseit.bean.RichiestaTirocinioBean;
import it.chooseit.bean.StatoRichiestaBean;
import it.chooseit.bean.StatoTirocinioBean;
import it.chooseit.bean.TutorAziendaleBean;
import it.chooseit.bean.TutorUniversitarioBean;
import it.chooseit.dao.AziendaDAO;
import it.chooseit.dao.RegistroTirocinioDAO;
import it.chooseit.dao.RichiestaTirocinioDAO;
import it.chooseit.dao.StatoRichiestaDAO;
import it.chooseit.dao.StatoTirocinioDAO;
import it.chooseit.dao.StudenteDAO;
import it.chooseit.dao.TutorAziendaleDAO;
import it.chooseit.dao.TutorUniversitarioDAO;
import it.chooseit.impl.Azienda;
import it.chooseit.impl.RegistroTirocinio;
import it.chooseit.impl.RichiestaTirocinio;
import it.chooseit.impl.StatoRichiesta;
import it.chooseit.impl.StatoTirocinio;
import it.chooseit.impl.Studente;
import it.chooseit.impl.TutorAziendale;
import it.chooseit.impl.TutorUniversitario;
import it.chooseit.services.ConvertEnum;

public class GestionePraticheTirocinioFacade {
	
	/**
	 * Restituisce la lista delle aziende convenzionate
	 * 
	 * @return lista delle aziende
	 */
	public Collection<AziendaBean> listaAziende(){
		Collection<AziendaBean> aziende = new ArrayList<AziendaBean>();
		AziendaDAO aziendaDao = new Azienda();
		String order = "ragione_sociale";
		
		//Recupero la lista delle aziende ordinandole per ragione sociale
		try {
			aziende = aziendaDao.retrieveAll(order);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore nel reperimento della lista delle aziende");
			return null;
		}
		
		TutorAziendaleDAO tutorAziendale = new TutorAziendale();
		RichiestaTirocinioDAO richiestaTirocinio = new RichiestaTirocinio();
		
		//Aggiorno le dipendenze di ogni azienda 
		for(AziendaBean a : aziende) {
			try {
				a.setTutorAziendali((ArrayList<TutorAziendaleBean>) tutorAziendale.getTutorDiAzienda(a));
				a.setRichiesteTirocinio((ArrayList<RichiestaTirocinioBean>) richiestaTirocinio.getRichiestePerAzienda(a));
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Errore nell'aggiornamento delle dipendenze delle aziende");
			}
		}
		
		return aziende;
	}
	
	/**
	 * Inserisce un'azienda specificata
	 * 
	 * @param azienda nuova azienda da inserire
	 * @return un valore vero o falso a seconda del risultato dell'inserimento
	 */
	public boolean inserisciAzienda(AziendaBean azienda) {
		AziendaDAO aziendaDao = new Azienda();
		
		//Inserisco l'azienda
		try {
			aziendaDao.insert(azienda);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore d'inserimento dell'azienda");
			return false;
		}
		
		TutorAziendaleDAO tutorAziendale = new TutorAziendale();
		RichiestaTirocinioDAO richiestaTirocinio = new RichiestaTirocinio();
		
		//Aggiorno le dipendeze dell'azienda inserita
		try {
			azienda.setTutorAziendali((ArrayList<TutorAziendaleBean>) tutorAziendale.getTutorDiAzienda(azienda));
			azienda.setRichiesteTirocinio((ArrayList<RichiestaTirocinioBean>) richiestaTirocinio.getRichiestePerAzienda(azienda));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	/**
	 * Aggiorna i dati di un'azienda specificata
	 * 
	 * @param azienda azienda con i campi aggiornati
	 * @return un valore vero o falso a seconda del risultato dell'aggiornamento
	 */
	public boolean aggiornaAzienda(AziendaBean azienda) {
		AziendaDAO aziendaDao = new Azienda();
		
		//Aggiorno l'azienda
		try {
			aziendaDao.update(azienda);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore durante l'aggiornamento dell'azienda");
			return false;
		}
		
		TutorAziendaleDAO tutorAziendale = new TutorAziendale();
		RichiestaTirocinioDAO richiestaTirocinio = new RichiestaTirocinio();
		
		//Aggiorno le dipendenze dell'azienda
		try {
			azienda.setTutorAziendali((ArrayList<TutorAziendaleBean>) tutorAziendale.getTutorDiAzienda(azienda));
			azienda.setRichiesteTirocinio((ArrayList<RichiestaTirocinioBean>) richiestaTirocinio.getRichiestePerAzienda(azienda));
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore durante l'aggiornamento delle dipendenze dell'azienda");
		}
		
		return true;
	}
	
	/**
	 * Restituisce la lista degli studenti a seconda del tipo di utente loggato
	 * 
	 * @param ruoloUtente indica il tipo di utente loggato
	 * @param email email dell'utente loggato
	 * @return lista di studenti
	 */
	public Collection<StudenteBean> listaStudenti(String ruoloUtente, String email){
		Collection<StudenteBean> studenti = new ArrayList<StudenteBean>();
		StudenteDAO studenteDao = new Studente();
		
		//Se l'utente loggato è il presidente allora visualizzo la lista degli studenti con richieste di tirocinio in convalida e studenti con tirocinio in corso
		//Altrimenti se l'utente loggato è la segreteria allora visualizzo la lista degli studenti con richieste di tirocinio nuove e in validazione
		//Altrimenti se l'utente loggato è un tutor allora visualizzo la lista degli studenti ad esso associati
		if(ruoloUtente.equalsIgnoreCase("Presidente")) {
			try {
				//Ottengo la lista degli studenti con richiesta di tirocinio nello stato di "in convalida"
				studenti = studenteDao.getStudentiPerStatoRichiesta("inconvalida");
				//Ottengo la lita degli studenti con tirocinio nello stati di "in corso"
				studenti.addAll(studenteDao.getStudentiPerStatoTirocinio("incorso"));
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Errore di reperimento dei dati della lista di studenti per il presidente");
				return null;
			}
		}
		else if (ruoloUtente.equalsIgnoreCase("Segreteria")) {
			try {
				//Ottengo la lista degli studenti con richiesta di tirocinio nello stato di "nuova"
				studenti = studenteDao.getStudentiPerStatoRichiesta("nuova");
				//Ottengo la lista degli studenti con richiesta di tirocinio nello stato di "in validazione"
				studenti.addAll(studenteDao.getStudentiPerStatoRichiesta("invalidazione"));
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Errore di reperimento dei dati della lista di studenti per la segreteria");
				return null;
			}
		}
		else if (ruoloUtente.equalsIgnoreCase("TutorAziendale")) {
			TutorAziendaleDAO tutorAziendale = new TutorAziendale();
			try {
				//Ottengo la lista degli studenti associati
				studenti = studenteDao.getStudentiAssociati(tutorAziendale.retrieveByKey(email));
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Errore di reperimento dei dati della lista di studenti per il tutor aziendale");
				return null;
			}
		}
		else if (ruoloUtente.equalsIgnoreCase("TutorUniversitario")) {
			TutorUniversitarioDAO tutorUniversitario = new TutorUniversitario();
			try {
				//Ottengo la lista degli studenti associati
				studenti = studenteDao.getStudentiAssociati(tutorUniversitario.retrieveByKey(email));
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Errore di reperimento dei dati della lista di studenti per il tutor universitario");
				return null;
			}
		}
		
		RegistroTirocinioDAO registroTirocinio = new RegistroTirocinio();
		RichiestaTirocinioDAO richiestaTirocinio = new RichiestaTirocinio();
		
		//Aggiorno le dipendenze di ogni studente della lista
		for(StudenteBean s : studenti) {
			try {
				s.setRegistriTirocinio((ArrayList<RegistroTirocinioBean>) registroTirocinio.getRegistriDiStudente(s));
				s.setRichiesteTirocinio((ArrayList<RichiestaTirocinioBean>) richiestaTirocinio.getRichiestePerStudente(s));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return studenti;
	}
	
	/**
	 * Restituisce la lista delle richieste di tirocinio a seconda dell'utente loggato
	 * 
	 * @param ruoloUtente tipo di utente loggato
	 * @param email email dell'utente loggato
	 * @return lista delle richieste di tirocinio 
	 */
	public Collection<RichiestaTirocinioBean> listaRichiesteTirocinio(String ruoloUtente, String email){
		Collection<RichiestaTirocinioBean> richieste = new ArrayList<RichiestaTirocinioBean>();
		RichiestaTirocinioDAO richiestaDao = new RichiestaTirocinio();
		StudenteDAO studenteDao = new Studente();
		StatoRichiestaDAO statoRichiestaDao = new StatoRichiesta();
		ConvertEnum convert = new ConvertEnum();
		
		//Se l'utente loggato è il presidente allora visualizzo la lista delle richieste di tirocinio in convalida
		//Altrimenti se l'utente loggato è la segreteria allora visualizzo la lista delle richieste di tirocinio nuove e in validazione
		//Altrimenti se l'utente loggato è uno studente allora visualizzo la lista delle richieste di tirocinio effettuate
		if(ruoloUtente.equalsIgnoreCase("Presidente")) {
			try {
				Collection<RichiestaTirocinioBean> ric = new ArrayList<RichiestaTirocinioBean>();
				StatoRichiestaBean stat = new StatoRichiestaBean();
				//Ottengo la lista di tutte le richieste di tirocinio
				ric = richiestaDao.retrieveAll(null);
				
				//Per ogni richiesta di tirocinio controllo se lo stato più aggiornato è quello di in convalida e la aggiungo alla lista altrimenti no
				for(RichiestaTirocinioBean r : ric) {
					stat = statoRichiestaDao.getStatoRichiesta(r);
					if(convert.convertStatoRichiestaString(stat.getTipo()).equalsIgnoreCase("in convalida"))
						richieste.add(r);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Errore di reperimento dati della lista delle richieste di tirocinio per il presidente");
				return null;
			}
		}
		else if (ruoloUtente.equalsIgnoreCase("Segreteria")) {
			try {
				Collection<RichiestaTirocinioBean> ric = new ArrayList<RichiestaTirocinioBean>();
				StatoRichiestaBean stat = new StatoRichiestaBean();
				//Ottengo la lista di tutte le richieste di tirocinio
				ric = richiestaDao.retrieveAll(null);
				
				//Per ogni richiesta di tirocinio controllo se lo stato più aggiornato è quello di nuovo o in validazione e la aggiungo alla lista altrimenti no
				for(RichiestaTirocinioBean r : ric) {
					stat = statoRichiestaDao.getStatoRichiesta(r);
					if(stat == null)
						System.out.println("STATO RICHIESTA VUOTOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
					if(convert.convertStatoRichiestaString(stat.getTipo()).equalsIgnoreCase("nuova") || convert.convertStatoRichiestaString(stat.getTipo()).equalsIgnoreCase("in validazione"))
						richieste.add(r);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Errore di reperimento dati della lista delle richieste di tirocinio per la segreteria");
				return null;
			}
		}
		else if(ruoloUtente.equalsIgnoreCase("Studente")) {
			try {
				//Ottengo la lista di tutte le richieste di tirocinio effettuate dallo studente loggato
				richieste = richiestaDao.getRichiestePerStudente(studenteDao.retrieveByKey(email));
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Errore di reperimento dati della lista delle richieste di tirocinio per lo studente");
				return null;
			}
		}
		
		//Aggiorno le dipendenze di ogni richiesta di tirocinio della lista
		for(RichiestaTirocinioBean r : richieste) {
			try {
				r.setStatiRichiesta((ArrayList<StatoRichiestaBean>) statoRichiestaDao.getStatiRichiesta(r));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return richieste;
	}
	
	/**
	 * Invia una richiesta di tirocinio
	 * 
	 * @param richiesta richiesta di tirocinio da inviare
	 * @param email email dell'utente che invia la richiesta
	 * @return valore vero o falso a seconda dell'esito dell'invio della richiesta
	 */
	public boolean inviaRichiestaTirocinio(RichiestaTirocinioBean richiesta, String email) {
		RichiestaTirocinioDAO richiestaTirocinioDao = new RichiestaTirocinio();
		StatoRichiestaDAO statoRichiestaDao = new StatoRichiesta();
		StatoRichiestaBean statoRic = null;
		StudenteDAO studenteDao = new Studente();
		StudenteBean studente = null;
		ArrayList<RichiestaTirocinioBean> richiesteTir = new ArrayList<RichiestaTirocinioBean>();
		Date dataStato = new Date(System.currentTimeMillis());
		ConvertEnum convert = new ConvertEnum();
		int i = 0;
		
		//Recupero i dati dello studente 
		try {
			studente = studenteDao.retrieveByKey(email);
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("Errore di riperimento dati dello studente");
		}
		
		//Recupero la lista delle richieste di tirocinio dello studente
		try {
			richiesteTir = (ArrayList<RichiestaTirocinioBean>) richiestaTirocinioDao.getRichiestePerStudente(studente);
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("Errore in InviaRichiestaTirocinio: reperimento lista richieste studente");
		}
		
		//Verifico quante richieste di tirocinio dello studente sono in uno stato qualsiasi diverso dallo stato "rifiutata"
		for(RichiestaTirocinioBean r: richiesteTir) {
			try {
				//Recupero l'ultimo stato aggiornato della richiesta di tirocinio r
				statoRic = statoRichiestaDao.getStatoRichiesta(r);
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Errore di riperimento dati dello stato della richiesta di tirocinio");
			}
			if(!convert.convertStatoRichiestaString(statoRic.getTipo()).equalsIgnoreCase("rifiutata"))
					i++;			
		}
		
		//Se le richieste di tirocinio con stato diverso da quello "annullata" sono minori di 2 allora si inserisce la richiesta, altrimenti no
		if(i < 2) {
			
			try {
				richiesta.setStudente(studenteDao.retrieveByKey(email));
				richiesta.setTutorAziendale(null);
				richiesta.setTutorUniversitario(null);
				richiesta.setRegistroTirocinio(null);
				//Inserisco la richiesta di tirocinio
				richiestaTirocinioDao.insert(richiesta);
				//Prelevo tutte le richieste
				ArrayList<RichiestaTirocinioBean> richieste = (ArrayList<RichiestaTirocinioBean>) richiestaTirocinioDao.retrieveAll("id");
				int id = richieste.size();
			
				/*for(RichiestaTirocinioBean r: richieste) {
					   if(r.getDataRichiesta() == richiesta.getDataRichiesta())
						   id = r.getId();
					}*/
				System.out.println("IDENTIFICATIVO DA SETTARE PER RICHIESTAS"+id);
				richiesta.setId(id);
				//Creo un nuovo stato per la richiesta effettuata impostandolo a "nuova"
				statoRic = new StatoRichiestaBean(dataStato, convert.convertStatoRichiesta("nuova"), richiesta);
				//Inserisco lo stato della richiesta di tirocinio
				statoRichiestaDao.insert(statoRic);
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Errore d'inserimento della richiesta di tirocinio");
				return false;
			}

			//Aggiorno le dipendenze della richiesta di tirocinio
			try {
				richiesta.setStatiRichiesta((ArrayList<StatoRichiestaBean>) statoRichiestaDao.getStatiRichiesta(richiesta));
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Errore durante l'aggiornamento delle dipendenze della richiesta di tirocinio");
			}

			return true;
		}
		else {
			System.out.println("Lo studente ha già effettuato due richieste di tirocinio");	
			return false;
		}
	}
	
	/**
	 * Effettua la valutazione iniziale della richiesta di tirocinio 
	 * 
	 * @param richiesta richiesta di tirocinio di cui effettua la valutazione iniziale
	 * @param tutorAziendale tutor aziendale selezionato per il tirocinio
	 * @param tutorUniversitario turo universitario selezionato per il tirocinio
	 * @param scelta esito della valutazione iniziale
	 * @return un valore vero o falso a seconda dell'esito della valutazione iniziale della richiesta di tirocnio
	 */
	public boolean valutazioneInizialeRichiestaTirocinio(RichiestaTirocinioBean richiesta, TutorAziendaleBean tutorAziendale, TutorUniversitarioBean tutorUniversitario, String scelta) {
		RichiestaTirocinioDAO richiestaTirocinioDao = new RichiestaTirocinio();
		StatoRichiestaDAO statoRichiestaDao = new StatoRichiesta();
		StatoRichiestaBean statoRic = null;
		Date dataStato = new Date(System.currentTimeMillis());
		ConvertEnum convert = new ConvertEnum();
		
		//Setto il tutor aziendale e enuversitario in base a quelli selezionati
		richiesta.setTutorAziendale(tutorAziendale);
		richiesta.setTutorUniversitario(tutorUniversitario);
		
		//Se la richiesta di tirocinio passa da nuova a in validazione viene aggiornata, inserendo i relativi tutor associati, ed inserito il relativo stato di in validazione
		//Se la richiesta di tirocinio passa da nuova a rifiutata viene inserito il relativo stato a rifiutata
		if(scelta.equalsIgnoreCase("in validazione")) {
			//Creo il nuovo stato, "in validazione", della richiesta di tirocinio 
			statoRic = new StatoRichiestaBean(dataStato, convert.convertStatoRichiesta("in validazione"), richiesta);
			
			try {
				//Aggiorno la richiesta di tirocinio
				richiestaTirocinioDao.update(richiesta);
				//Inserisco lo stato della richiesta di tirocinio
				statoRichiestaDao.insert(statoRic);
			} catch (SQLException e1) {
				e1.printStackTrace();
				System.out.println("Errore durante l'inserimento della richiesta di tirocinio e del relativo stato");
				return false;
			}
		}
		else {
			//Creo il nuovo stato, "rifiutata", della richiesta di tirocinio
			statoRic = new StatoRichiestaBean(dataStato, convert.convertStatoRichiesta("rifiutata"), richiesta);
			
			try {
				//Aggiorno la richiesta di tirocinio
				richiestaTirocinioDao.update(richiesta);
				//Inserisco lo stato della richiesta di tirocinio
				statoRichiestaDao.insert(statoRic);				
			} catch (SQLException e1) {
				e1.printStackTrace();
				System.out.println("Errore durante l'inserimento della richiesta di tirocinio e del relativo stato");
				return false;
			}	
		}
		
		//Aggiorno le dipendenze della richiesta di tirocinio
		try {
			richiesta.setStatiRichiesta((ArrayList<StatoRichiestaBean>) statoRichiestaDao.getStatiRichiesta(richiesta));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	/**
	 * Permette di effettuare la valutazione finale della richiesta di tirocinio
	 * 
	 * @param richiesta richiesta di cui effettuare la valutazione finale
	 * @param scelta scelta effettuata nella valutazione finale
	 * @return un valore vero o falso a seconda del buon esito della richiesta di tirocinio
	 */
	public boolean valutazioneFinaleRichiestaTirocinio(RichiestaTirocinioBean richiesta, String scelta) {
		StatoRichiestaDAO statoRichiesta = new StatoRichiesta();
		StatoRichiestaBean statoRic = null;
		Date dataStato = new Date(System.currentTimeMillis());
		ConvertEnum convert = new ConvertEnum();
		
		//Se la richiesta di tirocinio passa da in validazione a in convalida viene inserito il relativo stato di in convalida
		//Se la richiesta di tirocinio passa da in validazione a rifiutata viene inserito il relativo stato a rifiutata
		if(scelta.equalsIgnoreCase("in convalida")) {
			//Creo il nuovo stato, "in convalida", della richiesta di tirocinio
			StatoRichiestaBean stato = new StatoRichiestaBean(dataStato, convert.convertStatoRichiesta("in convalida"), richiesta);
			
			try {
				//Inserisco lo stato della richiesta di tirocinio
				statoRichiesta.insert(stato);
			} catch (SQLException e1) {
				e1.printStackTrace();
				return false;
			}
		}
		else {
			//Creo il nuovo stato, "rifutata", della richiesta di tirocinio
			statoRic = new StatoRichiestaBean(dataStato, convert.convertStatoRichiesta("rifiutata"), richiesta);

			try {
				//Inserisco lo stato della richiesta di tirocinio
				statoRichiesta.insert(statoRic);
			} catch (SQLException e1) {
				e1.printStackTrace();
				return false;
			}	
		}
		
		//Aggiorno le dipendenze della richiesta di tirocinio
		try {
			richiesta.setStatiRichiesta((ArrayList<StatoRichiestaBean>) statoRichiesta.getStatiRichiesta(richiesta));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	/**
	 * Permette di convalidare la richiesta di tirocinio
	 * 
	 * @param richiesta richiesta di tirocinio da convalidare
	 * @param scelta esito della convalida della richiesta di tirocinio
	 * @return un valore vero falso a seconda della riuscita della convalida della richiesta di tirocinio
	 */
	public boolean convalidaRichiestaTirocinio(RichiestaTirocinioBean richiesta, String scelta) {
		StatoRichiestaDAO statoRichiestaDao = new StatoRichiesta();
		StatoTirocinioDAO statoTirocinioDao = new StatoTirocinio();
		RegistroTirocinioDAO registroTirocinioDao = new RegistroTirocinio();
		StatoRichiestaBean statoRichiestaBean = null;
		RegistroTirocinioBean registroTirocinioBean = null;
		StatoTirocinioBean statoTirocinioBean = null;
		ArrayList<StatoTirocinioBean> statiTirocinio = new ArrayList<StatoTirocinioBean>();
		Date dataStato = new Date(System.currentTimeMillis());
		ConvertEnum convert = new ConvertEnum();
		
		//Se la richiesta di tirocinio passa da in convalida ad accettata viene inserito il relativo stato di accettata e viene creato il registro di tirocinio con il relativo stato di in corso, relativo alla richiesta di tirocinio
		//Se la richiesta di tirocinio passa da in convalida a rifiutata viene inserito il relativo stato a rifiutata
		if(scelta.equalsIgnoreCase("accettata")) {
			statoRichiestaBean = new StatoRichiestaBean(dataStato, convert.convertStatoRichiesta("accettata"), richiesta);
			statoTirocinioBean = new StatoTirocinioBean(richiesta.getRegistroTirocinio(), dataStato, convert.convertStatoTirocinio("incorso"));
			statiTirocinio.add(statoTirocinioBean);
			//Conto quanti registri di tirocinio ci sono
			int numRegistri = getNumRegistri();
			
			try {
				//inserisco il nuovo stato della richiesta
				statoRichiestaDao.insert(statoRichiestaBean);
				//Creo il registro di tirocinio
				registroTirocinioBean = new RegistroTirocinioBean(++numRegistri, dataStato, richiesta.getStudente(), richiesta.getTutorAziendale(), richiesta.getTutorUniversitario(), richiesta, null, statiTirocinio, null, null);
				//Setto il registro di tirocinio collegato alla richiesta
				richiesta.setRegistroTirocinio(registroTirocinioBean);
				//Inserisco il registro di tirocinio
				registroTirocinioDao.insert(registroTirocinioBean);
				//Inserisco lo stato del tirocinio
				statoTirocinioDao.insert(statoTirocinioBean);
			} catch (SQLException e1) {
				e1.printStackTrace();
				System.out.println("Errore nella fase di convalida della richiesta: annullamento richiesta fallito");
				return false;
			}	
		}
		else {
			//Creo lo stato della richiesta di tirocinio
			statoRichiestaBean = new StatoRichiestaBean(dataStato, convert.convertStatoRichiesta("rifiutata"), richiesta);
			try {
				//Inserisco lo stato della richiesta tirocinio
				statoRichiestaDao.insert(statoRichiestaBean);
			} catch (SQLException e1) {
				e1.printStackTrace();
				System.out.println("Errore nella fase di convalida della richiesta: annullamento richiesta fallito");
				return false;
			}	
		}
		
		try {
			richiesta.setStatiRichiesta((ArrayList<StatoRichiestaBean>) statoRichiestaDao.getStatiRichiesta(richiesta));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	/**
	 * Restituisce il numero di registri di tirocinio esistenti
	 * 
	 * @return numero registri tirocinio
	 */
	private int getNumRegistri() {
		RegistroTirocinioDAO registroTirocinioDao = new RegistroTirocinio();
		ArrayList<RegistroTirocinioBean> registriTirocinio = null;
		int numRegistri = 0;
		
		try {
			registriTirocinio = (ArrayList<RegistroTirocinioBean>) registroTirocinioDao.retrieveAll("identificativo");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore nel reperimento dei registri di tirocinio");
		}
		
		for(RegistroTirocinioBean r: registriTirocinio)
			numRegistri++;
		
		return numRegistri;
	}
	
}
