package de.alpharogroup.user.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.service.domain.AbstractDomainService;
import de.alpharogroup.user.management.daos.UserCreditsDao;
import de.alpharogroup.user.management.domain.UserCredit;
import de.alpharogroup.user.management.entities.UserCredits;
import de.alpharogroup.user.management.mapper.UserCreditsMapper;
import de.alpharogroup.user.management.service.api.UserCreditService;
import de.alpharogroup.user.management.service.api.UserCreditsService;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link UserCreditDomainService}.
 */
@Transactional
@Service("userCreditDomainService")
public class UserCreditDomainService
		extends AbstractDomainService<Integer, UserCredit, UserCredits, UserCreditsDao, UserCreditsMapper>
		implements UserCreditService {

	/** The {@link UserCreditsService}. */
	@Autowired
	@Getter
	@Setter
	private UserCreditsService userCreditsService;

	/**
	 * Sets the specific {@link UserCreditsDao}.
	 *
	 * @param userCreditsDao
	 *            the new {@link UserCreditsDao}.
	 */
	@Autowired
	public void setUserCreditsDao(final UserCreditsDao userCreditsDao) {
		setDao(userCreditsDao);
	}

	/**
	 * Sets the specific {@link UserCreditsMapper}.
	 *
	 * @param mapper
	 *            the new {@link UserCreditsMapper}.
	 */
	@Autowired
	public void setUserCreditsMapper(UserCreditsMapper mapper) {
		setMapper(mapper);
	}
	
}
