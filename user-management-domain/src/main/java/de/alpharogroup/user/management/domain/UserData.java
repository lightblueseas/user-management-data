package de.alpharogroup.user.management.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import de.alpharogroup.address.book.domain.Address;
import de.alpharogroup.domain.BaseDomainObject;
import de.alpharogroup.resource.system.domain.Resource;
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
