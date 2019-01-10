package it.chooseit.facade;

import java.sql.SQLException;
import java.util.ArrayList;

import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.ReportBean;
import it.chooseit.bean.RichiestaTirocinioBean;
import it.chooseit.bean.StatoReportBean;
import it.chooseit.bean.StatoRichiestaBean;
import it.chooseit.bean.StatoTirocinioBean;
import it.chooseit.bean.StudenteBean;
import it.chooseit.bean.TutorAziendaleBean;
import it.chooseit.bean.TutorUniversitarioBean;
import it.chooseit.bean.UtenteBean;
import it.chooseit.dao.PresidenteDAO;
import it.chooseit.dao.QuestionarioAziendaDAO;
import it.chooseit.dao.QuestionarioStudenteDAO;
import it.chooseit.dao.RegistroTirocinioDAO;
import it.chooseit.dao.ReportDAO;
import it.chooseit.dao.RichiestaTirocinioDAO;
import it.chooseit.dao.SegreteriaDAO;
import it.chooseit.dao.StatoReportDAO;
import it.chooseit.dao.StatoRichiestaDAO;
import it.chooseit.dao.StatoTirocinioDAO;
import it.chooseit.dao.StudenteDAO;
import it.chooseit.dao.TutorAziendaleDAO;
import it.chooseit.dao.TutorUniversitarioDAO;
import it.chooseit.dao.UtenteDAO;
import it.chooseit.impl.Presidente;
import it.chooseit.impl.QuestionarioAzienda;
import it.chooseit.impl.QuestionarioStudente;
import it.chooseit.impl.RegistroTirocinio;
import it.chooseit.impl.Report;
import it.chooseit.impl.RichiestaTirocinio;
import it.chooseit.impl.Segreteria;
import it.chooseit.impl.StatoReport;
import it.chooseit.impl.StatoRichiesta;
import it.chooseit.impl.StatoTirocinio;
import it.chooseit.impl.Studente;
import it.chooseit.impl.TutorAziendale;
import it.chooseit.impl.TutorUniversitario;
import it.chooseit.impl.Utente;

/**
 * Definisce i metodi per gestire le funzionalit&agrave; relative all&rsquo;account.
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

      //Se l'utente != null allora le credenziali sono giuste...
      if(utente != null) {
        //...quindi controllo il ruolo
        String ruolo = checkRuolo(utente);

        if(ruolo.equals("studente")) {
          //recupera le informazioni di studente dal db...
          StudenteDAO studenteDao = new Studente();
          StudenteBean studente = studenteDao.retrieveByKey(email);
          studente = getDatiDiStudente(studente);
          utente = studente;
        }

        if(ruolo.equals("segreteria")) {
          //recupera le informazioni di segreteria dal db...
          SegreteriaDAO segreteriaDao = new Segreteria();
          utente = segreteriaDao.retrieveByKey(email);
        }

        if(ruolo.equals("presidente")) {
          //recupera le informazioni di presidente dal db...
          PresidenteDAO presidenteDao = new Presidente();
          utente = presidenteDao.retrieveByKey(email);
        }

        if(ruolo.equals("tutorAziendale")) {
          //recupera le informazioni di tutor aziendale dal db...
          TutorAziendaleDAO tutorAziDao = new TutorAziendale();
          TutorAziendaleBean tutor = tutorAziDao.retrieveByKey(email);
          tutor = getDatiDiTutorAziendale(tutor);
          utente = tutorAziDao.retrieveByKey(email);
        }

        if(ruolo.equals("tutorUniversitario")) {
          //recupera le informazioni di tutor universitario dal db...
          TutorUniversitarioDAO tutorUniDao = new TutorUniversitario();
          TutorUniversitarioBean tutor = tutorUniDao.retrieveByKey(email);
          tutor = getDatiDiTutorUniversitario(tutor);
          utente = tutor;
        }

        return utente;

      }else {
        //..altrimenti le credenziali sono errate e return null;
        return null;
      }

    } catch (SQLException e) {
      //...altrimenti c'&egrave; stato un errore di accesso al db e return null
      return null;
    }
  }


  /**
   * Permette di recuperare tutti i dati associati allo studente mancanti dal retrieveByKey (listaRegistri e listaRichieste)
   * @param studente lo studente di cui si vogliono recuperare i dati
   * @return lo studente con tutti i dati associati 
   */
  public StudenteBean getDatiDiStudente(StudenteBean studente) {

    try {
      // prendi dati delle richieste
      RichiestaTirocinioDAO ricDao = new RichiestaTirocinio();
      ArrayList<RichiestaTirocinioBean> richieste = (ArrayList<RichiestaTirocinioBean>) ricDao.getRichiestePerStudente(studente);

      // prendi stati delle richieste
      StatoRichiestaDAO statoRicDao = new StatoRichiesta();
      for (RichiestaTirocinioBean richiestaTirocinioBean : richieste) {
        ArrayList<StatoRichiestaBean> statiRichiesta = (ArrayList<StatoRichiestaBean>) statoRicDao.getStatiRichiesta(richiestaTirocinioBean);
        for (StatoRichiestaBean statoRichiesta : statiRichiesta) {
          statoRichiesta.setRichiestaId(richiestaTirocinioBean);
        }
      }
      studente.setRichiesteTirocinio(richieste);

      // prendi dati dei registri
      RegistroTirocinioDAO regDao = new RegistroTirocinio();
      ArrayList<RegistroTirocinioBean> registri;

      registri = (ArrayList<RegistroTirocinioBean>) regDao.getRegistriDiStudente(studente);
      for (RegistroTirocinioBean registroTirocinioBean : registri) {
        registroTirocinioBean = getDatiDiRegistro(registroTirocinioBean);
        registroTirocinioBean.setStudente(studente);

        //aggiungi il registro alla richiesta
        RichiestaTirocinioBean richiesta = studente.getRichiestaTirocinio(registroTirocinioBean.getRichiestaTirocinio().getId());
        if(richiesta !=null)
          richiesta.setRegistroTirocinio(registroTirocinioBean);
      }
      studente.setRegistriTirocinio(registri);


    } catch (SQLException e) {
      // c'&egrave; stato un errore nel reperimento dati dal db, restituisci lo studente con i dati recuperati fin'ora
      return studente;
    }
    return studente;
  }


  /**
   * Permette di recuperare tutti i dati associati al tutor aziendale mancanti dal retrieveByKey (listaRegistriTirocinio)
   * @param tutor il tutor universitario del quale si vogliono recuperare i dati
   * @return il tutor universitario con tutti i dati associati
   */
  public TutorAziendaleBean getDatiDiTutorAziendale(TutorAziendaleBean tutor) {

    RegistroTirocinioDAO regDao = new RegistroTirocinio();
    ArrayList<RegistroTirocinioBean> registri;

    ReportDAO repoDao = new Report();
    ArrayList<ReportBean> reportFirmati = null;

    try {
      // prendi dati dei registri
      registri = (ArrayList<RegistroTirocinioBean>) regDao.getRegistriDiTutorAziendale(tutor);
      for (RegistroTirocinioBean registroTirocinioBean : registri) {
        registroTirocinioBean = getDatiDiRegistro(registroTirocinioBean);

        //prendi report firmati
        reportFirmati = (ArrayList<ReportBean>) repoDao.getReportFirmati(registroTirocinioBean);
        for (ReportBean reportBean : reportFirmati) {
          reportBean.setRegistroTirocinio(registroTirocinioBean);
          reportBean.setTutorAziendale(tutor);
        }
        tutor.setReports(reportFirmati);
      }
      tutor.setRegistriTirocinio(registri);


    } catch (SQLException e) {
      // c'&egrave; stato un errore nel reperimento dati dal db, restituisci il tutor aziendale con i dati recuperati fin'ora
      System.out.println(e.getMessage());
      return tutor;
    }
    return tutor;
  }


  /**
   * Permette di recuperare tutti i dati associati al tutor universitario mancanti dal retrieveByKey (listaRegistriTirocinio)
   * @param tutor il tutor universitario del quale si vogliono recuperare i dati
   * @return il tutor universitario con tutti i dati associati
   */
  public TutorUniversitarioBean getDatiDiTutorUniversitario(TutorUniversitarioBean tutor) {

    RegistroTirocinioDAO regDao = new RegistroTirocinio();
    ArrayList<RegistroTirocinioBean> registri;

    try {
      // prendi dati dei registri
      registri = (ArrayList<RegistroTirocinioBean>) regDao.getRegistriDiTutorUniversitario(tutor);
      for (RegistroTirocinioBean registroTirocinioBean : registri) {
        registroTirocinioBean = getDatiDiRegistro(registroTirocinioBean);
      }
      tutor.setRegistriTirocinio(registri);

    } catch (SQLException e) {
      // c'&egrave; stato un errore nel reperimento dati dal db, restituisci il tutor universitario con i dati recuperati fin'ora
      System.out.println(e.getMessage());
      return tutor;
    }
    return tutor;
  }


  /**
   * Permette di recuperare tutti i dati associati al registro di tirocinio mancanti dal retrieveByKey
   *  (richiestaTirocinio, listaReports, listaStatiTirocinio, questionarioAzienda, questionarioStudente)
   * @param registroTirocinioBean il registro del quale si vogliono recuperare i dati
   * @return il registro con tutti i dati associati
   * @throws SQLException
   */
  public RegistroTirocinioBean getDatiDiRegistro(RegistroTirocinioBean registroTirocinioBean) throws SQLException {

    ReportDAO repDao = new Report();
    StatoReportDAO sRepoDao = new StatoReport();

    StatoTirocinioDAO statoTirocinioDao = new StatoTirocinio();

    QuestionarioAziendaDAO qADao = new QuestionarioAzienda();
    QuestionarioStudenteDAO qSDao = new QuestionarioStudente();

    //recupera questionari
    registroTirocinioBean.setQuestionarioAzienda(qADao.retrieveByKey(registroTirocinioBean.getIdentificativo()));
    registroTirocinioBean.getQuestionarioAzienda().setRegistroTirocinio(registroTirocinioBean);
    registroTirocinioBean.setQuestionarioStudente(qSDao.retrieveByKey(registroTirocinioBean.getIdentificativo()));
    registroTirocinioBean.getQuestionarioStudente().setRegistroTirocinio(registroTirocinioBean);

    //recupera reports
    ArrayList<ReportBean> reports = (ArrayList<ReportBean>) repDao.getReportRegistro(registroTirocinioBean);
    for (ReportBean report : reports) {
      report.setRegistroTirocinio(registroTirocinioBean);
      //recupera stati reports
      ArrayList<StatoReportBean> statiReport = (ArrayList<StatoReportBean>) sRepoDao.getStatiReport(report);
      for (StatoReportBean statoBean : statiReport) {
        statoBean.setRegistroTirocinio(registroTirocinioBean);
        statoBean.setReport(report);
      }
      report.setStatiReport(statiReport);
    }
    registroTirocinioBean.setReports(reports);

    //recupera stati tirocinio
    ArrayList<StatoTirocinioBean> statiTirocinio = (ArrayList<StatoTirocinioBean>) statoTirocinioDao.getStatiTirocinio(registroTirocinioBean); 
    registroTirocinioBean.setStatiTirocinio(statiTirocinio);
    for (StatoTirocinioBean statoBean : statiTirocinio) {
      statoBean.setRegistroTirocinio(registroTirocinioBean);
    }
    return registroTirocinioBean;
  }


  /**
   * Permette di registrare un nuovo studente al sito.
   * @param studente lo studente da registrare
   * @param pwd la password dello studente da registrare
   * @return true se la registrazione &egrave; andata a buon fine, false altrimenti
   */
  public boolean registrazione(StudenteBean studente, String pwd) {

    StudenteDAO studenteDao = new Studente();
    try {
      // Aggiunta studente nel database ...
      studenteDao.insert(studente,pwd);
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
   * @return il ruolo dell'utente come String, null se l'utente non esiste
   */
  public String checkRuolo(UtenteBean utente) {
    String email = utente.getEmail();
    String ruolo = null;
    UtenteDAO utenteDao = new Utente();

    //Controlla il ruolo dell'utente
    try {
      //Se l'utente esiste...
      if(utenteDao.retrieveByKey(email) != null) {

        // Controllo se l'utente &egrave; studente
        StudenteDAO studenteDao = new Studente();
        if(studenteDao.retrieveByKey(email) != null) {
          ruolo = "studente";
        }

        // Controllo se l'utente &egrave; segreteria
        SegreteriaDAO segreteriaDao = new Segreteria();
        if(segreteriaDao.retrieveByKey(email) != null) {
          ruolo = "segreteria";
        }

        // Controllo se l'utente &egrave; presidente
        PresidenteDAO presidenteDao = new Presidente();
        if(presidenteDao.retrieveByKey(email) != null) {
          ruolo = "presidente";
        }

        // Controllo se l'utente &egrave; tutor aziendale
        TutorAziendaleDAO tutorAziDao = new TutorAziendale();
        if(tutorAziDao.retrieveByKey(email) != null) {
          ruolo = "tutorAziendale";
        }

        // Controllo se l'utente &egrave; tutor universitario
        TutorUniversitarioDAO tutorUniDao = new TutorUniversitario();
        if(tutorUniDao.retrieveByKey(email) != null) {
          ruolo = "tutorUniversitario";
        }

        return ruolo;
      }else {
        //...altrimenti l'utente non esiste (return null)
        return null;
      }
    } catch (SQLException e) {
      //...altrimenti c'&egrave; stato un errore di accesso al db e return null
      return null;
    }
  }

}
