package hibernate5.demo.event.embedded.collection;

import hibernate5.demo.event.Factory;
import hibernate5.demo.event.any.AnyTable;
import hibernate5.demo.event.any.Person;
import junit.framework.TestCase;

import javax.persistence.EntityManager;

/**
 * Created by hero on 2016/5/17.
 */
public class EmbeddedCollectionTest extends TestCase{

    public void testBasicUsage() {
        EntityManager entityManager = Factory.entityManager;
        entityManager.getTransaction().begin();
        EmbeddedCollectionTable table =new EmbeddedCollectionTable();
        table.getNames().add(new Name("王","小明"));
        table.getNames().add(new Name("方","小芳"));
        table.setId(1);
        table.setCardId("4128270031");

        EmbeddedCollectionTable table2 =new EmbeddedCollectionTable();
        table2.getNames().add(new Name("王","小明2"));
        table2.getNames().add(new Name("方","小芳2"));
        table2.setId(2);
        table2.setCardId("4128270032");

        entityManager.persist(table);
        entityManager.persist(table2);
        entityManager.getTransaction().commit();
    }
}
