package fr.membres.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import fr.membres.dao.MembreDao;
import fr.membres.entities.Membre;
import fr.membres.metier.MembreMetier;

@Transactional
public class MembreMetierImpl implements MembreMetier {

	@Autowired
	private MembreDao membreDao;
	
	
	
	
	public MembreDao getMembreDao() {
		return membreDao;
	}

	public void setMembreDao(MembreDao mDao) {
		this.membreDao = mDao;
	}

	@Override
	public Membre getMembre(Long id) {
		return membreDao.getMembre(id);
	}
	
	@Override
	public Membre getMembre(String email) {
		return membreDao.getMembre(email);
	}


	@Override
	public void setMembre(Membre m) {
		membreDao.setMembre(m);
	}

	@Override
	public void deleteMembre(Long membreID) {
		membreDao.deleteMembre(membreID);
	}

	@Override
	public List<Membre> getMembres() {
		return membreDao.getMembres();
	}

	@Override
	public Long addMembre(Membre m) {
		return membreDao.addMembre(m);
	}


	
}
