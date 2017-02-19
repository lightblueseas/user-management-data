package de.alpharogroup.user.management.service;

import java.util.List;

import javax.persistence.Query;

import de.alpharogroup.collections.ListExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.user.repositories.PermissionsDao;
import de.alpharogroup.user.entities.Permissions;
import de.alpharogroup.user.management.factories.UserManagementFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.user.management.service.api.PermissionsService;
import de.alpharogroup.user.management.service.util.HqlStringCreator;

@Transactional
@Service("permissionsService")
public class PermissionsBusinessService extends
		AbstractBusinessService<Permissions, Integer, PermissionsDao> implements
		PermissionsService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setPermissionsDao(PermissionsDao permissionsDao) {
		setDao(permissionsDao);
	}

	@Override
	public Permissions createAndSavePermissions(String name, String description) {
		return createAndSavePermissions(name, description, null);
	}

	@Override
	public Permissions createAndSavePermissions(String name,
			String description, String shortcut) {
		Permissions permissions = UserManagementFactory.getInstance()
				.newPermissions(name, description, shortcut);
		permissions = merge(permissions);
		return permissions;
	}
	
	public Permissions findByShortcut(String shortcut) {
		return ListExtensions.getFirst(find(null, null, shortcut));
	}
	
	public Permissions findByName(String name) {
		return ListExtensions.getFirst(find(null, name, null));
	}
	
	@SuppressWarnings("unchecked")
	public List<Permissions> find(String description, String permissionName, String shortcut) {
		String hqlString = HqlStringCreator.forPermissions(description, permissionName, shortcut);
		final Query query = getQuery(hqlString);
		if(description != null){
			query.setParameter("description", description);
		}
		if(permissionName != null){
			query.setParameter("permissionName", permissionName);
		}
		if(shortcut != null){
			query.setParameter("shortcut", shortcut);			
		}
		final List<Permissions> permissions = query.getResultList();
		return permissions;
	}

}