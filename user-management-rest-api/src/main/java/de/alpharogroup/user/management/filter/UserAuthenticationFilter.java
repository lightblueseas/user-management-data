package de.alpharogroup.user.management.filter;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.MapMaker;

import de.alpharogroup.service.rs.filter.AuthenticationFilter;
import de.alpharogroup.user.management.service.api.UserManagementService;
import lombok.Getter;
import lombok.Setter;

public class UserAuthenticationFilter extends AuthenticationFilter {
	
	@SuppressWarnings("deprecation")
	private Map<String, LocalDateTime> validTokens = new MapMaker()
	.expiration(30, TimeUnit.MINUTES)
	.makeMap();

	@Autowired
	@Getter
	@Setter
	private UserManagementService userManagementService;
	
	@Override
	protected String onValidateToken(String token) throws Exception {
		if (!validTokens.containsKey(token)) {
			if (!userManagementService.isValid(token)) {
				throw new Exception("UnauthorizedException with Token:"+ token); 
			}
		}
		validTokens.put(token, LocalDateTime.now());
		return token;
	}

}
