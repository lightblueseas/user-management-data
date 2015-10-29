package de.alpharogroup.user.management.service.api;

import java.util.List;
import java.util.Set;

import de.alpharogroup.db.service.jpa.BusinessService;
import de.alpharogroup.user.management.entities.Permissions;
import de.alpharogroup.user.management.entities.Roles;

/**
 * The Interface RolesService.
 */
public interface RolesService extends BusinessService<Roles, Integer>{

	/**
	 * Find all permissions from the given Roles object.
	 * 
	 * @param role
	 *            the given Roles object
	 * @return 's a list with all permissions from the given Roles object.
	 */
	List<Permissions> findAllPermissions(Roles role);
	
	/**
	 * Finds the Roles object with the given role name. If it does'nt exists it returns null.
	 *
	 * @param rolename the role name
	 * @return the roles
	 */
	Roles findRole(final String rolename);
	
	List<Roles> findRoles(final String rolename);
	
	/**
	 * Checks if a role exists with the given role name.
	 *
	 * @param rolename the role name
	 * @return true, if successful
	 */
	boolean exists(final String rolename);
	
	/**
	 * Creates a new Roles object with the given arguments and save it. If it does exists it will return the existing.
	 *
	 * @param rolename the role name.
	 * @param description the description of the role.
	 * @return the created or existing Roles object.
	 */
	Roles createAndSaveRole(String rolename, String description);
	
	/**
	 * Creates a new Roles object with the given arguments and save it. If it does exists it will return the existing.
	 *
	 * @param rolename the role name.
	 * @param description the description of the role.
	 * @param permissions the permissions to set for the role.
	 * @return the created or existing Roles object.
	 */
	Roles createAndSaveRole(String rolename, String description, Set<Permissions> permissions);

}