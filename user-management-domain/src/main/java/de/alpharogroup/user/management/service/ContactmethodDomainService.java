package de.alpharogroup.user.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.service.domain.AbstractDomainService;
import de.alpharogroup.user.management.daos.ContactmethodsDao;
import de.alpharogroup.user.management.domain.Contactmethod;
import de.alpharogroup.user.management.domain.User;
import de.alpharogroup.user.management.entities.Contactmethods;
import de.alpharogroup.user.management.entities.Users;
import de.alpharogroup.user.management.enums.ContactmethodType;
import de.alpharogroup.user.management.mapper.ContactmethodsMapper;
import de.alpharogroup.user.management.service.api.ContactmethodService;
import de.alpharogroup.user.management.service.api.ContactmethodsService;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link ContactmethodDomainService}.
 */
@Transactional
@Service("contactmethodDomainService")
public class ContactmethodDomainService
		extends AbstractDomainService<Integer, Contactmethod, Contactmethods, ContactmethodsDao, ContactmethodsMapper>
		implements ContactmethodService {

	/** The {@link ContactmethodsService}. */
	@Autowired
	@Getter
	@Setter
	private ContactmethodsService contactmethodsService;

	/**
	 * Sets the specific {@link ContactmethodsDao}.
	 *
	 * @param contactmethodsDao
	 *            the new {@link ContactmethodsDao}.
	 */
	@Autowired
	public void setContactmethodsDao(final ContactmethodsDao contactmethodsDao){
		setDao(contactmethodsDao);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean compare(final Contactmethod contact, final Contactmethod compare) {
		return contactmethodsService.compare(getMapper().toEntity(contact), getMapper().toEntity(compare));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existsContact(final Contactmethod contact) {
		return contactmethodsService.existsContact(getMapper().toEntity(contact));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existsContact(final String contactValue, final ContactmethodType contactMethod) {
		return contactmethodsService.existsContact(contactValue, contactMethod);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethod> findContact(final String contactValue, final ContactmethodType contactMethod) {
		return getMapper().toDomainObjects(contactmethodsService.findContact(contactValue, contactMethod));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethod> find(final ContactmethodType contactmethod, final String contactvalue) {
		return getMapper().toDomainObjects(contactmethodsService.find(contactmethod, contactvalue));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Contactmethod> findContactmethod(final ContactmethodType contactmethod, final User user) {
		final Users users = getMapper().map(user, Users.class);
		return getMapper().toDomainObjects(contactmethodsService.findContactmethod(contactmethod, users));
	}

}
