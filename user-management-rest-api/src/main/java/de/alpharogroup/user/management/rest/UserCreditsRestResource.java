package de.alpharogroup.user.management.rest;


import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.user.management.domain.UserCredit;
import de.alpharogroup.user.management.rest.api.UserCreditsResource;
import de.alpharogroup.user.management.service.api.UserCreditService;

public class UserCreditsRestResource
	extends
		AbstractRestfulResource<Integer, UserCredit, UserCreditService>
	implements
		UserCreditsResource
{

}
