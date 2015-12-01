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
public class Robinson extends BaseDomainObject<Integer> {
	private static final long serialVersionUID = 1L;
	/**
     * The value associated with the column: robinson
	 */
	private User robinson;
}
