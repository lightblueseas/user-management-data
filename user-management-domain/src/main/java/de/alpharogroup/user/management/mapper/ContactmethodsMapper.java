package de.alpharogroup.user.management.mapper;

import org.springframework.stereotype.Component;

import de.alpharogroup.db.entitymapper.AbstractEntityDOMapper;
import de.alpharogroup.user.management.domain.Contactmethod;
import de.alpharogroup.user.management.entities.Contactmethods;

/**
 * The class {@link ContactmethodsMapper}.
 */
@Component
public class ContactmethodsMapper extends AbstractEntityDOMapper<Contactmethods, Contactmethod> {
}
