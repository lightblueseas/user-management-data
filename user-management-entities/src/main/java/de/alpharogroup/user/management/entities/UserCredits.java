package de.alpharogroup.user.management.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import de.alpharogroup.db.entity.BaseEntity;
import de.alpharogroup.user.entities.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The entity class {@link UserCredits} is keeping the
 * information for the credits from a user. A user can buy credits that is
 * inserted in this table.
 */
@Entity
@Table(name = "user_credits")
@Getter
@Setter
@NoArgsConstructor
public class UserCredits
extends BaseEntity<Integer>
implements Cloneable {
	/**
	 * The serial Version UID.
	 */
	private static final long serialVersionUID = 6658246250439811798L;
	/** The points that the user have buyed. */
	@Column(name = "credits", nullable = true)
	private Integer credits;
	/**
	 * The user attribute that references to the Entity class {@link Users}
	 * that owns the credits.
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_USER_CREDITS_USER_ID"))
	private Users user;

}
