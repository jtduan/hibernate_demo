package hibernate5.demo.event.embedded;

import hibernate5.demo.event.Factory;
import hibernate5.demo.event.any.AnyTable;
import hibernate5.demo.event.any.Person;
import junit.framework.TestCase;

import javax.persistence.Embedded;
import javax.persistence.EntityManager;

/**
 * Created by hero on 2016/5/17.
 */
public class EmbeddedTest extends TestCase{

    public void testBasicUsage() {
        EntityManager entityManager = Factory.entityManager;
        entityManager.getTransaction().begin();
        EmbeddedTable table = new EmbeddedTable(new Name("王","小明"),new Name("宋","小芳"));
        entityManager.persist(table);
        entityManager.getTransaction().commit();
    }
}
