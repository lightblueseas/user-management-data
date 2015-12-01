package de.alpharogroup.user.management.domain;

import java.util.HashSet;
import java.util.Set;

import de.alpharogroup.domain.BaseDomainObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
public class Role extends BaseDomainObject<Integer> {
	/** The serial Version UID. */
	private static final long serialVersionUID = 1L;
	/** A description of the role. */
	private String description;
	/** The permissions of the role. */
	private Set<Permission> permissions = new HashSet<>();
	/** The name of the role. */
	private String rolename;
}
