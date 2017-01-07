package de.alpharogroup.user.management.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import de.alpharogroup.auth.interfaces.Permission;
import de.alpharogroup.db.entity.BaseEntity;

/**
 * The entity class {@link Permissions} is keeping the information for
 * the permissions of a role or roles.
 */
@Entity
@Table(name = "permissions")
@Getter
@Setter
@NoArgsConstructor
public class Permissions 
extends BaseEntity<Integer>
implements Permission, Cloneable {

	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/** A description for the permission. */
	@Column(name = "description", length = 64)
	private String description;
	/** The name from the permission. */
	@Column(name = "permissionName", length = 64, unique=true)
	private String permissionName;
	/** A shortcut for the permission. */
	@Column(name = "shortcut", length = 10, unique=true)
	private String shortcut;

}
