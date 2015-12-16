package de.alpharogroup.user.management.application.models;

import java.io.Serializable;

import de.alpharogroup.user.management.entities.Users;
import de.alpharogroup.user.management.enums.RuleViolationReason;
import lombok.Data;

/**
 * Bean class for an infringement information.
 */
@Data
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
