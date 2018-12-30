package it.chooseit.facade;

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
	
	public Collection<AziendaBean> listaAziende(){
		Collection<AziendaBean> aziende = new ArrayList<AziendaBean>();
		AziendaDAO aziendaDao = new Azienda();
		String order = "ragione_sociale";
		
		try {
			aziende = aziendaDao.retrieveAll(order);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		TutorAziendaleDAO tutorAziendale = new TutorAziendale();
		RichiestaTirocinioDAO richiestaTirocinio = new RichiestaTirocinio();
		
		for(AziendaBean a : aziende) {
			try {
				a.setTutorAziendali((ArrayList<TutorAziendaleBean>) tutorAziendale.getTutorDiAzienda(a));
				a.setRichiesteTirocinio((ArrayList<RichiestaTirocinioBean>) richiestaTirocinio.getRichiestePerAzienda(a));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return aziende;
	}
	
	public boolean inserisciAzienda(AziendaBean azienda) {
		AziendaDAO aziendaDao = new Azienda();
		
		try {
			aziendaDao.insert(azienda);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		TutorAziendaleDAO tutorAziendale = new TutorAziendale();
		RichiestaTirocinioDAO richiestaTirocinio = new RichiestaTirocinio();
		
		try {
			azienda.setTutorAziendali((ArrayList<TutorAziendaleBean>) tutorAziendale.getTutorDiAzienda(azienda));
			azienda.setRichiesteTirocinio((ArrayList<RichiestaTirocinioBean>) richiestaTirocinio.getRichiestePerAzienda(azienda));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public boolean aggiornaAzienda(AziendaBean azienda) {
		AziendaDAO aziendaDao = new Azienda();
		
		try {
			aziendaDao.update(azienda);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		TutorAziendaleDAO tutorAziendale = new TutorAziendale();
		RichiestaTirocinioDAO richiestaTirocinio = new RichiestaTirocinio();
		
		try {
			azienda.setTutorAziendali((ArrayList<TutorAziendaleBean>) tutorAziendale.getTutorDiAzienda(azienda));
			azienda.setRichiesteTirocinio((ArrayList<RichiestaTirocinioBean>) richiestaTirocinio.getRichiestePerAzienda(azienda));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public Collection<StudenteBean> listaStudenti(String ruoloUtente, String email){
		Collection<StudenteBean> studenti = new ArrayList<StudenteBean>();
		StudenteDAO studenteDao = new Studente();
		
		if(ruoloUtente.equalsIgnoreCase("Presidente")) {
			try {
				studenti = studenteDao.getStudentiPerStatoRichiesta("in convalida");
				studenti.addAll(studenteDao.getStudentiPerStatoTirocinio("in corso"));
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		else if (ruoloUtente.equalsIgnoreCase("Segreteria")) {
			try {
				studenti = studenteDao.getStudentiPerStatoRichiesta("nuova");
				studenti.addAll(studenteDao.getStudentiPerStatoRichiesta("in validazione"));
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		else if (ruoloUtente.equalsIgnoreCase("TutorAziendale")) {
			TutorAziendaleDAO tutorAziendale = new TutorAziendale();
			try {
				studenti = studenteDao.getStudentiAssociati(tutorAziendale.retrieveByKey(email));
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		else if (ruoloUtente.equalsIgnoreCase("TutorUniversitario")) {
			TutorUniversitarioDAO tutorUniversitario = new TutorUniversitario();
			try {
				studenti = studenteDao.getStudentiAssociati(tutorUniversitario.retrieveByKey(email));
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		
		RegistroTirocinioDAO registroTirocinio = new RegistroTirocinio();
		RichiestaTirocinioDAO richiestaTirocinio = new RichiestaTirocinio();
		
		for(StudenteBean s : studenti) {
			try {
				s.setRegistriTirocinio((ArrayList<RegistroTirocinioBean>) registroTirocinio.getRegistriDiStudente(s));
				s.setRichiesteTirocinio((ArrayList<RichiestaTirocinioBean>) richiestaTirocinio.getRichiestaPerStudente(s));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return studenti;
	}
	
	public Collection<RichiestaTirocinioBean> listaRichiesteTirocinio(String ruoloUtente){
		Collection<RichiestaTirocinioBean> richieste = new ArrayList<RichiestaTirocinioBean>();
		RichiestaTirocinioDAO richiestaDao = new RichiestaTirocinio();
		
		if(ruoloUtente.equalsIgnoreCase("Presidente")) {
			try {
				richieste = richiestaDao.getRichiestaPerStato("in convalida");
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		else if (ruoloUtente.equalsIgnoreCase("Segreteria")) {
			try {
				richieste = richiestaDao.getRichiestaPerStato("nuova");
				richieste.addAll(richiestaDao.getRichiestaPerStato("in validazione"));
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		
		StatoRichiestaDAO statoRichiesta = new StatoRichiesta();
		
		for(RichiestaTirocinioBean r : richieste) {
			try {
				r.setStatiRichiesta((ArrayList<StatoRichiestaBean>) statoRichiesta.getStatiRichiesta(r));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return richieste;
	}
	
	public boolean inviaRichiestaTirocinio(RichiestaTirocinioBean richiesta) {
		RichiestaTirocinioDAO richiestaTirocinio = new RichiestaTirocinio();
		StatoRichiestaDAO statoRichiesta = new StatoRichiesta();
		StatoRichiestaBean statoRic = null;
		Date dataStato = new Date(System.currentTimeMillis());
		ConvertEnum convert = new ConvertEnum();
		
		statoRic = new StatoRichiestaBean(dataStato, convert.convertStatoRichiesta("nuova"), richiesta);
		try {
			richiestaTirocinio.insert(richiesta);
			statoRichiesta.insert(statoRic);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		try {
			richiesta.setStatiRichiesta((ArrayList<StatoRichiestaBean>) statoRichiesta.getStatiRichiesta(richiesta));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public boolean valutazioneInizialeRichiestaTirocinio(RichiestaTirocinioBean richiesta, TutorAziendaleBean tutorAziendale, TutorUniversitarioBean tutorUniversitario, String scelta) {
		StatoRichiestaDAO statoRichiesta = new StatoRichiesta();
		RegistroTirocinioDAO registro = new RegistroTirocinio();
		StatoTirocinioDAO statoTirocinio = new StatoTirocinio();
		RegistroTirocinioDAO registroTirocinio = new RegistroTirocinio();
		StatoRichiestaBean statoRic = null;
		StatoTirocinioBean statoReg = null;
		Date dataStato = new Date(System.currentTimeMillis());
		ConvertEnum convert = new ConvertEnum();
			
		if(scelta.equalsIgnoreCase("in validazione")) {
			richiesta.setRegistroTirocinio(new RegistroTirocinioBean(richiesta.getStudente(), tutorAziendale, tutorUniversitario, richiesta));
			statoRic = new StatoRichiestaBean(dataStato, convert.convertStatoRichiesta("invalidazione"), richiesta);
			
			try {
				registro.insert(richiesta.getRegistroTirocinio());
				statoRichiesta.insert(statoRic);
			} catch (SQLException e1) {
				e1.printStackTrace();
				return false;
			}
		
			richiesta.setRegistroTirocinio(richiesta.getRegistroTirocinio());
			try {
				richiesta.setStatiRichiesta((ArrayList<StatoRichiestaBean>) statoRichiesta.getStatiRichiesta(richiesta));
				richiesta.getRegistroTirocinio().setStatiTirocinio((ArrayList<StatoTirocinioBean>) statoTirocinio.getStatiTirocinio(richiesta.getRegistroTirocinio()));
				richiesta.getRegistroTirocinio().getTutorAziendale().setRegistriTirocinio((ArrayList<RegistroTirocinioBean>) registroTirocinio.getRegistriDiTutorAziendale(richiesta.getRegistroTirocinio().getTutorAziendale()));
				richiesta.getRegistroTirocinio().getTutorUniversitario().setRegistriTirocinio((ArrayList<RegistroTirocinioBean>) registroTirocinio.getRegistriDiTutorUniversitario(richiesta.getRegistroTirocinio().getTutorUniversitario()));
			} catch (SQLException e) {
				e.printStackTrace();
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
		
			try {
				richiesta.setStatiRichiesta((ArrayList<StatoRichiestaBean>) statoRichiesta.getStatiRichiesta(richiesta));
				richiesta.getRegistroTirocinio().setStatiTirocinio((ArrayList<StatoTirocinioBean>) statoTirocinio.getStatiTirocinio(richiesta.getRegistroTirocinio()));
				richiesta.getRegistroTirocinio().getTutorAziendale().setRegistriTirocinio((ArrayList<RegistroTirocinioBean>) registroTirocinio.getRegistriDiTutorAziendale(richiesta.getRegistroTirocinio().getTutorAziendale()));
				richiesta.getRegistroTirocinio().getTutorUniversitario().setRegistriTirocinio((ArrayList<RegistroTirocinioBean>) registroTirocinio.getRegistriDiTutorUniversitario(richiesta.getRegistroTirocinio().getTutorUniversitario()));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return true;
	}
	
	public boolean valutazioneFinaleRichiestaTirocinio(RichiestaTirocinioBean richiesta, String scelta) {
		StatoRichiestaDAO statoRichiesta = new StatoRichiesta();
		StatoTirocinioDAO statoTirocinio = new StatoTirocinio();
		RegistroTirocinioDAO registroTirocinio = new RegistroTirocinio();
		StatoRichiestaBean statoRic = null;
		StatoTirocinioBean statoReg = null;
		Date dataStato = new Date(System.currentTimeMillis());
		ConvertEnum convert = new ConvertEnum();
		
		if(scelta.equalsIgnoreCase("in convalida")) {
			StatoRichiestaBean stato = new StatoRichiestaBean(dataStato, convert.convertStatoRichiesta("inconvalida"), richiesta);
			try {
				statoRichiesta.insert(stato);
			} catch (SQLException e1) {
				e1.printStackTrace();
				return false;
			}
		
			try {
				richiesta.setStatiRichiesta((ArrayList<StatoRichiestaBean>) statoRichiesta.getStatiRichiesta(richiesta));
				richiesta.getRegistroTirocinio().setStatiTirocinio((ArrayList<StatoTirocinioBean>) statoTirocinio.getStatiTirocinio(richiesta.getRegistroTirocinio()));
				richiesta.getRegistroTirocinio().getTutorAziendale().setRegistriTirocinio((ArrayList<RegistroTirocinioBean>) registroTirocinio.getRegistriDiTutorAziendale(richiesta.getRegistroTirocinio().getTutorAziendale()));
				richiesta.getRegistroTirocinio().getTutorUniversitario().setRegistriTirocinio((ArrayList<RegistroTirocinioBean>) registroTirocinio.getRegistriDiTutorUniversitario(richiesta.getRegistroTirocinio().getTutorUniversitario()));
			} catch (SQLException e) {
				e.printStackTrace();
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
		
			try {
				richiesta.setStatiRichiesta((ArrayList<StatoRichiestaBean>) statoRichiesta.getStatiRichiesta(richiesta));
				richiesta.getRegistroTirocinio().setStatiTirocinio((ArrayList<StatoTirocinioBean>) statoTirocinio.getStatiTirocinio(richiesta.getRegistroTirocinio()));
				richiesta.getRegistroTirocinio().getTutorAziendale().setRegistriTirocinio((ArrayList<RegistroTirocinioBean>) registroTirocinio.getRegistriDiTutorAziendale(richiesta.getRegistroTirocinio().getTutorAziendale()));
				richiesta.getRegistroTirocinio().getTutorUniversitario().setRegistriTirocinio((ArrayList<RegistroTirocinioBean>) registroTirocinio.getRegistriDiTutorUniversitario(richiesta.getRegistroTirocinio().getTutorUniversitario()));
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
		
			try {
				richiesta.setStatiRichiesta((ArrayList<StatoRichiestaBean>) statoRichiesta.getStatiRichiesta(richiesta));
				richiesta.getRegistroTirocinio().setStatiTirocinio((ArrayList<StatoTirocinioBean>) statoTirocinio.getStatiTirocinio(richiesta.getRegistroTirocinio()));
				richiesta.getRegistroTirocinio().getTutorAziendale().setRegistriTirocinio((ArrayList<RegistroTirocinioBean>) registroTirocinio.getRegistriDiTutorAziendale(richiesta.getRegistroTirocinio().getTutorAziendale()));
				richiesta.getRegistroTirocinio().getTutorUniversitario().setRegistriTirocinio((ArrayList<RegistroTirocinioBean>) registroTirocinio.getRegistriDiTutorUniversitario(richiesta.getRegistroTirocinio().getTutorUniversitario()));
			} catch (SQLException e) {
				e.printStackTrace();
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
		
			try {
				richiesta.setStatiRichiesta((ArrayList<StatoRichiestaBean>) statoRichiesta.getStatiRichiesta(richiesta));
				richiesta.getRegistroTirocinio().setStatiTirocinio((ArrayList<StatoTirocinioBean>) statoTirocinio.getStatiTirocinio(richiesta.getRegistroTirocinio()));
				richiesta.getRegistroTirocinio().getTutorAziendale().setRegistriTirocinio((ArrayList<RegistroTirocinioBean>) registroTirocinio.getRegistriDiTutorAziendale(richiesta.getRegistroTirocinio().getTutorAziendale()));
				richiesta.getRegistroTirocinio().getTutorUniversitario().setRegistriTirocinio((ArrayList<RegistroTirocinioBean>) registroTirocinio.getRegistriDiTutorUniversitario(richiesta.getRegistroTirocinio().getTutorUniversitario()));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return true;
	}
	
}
