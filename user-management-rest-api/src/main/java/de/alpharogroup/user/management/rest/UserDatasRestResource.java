package de.alpharogroup.user.management.rest;


import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.user.management.domain.UserData;
import de.alpharogroup.user.management.rest.api.UserDatasResource;
import de.alpharogroup.user.management.service.api.UserDataService;

public class UserDatasRestResource
	extends
		AbstractRestfulResource<Integer, UserData, UserDataService>
	implements UserDatasResource
{

}
