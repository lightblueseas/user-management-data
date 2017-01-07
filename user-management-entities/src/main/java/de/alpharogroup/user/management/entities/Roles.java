package de.alpharogroup.user.management.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import de.alpharogroup.db.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The entity class {@link Roles} is keeping the information for the user
 * roles.
 */
@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
public class Roles 
extends BaseEntity<Integer>
implements Cloneable {

	/** The serial Version UID. */
	private static final long serialVersionUID = -5523602462337489391L;
	/** A description of the role. */
	@Column(name = "description", length = 64)
	private String description;
	/** The permissions of the role. */
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		      name="role_permissions",
		      joinColumns={@JoinColumn(name="role_id", referencedColumnName="id")},
		      inverseJoinColumns={@JoinColumn(name="permission_id", referencedColumnName="id")})
	private Set<Permissions> permissions = new HashSet<Permissions>();
	/** The name of the role. */
	@Column(name = "rolename", length = 64, unique = true)
	private String rolename;
	
	/**
	 * Adds the permission.
	 *
	 * @param permission the permission
	 * @return true, if successful
	 */
	public boolean addPermission(Permissions permission){
		return permissions.add(permission);
	}
	
}
