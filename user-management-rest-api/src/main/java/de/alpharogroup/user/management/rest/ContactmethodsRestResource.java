package de.alpharogroup.user.management.rest;


import java.util.List;

import de.alpharogroup.collections.pairs.KeyValuePair;
import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.user.management.domain.Contactmethod;
import de.alpharogroup.user.management.domain.User;
import de.alpharogroup.user.management.enums.ContactmethodType;
import de.alpharogroup.user.management.rest.api.ContactmethodsResource;
import de.alpharogroup.user.management.service.api.ContactmethodService;

/**
 * The class {@link ContactmethodsRestResource} .
 */
public class ContactmethodsRestResource
	extends
		AbstractRestfulResource<Integer, Contactmethod, ContactmethodService>
	implements
		ContactmethodsResource
{

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean compare(final KeyValuePair<Contactmethod, Contactmethod> comparison)
	{
		boolean result = getDomainService().compare(comparison.getKey(), comparison.getValue());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existsContact(final String contact)
	{
//		boolean result = getDomainService().existsContact(contact);
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existsContact(final String contactValue, final ContactmethodType contactMethod)
	{
		boolean result = getDomainService().existsContact(contactValue, contactMethod);
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethod> findContact(String contactValue, ContactmethodType contactMethod) {		
		return getDomainService().findContact(contactValue, contactMethod);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethod> find(ContactmethodType contactmethod, String contactvalue) {
		return getDomainService().find(contactmethod, contactvalue);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethod> findContactmethod(ContactmethodType contactmethod, User user) {
		return getDomainService().findContactmethod(contactmethod, user);
	}

}
