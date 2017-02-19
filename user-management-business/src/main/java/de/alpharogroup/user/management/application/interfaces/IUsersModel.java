package de.alpharogroup.user.management.application.interfaces;

import java.io.Serializable;

import de.alpharogroup.user.entities.Users;

/**
 * The Interface IUsersModel have Methods for get the Users object.
 */
public interface IUsersModel extends Serializable {


	/**
	 * Gets the Users object.
	 * 
	 * @return the Users object.
	 */
	Users getUser();
}
