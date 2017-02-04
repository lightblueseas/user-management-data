package de.alpharogroup.user.management.rest.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.alpharogroup.service.rs.RestfulResource;
import de.alpharogroup.user.management.domain.Permission;

/**
 * The interface {@link PermissionsResource} provides methods for resolving permissions objects.
 */
@Path("/permission/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface PermissionsResource extends RestfulResource<Integer, Permission>
{

	/**
	 * Factory method to create and save a new {@link Permission} object.
	 *
	 * @param name the name
	 * @param description the description
	 * @return the new {@link Permission} object.
	 */
	@GET
	@Path("/new/perm/{name}/{description}/")
	Permission createAndSavePermissions(@PathParam("name") String name, @PathParam("description")String description);

	/**
	 * Factory method to create and save a new {@link Permission} object.
	 *
	 * @param name the name
	 * @param description the description
	 * @param shortcut the shortcut
	 * @return the new {@link Permission} object.
	 */
	@GET
	@Path("/new/perm/{name}/{description}/{shortcut}/")
	Permission createAndSavePermissions(@PathParam("name")String name, @PathParam("description")String description,
			@PathParam("shortcut")String shortcut);
	
	/**
	 * Find the {@link Permission} object by the given shortcut.
	 *
	 * @param shortcut the shortcut
	 * @return the found {@link Permission} object or null if not.
	 */
	@GET
	@Path("/find/by/shortcut/{shortcut}/")
	Permission findByShortcut(@PathParam("shortcut")String shortcut);
	
	/**
	 * Find the {@link Permission} object by the given name.
	 *
	 * @param name the name
	 * @return the found {@link Permission} object or null if not.
	 */
	@GET
	@Path("/find/by/name/{name}/")
	Permission findByName(@PathParam("name")String name);

	/**
	 * Find all {@link Permission} objects by the given parameters.
	 *
	 * @param description the description
	 * @param permissionName the permission name
	 * @param shortcut the shortcut
	 * @return the list of the found {@link Permission} objects.
	 */
	@GET
	@Path("/find/by/description/{description}/{name}/{shortcut}/")
	List<Permission> find(@PathParam("description")String description, @PathParam("name")String name,
			@PathParam("shortcut")String shortcut);
}
