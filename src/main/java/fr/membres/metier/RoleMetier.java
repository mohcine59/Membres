package fr.membres.metier;

import fr.membres.entities.UserRoles;

public interface RoleMetier {

	public void attribuerRole(UserRoles r, Long userID);
}
