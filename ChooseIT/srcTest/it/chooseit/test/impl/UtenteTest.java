package it.chooseit.test.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.chooseit.bean.UtenteBean;
import it.chooseit.impl.Utente;

class UtenteTest {

	private static Utente classUnderTest;
	private static UtenteBean bean;
	private static String email;
	
	/**
	 * Setta classUnderTest e bean prima del testRetrieveByKey.
	 * @throws Exception
	 */
	@BeforeAll
	static void setUp() throws Exception {
		classUnderTest = new Utente();
		email = "a.bianchi@studenti.unisa.it";
		
		assertNotNull(classUnderTest);
	}

	/**
	 * Testa il metodo retrieveByKey con un utente presente nel db.
	 */
	@Test
	void testRetrieveByKeyUtenteInDB() throws Exception{
		System.out.println("retrieveByKey");
		bean = classUnderTest.retrieveByKey(email);
		assertNotNull(bean);
		assertEquals(email, bean.getEmail());
	}
	
	/**
	 * Testa il metodo retrieveByKey con un utente non presente nel db.
	 * @throws Exception
	 */
	@Test
	void testRetrieveByKeyUtenteNonInDB() throws Exception{
		System.out.println("retriveByKey");
		bean = classUnderTest.retrieveByKey("email@mail.com");
		assertNull(bean);
	}

	/**
	 * Test del metodo checkLogin con un utente presente nel db e pwd corretta.
	 * @throws Exception
	 */
	@Test
	void testCheckLoginUtenteInDBPwdOk() throws Exception{
		System.out.println("checkLogin");
		bean = classUnderTest.checkLogin(email, "bianchi");
		assertNotNull(bean);
		assertEquals(email, bean.getEmail());
	}
	
	/**
	 * Test del metodo checkLogin con un utente presente nel db e pwd errata.
	 * @throws Exception
	 */
	@Test
	void testCheckLoginUtenteInDBPwdNonOk() throws Exception{
		System.out.println("checkLogin");
		bean = classUnderTest.checkLogin(email, "neri");
		assertNull(bean);
	}
	
	/**
	 * Test del metodo checkLogin con un utente non presente nel db.
	 * @throws Exception
	 */
	@Test
	void testCheckLoginUtenteNonInDB() throws Exception{
		System.out.println("checkLogin");
		bean = classUnderTest.checkLogin("prova@mail.com", "bianchi");
		assertNull(bean);
	}
	
	/**
	 * Test del metodo insert con un utente non presente nel db.
	 * @throws Exception
	 */
	@Test
	void testInsertUtenteNonInDB() throws Exception{
		System.out.println("insert");
		bean = new UtenteBean();
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
		classUnderTest.delete(bean.getEmail());
		classUnderTest.insert(bean,"password");
		UtenteBean result = classUnderTest.retrieveByKey("marika@gmail.com");
		assertNotNull(result);
		assertEquals("marika@gmail.com", result.getEmail());
	}

	/**
	 * Test del metodo insert con un utente già presente nel db.
	 */
	@Test
	void testInsertUtenteGiaInDB(){
		System.out.println("insert");
		bean = new UtenteBean();
		bean.setEmail(email);
		bean.setNome("Andrea");
		bean.setCognome("Bianchi");
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
		java.sql.Date sqlDate = null;
		try {
			java.util.Date utilDate = format.parse("1997-04-16");
			sqlDate = new java.sql.Date(utilDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		bean.setDataNascita(sqlDate);
		bean.setIndirizzo("via Roma 67");
		bean.setTelefono("3335421658");
		boolean exc = false;
		try {
			classUnderTest.insert(bean,"password");
		} catch (SQLException e) {
			exc = true;
		}
		assertTrue(exc);
	}
	
	/**
	 * Test del metodo insert con dati sull'utente non completi.
	 */
	@Test
	void testInsertUtenteNonCompleto(){
		System.out.println("insert");
		bean = new UtenteBean();
		bean.setEmail("marikapia@gmail.com");
		bean.setNome("Marika");
		bean.setCognome("Cognome");
		// manca data
		bean.setIndirizzo("via Scafati 67, 84018 SA");
		bean.setTelefono("3335421658");
		boolean exc = false;
		try {
			classUnderTest.insert(bean,"password");
		} catch (SQLException e) {
			exc = true;
		}
		assertTrue(exc);
	}
	
	/**
	 * Test del metodo update con utente nel db e dati completi.
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
	 * Test del metodo update con utente nel db e dati non completi.
	 */
	@Test
	void testUpdateUtenteInDBNonCompleto(){
		System.out.println("update");
		bean = new UtenteBean();
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
	 * Test del metodo delete con un utente presente nel db.
	 * @throws SQLException 
	 */
	@Test
	void testDeleteUtenteInDB() throws SQLException {
		System.out.println("delete");
		bean = new UtenteBean();
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
	 * Test del metodo delete con un utente non presente nel db.
	 * @throws SQLException 
	 */
	@Test
	void testDeleteUtenteNonInDB() throws SQLException {
		System.out.println("delete");
		bean = new UtenteBean();
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
	 * Test del metodo retrieveAll senza order.
	 * @throws SQLException 
	 */
	@Test
	void testRetrieveAllSenzaOrder() throws SQLException {
		System.out.println("retrieveAll");
		ArrayList<UtenteBean> list = (ArrayList<UtenteBean>) classUnderTest.retrieveAll(null);
		assertNotNull(list);
	}

	/**
	 * Test del metodo retrieveAll con order.
	 * @throws SQLException 
	 */
	@Test
	void testRetrieveAllConOrder() throws SQLException {
		System.out.println("retrieveAll");
		ArrayList<UtenteBean> list = (ArrayList<UtenteBean>) classUnderTest.retrieveAll("nome");
		assertNotNull(list);
	}
	
}
