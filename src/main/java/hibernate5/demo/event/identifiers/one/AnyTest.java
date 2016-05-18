package hibernate5.demo.event.identifiers.one;

import hibernate5.demo.event.Factory;
import junit.framework.TestCase;

import javax.persistence.EntityManager;

/**
 * Created by hero on 2016/5/17.
 */
public class AnyTest extends TestCase{

    public void testBasicUsage() {
        EntityManager entityManager = Factory.entityManager;
        entityManager.getTransaction().begin();
        IDCard idcard = new IDCard("card","123");
        User user= new User(idcard,"王明");
        entityManager.persist(user);
        entityManager.getTransaction().commit();

        entityManager = Factory.entityManagerFactory.createEntityManager();
        /**
         * getReference()与find()区别
         * getReference() 采用延迟加载机制，如果仅仅是获取对象并更新，而不去读取对象的属性，
         * 则getReference()会比find()方法少执行一次select
         * 另外，getReference()没有对象时会报异常，而find()返回null
         */
        User u = entityManager.getReference(User.class,new IDCard( "card", "123" ));
        System.out.println(u.getName());
    }
}
