package it.chooseit.facade;

import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.ReportBean;
import it.chooseit.bean.StudenteBean;
import it.chooseit.bean.TutorAziendaleBean;
import it.chooseit.bean.TutorUniversitarioBean;
import it.chooseit.dao.QuestionarioAziendaDAO;
import it.chooseit.dao.QuestionarioStudenteDAO;
import it.chooseit.dao.RegistroTirocinioDAO;
import it.chooseit.dao.ReportDAO;
import it.chooseit.impl.QuestionarioAzienda;
import it.chooseit.impl.QuestionarioStudente;
import it.chooseit.impl.RegistroTirocinio;
import it.chooseit.impl.Report;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import it.chooseit.bean.QuestionarioAziendaBean;
import it.chooseit.bean.QuestionarioStudenteBean;

/**
 * Definisce i metodi per la gestione dei Report.
 */
public class GestioneReportFacade {

	/**
	 * Permette di prelevare le informazioni relative a tutti i registri di
	 * tirocinio.
	 * 
	 * @return un insieme di registri di tirocinio se non ci sono errori, null
	 *         altrimenti
	 */
	public Collection<RegistroTirocinioBean> listaRegistroTirocinio() {

		Collection<RegistroTirocinioBean> list = new ArrayList<>();
		RegistroTirocinioDAO registro = new RegistroTirocinio();
		try {
			list = registro.getRegistriDiTirociniInCorso();
			list.addAll(registro.getRegistriDiTirociniInCorso());
			return list;
		} catch (SQLException e) {
			return null;
		}
	}

	/**
	 * Permette di prelevare informazioni relative ai registri di Tirocinio
	 * associati al tutor aziendale. PRE: tutor != null
	 * 
	 * @param tutor riferimento al tutor aziendale
	 * @return un insieme di registri associati al tutor aziendale
	 */
	public Collection<RegistroTirocinioBean> listaTirocinio(TutorAziendaleBean tutor) {
		Collection<RegistroTirocinioBean> list = new ArrayList<>();
		RegistroTirocinioDAO registro = new RegistroTirocinio();
		try {
			list = registro.getRegistriDiTutorAziendale(tutor);
			return list;
		} catch (SQLException e) {
			return null;
		}
	}

	/**
	 * Permette di prelevare informazioni relative ai registri di Tirocinio
	 * associati al tutor universitario. PRE: tutor != null
	 * 
	 * @param tutor riferimento al tutor universitario
	 * @return un insieme di registri associati al tutor universitario
	 */
	public Collection<RegistroTirocinioBean> listaRegistroTirocinio(TutorUniversitarioBean tutor) {
		Collection<RegistroTirocinioBean> list = new ArrayList<>();
		RegistroTirocinioDAO registro = new RegistroTirocinio();
		try {
			list = registro.getRegistriDiTutorUniversitario(tutor);
			return list;
		} catch (SQLException e) {
			return null;
		}
	}

	/**
	 * Permette di inserire un report nel registro di tirocinio assegnato.
	 * 
	 * @param report   il report da inserire nel registro di tirocinio
	 * @param registro il registro di tirocinio nel quale inserire il report
	 */
	public void inserimentoReport(ReportBean report, RegistroTirocinioBean registro) {
		try {
			if (report != null && registro != null) {
				ReportDAO reportD = new Report();
				reportD.insert(report);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Permette di recuperare un insieme di questionari valutativi sullo studente
	 * per il tutor aziendale.
	 * 
	 * @param tutor il tutor aziendale del quale si vogliono ricavare i questionari
	 *              da compilare
	 * @return un insieme di questionari valutativi sullo studente
	 */
	public Collection<QuestionarioStudenteBean> recuperaQuestionarioStudente(TutorAziendaleBean tutor) {
		Collection<QuestionarioStudenteBean> list = new ArrayList<>();
		QuestionarioStudenteDAO questionario = new QuestionarioStudente();
		if (tutor != null) {
			try {	
				list = questionario.getQuestionarioPer(tutor);
			} catch (SQLException E) {
				return null;
			}
		}
		return list;
	}

	/**
	 * Permette di recuperare un insieme di questionari valutativi sull'azienda
	 * per lo studente.
	 * 
	 * @param studente lo studente del quale si vogliono ricavare i questionari
	 *              da compilare
	 * @return un insieme di questionari valutativi sull'azienda
	 */
	public Collection<QuestionarioAziendaBean> recuperaQuestionarioAzienda(StudenteBean studente) {

		Collection<QuestionarioAziendaBean> list = new ArrayList<>();
		QuestionarioAziendaDAO questionario = new QuestionarioAzienda();
		if (studente != null) {
			try {
				list = questionario.getQuestionarioPer(studente);
			} catch (SQLException E) {
				return null;
			}
		}
		return list;
	}

	
	/**
	 * Permette l'inserimento di un questionario valutativo sullo studente associato 
	 * a un registro di tirocinio. 
	 * @param questionario il questionario da inserire
	 */
	public void inserisciQuestionarioStudente(QuestionarioStudenteBean questionario) {
		QuestionarioStudenteDAO nuovoQuestionario = new QuestionarioStudente();
		try {
			if (questionario != null) {
				nuovoQuestionario.insert(questionario);
			}
		} catch (SQLException E) {
		}
	}

	/**
	 * Permette l'inserimento di un questionario valutativo sull'azienda associato 
	 * a un registro di tirocinio. 
	 * @param questionario il questionario da inserire
	 */
	public void inserisciQuestionarioAzienda(QuestionarioAziendaBean questionario) {
		QuestionarioAziendaDAO nuovoQuestionario = new QuestionarioAzienda();
		try {
			if (questionario != null) {
				nuovoQuestionario.insert(questionario);
			}
		} catch (SQLException e) {
		}

	}
}