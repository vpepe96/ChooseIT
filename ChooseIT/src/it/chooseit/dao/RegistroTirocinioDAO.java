package it.chooseit.dao;

import java.util.Collection;

import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.StudenteBean;
import it.chooseit.bean.TutorAziendaleBean;


public interface RegistroTirocinioDAO extends GenericDAO<RegistroTirocinioBean, Integer> {
	
	public Collection<RegistroTirocinioBean> getRegistriDiStudente(StudenteBean studente);
	
	public Collection<RegistroTirocinioBean> getRegistriDiTutorAziendale(TutorAziendaleBean t);
	
	public Collection<RegistroTirocinioBean> getRegistriDiTirociniInCorso();
	
	public Collection<RegistroTirocinioBean> getRegistriDiTirociniTerminati();
	
}
