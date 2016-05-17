package hibernate5.demo.event.any;

import javax.persistence.*;

/**
 * Created by hero on 2016/5/17.
 */
@Entity
@Table(name = "company")
@DiscriminatorValue("CPY")
public class Company implements CarOwner{
    @Id
    @GeneratedValue
    private int Id;
    private String name;
    @Override
    public String getOwner() {
        return name;
    }

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
