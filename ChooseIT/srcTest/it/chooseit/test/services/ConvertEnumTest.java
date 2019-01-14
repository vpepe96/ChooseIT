package it.chooseit.test.services;

import static org.junit.jupiter.api.Assertions.*;

import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.Test;

import it.chooseit.bean.StatoRichiestaBean;
import it.chooseit.bean.StatoReportBean;
import it.chooseit.bean.StatoTirocinioBean;
import it.chooseit.services.ConvertEnum;

class ConvertEnumTest {

	//TEST PER LO STATO DELLA RICHIESTA DI TIROCINIO.
	
	/**
	 * Testa il metodo convertStatoRichiesta su un stato valido della richiesta di tirocinio.
	 * Stato considerato "nuova".
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	void testConvertStatoRichiestaNuova() throws NoSuchAlgorithmException, Exception{
		String stato = "nuova";
		ConvertEnum convert = new ConvertEnum();
		StatoRichiestaBean.StatoRichiesta tipo = convert.convertStatoRichiesta(stato);
		assertNotNull(tipo);
	}
	
	/**
	 * Testa il metodo convertStatoRichiesta su un stato valido della richiesta di tirocinio.
	 * Stato considerato "invalidazione".
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	void testConvertStatoRichiestaInValidazione() throws NoSuchAlgorithmException, Exception{
		String stato = "invalidazione";
		ConvertEnum convert = new ConvertEnum();
		StatoRichiestaBean.StatoRichiesta tipo = convert.convertStatoRichiesta(stato);
		assertNotNull(tipo);
	}
	
	/**
	 * Testa il metodo convertStatoRichiesta su un stato valido della richiesta di tirocinio.
	 * Stato considerato "inconvalida".
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	void testConvertStatoRichiestaInConvalida() throws NoSuchAlgorithmException, Exception{
		String stato = "inconvalida";
		ConvertEnum convert = new ConvertEnum();
		StatoRichiestaBean.StatoRichiesta tipo = convert.convertStatoRichiesta(stato);
		assertNotNull(tipo);
	}
	
	/**
	 * Testa il metodo convertStatoRichiesta su un stato valido della richiesta di tirocinio.
	 * Stato considerato "accettata".
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	void testConvertStatoRichiestaAccettata() throws NoSuchAlgorithmException, Exception{
		String stato = "accettata";
		ConvertEnum convert = new ConvertEnum();
		StatoRichiestaBean.StatoRichiesta tipo = convert.convertStatoRichiesta(stato);
		assertNotNull(tipo);
	}
	
	/**
	 * Testa il metodo convertStatoRichiesta su un stato valido della richiesta di tirocinio.
	 * Stato considerato "rifiutata".
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	void testConvertStatoRichiestaRifiutata() throws NoSuchAlgorithmException, Exception{
		String stato = "rifiutata";
		ConvertEnum convert = new ConvertEnum();
		StatoRichiestaBean.StatoRichiesta tipo = convert.convertStatoRichiesta(stato);
		assertNotNull(tipo);
	}
	
	/**
	 * Testa il metodo convertStatoRichiesta su un stato non valido della richiesta di tirocinio.
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	void testConvertStatoRichiestaInvalido() throws NoSuchAlgorithmException, Exception{
		String stato = "statoNonValido";
		ConvertEnum convert = new ConvertEnum();
		StatoRichiestaBean.StatoRichiesta tipo = convert.convertStatoRichiesta(stato);
		assertNull(tipo);
	}
	
	/**
	 * Testa il metodo convertStatoRichiestaString su un stato valido della richiesta di tirocinio.
	 * Stato considerato "nuova".
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	void testConvertStatoRichiestaStringNuova() throws NoSuchAlgorithmException, Exception{
		ConvertEnum convert = new ConvertEnum();
		String stato = convert.convertStatoRichiestaString(StatoRichiestaBean.StatoRichiesta.NUOVA);
		assertNotNull(stato);
	}
	
	/**
	 * Testa il metodo convertStatoRichiestaString su un stato valido della richiesta di tirocinio.
	 * Stato considerato "invalidazione".
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	void testConvertStatoRichiestaStringInValidazione() throws NoSuchAlgorithmException, Exception{
		ConvertEnum convert = new ConvertEnum();
		String stato = convert.convertStatoRichiestaString(StatoRichiestaBean.StatoRichiesta.INVALIDAZIONE);
		assertNotNull(stato);
	}
	
	/**
	 * Testa il metodo convertStatoRichiestaString su un stato valido della richiesta di tirocinio.
	 * Stato considerato "inconvalida".
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	void testConvertStatoRichiestaStringInConvalida() throws NoSuchAlgorithmException, Exception{
		ConvertEnum convert = new ConvertEnum();
		String stato = convert.convertStatoRichiestaString(StatoRichiestaBean.StatoRichiesta.INCONVALIDA);
		assertNotNull(stato);
	}
	
	/**
	 * Testa il metodo convertStatoRichiestaString su un stato valido della richiesta di tirocinio.
	 * Stato considerato "accettata".
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	void testConvertStatoRichiestaStringAccettata() throws NoSuchAlgorithmException, Exception{
		ConvertEnum convert = new ConvertEnum();
		String stato = convert.convertStatoRichiestaString(StatoRichiestaBean.StatoRichiesta.ACCETTATA);
		assertNotNull(stato);
	}
	
	/**
	 * Testa il metodo convertStatoRichiestaString su un stato valido della richiesta di tirocinio.
	 * Stato considerato "rifiutata".
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	void testConvertStatoRichiestaStringRifiutata() throws NoSuchAlgorithmException, Exception{
		ConvertEnum convert = new ConvertEnum();
		String stato = convert.convertStatoRichiestaString(StatoRichiestaBean.StatoRichiesta.RIFIUTATA);
		assertNotNull(stato);
	}
	
	//TEST PER LO STATO DEL REPORT.
	
	/**
	 * Testa il metodo convertStatoReport su un stato valido del report di tirocinio.
	 * Stato considerato "nuovo".
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	void testConvertStatoReportNuovo() throws NoSuchAlgorithmException, Exception{
		String stato = "nuovo";
		ConvertEnum convert = new ConvertEnum();
		StatoReportBean.StatoReport tipo = convert.convertStatoReport(stato);
		assertNotNull(tipo);
	}
	
	/**
	 * Testa il metodo convertStatoReport su un stato valido del report di tirocinio.
	 * Stato considerato "compilato".
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	void testConvertStatoReportCompilato() throws NoSuchAlgorithmException, Exception{
		String stato = "compilato";
		ConvertEnum convert = new ConvertEnum();
		StatoReportBean.StatoReport tipo = convert.convertStatoReport(stato);
		assertNotNull(tipo);
	}	
	
	/**
	 * Testa il metodo convertStatoReport su un stato valido del report di tirocinio.
	 * Stato considerato "validato".
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	void testConvertStatoReportValidato() throws NoSuchAlgorithmException, Exception{
		String stato = "validato";
		ConvertEnum convert = new ConvertEnum();
		StatoReportBean.StatoReport tipo = convert.convertStatoReport(stato);
		assertNotNull(tipo);
	}
	
	/**
	 * Testa il metodo convertStatoReport su un stato valido del report di tirocinio.
	 * Stato considerato "rifiutato".
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	void testConvertStatoReportRifiutato() throws NoSuchAlgorithmException, Exception{
		String stato = "rifiutato";
		ConvertEnum convert = new ConvertEnum();
		StatoReportBean.StatoReport tipo = convert.convertStatoReport(stato);
		assertNotNull(tipo);
	}
	
	/**
	 * Testa il metodo convertStatoReport su un stato non valido del report di tirocinio.
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	void testConvertStatoReportInvalido() throws NoSuchAlgorithmException, Exception{
		String stato = "statoNonValido";
		ConvertEnum convert = new ConvertEnum();
		StatoReportBean.StatoReport tipo = convert.convertStatoReport(stato);
		assertNull(tipo);
	}

	/**
	 * Testa il metodo convertStatoReportString su un stato valido del report di tirocinio.
	 * Stato considerato "nuovo".
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	void testConvertStatoReportStringNuovo() throws NoSuchAlgorithmException, Exception{
		ConvertEnum convert = new ConvertEnum();
		String stato = convert.convertStatoReportString(StatoReportBean.StatoReport.NUOVO);
		assertNotNull(stato);
	}
	
	/**
	 * Testa il metodo convertStatoReportString su un stato valido del report di tirocinio.
	 * Stato considerato "compilato".
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	void testConvertStatoReportStringCompilato() throws NoSuchAlgorithmException, Exception{
		ConvertEnum convert = new ConvertEnum();
		String stato = convert.convertStatoReportString(StatoReportBean.StatoReport.COMPILATO);
		assertNotNull(stato);
	}
	
	/**
	 * Testa il metodo convertStatoReportString su un stato valido del report di tirocinio.
	 * Stato considerato "validato".
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	void testConvertStatoReportStringValidato() throws NoSuchAlgorithmException, Exception{
		ConvertEnum convert = new ConvertEnum();
		String stato = convert.convertStatoReportString(StatoReportBean.StatoReport.VALIDATO);
		assertNotNull(stato);
	}
	
	/**
	 * Testa il metodo convertStatoReportString su un stato valido del report di tirocinio.
	 * Stato considerato "rifiutato".
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	void testConvertStatoReportStringRifiutato() throws NoSuchAlgorithmException, Exception{
		ConvertEnum convert = new ConvertEnum();
		String stato = convert.convertStatoReportString(StatoReportBean.StatoReport.RIFIUTATO);
		assertNotNull(stato);
	}

	//TEST PER LO STATO DEL TIROCINIO.
	
	/**
	 * Testa il metodo convertStatoTirocinio su un stato valido del tirocinio.
	 * Stato considerato "incorso".
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	void testConvertStatoTirocinioInCorso() throws NoSuchAlgorithmException, Exception{
		String stato = "incorso";
		ConvertEnum convert = new ConvertEnum();
		StatoTirocinioBean.StatoTirocinio tipo = convert.convertStatoTirocinio(stato);
		assertNotNull(tipo);
	}	
	
	/**
	 * Testa il metodo convertStatoTirocinio su un stato valido del tirocinio.
	 * Stato considerato "terminato".
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	void testConvertStatoTirocinioTerminato() throws NoSuchAlgorithmException, Exception{
		String stato = "terminato";
		ConvertEnum convert = new ConvertEnum();
		StatoTirocinioBean.StatoTirocinio tipo = convert.convertStatoTirocinio(stato);
		assertNotNull(tipo);
	}	
	
	/**
	 * Testa il metodo convertStatoTirocinio su un stato valido del tirocinio.
	 * Stato considerato "annullato".
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	void testConvertStatoTirocinioAnnullato() throws NoSuchAlgorithmException, Exception{
		String stato = "annullato";
		ConvertEnum convert = new ConvertEnum();
		StatoTirocinioBean.StatoTirocinio tipo = convert.convertStatoTirocinio(stato);
		assertNotNull(tipo);
	}	
	
	/**
	 * Testa il metodo convertStatoTirocinio su un stato non valido del tirocinio.
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	void testConvertStatoTirocinioInvalido() throws NoSuchAlgorithmException, Exception{
		String stato = "statoNonValido";
		ConvertEnum convert = new ConvertEnum();
		StatoTirocinioBean.StatoTirocinio tipo = convert.convertStatoTirocinio(stato);
		assertNull(tipo);
	}
	
	/**
	 * Testa il metodo convertStatoTirocinioString su un stato valido del tirocinio.
	 * Stato considerato "incorso".
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	void testConvertStatoTirocinioStringInCorso() throws NoSuchAlgorithmException, Exception{
		ConvertEnum convert = new ConvertEnum();
		String stato = convert.convertStatoTirocinioString(StatoTirocinioBean.StatoTirocinio.INCORSO);
		assertNotNull(stato);
	}
	
	/**
	 * Testa il metodo convertStatoTirocinioString su un stato valido del tirocinio.
	 * Stato considerato "terminato".
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	void testConvertStatoTirocinioStringTerminato() throws NoSuchAlgorithmException, Exception{
		ConvertEnum convert = new ConvertEnum();
		String stato = convert.convertStatoTirocinioString(StatoTirocinioBean.StatoTirocinio.TERMINATO);
		assertNotNull(stato);
	}
	
	/**
	 * Testa il metodo convertStatoTirocinioString su un stato valido del tirocinio.
	 * Stato considerato "terminato".
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	void testConvertStatoTirocinioStringAnnullato() throws NoSuchAlgorithmException, Exception{
		ConvertEnum convert = new ConvertEnum();
		String stato = convert.convertStatoTirocinioString(StatoTirocinioBean.StatoTirocinio.ANNULLATO);
		assertNotNull(stato);
	}
	
}