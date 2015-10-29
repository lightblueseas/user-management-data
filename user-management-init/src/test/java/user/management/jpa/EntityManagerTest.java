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
    
    @Test
    public void testAllOps(){
    	em.getTransaction().begin();
    	Query query = em.createQuery("select u from Users u where u.id=:userid");
    	query.setParameter("userid", 4);
    	@SuppressWarnings("unchecked")
		List<Users> users = query.getResultList();
    	for (Users user : users) {
    		Set<Resources> resources = user.getUserData().getResources();
    		for (Resources resource : resources) {
				System.out.println(resource.getFilename());
			}
		}
    	System.out.println(users);
    }
}