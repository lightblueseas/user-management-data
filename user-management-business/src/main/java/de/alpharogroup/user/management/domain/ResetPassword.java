package de.alpharogroup.user.management.domain;

import java.util.Date;

import de.alpharogroup.domain.BaseDomainObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
public class ResetPassword extends BaseDomainObject<Integer> {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/** The date which this data expire. */
	private Date expiryDate;
	/** mapping */
	private String generatedPassword;
	/** The time that the user send the form. */
	private Date starttime;
	/** The user attribute that references to the domain class {@link User}. */
	private User user;
}
