package de.alpharogroup.user.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import de.alpharogroup.service.domain.AbstractDomainService;
import de.alpharogroup.user.management.daos.PermissionsDao;
import de.alpharogroup.user.management.domain.Permission;
import de.alpharogroup.user.management.entities.Permissions;
import de.alpharogroup.user.management.mapper.PermissionsMapper;
import de.alpharogroup.user.management.service.api.PermissionService;
import de.alpharogroup.user.management.service.api.PermissionsService;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link PermissionDomainService}.
 */
public class PermissionDomainService
		extends AbstractDomainService<Integer, Permission, Permissions, PermissionsDao, PermissionsMapper>
		implements PermissionService {

	/** The {@link PermissionsService}. */
	@Autowired
	@Getter
	@Setter
	private PermissionsService permissionsService;

	/**
	 * Sets the specific {@link PermissionsDao}.
	 *
	 * @param permissionsDao
	 *            the new {@link PermissionsDao}.
	 */
	@Autowired
	public void setPermissionsDao(PermissionsDao permissionsDao) {
		setDao(permissionsDao);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Permission createAndSavePermissions(String name, String description) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Permission createAndSavePermissions(String name, String description, String shortcut) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Permission findByShortcut(String shortcut) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Permission findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Permission> find(String description, String permissionName, String shortcut) {
		// TODO Auto-generated method stub
		return null;
	}

}
