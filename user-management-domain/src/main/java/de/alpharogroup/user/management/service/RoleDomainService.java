package de.alpharogroup.user.management.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import de.alpharogroup.service.domain.AbstractDomainService;
import de.alpharogroup.user.management.daos.RolesDao;
import de.alpharogroup.user.management.domain.Permission;
import de.alpharogroup.user.management.domain.Role;
import de.alpharogroup.user.management.entities.Permissions;
import de.alpharogroup.user.management.entities.Roles;
import de.alpharogroup.user.management.mapper.RolesMapper;
import de.alpharogroup.user.management.service.api.RoleService;
import de.alpharogroup.user.management.service.api.RolesService;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link RoleDomainService}.
 */
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
	public void setRolesDao(RolesDao rolesDao) {
		setDao(rolesDao);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Permission> findAllPermissions(Role role) {
		Roles roles = getMapper().toEntity(role);
		List<Permissions> permissions = rolesService.findAllPermissions(roles);
		List<Permission> perms = getMapper().map(permissions, Permission.class);
		return perms;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Role findRole(String rolename) {
		return getMapper().toDomainObject(rolesService.findRole(rolename));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Role> findRoles(String rolename) {
		return getMapper().toDomainObjects(rolesService.findRoles(rolename));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(String rolename) {
		return rolesService.exists(rolename);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Role createAndSaveRole(String rolename, String description) {
		return getMapper().toDomainObject(rolesService.createAndSaveRole(rolename, description));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Role createAndSaveRole(String rolename, String description, Set<Permission> permissions) {
		List<Permissions> perms = getMapper().map(permissions, Permissions.class);
		Roles roles = rolesService.createAndSaveRole(rolename, description, new HashSet<>(perms));
		return getMapper().toDomainObject(roles);
	}

}
