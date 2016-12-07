package de.alpharogroup.user.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.user.management.service.api.AuthenticationsService;
import de.alpharogroup.user.management.service.api.UsersManagementService;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link AuthenticationsBusinessService} provides authentication methods.
 */
@Transactional
@Service("authenticationsService")
public class AuthenticationsBusinessService implements AuthenticationsService {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The {@link UsersManagementService}. */
	@Autowired
	@Getter
	@Setter
	private UsersManagementService usersManagementService;

	@Override
	public String newAuthenticationToken(String username) {		
		return usersManagementService.newAuthenticationToken(username);
	}
	
}
