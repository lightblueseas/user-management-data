package de.alpharogroup.user.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.service.domain.AbstractDomainService;
import de.alpharogroup.user.domain.User;
import de.alpharogroup.user.entities.Users;
import de.alpharogroup.user.management.daos.UserDatasDao;
import de.alpharogroup.user.management.domain.UserData;
import de.alpharogroup.user.management.entities.UserDatas;
import de.alpharogroup.user.management.mapper.UserDatasMapper;
import de.alpharogroup.user.management.service.api.UserDataService;
import de.alpharogroup.user.management.service.api.UserDatasService;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link UserDataDomainService}.
 */
@Transactional
@Service("userDataDomainService")
public class UserDataDomainService extends
		AbstractDomainService<Integer, UserData, UserDatas, UserDatasDao, UserDatasMapper> implements UserDataService {

	/** The {@link UserDatasService}. */
	@Autowired
	@Getter
	@Setter
	private UserDatasService userDatasService;

	/**
	 * Sets the specific {@link UserDatasDao}.
	 *
	 * @param userDatasDao
	 *            the new {@link UserDatasDao}.
	 */
	@Autowired
	public void setUserDatasDao(final UserDatasDao userDatasDao) {
		setDao(userDatasDao);
	}

	/**
	 * Sets the specific {@link UserDatasMapper}.
	 *
	 * @param mapper
	 *            the new {@link UserDatasMapper}.
	 */
	@Autowired
	public void setUserDatasMapper(final UserDatasMapper mapper) {
		setMapper(mapper);
	}

	@Override
	public UserData findBy(final User user)
	{
		final Users userEntity = getMapper().map(user, Users.class);
		final UserData userData = getMapper().toDomainObject(userDatasService.findBy(userEntity));
		return userData;
	}

	@Override
	public UserData findBy(final Integer userid)
	{
		final UserData userData = getMapper().toDomainObject(userDatasService.findBy(userid));
		return userData;
	}


}
