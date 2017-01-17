package fr.membres.metier.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import fr.membres.dao.MembreDao;
import fr.membres.entities.User;
import fr.membres.metier.UserMetier;

public class UserMetierImpl implements UserMetier{

	@Autowired
	MembreDao membreDao;
	
	
	
	public MembreDao getMembreDao() {
		return membreDao;
	}

	public void setMembreDao(MembreDao membreDao) {
		this.membreDao = membreDao;
	}

	@Override
	public Long addUser(User user) {
		membreDao.addUser(user);
		return user.getUserID();
	}

	@Override
	public void setUser(User user) {
		membreDao.setUser(user);
		
	}

	@Override
	public User getUser(Long userID) {
		return membreDao.getUser(userID);
	}

	
}
