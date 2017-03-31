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
package de.alpharogroup.user.management.rest;


import java.util.List;

import de.alpharogroup.address.book.domain.Address;
import de.alpharogroup.collections.pairs.KeyValuePair;
import de.alpharogroup.collections.pairs.Triple;
import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.user.domain.Role;
import de.alpharogroup.user.domain.User;
import de.alpharogroup.user.management.domain.model.UserSearchCriteria;
import de.alpharogroup.user.management.enums.GenderType;
import de.alpharogroup.user.management.rest.api.UsersResource;
import de.alpharogroup.user.management.service.api.UserService;

public class UsersRestResource
	extends
 AbstractRestfulResource<Integer, User, UserService>
	implements
		UsersResource
{
	
	public List<User> findAll() {
		return getDomainService().findAll();
	}

	@Override
	public boolean existsUserWithUsername(String username) {
		return getDomainService().existsUserWithUsername(username);
	}

	@Override
	public List<Address> findAddressesFromUser(User user) {
		return getDomainService().findAddressesFromUser(user);
	}

	@Override
	public Address findAddressFromUser(User user) {
		return getDomainService().findAddressFromUser(user);
	}

	@Override
	public List<Role> findRolesFromUser(User user) {
		return getDomainService().findRolesFromUser(user);
	}

	@Override
	public User findUserWithEmail(String email) {
		return getDomainService().findUserWithEmail(email);
	}

	@Override
	public User findUserWithUsername(String username) {
		return getDomainService().findUserWithUsername(username);
	}

	@Override
	public boolean userIsInRole(KeyValuePair<User, Role> user) {
		return getDomainService().userIsInRole(user.getKey(), user.getValue());
	}

	@Override
	public List<User> findUsers(Triple<Integer, GenderType, Integer> searchCriteria) {
		return getDomainService().findUsers(searchCriteria.getLeft(), searchCriteria.getMiddle(), searchCriteria.getRight());
	}

	@Override
	public List<User> findUsers(UserSearchCriteria userSearchCriteria) {
		return getDomainService().findUsers(
				userSearchCriteria.getFrom(), 
				userSearchCriteria.getSearchGender(), 
				userSearchCriteria.getUntil(), 
				userSearchCriteria.getGeohash());
	}
}
