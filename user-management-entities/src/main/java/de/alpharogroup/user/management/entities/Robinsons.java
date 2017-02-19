package de.alpharogroup.user.management.entities;

import javax.persistence.CascadeType;
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
 * The class {@link Robinsons} tags users that do not want to be disturbed, like email or other
 * messages or advertising.
 */
@Entity
@Table(name = "robinsons")
@Getter
@Setter
@NoArgsConstructor
public class Robinsons extends BaseEntity<Integer> implements Cloneable
{

	private static final long serialVersionUID = 1L;
	/**
	 * The value associated with the column: robinson
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "robinson_user_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_ROBINSON_USER_ID") )
	private Users robinson;

}
