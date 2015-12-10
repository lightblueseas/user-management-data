package de.alpharogroup.user.management.rest;


import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.user.management.domain.RelationPermission;
import de.alpharogroup.user.management.rest.api.RelationPermissionsResource;
import de.alpharogroup.user.management.service.api.RelationPermissionService;

public class RelationPermissionsRestResource
	extends
		AbstractRestfulResource<Integer, RelationPermission, RelationPermissionService>
	implements
	RelationPermissionsResource
{

}
