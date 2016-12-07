package de.alpharogroup.user.management.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import de.alpharogroup.db.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The Entity class {@link UserTokens} is keeping the information for
 * the token of users.
 */
@Entity
@Table(name = "user_tokens")
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserTokens 
extends BaseEntity<Integer>
implements Cloneable {

	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/** The user name. */
	@Column(name = "username", length = 256, unique = true)
	private String username;
	/** The token for the user. */
	@Column(name = "token", length = 128, unique=true)
	private String token;
	/** The expiration date. */
	private Date expiry;

}
