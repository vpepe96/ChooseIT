package it.chooseit.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.StudenteBean;
import it.chooseit.bean.TutorAziendaleBean;
import it.chooseit.bean.TutorUniversitarioBean;

class RegistroTirocinioTest {

	private static RegistroTirocinio classUnderTest;
	private static Integer key;
	private static RegistroTirocinioBean bean;
	
	@BeforeAll
	static void setUp() throws Exception {
		classUnderTest = new RegistroTirocinio();
		key = 1;
	}

	/**
	 * Testa il metodo retrieveByKey con un registro presente nel db.
	 * @throws SQLException
	 */
	@Test
	void testRetrieveByKeyRegistroInDB() throws SQLException {
		System.out.println("retrieveByKey");
		bean = classUnderTest.retrieveByKey(key);
		assertNotNull(bean);
		assertEquals(key.intValue(), bean.getIdentificativo());
	}

	/**
	 * Testa il metodo retrieveByKey con un registro non presente nel db.
	 * @throws SQLException
	 */
	@Test
	void testRetrieveByKeyRegistroNonInDB() throws SQLException {
		System.out.println("retrieveByKey");
		bean = classUnderTest.retrieveByKey(100);
		assertNull(bean);
	}

	
	/**
	 * Test del metodo retrieveAll senza order.
	 * @throws SQLException 
	 */
	@Test
	void testRetrieveAllSenzaOrder() throws SQLException {
		System.out.println("retrieveAll");
		ArrayList<RegistroTirocinioBean> list = (ArrayList<RegistroTirocinioBean>) classUnderTest.retrieveAll(null);
		assertNotNull(list);
	}

	/**
	 * Test del metodo retrieveAll con order.
	 * @throws SQLException 
	 */
	@Test
	void testRetrieveAllConOrder() throws SQLException {
		System.out.println("retrieveAll");
		ArrayList<RegistroTirocinioBean> list = (ArrayList<RegistroTirocinioBean>) classUnderTest.retrieveAll("identificativo");
		assertNotNull(list);
	}


	
	/**
	 * Test del metodo update con registro nel db e dati completi.
	 * @throws Exception
	 */
	@Test
	void testUpdateRegistroInDB() throws Exception{
		System.out.println("update");
		bean = classUnderTest.retrieveByKey(key);
		TutorUniversitarioBean tutor = new TutorUniversitarioBean();
		tutor.setEmail("luchini@unisa.it");
		bean.setTutorUniversitario(tutor);
		classUnderTest.update(bean);
		bean = classUnderTest.retrieveByKey(key);
		assertEquals("luchini@unisa.it", bean.getTutorUniversitario().getEmail());
	}

	
	
	/**
	 * Testa il metodo getRegistriDiStudente con uno studente che ha almeno un registro associato
	 * @throws SQLException
	 */
	@Test
	void testGetRegistriDiStudente() throws SQLException {
		System.out.println("getRegistriDiStudente");
		StudenteBean studente = new StudenteBean();
		studente.setEmail("a.bianchi@studenti.unisa.it");
		ArrayList<RegistroTirocinioBean> list = (ArrayList<RegistroTirocinioBean>) classUnderTest.getRegistriDiStudente(studente);
		assertNotNull(list);
	}

	/**
	 * Testa il metodo getRegistriDiTutorAziendale con un tutor aziendale
	 * che ha almeno un registro assegnato.
	 * @throws SQLException
	 */
	@Test
	void testGetRegistriDiTutorAziendale() throws SQLException {
		System.out.println("getRegistriDiTutorAziendale");
		TutorAziendaleBean tutor = new TutorAziendaleBean();
		tutor.setEmail("vnovo@gmail.com");
		ArrayList<RegistroTirocinioBean> list = (ArrayList<RegistroTirocinioBean>) classUnderTest.getRegistriDiTutorAziendale(tutor);
		assertNotNull(list);
	}

	
	/**
	 * Testa il metodo getRegistriDiTutorUniversitario con un tutor universitario
	 * che ha almeno un registro associato.
	 * @throws  SQLException
	 */
	@Test
	void testGetRegistriDiTutorUniversitario() throws  SQLException{
		System.out.println("getRegistriDiTutorAziendale");
		TutorUniversitarioBean tutor = new TutorUniversitarioBean();
		tutor.setEmail("luchini@unisa.it");
		ArrayList<RegistroTirocinioBean> list = (ArrayList<RegistroTirocinioBean>) classUnderTest.getRegistriDiTutorUniversitario(tutor);
		assertNotNull(list);
	}
	
	/**
	 * Test il metodo getRegistriDiTirocinioInCorso con un db che ha 
	 * almeno un registro di tirocinio nello stato 'in corso'
	 * @throws SQLException
	 */
	@Test
	void testGetRegistriDiTirociniInCorso() throws SQLException {
		System.out.println("getRegistriDiTirociniInCorso");
		ArrayList<RegistroTirocinioBean> list = (ArrayList<RegistroTirocinioBean>) classUnderTest.getRegistriDiTirociniInCorso();
		assertNotNull(list);
	}

	
	/**
	 * Testa il metodo getRegistriDiTirocinioInCorso con un db che ha
	 * almeno un registro di tirocinio nello stato 'terminato'
	 * @throws SQLException 
	 */
	@Test
	void testGetRegistriDiTirociniTerminati() throws SQLException {
		System.out.println("getRegistriDiTirociniTerminati");
		ArrayList<RegistroTirocinioBean> list = (ArrayList<RegistroTirocinioBean>) classUnderTest.getRegistriDiTirociniTerminati();
		assertNotNull(list);
	}

}
