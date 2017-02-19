package de.alpharogroup.user.management.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.service.domain.AbstractDomainService;
import de.alpharogroup.user.repositories.RolesDao;
import de.alpharogroup.user.management.domain.Permission;
import de.alpharogroup.user.management.domain.Role;
import de.alpharogroup.user.entities.Permissions;
import de.alpharogroup.user.entities.Roles;
import de.alpharogroup.user.management.mapper.RolesMapper;
import de.alpharogroup.user.management.service.api.RoleService;
import de.alpharogroup.user.management.service.api.RolesService;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link RoleDomainService}.
 */
@Transactional
@Service("roleDomainService")
public class RoleDomainService extends AbstractDomainService<Integer, Role, Roles, RolesDao, RolesMapper>
		implements RoleService {

	/** The {@link RolesService}. */
	@Autowired
	@Getter
	@Setter
	private RolesService rolesService;

	/**
	 * Sets the specific {@link RolesDao}.
	 *
	 * @param rolesDao
	 *            the new {@link RolesDao}.
	 */
	@Autowired
	public void setRolesDao(final RolesDao rolesDao) {
		setDao(rolesDao);
	}

	/**
	 * Sets the specific {@link RolesMapper}.
	 *
	 * @param mapper
	 *            the new {@link RolesMapper}.
	 */
	@Autowired
	public void setRolesMapper(RolesMapper mapper) {
		setMapper(mapper);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Permission> findAllPermissions(final Role role) {
		final Roles roles = getMapper().toEntity(role);
		final List<Permissions> permissions = rolesService.findAllPermissions(roles);
		final List<Permission> perms = getMapper().map(permissions, Permission.class);
		return perms;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Role findRole(final String rolename) {
		return getMapper().toDomainObject(rolesService.findRole(rolename));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Role> findRoles(final String rolename) {
		return getMapper().toDomainObjects(rolesService.findRoles(rolename));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(final String rolename) {
		return rolesService.exists(rolename);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Role createAndSaveRole(final String rolename, final String description) {
		return getMapper().toDomainObject(rolesService.createAndSaveRole(rolename, description));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Role createAndSaveRole(final String rolename, final String description, final Set<Permission> permissions) {
		final List<Permissions> perms = getMapper().map(permissions, Permissions.class);
		final Roles roles = rolesService.createAndSaveRole(rolename, description, new HashSet<>(perms));
		return getMapper().toDomainObject(roles);
	}

}
