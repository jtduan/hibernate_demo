package hibernate5.demo.event.any;

import hibernate5.demo.event.Factory;
import hibernate5.demo.event.columetransformer.formula.FormulaTable;
import junit.framework.TestCase;

import javax.persistence.EntityManager;

/**
 * Created by hero on 2016/5/17.
 */
public class AnyTest extends TestCase{

    public void testBasicUsage() {
        EntityManager entityManager = Factory.entityManager;
        entityManager.getTransaction().begin();
        AnyTable table = new AnyTable(new Person("王明"));
        entityManager.persist(table);
        entityManager.getTransaction().commit();
    }
}
