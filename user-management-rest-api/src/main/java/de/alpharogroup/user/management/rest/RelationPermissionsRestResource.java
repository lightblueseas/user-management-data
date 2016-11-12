package de.alpharogroup.user.management.rest;


import java.util.List;

import de.alpharogroup.collections.pairs.KeyValuePair;
import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.user.management.domain.Permission;
import de.alpharogroup.user.management.domain.RelationPermission;
import de.alpharogroup.user.management.domain.User;
import de.alpharogroup.user.management.rest.api.RelationPermissionsResource;
import de.alpharogroup.user.management.service.api.RelationPermissionService;

public class RelationPermissionsRestResource
	extends
		AbstractRestfulResource<Integer, RelationPermission, RelationPermissionService>
	implements
	RelationPermissionsResource
{

	@Override
	public RelationPermission findRelationPermissions(KeyValuePair<User, User> providerToSubscriber) {
		return getDomainService().findRelationPermissions(providerToSubscriber.getKey(), providerToSubscriber.getValue());
	}
	@Override
	public RelationPermission findRelationPermissions(User provider, User subscriber, Permission permission) {
		return getDomainService().findRelationPermissions(provider, subscriber, permission);
	}

	@Override
	public List<RelationPermission> find(User provider, User subscriber) {
		return getDomainService().find(provider, subscriber);
	}

	@Override
	public List<RelationPermission> find(User provider, User subscriber, Permission permission) {
		return getDomainService().find(provider, subscriber, permission);
	}

	@Override
	public void addPermission(User provider, User subscriber, Permission permission) {
		getDomainService().addPermission(provider, subscriber, permission);
	}

	@Override
	public void removePermission(User provider, User subscriber, Permission permission) {
		getDomainService().removePermission(provider, subscriber, permission);
	}

	@Override
	public void removeAllPermissions(User provider, User subscriber) {
		getDomainService().removeAllPermissions(provider, subscriber);
	}


}
