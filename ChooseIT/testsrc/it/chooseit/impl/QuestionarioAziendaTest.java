package it.chooseit.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.chooseit.bean.AziendaBean;
import it.chooseit.bean.QuestionarioAziendaBean;
import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.StudenteBean;
import it.chooseit.bean.TutorAziendaleBean;

class QuestionarioAziendaTest  {

	void setUp() throws Exception {
		   azienda = new QuestionarioAziendaBean();
		   reg=new RegistroTirocinioBean();
		   tutor=new TutorAziendaleBean();
		   
		  
		   
	}

	@Test
	final void testRetrieveByKey() throws Exception {
		System.out.println("retrieveByKey");
		azienda = az.retrieveByKey(id);
		assertNotNull(azienda);
		assertEquals(reg,azienda.getRegistroTirocinio() );
	}
	
	

	@Test
	final void testInsert() throws Exception {
		System.out.println("insert");
		azienda = az.retrieveByKey(id);
		boolean exc = false;
		try {
			az.insert(azienda);
		} catch (SQLException e) {
			exc = true;
		}
		assertTrue(exc);
	}

	@Test
	final void testUpdate() throws Exception {
		azienda = az.retrieveByKey(id);
		azienda.setEo1(eo1);
		az.update(azienda);
		azienda = az.retrieveByKey(id);
		assertEquals(eo1, azienda.getEo1());
	}

	@Test
	final void testDelete() throws Exception {
		System.out.println("delete");
		azienda = new QuestionarioAziendaBean();
		azienda.setPdt1(pdt1);
		azienda.setPdt2(pdt2);
		azienda.setPdt3(pdt3);
		azienda.setPdt4(pdt4);
		azienda.setPdt5(pdt5);
		azienda.setEo1(eo1);
		azienda.setEo2(eo2);
		azienda.setEo3(eo3);
		azienda.setEo4(eo4);
		azienda.setEo5(eo5);
		azienda.setSu1(su1);
		azienda.setSu2(su2);
		azienda.setSu3(su3);
		
		
		
		boolean deleted = az.delete(id);
		assertFalse(deleted);
	}

	@Test
	final void testGetQuestionarioPerStudente() {
		Collection<QuestionarioAziendaBean> questionario=new ArrayList<>(); 
		
	   
		StudenteBean studenteA=new StudenteBean();
	    studenteA.setCognome("Abcan");
	    studenteA.setEmail("Mario@gmail.com");
	        studenteA.setNome("Anna");
	        StudenteBean studenteB=new StudenteBean();
	        studenteB.setCognome("Abcan");
	        studenteB.setEmail("Mario@gmail.com");
	        studenteB.setNome("Anna");
			RegistroTirocinioBean registroA=new RegistroTirocinioBean();
			RegistroTirocinioBean registroB=new RegistroTirocinioBean();
			registroA.setStudente(studenteA);
			registroB.setStudente(studenteB);
			QuestionarioAziendaBean questionarioA=new QuestionarioAziendaBean();
			
			questionarioA.setRegistroTirocinio(registroA);
			questionarioA.setPdt1(pdt1);
			questionarioA.setPdt2(pdt2);
			questionarioA.setPdt3(pdt3);
			questionarioA.setPdt4(pdt4);
			questionarioA.setPdt5(pdt5);
			questionarioA.setEo1(eo1);
			questionarioA.setEo2(eo2);
			questionarioA.setEo3(eo3);
			questionarioA.setEo4(eo4);
			questionarioA.setEo5(eo5);
			questionarioA.setSu1(su1);
			questionarioA.setSu2(su2);
			questionarioA.setSu3(su3);
			
			QuestionarioAziendaBean questionarioB=new QuestionarioAziendaBean();
			questionarioB.setRegistroTirocinio(registroB);
			questionarioB.setPdt1(pdt1);
			questionarioB.setPdt2(pdt2);
			questionarioB.setPdt3(pdt3);
			questionarioB.setPdt4(pdt4);
			questionarioB.setPdt5(pdt5);
			questionarioB.setEo1(eo1);
			questionarioB.setEo2(eo2);
			questionarioB.setEo3(eo3);
			questionarioB.setEo4(eo4);
			questionarioB.setEo5(eo5);
			questionarioB.setSu1(su1);
			questionarioB.setSu2(su2);
			questionarioB.setSu3(su3);
			
			questionario.add(questionarioA);
			questionario.add(questionarioB);
		
		
	}

	@Test
	final void testRetrieveAll() throws Exception {
		ArrayList<QuestionarioAziendaBean> list = (ArrayList<QuestionarioAziendaBean>) az.retrieveAll("registroTirocinio");
		assertNotNull(list);
	}

	private static final int pdt1 = 1;
	  private static final int pdt2 = 3;
	  private static final int pdt3 = 4;
	  private static final int pdt4 = 5;
	  private static final int pdt5 = 2;
	  private static final int  eo1 = 3;
	  private static final int  eo2 = 5;
	  private static final int  eo3 = 2;
	  private static final int  eo4 = 1;
	  private static final int  eo5 = 4;
	  private static final int  su1 = 5;
	  private static final int  su2 = 3;
	  private static final int  su3 = 4;
	  QuestionarioAzienda az=new QuestionarioAzienda();
	  int id= reg.getIdentificativo();
	

	private static QuestionarioAziendaBean azienda;
	private static RegistroTirocinioBean reg;
	private static TutorAziendaleBean tutor;
	
	

}
