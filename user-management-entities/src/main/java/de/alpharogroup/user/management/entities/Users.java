package de.alpharogroup.user.management.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import de.alpharogroup.db.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Entity class {@link Users} is keeping the information for the users from
 * the application.
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class Users 
extends BaseEntity<Integer> 
implements Cloneable {

	/** The serial Version UID. */
	private static final long serialVersionUID = 1L;
	/** The attribute active, if true the user account is active. */
	@Column(name = "active")
	private Boolean active;
	/** A Flag that indicates if the user account is locked or not. */
	@Column(name = "locked")
	private Boolean locked;
	/** The hash from the password hashed with sha512. */
	@Column(name = "pw", length = 1024)
	private String pw;
	/** The roles of the user. */
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "user_roles", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") }, 
	inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") })
	private Set<Roles> roles = new HashSet<Roles>();
	/** The salt that is used to compute the hash. */
	@Column(name = "salt", length = 8)
	private String salt;
	/** The data of this user. */
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "user_data")
	private UserDatas userData;
	/** The user name. */
	@Column(name = "username", length = 256, unique = true)
	private String username;

	/**
	 * Adds a role to the user.
	 * 
	 * @param role
	 *            the role
	 * @return true, if successful
	 */
	public boolean addRole(Roles role) {
		return roles.add(role);
	}

	public boolean isActive() {
		return getActive();
	}

}
