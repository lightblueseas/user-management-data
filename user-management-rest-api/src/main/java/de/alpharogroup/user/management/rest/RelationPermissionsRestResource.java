package de.alpharogroup.user.management.rest;


import java.util.List;

import de.alpharogroup.collections.pairs.KeyValuePair;
import de.alpharogroup.collections.pairs.Triple;
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
	public RelationPermission findRelationPermissions(Triple<User, User, Permission> providerToSubscriberOfPerms) {
		return getDomainService().findRelationPermissions(
				providerToSubscriberOfPerms.getLeft(), 
				providerToSubscriberOfPerms.getMiddle(), 
				providerToSubscriberOfPerms.getRight());
	}
	
	@Override
	public List<RelationPermission> find(KeyValuePair<User, User> providerToSubscriber) {
		return getDomainService().find(providerToSubscriber.getKey(), providerToSubscriber.getValue());
	}

	@Override
	public List<RelationPermission> find(Triple<User, User, Permission> providerToSubscriberOfPerms) {
		return getDomainService().find(
				providerToSubscriberOfPerms.getLeft(), 
				providerToSubscriberOfPerms.getMiddle(), 
				providerToSubscriberOfPerms.getRight());
	}

	@Override
	public void addPermission(Triple<User, User, Permission> providerToSubscriberOfPerms) {
		getDomainService().addPermission(
				providerToSubscriberOfPerms.getLeft(), 
				providerToSubscriberOfPerms.getMiddle(), 
				providerToSubscriberOfPerms.getRight());
	}

	@Override
	public void removePermission(Triple<User, User, Permission> providerToSubscriberOfPerms) {
		getDomainService().removePermission(
				providerToSubscriberOfPerms.getLeft(), 
				providerToSubscriberOfPerms.getMiddle(), 
				providerToSubscriberOfPerms.getRight());
	}

	@Override
	public void removeAllPermissions(KeyValuePair<User, User> providerToSubscriber) {
		getDomainService().removeAllPermissions(providerToSubscriber.getKey(), providerToSubscriber.getValue());
	}

}
