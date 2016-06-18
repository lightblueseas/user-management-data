package de.alpharogroup.user.management.sign.in;
import java.util.ArrayList;
import java.util.List;


/**
 * The class AuthenticationResult.
 * @deprecated use instead the same class from project auth.security
 * will be deleted in version 4.*.*
 */
@Deprecated
public class AuthenticationResult<U, E> {
		
	private List<E> validationErrors = new ArrayList<E>();
	
	private U user;

	public U getUser() {
		return user;
	}

	public void setUser(U user) {
		this.user = user;
	}

	public List<E> getValidationErrors() {
		return validationErrors;
	}

	public void setValidationErrors(List<E> validationErrors) {
		this.validationErrors = validationErrors;
	}

}