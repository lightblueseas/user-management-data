package de.alpharogroup.user.management.service.api;

import de.alpharogroup.auth.models.AuthenticationErrors;
import de.alpharogroup.auth.models.AuthenticationResult;
import de.alpharogroup.user.management.domain.User;

public interface AuthenticationService {

	AuthenticationResult<User, AuthenticationErrors> authenticate(String emailOrUsername, String password);
}
