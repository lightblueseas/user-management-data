package de.alpharogroup.user.management.rest;


import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.user.management.domain.User;
import de.alpharogroup.user.management.rest.api.UsersResource;
import de.alpharogroup.user.management.service.api.UserService;

public class UsersRestResource
	extends
 AbstractRestfulResource<Integer, User, UserService>
	implements
		UsersResource
{

}
