package it.chooseit.test.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.chooseit.bean.AziendaBean;
import it.chooseit.bean.RichiestaTirocinioBean;
import it.chooseit.bean.StatoRichiestaBean.StatoRichiesta;
import it.chooseit.bean.StudenteBean;
import it.chooseit.bean.TutorAziendaleBean;
import it.chooseit.bean.TutorUniversitarioBean;
import it.chooseit.impl.RichiestaTirocinio;
import it.chooseit.services.ConvertEnum;

class RichiestaTirocinioTest {

	private static RichiestaTirocinio classUnderTest;
	private static Integer key;
	private static RichiestaTirocinioBean bean;
	
	@BeforeAll
	static void setUp() throws Exception {
		classUnderTest = new RichiestaTirocinio();
		key = 5;
	}

	/**
	 * Testa il metodo retrieveByKey con una richiesta presente in db.
	 * @throws SQLException
	 */
	@Test
	void testRetrieveByKey() throws SQLException {
		System.out.println("retrieveByKey");
		bean = classUnderTest.retrieveByKey(key);
		assertEquals(5, bean.getId());
	}

	
	/**
	 * Testa il metodo retrieveAll con order null con almeno una richiesta nel db.
	 * @throws SQLException 
	 */
	@Test
	synchronized void testRetrieveAllSenzaOrder() throws SQLException {
		System.out.println("retrieveAll");
		
		bean = new RichiestaTirocinioBean();
		StudenteBean studente = new StudenteBean();
		studente.setEmail("a.bianchi@studenti.unisa.it");
		bean.setStudente(studente);
		AziendaBean azienda = new AziendaBean();
		azienda.setRagioneSociale("Allinit");
		bean.setAzienda(azienda);
		bean.setProgettoFormativo("");
		bean.setDataRichiesta(new Date(System.currentTimeMillis()));
		classUnderTest.insert(bean);
		
		ArrayList<RichiestaTirocinioBean> list = (ArrayList<RichiestaTirocinioBean>) classUnderTest.retrieveAll("id");
		assertNotEquals(0, list.size());
		
		Integer id = 0;
		for (RichiestaTirocinioBean richiestaTirocinioBean : list) {
			id=richiestaTirocinioBean.getId();
		}
		System.out.println(id);
		classUnderTest.delete(id);
	}

	
	/**
	 * Testa il metodo retrieveAll con order con almeno una richiesta nel db.
	 * @throws SQLException 
	 */
	@Test
	void testRetrieveAllConOrder() throws SQLException {
		System.out.println("retrieveAll");
		
		bean = new RichiestaTirocinioBean();
		StudenteBean studente = new StudenteBean();
		studente.setEmail("a.bianchi@studenti.unisa.it");
		bean.setStudente(studente);
		AziendaBean azienda = new AziendaBean();
		azienda.setRagioneSociale("Allinit");
		bean.setAzienda(azienda);
		bean.setProgettoFormativo("");
		bean.setDataRichiesta(new Date(System.currentTimeMillis()));
		classUnderTest.insert(bean);
		
		ArrayList<RichiestaTirocinioBean> list = (ArrayList<RichiestaTirocinioBean>) classUnderTest.retrieveAll("id");
		assertNotEquals(0, list.size());
		
		Integer id = 0;
		for (RichiestaTirocinioBean richiestaTirocinioBean : list) {
			id=richiestaTirocinioBean.getId();
		}
		System.out.println(id);
		classUnderTest.delete(id);
	}
	
	/**
	 * Testa il metodo insert con una nuova richiesta di tirocinio.
	 * @throws SQLException
	 */
	@Test
	synchronized void testInsert() throws SQLException {
		System.out.println("insert");
		
		bean = new RichiestaTirocinioBean();
		StudenteBean studente = new StudenteBean();
		studente.setEmail("a.bianchi@studenti.unisa.it");
		bean.setStudente(studente);
		AziendaBean azienda = new AziendaBean();
		azienda.setRagioneSociale("Allinit");
		bean.setAzienda(azienda);
		bean.setProgettoFormativo("");
		bean.setDataRichiesta(new Date(System.currentTimeMillis()));
		
		boolean ok = false;
		try {
			classUnderTest.insert(bean);
			ok = true;
		} catch (SQLException e) {
			ok = false;
		}
		
		assertTrue(ok);
		
		ArrayList<RichiestaTirocinioBean> list = (ArrayList<RichiestaTirocinioBean>) classUnderTest.retrieveAll("id");
		assertNotEquals(0, list.size());
		
		Integer id = 0;
		for (RichiestaTirocinioBean richiestaTirocinioBean : list) {
			id=richiestaTirocinioBean.getId();
		}
		System.out.println(id);
		classUnderTest.delete(id);
	}

	/**
	 * Testa il metodo update con un registro di tirocinio presente nel db.
	 * @throws SQLException
	 */
	@Test
	synchronized void testUpdate() throws SQLException {
		System.out.println("insert");
		
		bean = new RichiestaTirocinioBean();
		StudenteBean studente = new StudenteBean();
		studente.setEmail("a.bianchi@studenti.unisa.it");
		bean.setStudente(studente);
		AziendaBean azienda = new AziendaBean();
		azienda.setRagioneSociale("Allinit");
		bean.setAzienda(azienda);
		bean.setProgettoFormativo("");
		bean.setDataRichiesta(new Date(System.currentTimeMillis()));
		
		classUnderTest.insert(bean);
		
		ArrayList<RichiestaTirocinioBean> list = (ArrayList<RichiestaTirocinioBean>) classUnderTest.retrieveAll("id");
		assertNotEquals(0, list.size());
		
		Integer id = 0;
		for (RichiestaTirocinioBean richiestaTirocinioBean : list) {
			id=richiestaTirocinioBean.getId();
		}
		System.out.println(id);
		bean.setId(id);
		
		TutorAziendaleBean tutorAz = new TutorAziendaleBean();
		tutorAz.setEmail("vnovo@gmail.com");
		bean.setTutorAziendale(tutorAz);
		
		TutorUniversitarioBean tutorUni = new TutorUniversitarioBean();
		tutorUni.setEmail("luchini@unisa.it");
		bean.setTutorUniversitario(tutorUni);
		
		boolean ok = false;
		try {
			classUnderTest.update(bean);
			ok = true;
		} catch (SQLException e) {
			ok = false;
		}
		
		assertTrue(ok);
		
		classUnderTest.delete(id);
	}

	/**
	 * Testa il metodo delete con una richiesta presente nel db.
	 * @throws SQLException 
	 */
	@Test
	synchronized void testDelete() throws SQLException {
		System.out.println("delete");
		
		bean = new RichiestaTirocinioBean();
		StudenteBean studente = new StudenteBean();
		studente.setEmail("a.bianchi@studenti.unisa.it");
		bean.setStudente(studente);
		AziendaBean azienda = new AziendaBean();
		azienda.setRagioneSociale("Allinit");
		bean.setAzienda(azienda);
		bean.setProgettoFormativo("");
		bean.setDataRichiesta(new Date(System.currentTimeMillis()));
		
		classUnderTest.insert(bean);
		
		ArrayList<RichiestaTirocinioBean> list = (ArrayList<RichiestaTirocinioBean>) classUnderTest.retrieveAll("id");
		assertNotEquals(0, list.size());
		
		Integer id = 0;
		for (RichiestaTirocinioBean richiestaTirocinioBean : list) {
			id=richiestaTirocinioBean.getId();
		}
		System.out.println(id);
		boolean ok = false;
		try {
			classUnderTest.delete(id);
			ok = true;
		} catch (SQLException e) {
			ok = false;
		}
		
		assertTrue(ok);
	}

	/**
	 * Testa il metodo getRichiestePerAzienda con almeno una richista 
	 * per l'azienda nel db.
	 * @throws SQLException
	 */
	@Test
	synchronized void testGetRichiestePerAzienda() throws SQLException {
		System.out.println("insert");
		
		bean = new RichiestaTirocinioBean();
		StudenteBean studente = new StudenteBean();
		studente.setEmail("a.bianchi@studenti.unisa.it");
		bean.setStudente(studente);
		AziendaBean azienda = new AziendaBean();
		azienda.setRagioneSociale("Allinit");
		bean.setAzienda(azienda);
		bean.setProgettoFormativo("");
		bean.setDataRichiesta(new Date(System.currentTimeMillis()));
			
		classUnderTest.insert(bean);
		
		ArrayList<RichiestaTirocinioBean> list = (ArrayList<RichiestaTirocinioBean>) classUnderTest.retrieveAll("id");
		assertNotEquals(0, list.size());
		
		Integer id = 0;
		for (RichiestaTirocinioBean richiestaTirocinioBean : list) {
			id=richiestaTirocinioBean.getId();
		}
		System.out.println(id);
		list = (ArrayList<RichiestaTirocinioBean>) classUnderTest.getRichiestePerAzienda(azienda);
		
		assertNotEquals(0, list.size());
		
		classUnderTest.delete(id);
	}

	
	/**
	 * Testa il metodo getRichiestePerStato con uno stato associato ad 
	 * almeno una richiesta nel db.
	 * @throws SQLException
	 */
	@Test
	synchronized void testGetRichiestePerStato() throws SQLException {
		System.out.println("getRichiestaPerStato");
		
		ConvertEnum conv = new ConvertEnum();
		ArrayList<RichiestaTirocinioBean> list = (ArrayList<RichiestaTirocinioBean>) classUnderTest.getRichiestePerStato(conv.convertStatoRichiestaString(StatoRichiesta.NUOVA));
		
		assertNotEquals(0, list.size());
	}

	/**
	 * Test del metodo getRichiestePerStudente con uno studente che ha almeno 
	 * una richiesta associata.
	 * @throws SQLException
	 */
	@Test
	synchronized void testGetRichiestePerStudente() throws SQLException {
		System.out.println("getRichiestePerStudente");
		
		bean = new RichiestaTirocinioBean();
		StudenteBean studente = new StudenteBean();
		studente.setEmail("a.bianchi@studenti.unisa.it");
		bean.setStudente(studente);
		AziendaBean azienda = new AziendaBean();
		azienda.setRagioneSociale("Allinit");
		bean.setAzienda(azienda);
		bean.setProgettoFormativo("");
		bean.setDataRichiesta(new Date(System.currentTimeMillis()));
		
		classUnderTest.insert(bean);
		
		ArrayList<RichiestaTirocinioBean> list = (ArrayList<RichiestaTirocinioBean>) classUnderTest.retrieveAll("id");
		assertNotEquals(0, list.size());
		
		Integer id = 0;
		for (RichiestaTirocinioBean richiestaTirocinioBean : list) {
			id=richiestaTirocinioBean.getId();
		}
		System.out.println(id);
		
		list = (ArrayList<RichiestaTirocinioBean>) classUnderTest.getRichiestePerStudente(studente);
		
		assertNotEquals(0, list.size());
		
		classUnderTest.delete(id);
	}

}
