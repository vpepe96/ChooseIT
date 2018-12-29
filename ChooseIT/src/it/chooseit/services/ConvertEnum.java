package it.chooseit.services;

/**
 * La classe ConvertEnum è un servizio che si rende utile per convertire una stringa nella corrispettiva variabile enum
 * quando si ha a che fare con gli stati delle richieste di tirocinio, dei report e dei tirocini.
 * 
 * @author RocketStudios
 */

import it.chooseit.bean.StatoRichiestaBean.StatoRichiesta;
import it.chooseit.bean.StatoReportBean.StatoReport;
import it.chooseit.bean.StatoTirocinioBean.StatoTirocinio;

public class ConvertEnum {
	//public enum StatoRichiesta {NUOVA, INVALIDAZIONE, INCONVALIDA, ACCETTATA, RIFIUTATA};
	//public enum StatoReport {NUOVO, COMPILATO, VALIDATO, RIFIUTATO};
	//public enum StatoTirocinio {INCORSO, ANNULLATO, TERMINATO};
	
	/**
	 * Restituisce la variabile enum di StatoRichiesta che corrisponde ad una stringa specificata
	 * Stati di richiesta tirocinio: public enum StatoRichiesta {NUOVA, INVALIDAZIONE, INCONVALIDA, ACCETTATA, RIFIUTATA}
	 * 
	 * Pre: stato != null
	 * @param stato stringa specificata
	 * @return enum corrispondente alla stringa specificata
	 */
	public StatoRichiesta convertStatoRichiesta(String stato) {
		StatoRichiesta tipo = null;
		
		switch(stato) {	
			case "NUOVA": tipo = StatoRichiesta.NUOVA; 
						  break;
			
			case "INVALIDAZIONE": tipo = StatoRichiesta.INVALIDAZIONE;
								  break;
			
			case "INCONVALIDA": tipo = StatoRichiesta.INCONVALIDA;
			  					break;
			
			case "ACCETTATA": tipo = StatoRichiesta.INCONVALIDA;
							  break;
			
			case "RIFIUTATA": tipo = StatoRichiesta.INCONVALIDA;
				  	 		  break;	
		}
		
		return tipo;
	}
	
	/**
	 * Restituisce la variabile enum di StatoReport che corrisponde ad una stringa specificata
	 * Stati di report: public enum StatoReport {NUOVO, COMPILATO, VALIDATO, RIFIUTATO}
	 * 
	 * Pre: stato != null
	 * @param stato stringa specificata
	 * @return enum corrispondente alla stringa specificata
	 */
	public StatoReport convertStatoReport(String stato) {
		StatoReport tipo = null;
		
		switch(stato) {	
			case "NUOVO": tipo = StatoReport.NUOVO; 
						  break;
			
			case "COMPILATO": tipo = StatoReport.COMPILATO;
								  break;
			
			case "VALIDATO": tipo = StatoReport.VALIDATO;
			  					break;
			
			case "RIFIUTATO": tipo = StatoReport.RIFIUTATO;
							  break;
		}
		
		return tipo;
	}
	
	/**
	 * Restituisce la variabile enum di StatoTirocinio che corrisponde ad una stringa specificata
	 * Stati del tirocinio: public enum StatoTirocinio {INCORSO, ANNULLATO, TERMINATO}
	 * 
	 * Pre: stato != null
	 * @param stato stringa specificata
	 * @return enum corrispondente alla stringa specificata
	 */
	public StatoTirocinio convertStatoTirocinio(String stato) {
		StatoTirocinio tipo = null;
		
		switch(stato) {	
			case "INCORSO": tipo = StatoTirocinio.INCORSO; 
						  break;
			
			case "ANNULLATO": tipo = StatoTirocinio.ANNULLATO;
								  break;
			
			case "TERMINATO": tipo = StatoTirocinio.TERMINATO;
			  					break;
		}
		
		return tipo;
	}
	
}
