package de.alpharogroup.user.management.sign.up;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;

import de.alpharogroup.address.book.entities.Addresses;
import de.alpharogroup.user.management.enums.GenderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The class {@link UserModel} holds data of the user.
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel implements Serializable {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/** The birthname. */
	private String birthname;

	/** The dateofbirth. */
	private Date dateofbirth;

	/** The firstname. */
	private String firstname;

	/** The gender. */
	private GenderType gender;

	/** The IP address. */
	private String ipAddress;

	/** The lastname. */
	private String lastname;

	/** The locale. */
	private Locale locale;

	/** The mobile. */
	private String mobile;

	/** The telefon. */
	private String telefon;

	/** The fax. */
	private String fax;

	private Addresses address;

}
