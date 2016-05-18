package hibernate5.demo.event.associations;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * 使用两个一对多的关联来实现多对多的关联
 */
@Entity
public class PersonHome implements Serializable{
    @Id
    @ManyToOne
    private Person person;

    @Id
    @ManyToOne
    private Home home;

    public PersonHome() {
    }

    public PersonHome(Person person, Home home) {
        this.person = person;
        this.home = home;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }
}
