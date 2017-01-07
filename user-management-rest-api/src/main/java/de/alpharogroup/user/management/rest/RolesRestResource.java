package de.alpharogroup.user.management.rest;


import java.util.List;
import java.util.Set;

import de.alpharogroup.collections.pairs.KeyValuePair;
import de.alpharogroup.collections.pairs.Triple;
import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.user.management.domain.Permission;
import de.alpharogroup.user.management.domain.Role;
import de.alpharogroup.user.management.rest.api.RolesResource;
import de.alpharogroup.user.management.service.api.RoleService;

public class RolesRestResource
	extends
 AbstractRestfulResource<Integer, Role, RoleService>
	implements
		RolesResource
{

	@Override
	public List<Permission> findAllPermissions(Role role) {
		return getDomainService().findAllPermissions(role);
	}

	@Override
	public Role findRole(String rolename) {
		return getDomainService().findRole(rolename);
	}

	@Override
	public List<Role> findRoles(String rolename) {
		return getDomainService().findRoles(rolename);
	}

	@Override
	public boolean exists(String rolename) {
		return getDomainService().exists(rolename);
	}

	@Override
	public Role createAndSaveRole(KeyValuePair<String, String> newRole) {
		return getDomainService().createAndSaveRole(newRole.getKey(), newRole.getValue());
	}

	@Override
	public Role createAndSaveRole(Triple<String, String, Set<Permission>> roleToCreate) {
		return getDomainService().createAndSaveRole(
				roleToCreate.getLeft(), roleToCreate.getMiddle(), roleToCreate.getRight());
	}

}
