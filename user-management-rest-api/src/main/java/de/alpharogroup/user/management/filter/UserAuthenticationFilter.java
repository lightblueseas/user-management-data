/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *  *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *  *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
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

public class UserAuthenticationFilter extends AuthenticationFilter
{

	@SuppressWarnings("deprecation")
	private Map<String, LocalDateTime> validTokens = new MapMaker().expiration(30, TimeUnit.MINUTES)
		.makeMap();

	@Autowired
	@Getter
	@Setter
	private UserManagementService userManagementService;

	@Override
	protected String onValidateToken(String token) throws Exception
	{
		if (!validTokens.containsKey(token))
		{
			if (!userManagementService.isValid(token))
			{
				throw new Exception("UnauthorizedException with Token:" + token);
			}
		}
		validTokens.put(token, LocalDateTime.now());
		return token;
	}

}
