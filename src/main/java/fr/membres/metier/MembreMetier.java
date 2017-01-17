package fr.membres.metier;

import java.util.List;

import fr.membres.entities.Membre;

public interface MembreMetier {

	public Long addMembre(Membre m);
	public Membre getMembre(Long id);
	public Membre getMembre(String email);
	public void setMembre(Membre m);
	public void deleteMembre(Long membreID);
	public List<Membre> getMembres();
}
