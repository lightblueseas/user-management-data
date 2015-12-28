package user.management.jpa;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import de.alpharogroup.resource.system.entities.Resources;
import de.alpharogroup.user.management.entities.Users;

public class EntityManagerTest {

    private EntityManager em = null;

    @BeforeClass
    public void setUpClass() throws Exception {
        if (em == null) {
            em = (EntityManager) Persistence.
                      createEntityManagerFactory("usermanagement").
                      createEntityManager();
        }
    }

    @Test(enabled=false)
    public void testAllOps(){
    	em.getTransaction().begin();
    	final Query query = em.createQuery("select u from Users u where u.id=:userid");
    	query.setParameter("userid", 4);
    	@SuppressWarnings("unchecked")
		final
		List<Users> users = query.getResultList();
    	for (final Users user : users) {
    		final Set<Resources> resources = user.getUserData().getResources();
    		for (final Resources resource : resources) {
				System.out.println(resource.getFilename());
			}
		}
    	System.out.println(users);
    }
}