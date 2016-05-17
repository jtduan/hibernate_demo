package hibernate5.demo.event.CustomPhysicalNamingStrategy;

import hibernate5.demo.event.Event;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "event2")
public class Event2 {
    @Id
    private int Id;
    private String name;

    public Event2(){}
    public Event2(int id, String name) {
        Id = id;
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
