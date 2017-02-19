package de.alpharogroup.user.management.application.models;

import java.io.Serializable;

import de.alpharogroup.user.entities.Users;
import de.alpharogroup.user.management.enums.RuleViolationReason;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Bean class for an infringement information.
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InfringementModel implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The reason. */
	private RuleViolationReason reason;

	/** The detector. */
	private Users detector;

	/** The violator. */
	private Users violator;

	/** The description. */
	private String description;

}
