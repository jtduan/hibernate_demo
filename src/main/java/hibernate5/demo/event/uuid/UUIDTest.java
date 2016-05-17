package hibernate5.demo.event.uuid;

import junit.framework.TestCase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.UUID;

/**
 * Created by hero on 2016/5/17.
 */
public class UUIDTest extends TestCase{
    private EntityManagerFactory entityManagerFactory;

    @Override
    protected void setUp() throws Exception {
        // like discussed with regards to SessionFactory, an EntityManagerFactory is set up once for an application
        // 		IMPORTANT: notice how the name here matches the name we gave the persistence-unit in persistence.xml!
        entityManagerFactory = Persistence.createEntityManagerFactory( "hibernate5.demo.event.jpa" );
    }

    @Override
    protected void tearDown() throws Exception {
        entityManagerFactory.close();
    }

    public void testBasicUsage() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        UUIDTable table = new UUIDTable(UUID.fromString("a7b7b903-e888-44ba-a2cd-a5cadab7f183"), UUID.fromString("a7b7b903-e888-44ba-a2cd-a5cadab7f183"),UUID.randomUUID());
        entityManager.persist(table);
        entityManager.getTransaction().commit();
        entityManager.close();

        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        UUIDTable uuid = entityManager.find(UUIDTable.class,UUID.fromString("a7b7b903-e888-44ba-a2cd-a5cadab7f183"));
        System.out.println(uuid.getUuid2());
        assertEquals(uuid.getUid().toString(),"a7b7b903-e888-44ba-a2cd-a5cadab7f183");
    }
}
