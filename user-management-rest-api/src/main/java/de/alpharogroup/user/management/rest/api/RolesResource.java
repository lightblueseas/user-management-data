package de.alpharogroup.user.management.rest.api;

import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.alpharogroup.service.rs.RestfulResource;
import de.alpharogroup.user.management.domain.Permission;
import de.alpharogroup.user.management.domain.Role;

/**
 * The interface {@link RolesResource} provides methods for resolve roles of users.
 */
@Path("/roles/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface RolesResource extends RestfulResource<Integer, Role>
{

	/**
	 * Find all {@link Permission} objects from the given {@link Role} object.
	 *
	 * @param role
	 *            the given {@link Role} object
	 * @return 's a list with all {@link Permission} objects from the given {@link Role} object.
	 */
	List<Permission> findAllPermissions(Role role);

	/**
	 * Find the {@link Role} object with the given role name. If it does'nt exists it returns null.
	 *
	 * @param rolename the role name
	 * @return the found {@link Role} object or if it does'nt exists it returns null.
	 */
	Role findRole(final String rolename);

	/**
	 * Find the {@link Role} objects with the given role name.
	 *
	 * @param rolename the rolename
	 * @return the found {@link Role} objects
	 */
	List<Role> findRoles(final String rolename);

	/**
	 * Checks if a role exists with the given role name.
	 *
	 * @param rolename the role name
	 * @return true, if successful
	 */
	boolean exists(final String rolename);

	/**
	 * Creates a new {@link Role} object with the given arguments and save it. If it does exists it will return the existing.
	 *
	 * @param rolename the role name.
	 * @param description the description of the role.
	 * @return the created or existing {@link Role} object.
	 */
	Role createAndSaveRole(String rolename, String description);

	/**
	 * Creates a new {@link Role} object with the given arguments and save it. If it does exists it will return the existing.
	 *
	 * @param rolename the role name.
	 * @param description the description of the role.
	 * @param permissions the permissions to set for the role.
	 * @return the created or existing {@link Role} object.
	 */
	Role createAndSaveRole(String rolename, String description, Set<Permission> permissions);
}
