package de.alpharogroup.user.management.domain;

import de.alpharogroup.domain.BaseDomainObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
public class Permission extends BaseDomainObject<Integer> {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/** A description for the permission. */
	private String description;
	/** The name from the permission. */
	private String permissionName;
	/** A shortcut for the permission. */
	private String shortcut;
}
