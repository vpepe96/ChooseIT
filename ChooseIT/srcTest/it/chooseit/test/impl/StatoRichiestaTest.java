package it.chooseit.test.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.chooseit.bean.AziendaBean;
import it.chooseit.bean.RichiestaTirocinioBean;
import it.chooseit.bean.StatoRichiestaBean;
import it.chooseit.bean.StudenteBean;
import it.chooseit.impl.RichiestaTirocinio;
import it.chooseit.impl.StatoRichiesta;

class StatoRichiestaTest {
	
	private static StatoRichiesta classUnderTest;
	private static RichiestaTirocinio classSupport;
	private static StatoRichiestaBean statoRichiesta;
	private static RichiestaTirocinioBean richiesta;

	/**
	 * Setta classUnderTest e bean prima del testRetrieveByKey
	 * @throws Exception
	 */
	@BeforeAll
	static void setUp() throws Exception { 
		classUnderTest = new StatoRichiesta();
		classSupport = new RichiestaTirocinio();
		assertNotNull(classUnderTest);
	}

	/**
	 * Test del metodo retrieveAll con parametro order
	 * @throws Exception
	 */
	@Test
	void testRetrieveAllConOrder() throws Exception{
		System.out.println("retrieveAll | input --> order");
		ArrayList<StatoRichiestaBean> list = (ArrayList<StatoRichiestaBean>) classUnderTest.retrieveAll("data_stato");
		assertNotNull(list);
	}
	
	/**
	 * Test del metodo retrieveAll senza parametro order
	 * @throws Exception
	 */
	@Test
	void testRetrieveAllSenzaOrder() throws Exception{
		System.out.println("retrieveAll | input --> null");
		ArrayList<StatoRichiestaBean> list = (ArrayList<StatoRichiestaBean>) classUnderTest.retrieveAll(null);
		assertNotNull(list);
	}
	
	/**
	 * Test del metodo insert inserendo uno stato richiesta relativo ad una richiesta
	 * @throws Exception
	 */
	@Test
	void testInsert() throws Exception{
		System.out.println("insert | input --> statoRichiesta non presente in DB");
		statoRichiesta = new StatoRichiestaBean();
		
		//creazione di una nuova richiesta di tirocinio
		StudenteBean studente = new StudenteBean();
		studente.setEmail("a.bianchi@studenti.unisa.it");
		AziendaBean azienda = new AziendaBean();
		azienda.setRagioneSociale("Allinit");
		
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
		java.sql.Date sqlDate = null;
		try {
			java.util.Date utilDate = format.parse("1997-04-16");
			sqlDate = new java.sql.Date(utilDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		richiesta = new RichiestaTirocinioBean();
		richiesta.setStudente(studente);
		richiesta.setAzienda(azienda);
		richiesta.setDataRichiesta(sqlDate);
		richiesta.setProgettoFormativo("");
		classSupport.insert(richiesta);

  ArrayList<RichiestaTirocinioBean> list = (ArrayList<RichiestaTirocinioBean>) classSupport.retrieveAll("id");
  int id = 0;
  for (RichiestaTirocinioBean richiestaTirocinioBean : list) {
    id = richiestaTirocinioBean.getId();
  }
  richiesta.setId(id);
		
		StatoRichiestaBean.StatoRichiesta tipo = StatoRichiestaBean.StatoRichiesta.NUOVA;
		
		statoRichiesta.setTipo(tipo);
		statoRichiesta.setRichiestaId(richiesta);
		statoRichiesta.setDataStato(sqlDate);

		classUnderTest.insert(statoRichiesta);
		
		classUnderTest.delete(statoRichiesta);

		
		classSupport.delete(richiesta.getId());
	}

	/**
	 * Test del metodo delete su uno stato presente nel DB.
	 */
	@Test
	void testDelete() throws Exception, ParseException{
	  statoRichiesta = new StatoRichiestaBean();
	  
	  //creazione di una nuova richiesta di tirocinio
	  StudenteBean studente = new StudenteBean();
	  studente.setEmail("a.bianchi@studenti.unisa.it");
	  AziendaBean azienda = new AziendaBean();
	  azienda.setRagioneSociale("Allinit");
	  
	  SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
	  java.sql.Date sqlDate = null;
	  try {
	   java.util.Date utilDate = format.parse("1997-04-16");
	   sqlDate = new java.sql.Date(utilDate.getTime());
	  } catch (ParseException e) {
	   e.printStackTrace();
	  }

	  richiesta = new RichiestaTirocinioBean();
	  richiesta.setStudente(studente);
	  richiesta.setAzienda(azienda);
	  richiesta.setDataRichiesta(sqlDate);
	  richiesta.setProgettoFormativo("");
	  classSupport.insert(richiesta);
	  
	  ArrayList<RichiestaTirocinioBean> list = (ArrayList<RichiestaTirocinioBean>) classSupport.retrieveAll("id");
	  int id = 0;
	  for (RichiestaTirocinioBean richiestaTirocinioBean : list) {
	    id = richiestaTirocinioBean.getId();
	  }
	  richiesta.setId(id);
	  
	  StatoRichiestaBean.StatoRichiesta tipo = StatoRichiestaBean.StatoRichiesta.NUOVA;
	  
	  statoRichiesta.setTipo(tipo);
	  statoRichiesta.setRichiestaId(richiesta);
	  statoRichiesta.setDataStato(sqlDate);

	  classUnderTest.insert(statoRichiesta);
	  
	  boolean ok = classUnderTest.delete(statoRichiesta);
	  assertTrue(ok);
	  
	  classSupport.delete(richiesta.getId());
	}
	

	/**
	 * Test del metodo getStatoRichiesta
	 */
	@Test
	void testGetStatoRichiesta() throws Exception {
   statoRichiesta = new StatoRichiestaBean();
   
   //creazione di una nuova richiesta di tirocinio
   StudenteBean studente = new StudenteBean();
   studente.setEmail("a.bianchi@studenti.unisa.it");
   AziendaBean azienda = new AziendaBean();
   azienda.setRagioneSociale("Allinit");
   
   SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
   java.sql.Date sqlDate = null;
   try {
    java.util.Date utilDate = format.parse("1997-04-16");
    sqlDate = new java.sql.Date(utilDate.getTime());
   } catch (ParseException e) {
    e.printStackTrace();
   }

   richiesta = new RichiestaTirocinioBean();
   richiesta.setStudente(studente);
   richiesta.setAzienda(azienda);
   richiesta.setDataRichiesta(sqlDate);
   richiesta.setProgettoFormativo("");
   classSupport.insert(richiesta);
   
   ArrayList<RichiestaTirocinioBean> list = (ArrayList<RichiestaTirocinioBean>) classSupport.retrieveAll("id");
   int id = 0;
   for (RichiestaTirocinioBean richiestaTirocinioBean : list) {
     id = richiestaTirocinioBean.getId();
   }
   richiesta.setId(id);
   
   StatoRichiestaBean.StatoRichiesta tipo = StatoRichiestaBean.StatoRichiesta.NUOVA;
   
   statoRichiesta.setTipo(tipo);
   statoRichiesta.setRichiestaId(richiesta);
   statoRichiesta.setDataStato(sqlDate);

   classUnderTest.insert(statoRichiesta);
      
  StatoRichiestaBean stato = classUnderTest.getStatoRichiesta(richiesta);
 
  assertEquals(StatoRichiestaBean.StatoRichiesta.NUOVA,stato.getTipo());
  boolean ok = classUnderTest.delete(statoRichiesta);
  assertTrue(ok);
  classSupport.delete(richiesta.getId());
	}

	/**
	 * Test del metodo getStatiRichiesta
	 */
	@Test
	void testGetStatiRichiesta() throws Exception {
   statoRichiesta = new StatoRichiestaBean();
   
   //creazione di una nuova richiesta di tirocinio
   StudenteBean studente = new StudenteBean();
   studente.setEmail("a.bianchi@studenti.unisa.it");
   AziendaBean azienda = new AziendaBean();
   azienda.setRagioneSociale("Allinit");
   
   SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
   java.sql.Date sqlDate = null;
   try {
    java.util.Date utilDate = format.parse("1997-04-16");
    sqlDate = new java.sql.Date(utilDate.getTime());
   } catch (ParseException e) {
    e.printStackTrace();
   }

   richiesta = new RichiestaTirocinioBean();
   richiesta.setStudente(studente);
   richiesta.setAzienda(azienda);
   richiesta.setDataRichiesta(sqlDate);
   richiesta.setProgettoFormativo("");
   classSupport.insert(richiesta);
   
   ArrayList<RichiestaTirocinioBean> list = (ArrayList<RichiestaTirocinioBean>) classSupport.retrieveAll("id");
   int id = 0;
   for (RichiestaTirocinioBean richiestaTirocinioBean : list) {
     id = richiestaTirocinioBean.getId();
   }
   richiesta.setId(id);
   
   StatoRichiestaBean.StatoRichiesta tipo = StatoRichiestaBean.StatoRichiesta.NUOVA;
   
   statoRichiesta.setTipo(tipo);
   statoRichiesta.setRichiestaId(richiesta);
   statoRichiesta.setDataStato(sqlDate);

   classUnderTest.insert(statoRichiesta);
   
		ArrayList<StatoRichiestaBean> stati = (ArrayList<StatoRichiestaBean>) classUnderTest.getStatiRichiesta(richiesta);
	
		assertEquals(1,stati.size());
		boolean ok = classUnderTest.delete(statoRichiesta);
  assertTrue(ok);
		classSupport.delete(richiesta.getId());
	}

}
