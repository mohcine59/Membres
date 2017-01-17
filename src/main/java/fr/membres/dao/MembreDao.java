package fr.membres.dao;

import java.util.List;

import fr.membres.entities.Membre;
import fr.membres.entities.UserRoles;
import fr.membres.entities.User;

public interface MembreDao {
	
	
	public Long addMembre(Membre m);
	
	public void setMembre(Membre m);
	
	public Membre getMembre(Long idMemebre);
	
	public Membre getMembre(String email);
	
	public void deleteMembre(Long membreID);
	
	public List<Membre> getMembres();
	
	public void addUser(User u);
	
	public void setUser(User u);
	
	public void attribuerRole(UserRoles r, Long userID);
	
	public Long getIdMembreFromUser(String email);
	
	public User getUser(Long userID);
	
	public List<Membre> listMembresVille(String ville);
}
