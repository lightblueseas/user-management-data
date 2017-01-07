package de.alpharogroup.user.management.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import de.alpharogroup.db.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The entity class {@link ResetPasswords} is keeping the
 * information for reseting the password from a user. Data will be inserted when
 * a user forgets his password and enter his data in the form.
 */
@Entity
@Table(name = "reset_passwords")
@Getter
@Setter
@NoArgsConstructor
public class ResetPasswords 
extends BaseEntity<Integer>
implements Cloneable {

	/** The serial Version UID */
	private static final long serialVersionUID = -4437962692764644264L;
	/** The date which this data expire. */
	@Column(name = "expiry_date")
	private Date expiryDate;
	/** mapping */
	@Column(name = "generated_password", length = 1024)
	private String generatedPassword;
	/** The time that the user send the form. */
	@Column(name = "starttime")
	private Date starttime;
	/** The user attribute that references to the Entity class {@link Users}. */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_RESET_PASSWORDS_USER_ID"))
	private Users user;
	
}
