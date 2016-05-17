package hibernate5.demo.event.columetransformer;

import hibernate5.demo.event.Factory;
import junit.framework.TestCase;

import javax.persistence.EntityManager;

/**
 * Created by hero on 2016/5/17.
 */
public class ColumnTransformerTest extends TestCase{

    public void testBasicUsage() {
        EntityManager entityManager = Factory.entityManager;
        entityManager.getTransaction().begin();
        ColumeTransformerTable table = new ColumeTransformerTable(1,"123456");
        entityManager.persist(table);
        entityManager.getTransaction().commit();

        entityManager = Factory.entityManagerFactory.createEntityManager();
        ColumeTransformerTable t =entityManager.find(ColumeTransformerTable.class,1);
        assertEquals(t.getPassword(),entityManager.createNativeQuery("select password ('123456')").getSingleResult());
    }
}
