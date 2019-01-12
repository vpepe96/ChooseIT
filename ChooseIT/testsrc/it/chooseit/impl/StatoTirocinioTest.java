package it.chooseit.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.RichiestaTirocinioBean;
import it.chooseit.bean.StatoTirocinioBean;
import it.chooseit.bean.StudenteBean;
import it.chooseit.bean.TutorAziendaleBean;
import it.chooseit.bean.TutorUniversitarioBean;

class StatoTirocinioTest {
	
	private static StatoTirocinio classUnderTest;
	private static RegistroTirocinio classSupport;
	
	/**
	 * Setta classUnderTest e bean prima del testRetrieveByKey
	 * @throws Exception
	 */
	@BeforeAll
	static void setUp() throws Exception {
		classUnderTest = new StatoTirocinio();
		
		assertNotNull(classUnderTest);
	}

	/**
	 * Test del metodo retrieveAll con parametro order
	 * @throws Exception
	 */
	@Test
	void testRetrieveAllConOrder() throws SQLException {
		System.out.println("retrieveAll | input --> order");
		try {
		ArrayList<StatoTirocinioBean> list = (ArrayList<StatoTirocinioBean>) classUnderTest.retrieveAll("data_stato");
		assertNotNull(list);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Test del metodo retrieveAll senza parametro order
	 * @throws Exception
	 */
	@Test
	void testRetrieveAllSenzaOrder() throws Exception {
		System.out.println("retrieveAll | input --> null");
		ArrayList<StatoTirocinioBean> list = (ArrayList<StatoTirocinioBean>) classUnderTest.retrieveAll(null);
		assertNotNull(list);
	}
	
	/**
	 * Test del metodo insert inserendo un nuovo stato tirocinio ad un registro
	 * @throws Exception
	 */
	@Test
	void testInsert() throws Exception {
		System.out.println("insert | input --> statoTirocinio non presente in DB");
		StatoTirocinioBean statoTirocinio = new StatoTirocinioBean();
		
		//creazione di una nuova richiesta di tirocinio
		RegistroTirocinioBean registro = new RegistroTirocinioBean();
		
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
		java.sql.Date sqlDate = null;
		try {
			java.util.Date utilDate = format.parse("1997-04-16");
			sqlDate = new java.sql.Date(utilDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		StatoTirocinioBean.StatoTirocinio tipo = StatoTirocinioBean.StatoTirocinio.INCORSO;
		
		statoTirocinio.setTipo(tipo);
		statoTirocinio.setRegistroTirocinio(registro);
		statoTirocinio.setDataStato(sqlDate);
		
		registro.setStatoTirocinio(new Date(System.currentTimeMillis()), statoTirocinio);

		classSupport.insert(registro);
		
		assertEquals(statoTirocinio, registro.getStatoTirocinio(tipo));
	}

	/**
	 * Test del metodo delete eliminando uno stato tirocinio presente nel DB
	 */
	@Test
	void testDelete() throws Exception {
		StatoTirocinioBean statoTirocinio = new StatoTirocinioBean();
		
		RegistroTirocinioBean registro = new RegistroTirocinioBean();
		registro.setIdentificativo(9);
		
		StudenteBean studente = new StudenteBean();
		registro.setStudente(studente);
		TutorAziendaleBean tutorAzienda = new TutorAziendaleBean();
		registro.setTutorAziendale(tutorAzienda);
		TutorUniversitarioBean tutorUni = new TutorUniversitarioBean();
		registro.setTutorUniversitario(tutorUni);
		RichiestaTirocinioBean richiesta = new RichiestaTirocinioBean();
		registro.setRichiestaTirocinio(richiesta);
		
		registro.setStatoTirocinio(new Date(System.currentTimeMillis()), statoTirocinio);
		
		classSupport.insert(registro);
	
		boolean ok = classUnderTest.delete(statoTirocinio);
		assertEquals(true, ok);
	}

	/**
	 * Test del metodo getStatoTirocinio
	 * @throws Exception
	 */
	@Test
	void testGetStatoTirocinio() throws Exception {
		StatoTirocinioBean statoTirocinio = new StatoTirocinioBean();
		
		RegistroTirocinioBean registro = new RegistroTirocinioBean();
		registro.setIdentificativo(9);
		
		StudenteBean studente = new StudenteBean();
		registro.setStudente(studente);
		TutorAziendaleBean tutorAzienda = new TutorAziendaleBean();
		registro.setTutorAziendale(tutorAzienda);
		TutorUniversitarioBean tutorUni = new TutorUniversitarioBean();
		registro.setTutorUniversitario(tutorUni);
		RichiestaTirocinioBean richiesta = new RichiestaTirocinioBean();
		registro.setRichiestaTirocinio(richiesta);
		
		registro.setStatoTirocinio(new Date(System.currentTimeMillis()), statoTirocinio);
		
		classSupport.insert(registro);
	
		assertEquals(statoTirocinio, registro.getStatoTirocinio(null));
	}

	/**
	 * Test delmetodo getStatiTirocinio
	 * @throws SQLException
	 */
	@Test
	void testGetStatiTirocinio() throws SQLException {
		StatoTirocinioBean statoTirocinio = new StatoTirocinioBean();
		
		RegistroTirocinioBean registro = new RegistroTirocinioBean();
		registro.setIdentificativo(9);
		
		StudenteBean studente = new StudenteBean();
		registro.setStudente(studente);
		TutorAziendaleBean tutorAzienda = new TutorAziendaleBean();
		registro.setTutorAziendale(tutorAzienda);
		TutorUniversitarioBean tutorUni = new TutorUniversitarioBean();
		registro.setTutorUniversitario(tutorUni);
		RichiestaTirocinioBean richiesta = new RichiestaTirocinioBean();
		registro.setRichiestaTirocinio(richiesta);
		
		registro.setStatoTirocinio(new Date(System.currentTimeMillis()), statoTirocinio);
		
		classSupport.insert(registro);
		
		ArrayList<StatoTirocinioBean> list = (ArrayList<StatoTirocinioBean>) classUnderTest.getStatiTirocinio(registro);
	
		assertEquals(1,list.size());
		
		classSupport.delete(6);
	}

}
