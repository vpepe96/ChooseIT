package it.chooseit.test.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.ReportBean;
import it.chooseit.bean.TutorAziendaleBean;
import it.chooseit.impl.Report;
import it.chooseit.services.ReportKey;

class ReportTest {

	private static Report classUnderTest;
	private static ReportKey key;
	private static ReportBean bean;
	
	@BeforeAll
	static void setUp() throws Exception {
		classUnderTest = new Report();
		RegistroTirocinioBean registro = new RegistroTirocinioBean();
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
		Date data = new Date(format.parse("2012-11-10").getTime());
		registro.setIdentificativo(1);
		key = new ReportKey(registro, data);
	}

	/**
	 * Testa il metodo retrieveByKey con un report presente nel db.
	 * @throws SQLException 
	 */
	@Test
	void testRetrieveByKey() throws SQLException {
		System.out.println("retrieveBtKey");
		bean = classUnderTest.retrieveByKey(key);
		assertNotNull(bean);
	}

	/**
	 * Test del metodo retrieveAll con un db che ha almeno un report.
	 * @throws SQLException
	 */
	@Test
	void testRetrieveAll() throws SQLException {
		System.out.println("retrieveAll");
		ArrayList<ReportBean> list = (ArrayList<ReportBean>) classUnderTest.retrieveAll(null);
		assertNotNull(list);
	}

	/**
	 * Test del metodo insert con un report presente nel db.
	 * @throws SQLException
	 */
	@Test
	void testInsert() throws SQLException {
		System.out.println("insert");
		bean = new ReportBean();
		RegistroTirocinioBean registro = new RegistroTirocinioBean();
		registro.setIdentificativo(1);
		bean.setRegistroTirocinio(registro);
		Date dataRepo = new Date(System.currentTimeMillis());
		bean.setDataInserimento(dataRepo);
		bean.setPath("");
		classUnderTest.insert(bean);
		ReportKey repoKey = new ReportKey(registro, dataRepo);
		bean = classUnderTest.retrieveByKey(repoKey);
		assertNotNull(bean);
		classUnderTest.delete(repoKey);
	}

	/**
	 * Testa il metodo update con un report presente nel db.
	 * @throws SQLException
	 */
	@Test
	void testUpdate() throws SQLException {
		System.out.println("update");
		bean = new ReportBean();
		RegistroTirocinioBean registro = new RegistroTirocinioBean();
		registro.setIdentificativo(1);
		bean.setRegistroTirocinio(registro);
		Date dataRepo = new Date(System.currentTimeMillis());
		bean.setDataInserimento(dataRepo);
		bean.setPath("");
		classUnderTest.insert(bean);
		ReportKey repoKey = new ReportKey(registro, dataRepo);
		bean = classUnderTest.retrieveByKey(repoKey);
		bean.setPath("nuovo path");
		TutorAziendaleBean tutor = new TutorAziendaleBean();
		tutor.setEmail("valeriorossi@gmail.com");
		bean.setTutorAziendale(tutor);
		classUnderTest.update(bean);
		bean = classUnderTest.retrieveByKey(repoKey);
		assertEquals("nuovo path", bean.getPath());
		classUnderTest.delete(repoKey);
	}

	/**
	 * Testa il metodo delete con un report presente nel db.
	 * @throws SQLException
	 */
	@Test
	void testDelete() throws SQLException {
		System.out.println("delete");
		bean = new ReportBean();
		RegistroTirocinioBean registro = new RegistroTirocinioBean();
		registro.setIdentificativo(1);
		bean.setRegistroTirocinio(registro);
		Date dataRepo = new Date(System.currentTimeMillis());
		bean.setDataInserimento(dataRepo);
		bean.setPath("");
		classUnderTest.insert(bean);
		ReportKey repoKey = new ReportKey(registro, dataRepo);
		boolean ok =  classUnderTest.delete(repoKey);
		assertEquals(true, ok);
	}

	/**
	 * Testa il metodo getReportFirmati con un registro che ha almeno un report firmato.
	 * @throws SQLException 
	 */
	@Test
	void testGetReportFirmati() throws SQLException {
		System.out.println("getReportFirmati");
		RegistroTirocinioBean registro = new RegistroTirocinioBean();
		registro.setIdentificativo(1);
		bean.setRegistroTirocinio(registro);
		ArrayList<ReportBean> list = (ArrayList<ReportBean>) classUnderTest.getReportFirmati(registro);
		assertNotEquals(0, list.size());
	}
	

	/**
	 * Testa il metodo getReportFirmati con un registro che non ha nessun report.
	 * @throws SQLException
	 */
	@Test
	void testGetReportNonFirmati() throws SQLException {
		System.out.println("getReportNonFirmati");
		RegistroTirocinioBean registro = new RegistroTirocinioBean();
		registro.setIdentificativo(1);
		bean.setRegistroTirocinio(registro);
		ArrayList<ReportBean> list = (ArrayList<ReportBean>) classUnderTest.getReportNonFirmati(registro);
		assertEquals(0, list.size());
	}

	/**
	 * Test del metodo getReportRegistro con un registro che ha almeno un report.
	 * @throws SQLException
	 */
	@Test
	void testGetReportRegistro() throws SQLException {
		System.out.println("getReportRegistro");
		RegistroTirocinioBean registro = new RegistroTirocinioBean();
		registro.setIdentificativo(1);
		bean.setRegistroTirocinio(registro);
		ArrayList<ReportBean> list = (ArrayList<ReportBean>) classUnderTest.getReportRegistro(registro);
		assertNotEquals(0, list.size());
	}

}
