package hibernate5.demo.event.identifiers.one;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by hero on 2016/5/17.
 */
@Entity
@Table(name = "card_user")
public class User implements Serializable{
    @EmbeddedId
    private IDCard Id;

    private String name;

    public User() {
    }

    public User(IDCard id, String name) {
        Id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public IDCard getId() {
        return Id;
    }
}
