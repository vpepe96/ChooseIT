package it.chooseit.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.chooseit.bean.AziendaBean;
import it.chooseit.bean.QuestionarioAziendaBean;
import it.chooseit.bean.QuestionarioStudenteBean;
import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.StudenteBean;
import it.chooseit.bean.TutorAziendaleBean;

class QuestionarioStudenteTest {

	void setUp() throws Exception {
		   azienda = new QuestionarioStudenteBean();
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
		azienda.setT1(T1);
		az.update(azienda);
		azienda = az.retrieveByKey(id);
		assertEquals(T1, azienda.getT1());
	}

	@Test
	final void testDelete() throws Exception {
		System.out.println("delete");
		azienda = new QuestionarioStudenteBean();
		azienda.setPdt1(pdt1);
		azienda.setPdt2(pdt2);
		azienda.setPdt3(pdt3);
		azienda.setPdt4(pdt4);
		
		azienda.setT1(T1);
		azienda.setT2(T2);
		azienda.setT3(T3);
		azienda.setT4(T4);
		
		azienda.setSu1(su1);
		azienda.setSu2(su2);
		azienda.setSu3(su3);
		
		
		
		boolean deleted = az.delete(id);
		assertFalse(deleted);
	}

	@Test
	final void testGetQuestionarioPerStudente() {
		Collection<QuestionarioStudenteBean> questionario=new ArrayList<>(); 
		
	   
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
			QuestionarioStudenteBean questionarioA=new QuestionarioStudenteBean();
			
			questionarioA.setRegistroTirocinio(registroA);
			questionarioA.setPdt1(pdt1);
			questionarioA.setPdt2(pdt2);
			questionarioA.setPdt3(pdt3);
			questionarioA.setPdt4(pdt4);
			
			questionarioA.setT1(T1);
			questionarioA.setT2(T2);
			questionarioA.setT3(T3);
			questionarioA.setT4(T4);
			
			questionarioA.setSu1(su1);
			questionarioA.setSu2(su2);
			questionarioA.setSu3(su3);
			
			QuestionarioStudenteBean questionarioB=new QuestionarioStudenteBean();
			questionarioB.setRegistroTirocinio(registroB);
			questionarioB.setPdt1(pdt1);
			questionarioB.setPdt2(pdt2);
			questionarioB.setPdt3(pdt3);
			questionarioB.setPdt4(pdt4);
			
			questionarioB.setT1(T1);
			questionarioB.setT2(T2);
			questionarioB.setT3(T3);
			questionarioB.setT4(T4);
			
			questionarioB.setSu1(su1);
			questionarioB.setSu2(su2);
			questionarioB.setSu3(su3);
			
			questionario.add(questionarioA);
			questionario.add(questionarioB);
		
		
	}

	@Test
	final void testRetrieveAll() throws Exception {
		ArrayList<QuestionarioStudenteBean> list = (ArrayList<QuestionarioStudenteBean>) az.retrieveAll("registroTirocinio");
		assertNotNull(list);
	}

	private static final int pdt1 = 1;
	  private static final int pdt2 = 3;
	  private static final int pdt3 = 4;
	  private static final int pdt4 = 5;
	 
	  private static final int  T1 = 3;
	  private static final int  T2 = 5;
	  private static final int  T3 = 2;
	  private static final int  T4 = 1;
	  
	  private static final int  su1 = 5;
	  private static final int  su2 = 3;
	  private static final int  su3 = 4;
	  QuestionarioStudente az=new QuestionarioStudente();
	  int id= reg.getIdentificativo();
	

	private static QuestionarioStudenteBean azienda;
	private static RegistroTirocinioBean reg;
	private static TutorAziendaleBean tutor;
	
	
}


	
