package de.alpharogroup.user.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
@Service("permissionDomainService")
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
	public void setPermissionsDao(final PermissionsDao permissionsDao) {
		setDao(permissionsDao);
	}

	/**
	 * Sets the specific {@link PermissionsMapper}.
	 *
	 * @param mapper
	 *            the new {@link PermissionsMapper}.
	 */
	@Autowired
	public void setPermissionsMapper(PermissionsMapper mapper) {
		setMapper(mapper);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Permission createAndSavePermissions(final String name, final String description) {
		return getMapper().toDomainObject(permissionsService.createAndSavePermissions(name, description));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Permission createAndSavePermissions(final String name, final String description, final String shortcut) {
		return getMapper().toDomainObject(permissionsService.createAndSavePermissions(name, description, shortcut));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Permission findByShortcut(final String shortcut) {
		return getMapper().toDomainObject(permissionsService.findByShortcut(shortcut));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Permission findByName(final String name) {
		return getMapper().toDomainObject(permissionsService.findByName(name));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Permission> find(final String description, final String permissionName, final String shortcut) {
		return getMapper().toDomainObjects(permissionsService.find(description, permissionName, shortcut));
	}

}
