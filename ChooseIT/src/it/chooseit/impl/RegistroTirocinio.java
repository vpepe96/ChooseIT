package it.chooseit.impl;

import java.sql.SQLException;
import java.util.Collection;

import it.chooseit.bean.RegistroTirocinioBean;
import it.chooseit.bean.StudenteBean;
import it.chooseit.bean.TutorAziendaleBean;
import it.chooseit.dao.RegistroTirocinioDAO;

public class RegistroTirocinio implements RegistroTirocinioDAO {

	@Override
	public RegistroTirocinioBean retrieveByKey(Integer key) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<RegistroTirocinioBean> retrieveAll(String order) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(RegistroTirocinioBean object) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(RegistroTirocinioBean object) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean delete(Integer key) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<RegistroTirocinioBean> getRegistriDiStudente(StudenteBean studente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<RegistroTirocinioBean> getRegistriDiTutorAziendale(TutorAziendaleBean t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<RegistroTirocinioBean> getRegistriDiTirociniInCorso() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<RegistroTirocinioBean> getRegistriDiTirociniTerminati() {
		// TODO Auto-generated method stub
		return null;
	}

}
