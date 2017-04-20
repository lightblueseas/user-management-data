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
package de.alpharogroup.user.management.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import de.alpharogroup.db.entity.BaseEntity;
import de.alpharogroup.user.management.enums.ContactmethodType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The entity class {@link Contactmethods} is keeping the information for the contact methods and
 * the corresponding value.
 */
@Entity
@Table(name = "contactmethods")
@TypeDef(name = "contactmethodConverter", typeClass = de.alpharogroup.db.postgres.usertype.PGEnumUserType.class, parameters = {
		@Parameter(name = "enumClassName", value = "de.alpharogroup.user.management.enums.ContactmethodType") })
@Getter
@Setter
@NoArgsConstructor
public class Contactmethods extends BaseEntity<Integer> implements Cloneable
{

	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/** The contact method like email, telefon etc. */
	@Enumerated(EnumType.STRING)
	@Column(name = "contactmethod")
	@Type(type = "contactmethodConverter")
	private ContactmethodType contactmethod;
	/**
	 * The value from the contact method. For instance 'abc@gmail.com' for email or
	 * 'http://www.google.com' for internet.
	 */
	@Column(name = "contactvalue", length = 1024)
	private String contactvalue;

}
