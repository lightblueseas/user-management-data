package de.alpharogroup.user.management.rest;


import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.user.management.domain.ResetPassword;
import de.alpharogroup.user.management.domain.User;
import de.alpharogroup.user.management.rest.api.ResetPasswordsResource;
import de.alpharogroup.user.management.service.api.ResetPasswordService;

public class ResetPasswordsRestResource
	extends
		AbstractRestfulResource<Integer, ResetPassword, ResetPasswordService>
	implements
		ResetPasswordsResource
{

	@Override
	public ResetPassword findResetPassword(User user, String generatedPassword) {
		return getDomainService().findResetPassword(user, generatedPassword);
	}

	@Override
	public ResetPassword findResetPassword(User user) {
		return getDomainService().findResetPassword(user);
	}

}
