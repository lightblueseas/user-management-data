package de.alpharogroup.user.management.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import de.alpharogroup.db.entity.BaseEntity;
import de.alpharogroup.user.management.enums.RuleViolationReason;

/**
 * Object mapping for hibernate-handled table: rule_violations 
 */
@Entity
@Table(name="rule_violations")
@TypeDefs({ 
	@TypeDef(name = "reasonConverter", typeClass = de.alpharogroup.db.postgres.usertype.PGEnumUserType.class, parameters = { @Parameter(name = "enumClassName", value = "de.alpharogroup.user.management.enums.RuleViolationReason") }) })
@Getter
@Setter
@NoArgsConstructor
public class RuleViolations
extends BaseEntity<Integer>
implements Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	@Column(name = "reason")
	@Type(type = "reasonConverter")
	private RuleViolationReason reason;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "detector_user_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_DETECTOR_USER_ID"))
	private Users detector;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "violator_user_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_VIOLATOR_USER_ID"))
	private Users violator;
	@Column( name="description", length = 1000  )
	private String description;

}
