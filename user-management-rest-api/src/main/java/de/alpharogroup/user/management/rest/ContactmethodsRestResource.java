package de.alpharogroup.user.management.rest;


import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.user.management.domain.Contactmethod;
import de.alpharogroup.user.management.rest.api.ContactmethodsResource;
import de.alpharogroup.user.management.service.api.ContactmethodService;

public class ContactmethodsRestResource
	extends
		AbstractRestfulResource<Integer, Contactmethod, ContactmethodService>
	implements
		ContactmethodsResource
{

}
