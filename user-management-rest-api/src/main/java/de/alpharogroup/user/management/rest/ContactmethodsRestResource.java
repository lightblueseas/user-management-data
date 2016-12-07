package de.alpharogroup.user.management.rest;


import java.util.List;

import de.alpharogroup.collections.pairs.KeyValuePair;
import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.service.rs.Securable;
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
    @Securable
	public boolean existsContact(KeyValuePair<String, ContactmethodType> contactMethod) {
		boolean result = getDomainService().existsContact(contactMethod.getKey(), contactMethod.getValue());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */

	@Override
	public List<Contactmethod> findContact(KeyValuePair<String, ContactmethodType> contactMethod) {	
		return getDomainService().findContact(contactMethod.getKey(), contactMethod.getValue());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethod> find(KeyValuePair<String, ContactmethodType> contactMethod) {
		return getDomainService().find(contactMethod.getValue(), contactMethod.getKey());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethod> findContactmethod(KeyValuePair<ContactmethodType, User> contactMethodsFromUser) {
		return getDomainService().findContactmethod(contactMethodsFromUser.getKey(), contactMethodsFromUser.getValue());
	}


}
