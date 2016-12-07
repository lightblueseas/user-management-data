package de.alpharogroup.user.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.auth.models.AuthenticationErrors;
import de.alpharogroup.auth.models.AuthenticationResult;
import de.alpharogroup.user.management.domain.User;
import de.alpharogroup.user.management.entities.Users;
import de.alpharogroup.user.management.mapper.UsersMapper;
import de.alpharogroup.user.management.service.api.AuthenticationService;
import de.alpharogroup.user.management.service.api.AuthenticationsService;
import de.alpharogroup.user.management.service.api.UsersManagementService;
import lombok.Getter;
import lombok.Setter;

@Transactional
@Service("authenticationDomainService")
public class AuthenticationDomainService implements AuthenticationService {
	

	/** The {@link AuthenticationsService}. */
	@Autowired
	@Getter
	@Setter
	private AuthenticationsService authenticationsService;
	
	private final UsersMapper mapper = new UsersMapper();

	@Override
	public AuthenticationResult<User, AuthenticationErrors> authenticate(String emailOrUsername, String password) {
		AuthenticationResult<User, AuthenticationErrors> authenticationResult = new AuthenticationResult<>();
		AuthenticationResult<Users, AuthenticationErrors> originalAuthenticationResult = authenticationsService.authenticate(emailOrUsername, password);
		authenticationResult.setValidationErrors(authenticationResult.getValidationErrors());		
		authenticationResult.setUser(mapper.toDomainObject(originalAuthenticationResult.getUser()));
		return authenticationResult;
	}

	@Override
	public String newAuthenticationToken(String username) {
		return authenticationsService.newAuthenticationToken(username);
	}

}
