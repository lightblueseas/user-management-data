package de.alpharogroup.user.management.domain;

import de.alpharogroup.db.domain.BaseBusinessObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
public class Recommendation extends BaseBusinessObject<Integer> {
	/**
	 * The serial Version UID
	 */
	private static final long serialVersionUID = 1L;
	/** The user that made the recommendation. */
	private User user;
	/** The user that is recommended. */
	private User recommended; 
	/** The email where this recommendation is send. */
	private String email;
	/** The text from the invitation from the user. This is optional. */
	private String invitationText;
	/** The sent flag, if true the recommendation is successfully sent with the message system. */
	private Boolean sent;
}
