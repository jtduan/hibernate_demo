package hibernate5.demo.event.identifiers.one;

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
        IDCard idcard = new IDCard("card","123");
        User user= new User(idcard,"王明");
        entityManager.persist(user);
        entityManager.getTransaction().commit();

        entityManager = Factory.entityManagerFactory.createEntityManager();
        User u = entityManager.find(User.class,new IDCard( "card", "123" ));
        System.out.println(u.getName());
    }
}
