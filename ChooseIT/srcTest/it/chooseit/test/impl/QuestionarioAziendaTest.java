package it.chooseit.test.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.chooseit.bean.AziendaBean;
import it.chooseit.bean.QuestionarioAziendaBean;
import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.RichiestaTirocinioBean;
import it.chooseit.bean.StudenteBean;
import it.chooseit.bean.TutorAziendaleBean;
import it.chooseit.bean.TutorUniversitarioBean;
import it.chooseit.impl.QuestionarioAzienda;
import it.chooseit.impl.RegistroTirocinio;
import it.chooseit.impl.RichiestaTirocinio;

class QuestionarioAziendaTest  {

 private static QuestionarioAzienda classUnderTest;
 private static QuestionarioAziendaBean bean;
 private static int ricId;
 private static int id;
 private static StudenteBean studente;
 
 private static int pdt1;
 private static int pdt2;
 private static int pdt3;
 private static int pdt4;
 private static int pdt5;
 private static int  eo1;
 private static int  eo2;
 private static int  eo3;
 private static int  eo4;
 private static int  eo5;
 private static int  su1;
 private static int  su2;
 private static int  su3;
  
 @BeforeAll
	static void setUp() throws Exception {
		   bean = new QuestionarioAziendaBean();
		   classUnderTest = new QuestionarioAzienda();
		   
		   pdt1 = 1;
		   pdt2 = 3;
		   pdt3 = 4;
		   pdt4 = 5;
		   pdt5 = 2;
		   eo1 = 3;
		   eo2 = 5;
		   eo3 = 2;
		   eo4 = 1;
		   eo5 = 4;
		   su1 = 5;
		   su2 = 3;
		   su3 = 4;
		   
		   
		   studente = new StudenteBean();
		   studente.setEmail("a.bianchi@studenti.unisa.it");
		   
		   Date dataInizio = new Date(System.currentTimeMillis());
		   
		   TutorAziendaleBean tutorAziendale =  new TutorAziendaleBean();
		   tutorAziendale.setEmail(null);
		   
		   TutorUniversitarioBean tutorUniversitario = new TutorUniversitarioBean();
		   tutorUniversitario.setEmail(null);
		   
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
		   
		   RegistroTirocinio regDao = new RegistroTirocinio();
		   RegistroTirocinioBean reg = new RegistroTirocinioBean();
		   reg.setStudente(studente);
		   reg.setDataInizio(dataInizio);
		   reg.setTutorAziendale(tutorAziendale);
		   reg.setTutorUniversitario(tutorUniversitario);
		   reg.setRichiestaTirocinio(ric);
		   regDao.insert(reg);
		   
		   ArrayList<RegistroTirocinioBean> registri = (ArrayList<RegistroTirocinioBean>) regDao.retrieveAll("identificativo");
		   id = 0;
		   for (RegistroTirocinioBean registroTirocinioBean : registri) {
		     id=registroTirocinioBean.getIdentificativo();
		   }
		   //in id c'è l'dentificativo dell'ultimo registro inserito
		   reg.setIdentificativo(id);
		   
		   bean.setRegistroTirocinio(reg);
		   classUnderTest.insert(bean);
	}

 /**
  * Testa il metodo retrieveByKey con un questionario associato ad un registro
  * presente nel db.
  * @throws Exception
  */
	@Test
	final void testRetrieveByKeyQuestionarioInDB() throws Exception {
		System.out.println("retrieveByKey");
		
		QuestionarioAziendaBean b = classUnderTest.retrieveByKey(id);
		
		assertNotNull(b);
		assertEquals(id, bean.getRegistroTirocinio().getIdentificativo());
	}
	
	
 /**
  * Testa il metodo retrieveByKey con un questionario associato ad un registro
  * non presente nel db.
  * @throws Exception
  */
 @Test
 final void testRetrieveByKeyQuestionarioNonInDB() throws Exception {
  System.out.println("retrieveByKey");
  
  QuestionarioAziendaBean b = classUnderTest.retrieveByKey(100);
  
  assertNull(b);
 }
	
	

	/**
	 * Testa il metodo insert con l'inserimento di un nuovo questionario
	 * vuoto associato a un nuovo registro.
	 * @throws Exception
	 */
	@Test
	final void testInsert() throws Exception {
		System.out.println("insert");

		classUnderTest.delete(id);
		
		classUnderTest.insert(bean);
		
		bean = classUnderTest.retrieveByKey(id);
		assertNotNull(bean);
	}

	/**
	 * Testa il metodo update con un questionario già presente nel db.
	 * @throws Exception
	 */
	@Test
	final void testUpdate() throws Exception {
		System.out.println("update");
		
		bean.setEo1(eo1);
		bean.setEo2(eo2);
		bean.setEo3(eo3);
		bean.setEo4(eo4);
		bean.setEo5(eo5);
		bean.setPdt1(pdt1);
		bean.setPdt2(pdt2);
		bean.setPdt3(pdt3);
		bean.setPdt4(pdt4);
		bean.setPdt5(pdt5);
		bean.setSu1(su1);
		bean.setSu2(su2);
		bean.setSu3(su3);
		
		classUnderTest.update(bean);
		QuestionarioAziendaBean b = classUnderTest.retrieveByKey(id);
		
		assertNotNull(b);
		assertEquals(eo1, b.getEo1());
	}

	/**
	 * Testa il metodo delete con un questionario presente nel db.
	 * @throws Exception
	 */
	@Test
	final void testDelete() throws Exception {
		System.out.println("delete");
		
		boolean deleted = classUnderTest.delete(id);
		assertTrue(deleted);
		
		classUnderTest.insert(bean);
	}


	/**
	 * Testa il metodo getQuestionariPerStudente con uno studente presente nel db
	 * e con almeno un questionario associato.
	 */
	@Test
	final void testGetQuestionarioPerStudente() throws Exception{
	  System.out.println("getQuestionarioPerStudente");
		
	  bean.setEo1(0);
	  bean.setEo2(0);
	  bean.setEo3(0);
	  bean.setEo4(0);
	  bean.setEo5(0);
	  bean.setPdt1(0);
	  bean.setPdt2(0);
	  bean.setPdt3(0);
	  bean.setPdt4(0);
	  bean.setPdt5(0);
	  bean.setSu1(0);
	  bean.setSu2(0);
	  bean.setSu3(0);
	  classUnderTest.update(bean);
	  
	  ArrayList<QuestionarioAziendaBean> questionari = (ArrayList<QuestionarioAziendaBean>) classUnderTest.getQuestionarioPerStudente(studente);
	  assertNotEquals(0, questionari.size());
	}

	
	/**
	 * Testa il metodo retrieveAll con un database in cui sono presenti almeno un
	 * questionario.
	 * @throws Exception
	 */
	@Test
	final void testRetrieveAll() throws Exception {
		ArrayList<QuestionarioAziendaBean> list = (ArrayList<QuestionarioAziendaBean>) classUnderTest.retrieveAll(null);
		assertNotEquals(0, list.size());
	}

	
 @AfterAll
 static void tearDown() throws Exception {
   classUnderTest.delete(id);
 }

}
