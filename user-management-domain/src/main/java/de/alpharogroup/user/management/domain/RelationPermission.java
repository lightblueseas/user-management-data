package de.alpharogroup.user.management.domain;

import java.util.HashSet;
import java.util.Set;

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
public class RelationPermission extends BaseDomainObject<Integer> {
	/**
	 * The serial Version UID
	 */
	private static final long serialVersionUID = 1L;
	/** The subscriber of the permissions. */
	private User subscriber;	
	/** The provider of the permissions. */
	private User provider;	
	/** The permissions of the role. */
	private Set<Permission> permissions = new HashSet<>();
}
