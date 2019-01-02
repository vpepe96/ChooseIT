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
					if(stat.getTipo().toString().equalsIgnoreCase("inconvalida"))
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
					if(stat.getTipo().toString().equalsIgnoreCase("nuova") || stat.getTipo().toString().equalsIgnoreCase("invalidazione"))
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
		RichiestaTirocinioDAO richiestaTirocinio = new RichiestaTirocinio();
		StatoRichiestaDAO statoRichiesta = new StatoRichiesta();
		StatoRichiestaBean statoRic = null;
		StudenteDAO studenteDao = new Studente();
		StudenteBean studente = null;
		ArrayList<RichiestaTirocinioBean> richiesteTir = new ArrayList<RichiestaTirocinioBean>();
		Date dataStato = new Date(System.currentTimeMillis());
		ConvertEnum convert = new ConvertEnum();
		int i = 0;
		
		StatoTirocinioDAO statoTirocinio = new StatoTirocinio();
		RegistroTirocinioDAO registroTirocinio = new RegistroTirocinio();
		StatoTirocinioBean statoReg = null;
		TutorAziendaleDAO tutorAziendaleDao = new TutorAziendale();
		TutorAziendaleBean tutorAziendale = null;
		TutorUniversitarioDAO tutorUniversitarioDao = new TutorUniversitario();
		TutorUniversitarioBean tutorUniversitario = null;
		
		//Recupero i dati dello studente e dei tutor 
		try {
			studente = studenteDao.retrieveByKey(email);
			tutorAziendale = tutorAziendaleDao.retrieveByKey("valeriorossi@gmail.com");
			tutorUniversitario = tutorUniversitarioDao.retrieveByKey("luchini@unisa.it");
		
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("Errore di riperimento dati dello studente");
		}
		
		//Recupero la lista delle richieste di tirocinio dello studente
		richiesteTir = studente.getRichiesteTirocinio();
		
		//Verifico quante richieste di tirocinio dello studente sono in uno stato qualsiasi diverso dallo stato "rifiutata"
		for(RichiestaTirocinioBean r: richiesteTir) {
			try {
				//Recupero l'ultimo stato aggiornato della richiesta di tirocinio r
				statoRic = statoRichiesta.getStatoRichiesta(r);
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Errore di riperimento dati dello stato della richiesta di tirocinio");
			}
			if(!statoRic.getTipo().toString().equalsIgnoreCase("rifiutata"))
					i++;			
		}
		
		//Se le richieste di tirocinio con stato diverso da quello "annullata" sono minori di 2 allora si inserisce la richiesta, altrimenti no
		if(i < 2) {
			//Creo un nuovo stato per la richiesta effettuata impostandolo a "nuova"
			statoRic = new StatoRichiestaBean(dataStato, convert.convertStatoRichiesta("nuova"), richiesta);
			try {
				richiesta.setStudenteEmail(studenteDao.retrieveByKey(email));
				richiesta.setRegistroTirocinio(new RegistroTirocinioBean(richiesta.getStudente(), tutorAziendale, tutorUniversitario, richiesta));
				//Inserisco la richiesta di tirocinio
				richiestaTirocinio.insert(richiesta);
				//Inserisco lo stato della richiesta di tirocinio
				statoRichiesta.insert(statoRic);
				//Inserisco il registro di tirocinio
				registroTirocinio.insert(richiesta.getRegistroTirocinio());
				//Inserisco lo stato del registro di tirocinio
				statoReg = new StatoTirocinioBean(richiesta.getRegistroTirocinio(), dataStato, convert.convertStatoTirocinio("incorso"));
				statoTirocinio.insert(statoReg);
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Errore d'inserimento della richiesta di tirocinio");
				return false;
			}

			//Aggiorno le dipendenze della richiesta di tirocinio
			try {
				richiesta.setStatiRichiesta((ArrayList<StatoRichiestaBean>) statoRichiesta.getStatiRichiesta(richiesta));
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
		RegistroTirocinioDAO registroTirocinioDao = new RegistroTirocinio();
		StatoTirocinioDAO statoTirocinioDao = new StatoTirocinio();
		StatoRichiestaBean statoRic = null;
		StatoTirocinioBean statoReg = null;
		Date dataStato = new Date(System.currentTimeMillis());
		ConvertEnum convert = new ConvertEnum();
		
		//Aggiorno il registro di tirocinio associato alla richiesta
		richiesta.setRegistroTirocinio(new RegistroTirocinioBean(richiesta.getStudente(), tutorAziendale, tutorUniversitario, richiesta));
		
		//Se la richiesta di tirocinio passa da nuova a in validazione viene inserita con il relativo stato di nuova
		//Se la richiesta di tirocinio passa da nuova a rifiutata viene inserita con il relativo stato a rifiutata
		if(scelta.equalsIgnoreCase("inValidazione")) {
			richiesta.setRegistroTirocinio(new RegistroTirocinioBean(richiesta.getStudente(), tutorAziendale, tutorUniversitario, richiesta));
			statoRic = new StatoRichiestaBean(dataStato, convert.convertStatoRichiesta("invalidazione"), richiesta);
						
			try {
				//Inserisco la richiesta di tirocinio
				richiestaTirocinioDao.insert(richiesta);
				//Inserisco lo stato della richiesta di tirocinio
				statoRichiestaDao.insert(statoRic);
				//Aggiorno il registro di tirocinio
				registroTirocinioDao.update(richiesta.getRegistroTirocinio());
			} catch (SQLException e1) {
				e1.printStackTrace();
				System.out.println("Errore durante l'inserimento della richiesta di tirocinio e del relativo stato");
				return false;
			}
		}
		else {
			statoRic = new StatoRichiestaBean(dataStato, convert.convertStatoRichiesta("rifiutata"), richiesta);
			statoReg = new StatoTirocinioBean(richiesta.getRegistroTirocinio(), dataStato, convert.convertStatoTirocinio("annullato"));
			
			try {
				statoRichiestaDao.insert(statoRic);
				statoTirocinioDao.insert(statoReg);
				//Aggiorno il registro di tirocinio
				registroTirocinioDao.update(richiesta.getRegistroTirocinio());
				//Inserisco un nuovo stato annullato per il tirocinio
				statoTirocinioDao.insert(new StatoTirocinioBean(richiesta.getRegistroTirocinio(), dataStato, convert.convertStatoTirocinio("annullato")));
			} catch (SQLException e1) {
				e1.printStackTrace();
				System.out.println("Errore durante l'inserimento della richiesta di tirocinio e del relativo stato");
				return false;
			}	
		}
		
		//Aggiorno le dipendenze della richiesta di tirocinio
		try {
			richiesta.setStatiRichiesta((ArrayList<StatoRichiestaBean>) statoRichiestaDao.getStatiRichiesta(richiesta));
			richiesta.getRegistroTirocinio().setStatiTirocinio((ArrayList<StatoTirocinioBean>) statoTirocinioDao.getStatiTirocinio(richiesta.getRegistroTirocinio()));
			richiesta.getRegistroTirocinio().getTutorAziendale().setRegistriTirocinio((ArrayList<RegistroTirocinioBean>) registroTirocinioDao.getRegistriDiTutorAziendale(richiesta.getRegistroTirocinio().getTutorAziendale()));
			richiesta.getRegistroTirocinio().getTutorUniversitario().setRegistriTirocinio((ArrayList<RegistroTirocinioBean>) registroTirocinioDao.getRegistriDiTutorUniversitario(richiesta.getRegistroTirocinio().getTutorUniversitario()));
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
		StatoTirocinioDAO statoTirocinio = new StatoTirocinio();
		RegistroTirocinioDAO registroTirocinio = new RegistroTirocinio();
		StatoRichiestaBean statoRic = null;
		StatoTirocinioBean statoReg = null;
		Date dataStato = new Date(System.currentTimeMillis());
		ConvertEnum convert = new ConvertEnum();
		
		if(scelta.equalsIgnoreCase("inConvalida")) {
			StatoRichiestaBean stato = new StatoRichiestaBean(dataStato, convert.convertStatoRichiesta("inconvalida"), richiesta);
			try {
				statoRichiesta.insert(stato);
			} catch (SQLException e1) {
				e1.printStackTrace();
				return false;
			}
		}
		else {
			statoRic = new StatoRichiestaBean(dataStato, convert.convertStatoRichiesta("rifiutata"), richiesta);
			statoReg = new StatoTirocinioBean(richiesta.getRegistroTirocinio(), dataStato, convert.convertStatoTirocinio("annullato"));
			try {
				statoRichiesta.insert(statoRic);
				statoTirocinio.insert(statoReg);
			} catch (SQLException e1) {
				e1.printStackTrace();
				return false;
			}	
		}
		
		//Aggiorno le dipendenze della richiesta di tirocinio
		try {
			richiesta.setStatiRichiesta((ArrayList<StatoRichiestaBean>) statoRichiesta.getStatiRichiesta(richiesta));
			richiesta.getRegistroTirocinio().setStatiTirocinio((ArrayList<StatoTirocinioBean>) statoTirocinio.getStatiTirocinio(richiesta.getRegistroTirocinio()));
			richiesta.getRegistroTirocinio().getTutorAziendale().setRegistriTirocinio((ArrayList<RegistroTirocinioBean>) registroTirocinio.getRegistriDiTutorAziendale(richiesta.getRegistroTirocinio().getTutorAziendale()));
			richiesta.getRegistroTirocinio().getTutorUniversitario().setRegistriTirocinio((ArrayList<RegistroTirocinioBean>) registroTirocinio.getRegistriDiTutorUniversitario(richiesta.getRegistroTirocinio().getTutorUniversitario()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public boolean convalidaRichiestaTirocinio(RichiestaTirocinioBean richiesta, String scelta) {
		StatoRichiestaDAO statoRichiesta = new StatoRichiesta();
		StatoTirocinioDAO statoTirocinio = new StatoTirocinio();
		RegistroTirocinioDAO registroTirocinio = new RegistroTirocinio();
		StatoRichiestaBean statoRic = null;
		StatoTirocinioBean statoReg = null;
		Date dataStato = new Date(System.currentTimeMillis());
		ConvertEnum convert = new ConvertEnum();
		
		if(scelta.equalsIgnoreCase("accettata")) {
			statoRic = new StatoRichiestaBean(dataStato, convert.convertStatoRichiesta("accettata"), richiesta);
			statoReg = new StatoTirocinioBean(richiesta.getRegistroTirocinio(), dataStato, convert.convertStatoTirocinio("incorso"));
			try {
				statoRichiesta.insert(statoRic);
				statoTirocinio.insert(statoReg);
			} catch (SQLException e1) {
				e1.printStackTrace();
				return false;
			}	
		}
		else {
			statoRic = new StatoRichiestaBean(dataStato, convert.convertStatoRichiesta("rifiutata"), richiesta);
			statoReg = new StatoTirocinioBean(richiesta.getRegistroTirocinio(), dataStato, convert.convertStatoTirocinio("annullato"));
			try {
				statoRichiesta.insert(statoRic);
				statoTirocinio.insert(statoReg);
			} catch (SQLException e1) {
				e1.printStackTrace();
				return false;
			}	
		}
		
		try {
			richiesta.setStatiRichiesta((ArrayList<StatoRichiestaBean>) statoRichiesta.getStatiRichiesta(richiesta));
			richiesta.getRegistroTirocinio().setStatiTirocinio((ArrayList<StatoTirocinioBean>) statoTirocinio.getStatiTirocinio(richiesta.getRegistroTirocinio()));
			richiesta.getRegistroTirocinio().getTutorAziendale().setRegistriTirocinio((ArrayList<RegistroTirocinioBean>) registroTirocinio.getRegistriDiTutorAziendale(richiesta.getRegistroTirocinio().getTutorAziendale()));
			richiesta.getRegistroTirocinio().getTutorUniversitario().setRegistriTirocinio((ArrayList<RegistroTirocinioBean>) registroTirocinio.getRegistriDiTutorUniversitario(richiesta.getRegistroTirocinio().getTutorUniversitario()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
}
