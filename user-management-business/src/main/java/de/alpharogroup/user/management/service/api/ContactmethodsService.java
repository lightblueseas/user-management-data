package de.alpharogroup.user.management.service.api;

import java.util.List;

import de.alpharogroup.db.service.jpa.BusinessService;
import de.alpharogroup.user.management.entities.Contactmethods;
import de.alpharogroup.user.management.entities.Users;
import de.alpharogroup.user.management.enums.Contactmethod;

/**
 * The Interface ContactmethodsService.
 */
public interface ContactmethodsService extends BusinessService<Contactmethods, Integer>{
	
	/**
	 * Compare.
	 * 
	 * @param contact
	 *            the contact
	 * @param compare
	 *            the compare
	 * @return true, if successful
	 */
	boolean compare(Contactmethods contact, Contactmethods compare);

	/**
	 * Exists contact.
	 * 
	 * @param contact
	 *            the contact
	 * @return true, if successful
	 */
	boolean existsContact(Contactmethods contact);

	/**
	 * Exists contact.
	 * 
	 * @param contactValue
	 *            the contact value
	 * @param contactMethod
	 *            the contact method
	 * @return true, if successful
	 */
	boolean existsContact(String contactValue,
			Contactmethod contactMethod);

	/**
	 * Find contact.
	 * 
	 * @param contactValue
	 *            the contact value
	 * @param contactMethod
	 *            the contact method
	 * @return the list
	 */
	List<Contactmethods> findContact(String contactValue,
			Contactmethod contactMethod);

	/**
	 * Find contact.
	 *
	 * @param contactmethod the contactmethod
	 * @param contactvalue the contactvalue
	 * @return the list
	 */
	List<Contactmethods> find(final Contactmethod contactmethod, final String contactvalue);
	
	List<Contactmethods> findContactmethod(final Contactmethod contactmethod, final Users user);
}