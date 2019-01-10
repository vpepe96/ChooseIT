package it.chooseit.bean;

import java.io.Serializable;


/**
 * Un oggetto QuestionarioAziendaBean rappresenta un questionario valutativo che viene compilato da un tirocinante 
 * in riferimento ad un tutor aziendale.
 * Un questionario azienda ha un collegamento al registro di tirocinio, rappresentato con la variabile d'istanza 
 * registroTirocinio, le risposte alle domande relatite al progetto di tirocinio, rappresentate con le variabili 
 * d'istanza pdt1, pdt2, pdt3, pdt4 e pdt5, le risposte alle domande relative all'ente ospitante, rappresentate 
 * con le variabili d'istanza eo1, eo2, eo3, eo4 e eo5, e le risposte delle domande relative alle strutture 
 * universitarie addette alla gestione dei tirocini, che vengono rappresentate con le varibili d'istanza su1, su2 e su3.
 *  
 * @author RocketStudios
 */
public class QuestionarioAziendaBean implements Serializable{

  private static final long serialVersionUID = 1L;

  /**
   * Rappresenta il registro di tirocinio a cui &egrave; collegato il questionario
   */
  private RegistroTirocinioBean registroTirocinio;

  /**
   * Rappresenta la prima risposta relativa alla prima domanda sul progetto di tirocinio del questionario
   */
  private int pdt1;

  /**
   * Rappresenta la seconda risposta relativa alla seconda domanda sul progetto di tirocinio del questionario
   */
  private int pdt2;

  /**
   * Rappresenta la terza risposta relativa alla terza domanda sul progetto di tirocinio del questionario
   */
  private int pdt3;

  /**
   * Rappresenta la quarta risposta relativa alla quarta domanda sul progetto di tirocinio del questionario
   */
  private int pdt4;

  /**
   * Rappresenta la quinta risposta relativa alla quinta domanda sul progetto di tirocinio del questionario
   */
  private int pdt5;

  /**
   * Rappresenta la prima risposta relativa alla prima domanda sull'ente ospitante del questionario
   */
  private int eo1;

  /**
   * Rappresenta la seconda risposta relativa alla seconda domanda sull'ente ospitante del questionario
   */
  private int eo2;

  /**
   * Rappresenta la terza risposta relativa alla terza domanda sull'ente ospitante del questionario
   */
  private int eo3;

  /**
   * Rappresenta la quarta risposta relativa alla quarta domanda sull'ente ospitante del questionario
   */
  private int eo4;

  /**
   * Rappresenta la quinta risposta relativa alla quinta domanda sull'ente ospitante del questionario
   */
  private int eo5;

  /**
   * Rappresenta la prima risposta relativa alla prima domanda sulle strutture universitarie addette alla gestione dei tirocini del questionario
   */
  private int su1;

  /**
   * Rappresenta la seconda risposta relativa alla seconda domanda sulle strutture universitarie addette alla gestione dei tirocini del questionario
   */
  private int su2;

  /**
   * Rappresenta la terza risposta relativa alla terza domanda sulle strutture universitarie addette alla gestione dei tirocini del questionario
   */
  private int su3;

  /**
   * Costruttore di QuestionarioAziendaBean
   * 
   * @param registroTirocinio registro di tirocinio associato
   */
  public QuestionarioAziendaBean(RegistroTirocinioBean registroTirocinio) {
    this.registroTirocinio = registroTirocinio;
  }

  /**
   * Costruttore vuoto di QuestionarioAziendaBean.
   */
  public QuestionarioAziendaBean() {}
  /*
    |--------------------------------------------------------------------------
    | Interfaccia pubblica
    |--------------------------------------------------------------------------
   */

  /**
   * Restituisce il registro di tirocinio a cui &egrave; associato QuestionarioAziendaBean
   * 
   * @return registro di tirocinio associato
   */
  public RegistroTirocinioBean getRegistroTirocinio() {
    return registroTirocinio;
  }

  /**
   * Setta un nuovo registro di tirocinio a cui &egrave; associato QuestionarioAziendaBean
   * 
   * Pre: registro != null
   * @param registro nuovo registro di tirocinio associato
   */
  public void setRegistroTirocinio(RegistroTirocinioBean registroTirocinio) {
    this.registroTirocinio = registroTirocinio;
  }

  /**
   * Restituisce la risposta alla prima domanda relativa al progetto di tirocinio di QuestionarioAziendaBean
   * 
   * @return risposta alla prima domanda relativa al progetto di tirocinio 
   */
  public int getPdt1() {
    return pdt1;
  }

  /**
   * Setta la risposta alla prima domanda relativa al progetto di tirocinio di QuestionarioAziendaBean
   * 
   * Pre: pdt1 > 0 && pdt1 < 6
   * @param pdt1 nuova risposta alla prima domanda relativa al progetto di tirocinio 
   */
  public void setPdt1(int pdt1) {
    this.pdt1 = pdt1;
  }

  /**
   * Restituisce la risposta alla seconda domanda relativa al progetto di tirocinio di QuestionarioAziendaBean
   * 
   * @return risposta alla seconda domanda relativa al progetto di tirocinio 
   */
  public int getPdt2() {
    return pdt2;
  }

  /**
   * Setta la risposta alla seconda domanda relativa al progetto di tirocinio di QuestionarioAziendaBean
   * 
   * Pre: pdt2 > 0 && pdt2 < 6
   * @param pdt2 nuova risposta alla seconda domanda relativa al progetto di tirocinio 
   */
  public void setPdt2(int pdt2) {
    this.pdt2 = pdt2;
  }

  /**
   * Restituisce la risposta alla terza domanda relativa al progetto di tirocinio di QuestionarioAziendaBean
   * 
   * @return risposta alla terza domanda relativa al progetto di tirocinio 
   */
  public int getPdt3() {
    return pdt3;
  }

  /**
   * Setta la risposta alla terza domanda relativa al progetto di tirocinio di QuestionarioAziendaBean
   * 
   * Pre: pdt3 > 0 && pdt3 < 6
   * @param pdt3 nuova risposta alla terza domanda relativa al progetto di tirocinio 
   */
  public void setPdt3(int pdt3) {
    this.pdt3 = pdt3;
  }

  /**
   * Restituisce la risposta alla quarta domanda relativa al progetto di tirocinio di QuestionarioAziendaBean
   * 
   * @return risposta alla quarta domanda relativa al progetto di tirocinio 
   */
  public int getPdt4() {
    return pdt4;
  }

  /**
   * Setta la risposta alla quarta domanda relativa al progetto di tirocinio di QuestionarioAziendaBean
   * 
   * Pre: pdt4 > 0 && pdt4 < 6
   * @param pdt4 nuova risposta alla quarta domanda relativa al progetto di tirocinio 
   */
  public void setPdt4(int pdt4) {
    this.pdt4 = pdt4;
  }

  /**
   * Restituisce la risposta alla quinta domanda relativa al progetto di tirocinio di QuestionarioAziendaBean
   * 
   * @return risposta alla quinta domanda relativa al progetto di tirocinio 
   */
  public int getPdt5() {
    return pdt5;
  }

  /**
   * Setta la risposta alla quinta domanda relativa al progetto di tirocinio di QuestionarioAziendaBean
   * 
   * Pre: pdt5 > 0 && pdt5 < 6
   * @param pdt5 nuova risposta alla quinta domanda relativa al progetto di tirocinio 
   */
  public void setPdt5(int pdt5) {
    this.pdt5 = pdt5;
  }

  /**
   * Restituisce la risposta alla prima domanda relativa all'ente ospitante di QuestionarioAziendaBean
   * 
   * @return risposta alla prima domanda relativa all'ente ospitante 
   */
  public int getEo1() {
    return eo1;
  }

  /**
   * Setta la risposta alla prima domanda relativa all'ente ospitante di QuestionarioAziendaBean
   * 
   * Pre: eo1 > 0 && eo1 < 6
   * @param eo1 nuova risposta alla prima domanda relativa all'ente ospitante 
   */
  public void setEo1(int eo1) {
    this.eo1 = eo1;
  }

  /**
   * Restituisce la risposta alla seconda domanda relativa all'ente ospitante di QuestionarioAziendaBean
   * 
   * @return risposta alla seconda domanda relativa all'ente ospitante 
   */
  public int getEo2() {
    return eo2;
  }

  /**
   * Setta la risposta alla seconda domanda relativa all'ente ospitante di QuestionarioAziendaBean
   * 
   * Pre: eo2 > 0 && eo2 < 6
   * @param eo2 nuova risposta alla seconda domanda relativa all'ente ospitante 
   */
  public void setEo2(int eo2) {
    this.eo2 = eo2;
  }

  /**
   * Restituisce la risposta alla terza domanda relativa all'ente ospitante di QuestionarioAziendaBean
   * 
   * @return risposta alla terza domanda relativa all'ente ospitante 
   */
  public int getEo3() {
    return eo3;
  }

  /**
   * Setta la risposta alla terza domanda relativa all'ente ospitante di QuestionarioAziendaBean
   * 
   * Pre: eo3 > 0 && eo3 < 6
   * @param eo3 nuova risposta alla terza domanda relativa all'ente ospitante 
   */
  public void setEo3(int eo3) {
    this.eo3 = eo3;
  }

  /**
   * Restituisce la risposta alla quarta domanda relativa all'ente ospitante di QuestionarioAziendaBean
   * 
   * @return risposta alla quarta domanda relativa all'ente ospitante 
   */
  public int getEo4() {
    return eo4;
  }

  /**
   * Setta la risposta alla quarta domanda relativa all'ente ospitante di QuestionarioAziendaBean
   * 
   * Pre: eo4 > 0 && eo4 < 6
   * @param eo4 nuova risposta alla quarta domanda relativa all'ente ospitante 
   */
  public void setEo4(int eo4) {
    this.eo4 = eo4;
  }

  /**
   * Restituisce la risposta alla quinta domanda relativa all'ente ospitante di QuestionarioAziendaBean
   * 
   * @return risposta alla quinta domanda relativa all'ente ospitante 
   */
  public int getEo5() {
    return eo5;
  }

  /**
   * Setta la risposta alla quinta domanda relativa all'ente ospitante di QuestionarioAziendaBean
   * 
   * Pre: eo5 > 0 && eo5 < 6
   * @param eo5 nuova risposta alla quinta domanda relativa all'ente ospitante 
   */
  public void setEo5(int eo5) {
    this.eo5 = eo5;
  }

  /**
   * Restituisce la risposta alla prima domanda relativa alle strutture universitarie adette alla gestione dei tirocini di QuestionarioAziendaBean
   * 
   * @return risposta alla prima domanda relativa alle strutture universitarie adette alla gestione dei tirocini
   */
  public int getSu1() {
    return su1;
  }

  /**
   * Setta la risposta alla prima domanda relativa alle strutture universitarie adette alla gestione dei tirocini di QuestionarioAziendaBean
   * 
   * Pre: su1 > 0 && su1 < 6
   * @param su1 nuova risposta alla prima domanda relativa alle strutture universitarie adette alla gestione dei tirocini 
   */
  public void setSu1(int su1) {
    this.su1 = su1;
  }

  /**
   * Restituisce la risposta alla seconda domanda relativa alle strutture universitarie adette alla gestione dei tirocini di QuestionarioAziendaBean
   * 
   * @return risposta alla seconda domanda relativa alle strutture universitarie adette alla gestione dei tirocini
   */
  public int getSu2() {
    return su2;
  }

  /**
   * Setta la risposta alla seconda domanda relativa alle strutture universitarie adette alla gestione dei tirocini di QuestionarioAziendaBean
   * 
   * Pre: su2 > 0 && su2 < 6
   * @param su2 nuova rispsota alla seconda domanda relativa alle strutture universitarie adette alla gestione dei tirocini 
   */
  public void setSu2(int su2) {
    this.su2 = su2;
  }

  /**
   * Restituisce la risposta alla terza domanda relativa alle strutture universitarie adette alla gestione dei tirocini di QuestionarioAziendaBean
   * 
   * @return risposta alla terza domanda relativa alle strutture universitarie adette alla gestione dei tirocini
   */
  public int getSu3() {
    return su3;
  }

  /**
   * Setta la risposta alla terza domanda relativa alle strutture universitarie adette alla gestione dei tirocini di QuestionarioAziendaBean
   * 
   * Pre: su3 > 0 && su3 < 6
   * @param su3 nuova rispsota alla terza domanda relativa alle strutture universitarie adette alla gestione dei tirocini 
   */
  public void setSu3(int su3) {
    this.su3 = su3;
  }

}