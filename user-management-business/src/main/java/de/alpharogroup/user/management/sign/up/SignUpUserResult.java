package de.alpharogroup.user.management.sign.up;

import java.io.Serializable;

import de.alpharogroup.auth.models.ValidationErrors;
import de.alpharogroup.user.management.entities.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The class {@link SignUpUserResult}.
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpUserResult implements Serializable {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	private Users user;

	private ValidationErrors validationErrors;

}
