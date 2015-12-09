package de.alpharogroup.user.management.rest;


import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.user.management.domain.Permission;
import de.alpharogroup.user.management.rest.api.PermissionsResource;
import de.alpharogroup.user.management.service.api.PermissionService;

public class PermissionsRestResource
	extends
		AbstractRestfulResource<Integer, Permission, PermissionService>
	implements
		PermissionsResource
{

}
