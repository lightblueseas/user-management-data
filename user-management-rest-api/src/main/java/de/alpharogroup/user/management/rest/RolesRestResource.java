package de.alpharogroup.user.management.rest;


import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.user.management.domain.Role;
import de.alpharogroup.user.management.rest.api.RolesResource;
import de.alpharogroup.user.management.service.api.RoleService;

public class RolesRestResource
	extends
 AbstractRestfulResource<Integer, Role, RoleService>
	implements
		RolesResource
{

}
