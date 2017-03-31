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
package de.alpharogroup.user.management.service.api;

import de.alpharogroup.db.service.api.BusinessService;
import de.alpharogroup.user.management.entities.UserDatas;
import de.alpharogroup.user.entities.Users;

/**
 * The interface {@link UserDatasService}.
 */
public interface UserDatasService extends BusinessService<UserDatas, Integer> {

	/**
	 * Find the {@link UserDatas} object by the given {@link Users} object.
	 *
	 * @param user the user
	 * @return the found {@link UserDatas} object or null if does not exist.
	 */
	UserDatas findBy(Users user);


	/**
	 * Find the {@link UserDatas} object by the given {@link Integer} user id.
	 *
	 * @param userid the user id
	 * @return the found {@link UserDatas} object or null if does not exist.
	 */
	UserDatas findBy(final Integer userid);

}