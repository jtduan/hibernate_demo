package hibernate5.demo.event.version;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import hibernate5.demo.event.Factory;
import hibernate5.demo.event.date.temporal.DateJava8Table;
import hibernate5.demo.event.date.temporal.DateTable;
import junit.framework.TestCase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 * Created by hero on 2016/5/17.
 */
public class VersionTest extends TestCase{

    public void testBasicUsage() {
        EntityManager entityManager = Factory.entityManager;
        entityManager.getTransaction().begin();
        Version version = new Version(1,"王明");
        entityManager.persist(version);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        Version v = entityManager.find(Version.class,1);
        v.setContent("2号王明");
        entityManager.getTransaction().commit();

        System.out.println(version.getPrice());

        entityManager.getTransaction().begin();
        Version v2 = entityManager.find(Version.class,1);
        v2.setContent("3号王明");
        entityManager.getTransaction().commit();
    }
}
