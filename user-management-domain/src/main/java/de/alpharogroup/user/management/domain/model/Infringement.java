package de.alpharogroup.user.management.domain.model;

import de.alpharogroup.user.management.domain.User;
import de.alpharogroup.user.management.enums.RuleViolationReason;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The class {@link Infringement}.
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Infringement {
	
	/** The detector. */
	private User detector;
	
	/** The violator. */
	private User violator;
	
	/** The reason. */
	private RuleViolationReason reason;
	
	/** The description. */
	private String description;
	
}
