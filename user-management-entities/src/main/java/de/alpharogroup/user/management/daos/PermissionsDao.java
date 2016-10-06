package de.alpharogroup.user.management.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import de.alpharogroup.db.dao.jpa.JpaEntityManagerDao;
import de.alpharogroup.user.management.entities.Permissions;
import lombok.Getter;
import lombok.Setter;

@Repository("permissionsDao")
public class PermissionsDao extends JpaEntityManagerDao<Permissions, Integer> {
	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/** The entity manager. */
	@PersistenceContext
	@Getter
	@Setter
	private EntityManager entityManager;

}
