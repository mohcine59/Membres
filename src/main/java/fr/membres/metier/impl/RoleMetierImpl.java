package fr.membres.metier.impl;

import org.springframework.beans.factory.annotation.Autowired;

import fr.membres.dao.MembreDao;
import fr.membres.entities.UserRoles;
import fr.membres.metier.RoleMetier;

public class RoleMetierImpl implements RoleMetier {

	@Autowired
	private MembreDao membreDao;
	
	
	
	public MembreDao getMembreDao() {
		return membreDao;
	}

	public void setMembreDao(MembreDao membreDao) {
		this.membreDao = membreDao;
	}

	@Override
	public void attribuerRole(UserRoles r, Long userID) {
		membreDao.attribuerRole(r, userID);
	}

	public MembreDao getmDao() {
		return membreDao;
	}

	public void setmDao(MembreDao mDao) {
		this.membreDao = mDao;
	}

	
}
