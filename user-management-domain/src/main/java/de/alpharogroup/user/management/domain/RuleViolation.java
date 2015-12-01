package de.alpharogroup.user.management.domain;

import de.alpharogroup.domain.BaseDomainObject;
import de.alpharogroup.user.management.enums.RuleViolationReason;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class RuleViolation extends BaseDomainObject<Integer> {
	private static final long serialVersionUID = 1L;
	private RuleViolationReason reason;
	private User detector;
	private User violator;
	private String description;
}
