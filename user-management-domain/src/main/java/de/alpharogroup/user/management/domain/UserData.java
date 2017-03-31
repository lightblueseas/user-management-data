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
package de.alpharogroup.user.management.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import de.alpharogroup.address.book.domain.Address;
import de.alpharogroup.domain.BaseDomainObject;
import de.alpharogroup.resource.system.domain.Resource;
import de.alpharogroup.user.domain.User;
import de.alpharogroup.user.management.enums.GenderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserData extends BaseDomainObject<Integer> {
	/**
	 * The serial Version UID.
	 */
	private static final long serialVersionUID = 1L;
	private User owner;
	/** The addresses of the user. */
	private Set<Address> addresses = new HashSet<>();
	/** The birth name from the user if he or she had one. */
	private String birthname;
	/** The contacts of the user that are black listed. */
	private Set<User> blacklistedContacts = new HashSet<>();
	/** The contact data of the user. */
	private Set<Contactmethod> contactmethods = new HashSet<>();
	/** The date of birth from the user. */
	private Date dateofbirth;
	/** The first name of the user. */
	private String firstname;
	/** The enum for the gender of the user. */
	private GenderType gender;
	/** The resources of the user. */
	private Set<Resource> resources = new HashSet<>();
	/** The ip address from where the user has register his self. */
	private String ipAddress;
	/** The last name of the user. */
	private String lastname;
	/** The locale from the user when she/he registered. */
	private String locale;
	/** The primary address of the user. */
	private Address primaryAddress;
	/** The contacts of the user to other users. */
	private Set<User> userContacts = new HashSet<>();
}
