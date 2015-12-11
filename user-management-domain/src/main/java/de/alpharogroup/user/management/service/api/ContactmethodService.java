package de.alpharogroup.user.management.service.api;

import java.util.List;

import de.alpharogroup.service.domain.DomainService;
import de.alpharogroup.user.management.domain.Contactmethod;
import de.alpharogroup.user.management.domain.User;
import de.alpharogroup.user.management.enums.ContactmethodType;

/**
 * The interface {@link ContactmethodService}.
 */
public interface ContactmethodService extends DomainService<Integer, Contactmethod>  {
	
	/**
	 * Compare the given {@link Contactmethod} objects.
	 * 
	 * @param contact
	 *            the contact
	 * @param compare
	 *            the compare
	 * @return true, if successful
	 */
	boolean compare(Contactmethod contact, Contactmethod compare);

	/**
	 * Check if a contact exist with given {@link Contactmethod}.
	 * 
	 * @param contact
	 *            the contact
	 * @return true, if successful
	 */
	boolean existsContact(Contactmethod contact);

	/**
	 * Check if a contact exist with given contact value and the given {@link ContactmethodType}.
	 * 
	 * @param contactValue
	 *            the contact value
	 * @param contactMethod
	 *            the contact method
	 * @return true, if successful
	 */
	boolean existsContact(String contactValue,
			ContactmethodType contactMethod);

	/**
	 * Find all the {@link Contactmethod} objects from the given contact value and the given {@link ContactmethodType}.
	 * 
	 * @param contactValue
	 *            the contact value
	 * @param contactMethod
	 *            the contact method
	 * @return the list of the found {@link Contactmethod} objects.
	 */
	List<Contactmethod> findContact(String contactValue,
			ContactmethodType contactMethod);

	/**
	 * Find all the {@link Contactmethod} objects from the given contact value and the given {@link ContactmethodType}.
	 *
	 * @param contactmethod the contact method
	 * @param contactvalue the contact value
	 * @return the list of the found {@link Contactmethod} objects.
	 */
	List<Contactmethod> find(final ContactmethodType contactmethod, final String contactvalue);
	
	/**
	 * Find all the {@link Contactmethod} objects from the given user and the given {@link ContactmethodType}.
	 *
	 * @param contactmethod the contact method
	 * @param user the user
	 * @return the list of the found {@link Contactmethod} objects.
	 */
	List<Contactmethod> findContactmethod(final ContactmethodType contactmethod, final User user);
}