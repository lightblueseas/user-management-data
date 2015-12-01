package de.alpharogroup.user.management.service;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.user.management.daos.ContactmethodsDao;
import de.alpharogroup.user.management.entities.Contactmethods;
import de.alpharogroup.user.management.entities.Users;
import de.alpharogroup.user.management.enums.ContactmethodType;
import de.alpharogroup.user.management.service.api.ContactmethodsService;
import de.alpharogroup.user.management.service.util.HqlStringCreator;

@Transactional
@Service("contactmethodsService")
public class ContactmethodsBusinessService extends AbstractBusinessService<Contactmethods, Integer, ContactmethodsDao> implements ContactmethodsService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setContactmethodsDao(ContactmethodsDao contactmethodsDao) {
		setDao(contactmethodsDao);
	}
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean compare(final Contactmethods contact,
			final Contactmethods compare) {
		if(contact == null && compare != null) {
			return false;
		}
		if(contact == null && compare == null) {
			return true;
		}
		if(contact != null && compare == null) {
			return false;
		}
		if(contact.getContactvalue() == null && compare.getContactvalue() != null) {
			return false;
		}
		if(contact.getContactvalue() == null && compare.getContactvalue() == null) {
			return true;
		}
		if(contact.getContactvalue() != null && compare.getContactvalue() == null) {
			return false;
		}
		return contact.getContactmethod().equals(compare.getContactmethod())
				&& contact.getContactvalue().equals(compare.getContactvalue());
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean existsContact(final Contactmethods contact) {
		return existsContact(contact.getContactvalue(),
				contact.getContactmethod());
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean existsContact(final String contactValue,
			final ContactmethodType contactMethod) {
		final List<Contactmethods> contacts = findContact(contactValue,
				contactMethod);
		if (null != contacts && !contacts.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Contactmethods> findContact(final String contactValue,
			final ContactmethodType contactMethod) {
		return find(contactMethod, contactValue);
	}
	
	@SuppressWarnings("unchecked")
	public List<Contactmethods> find(final ContactmethodType contactmethod, final String contactvalue) {
		String hqlString = HqlStringCreator.forContactmethods(contactmethod, contactvalue);
		final Query query = getQuery(hqlString);
		if(contactmethod != null){
			query.setParameter("contactmethod", contactmethod);
		}
		if(contactvalue != null){
			query.setParameter("contactvalue", contactvalue);
		}
		final List<Contactmethods> contactmethods = query.getResultList();
		return contactmethods;
	}
	
	@SuppressWarnings("unchecked")
	public List<Contactmethods> findContactmethod(final ContactmethodType contactmethod, final Users user) {
		final String hqlString = 
				  "select distinct cm from Users u inner join u.userData.contactmethods cm "
				+ "where u=:user "
				+ "and cm.contactmethod.contactmethod=:contactmethod";
		final Query query = getQuery(hqlString);
		if(user != null){
			query.setParameter("user", user);
		}
		if(contactmethod != null){
			query.setParameter("contactmethod", contactmethod);
		}
		final List<Contactmethods> contactmethods = query.getResultList();
		return contactmethods;		
	}

}