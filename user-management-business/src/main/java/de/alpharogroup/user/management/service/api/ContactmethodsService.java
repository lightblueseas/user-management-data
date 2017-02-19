package de.alpharogroup.user.management.service.api;

import java.util.List;

import de.alpharogroup.db.service.api.BusinessService;
import de.alpharogroup.user.management.entities.Contactmethods;
import de.alpharogroup.user.entities.Users;
import de.alpharogroup.user.management.enums.ContactmethodType;

/**
 * The interface {@link ContactmethodsService}.
 */
public interface ContactmethodsService extends BusinessService<Contactmethods, Integer>{
	
	/**
	 * Compare the given {@link Contactmethods} objects.
	 * 
	 * @param contact
	 *            the contact
	 * @param compare
	 *            the compare
	 * @return true, if successful
	 */
	boolean compare(Contactmethods contact, Contactmethods compare);

	/**
	 * Check if a contact exist with given {@link Contactmethods}.
	 * 
	 * @param contact
	 *            the contact
	 * @return true, if successful
	 */
	boolean existsContact(Contactmethods contact);

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
	 * Find all the {@link Contactmethods} objects from the given contact value and the given {@link ContactmethodType}.
	 * 
	 * @param contactValue
	 *            the contact value
	 * @param contactMethod
	 *            the contact method
	 * @return the list of the found {@link Contactmethods} objects.
	 */
	List<Contactmethods> findContact(String contactValue,
			ContactmethodType contactMethod);

	/**
	 * Find all the {@link Contactmethods} objects from the given contact value and the given {@link ContactmethodType}.
	 *
	 * @param contactmethod the contact method
	 * @param contactvalue the contact value
	 * @return the list of the found {@link Contactmethods} objects.
	 */
	List<Contactmethods> find(final ContactmethodType contactmethod, final String contactvalue);

	/**
	 * Find all the {@link Contactmethods} objects from the given user and the given {@link ContactmethodType}.
	 *
	 * @param contactmethod the contact method
	 * @param user the user
	 * @return the list of the found {@link Contactmethods} objects.
	 */
	List<Contactmethods> findContactmethod(final ContactmethodType contactmethod, final Users user);
}