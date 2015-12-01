package de.alpharogroup.user.management.service.api;

import java.util.List;

import de.alpharogroup.service.domain.DomainService;
import de.alpharogroup.user.management.domain.Permission;

/**
 * The interface {@link PermissionService}.
 */
public interface PermissionService extends DomainService<Integer, Permission> {

	/**
	 * Factory method to create and save a new {@link Permission} object.
	 *
	 * @param name the name
	 * @param description the description
	 * @return the new {@link Permission} object.
	 */
	Permission createAndSavePermissions(String name, String description);

	/**
	 * Factory method to create and save a new {@link Permission} object.
	 *
	 * @param name the name
	 * @param description the description
	 * @param shortcut the shortcut
	 * @return the new {@link Permission} object.
	 */
	Permission createAndSavePermissions(String name, String description,
			String shortcut);
	
	/**
	 * Find the {@link Permission} object by the given shortcut.
	 *
	 * @param shortcut the shortcut
	 * @return the found {@link Permission} object or null if not.
	 */
	Permission findByShortcut(String shortcut);
	
	/**
	 * Find the {@link Permission} object by the given name.
	 *
	 * @param name the name
	 * @return the found {@link Permission} object or null if not.
	 */
	Permission findByName(String name);

	/**
	 * Find all {@link Permission} objects by the given parameters.
	 *
	 * @param description the description
	 * @param permissionName the permission name
	 * @param shortcut the shortcut
	 * @return the list of the found {@link Permission} objects.
	 */
	List<Permission> find(String description, String permissionName,
			String shortcut);
}
