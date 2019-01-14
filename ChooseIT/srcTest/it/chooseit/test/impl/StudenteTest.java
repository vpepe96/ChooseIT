package it.chooseit.test.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.chooseit.bean.AziendaBean;
import it.chooseit.bean.StudenteBean;
import it.chooseit.bean.TutorAziendaleBean;
import it.chooseit.bean.TutorUniversitarioBean;
import it.chooseit.bean.UtenteBean;
import it.chooseit.impl.Studente;
import it.chooseit.impl.Utente;

class StudenteTest {

	
	private static Studente classUnderTest;
	private static StudenteBean bean;
	private static String email;
	private static TutorAziendaleBean tutorAziendale;
	private static TutorUniversitarioBean tutorUniversitario;
	
	/**
	 * Setta classUnderTest e bean prima del testRetrieveByKey.
	 * @throws Exception
	 */
	@BeforeAll
	static void setUp() throws Exception {
		classUnderTest = new Studente();
		email = "a.bianchi@studenti.unisa.it";
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
		java.sql.Date sqlDate = null;
		try {
			java.util.Date utilDate = format.parse("1974-08-11");
			sqlDate = new java.sql.Date(utilDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		tutorAziendale = new TutorAziendaleBean("vnovo@gmail.com", "Valentino","Novo","3267855842","via Dei Tribunali 66",sqlDate,"", new AziendaBean("ITD Solutions", "", "via Galileo Galilei 7, Milano (MI)","via della Maglianella 65, Roma (RM)", null, null), null, null);
		
		try {
			java.util.Date utilDate = format.parse("1974-08-11");
			sqlDate = new java.sql.Date(utilDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		tutorUniversitario = new TutorUniversitarioBean("mpoletto@unisa.it", "Massimo", "Poletto", "3789921234", "via Fisciano 90", sqlDate, "", null);
		assertNotNull(classUnderTest);
	}

	/**
	 * Testa il metodo retrieveByKey con uno studente presente nel db.
	 */
	@Test
	void testRetrieveByKeyStudenteInDB() throws Exception{
		System.out.println("retrieveByKey");
		bean = classUnderTest.retrieveByKey(email);
		assertNotNull(bean);
		assertEquals(email, bean.getEmail());
	}
	
	
	/**
	 * Testa il metodo retrieveByKey con uno studente non presente nel db.
	 * @throws Exception
	 */
	@Test
	void testRetrieveByKeyStudenteNonInDB() throws Exception{
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
		ArrayList<StudenteBean> list = (ArrayList<StudenteBean>) classUnderTest.retrieveAll(null);
		assertNotNull(list);
	}

	/**
	 * Test del metodo retrieveAll con order.
	 * @throws SQLException 
	 */
	@Test
	void testRetrieveAllConOrder() throws SQLException {
		System.out.println("retrieveAll");
		ArrayList<StudenteBean> list = (ArrayList<StudenteBean>) classUnderTest.retrieveAll("email");
		assertNotNull(list);
	}

	/**
	 * Test del metodo insert con uno studente non presente nel db.
	 * @throws Exception
	 */
	@Test
	void testInsertStudenteNonInDB() throws Exception{
		System.out.println("insert");
		bean = new StudenteBean();
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
		bean.setMatricola("0512104539");
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
	 * Test del metodo insert con uno studente già presente nel db.
	 * @throws SQLException 
	 */
	@Test
	void testInsertStudenteGiaInDB() throws SQLException{
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
	 * Test del metodo insert con dati sullo studente non completi.
	 */
	@Test
	void testInsertStudenteNonCompleto(){
		System.out.println("insert");
		bean = new StudenteBean();
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
		bean.setTelefono("3335421658");
		//manca matricola
		boolean exc = false;
		try {
			classUnderTest.insert(bean,"password");
		} catch (SQLException e) {
			exc = true;
		}
		assertTrue(exc);
	}

	
	/**
	 * Test del metodo update con studente nel db e dati completi.
	 * @throws Exception
	 */
	@Test
	void testUpdateStudenteInDB() throws Exception{
		System.out.println("update");
		bean = classUnderTest.retrieveByKey(email);
		bean.setDescrizione("questa è una descrizione");
		classUnderTest.update(bean);
		bean = classUnderTest.retrieveByKey(email);
		assertEquals("questa è una descrizione", bean.getDescrizione());
	}


	/**
	 * Test del metodo delete con un utente presente nel db.
	 * @throws SQLException 
	 */
	@Test
	void testDeleteStudenteInDB() throws SQLException {
		System.out.println("delete");
		bean = new StudenteBean();
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
		bean.setMatricola("0512104239");
		classUnderTest.insert(bean,"pwd");
		boolean deleted = classUnderTest.delete(bean.getEmail());
		assertTrue(deleted);
	}
	
	/**
	 * Test del metodo delete con un studente non presente nel db.
	 * @throws SQLException 
	 */
	@Test
	void testDeleteStudenteNonInDB() throws SQLException {
		System.out.println("delete");
		bean = new StudenteBean();
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
	 * Test del metodo getStudentiAssociati con tutorAziendale presente nel db
	 *  e con almeno uno studente associato.
	 * @throws SQLException
	 */
	@Test
	void testGetStudentiAssociatiTutorAziendaleInDB() throws SQLException {
		System.out.println("getStudentiAssociatiTutorAziendale");
		ArrayList<StudenteBean> list = (ArrayList<StudenteBean>) classUnderTest.getStudentiAssociati(tutorAziendale);
		assertNotNull(list);
	}
	
	/**
	 * Test del metodo getStudentiAssociati con tutorAziendale non presente nel db.
	 * @throws SQLException
	 */
	@Test
	void testGetStudentiAssociatiTutorAziendaleNonInDB() throws SQLException {
		System.out.println("getStudentiAssociatiTutorAziendale");
		TutorAziendaleBean tutor = new TutorAziendaleBean();
		tutor.setEmail("prova@mail.com");
		ArrayList<StudenteBean> list = (ArrayList<StudenteBean>) classUnderTest.getStudentiAssociati(tutor);
		assertEquals(0, list.size());
	}

	
	/**
	 * Test del metodo getStudentiAssociati con tutorAziendale presente nel db e con nessuno studente associato.
	 * @throws SQLException
	 */
	@Test
	void testGetStudentiAssociatiTutorAziendaleInDBNoStudenti() throws SQLException {
		System.out.println("getStudentiAssociatiTutorAziendale");
		TutorAziendaleBean tutor = new TutorAziendaleBean();
		tutor.setEmail("antoniobianchi@gmail.com");
		tutor.setNome("nome");
		tutor.setCognome("cognome");
		tutor.setTelefono("3265574125");
		tutor.setIndirizzo("via Romana 21");
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
		java.sql.Date sqlDate = null;
		try {
			java.util.Date utilDate = format.parse("1997-04-16");
			sqlDate = new java.sql.Date(utilDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		tutor.setDataNascita(sqlDate);
		tutor.setFotoProfilo("");
		tutor.setAzienda(new AziendaBean("ITD Solutions", "", "via Galileo Galilei 7, Milano (MI)","via della Maglianella 65, Roma (RM)", null, null));
		ArrayList<StudenteBean> list = (ArrayList<StudenteBean>) classUnderTest.getStudentiAssociati(tutor);
		assertEquals(0, list.size());
		}

	
	/**
	 * Test del metodo getStudentiAssociati con tutorUniversitario presente nel db
	 * e con almeno uno studente associato.
	 * @throws SQLException 
	 */
	@Test
	void testGetStudentiAssociatiTutorUniversitarioInDB() throws SQLException {
		System.out.println("getStudentiAssociatiTutorUniversitario");
		ArrayList<StudenteBean> list = (ArrayList<StudenteBean>) classUnderTest.getStudentiAssociati(tutorUniversitario);
		assertNotNull(list);
	}

	/**
	 * Test del metodo getStudentiAssociati con tutorUniversitario non presente.
	 * @throws SQLException 
	 */
	@Test
	void testGetStudentiAssociatiTutorUniversitarioNonInDB() throws SQLException {
		System.out.println("getStudentiAssociatiTutorUniversitario");
		TutorUniversitarioBean tutor = new TutorUniversitarioBean();
		tutor.setEmail("nonindb@gmail.com");
		tutor.setNome("nome");
		tutor.setCognome("cognome");
		tutor.setTelefono("3265574125");
		tutor.setIndirizzo("via Romana 21");
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
		java.sql.Date sqlDate = null;
		try {
			java.util.Date utilDate = format.parse("1997-04-16");
			sqlDate = new java.sql.Date(utilDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		tutor.setDataNascita(sqlDate);
		tutor.setFotoProfilo("");
		
		ArrayList<StudenteBean> list = (ArrayList<StudenteBean>) classUnderTest.getStudentiAssociati(tutor);
		assertEquals(0, list.size());
		}
	

	/**
	 * Testa il metodo getStudentiPerStatoRichiesta con uno statoRichiesta associato ad
	 * almeno una richiesta di uno studente.
	 * @throws SQLException 
	 */
	@Test
	void testGetStudentiPerStatoRichiesta() throws SQLException {
		System.out.println("getStudentiPerStatoRichiesta");
		String statoRichiesta = "nuova";
		ArrayList<StudenteBean> list = (ArrayList<StudenteBean>) classUnderTest.getStudentiPerStatoRichiesta(statoRichiesta);
		assertNotNull(list);
	}

	/**
	 * Testa il metodo getStudentiPerStatoTirocinio con uno statoTirocinio associato ad 
	 * almeno un registro di uno studente.
	 * @throws SQLException 
	 */
	@Test
	void testGetStudentiPerStatoTirocinio() throws SQLException {
		System.out.println("getStudentiPerStatoTirocinio");
		String statoTirocinio = "incorso";
		ArrayList<StudenteBean> list = (ArrayList<StudenteBean>) classUnderTest.getStudentiPerStatoTirocinio(statoTirocinio);
		assertNotNull(list);
	}

}
