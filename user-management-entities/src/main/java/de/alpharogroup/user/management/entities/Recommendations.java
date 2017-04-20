/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *  *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *  *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.alpharogroup.user.management.entities;

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
 * The entity class {@link Recommendations} is keeping the information for the recommendations that
 * a user recommended another user to an email with an invitation text.
 */
@Entity
@Table(name = "recommendations")
@Getter
@Setter
@NoArgsConstructor
public class Recommendations extends BaseEntity<Integer> implements Cloneable
{

	/**
	 * The serial Version UID
	 */
	private static final long serialVersionUID = 1L;
	/** The user that made the recommendation. */
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_RECOMMENDATIONS_USER_ID"))
	private Users user;
	/** The user that is recommended. */
	@ManyToOne
	@JoinColumn(name = "recommended_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_RECOMMENDATIONS_RECOMMENDED_ID"))
	private Users recommended;
	/** The email where this recommendation is send. */
	@Column(name = "email", length = 1024)
	private String email;
	/** The text from the invitation from the user. This is optional. */
	@Column(name = "invitation_text", length = 1024)
	private String invitationText;
	/** The sent flag, if true the recommendation is successfully sent with the message system. */
	@Column(name = "sent")
	private Boolean sent;

}