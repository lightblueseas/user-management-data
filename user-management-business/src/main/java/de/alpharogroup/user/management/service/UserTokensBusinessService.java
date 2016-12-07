package de.alpharogroup.user.management.service;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.torpedoquery.jpa.Torpedo;

import de.alpharogroup.collections.ListExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.user.management.daos.UserTokensDao;
import de.alpharogroup.user.management.entities.UserTokens;
import de.alpharogroup.user.management.service.api.UserTokensService;

@Transactional
@Service("userTokensService")
public class UserTokensBusinessService extends AbstractBusinessService<UserTokens, Integer, UserTokensDao> implements UserTokensService {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setUserTokensDao(UserTokensDao userTokensDao) {
		setDao(userTokensDao);
	}

	@Override
	public UserTokens find(String username) {
		return ListExtensions.getFirst(findAll(username));
	}

	@Override
	public List<UserTokens> findAll(String username) {
		List<UserTokens> userTokens = null;
		UserTokens from = Torpedo.from(UserTokens.class);
		Torpedo.where(from.getUsername()).eq(username);
		org.torpedoquery.jpa.Query<UserTokens> select = Torpedo.select(from);
		userTokens = select.list(getDao().getEntityManager());
		return userTokens;
	}

	@Override
	public String getAutheticationToken(String username) {
		UserTokens token = find(username);
		if (token != null) {
			return token.getToken();
		}
		return null;
	}

	@Override
	public boolean isValid(String token) {
		List<UserTokens> userTokens = null;
		UserTokens from = Torpedo.from(UserTokens.class);
		Torpedo.where(from.getToken()).eq(token);
		org.torpedoquery.jpa.Query<UserTokens> select = Torpedo.select(from);
		userTokens = select.list(getDao().getEntityManager());
		boolean valid = CollectionUtils.isNotEmpty(userTokens);
		return valid;
	}

}