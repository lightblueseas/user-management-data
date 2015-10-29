package de.alpharogroup.user.management.entities;

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
 * The Entity class {@link Recommendations} is keeping the
 * information for the recommendations that a user recommended another user to an email with an invitation text.
 */
@Entity
@Table(name = "recommendations")
@Getter
@Setter
@NoArgsConstructor
public class Recommendations
extends BaseEntity<Integer>
implements Cloneable { 

	/**
	 * The serial Version UID
	 */
	private static final long serialVersionUID = 1L;
	/** The user that made the recommendation. */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_RECOMMENDATIONS_USER_ID"))
	private Users user;
	/** The user that is recommended. */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "recommended_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_RECOMMENDATIONS_RECOMMENDED_ID"))
	private Users recommended; 
	/** The email where this recommendation is send. */
	@Column( name="email", length = 1024  )
	private String email;
	/** The text from the invitation from the user. This is optional. */
	@Column( name="invitation_text", length = 1024  )
    private String invitationText;
	/** The sent flag, if true the recommendation is successfully sent with the message system. */
	@Column(name = "sent")
	private Boolean sent;

}