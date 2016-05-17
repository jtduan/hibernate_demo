package hibernate5.demo.event;

import junit.framework.TestCase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by hero on 2016/5/17.
 */
public class Factory{
    public static EntityManagerFactory entityManagerFactory;

    /**
     * 注意：当使用同一个entityManager 时，先save再find()可能不会触发数据库的查询动作
     */
    public static EntityManager entityManager;

    static{
        entityManagerFactory = Persistence.createEntityManagerFactory( "hibernate5.demo.event.jpa" );
        entityManager = entityManagerFactory.createEntityManager();
    }
}
