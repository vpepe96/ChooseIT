package it.chooseit.facade;

import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.ReportBean;
import it.chooseit.bean.StatoReportBean;
import it.chooseit.bean.StudenteBean;
import it.chooseit.bean.TutorAziendaleBean;
import it.chooseit.bean.TutorUniversitarioBean;
import it.chooseit.dao.QuestionarioAziendaDAO;
import it.chooseit.dao.QuestionarioStudenteDAO;
import it.chooseit.dao.RegistroTirocinioDAO;
import it.chooseit.dao.ReportDAO;
import it.chooseit.dao.StatoReportDAO;
import it.chooseit.impl.QuestionarioAzienda;
import it.chooseit.impl.QuestionarioStudente;
import it.chooseit.impl.RegistroTirocinio;
import it.chooseit.impl.Report;
import it.chooseit.impl.StatoReport;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
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
    GestioneAccountFacade g = new GestioneAccountFacade();
    try {
      list = registro.retrieveAll(null);
      for (RegistroTirocinioBean registroTirocinioBean : list) {
        g.getDatiDiRegistro(registroTirocinioBean);
      }
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
  public void inserimentoReport(ReportBean report) {
    try {
      if (report != null ) {
        ReportDAO reportD = new Report();
        reportD.insert(report);
        StatoReportDAO statoDao = new StatoReport();
        StatoReportBean stato = new StatoReportBean();
        stato.setRegistroTirocinio(report.getRegistroTirocinio());
        stato.setDataStato(report.getDataInserimento());
        stato.setReport(report);
        stato.setTipo(it.chooseit.bean.StatoReportBean.StatoReport.COMPILATO);
        statoDao.insert(stato);
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
        list = questionario.getQuestionarioPerTutorAziendale(tutor);
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
        list = questionario.getQuestionarioPerStudente(studente);
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
        System.out.println("cancella questionario");
        nuovoQuestionario.delete(questionario.getRegistroTirocinio().getIdentificativo());
        System.out.println("inserisci questionario");
        nuovoQuestionario.insert(questionario);
      }else {
        System.out.println("questionario null");
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
        System.out.println("cancella questionario");
        nuovoQuestionario.delete(questionario.getRegistroTirocinio().getIdentificativo());
        System.out.println("inserisci questionario");
        nuovoQuestionario.insert(questionario);
      }
    } catch (SQLException e) {
    }

  }


  /**
   * Permette l'inserimento della firma da parte del tutor in un determinato report
   * @param report e tutorAziendale
   */

  public ReportBean inserimentoFirma(ReportBean bean,TutorAziendaleBean tutor) {

    ReportDAO report =new Report();
    StatoReportDAO stato = new StatoReport();
    try {

      if( bean!=null) {
        bean.setTutorAziendale(tutor);
        report.update(bean);
        Date dataStato = new Date(Calendar.getInstance().getTimeInMillis());
        StatoReportBean stRepo = new StatoReportBean(dataStato, it.chooseit.bean.StatoReportBean.StatoReport.VALIDATO, bean, bean.getRegistroTirocinio());
        stato.insert(stRepo);
      }
    }catch (SQLException e) {
      return null;
    }
    return bean;

  }
  /**
   * Permette l'inserimento del report  da parte dello studente
   * @param report e tutorAziendale
   */

  public ReportBean inserimentoFirma(ReportBean bean) {

    ReportDAO report =new Report();
    try {

      if( bean!=null) {
        report.update(bean);

      }
    }catch (SQLException e) {
      return null;
    }
    return bean;

  }
}