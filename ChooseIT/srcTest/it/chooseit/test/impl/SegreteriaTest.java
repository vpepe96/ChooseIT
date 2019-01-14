package it.chooseit.test.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.chooseit.bean.SegreteriaBean;
import it.chooseit.bean.UtenteBean;
import it.chooseit.impl.Segreteria;
import it.chooseit.impl.Utente;

class SegreteriaTest {

	private static Segreteria classUnderTest;
	private static SegreteriaBean bean;
	private static String email;
	
	/**
	 * Setta classUnderTest e bean prima del testRetrieveByKey.
	 * @throws Exception
	 */
	@BeforeAll
	static void setUp() throws Exception {
		classUnderTest = new Segreteria();
		email = "rgiordano.di@unisa.it";
		
		assertNotNull(classUnderTest);
	}

	/**
	 * Testa il metodo retrieveByKey con un utente di tipo segreteria presente nel db.
	 */
	@Test
	void testRetrieveByKeySegreteriaInDB() throws Exception{
		System.out.println("retrieveByKey");
		bean = classUnderTest.retrieveByKey(email);
		assertNotNull(bean);
		assertEquals(email, bean.getEmail());
	}
	
	
	/**
	 * Testa il metodo retrieveByKey con un utente di tipo segreteria non presente nel db.
	 * @throws Exception
	 */
	@Test
	void testRetrieveByKeySegreteriaNonInDB() throws Exception{
		System.out.println("retriveByKey");
		bean = classUnderTest.retrieveByKey("email@mail.com");
		assertNull(bean);
	}

	/**
	 * Test del metodo retrieveAll senza order.
	 * @throws SQLException 
	 */
	@Test
	void testRetrieveAllSenzaOrder() throws SQLException {
		System.out.println("retrieveAll");
		ArrayList<SegreteriaBean> list = (ArrayList<SegreteriaBean>) classUnderTest.retrieveAll(null);
		assertNotNull(list);
	}

	/**
	 * Test del metodo retrieveAll con order.
	 * @throws SQLException 
	 */
	@Test
	void testRetrieveAllConOrder() throws SQLException {
		System.out.println("retrieveAll");
		ArrayList<SegreteriaBean> list = (ArrayList<SegreteriaBean>) classUnderTest.retrieveAll("nome");
		assertNotNull(list);
	}

	/**
	 * Test del metodo update con utente segreteria nel db e dati completi.
	 * @throws Exception
	 */
	@Test
	void testUpdateUtenteInDB() throws Exception{
		System.out.println("update");
		bean = classUnderTest.retrieveByKey(email);
		bean.setNome("Marco");
		classUnderTest.update(bean);
		bean = classUnderTest.retrieveByKey(email);
		assertEquals("Marco", bean.getNome());
	}

	
	/**
	 * Test del metodo update con utente segreteria nel db e dati non completi.
	 */
	@Test
	void testUpdateUtenteInDBNonCompleto(){
		System.out.println("update");
		bean = new SegreteriaBean();
		bean.setNome("Marco");
		bean.setEmail(email);
		boolean exc = false;
		try {
			classUnderTest.update(bean);
		} catch (SQLException e) {
			exc = true;
		}
		assertTrue(exc);
	}

	/**
	 * Test del metodo delete con un utente segreteria presente nel db.
	 * @throws SQLException 
	 */
	@Test
	void testDeleteUtenteInDB() throws SQLException {
		System.out.println("delete");
		bean = new SegreteriaBean();
		bean.setNome("Marco");
		bean.setEmail("prova@mail.com");
		bean.setCognome("Prova");
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
		java.sql.Date sqlDate = null;
		try {
			java.util.Date utilDate = format.parse("1997-04-16");
			sqlDate = new java.sql.Date(utilDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		bean.setDataNascita(sqlDate);
		bean.setIndirizzo("via Roma 61");
		bean.setTelefono("3362541258");
		classUnderTest.insert(bean,"pwd");
		boolean deleted = classUnderTest.delete(bean.getEmail());
		assertTrue(deleted);
	}

	
	
	/**
	 * Test del metodo delete con un utente segreteria non presente nel db.
	 * @throws SQLException 
	 */
	@Test
	void testDeleteUtenteNonInDB() throws SQLException {
		System.out.println("delete");
		bean = new SegreteriaBean();
		bean.setNome("Marco");
		bean.setEmail("prova@mail.com");
		bean.setCognome("Prova");
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
		java.sql.Date sqlDate = null;
		try {
			java.util.Date utilDate = format.parse("1997-04-16");
			sqlDate = new java.sql.Date(utilDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		bean.setDataNascita(sqlDate);
		bean.setIndirizzo("via Roma 61");
		bean.setTelefono("3362541258");
		boolean deleted = classUnderTest.delete(bean.getEmail());
		assertFalse(deleted);
	}
	
	/**
	 * Test del metodo insert con un utente segreteria non presente nel db.
	 * @throws Exception
	 */
	@Test
	void testInsertSegreteriaNonInDB() throws Exception{
		System.out.println("insert");
		bean = new SegreteriaBean();
		bean.setEmail("marika@gmail.com");
		bean.setNome("Marika");
		bean.setCognome("Cognome");
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
		java.sql.Date sqlDate = null;
		try {
			java.util.Date utilDate = format.parse("1997-04-16");
			sqlDate = new java.sql.Date(utilDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		bean.setDataNascita(sqlDate);
		bean.setIndirizzo("via Scafati 67, 84018 SA");
		bean.setTelefono("3335421658");
		Utente utDao = new Utente();
		classUnderTest.delete(bean.getEmail());
		utDao.delete(bean.getEmail());
		classUnderTest.insert(bean,"password");
		UtenteBean result = classUnderTest.retrieveByKey("marika@gmail.com");
		assertNotNull(result);
		assertEquals("marika@gmail.com", result.getEmail());
		classUnderTest.delete(bean.getEmail());
	}
	
	/**
	 * Test del metodo insert con un utente segreteria già presente nel db.
	 * @throws SQLException 
	 */
	@Test
	void testInsertSegreteriaGiaInDB() throws SQLException{
		System.out.println("insert");
		bean = classUnderTest.retrieveByKey(email);
		boolean exc = false;
		try {
			classUnderTest.insert(bean,"password");
		} catch (SQLException e) {
			exc = true;
		}
		assertTrue(exc);
	}
	
	/**
	 * Test del metodo insert con dati sull'utente segreteria non completi.
	 */
	@Test
	void testInsertStudenteNonCompleto(){
		System.out.println("insert");
		bean = new SegreteriaBean();
		bean.setEmail("marikapia@gmail.com");
		bean.setNome("Marika");
		bean.setCognome("Cognome");
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
		java.sql.Date sqlDate = null;
		try {
			java.util.Date utilDate = format.parse("1997-04-16");
			sqlDate = new java.sql.Date(utilDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		bean.setDataNascita(sqlDate);
		bean.setIndirizzo("via Scafati 67, 84018 SA");
		//manca telefono
		boolean exc = false;
		try {
			classUnderTest.insert(bean,"password");
		} catch (SQLException e) {
			exc = true;
		}
		assertTrue(exc);
	}


}
