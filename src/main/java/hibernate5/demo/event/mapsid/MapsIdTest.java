package hibernate5.demo.event.mapsid;

import hibernate5.demo.event.Factory;
import hibernate5.demo.event.any.AnyTable;
import hibernate5.demo.event.any.Person;
import junit.framework.TestCase;

import javax.persistence.EntityManager;

/**
 * Created by hero on 2016/5/17.
 */
public class MapsIdTest extends TestCase{

    public void testBasicUsage() {
        EntityManager entityManager = Factory.entityManager;
        entityManager.getTransaction().begin();
        User3 user = new User3("王明",new Book3("计算机组成原理"));
        entityManager.persist(user);

//        Book3 book = new Book3("C语言");
//
//        User3 user2 =
//        entityManager.persist(user2);

        entityManager.getTransaction().commit();
    }
}
