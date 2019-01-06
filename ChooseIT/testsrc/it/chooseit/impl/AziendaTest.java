package it.chooseit.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.chooseit.bean.AziendaBean;

class AziendaTest {
	
	private static Azienda classUnderTest;
	private static AziendaBean bean;
	private static String ragioneSociale;
	
	/**
	 * Setta classUnderTest e bean prima del testRetrieveByKey.
	 * @throws Exception
	 */
	@BeforeAll
	static void setUp() throws Exception {
		classUnderTest = new Azienda();
		ragioneSociale = "Allinit";
		
		assertNotNull(classUnderTest, "La classe classUnderTest è null");
	}

	/**
	 * Testa il metodo retrieveByKey con un'azienda presente nel db.
	 * @throws Exception
	 */
	@Test
	void testRetrieveByKeyAziendaInDB() throws Exception{
		System.out.println("retrieveByKey");
		bean = classUnderTest.retrieveByKey(ragioneSociale);
		assertNotNull(bean);
		assertEquals(ragioneSociale, bean.getRagioneSociale());
	}

	/**
	 * Testa il metodo retrieveByKey con un'azienda non presente nel db.
	 * @throws Exception
	 */
	@Test
	void testRetrieveByKeyAziendaNonInDB() throws Exception{
		System.out.println("retriveByKey");
		bean = classUnderTest.retrieveByKey("Allianz");
		assertNull(bean.getRagioneSociale());
	}

	/**
	 * Test del metodo retrieveAll senza order.
	 * @throws SQLException 
	 */
	@Test
	void testRetrieveAllSenzaOrder() throws SQLException {
		System.out.println("retrieveAll");
		ArrayList<AziendaBean> list = (ArrayList<AziendaBean>) classUnderTest.retrieveAll(null);
		assertNotNull(list);
	}

	/**
	 * Test del metodo retrieveAll con order.
	 * @throws SQLException 
	 */
	@Test
	void testRetrieveAllConOrder() throws SQLException {
		System.out.println("retrieveAll");
		ArrayList<AziendaBean> list = (ArrayList<AziendaBean>) classUnderTest.retrieveAll("ragione_sociale");
		assertNotNull(list);
	}

	/**
	 * Test del metodo update con azienda nel db e dati completi.
	 * @throws Exception
	 */
	@Test
	void testUpdateAziendaInDB() throws SQLException{
		System.out.println("update");
		bean = classUnderTest.retrieveByKey(ragioneSociale);
		bean.setSedeLegale("Firenze");
		classUnderTest.update(bean);
		bean = classUnderTest.retrieveByKey(ragioneSociale);
		assertEquals("Firenze", bean.getSedeLegale());
	}
	
	/**
	 * Test del metodo update con azienda nel db e dati non completi.
	 */
	@Test
	void testUpdateAziendaInDBNonCompleto() throws SQLException {
		System.out.println("update");
		bean = new AziendaBean();
		bean.setSedeLegale("Firenze");
		bean.setRagioneSociale(ragioneSociale);
		boolean exc = false;
		try {
			classUnderTest.update(bean);
		} catch (SQLException e) {
			exc = true;
		}
		assertTrue(exc);
	}
	
	/**
	 * Test del metodo delete con un'azienda presente nel db.
	 * @throws SQLException 
	 */
	@Test
	void testDeleteAziendaInDB() throws SQLException {
		System.out.println("delete");
		bean = new AziendaBean();
		bean.setRagioneSociale("Nextsoft");
		bean.setSedeLegale("Firenze");
		bean.setSedeOperativa("Padova");
		bean.setProgettoFormativo(" ");
		classUnderTest.insert(bean);
		boolean deleted = classUnderTest.delete(bean.getRagioneSociale());
		assertTrue(deleted);
	}

	/**
	 * Test del metodo delete con un'azienda non presente nel db.
	 * @throws SQLException 
	 */
	@Test
	void testDeleteAziendaNonInDB() throws SQLException {
		System.out.println("delete");
		bean = new AziendaBean();
		bean.setRagioneSociale("Nextsoft");
		bean.setSedeLegale("Firenze");
		bean.setSedeOperativa("Padova");
		bean.setProgettoFormativo(" ");
		boolean deleted = classUnderTest.delete(bean.getRagioneSociale());
		assertFalse(deleted);
	}

	/**
	 * Test del metodo insert con un'azienda non presente nel db.
	 * @throws Exception
	 */
	@Test
	void testInsertAziendaNonInDB() throws SQLException{
		System.out.println("insert");
		bean = new AziendaBean();
		bean.setRagioneSociale("KeyBiz");
		bean.setSedeLegale("Napoli");
		bean.setSedeOperativa("Salerno");
		bean.setProgettoFormativo("progetto-formativo");
		classUnderTest.insert(bean);
		AziendaBean result = classUnderTest.retrieveByKey("Metoda");
		assertNotNull(result);
		assertEquals("Metoda", result.getRagioneSociale());
	}
	
	/**
	 * Test del metodo insert con un'azienda già presente nel db.
	 * @throws SQLException 
	 */
	@Test
	void testInsertAziendaGiaInDB() throws SQLException{
		System.out.println("insert");
		bean = classUnderTest.retrieveByKey(ragioneSociale);
		boolean exc = false;
		try {
			classUnderTest.insert(bean);
		} catch (SQLException e) {
			exc = true;
		}
		assertTrue(exc);
	}
	
	/**
	 * Test del metodo insert con dati sull'azienda non completi.
	 */
	@Test
	void testInsertAziendaNonCompleto() throws SQLException {
		System.out.println("insert");
		bean = new AziendaBean();
		bean.setRagioneSociale("Metoda");
		bean.setSedeLegale("Napoli");
		bean.setSedeOperativa("Salerno");
		
		//manca il progetto formativo
		
		boolean exc = false;
		try {
			classUnderTest.insert(bean);
		} catch (SQLException e) {
			exc = true;
		}
		assertTrue(exc);
	}

}
