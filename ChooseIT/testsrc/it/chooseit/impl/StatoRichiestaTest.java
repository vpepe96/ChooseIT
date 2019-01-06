package it.chooseit.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.chooseit.bean.AziendaBean;
import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.RichiestaTirocinioBean;
import it.chooseit.bean.StatoRichiestaBean;
import it.chooseit.bean.StudenteBean;

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
		AziendaBean azienda = new AziendaBean();
		RegistroTirocinioBean registro = new RegistroTirocinioBean();
		
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
		java.sql.Date sqlDate = null;
		try {
			java.util.Date utilDate = format.parse("1997-04-16");
			sqlDate = new java.sql.Date(utilDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		richiesta = new RichiestaTirocinioBean(6, studente, sqlDate, azienda, "...", registro, null, null, null);
		classSupport.insert(richiesta);
		
		StatoRichiestaBean.StatoRichiesta tipo = StatoRichiestaBean.StatoRichiesta.NUOVA;
		
		statoRichiesta.setTipo(tipo);
		statoRichiesta.setRichiestaId(richiesta);
		statoRichiesta.setDataStato(sqlDate);

		classUnderTest.insert(statoRichiesta);
		
		assertEquals(statoRichiesta, richiesta.getStatoRichiesta(tipo));
	}

	/**
	 * Test del metodo delete su uno stato presente nel DB.
	 */
	@Test
	void testDelete() throws Exception, ParseException{
		statoRichiesta = new StatoRichiestaBean();
		
		richiesta = new RichiestaTirocinioBean();
		richiesta.setId(6);
		
		StudenteBean studente = new StudenteBean();
		richiesta.setStudente(studente);
		AziendaBean azienda = new AziendaBean();
		richiesta.setAzienda(azienda);
		richiesta.setTutorAziendale(null);
		richiesta.setTutorUniversitario(null);
		richiesta.setProgettoFormativo("..");
		richiesta.setDataRichiesta(new Date(System.currentTimeMillis()));
		RegistroTirocinioBean registro = new RegistroTirocinioBean();
		richiesta.setRegistroTirocinio(registro);
		richiesta.setStatiRichiesta(null);
		
		classSupport.insert(richiesta);
	
		boolean ok = classUnderTest.delete(statoRichiesta);
		assertEquals(true, ok);
		
		classSupport.delete(6);
	}
	

	/**
	 * Test del metodo getStatoRichiesta
	 */
	@Test
	void testGetStatoRichiesta() throws Exception {
		statoRichiesta = new StatoRichiestaBean();
		
		richiesta = new RichiestaTirocinioBean();
		richiesta.setId(6);
		
		StudenteBean studente = new StudenteBean();
		richiesta.setStudente(studente);
		AziendaBean azienda = new AziendaBean();
		richiesta.setAzienda(azienda);
		richiesta.setTutorAziendale(null);
		richiesta.setTutorUniversitario(null);
		richiesta.setProgettoFormativo("..");
		richiesta.setDataRichiesta(new Date(System.currentTimeMillis()));
		RegistroTirocinioBean registro = new RegistroTirocinioBean();
		richiesta.setRegistroTirocinio(registro);
		richiesta.setStatiRichiesta(null);
		
		classSupport.insert(richiesta);
	
		assertEquals(statoRichiesta, classUnderTest.getStatoRichiesta(richiesta));
		classSupport.delete(6);
	}

	/**
	 * Test del metodo getStatiRichiesta
	 */
	@Test
	void testGetStatiRichiesta() throws Exception {
		statoRichiesta = new StatoRichiestaBean();
		
		richiesta = new RichiestaTirocinioBean();
		richiesta.setId(6);
		
		StudenteBean studente = new StudenteBean();
		richiesta.setStudente(studente);
		AziendaBean azienda = new AziendaBean();
		richiesta.setAzienda(azienda);
		richiesta.setTutorAziendale(null);
		richiesta.setTutorUniversitario(null);
		richiesta.setProgettoFormativo("..");
		richiesta.setDataRichiesta(new Date(System.currentTimeMillis()));
		RegistroTirocinioBean registro = new RegistroTirocinioBean();
		richiesta.setRegistroTirocinio(registro);
		richiesta.setStatoRichiesta(new Date(System.currentTimeMillis()), statoRichiesta);
		
		classSupport.insert(richiesta);
		
		ArrayList<StatoRichiestaBean> list = (ArrayList<StatoRichiestaBean>) classUnderTest.getStatiRichiesta(richiesta);
	
		assertEquals(1,list.size());
		
		classSupport.delete(6);
	}

}
