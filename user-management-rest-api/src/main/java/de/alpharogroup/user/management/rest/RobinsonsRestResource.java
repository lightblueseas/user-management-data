package de.alpharogroup.user.management.rest;


import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.user.management.domain.Robinson;
import de.alpharogroup.user.management.rest.api.RobinsonsResource;
import de.alpharogroup.user.management.service.api.RobinsonService;

public class RobinsonsRestResource
	extends
		AbstractRestfulResource<Integer, Robinson, RobinsonService>
	implements
 RobinsonsResource
{

}
