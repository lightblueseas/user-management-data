package de.alpharogroup.user.management.sign.up;

import java.io.Serializable;

import de.alpharogroup.auth.models.ValidationErrors;
import de.alpharogroup.user.management.entities.Users;

public class SignUpUserResult implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Users user;
	
	private ValidationErrors validationErrors;

	public Users getUser() {
		return user;
	}

	public ValidationErrors getValidationErrors() {
		return validationErrors;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public void setValidationErrors(ValidationErrors validationErrors) {
		this.validationErrors = validationErrors;
	}

}
