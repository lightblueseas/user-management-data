package de.alpharogroup.user.management.rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.alpharogroup.service.rs.RestfulResource;
import de.alpharogroup.user.management.domain.RelationPermission;

/**
 * The interface {@link RelationPermissionsResource} provides methods for resolving relations of
 * permissions from user objects.
 */
@Path("/relation/permission/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface RelationPermissionsResource extends RestfulResource<Integer, RelationPermission>
{

}
