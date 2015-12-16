package de.alpharogroup.user.management.rest;


import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.user.management.domain.Contactmethod;
import de.alpharogroup.user.management.enums.ContactmethodType;
import de.alpharogroup.user.management.rest.api.ContactmethodsResource;
import de.alpharogroup.user.management.service.api.ContactmethodService;

public class ContactmethodsRestResource
	extends
		AbstractRestfulResource<Integer, Contactmethod, ContactmethodService>
	implements
		ContactmethodsResource
{

	@Override
	public boolean compare(final Contactmethod contact, final Contactmethod compare)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsContact(final Contactmethod contact)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsContact(final String contactValue, final ContactmethodType contactMethod)
	{
		// TODO Auto-generated method stub
		return false;
	}

}
