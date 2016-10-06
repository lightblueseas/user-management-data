package de.alpharogroup.user.management.mapper;

import org.springframework.stereotype.Component;

import de.alpharogroup.db.entitymapper.AbstractEntityDOMapper;
import de.alpharogroup.user.management.domain.RuleViolation;
import de.alpharogroup.user.management.entities.RuleViolations;

/**
 * The class {@link RuleViolationsMapper}.
 */
@Component
public class RuleViolationsMapper extends AbstractEntityDOMapper<RuleViolations, RuleViolation> {

}
