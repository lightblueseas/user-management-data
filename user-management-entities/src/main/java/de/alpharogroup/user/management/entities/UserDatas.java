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

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import de.alpharogroup.address.book.entities.Addresses;
import de.alpharogroup.db.entity.BaseEntity;
import de.alpharogroup.resource.system.entities.Resources;
import de.alpharogroup.user.entities.Users;
import de.alpharogroup.user.management.enums.GenderType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class UserData hold user specific data.
 */
@Entity
@Table(name = "user_data")
@TypeDefs({
		@TypeDef(name = "genderConverter", typeClass = de.alpharogroup.db.postgres.usertype.PGEnumUserType.class, parameters = {
				@Parameter(name = "enumClassName", value = "de.alpharogroup.user.management.enums.GenderType") }) })
@Getter
@Setter
@NoArgsConstructor
public class UserDatas extends BaseEntity<Integer> implements Cloneable
{

	/**
	 * The serial Version UID.
	 */
	private static final long serialVersionUID = 1L;
	/** The owner of this user data. */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "owner")
	private Users owner;
	/** The addresses of the user. */
	@ManyToMany(fetch = FetchType.EAGER)
	@Cascade({ CascadeType.SAVE_UPDATE, CascadeType.DELETE })
	@JoinTable(name = "user_addresses", joinColumns = {
			@JoinColumn(name = "user_data_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "addresses_id", referencedColumnName = "id") })
	private Set<Addresses> addresses = new HashSet<>();
	/** The birth name from the user if he or she had one. */
	@Column(name = "birthname", length = 64)
	private String birthname;
	/** The contacts of the user that are black listed. */
	@ManyToMany(fetch = FetchType.EAGER)
	@Cascade({ CascadeType.SAVE_UPDATE, CascadeType.DELETE })
	@JoinTable(name = "blacklisted_contacts", joinColumns = {
			@JoinColumn(name = "user_data_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "blacklisted_id", referencedColumnName = "id") })
	private Set<Users> blacklistedContacts = new HashSet<>();
	/** The contact data of the user. */
	@ManyToMany(fetch = FetchType.EAGER)
	@Cascade({ CascadeType.SAVE_UPDATE, CascadeType.DELETE })
	@JoinTable(name = "user_contactmethods", joinColumns = {
			@JoinColumn(name = "user_data_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "contactmethods_id", referencedColumnName = "id") })
	private Set<Contactmethods> contactmethods = new HashSet<>();
	/** The date of birth from the user. */
	private Date dateofbirth;
	/** The first name of the user. */
	@Column(name = "firstname", length = 64)
	private String firstname;
	/** The enum for the gender of the user. */
	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	@Type(type = "genderConverter")
	private GenderType gender;
	/** The resources of the user. */
	@ManyToMany(fetch = FetchType.EAGER)
	@Cascade({ CascadeType.SAVE_UPDATE, CascadeType.DELETE })
	@JoinTable(name = "user_resources", joinColumns = {
			@JoinColumn(name = "user_data_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "resources_id", referencedColumnName = "id") })
	private Set<Resources> resources = new HashSet<>();
	/** The ip address from where the user has register his self. */
	@Column(name = "ip_address", length = 16)
	private String ipAddress;
	/** The last name of the user. */
	@Column(name = "lastname", length = 64)
	private String lastname;
	/** The locale from the user when she/he registered. */
	@Column(name = "locale", length = 12)
	private String locale;
	/** The primary address of the user. */
	@ManyToOne
	@Cascade({ CascadeType.ALL })
	@JoinColumn(name = "primary_address_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_USER_DATA_PRIMARY_ADDRESS_ID"))
	private Addresses primaryAddress;
	/** The contacts of the user to other users. */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_contacts", joinColumns = {
			@JoinColumn(name = "user_data_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "user_contact_id", referencedColumnName = "id") })
	private Set<Users> userContacts = new HashSet<>();

}
