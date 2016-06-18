package de.alpharogroup.user.management.service.api;

import de.alpharogroup.user.management.domain.User;
import de.alpharogroup.user.management.sign.in.AuthenticationErrors;
import de.alpharogroup.user.management.sign.in.AuthenticationResult;

public interface AuthenticationService {

	AuthenticationResult<User, AuthenticationErrors> authenticate(String emailOrUsername, String password);
}
