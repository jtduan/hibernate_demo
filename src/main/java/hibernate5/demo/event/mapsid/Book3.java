package hibernate5.demo.event.mapsid;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book3 {
    @Id
    @GeneratedValue
    private int Id;

    private String name;

    public Book3() {
    }

    public Book3(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
