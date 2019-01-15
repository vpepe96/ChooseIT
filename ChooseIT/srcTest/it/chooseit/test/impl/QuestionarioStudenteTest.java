package it.chooseit.test.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.chooseit.bean.AziendaBean;
import it.chooseit.bean.QuestionarioStudenteBean;
import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.RichiestaTirocinioBean;
import it.chooseit.bean.StudenteBean;
import it.chooseit.bean.TutorAziendaleBean;
import it.chooseit.bean.TutorUniversitarioBean;
import it.chooseit.impl.QuestionarioStudente;
import it.chooseit.impl.RegistroTirocinio;
import it.chooseit.impl.RichiestaTirocinio;

class QuestionarioStudenteTest  {

 private static QuestionarioStudente classUnderTest;
 private static QuestionarioStudenteBean bean;
 private static int ricId;
 private static int id;
 private static StudenteBean studente;
 private static TutorAziendaleBean tutorAziendale;
 
 private static int pdt1;
 private static int pdt2;
 private static int pdt3;
 private static int pdt4;
 private static int  t1;
 private static int  t2;
 private static int  t3;
 private static int  t4;
 private static int  su1;
 private static int  su2;
 private static int  su3;
  
 @BeforeAll
	static void setUp() throws Exception {
		   bean = new QuestionarioStudenteBean();
		   classUnderTest = new QuestionarioStudente();
		   
		   pdt1 = 1;
		   pdt2 = 3;
		   pdt3 = 4;
		   pdt4 = 5;
		   t1 = 3;
		   t2 = 5;
		   t3 = 2;
		   t4 = 1;
		   su1 = 5;
		   su2 = 3;
		   su3 = 4;
		   
		   
		   studente = new StudenteBean();
		   studente.setEmail("a.bianchi@studenti.unisa.it");
		   
		   Date dataInizio = new Date(System.currentTimeMillis());
		   
		   tutorAziendale =  new TutorAziendaleBean();
		   tutorAziendale.setEmail("vnovo@gmail.com");
		   
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
		     ricId = richiestaTirocinioBean.getId();
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
		     id = registroTirocinioBean.getIdentificativo();
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
		
		QuestionarioStudenteBean b = classUnderTest.retrieveByKey(id);
		
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
  
  QuestionarioStudenteBean b = classUnderTest.retrieveByKey(100);
  
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
		
		bean.setT1(t1);
		bean.setT2(t2);
		bean.setT3(t3);
		bean.setT4(t4);
		bean.setPdt1(pdt1);
		bean.setPdt2(pdt2);
		bean.setPdt3(pdt3);
		bean.setPdt4(pdt4);
		bean.setSu1(su1);
		bean.setSu2(su2);
		bean.setSu3(su3);
		
		classUnderTest.update(bean);
		QuestionarioStudenteBean b = classUnderTest.retrieveByKey(id);
		
		assertNotNull(b);
		assertEquals(t1, b.getT1());
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
	final void testGetQuestionarioPerTutorAziendale() throws Exception{
	  System.out.println("getQuestionariPerTutorAziendale");
	  
	  ArrayList<QuestionarioStudenteBean> questionari = (ArrayList<QuestionarioStudenteBean>) classUnderTest.getQuestionarioPerTutorAziendale(tutorAziendale);
	  assertNotEquals(0, questionari.size());
	}

	
	/**
	 * Testa il metodo retrieveAll con un database in cui sono presenti almeno un
	 * questionario.
	 * @throws Exception
	 */
	@Test
	final void testRetrieveAllSenzaOrder() throws Exception {
		ArrayList<QuestionarioStudenteBean> list = (ArrayList<QuestionarioStudenteBean>) classUnderTest.retrieveAll(null);
		assertNotEquals(0, list.size());
	}

	
 /**
  * Testa il metodo retrieveAll con un database in cui sono presenti almeno un
  * questionario.
  * @throws Exception
  */
 @Test
 final void testRetrieveAllConOrder() throws Exception {
  ArrayList<QuestionarioStudenteBean> list = (ArrayList<QuestionarioStudenteBean>) classUnderTest.retrieveAll("registro_id");
  assertNotEquals(0, list.size());
 }
 
 @Test
 final void testGetQuestionariNonCompilati() throws Exception {
   bean.setT1(0);
   bean.setT2(0);
   bean.setT3(0);
   bean.setT4(0);
   bean.setPdt1(0);
   bean.setPdt2(0);
   bean.setPdt3(0);
   bean.setPdt4(0);
   bean.setSu1(0);
   bean.setSu2(0);
   bean.setSu3(0);
   classUnderTest.update(bean);
   ArrayList<QuestionarioStudenteBean> list = (ArrayList<QuestionarioStudenteBean>) classUnderTest.getQuestionariNonCompilati(tutorAziendale);
   assertNotNull(list);
 }
	
 @AfterAll
 static void tearDown() throws Exception {
   classUnderTest.delete(id);
 }

}
