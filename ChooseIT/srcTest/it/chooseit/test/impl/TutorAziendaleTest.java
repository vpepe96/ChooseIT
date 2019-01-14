package it.chooseit.test.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.chooseit.bean.AziendaBean;
import it.chooseit.bean.TutorAziendaleBean;
import it.chooseit.bean.UtenteBean;
import it.chooseit.impl.TutorAziendale;
import it.chooseit.impl.Utente;

class TutorAziendaleTest {

	private static TutorAziendale classUnderTest;
	private static TutorAziendaleBean bean;
	private static String email;
	
	/**
	 * Setta classUnderTest e bean prima del testRetrieveByKey.
	 * @throws Exception
	 */
	@BeforeAll
	static void setUp() throws Exception {
		classUnderTest = new TutorAziendale();
		email = "vnovo@gmail.com";
		
		assertNotNull(classUnderTest);
	}

	/**
	 * Testa il metodo retrieveByKey con un utente di tipo tutorAziendale presente nel db.
	 */
	@Test
	void testRetrieveByKeyTutorAziendaleInDB() throws Exception{
		System.out.println("retrieveByKey");
		bean = classUnderTest.retrieveByKey(email);
		assertNotNull(bean);
		assertEquals(email, bean.getEmail());
	}

	/**
	 * Testa il metodo retrieveByKey con un utente di tipo tutorAziendale non presente nel db.
	 * @throws Exception
	 */
	@Test
	void testRetrieveByKeyTutorAziendaleNonInDB() throws Exception{
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
		ArrayList<TutorAziendaleBean> list = (ArrayList<TutorAziendaleBean>) classUnderTest.retrieveAll(null);
		assertNotNull(list);
	}

	/**
	 * Test del metodo retrieveAll con order.
	 * @throws SQLException 
	 */
	@Test
	void testRetrieveAllConOrder() throws SQLException {
		System.out.println("retrieveAll");
		ArrayList<TutorAziendaleBean> list = (ArrayList<TutorAziendaleBean>) classUnderTest.retrieveAll("email");
		assertNotNull(list);
	}

	/**
	 * Test del metodo insert con un utente tutorAziendale non presente nel db.
	 * @throws Exception
	 */
	@Test
	void testInsertTutorAziendaleNonInDB() throws Exception{
		System.out.println("insert");
		bean = new TutorAziendaleBean();
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
		AziendaBean azienda = new AziendaBean();
		azienda.setRagioneSociale("ITD Solutions");
		bean.setAzienda(azienda);
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
	 * Test del metodo insert con un utente tutorAziendale già presente nel db.
	 * @throws SQLException 
	 */
	@Test
	void testInsertTutorAziendaleGiaInDB() throws SQLException{
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
	 * Test del metodo insert con dati sull'utente tutorAziendale non completi.
	 */
	@Test
	void testInsertTutorAziendaleNonCompleto(){
		System.out.println("insert");
		bean = new TutorAziendaleBean();
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
		bean.setTelefono("3365842552");
		AziendaBean azienda = new AziendaBean();
		bean.setAzienda(azienda);
		//manca azienda ragione sociale
		boolean exc = false;
		try {
			classUnderTest.insert(bean,"password");
		} catch (SQLException e) {
			exc = true;
		}
		assertTrue(exc);
	}

	/**
	 * Test del metodo update con utente tutorAziendale nel db e dati completi.
	 * @throws Exception
	 */
	@Test
	void testUpdateTutorAziendaleInDB() throws Exception{
		System.out.println("update");
		bean = classUnderTest.retrieveByKey(email);
		bean.setNome("Marco");
		classUnderTest.update(bean);
		bean = classUnderTest.retrieveByKey(email);
		assertEquals("Marco", bean.getNome());
	}

	
	/**
	 * Test del metodo update con utente tutorAziendale nel db e dati non completi.
	 */
	@Test
	void testUpdateTutorAziendaleInDBNonCompleto(){
		System.out.println("update");
		bean = new TutorAziendaleBean();
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
	 * Test del metodo delete con un utente tutorAziendale presente nel db.
	 * @throws SQLException 
	 */
	@Test
	void testDeleteTutorAziendaleInDB() throws SQLException {
		System.out.println("delete");
		bean = new TutorAziendaleBean();
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
		AziendaBean azienda = new AziendaBean();
		azienda.setRagioneSociale("ITD Solutions");
		bean.setAzienda(azienda);
		classUnderTest.insert(bean,"pwd");
		boolean deleted = classUnderTest.delete(bean.getEmail());
		assertTrue(deleted);
	}

	
	
	/**
	 * Test del metodo delete con un utente tutorAziendale non presente nel db.
	 * @throws SQLException 
	 */
	@Test
	void testDeleteUtenteNonInDB() throws SQLException {
		System.out.println("delete");
		bean = new TutorAziendaleBean();
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
	 * Testa il metodo getTutorDiAzienda con un'azienda presente nel db 
	 * e con almeno un tutor aziendale associato.
	 * @throws SQLException
	 */
	@Test
	void testGetTutorDiAziendaInDB() throws SQLException {
		System.out.println("getTutorDiAzienda");
		AziendaBean azienda = new AziendaBean();
		azienda.setRagioneSociale("ITD Solutions");
		ArrayList<TutorAziendaleBean> list = (ArrayList<TutorAziendaleBean>) classUnderTest.getTutorDiAzienda(azienda);
		assertNotNull(list);
	}
	
	/**
	 * Testa il metodo getTutorDiAzienda con un'azienda non presente nel db.
	 * @throws SQLException
	 */
	void testGetTutorDiAziendaNonInDB() throws SQLException {
		System.out.println("getTutorDiAzienda");
		AziendaBean azienda = new AziendaBean();
		azienda.setRagioneSociale("Nome a caso");
		ArrayList<TutorAziendaleBean> list = (ArrayList<TutorAziendaleBean>) classUnderTest.getTutorDiAzienda(azienda);
		assertNull(list);
	}

}
