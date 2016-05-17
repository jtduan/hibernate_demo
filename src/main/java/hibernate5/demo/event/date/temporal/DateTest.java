package hibernate5.demo.event.date.temporal;

import hibernate5.demo.event.uuid.UUIDTable;
import junit.framework.TestCase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

/**
 * Created by hero on 2016/5/17.
 */
public class DateTest extends TestCase{
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
        DateTable table =new DateTable(1,new Date(),new Date(),new Date());
        entityManager.persist(table);
        entityManager.getTransaction().commit();
//        entityManager.close();

//        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        DateJava8Table java8table =new DateJava8Table(1, LocalDate.now(), LocalTime.now(),Instant.now());
        entityManager.persist(java8table);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
