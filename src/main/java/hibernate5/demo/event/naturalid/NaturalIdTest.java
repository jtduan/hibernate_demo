package hibernate5.demo.event.naturalid;

import hibernate5.demo.event.Factory;
import hibernate5.demo.event.any.AnyTable;
import hibernate5.demo.event.any.Person;
import junit.framework.TestCase;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by hero on 2016/5/17.
 */
public class NaturalIdTest extends TestCase{

    public void testBasicUsage() {
        EntityManager entityManager = Factory.entityManager;
        entityManager.getTransaction().begin();
        NaturalIdTable table = new NaturalIdTable("4128270031","王明");
        entityManager.persist(table);
        entityManager.getTransaction().commit();


        entityManager = Factory.entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Session session = entityManager.unwrap(Session.class);
        NaturalIdTable naturalid= session.bySimpleNaturalId(NaturalIdTable.class).load("4128270031");
        System.out.println(naturalid.getName());
        entityManager.getTransaction().commit();
    }
}
