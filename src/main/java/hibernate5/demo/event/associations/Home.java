package hibernate5.demo.event.associations;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "asso_home")
public class Home {
    @Id
    private String home_id;

    private String home_city;
    private String home_number;

    @OneToMany(mappedBy = "home",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Room> rooms;


    @OneToMany(mappedBy = "home", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonHome> persons = new ArrayList<>();

    public Home() {
    }

    public Home(String home_id, String home_city, String home_number) {
        this.home_id = home_id;
        this.home_city = home_city;
        this.home_number = home_number;
    }

    public List<PersonHome> getPersons() {
        return persons;
    }

    public void setPersons(List<PersonHome> persons) {
        this.persons = persons;
    }
}
