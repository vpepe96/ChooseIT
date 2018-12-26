package it.chooseit.bean;

/**
 * Un oggetto TutorUniveristarioBean rappresenta un tutor universitario dell'Universit� degli Studi di Salerno
 * iscritto alla piattaforma ChooseIT. Un oggetto TutorUniversitarioBean � anche un oggetto UtenteBean, infatti
 * {@inheritDoc}.
 *
 * @author RocketStudios
 */

import java.io.Serializable;

public class TutorUniversitarioBean extends UtenteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Costruttore di TutorUniversitarioBean.
	 */
	public TutorUniversitarioBean() { }
	
}