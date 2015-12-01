package de.alpharogroup.user.management.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import de.alpharogroup.db.entity.BaseEntity;
import de.alpharogroup.user.management.enums.ContactmethodType;

/**
 * The Entity class {@link Contactmethods} is keeping the
 * information for the contact methods and the corresponding value.
 */
@Entity
@Table(name = "contactmethods")
@TypeDef(name = "contactmethodConverter", typeClass = de.alpharogroup.db.postgres.usertype.PGEnumUserType.class, parameters = { @Parameter(name = "enumClassName", value = "de.alpharogroup.user.management.enums.ContactmethodType") })
@Getter
@Setter
@NoArgsConstructor
public class Contactmethods 
extends BaseEntity<Integer>
implements Cloneable {

	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/** The contact method like email, telefon etc. */
	@Enumerated(EnumType.STRING)
	@Column(name = "contactmethod")
	@Type(type = "contactmethodConverter")
	private ContactmethodType contactmethod;
	/**
	 * The value from the contact method. For instance 'abc@gmail.com' for email
	 * or 'http://www.google.com' for internet.
	 */
	@Column(name = "contactvalue", length = 1024)
	private String contactvalue;

}
