package fr.membres.dao.impl;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.membres.dao.MembreDao;
import fr.membres.entities.Membre;
import fr.membres.entities.User;
import fr.membres.entities.UserRoles;

public class MembreDaoImpl implements MembreDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Long addMembre(final Membre m) {
		this.em.persist(m);
		return m.getMembreID();
	}

	@Override
	public void setMembre(final Membre m) {
		this.em.merge(m);
	}

	@Override
	public List<Membre> getMembres() {
		
		final Query req = this.em.createQuery("select m from Membre m");
		System.out.println("=========== requete");
		return req.getResultList();
	}

	@Override
	public Membre getMembre(final Long idMemebre) {
		return this.em.find(Membre.class, idMemebre);
	}
	
	@Override
	public Membre getMembre(String email) {
		Long id = getIdMembreFromUser(email);
		
		return em.find(Membre.class, id);
	}

	@Override
	public void addUser(final User u) {
		this.em.persist(u);
	}

	@Override
	public void setUser(final User u) {
		this.em.merge(u);
	}

	@Override
	public void attribuerRole(final UserRoles r, final Long userID) {
		final User u = this.em.find(User.class, userID);
		u.getRoles().add(r);
		this.em.persist(r);
	}

	@Override
	public Long getIdMembreFromUser(final String email) {
		final Query req = this.em.createNativeQuery("select membreID from membre where email =:email");
		req.setParameter("email", email);
		final Object membreID = req.getSingleResult();
		final BigInteger membreIdBig = (BigInteger) membreID;
		final long memebreIdLong = membreIdBig.longValue();
		return memebreIdLong;
	}

	@Override
	public User getUser(final Long userID) {
		return this.em.find(User.class, userID);
	}

	@Override
	public List<Membre> listMembresVille(final String ville) {
		final Query req = this.em.createNativeQuery("select * from membre m where ville =:x", Membre.class);
		req.setParameter("x", ville);
		return req.getResultList();
	}

	@Override
	public void deleteMembre(final Long membreID) {
		final Membre m = this.em.find(Membre.class, membreID);
		this.em.remove(m);
	}


}
