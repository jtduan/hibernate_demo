package hibernate5.demo.event.associations;

import hibernate5.demo.event.Factory;
import junit.framework.TestCase;

import javax.persistence.EntityManager;

/**
 * Created by hero on 2016/5/17.
 */
public class AssociationsTest extends TestCase{

    public void testBasicUsage() {
        EntityManager entityManager = Factory.entityManager;
        entityManager.getTransaction().begin();
        Home home = new Home("9","平舆","1973");
        Room room = new Room(2,35,home);
        Room room2 = new Room(3,24,home);

        /**
         * 此处注意:数据库中Desk表中room_id字段为空,
         * ======解决方案=======
         * 构Desk时需要传入room_id
         */
        room.getDesks().add(new Desk("4",24));
        /**
         * 此处 Desk表中room_id不再为空(尽管感觉room参数多余)
         * 原因: 由于mappedBy属性,hibernte 在多的一端不再对desk外键进行管理
         * Desk本身又没有传入room_id,导致该字段为空
         */
        room.getDesks().add(new Desk("2",8,room));
        room.getDesks().add(new Desk("3",11,room));

        entityManager.persist(room);
        entityManager.persist(room2);
        entityManager.getTransaction().commit();

        entityManager.clear();
        entityManager.getTransaction().begin();

        Person p = new Person("4128271993","王明");
        /**
         * 此处PersonalCard Id被@MapsId注解，该字段98765会被忽略
         */
        PersonalCard card = new PersonalCard("98765",2,true,p);
        entityManager.persist(card);

        entityManager.flush();
        entityManager.clear();
        entityManager.getTransaction().commit();

//
        entityManager.getTransaction().begin();

        Person p2 = new Person("4128271995","王明");
        Person p3 = new Person("4128271994","李明");
        /**
         * 此处PersonalCard Id被@MapsId注解，该字段98765会被忽略
         */
        Home home2 = new Home("123456","平舆","98765");
        Home home3 = new Home("123455","平舆","98764");

        entityManager.persist(home2);
        entityManager.persist(home3);
        entityManager.persist(p2);
        entityManager.persist(p3);

        p2.addHome(home2).addHome(home3);
        p3.addHome(home2).addHome(home3);
        entityManager.flush();
//        entityManager.clear();
        entityManager.getTransaction().commit();
    }
}
