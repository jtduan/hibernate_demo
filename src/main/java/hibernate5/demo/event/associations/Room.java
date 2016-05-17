package hibernate5.demo.event.associations;

import org.hibernate.annotations.Columns;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {
    @Id
    private int Id;

    private int size;

    @ManyToOne(cascade = CascadeType.ALL)
    /**
     * foreiginKey作用==========待定===========
     */
    @JoinColumn(name = "home_id",foreignKey = @ForeignKey(name = "HOME_ID_FK"))
    private Home home;

    /**
     * mappedBy 值为对应的多端的字段名称
     */
    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL,orphanRemoval=true)
    private List<Desk> desks = new ArrayList<>();

    public Room() {
    }

    public Room(int id, int size, Home home) {
        Id = id;
        this.size = size;
        this.home = home;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public List<Desk> getDesks() {
        return desks;
    }

    public void setDesks(List<Desk> desks) {
        this.desks = desks;
    }
}
