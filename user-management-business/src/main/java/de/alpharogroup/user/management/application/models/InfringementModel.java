package de.alpharogroup.user.management.application.models;

import java.io.Serializable;

import de.alpharogroup.user.management.entities.Users;
import de.alpharogroup.user.management.enums.RuleViolationReason;
import lombok.Data;

@Data
public class InfringementModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private RuleViolationReason reason;
	
	private Users detector;
	
	private Users violator;
	
	private String description;

}
