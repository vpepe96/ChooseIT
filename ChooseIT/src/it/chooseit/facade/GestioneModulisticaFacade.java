package it.chooseit.facade;

import java.io.File;

import it.chooseit.bean.AziendaBean;
import it.chooseit.bean.ReportBean;
import it.chooseit.bean.RichiestaTirocinioBean;
import it.chooseit.bean.UtenteBean;

/**
 * Definisce i metodi per gestire le funzionalit&agrave; relative all' upload e download della modulistica.
 */
public class GestioneModulisticaFacade {

  /**
   * Permette di caricare sul server un progetto Formativo relativo ad un'azienda in fase di inserimento o modifica dell'azienda.
   * PRE: azienda != null AND relative != null
   * @param azienda azienda di cui caricare il file
   * @param relative path relativo dove salvare il file 
   * @return String path assoluto corretto in cui salvare il file 
   */
  public static String  uploadProgettoFormativo(AziendaBean azienda, String relative) {
    String path=relative+"\\files\\aziende";
    File dir=new File(path);

    if(!dir.exists()) {
      //se la cartella non esiste la crea e poi procede
      dir.mkdirs();
    }

    String fileName=azienda.getRagioneSociale();
    path=""+path+File.separator+fileName+".pdf";

    return path;
  }


  /**
   * Permette di caricare sul server una Richiesta di Tirocinio relativa ad uno studente.
   * PRE: richiesta != null AND relative != null
   * @param richiesta richiesta di cui caricare il file
   * @param relative path relativo dove salvare il file 
   * @return String path assoluto corretto in cui salvare il file 
   */
  public static String uploadRichiestaTirocinio(RichiestaTirocinioBean richiesta, String relative) {
    String path=relative+"\\files\\studenti";
    File dir=new File(path);

    if(!dir.exists()) {
      //se la cartella non esiste la crea e poi procede
      dir.mkdirs();
    }

    //apro la ccrtella relativa allo studente specifico
    path=""+path+File.separator+richiesta.getStudente().getMatricola();

    dir=new File(path);

    if(!dir.exists()) {
      //se la cartella non esiste la crea e poi procede
      dir.mkdirs();
    }

    String fileName="RichiestaTirocinio.pdf";
    path=""+path+File.separator+fileName;

    return path;
  }


  /**
   * Permette di caricare sul server un Report relativo ad uno studente.
   * PRE: report != null AND report != null
   * @param report report di cui caricare il file
   * @param relative path relativo dove salvare il file 
   * @return String path assoluto corretto in cui salvare il file 
   */
  public static String uploadReport(ReportBean report, String relative) {

    String path=relative+"\\files\\studenti";
    File dir=new File(path);

    if(!dir.exists()) {
      //se la cartella non esiste la crea e poi procede
      dir.mkdirs();
    }

    //apro la ccrtella relativa allo studente specifico
    path=""+path+File.separator+report.getRegistroTirocinio().getStudente().getMatricola();

    dir=new File(path);

    if(!dir.exists()) {
      //se la cartella non esiste la crea e poi procede
      dir.mkdirs();
    }

    //dopo aver avuto accesso alla cartella dello studente deve creare, se non esiste, la cartella RegistroTirocinio
    path=""+path+File.separator+"RegistroTirocinio";
    dir=new File(path);

    if(!dir.exists()) {
      //se la cartella non esiste la crea e poi procede
      dir.mkdirs();
    }


    String fileName=""+report.getDataInserimento().toString()+".pdf";
    path=""+path+File.separator+fileName;

    return path;
  }



  /**
   * Permette di caricare sul server un'immagine relativa ad uno studente.
   * PRE: uetnte != null AND relative != null
   * @param utente Utente di cui si desidera caricare l'immagine.
   * @param relative path relativo dove salvare il file 
   * @return String path assoluto corretto in cui salvare il file 
   */
  public static String uploadImmagine(UtenteBean utente, String relative) {
    String path=relative+"\\files\\img";
    File dir=new File(path);

    if(!dir.exists()) {
      //se la cartella non esiste la crea e poi procede
      dir.mkdirs();
    }

    String fileName=""+modificaEmail(utente.getEmail())+".jpg"; 
    path=""+path+File.separator+fileName;

    return path;
  }


  /**
   * Permette di scaricare dal server un progetto formativo relativo ad un'azienda.
   * PRE: azienda != null AND relative != null
   * @param azienda azienda della quale si desidera scaricare il progetto formativo. 
   * @param relative path relativo dove recuperare il file. 
   * @return File Progetto formativo richiesto (se disponibile), null altrimenti.
   */
  public static File downloadProgettoFormativo(AziendaBean azienda, String relative) {
    String filePath=relative+"\\files\\aziende";
    String fileName=""+azienda.getRagioneSociale();
    filePath=filePath+File.separator+fileName;

    System.out.println("Downloading: "+filePath);

    File f=new File(filePath);

    if(!f.exists()) {
      return null;
    }else {
      return f;
    }


  }


  /**
   * Permette di scaricare dal server una Richiesta di tirocinio relativa ad uno studente.
   * PRE: richiesta != null AND relative != null
   * @param richiesta richiesta della quale si desidera scaricare il file. 
   * @param relative path relativo dove recuperare il file. 
   * @return File Richiesta di tirocinio richiesta (se disponibile), null altrimenti.
   */
  public static File downloadRichiestaTirocinio(RichiestaTirocinioBean richiesta, String relative) {
    String path=relative+"\\files\\studenti";
    path=""+path+File.separator+richiesta.getStudente().getMatricola();

    String fileName="RichiestaTirocinio.pdf";
    path=""+path+File.separator+fileName;
    File f=new File(path);
    if(!f.exists()) {
      return null;
    }else {
      return f;
    }

  }


  /**
   * Permette di scaricare dal server un Report relativo ad uno studente.
   * PRE: azienda != null AND relative != null
   * @param report report del quale si desidera ottenere il file. 
   * @param relative path relativo dove recuperare il file. 
   * @return File Report richiesto (se disponibile), null altrimenti.
   */
  public static File downloadReport(ReportBean report, String relative) {
    String path=relative+"\\files\\studenti"+File.separator+report.getRegistroTirocinio().getStudente().getMatricola()+File.separator+"RegistroTirocinio";
    String fileName=""+report.getDataInserimento().toString()+".pdf";
    path=""+path+File.separator+fileName;
    System.out.println("Downloading: "+path);
    File f=new File(path);
    if(!f.exists()) {
      return null;
    }else {
      return f;
    }
  }




  private static String modificaEmail(String email) {
    email=email.replace(".", "_");
    email=email.replace("@","_");
    System.out.println(email);
    return email;
  }

}
