package de.alpharogroup.user.management.mapper;

import org.springframework.stereotype.Component;

import de.alpharogroup.db.entitymapper.AbstractEntityDOMapper;
import de.alpharogroup.user.management.domain.User;
import de.alpharogroup.user.entities.Users;

/**
 * The class {@link UsersMapper}.
 */
@Component
public class UsersMapper extends AbstractEntityDOMapper<Users, User> {

}
