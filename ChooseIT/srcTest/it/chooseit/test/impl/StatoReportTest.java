package it.chooseit.test.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.ReportBean;
import it.chooseit.bean.StatoReportBean;
import it.chooseit.impl.RegistroTirocinio;
import it.chooseit.impl.Report;
import it.chooseit.impl.StatoReport;
import it.chooseit.services.ReportKey;

class StatoReportTest {

	private static StatoReport classUnderTest;
	private static StatoReportBean bean;
	private static Report classSupportReport;
	private static RegistroTirocinio classSupportRegistro;
	
	@BeforeAll
	static void setUp() throws Exception {
		classUnderTest = new StatoReport();
		classSupportReport = new Report();
		classSupportRegistro = new RegistroTirocinio();
	}

	/**
	 * Test del metodo retrieveAll con un db che ha almeno uno stato report.
	 * @throws SQLException
	 */
	@Test
	void testRetrieveAll() throws SQLException{
		System.out.println("retrieveAll");
		ArrayList<StatoReportBean> list = (ArrayList<StatoReportBean>) classUnderTest.retrieveAll(null);
		assertNotEquals(0, list.size());
	}

	
	/**
	 * Testa il metodo insert con uno stato report relativo a un report
	 * presente in db.
	 * @throws ParseException
	 * @throws SQLException
	 */
	@Test
	void testInsert() throws ParseException, SQLException {
		System.out.println("insert");
		
		bean =  new StatoReportBean();
		ReportBean beanRepo = new ReportBean();
		RegistroTirocinioBean registro = new RegistroTirocinioBean();
		registro.setIdentificativo(3);
		beanRepo.setRegistroTirocinio(registro);
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date(format.parse("10/11/2019").getTime());
		Date dataRepo = new Date(data.getTime());
		beanRepo.setDataInserimento(dataRepo);
		beanRepo.setPath("");
		Report repoDao = new Report();
		repoDao.insert(beanRepo);
		ReportKey repoKey = new ReportKey(registro, dataRepo);
		beanRepo = repoDao.retrieveByKey(repoKey);
		
		bean.setReport(beanRepo);
		bean.setRegistroTirocinio(registro);
		bean.setDataStato(new Date(System.currentTimeMillis()));
		bean.setTipo(it.chooseit.bean.StatoReportBean.StatoReport.COMPILATO);
		
		boolean ok = false;
		
			try {
				classUnderTest.insert(bean);
				ok = true;
			} catch (SQLException e) {
				ok = false;
			}
		assertTrue(ok);
	
		classUnderTest.delete(bean);
		repoDao.delete(repoKey);
	}


	/**
	 * Testa il metodo delete con uno stato report relativo a un report 
	 * presente nel db.
	 */
	@Test
	void testDelete() throws SQLException, ParseException {
		bean = new StatoReportBean();
		ReportBean beanRepo = new ReportBean();
		RegistroTirocinioBean registro = new RegistroTirocinioBean();
		registro.setIdentificativo(3);
		beanRepo.setRegistroTirocinio(registro);
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date(format.parse("10/11/2020").getTime());
		Date dataRepo = new Date(data.getTime());
		beanRepo.setDataInserimento(dataRepo);
		beanRepo.setPath("");
		Report repoDao = new Report();
		repoDao.insert(beanRepo);
		ReportKey repoKey = new ReportKey(registro, dataRepo);
		beanRepo = repoDao.retrieveByKey(repoKey);
		bean.setReport(beanRepo);
		bean.setDataStato(new Date(System.currentTimeMillis()));
		bean.setTipo(it.chooseit.bean.StatoReportBean.StatoReport.COMPILATO);
		bean.setRegistroTirocinio(registro);
		classUnderTest.insert(bean);
	
		boolean ok = classUnderTest.delete(bean);
		assertEquals(true, ok);
		repoDao.delete(repoKey);
	}

	/**
	 * Testa il metodo getStatoReport con un report presente nel db e
	 * con almeno uno stato associato.
	 * @throws ParseException
	 * @throws SQLException
	 */
	@Test
	void testGetStatoReport() throws ParseException, SQLException {
		bean = new StatoReportBean();
		ReportBean beanRepo = new ReportBean();
		RegistroTirocinioBean registro = new RegistroTirocinioBean();
		registro.setIdentificativo(3);
		beanRepo.setRegistroTirocinio(registro);
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date(format.parse("10/01/2011").getTime());
		Date dataRepo = new Date(data.getTime());
		beanRepo.setDataInserimento(dataRepo);
		beanRepo.setPath("");
		Report repoDao = new Report();
		repoDao.insert(beanRepo);
		ReportKey repoKey = new ReportKey(registro, dataRepo);
		beanRepo = repoDao.retrieveByKey(repoKey);
		
		bean.setReport(beanRepo);
		
		bean.setDataStato(new Date(System.currentTimeMillis()));
		
		bean.setTipo(it.chooseit.bean.StatoReportBean.StatoReport.COMPILATO);
		
		bean.setRegistroTirocinio(registro);
		
		classUnderTest.insert(bean);
		
		StatoReportBean rs = classUnderTest.getStatoReport(beanRepo);
	
		assertEquals(bean.getTipo(), rs.getTipo());
		
		classUnderTest.delete(bean);
		repoDao.delete(repoKey);
	}

	/**
	 * Testa il metodo getstatiReport con un report presente nel db 
	 * e almeno uno stato associato.
	 * @throws ParseException
	 * @throws SQLException
	 */
	@Test
	void testGetStatiReport() throws ParseException, SQLException {
		System.out.println("getStatReport | input --> statoReport non presente in DB");
		
		RegistroTirocinioBean registro = classSupportRegistro.retrieveByKey(1);
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date(format.parse("10/11/2012").getTime());
		Date dataRepo = new Date(data.getTime());
		ReportKey key = new ReportKey(registro, dataRepo);
		ReportBean report = classSupportReport.retrieveByKey(key);
		Collection<StatoReportBean> stati = classUnderTest.getStatiReport(report);
	
		assertEquals(2, stati.size());
	}

}
