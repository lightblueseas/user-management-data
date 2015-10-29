package de.alpharogroup.user.management.domain;

import de.alpharogroup.db.domain.BaseBusinessObject;
import de.alpharogroup.user.management.enums.Contactmethod;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
public class ContactmethodBusinessObject extends BaseBusinessObject<Integer> {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/** The contact method like email, telefon etc. */
	private Contactmethod contactmethod;
	/**
	 * The value from the contact method. For instance 'abc@gmail.com' for email
	 * or 'http://www.google.com' for internet.
	 */
	private String contactvalue;
}
