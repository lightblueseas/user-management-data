package de.alpharogroup.user.management.rest;


import java.util.List;

import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.user.management.domain.Permission;
import de.alpharogroup.user.management.rest.api.PermissionsResource;
import de.alpharogroup.user.management.service.api.PermissionService;

/**
 * The class {@link PermissionsRestResource} .
 */
public class PermissionsRestResource
	extends
		AbstractRestfulResource<Integer, Permission, PermissionService>
	implements
		PermissionsResource
{

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Permission createAndSavePermissions(String name, String description) {
		return getDomainService().createAndSavePermissions(name, description);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Permission createAndSavePermissions(String name, String description, String shortcut) {
		return getDomainService().createAndSavePermissions(name, description, shortcut);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Permission findByShortcut(String shortcut) {
		return getDomainService().findByShortcut(shortcut);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Permission findByName(String name) {
		return getDomainService().findByName(name);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Permission> find(String description, String name, String shortcut) {
		return getDomainService().find(description, name, shortcut);
	}

}
