package de.alpharogroup.user.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.service.domain.AbstractDomainService;
import de.alpharogroup.user.management.daos.RelationPermissionsDao;
import de.alpharogroup.user.management.domain.Permission;
import de.alpharogroup.user.management.domain.RelationPermission;
import de.alpharogroup.user.management.domain.User;
import de.alpharogroup.user.management.entities.Permissions;
import de.alpharogroup.user.management.entities.RelationPermissions;
import de.alpharogroup.user.management.entities.Users;
import de.alpharogroup.user.management.mapper.RelationPermissionsMapper;
import de.alpharogroup.user.management.service.api.RelationPermissionService;
import de.alpharogroup.user.management.service.api.RelationPermissionsService;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link RelationPermissionDomainService}.
 */
@Transactional
@Service("relationPermissionDomainService")
public class RelationPermissionDomainService extends
		AbstractDomainService<Integer, RelationPermission, RelationPermissions, RelationPermissionsDao, RelationPermissionsMapper>
		implements RelationPermissionService {

	/** The {@link RelationPermissionsService}. */
	@Autowired
	@Getter
	@Setter
	private RelationPermissionsService relationPermissionsService;

	/**
	 * Sets the specific {@link RelationPermissionsDao}.
	 *
	 * @param relationPermissionsDao
	 *            the new {@link RelationPermissionsDao}.
	 */
	@Autowired
	public void setRelationPermissionsDao(final RelationPermissionsDao relationPermissionsDao) {
		setDao(relationPermissionsDao);
	}

	/**
	 * Sets the specific {@link RelationPermissionsMapper}.
	 *
	 * @param mapper
	 *            the new {@link RelationPermissionsMapper}.
	 */
	@Autowired
	public void setRelationPermissionsMapper(RelationPermissionsMapper mapper) {
		setMapper(mapper);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public RelationPermission findRelationPermissions(final User provider, final User subscriber) {
		final Users providers = getMapper().map(provider, Users.class);
		final Users subscribers = getMapper().map(subscriber, Users.class);
		final RelationPermission relationPermission = getMapper().toDomainObject(relationPermissionsService.findRelationPermissions(providers, subscribers));
		return relationPermission;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RelationPermission findRelationPermissions(final User provider, final User subscriber, final Permission permission) {
		final Users providers = getMapper().map(provider, Users.class);
		final Users subscribers = getMapper().map(subscriber, Users.class);
		final Permissions permissions = getMapper().map(permission, Permissions.class);
		final RelationPermission relationPermission = getMapper().toDomainObject(relationPermissionsService.findRelationPermissions(providers, subscribers, permissions));
		return relationPermission;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<RelationPermission> find(final User provider, final User subscriber) {
		final Users providers = getMapper().map(provider, Users.class);
		final Users subscribers = getMapper().map(subscriber, Users.class);
		final List<RelationPermission> relationPermissions = getMapper().toDomainObjects(relationPermissionsService.find(providers, subscribers));
		return relationPermissions;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<RelationPermission> find(final User provider, final User subscriber, final Permission permission) {
		final Users providers = getMapper().map(provider, Users.class);
		final Users subscribers = getMapper().map(subscriber, Users.class);
		final Permissions permissions = getMapper().map(permission, Permissions.class);
		final List<RelationPermission> relationPermissions = getMapper().toDomainObjects(relationPermissionsService.find(providers, subscribers, permissions));
		return relationPermissions;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addPermission(final User provider, final User subscriber, final Permission permission) {
		final Users providers = getMapper().map(provider, Users.class);
		final Users subscribers = getMapper().map(subscriber, Users.class);
		final Permissions permissions = getMapper().map(permission, Permissions.class);
		relationPermissionsService.addPermission(providers, subscribers, permissions);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removePermission(final User provider, final User subscriber, final Permission permission) {
		final Users providers = getMapper().map(provider, Users.class);
		final Users subscribers = getMapper().map(subscriber, Users.class);
		final Permissions permissions = getMapper().map(permission, Permissions.class);
		relationPermissionsService.removePermission(providers, subscribers, permissions);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeAllPermissions(final User provider, final User subscriber) {
		final Users providers = getMapper().map(provider, Users.class);
		final Users subscribers = getMapper().map(subscriber, Users.class);
		relationPermissionsService.removeAllPermissions(providers, subscribers);
	}

}
