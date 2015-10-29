package de.alpharogroup.user.management.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import de.alpharogroup.db.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class describes the permissions that a user can give to another user. 
 * For instance: if a user(the provider of the permissions) have private resources like images
 * and want to release them to another user(the subscriber) so he can see this resources, 
 * than an entry of a provider and the specified permission have to be added in the set of permission. 
 */
@Entity
@Table(name="relation_permissions")
@Getter
@Setter
@NoArgsConstructor
public class RelationPermissions 
extends BaseEntity<Integer>
implements Cloneable {

	/**
	 * The serial Version UID
	 */
	private static final long serialVersionUID = 1L;
	/** The subscriber of the permissions. */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "subscriber_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_USER_RELATION_PERMISSIONS_SUBSCRIBER_ID"))
	private Users subscriber;	
	/** The provider of the permissions. */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "provider_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_USER_RELATION_PERMISSIONS_PROVIDER_ID"))
	private Users provider;	
	/** The permissions of the role. */
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		      name="user_relation_permissions",
		      joinColumns={@JoinColumn(name="user_relation_permission_id", referencedColumnName="id")},
		      inverseJoinColumns={@JoinColumn(name="permission_id", referencedColumnName="id")})
	private Set<Permissions> permissions = new HashSet<Permissions>();

}