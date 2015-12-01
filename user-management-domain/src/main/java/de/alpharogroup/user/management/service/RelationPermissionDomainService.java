package de.alpharogroup.user.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import de.alpharogroup.service.domain.AbstractDomainService;
import de.alpharogroup.user.management.daos.RelationPermissionsDao;
import de.alpharogroup.user.management.domain.Permission;
import de.alpharogroup.user.management.domain.RelationPermission;
import de.alpharogroup.user.management.domain.User;
import de.alpharogroup.user.management.entities.RelationPermissions;
import de.alpharogroup.user.management.mapper.RelationPermissionsMapper;
import de.alpharogroup.user.management.service.api.RelationPermissionService;
import de.alpharogroup.user.management.service.api.RelationPermissionsService;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link RelationPermissionDomainService}.
 */
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
	public void setRelationPermissionsDao(RelationPermissionsDao relationPermissionsDao) {
		setDao(relationPermissionsDao);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RelationPermission findRelationPermissions(User provider, User subscriber) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RelationPermission findRelationPermissions(User provider, User subscriber, Permission permission) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<RelationPermission> find(User provider, User subscriber) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<RelationPermission> find(User provider, User subscriber, Permission permission) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addPermission(User provider, User subscriber, Permission permission) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removePermission(User provider, User subscriber, Permission permission) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeAllPermissions(User provider, User subscriber) {
		// TODO Auto-generated method stub
		
	}

}
