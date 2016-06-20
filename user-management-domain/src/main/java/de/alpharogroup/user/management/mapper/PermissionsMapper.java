package de.alpharogroup.user.management.mapper;

import org.springframework.stereotype.Component;

import de.alpharogroup.db.entitymapper.AbstractEntityDOMapper;
import de.alpharogroup.user.management.domain.Permission;
import de.alpharogroup.user.management.entities.Permissions;

/**
 * The class {@link PermissionsMapper}.
 */
@Component
public class PermissionsMapper extends AbstractEntityDOMapper<Permissions, Permission> {
}
