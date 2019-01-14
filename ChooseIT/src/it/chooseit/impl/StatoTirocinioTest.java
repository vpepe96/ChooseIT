package it.chooseit.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.StatoTirocinioBean;
import it.chooseit.dao.RegistroTirocinioDAO;
import it.chooseit.dao.StatoTirocinioDAO;

class StatoTirocinioTest {
	
	private static StatoTirocinio classUnderTest;
	
	/**
	 * Setta classUnderTest e bean prima del testRetrieveByKey
	 * @throws Exception
	 */
	@BeforeAll
	static void setUp() throws Exception {
		classUnderTest = new StatoTirocinio();
		
		assertNotNull(classUnderTest);
	}

	/**
	 * Test del metodo retrieveAll con parametro order
	 * @throws Exception
	 */
	@Test
	void testRetrieveAllConOrder() throws SQLException {
		System.out.println("retrieveAll | input --> order");
		try {
		ArrayList<StatoTirocinioBean> list = (ArrayList<StatoTirocinioBean>) classUnderTest.retrieveAll("data_stato");
		assertNotNull(list);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
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
		System.out.println("insert | input --> statoTirocinio non presente in DB");
		
		//Recupero dati di un registro di tirocinio
		RegistroTirocinioDAO registroTirocinioDao = new RegistroTirocinio();
		RegistroTirocinioBean registroTirocinio = registroTirocinioDao.retrieveByKey(1);

		//Carico gli stati relativi al registro di tirocinio 
		StatoTirocinioDAO statoTirocinioDao = new StatoTirocinio();
		StatoTirocinioBean statoTirocinio = new StatoTirocinioBean(registroTirocinio, new Date(System.currentTimeMillis()), StatoTirocinioBean.StatoTirocinio.ANNULLATO);
		statoTirocinioDao.insert(statoTirocinio);
		
		StatoTirocinioBean.StatoTirocinio stato = StatoTirocinioBean.StatoTirocinio.ANNULLATO;
		
		assertEquals(stato.toString().toLowerCase(), statoTirocinioDao.getStatoTirocinio(registroTirocinio).getTipo().toString().toLowerCase());
	}

	/**
	 * Test del metodo delete eliminando uno stato tirocinio presente nel DB
	 */
	@Test
	void testDelete() throws Exception {
		//Recupero dati di un registro di tirocinio
		RegistroTirocinioDAO registroTirocinioDao = new RegistroTirocinio();
		RegistroTirocinioBean registroTirocinio = registroTirocinioDao.retrieveByKey(1);

		//Carico gli stati relativi al registro di tirocinio 
		StatoTirocinioDAO statoTirocinioDao = new StatoTirocinio();
		Collection<StatoTirocinioBean> statiTirocinio = statoTirocinioDao.getStatiTirocinio(registroTirocinio);

		//Prelevo uno stato di tirocinio
		StatoTirocinioBean statoTirocinio = null;
		Iterator<?> it = statiTirocinio.iterator();	
		if(it.hasNext())
			statoTirocinio = (StatoTirocinioBean) it.next();

		boolean ok = classUnderTest.delete(statoTirocinio);
		assertEquals(true, ok);
	}

	/**
	 * Test del metodo getStatoTirocinio
	 * @throws Exception
	 */
	@Test
	void testGetStatoTirocinio() throws Exception {
		//Recupero dati di un registro di tirocinio
		RegistroTirocinioDAO registroTirocinioDao = new RegistroTirocinio();
		RegistroTirocinioBean registroTirocinio = registroTirocinioDao.retrieveByKey(1);
		
		//Carico gli stati relativi al registro di tirocinio 
		StatoTirocinioDAO statoTirocinioDao = new StatoTirocinio();
		Collection<StatoTirocinioBean> statiTirocinio = statoTirocinioDao.getStatiTirocinio(registroTirocinio);
		
		//Dagli stati recuperati ricavo l'ultimo stato
		StatoTirocinioBean lastStatoTirocinio = null;
		Iterator<?> it = statiTirocinio.iterator();	
		while(it.hasNext()) {
			lastStatoTirocinio = (StatoTirocinioBean) it.next();
		}
		
		assertEquals(lastStatoTirocinio.getTipo().toString(), statoTirocinioDao.getStatoTirocinio(registroTirocinio).getTipo().toString());
	}

	/**
	 * Test del metodo getStatiTirocinio
	 * @throws SQLException
	 */
	@Test
	void testGetStatiTirocinio() throws SQLException {
		//Recupero dati di un registro di tirocinio
		RegistroTirocinioDAO registroTirocinioDao = new RegistroTirocinio();
		RegistroTirocinioBean registroTirocinio = registroTirocinioDao.retrieveByKey(3);

		//Carico gli stati relativi al registro di tirocinio 
		StatoTirocinioDAO statoTirocinioDao = new StatoTirocinio();
		Collection<StatoTirocinioBean> statiTirocinio = statoTirocinioDao.getStatiTirocinio(registroTirocinio);

		assertEquals(2,statiTirocinio.size());
	}

}
