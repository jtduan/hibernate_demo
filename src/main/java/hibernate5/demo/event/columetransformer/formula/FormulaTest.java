package hibernate5.demo.event.columetransformer.formula;

import hibernate5.demo.event.Factory;
import junit.framework.TestCase;

import javax.persistence.EntityManager;

/**
 * Created by hero on 2016/5/17.
 */
public class FormulaTest extends TestCase{

    public void testBasicUsage() {
        EntityManager entityManager = Factory.entityManager;
        entityManager.getTransaction().begin();
        FormulaTable table = new FormulaTable(2, 4, 6);
        entityManager.persist(table);
        entityManager.getTransaction().commit();

        entityManager = Factory.entityManagerFactory.createEntityManager();
        FormulaTable t = entityManager.find(FormulaTable.class, 1);
        assertEquals(48,t.getVolume());
    }
}
