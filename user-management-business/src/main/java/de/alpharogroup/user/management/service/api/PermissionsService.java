package de.alpharogroup.user.management.service.api;

import java.util.List;

import de.alpharogroup.db.service.jpa.BusinessService;
import de.alpharogroup.user.management.entities.Permissions;

public interface PermissionsService extends
		BusinessService<Permissions, Integer> {

	Permissions createAndSavePermissions(String name, String description);

	Permissions createAndSavePermissions(String name, String description,
			String shortcut);
	
	Permissions findByShortcut(String shortcut);
	
	Permissions findByName(String name);

	List<Permissions> find(String description, String permissionName,
			String shortcut);
}