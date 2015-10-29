package de.alpharogroup.user.management.service;

import java.util.List;

import javax.persistence.Query;

import de.alpharogroup.collections.ListExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.user.management.daos.RelationPermissionsDao;
import de.alpharogroup.user.management.entities.Permissions;
import de.alpharogroup.user.management.entities.RelationPermissions;
import de.alpharogroup.user.management.entities.Users;
import de.alpharogroup.user.management.factories.UserManagementFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.user.management.service.api.RelationPermissionsService;
import de.alpharogroup.user.management.service.util.HqlStringCreator;

@Transactional
@Service("relationPermissionsService")
public class RelationPermissionsBusinessService extends
		AbstractBusinessService<RelationPermissions, Integer, RelationPermissionsDao> implements
		RelationPermissionsService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setRelationPermissionsDao(RelationPermissionsDao relationPermissionsDao) {
		setDao(relationPermissionsDao);
	}
	
	public RelationPermissions findRelationPermissions(final Users provider, final Users subscriber) {
		return ListExtensions.getFirst(find(provider, subscriber));
	}
	
	public RelationPermissions findRelationPermissions(final Users provider, final Users subscriber, Permissions permission) {
		return ListExtensions.getFirst(find(provider, subscriber, permission));
	}
	
	public List<RelationPermissions> find(final Users provider, final Users subscriber) {
		return find(provider, subscriber, null);
	}
	
	@SuppressWarnings("unchecked")
	public List<RelationPermissions> find(final Users provider, final Users subscriber, Permissions permission) {
		final String hqlString = HqlStringCreator.forRelationPermissions(provider, subscriber, permission);
		final Query query = getQuery(hqlString);
		if(provider != null){
			query.setParameter("provider", provider);			
		}
		if(subscriber != null){
			query.setParameter("subscriber", subscriber);			
		}
		if(permission != null) {
			query.setParameter("permission", permission);			
		}
		List<RelationPermissions> list = query.getResultList();
		return list;
	}
	

	public void addPermission( Users provider, Users subscriber, Permissions permission) {
		RelationPermissions rp = findRelationPermissions(provider, subscriber, permission);
		if(rp == null) {
			rp = findRelationPermissions(provider, subscriber);
			if(rp == null) {
				rp = UserManagementFactory.getInstance().newRelationPermissions(provider, subscriber);
			}								
			rp.getPermissions().add(permission);
			merge(rp);
		}
	}	


	public void removePermission( Users provider, Users subscriber, Permissions permission) {
		RelationPermissions rp = findRelationPermissions(provider, subscriber, permission);
		if(rp != null) {
			rp.getPermissions().remove(permission);
			merge(rp);
		}
	}


	public void removeAllPermissions(Users provider, Users subscriber) {
		// delete all permissions that are given for both users
		RelationPermissions relationPermissions = findRelationPermissions(provider, subscriber);
		if(relationPermissions != null) {
			relationPermissions.setProvider(null);
			relationPermissions.setSubscriber(null);
			relationPermissions = merge(relationPermissions);
			delete(relationPermissions);
		}
		relationPermissions = findRelationPermissions(subscriber, provider);
		if(relationPermissions != null) {
			relationPermissions.setProvider(null);
			relationPermissions.setSubscriber(null);
			relationPermissions = merge(relationPermissions);
			delete(relationPermissions);
		}
	}
}