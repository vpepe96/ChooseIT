package it.chooseit.services;

/**
 * La classe ConvertEnum è un servizio che si rende utile per convertire una stringa, indenpendemente dal suo formato, 
 * nella corrispettiva variabile enum quando si ha a che fare con gli stati delle richieste di tirocinio, dei report 
 * e dei tirocini.
 * 
 * @author RocketStudios
 */

import it.chooseit.bean.StatoRichiestaBean.StatoRichiesta;
import it.chooseit.bean.StatoReportBean.StatoReport;
import it.chooseit.bean.StatoTirocinioBean.StatoTirocinio;

public class ConvertEnum {
	
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
		String[] stati = {"NUOVA","IN VALIDAZIONE","IN CONVALIDA","ACCETTATA","RIFIUTATA"};
		
		if(stato.equalsIgnoreCase(stati[0]))
			tipo = StatoRichiesta.NUOVA;
		
		else if(stato.equalsIgnoreCase(stati[1]))
			tipo = StatoRichiesta.INVALIDAZIONE;
		
		else if(stato.equalsIgnoreCase(stati[2]))
			tipo = StatoRichiesta.INCONVALIDA;
		
		else if(stato.equalsIgnoreCase(stati[3]))
			tipo = StatoRichiesta.ACCETTATA;
		
		else if(stato.equalsIgnoreCase(stati[4]))
			tipo = StatoRichiesta.RIFIUTATA;
		
		return tipo;
	}
	
	public String convertStatoRichiestaString(StatoRichiesta stato) {
		String tipo = null;
		String[] stati = {"NUOVA","IN VALIDAZIONE","IN CONVALIDA","ACCETTATA","RIFIUTATA"};
		
		if(stato.toString().equalsIgnoreCase(stati[0]))
			tipo = stati[0];
		
		else if(stato.toString().equalsIgnoreCase(stati[1]))
			tipo = stati[1];
		
		else if(stato.toString().equalsIgnoreCase(stati[2]))
			tipo = stati[2];
		
		else if(stato.toString().equalsIgnoreCase(stati[3]))
			tipo = stati[3];
		
		else if(stato.toString().equalsIgnoreCase(stati[4]))
			tipo = stati[4];
		
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
		String[] stati = {"NUOVO","COMPILATO","VALIDATO","RIFIUTATO"};
		
		if(stato.equalsIgnoreCase(stati[0]))
			tipo = StatoReport.NUOVO;
		
		else if(stato.equalsIgnoreCase(stati[1]))
			tipo = StatoReport.COMPILATO;
		
		else if(stato.equalsIgnoreCase(stati[2]))
			tipo = StatoReport.VALIDATO;
		
		else if(stato.equalsIgnoreCase(stati[3]))
			tipo = StatoReport.RIFIUTATO;
			
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
		String[] stati = {"IN CORSO","ANNULLATO","TERMINATO"};
		
		if(stato.equalsIgnoreCase(stati[0]))
			tipo = StatoTirocinio.INCORSO;
		
		else if(stato.equalsIgnoreCase(stati[1]))
			tipo = StatoTirocinio.ANNULLATO;
		
		else if(stato.equalsIgnoreCase(stati[2]))
			tipo = StatoTirocinio.TERMINATO;
			
		return tipo;
	}
	
}
