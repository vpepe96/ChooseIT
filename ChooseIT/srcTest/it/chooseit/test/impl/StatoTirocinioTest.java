package it.chooseit.test.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.StatoTirocinioBean;
import it.chooseit.impl.RegistroTirocinio;
import it.chooseit.impl.StatoTirocinio;

class StatoTirocinioTest {
	
	private static StatoTirocinio classUnderTest;
	private static RegistroTirocinio classSupportRegistro;
	
	/**
	 * Setta classUnderTest e bean prima del testRetrieveByKey
	 * @throws Exception
	 */
	@BeforeAll
	static void setUp() throws Exception {
		classUnderTest = new StatoTirocinio();
		classSupportRegistro = new RegistroTirocinio();
		
		assertNotNull(classUnderTest);
		assertNotNull(classSupportRegistro);
	}

	/**
	 * Test del metodo retrieveAll con parametro order
	 * @throws Exception
	 */
	@Test
	void testRetrieveAllConOrder() throws SQLException {
		System.out.println("retrieveAll | input --> order");
		ArrayList<StatoTirocinioBean> list = (ArrayList<StatoTirocinioBean>) classUnderTest.retrieveAll("data_stato");
		assertNotNull(list);
	}
	/**
	 * Test del metodo retrieveAll senza parametro order
	 * @throws Exception
	 */
	@Test
	void testRetrieveAllSenzaOrder() throws Exception {
		System.out.println("retrieveAll | input --> null");
		ArrayList<StatoTirocinioBean> list = (ArrayList<StatoTirocinioBean>) classUnderTest.retrieveAll(null);
		assertNotNull(list);
	}
	
	/**
	 * Test del metodo insert inserendo un nuovo stato tirocinio ad un registro
	 * @throws Exception
	 */
	@Test
	void testInsert() throws Exception {
		System.out.println("insert");
		RegistroTirocinioBean registro = classSupportRegistro.retrieveByKey(1);
		
		StatoTirocinioBean stato = new StatoTirocinioBean(registro, new Date(System.currentTimeMillis()), StatoTirocinioBean.StatoTirocinio.ANNULLATO);
		
		boolean insertOk = false; 
		try {
			classUnderTest.insert(stato);
			insertOk = true;
		}catch(SQLException e) {
			insertOk = false;
			e.printStackTrace();
		}
		
		assertTrue(insertOk);
		classUnderTest.delete(stato);
	}

	/**
	 * Test del metodo delete eliminando uno stato tirocinio presente nel DB
	 */
	@Test
	void testDelete() throws Exception {
		RegistroTirocinioBean registro = classSupportRegistro.retrieveByKey(1);

		StatoTirocinioBean stato = new StatoTirocinioBean(registro, new Date(System.currentTimeMillis()), StatoTirocinioBean.StatoTirocinio.ANNULLATO);

		try {
			classUnderTest.insert(stato);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		boolean deleteOk = false; 
		try {
			classUnderTest.delete(stato);
			deleteOk = true;
		}catch(SQLException e) {
			deleteOk = false;
			e.printStackTrace();
		}

		assertTrue(deleteOk);
	}

	/**
	 * Test del metodo getStatoTirocinio
	 * @throws Exception
	 */
	@Test
	void testGetStatoTirocinio() throws Exception {
		System.out.println("getStatoTirocinio | input --> statoTirocinio non presente in DB");
		
		RegistroTirocinioBean registro = classSupportRegistro.retrieveByKey(1);
		
		StatoTirocinioBean stato = classUnderTest.getStatoTirocinio(registro);

		assertEquals(stato.getTipo().toString().toLowerCase(), "terminato");
	}

	/**
	 * Test delmetodo getStatiTirocinio
	 * @throws SQLException
	 */
	@Test
	void testGetStatiTirocinio() throws SQLException {
		System.out.println("getStatoTirocinio | input --> statoTirocinio non presente in DB");
		
		RegistroTirocinioBean registro = classSupportRegistro.retrieveByKey(1);
		Collection<StatoTirocinioBean> stati = classUnderTest.getStatiTirocinio(registro);
	
		assertEquals(2, stati.size());
	}
	
}
