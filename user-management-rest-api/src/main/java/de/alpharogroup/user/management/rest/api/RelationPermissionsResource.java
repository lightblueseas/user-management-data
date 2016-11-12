package de.alpharogroup.user.management.rest.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.alpharogroup.collections.pairs.KeyValuePair;
import de.alpharogroup.service.rs.RestfulResource;
import de.alpharogroup.user.management.domain.Permission;
import de.alpharogroup.user.management.domain.RelationPermission;
import de.alpharogroup.user.management.domain.User;
import de.alpharogroup.user.management.enums.ContactmethodType;

/**
 * The interface {@link RelationPermissionsResource} provides methods for resolving relations of
 * permissions from user objects.
 */
@Path("/relation/permission/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface RelationPermissionsResource extends RestfulResource<Integer, RelationPermission>
{
	
	/**
	 * Find all given permissions that the given provider granted to the
	 * subscriber.
	 * 
	 * @param provider
	 *            the provider
	 * @param subscriber
	 *            the subscriber
	 * @return the list
	 */
	RelationPermission findRelationPermissions(final KeyValuePair<User, User> providerToSubscriber);

	/**
	 * Finds the RelationPermissions object from the given permissions the given
	 * provider and the subscriber.
	 * 
	 * @param provider
	 *            the provider
	 * @param subscriber
	 *            the subscriber
	 * @param permission
	 *            the permission
	 * @return the relation permissions
	 */
	RelationPermission findRelationPermissions(final User provider,
			final User subscriber, Permission permission);

	/**
	 * Find a list of RelationPermissions that the given provider granted to the
	 * subscriber.
	 * 
	 * @param provider
	 *            the provider
	 * @param subscriber
	 *            the subscriber
	 * @return the list
	 */
	List<RelationPermission> find(final User provider, final User subscriber);

	/**
	 * Find a list of RelationPermissions from the given provider and to the
	 * subscriber and the given permission if the provider granted this
	 * permission to the subscriber.
	 * 
	 * @param provider
	 *            the provider
	 * @param subscriber
	 *            the subscriber
	 * @param permission
	 *            the permission
	 * @return the list
	 */
	List<RelationPermission> find(final User provider,
			final User subscriber, Permission permission);
	
	/**
	 * Adds the given permission for the given subscriber provided from the provider.
	 *
	 * @param provider the provider
	 * @param subscriber the subscriber
	 * @param permission the permission
	 */
	void addPermission( User provider, User subscriber, Permission permission);
	
	/**
	 * Removes the given permission for the given subscriber provided from the provider.
	 *
	 * @param provider the provider
	 * @param subscriber the subscriber
	 * @param permission the permission
	 */
	void removePermission( User provider, User subscriber, Permission permission);
	
	/**
	 * Removes all permissions that are given for both users.
	 *
	 * @param provider the provider
	 * @param subscriber the subscriber
	 */
	void removeAllPermissions(User provider, User subscriber);
}
