package it.chooseit.test.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.chooseit.bean.PresidenteBean;
import it.chooseit.impl.Presidente;

class PresidenteTest {

	private static Presidente classUnderTest;
	private static PresidenteBean bean;
	private static String email;
	
	/**
	 * Setta classUnderTest e bean prima del testRetrieveByKey.
	 * @throws Exception
	 */
	@BeforeAll
	static void setUp() throws Exception {
		classUnderTest = new Presidente();
		
		email = "presidente@unisa.it";
		
		bean = new PresidenteBean();
		bean.setEmail(email);
		bean.setNome("presidente");
		bean.setCognome("presidente");
		bean.setDataNascita(new Date(System.currentTimeMillis()));
		bean.setFotoProfilo("");
		bean.setIndirizzo("via Roma");
		bean.setTelefono("3365124458");
		
		assertNotNull(classUnderTest);
		classUnderTest.insert(bean, "password");
	}
	
	/**
	 * Testa il metodo retrieveByKey con un utente di tipo presidente presente nel db.
	 */
	@Test
	void testRetrieveByKeyPresidenteInDB() throws Exception{
		System.out.println("retrieveByKey");
		PresidenteBean b = classUnderTest.retrieveByKey(email);
		assertNotNull(b);
		assertEquals(email, bean.getEmail());
	}

	/**
	 * Testa il metodo retrieveByKey con un utente di tipo presidente non presente nel db.
	 * @throws Exception
	 */
	@Test
	void testRetrieveByKeyPresidenteNonInDB() throws Exception{
		System.out.println("retriveByKey");
	 PresidenteBean b = classUnderTest.retrieveByKey("email@mail.com");
		assertNull(b);
	}
	
	
	
	/**
	 * Test del metodo retrieveAll senza order.
	 * @throws SQLException 
	 */
	@Test
	void testRetrieveAllSenzaOrder() throws SQLException {
		System.out.println("retrieveAll");
		ArrayList<PresidenteBean> list = (ArrayList<PresidenteBean>) classUnderTest.retrieveAll(null);
		assertNotNull(list);
	}

	/**
	 * Test del metodo retrieveAll con order.
	 * @throws SQLException 
	 */
	@Test
	void testRetrieveAllConOrder() throws SQLException {
		System.out.println("retrieveAll");
		ArrayList<PresidenteBean> list = (ArrayList<PresidenteBean>) classUnderTest.retrieveAll("email");
		assertNotNull(list);
	}

	/**
	 * Test del metodo update con utente presidente nel db e dati completi.
	 * @throws Exception
	 */
	@Test
	void testUpdatePresidenteInDB() throws Exception{
		System.out.println("update");
		
		bean = classUnderTest.retrieveByKey(email);
		bean.setNome("Marco");
		classUnderTest.update(bean);
		bean = classUnderTest.retrieveByKey(email);
		assertEquals("Marco", bean.getNome());
	}
	
	
	/**
	 * Test del metodo delete con un utente presidente presente nel db.
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	@Test
	void testDeletePresidenteInDB() throws SQLException, ParseException {
		System.out.println("delete");
		
		boolean deleted = classUnderTest.delete(bean.getEmail());
		assertTrue(deleted);
		
		classUnderTest.insert(bean, "password");
	}

	
	
	/**
	 * Test del metodo delete con un utente presidente non presente nel db.
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	@Test
	void testDeleteUtenteNonInDB() throws SQLException, ParseException {
		System.out.println("delete");
		
		bean = new PresidenteBean();
		bean.setNome("Marco");
		bean.setEmail("prova@mail.com");
		bean.setCognome("Prova");
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
		java.sql.Date sqlDate = null;
	
		java.util.Date utilDate = format.parse("1997-04-16");
		sqlDate = new java.sql.Date(utilDate.getTime());

		bean.setDataNascita(sqlDate);
		bean.setIndirizzo("via Roma 61");
		bean.setTelefono("3362541258");
		boolean deleted = classUnderTest.delete(bean.getEmail());
		assertFalse(deleted);
	}

	
	/**
	 * Test del metodo insert con un utente presidente non presente nel db.
	 * @throws Exception
	 */
	@Test
	void testInsertPresidenteNonInDB() throws Exception{
		System.out.println("insert");
	
		classUnderTest.delete(email);
		classUnderTest.insert(bean, "password");
		PresidenteBean b = classUnderTest.retrieveByKey(email);
		
		assertNotNull(b);
		assertEquals(email, b.getEmail());
	}
	
	/**
	 * Test del metodo insert con un utente presidente già presente nel db.
	 * @throws SQLException 
	 */
	@Test
	void testInsertPresidenteGiaInDB() throws SQLException{
		System.out.println("insert");
		
		PresidenteBean b = classUnderTest.retrieveByKey(email);
		boolean exc = false;
		try {
			classUnderTest.insert(b,"password");
		} catch (SQLException e) {
			exc = true;
		}
		assertTrue(exc);
	}
	
	/**
	 * Test del metodo insert con dati sull'utente presidente non completi.
	 * @throws Exception 
	 */
	@Test
	void testInsertStudenteNonCompleto() throws Exception{
		System.out.println("insert");
				
		PresidenteBean b = classUnderTest.retrieveByKey(email);
		classUnderTest.delete(email);
		
		b.setTelefono(null);
		
		boolean exc = false;
		try {
			classUnderTest.insert(b,"password");
		} catch (SQLException e) {
			exc = true;
		}
		assertTrue(exc);
		classUnderTest.insert(bean,"password");
	}
	
 @AfterAll
 static void tearDown() throws Exception {
   classUnderTest.delete(email);
 }
 
}
