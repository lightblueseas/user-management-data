package de.alpharogroup.user.management.rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
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

}
