package de.alpharogroup.user.management.domain;

import de.alpharogroup.domain.BaseDomainObject;
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
public class UserCredit extends BaseDomainObject<Integer> {
	/**
	 * The serial Version UID.
	 */
	private static final long serialVersionUID = 1L;
	/** The points that the user have buyed. */
	private Integer credits;
	/**
	 * The user attribute that references to the Entity class {@link User}
	 * that owns the credits.
	 */
	private User user;
}
