package hibernate5.demo.event.identifiers.two;

import hibernate5.demo.event.Factory;
import junit.framework.TestCase;

import javax.persistence.EntityManager;

/**
 * Created by hero on 2016/5/17.
 */
public class AnyTest extends TestCase{

    public void testBasicUsage() {
        EntityManager entityManager = Factory.entityManager;
        entityManager.getTransaction().begin();

        SchoolUser user= new SchoolUser("平舆","二小","王明");
        entityManager.persist(user);
        entityManager.getTransaction().commit();

        entityManager = Factory.entityManagerFactory.createEntityManager();
        SchoolUser u= (SchoolUser)entityManager.createQuery("from SchoolUser where name = '王明'").getSingleResult();
        System.out.println(u.getName());
    }
}
