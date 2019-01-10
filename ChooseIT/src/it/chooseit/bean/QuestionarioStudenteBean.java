package it.chooseit.bean;

import java.io.Serializable;

/**
 * Un oggetto QuestionarioStudenteBean rappresenta un questionario valutativo che viene compilato da un tutor aziendale 
 * in riferimento ad un tirocinante.
 * Un questionario studente ha un collegamento al registro di tirocinio, rappresentato con la variabile d'istanza 
 * registroTirocinio, delle domande relatite al progetto di tirocinio, rappresentate con le variabili d'istanza pdt1, pdt2,
 * pdt3 e pdt4, delle domande relative al tirocinante, rappresentate con le variabili d'istanza t1, t2, t3 e t4, e delle 
 * domande relative alle strutture universitarie addette alla gestione deintirocini, che vengono rappresentate con le 
 * varibilind'istanza su1, su2 e su3.
 *  
 * @author RocketStudios
 */
public class QuestionarioStudenteBean implements Serializable{

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
   * Rappresenta la quarta domanda relativa al progetto di tirocinio del questionario
   */
  private int pdt4;

  /**
   * Rappresenta la prima risposta relativa alla prima domanda sul tirocinante del questionario
   */
  private int t1;

  /**
   * Rappresenta la seconda risposta relativa alla seconda domanda sul tirocinante del questionario
   */
  private int t2;

  /**
   * Rappresenta la terza risposta relativa alla terza domanda sul tirocinante del questionario
   */
  private int t3;

  /**
   * Rappresenta la quarta risposta relativa alla quarta domanda sul tirocinante del questionario
   */
  private int t4;

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
   * Costruttore di QuestionarioStudenteBean
   * 
   * @param registroTirocinio registro di tirocinio associato
   */
  public QuestionarioStudenteBean(RegistroTirocinioBean registroTirocinio) {
    this.registroTirocinio = registroTirocinio;
  }

  /**
   * Costruttore vuoto di QuestionarioStudenteBean.
   */
  public QuestionarioStudenteBean() {}

  /*
    |--------------------------------------------------------------------------
    | Interfaccia pubblica
    |--------------------------------------------------------------------------
   */

  /**
   * Restituisce il registro di tirocinio a cui &egrave; associato QuestionarioStudenteBean
   * 
   * @return registro di tirocinio associato
   */
  public RegistroTirocinioBean getRegistroTirocinio() {
    return registroTirocinio;
  }

  /**
   * Setta un nuovo registro di tirocinio a cui &egrave; associato QuestionarioStudenteBean
   * 
   * Pre: registroTirocinio != null
   * @param registroTirocinio nuovo id del registro di tirocinio associato
   */
  public void setRegistroTirocinio(RegistroTirocinioBean registroTirocinio) {
    this.registroTirocinio = registroTirocinio;
  }

  /**
   * Restituisce la risposta alla prima domanda relativa al progetto di tirocinio di QuestionarioStudenteBean
   * 
   * @return risposta alla prima domanda relativa al progetto di tirocinio 
   */
  public int getPdt1() {
    return pdt1;
  }

  /**
   * Setta la risposta alla prima domanda relativa al progetto di tirocinio di QuestionarioStudenteBean
   * 
   * Pre: pdt1 > 0 && pdt1 < 6
   * @param pdt1 nuova risposta alla prima domanda relativa al progetto di tirocinio 
   */
  public void setPdt1(int pdt1) {
    this.pdt1 = pdt1;
  }

  /**
   * Restituisce la risposta alla seconda domanda relativa al progetto di tirocinio di QuestionarioStudenteBean
   * 
   * @return risposta alla seconda domanda relativa al progetto di tirocinio 
   */
  public int getPdt2() {
    return pdt2;
  }

  /**
   * Setta la risposta alla seconda domanda relativa al progetto di tirocinio di QuestionarioStudenteBean
   * 
   * Pre: pdt2 > 0 && pdt2 < 6
   * @param pdt2 nuova risposta alla seconda domanda relativa al progetto di tirocinio 
   */
  public void setPdt2(int pdt2) {
    this.pdt2 = pdt2;
  }

  /**
   * Restituisce la risposta alla terza domanda relativa al progetto di tirocinio di QuestionarioStudenteBean
   * 
   * @return risposta alla terza domanda relativa al progetto di tirocinio 
   */
  public int getPdt3() {
    return pdt3;
  }

  /**
   * Setta la risposta alla terza domanda relativa al progetto di tirocinio di QuestionarioStudenteBean
   * 
   * Pre: pdt3 > 0 && pdt3 < 6
   * @param pdt3 nuova risposta alla terza domanda relativa al progetto di tirocinio 
   */
  public void setPdt3(int pdt3) {
    this.pdt3 = pdt3;
  }

  /**
   * Restituisce la risposta alla quarta domanda relativa al progetto di tirocinio di QuestionarioStudenteBean
   * 
   * @return risposta alla quarta domanda relativa al progetto di tirocinio 
   */
  public int getPdt4() {
    return pdt4;
  }

  /**
   * Setta la risposta alla quarta domanda relativa al progetto di tirocinio di QuestionarioStudenteBean
   * 
   * Pre: pdt4 > 0 && pdt4 < 6
   * @param pdt4 nuova risposta alla quarta domanda relativa al progetto di tirocinio 
   */
  public void setPdt4(int pdt4) {
    this.pdt4 = pdt4;
  }

  /**
   * Restituisce la risposta alla prima domanda relativa al tirocinante di QuestionarioStudenteBean
   * 
   * @return risposta alla prima domanda relativa al tirocinante 
   */
  public int getT1() {
    return t1;
  }

  /**
   * Setta la risposta alla prima domanda relativa al tirocinante di QuestionarioStudenteBean
   * 
   * Pre: t1 > 0 && t1 < 6
   * @param t1 nuova risposta alla prima domanda relativa al tirocinante 
   */
  public void setT1(int t1) {
    this.t1 = t1;
  }

  /**
   * Restituisce la risposta alla seconda domanda relativa al tirocinante di QuestionarioStudenteBean
   * 
   * @return risposta alla seconda domanda relativa al tirocinante 
   */
  public int getT2() {
    return t2;
  }

  /**
   * Setta la risposta alla seconda domanda relativa al tirocinante di QuestionarioStudenteBean
   * 
   * Pre: t2 > 0 && t2 < 6
   * @param t2 nuova risposta alla seconda domanda relativa al tirocinante 
   */
  public void setT2(int t2) {
    this.t2 = t2;
  }

  /**
   * Restituisce la risposta alla terza domanda relativa al tirocinante di QuestionarioStudenteBean
   * 
   * @return risposta alla terza domanda relativa al tirocinante 
   */
  public int getT3() {
    return t3;
  }

  /**
   * Setta la risposta alla terza domanda relativa al tirocinante di QuestionarioStudenteBean
   * 
   * Pre: t3 > 0 && t3 < 6
   * @param t3 nuova risposta alla terza domanda relativa al tirocinante 
   */
  public void setT3(int t3) {
    this.t3 = t3;
  }

  /**
   * Restituisce la risposta alla quarta domanda relativa al tirocinante di QuestionarioStudenteBean
   * 
   * @return risposta alla quarta domanda relativa al tirocinante 
   */
  public int getT4() {
    return t4;
  }

  /**
   * Setta la risposta alla quarta domanda relativa al tirocinante di QuestionarioStudenteBean
   * 
   * Pre: t4 > 0 && t4 < 6
   * @param t4 nuova risposta alla quarta domanda relativa al tirocinante 
   */
  public void setT4(int t4) {
    this.t4 = t4;
  }

  /**
   * Restituisce la risposta alla prima domanda relativa alle strutture universitarie adette alla gestione dei tirocini di QuestionarioStudenteBean
   * 
   * @return risposta alla prima domanda relativa alle strutture universitarie adette alla gestione dei tirocini
   */
  public int getSu1() {
    return su1;
  }

  /**
   * Setta la risposta alla prima domanda relativa alle strutture universitarie adette alla gestione dei tirocini di QuestionarioStudenteBean
   * 
   * Pre: su1 > 0 && su1 < 6
   * @param su1 nuova risposta alla prima domanda relativa alle strutture universitarie adette alla gestione dei tirocini 
   */
  public void setSu1(int su1) {
    this.su1 = su1;
  }

  /**
   * Restituisce la risposta alla seconda domanda relativa alle strutture universitarie adette alla gestione dei tirocini di QuestionarioStudenteBean
   * 
   * @return risposta alla seconda domanda relativa alle strutture universitarie adette alla gestione dei tirocini
   */
  public int getSu2() {
    return su2;
  }

  /**
   * Setta la risposta alla seconda domanda relativa alle strutture universitarie adette alla gestione dei tirocini di QuestionarioStudenteBean
   * 
   * Pre: su2 > 0 && su2 < 6
   * @param su2 nuova risposta alla seconda domanda relativa alle strutture universitarie adette alla gestione dei tirocini 
   */
  public void setSu2(int su2) {
    this.su2 = su2;
  }

  /**
   * Restituisce la risposta alla terza domanda relativa alle strutture universitarie adette alla gestione dei tirocini di QuestionarioStudenteBean
   * 
   * @return risposta alla terza domanda relativa alle strutture universitarie adette alla gestione dei tirocini
   */
  public int getSu3() {
    return su3;
  }

  /**
   * Setta la risposta alla terza domanda relativa alle strutture universitarie adette alla gestione dei tirocini di QuestionarioStudenteBean
   * 
   * Pre: su3 > 0 && su3 < 6
   * @param su3 nuova risposta alla terza domanda relativa alle strutture universitarie adette alla gestione dei tirocini 
   */
  public void setSu3(int su3) {
    this.su3 = su3;
  }


}