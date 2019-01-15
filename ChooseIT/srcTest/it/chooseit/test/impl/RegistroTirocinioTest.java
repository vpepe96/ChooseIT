package it.chooseit.test.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.chooseit.bean.AziendaBean;
import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.RichiestaTirocinioBean;
import it.chooseit.bean.StudenteBean;
import it.chooseit.bean.TutorAziendaleBean;
import it.chooseit.bean.TutorUniversitarioBean;
import it.chooseit.impl.RegistroTirocinio;
import it.chooseit.impl.RichiestaTirocinio;

class RegistroTirocinioTest {

	private static RegistroTirocinio classUnderTest;
	private static RegistroTirocinioBean bean;
 private static int ricId;
 private static int id;
 private static StudenteBean studente;
	private static TutorAziendaleBean tutorAziendale;
	private static TutorUniversitarioBean tutorUniversitario;
	
	@BeforeAll
	static void setUp() throws Exception {
		classUnderTest = new RegistroTirocinio();
		bean = new RegistroTirocinioBean();
		
  studente = new StudenteBean();
  studente.setEmail("a.bianchi@studenti.unisa.it");
  
  Date dataInizio = new Date(System.currentTimeMillis());
  
  tutorAziendale =  new TutorAziendaleBean();
  tutorAziendale.setEmail("vnovo@gmail.com");
  
  tutorUniversitario = new TutorUniversitarioBean();
  tutorUniversitario.setEmail("luchini@unisa.it");
  
  AziendaBean azienda = new AziendaBean();
  azienda.setRagioneSociale("ITD Solutions");
  
  RichiestaTirocinioBean ric = new RichiestaTirocinioBean();
  ric.setAzienda(azienda);
  ric.setStudente(studente);
  ric.setProgettoFormativo("");
  ric.setDataRichiesta(new Date(System.currentTimeMillis()));
  RichiestaTirocinio ricDao = new RichiestaTirocinio();
  ricDao.insert(ric);
  
  ArrayList<RichiestaTirocinioBean> richieste = (ArrayList<RichiestaTirocinioBean>) ricDao.retrieveAll("id");
  ricId = 0;
  for (RichiestaTirocinioBean richiestaTirocinioBean : richieste) {
    ricId=richiestaTirocinioBean.getId();
  }
  //ricId è l'identificativo dell'ultima richiesta appena inserita
  ric.setId(ricId);
  
  bean.setStudente(studente);
  bean.setDataInizio(dataInizio);
  bean.setTutorAziendale(tutorAziendale);
  bean.setTutorUniversitario(tutorUniversitario);
  bean.setRichiestaTirocinio(ric);
  classUnderTest.insert(bean);
  
  ArrayList<RegistroTirocinioBean> registri = (ArrayList<RegistroTirocinioBean>) classUnderTest.retrieveAll("identificativo");
  id = 0;
  for (RegistroTirocinioBean registroTirocinioBean : registri) {
    id=registroTirocinioBean.getIdentificativo();
  }
  //in id c'è l'dentificativo dell'ultimo registro inserito
  bean.setIdentificativo(id);
	}

	/**
	 * Testa il metodo retrieveByKey con un registro presente nel db.
	 * @throws SQLException
	 */
	@Test
	void testRetrieveByKeyRegistroInDB() throws SQLException {
		System.out.println("retrieveByKey");
		
		bean = classUnderTest.retrieveByKey(id);
		assertNotNull(bean);
		assertEquals(id, bean.getIdentificativo());
	}

	/**
	 * Testa il metodo retrieveByKey con un registro non presente nel db.
	 * @throws SQLException
	 */
	@Test
	void testRetrieveByKeyRegistroNonInDB() throws SQLException {
		System.out.println("retrieveByKey");
		RegistroTirocinioBean b = classUnderTest.retrieveByKey(100);
		assertNull(b);
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
		
		bean = classUnderTest.retrieveByKey(id);
		TutorUniversitarioBean tutor = new TutorUniversitarioBean();
		tutor.setEmail("luchini@unisa.it");
		bean.setTutorUniversitario(tutor);
		classUnderTest.update(bean);
		bean = classUnderTest.retrieveByKey(id);
		assertEquals("luchini@unisa.it", bean.getTutorUniversitario().getEmail());
	}

	
	
	/**
	 * Testa il metodo getRegistriDiStudente con uno studente che ha almeno un registro associato
	 * @throws SQLException
	 */
	@Test
	void testGetRegistriDiStudente() throws SQLException {
		System.out.println("getRegistriDiStudente");
		
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
		
		ArrayList<RegistroTirocinioBean> list = (ArrayList<RegistroTirocinioBean>) classUnderTest.getRegistriDiTutorAziendale(tutorAziendale);
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
		
		ArrayList<RegistroTirocinioBean> list = (ArrayList<RegistroTirocinioBean>) classUnderTest.getRegistriDiTutorUniversitario(tutorUniversitario);
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
