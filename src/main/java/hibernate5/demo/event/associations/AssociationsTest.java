package hibernate5.demo.event.associations;

import hibernate5.demo.event.Factory;
import hibernate5.demo.event.any.AnyTable;
import hibernate5.demo.event.any.Person;
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
    }
}
