package fr.membres.metier;

import fr.membres.entities.User;

public interface UserMetier {

	public Long addUser(User user);
	public void setUser(User user);
	public User getUser(Long userId);
}
